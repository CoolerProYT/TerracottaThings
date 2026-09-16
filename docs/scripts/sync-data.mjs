// Pulls wiki data straight from the mod so the docs never drift from the game:
// datagen output (recipes, lang, tags, loot tables) and the block icons rendered into public/icons/.
// Run `./gradlew :neoforge:runData` first when the mod's data changes, and `npm run icons` when its models change.
import { existsSync, mkdirSync, readdirSync, readFileSync, writeFileSync } from 'node:fs'
import { basename, dirname, join } from 'node:path'
import { fileURLToPath } from 'node:url'

const docs = join(dirname(fileURLToPath(import.meta.url)), '..')
const root = join(docs, '..')
const generated = join(root, 'common/src/generated/resources')
const modId = 'terracottathings'
const data = join(generated, `data/${modId}`)

if (!existsSync(generated)) {
  console.error(`No datagen output at ${generated}. Run ./gradlew :neoforge:runData first.`)
  process.exit(1)
}

const readJson = (file) => JSON.parse(readFileSync(file, 'utf8'))
const jsonFiles = (dir) => (existsSync(dir) ? readdirSync(dir).filter((f) => f.endsWith('.json')).sort() : [])

const lang = readJson(join(generated, `assets/${modId}/lang/en_us.json`))

// Vanilla dye order, as used by the creative tab.
const COLORS = ['white', 'orange', 'magenta', 'light_blue', 'yellow', 'lime', 'pink', 'gray', 'light_gray', 'cyan', 'purple', 'blue', 'brown', 'green', 'red', 'black']
const SHAPES = ['button', 'pressure_plate', 'stairs', 'slab', 'wall']

// Every block id splits into [color_][glazed_]terracotta_<shape>.
const blockPattern = new RegExp(`^(?:(${COLORS.join('|')})_)?(glazed_)?terracotta_(${SHAPES.join('|')})$`)

const names = {}
const blocks = []
for (const [key, value] of Object.entries(lang)) {
  const match = key.match(new RegExp(`^(?:item|block)\\.${modId}\\.([a-z0-9_]+)$`))
  if (!match) continue
  const id = `${modId}:${match[1]}`
  names[id] = value
  const parts = match[1].match(blockPattern)
  if (!parts) {
    console.warn(`Unrecognised block ${id}; it is left out of the block lists.`)
    continue
  }
  const [, color = null, glazed, shape] = parts
  const family = glazed ? 'glazed' : color ? 'dyed' : 'plain'
  // The vanilla block the variant is made from and textured with.
  const base = `minecraft:${color ? `${color}_` : ''}${glazed ? 'glazed_' : ''}terracotta`
  blocks.push({ id, name: value, color, family, shape, base })
}
// Creative tab order: by shape, then plain, dyed and glazed.
const FAMILIES = ['plain', 'dyed', 'glazed']
blocks.sort(
  (a, b) =>
    SHAPES.indexOf(a.shape) - SHAPES.indexOf(b.shape) ||
    FAMILIES.indexOf(a.family) - FAMILIES.indexOf(b.family) ||
    COLORS.indexOf(a.color) - COLORS.indexOf(b.color),
)

const textures = {}
const icons = join(docs, 'public/icons')
for (const file of existsSync(icons) ? readdirSync(icons).filter((f) => f.endsWith('.png')) : []) {
  textures[`${modId}:${basename(file, '.png')}`] = `/icons/${file}`
}
const missingIcons = blocks.filter((block) => !textures[block.id])
if (missingIcons.length > 0) console.warn(`${missingIcons.length} blocks have no icon. Run npm run icons.`)

const ingredient = (value) => {
  if (typeof value === 'string') return value
  if (Array.isArray(value)) return ingredient(value[0])
  if (value?.item) return value.item
  if (value?.tag) return `#${value.tag}`
  return '?'
}

const recipes = jsonFiles(join(data, 'recipe')).map((file) => {
  const json = readJson(join(data, 'recipe', file))
  const recipe = {
    id: `${modId}:${basename(file, '.json')}`,
    type: json.type,
    category: json.category ?? null,
    result: { id: json.result?.id, count: json.result?.count ?? 1 },
  }
  if (json.type === 'minecraft:crafting_shaped') {
    recipe.pattern = json.pattern
    recipe.key = Object.fromEntries(Object.entries(json.key).map(([symbol, value]) => [symbol, ingredient(value)]))
  } else if (json.type === 'minecraft:crafting_shapeless') {
    recipe.ingredients = json.ingredients.map(ingredient)
  } else if (json.type === 'minecraft:stonecutting') {
    recipe.ingredient = ingredient(json.ingredient)
  } else {
    recipe.ingredient = ingredient(json.ingredient)
    recipe.cookingTime = json.cookingtime
    recipe.experience = json.experience
  }
  return recipe
})

// Vanilla tags the mod adds its blocks to, e.g. minecraft:walls or minecraft:mineable/pickaxe.
const tags = []
for (const registry of ['block', 'item']) {
  const tagsRoot = join(generated, 'data/minecraft/tags', registry)
  const walk = (dir, prefix) => {
    if (!existsSync(dir)) return
    for (const entry of readdirSync(dir, { withFileTypes: true })) {
      if (entry.isDirectory()) walk(join(dir, entry.name), `${prefix}${entry.name}/`)
      else if (entry.name.endsWith('.json')) {
        const values = readJson(join(dir, entry.name)).values.map((value) => (typeof value === 'string' ? value : value.id))
        tags.push({ registry, id: `minecraft:${prefix}${basename(entry.name, '.json')}`, values })
      }
    }
  }
  walk(tagsRoot, '')
}
tags.sort((a, b) => a.registry.localeCompare(b.registry) || a.id.localeCompare(b.id))

// Blocks whose loot table drops two items from a double slab.
const doubleDrops = jsonFiles(join(data, 'loot_table/blocks'))
  .filter((file) => readFileSync(join(data, 'loot_table/blocks', file), 'utf8').includes('"type": "double"'))
  .map((file) => `${modId}:${basename(file, '.json')}`)

mkdirSync(join(docs, '.vitepress/data'), { recursive: true })
writeFileSync(
  join(docs, '.vitepress/data/data.json'),
  JSON.stringify({ colors: COLORS, shapes: SHAPES, families: FAMILIES, names, textures, blocks, recipes, tags, doubleDrops }, null, 2),
)
console.log(
  `Synced ${blocks.length} blocks, ${recipes.length} recipes, ${tags.length} tags, ${Object.keys(textures).length} icons.`,
)
