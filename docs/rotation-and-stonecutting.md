# Rotation and stonecutting — Minecraft 26.1.2

Glazed slabs face opposite the placing player, matching vanilla glazed terracotta. Double slabs preserve the first slab's facing and clear waterlogging. The stonecutter accepts plain terracotta and all dyed/glazed colors, yielding one stair, two slabs, or one wall.

MC-Test 26.1.2.1 is a development-only Fabric runtime dependency. With a Fabric dev client running, use Node 22+:

```sh
node scripts/mctest-regression.mjs build/mctest-26.1-fabric-results.json
```

The script creates a separate test world and checks all four directions against vanilla, upper slabs, waterlogging and merging, all 16 glazed slab colors, all 99 stonecutter outputs, and ingredient consumption for all 33 source blocks. Close clients with MC-Test after testing. Structure rotation/mirroring is implemented but is not exercised by this script.

## Verified results

Fabric 0.18.6 / Minecraft 26.1.2: 154 MC-Test checks passed. Fabric, NeoForge, and Forge builds pass with all 99 stonecutter recipes packaged and MC-Test excluded from release jars/POMs. NeoForge and Forge were build-verified; their in-game MC-Test suites were not run.
