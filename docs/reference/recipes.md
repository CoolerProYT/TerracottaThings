# Changing recipes

Each block has one recipe, named after the block: the recipe for `terracottathings:red_terracotta_wall` is `data/terracottathings/recipe/red_terracotta_wall.json`. A datapack file at the same path replaces it.

## Recipe patterns

All colors of a shape use the same pattern. Only the terracotta changes.

| Shape | Type | Pattern | Makes |
| --- | --- | --- | --- |
| Button | Shapeless | 1 terracotta | 1 |
| Pressure plate | Shaped | 2 terracotta side by side | 1 |
| Stairs | Shaped | 6 terracotta in a staircase | 4 |
| Slab | Shaped | 3 terracotta in a row | 6 |
| Wall | Shaped | 6 terracotta in two rows of three | 6 |

This is the stairs recipe for plain terracotta, as the mod ships it:

```json
{
  "type": "minecraft:crafting_shaped",
  "category": "building",
  "key": {
    "#": "minecraft:terracotta"
  },
  "pattern": [
    "#  ",
    "## ",
    "###"
  ],
  "result": {
    "count": 4,
    "id": "terracottathings:terracotta_stairs"
  }
}
```

## Adding a stonecutter recipe

The mod has no stonecutter recipes. To cut stairs from a single block, add a new file with its own name, for example `data/yourpack/recipe/terracotta_stairs_from_stonecutting.json`:

```json
{
  "type": "minecraft:stonecutting",
  "ingredient": "minecraft:terracotta",
  "result": {
    "id": "terracottathings:terracotta_stairs"
  }
}
```

Stonecutter recipes make one item each unless you set `"count"` in `result`.

## Removing a recipe

Replace the recipe file with one whose only condition can never be true. On NeoForge:

```json
{
  "neoforge:conditions": [{ "type": "neoforge:false" }]
}
```

On Fabric:

```json
{
  "fabric:load_conditions": [{ "condition": "fabric:not", "value": { "condition": "fabric:true" } }]
}
```

Recipe unlocks live in `data/terracottathings/advancement/recipes/`. The mod unlocks a recipe when a player first picks up the terracotta it uses.

## Drops

Each block drops itself, and double slabs drop two slabs. Like vanilla blocks, they can drop nothing when an explosion breaks them. The loot tables are at `data/terracottathings/loot_table/blocks/<block>.json`.
