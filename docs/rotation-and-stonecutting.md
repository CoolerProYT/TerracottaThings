# Rotation and stonecutting checks (Minecraft 26.3)

Glazed terracotta slabs face opposite the placing player, matching vanilla glazed terracotta. The south-facing model preserves the previous texture orientation. Existing saved slabs without facing load with the default south facing. Double slabs preserve the first slab's direction and clear waterlogging.

Stonecutting supports all 33 source blocks: plain terracotta, 16 dyed colors, and 16 glazed colors. Each yields one stair, two slabs, or one wall. Existing crafting recipes remain available.

## Repeatable in-game regression

MC-Test 26.3.0.2 is configured as a development-only runtime dependency on both loaders. It is not bundled or published as a dependency. Start a client using MC-Test's `mc_launch` tool, or the corresponding Gradle task:

```sh
./gradlew :fabric:runClient
# Or: ./gradlew :neoforge:runClient
```

With the client ready, use Node 22+ to run:

```sh
node scripts/mctest-regression.mjs build/mctest-fabric-results.json
# For NeoForge: use build/mctest-neoforge-results.json
```

The script uses MC-Test's local WebSocket API, creates a separate flat creative test world, and checks:

- All four horizontal directions against vanilla glazed terracotta placed from the same player positions.
- Upper slab placement.
- Waterlogged slab placement and merging from another direction, preserving facing and clearing water.
- Placement of all 16 glazed slab colors.
- All 99 stonecutter outputs through the actual stonecutter GUI.
- Taking an output and consuming one input for each of the 33 source blocks.

It writes a JSON report and saves a screenshot in the client's `mctest/screenshots/` directory. Close the client with `mc_close_all` after testing. Vertical slab compatibility is outside this change's scope. Structure rotation/mirroring is implemented but is not exercised by this script.

## Verified results — 25 October 2026

- Fabric 0.19.5 / Minecraft 26.3: **154 checks passed**.
- NeoForge 26.3.0.1-beta / Minecraft 26.3: **154 checks passed**.
- Reports: `build/mctest-fabric-results.json` and `build/mctest-neoforge-results.json`.
- Run logs: `build/mctest-fabric-regression.log` and `build/mctest-neoforge-regression.log`.

Both clients were closed with MC-Test after testing. No TerracottaThings errors were reported in the NeoForge MC-Test error log.
