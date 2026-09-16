# For modpack makers

Terracotta Things has no config file. Everything about its blocks that you would want to change lives in data files, so a datapack or a tool like KubeJS can adjust it.

| What | Where | Page |
| --- | --- | --- |
| Block and item ids | `terracottathings:<color>_<type>` | [Block ids](./ids) |
| Tags | Vanilla tags such as `#minecraft:walls` | [Tags](./tags) |
| Recipes | `data/terracottathings/recipe/` | [Changing recipes](./recipes) |
| Drops | `data/terracottathings/loot_table/blocks/` | [Changing recipes](./recipes#drops) |

Datapack changes apply with `/reload`, or when the world is next opened.
