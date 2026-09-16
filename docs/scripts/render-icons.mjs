// Renders an inventory icon for every mod block into public/icons/.
// The mod's blocks reuse vanilla textures and have no item textures of their own, so each icon is drawn
// from the block's item model: datagen output for the model, the vanilla client jar for parent models and textures.
// The jar is found in the Gradle cache after the project has been built once. Pass a path to use another jar:
//   node scripts/render-icons.mjs [path/to/minecraft.jar]
// The renders are committed, so run this only when blocks or their models change.
import { existsSync, mkdirSync, readdirSync, readFileSync, writeFileSync } from 'node:fs'
import { homedir } from 'node:os'
import { basename, dirname, join } from 'node:path'
import { fileURLToPath } from 'node:url'
import { crc32, deflateSync, inflateRawSync, inflateSync } from 'node:zlib'

const SIZE = Number(process.env.ICON_SIZE ?? 128)
const SAMPLES = 3 // per axis, so edges are smoothed without blurring texels

const docs = join(dirname(fileURLToPath(import.meta.url)), '..')
const root = join(docs, '..')
const generated = join(root, 'common/src/generated/resources')
const modId = 'terracottathings'
const out = join(docs, 'public/icons')

// ---------- vanilla jar ----------

function findJar() {
  if (process.argv[2]) return process.argv[2]
  const version = readFileSync(join(root, 'gradle.properties'), 'utf8').match(/^minecraft_version=(.+)$/m)?.[1].trim()
  const loom = join(homedir(), '.gradle/caches/fabric-loom/minecraftMaven/net/minecraft')
  const candidates = ['minecraft-merged-deobf', 'minecraft-merged', 'minecraft-client-deobf', 'minecraft-client'].map((name) =>
    join(loom, name, version, `${name}-${version}.jar`),
  )
  const jar = candidates.find(existsSync)
  if (!jar) {
    console.error(`No Minecraft ${version} jar in the Gradle cache. Build the project once, or pass the jar path.`)
    process.exit(1)
  }
  return jar
}

/** Reads a zip's central directory; entries are inflated on demand. */
function openZip(file) {
  const buf = readFileSync(file)
  let eocd = buf.length - 22
  while (eocd >= 0 && buf.readUInt32LE(eocd) !== 0x06054b50) eocd--
  const count = buf.readUInt16LE(eocd + 10)
  let pos = buf.readUInt32LE(eocd + 16)
  const entries = new Map()
  for (let i = 0; i < count; i++) {
    const method = buf.readUInt16LE(pos + 10)
    const size = buf.readUInt32LE(pos + 20)
    const nameLength = buf.readUInt16LE(pos + 28)
    const extraLength = buf.readUInt16LE(pos + 30)
    const commentLength = buf.readUInt16LE(pos + 32)
    const offset = buf.readUInt32LE(pos + 42)
    entries.set(buf.toString('utf8', pos + 46, pos + 46 + nameLength), { method, size, offset })
    pos += 46 + nameLength + extraLength + commentLength
  }
  return (name) => {
    const entry = entries.get(name)
    if (!entry) return null
    const start = entry.offset + 30 + buf.readUInt16LE(entry.offset + 26) + buf.readUInt16LE(entry.offset + 28)
    const data = buf.subarray(start, start + entry.size)
    return entry.method === 8 ? inflateRawSync(data) : Buffer.from(data)
  }
}

// ---------- PNG ----------

function decodePng(buf) {
  let pos = 8
  let width, height, depth, colorType, palette, alphas
  const idat = []
  while (pos < buf.length) {
    const length = buf.readUInt32BE(pos)
    const type = buf.toString('ascii', pos + 4, pos + 8)
    const data = buf.subarray(pos + 8, pos + 8 + length)
    if (type === 'IHDR') {
      width = data.readUInt32BE(0)
      height = data.readUInt32BE(4)
      depth = data[8]
      colorType = data[9]
      if (data[12] !== 0) throw new Error('Interlaced PNGs are not supported')
    } else if (type === 'PLTE') palette = data
    else if (type === 'tRNS') alphas = data
    else if (type === 'IDAT') idat.push(data)
    pos += 12 + length
  }
  const channels = { 0: 1, 2: 3, 3: 1, 4: 2, 6: 4 }[colorType]
  const bitsPerPixel = channels * depth
  const bytesPerPixel = Math.max(1, bitsPerPixel >> 3)
  const stride = Math.ceil((width * bitsPerPixel) / 8)
  const raw = inflateSync(Buffer.concat(idat))
  const rows = Buffer.alloc(stride * height)
  for (let y = 0; y < height; y++) {
    const filter = raw[y * (stride + 1)]
    const line = raw.subarray(y * (stride + 1) + 1, (y + 1) * (stride + 1))
    const row = rows.subarray(y * stride, (y + 1) * stride)
    const prev = y > 0 ? rows.subarray((y - 1) * stride, y * stride) : Buffer.alloc(stride)
    for (let x = 0; x < stride; x++) {
      const a = x >= bytesPerPixel ? row[x - bytesPerPixel] : 0
      const b = prev[x]
      const c = x >= bytesPerPixel ? prev[x - bytesPerPixel] : 0
      let predictor = 0
      if (filter === 1) predictor = a
      else if (filter === 2) predictor = b
      else if (filter === 3) predictor = (a + b) >> 1
      else if (filter === 4) {
        const p = a + b - c
        const pa = Math.abs(p - a)
        const pb = Math.abs(p - b)
        const pc = Math.abs(p - c)
        predictor = pa <= pb && pa <= pc ? a : pb <= pc ? b : c
      }
      row[x] = (line[x] + predictor) & 0xff
    }
  }
  const sample = (row, index) => {
    if (depth === 8) return rows[row * stride + index]
    if (depth === 16) return rows[row * stride + index * 2]
    const bit = index * depth
    return (rows[row * stride + (bit >> 3)] >> (8 - depth - (bit % 8))) & ((1 << depth) - 1)
  }
  const scale = depth < 8 && colorType !== 3 ? 255 / ((1 << depth) - 1) : 1
  const pixels = new Uint8ClampedArray(width * height * 4)
  for (let y = 0; y < height; y++) {
    for (let x = 0; x < width; x++) {
      const i = (y * width + x) * 4
      const s = (c) => sample(y, x * channels + c) * scale
      if (colorType === 3) {
        const index = sample(y, x)
        pixels.set([palette[index * 3], palette[index * 3 + 1], palette[index * 3 + 2], alphas?.[index] ?? 255], i)
      } else if (colorType === 0) pixels.set([s(0), s(0), s(0), 255], i)
      else if (colorType === 4) pixels.set([s(0), s(0), s(0), s(1)], i)
      else if (colorType === 2) pixels.set([s(0), s(1), s(2), 255], i)
      else pixels.set([s(0), s(1), s(2), s(3)], i)
    }
  }
  return { width, height, pixels }
}

function encodePng(width, height, pixels) {
  const chunk = (type, data) => {
    const head = Buffer.alloc(8)
    head.writeUInt32BE(data.length)
    head.write(type, 4, 'ascii')
    const crc = Buffer.alloc(4)
    crc.writeUInt32BE(crc32(Buffer.concat([head.subarray(4), data])))
    return Buffer.concat([head, data, crc])
  }
  const header = Buffer.alloc(13)
  header.writeUInt32BE(width, 0)
  header.writeUInt32BE(height, 4)
  header.set([8, 6, 0, 0, 0], 8)
  const raw = Buffer.alloc((width * 4 + 1) * height)
  for (let y = 0; y < height; y++) {
    Buffer.from(pixels.buffer, pixels.byteOffset + y * width * 4, width * 4).copy(raw, y * (width * 4 + 1) + 1)
  }
  return Buffer.concat([
    Buffer.from([0x89, 0x50, 0x4e, 0x47, 0x0d, 0x0a, 0x1a, 0x0a]),
    chunk('IHDR', header),
    chunk('IDAT', deflateSync(raw, { level: 9 })),
    chunk('IEND', Buffer.alloc(0)),
  ])
}

// ---------- models ----------

const readJar = openZip(findJar())

function resource(id, folder, ext) {
  const [namespace, path] = id.includes(':') ? id.split(':') : ['minecraft', id]
  const file = `assets/${namespace}/${folder}/${path}.${ext}`
  if (namespace === modId) {
    const local = join(generated, file)
    return existsSync(local) ? readFileSync(local) : null
  }
  return readJar(file)
}

/** Resolves a model's parent chain into its elements, textures and gui transform. */
function loadModel(id) {
  const chain = []
  for (let current = id; current; ) {
    const json = resource(current, 'models', 'json')
    if (!json) throw new Error(`Missing model ${current}`)
    const model = JSON.parse(json.toString('utf8'))
    chain.push(model)
    current = model.parent
  }
  const textures = Object.assign({}, ...[...chain].reverse().map((model) => model.textures ?? {}))
  const elements = chain.find((model) => model.elements)?.elements ?? []
  const gui = chain.find((model) => model.display?.gui)?.display.gui ?? {}
  const resolve = (ref) => {
    for (let depth = 0; ref?.startsWith('#') && depth < 10; depth++) ref = textures[ref.slice(1)]
    return ref
  }
  return { elements, gui, resolve }
}

const textureCache = new Map()
function texture(id) {
  if (!textureCache.has(id)) {
    const png = resource(id, 'textures', 'png')
    if (!png) throw new Error(`Missing texture ${id}`)
    textureCache.set(id, decodePng(png))
  }
  return textureCache.get(id)
}

// ---------- renderer ----------

const rad = (deg) => (deg * Math.PI) / 180
const rotateX = ([x, y, z], a) => [x, y * Math.cos(a) - z * Math.sin(a), y * Math.sin(a) + z * Math.cos(a)]
const rotateY = ([x, y, z], a) => [x * Math.cos(a) + z * Math.sin(a), y, -x * Math.sin(a) + z * Math.cos(a)]
const rotateZ = ([x, y, z], a) => [x * Math.cos(a) - y * Math.sin(a), x * Math.sin(a) + y * Math.cos(a), z]

// Inventory lighting: the top is lit fully, the side facing left is dimmed less than the one facing right.
const NORMALS = { down: [0, -1, 0], up: [0, 1, 0], north: [0, 0, -1], south: [0, 0, 1], west: [-1, 0, 0], east: [1, 0, 0] }
function shadeFor(normal, rotation) {
  const [x, y] = rotateX(rotateY(rotateZ(normal, rotation[2]), rotation[1]), rotation[0])
  if (y > 0.3) return 1
  if (y < -0.3) return 0.4
  return x < 0 ? 0.72 : 0.48
}

// For each face: default UV from the element bounds, and where a hit point falls along the face's U and V.
const FACES = {
  down: { axis: 1, side: 0, uv: (f, t) => [f[0], 16 - t[2], t[0], 16 - f[2]], at: (p, f, t) => [(p[0] - f[0]) / (t[0] - f[0]), (t[2] - p[2]) / (t[2] - f[2])] },
  up: { axis: 1, side: 1, uv: (f, t) => [f[0], f[2], t[0], t[2]], at: (p, f, t) => [(p[0] - f[0]) / (t[0] - f[0]), (p[2] - f[2]) / (t[2] - f[2])] },
  north: { axis: 2, side: 0, uv: (f, t) => [16 - t[0], 16 - t[1], 16 - f[0], 16 - f[1]], at: (p, f, t) => [(t[0] - p[0]) / (t[0] - f[0]), (t[1] - p[1]) / (t[1] - f[1])] },
  south: { axis: 2, side: 1, uv: (f, t) => [f[0], 16 - t[1], t[0], 16 - f[1]], at: (p, f, t) => [(p[0] - f[0]) / (t[0] - f[0]), (t[1] - p[1]) / (t[1] - f[1])] },
  west: { axis: 0, side: 0, uv: (f, t) => [f[2], 16 - t[1], t[2], 16 - f[1]], at: (p, f, t) => [(p[2] - f[2]) / (t[2] - f[2]), (t[1] - p[1]) / (t[1] - f[1])] },
  east: { axis: 0, side: 1, uv: (f, t) => [16 - t[2], 16 - t[1], 16 - f[2], 16 - f[1]], at: (p, f, t) => [(t[2] - p[2]) / (t[2] - f[2]), (t[1] - p[1]) / (t[1] - f[1])] },
}

function render(modelId) {
  const model = loadModel(modelId)
  const rotation = (model.gui.rotation ?? [0, 0, 0]).map(rad)
  const translation = model.gui.translation ?? [0, 0, 0]
  const scale = model.gui.scale ?? [1, 1, 1]
  for (const element of model.elements) {
    if (element.rotation && element.rotation.angle) console.warn(`${modelId}: element rotation is ignored`)
  }

  // Screen point (in block units, y up) to model space: undo translate, rotate X·Y·Z, scale.
  const toModel = (v) => {
    let p = [v[0] - translation[0] / 16, v[1] - translation[1] / 16, v[2] - translation[2] / 16]
    p = rotateZ(rotateY(rotateX(p, -rotation[0]), -rotation[1]), -rotation[2])
    return [(p[0] / scale[0]) * 16 + 8, (p[1] / scale[1]) * 16 + 8, (p[2] / scale[2]) * 16 + 8]
  }

  const sampleRay = (sx, sy) => {
    const origin = toModel([sx, sy, 4])
    const far = toModel([sx, sy, -4])
    const dir = far.map((c, i) => c - origin[i])
    const hits = []
    for (const element of model.elements) {
      let near = -Infinity
      let farT = Infinity
      let entry = null
      for (let axis = 0; axis < 3; axis++) {
        const lo = element.from[axis]
        const hi = element.to[axis]
        if (Math.abs(dir[axis]) < 1e-12) {
          if (origin[axis] < lo || origin[axis] > hi) {
            near = Infinity
            break
          }
          continue
        }
        let t1 = (lo - origin[axis]) / dir[axis]
        let t2 = (hi - origin[axis]) / dir[axis]
        let side1 = 0
        if (t1 > t2) {
          ;[t1, t2] = [t2, t1]
          side1 = 1
        }
        if (t1 > near) {
          near = t1
          entry = { axis, side: side1 }
        }
        farT = Math.min(farT, t2)
      }
      if (near > farT || !entry) continue
      const name = Object.keys(FACES).find((key) => FACES[key].axis === entry.axis && FACES[key].side === entry.side)
      const face = element.faces?.[name]
      if (!face) continue
      hits.push({ t: near, element, face, name })
    }
    hits.sort((a, b) => a.t - b.t)
    for (const { t, element, face, name } of hits) {
      const point = origin.map((c, i) => c + dir[i] * t)
      const info = FACES[name]
      const [u1, v1, u2, v2] = face.uv ?? info.uv(element.from, element.to)
      let [fu, fv] = info.at(point, element.from, element.to)
      for (let r = 0; r < ((face.rotation ?? 0) / 90) % 4; r++) [fu, fv] = [fv, 1 - fu]
      const tex = texture(model.resolve(face.texture))
      const u = u1 + Math.min(Math.max(fu, 0), 0.9999) * (u2 - u1)
      const v = v1 + Math.min(Math.max(fv, 0), 0.9999) * (v2 - v1)
      const x = Math.min(Math.floor((u / 16) * tex.width), tex.width - 1)
      const y = Math.min(Math.floor((v / 16) * tex.width), tex.width - 1) // square frame of an animated strip
      const i = (y * tex.width + x) * 4
      if (tex.pixels[i + 3] === 0) continue
      const shade = shadeFor(NORMALS[name], rotation)
      return [tex.pixels[i] * shade, tex.pixels[i + 1] * shade, tex.pixels[i + 2] * shade, tex.pixels[i + 3]]
    }
    return null
  }

  const pixels = new Uint8ClampedArray(SIZE * SIZE * 4)
  for (let py = 0; py < SIZE; py++) {
    for (let px = 0; px < SIZE; px++) {
      let r = 0, g = 0, b = 0, a = 0
      for (let j = 0; j < SAMPLES; j++) {
        for (let k = 0; k < SAMPLES; k++) {
          // The 16px inventory slot spans one block unit, centred on the model.
          const sx = (px + (k + 0.5) / SAMPLES) / SIZE - 0.5
          const sy = 0.5 - (py + (j + 0.5) / SAMPLES) / SIZE
          const color = sampleRay(sx, sy)
          if (!color) continue
          const alpha = color[3] / 255
          r += color[0] * alpha
          g += color[1] * alpha
          b += color[2] * alpha
          a += alpha
        }
      }
      const i = (py * SIZE + px) * 4
      if (a > 0) pixels.set([r / a, g / a, b / a, (a / (SAMPLES * SAMPLES)) * 255], i)
    }
  }
  return encodePng(SIZE, SIZE, pixels)
}

// ---------- main ----------

const itemsDir = join(generated, `assets/${modId}/items`)
mkdirSync(out, { recursive: true })
const only = process.env.ICON_ONLY // renders a single item (or a vanilla one, e.g. minecraft:stone_stairs) for checking
const items = only ? [only] : readdirSync(itemsDir).filter((f) => f.endsWith('.json')).map((f) => `${modId}:${basename(f, '.json')}`)
for (const item of items) {
  const json = resource(item, 'items', 'json')
  const definition = JSON.parse(json.toString('utf8'))
  if (definition.model?.type !== 'minecraft:model') throw new Error(`${item}: unsupported item model ${definition.model?.type}`)
  writeFileSync(join(out, `${item.split(':')[1]}.png`), render(definition.model.model))
}
console.log(`Rendered ${items.length} icons to ${out}.`)
