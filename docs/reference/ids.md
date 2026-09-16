# Block ids

Every block has an item with the same id. Ids follow one pattern:

```
terracottathings:[color_][glazed_]terracotta_<type>
```

- `color` is one of the 16 dye colors: `white`, `orange`, `magenta`, `light_blue`, `yellow`, `lime`, `pink`, `gray`, `light_gray`, `cyan`, `purple`, `blue`, `brown`, `green`, `red`, `black`. Plain terracotta has no color.
- `glazed_` is present for glazed terracotta. Glazed blocks always have a color, because vanilla has no plain glazed terracotta.
- `type` is one of `button`, `pressure_plate`, `stairs`, `slab`, `wall`.

| Example | Block |
| --- | --- |
| `terracottathings:terracotta_wall` | <ItemSlot id="terracottathings:terracotta_wall" label /> |
| `terracottathings:light_blue_terracotta_slab` | <ItemSlot id="terracottathings:light_blue_terracotta_slab" label /> |
| `terracottathings:lime_glazed_terracotta_stairs` | <ItemSlot id="terracottathings:lime_glazed_terracotta_stairs" label /> |

The creative tab is `terracottathings:terracotta_things`.

## Look up an id

Select a block to copy its id.

<BlockGallery />
