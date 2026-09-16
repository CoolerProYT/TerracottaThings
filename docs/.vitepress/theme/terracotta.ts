// @ts-ignore
import raw from '../data/data.json'

export type Shape = 'button' | 'pressure_plate' | 'stairs' | 'slab' | 'wall'
export type Family = 'plain' | 'dyed' | 'glazed'

export interface Block {
  id: string
  name: string
  /** Dye color, or null for plain terracotta. */
  color: string | null
  family: Family
  shape: Shape
  /** The vanilla block it is crafted from and textured with. */
  base: string
}

export interface Recipe {
  id: string
  type: string
  category: string | null
  result: { id: string; count: number }
  pattern?: string[]
  key?: Record<string, string>
  ingredients?: string[]
  ingredient?: string
  cookingTime?: number
  experience?: number
}

export interface Tag {
  registry: 'block' | 'item'
  id: string
  values: string[]
}

export const data = raw as unknown as {
  colors: string[]
  shapes: Shape[]
  families: Family[]
  names: Record<string, string>
  textures: Record<string, string>
  blocks: Block[]
  recipes: Recipe[]
  tags: Tag[]
  doubleDrops: string[]
}

export const SHAPE_NAMES: Record<Shape, string> = {
  button: 'Buttons',
  pressure_plate: 'Pressure plates',
  stairs: 'Stairs',
  slab: 'Slabs',
  wall: 'Walls',
}

export const SHAPE_PAGES: Record<Shape, string> = {
  button: '/guide/buttons',
  pressure_plate: '/guide/pressure-plates',
  stairs: '/guide/stairs',
  slab: '/guide/slabs',
  wall: '/guide/walls',
}

export const FAMILY_NAMES: Record<Family, string> = {
  plain: 'Terracotta',
  dyed: 'Dyed terracotta',
  glazed: 'Glazed terracotta',
}

/** Readable name for a vanilla id, e.g. minecraft:light_blue_terracotta -> Light Blue Terracotta. */
function prettify(id: string): string {
  const path = id.replace(/^#/, '').split(':').pop() ?? id
  return path
    .split(/[_/]/)
    .map((word) => word.charAt(0).toUpperCase() + word.slice(1))
    .join(' ')
}

/** Mod blocks use their in-game name; vanilla ids are turned into readable names. */
export function itemName(id: string): string {
  return data.names[id] ?? prettify(id)
}

export function colorName(color: string | null): string {
  return color ? prettify(color) : 'Plain'
}

/** Hosted renders of vanilla items, one PNG per item id. Mojang's textures are not bundled here. */
const VANILLA_ICONS = 'https://storage.googleapis.com/coolerpromc/textures'

/**
 * Where to load an item's icon from. Mod blocks use the icons rendered by scripts/render-icons.mjs
 * (a site path); vanilla items use the hosted renders.
 */
export function itemIcon(id: string): { src: string; local: boolean } | null {
  if (data.textures[id]) return { src: data.textures[id], local: true }
  // @ts-ignore
  const [namespace, path] = id.includes(':') ? id.split(':') : ['minecraft', id]
  if (namespace !== 'minecraft') return null
  return { src: `${VANILLA_ICONS}/${namespace}/${path}.png`, local: false }
}

export function findRecipe(id: string): Recipe | undefined {
  const full = id.includes(':') ? id : `terracottathings:${id}`
  return data.recipes.find((recipe) => recipe.id === full)
}

/** Recipe that makes the given block, whatever the recipe's own id. */
export function recipeFor(blockId: string): Recipe | undefined {
  return data.recipes.find((recipe) => recipe.result.id === blockId)
}

export function blocksOf(shape?: Shape, family?: Family): Block[] {
  return data.blocks.filter((block) => (!shape || block.shape === shape) && (!family || block.family === family))
}

/** The 33 terracotta blocks the mod builds on: plain, 16 dyed, 16 glazed. */
export function baseBlocks(): { base: string; color: string | null; family: Family }[] {
  const seen = new Map<string, { base: string; color: string | null; family: Family }>()
  for (const block of data.blocks) {
    if (!seen.has(block.base)) seen.set(block.base, { base: block.base, color: block.color, family: block.family })
  }
  return [...seen.values()]
}

/** Vanilla tags a block is listed in. */
export function tagsOf(blockId: string): Tag[] {
  return data.tags.filter((tag) => tag.values.includes(blockId))
}
