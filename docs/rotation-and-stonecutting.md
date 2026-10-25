# Rotation and stonecutting — Minecraft 26.2

Glazed slabs face opposite the placing player, matching vanilla glazed terracotta. Double slabs preserve the first slab's facing and clear waterlogging. The stonecutter accepts plain terracotta and all dyed/glazed colors, yielding one stair, two slabs, or one wall.

MC-Test 26.2.0.1 is a development-only Fabric runtime dependency. With a dev client running, use Node 22+:

```sh
node scripts/mctest-regression.mjs build/mctest-26.2-results.json
```

The script creates a separate test world and checks all four directions against vanilla, upper slabs, waterlogging and merging, all 16 glazed slab colors, all 99 stonecutter outputs, and ingredient consumption for all 33 source blocks. Close clients with MC-Test after testing. Structure rotation/mirroring is implemented but is not exercised by this script.

## Verified results

Fabric 0.19.0: 154 checks passed. Both loader release builds pass against their configured versions. NeoForge in-game MC-Test coverage is unavailable: MC-Test requires 26.2.0.93, whose development source compilation fails in upstream HolderSet code. The release remains built against 26.2.0.1-beta.
