# Tags

The mod adds its blocks to these vanilla tags, so anything that works with vanilla walls, slabs or buttons also works with them. It adds no tags of its own.

<TagTable />

Walls are not listed in `#minecraft:mineable/pickaxe` themselves: vanilla already includes the whole `#minecraft:walls` tag there, so terracotta walls are mined with a pickaxe too.

::: warning Plain terracotta stairs and slab
`terracottathings:terracotta_stairs` and `terracottathings:terracotta_slab` are missing from the `stairs` and `slabs` tags in the current version. They still work normally in the world, but recipes or mods that look for any stairs or slab by tag skip them. A datapack can add them:

```jsonc
// data/minecraft/tags/block/stairs.json (and the same under tags/item/)
{
  "values": ["terracottathings:terracotta_stairs"]
}
```

Do the same in `slabs.json` for `terracottathings:terracotta_slab`. Leave out `"replace": true`, so your file adds to the tag instead of replacing it.
:::
