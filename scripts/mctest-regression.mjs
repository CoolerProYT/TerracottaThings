// Node 22+. Launch a dev client with MC-Test first, then run this script.
// Creates a dedicated test world; changes only that world.
import assert from 'node:assert/strict';
import { writeFile } from 'node:fs/promises';
const ws = new WebSocket(process.env.MCTEST_URL ?? 'ws://127.0.0.1:25599/');
await new Promise((resolve, reject) => { ws.onopen = resolve; ws.onerror = reject; });
let sequence = 0;
const pending = new Map();
ws.onmessage = ({ data }) => {
    const reply = JSON.parse(data);
    const entry = pending.get(reply.id);
    if (!entry) return;
    pending.delete(reply.id);
    clearTimeout(entry.timer);
    if (reply.error) entry.reject(new Error(JSON.stringify(reply.error)));
    else entry.resolve(reply.result);
};
function call(method, params = {}) {
    return new Promise((resolve, reject) => {
        const id = ++sequence;
        const timer = setTimeout(() => { pending.delete(id); reject(new Error(`Timed out: ${method}`)); }, 60000);
        pending.set(id, { resolve, reject, timer });
        ws.send(JSON.stringify({ id, method, params }));
    });
}
const command = command => call('command', { command, ticks: 2 });
const settle = () => call('waitFor', { condition: 'ticks:3' });
const readBlock = () => call('block', { x: 0, y: 100, z: 0 });
const results = [];
const colors = ['white', 'orange', 'magenta', 'light_blue', 'yellow', 'lime', 'pink', 'gray', 'light_gray', 'cyan', 'purple', 'blue', 'brown', 'green', 'red', 'black'];
try {
    const status = await call('status');
    if (status.state === 'in-world') await call('world.leave');
    await call('world.create', { name: `Terracotta regression ${Date.now()}`, flat: true, gamemode: 'creative', difficulty: 'peaceful', structures: false, timeoutMs: 60000 });
    await command('fill -20 99 -20 20 99 20 stone');
    // Prevent real keyboard input from moving the player during the automated run.
    await command('attribute @s minecraft:movement_speed base set 0');
    await command('tp @s 0.5 100 2.5 180 20');
    const slab = 'terracottathings:white_glazed_terracotta_slab';
    await command(`give @s ${slab} 64`);
    await call('selectItem', { item: slab });
    for (const [yaw, facing, x, z] of [[0, 'north', 0.5, -1.5], [90, 'east', 2.5, 0.5], [180, 'south', 0.5, 2.5], [-90, 'west', -1.5, 0.5]]) {
        await command('setblock 0 100 0 air');
        await command(`tp @s ${x} 100 ${z} ${yaw} 20`);
        await call('useOn', { x: 0, y: 99, z: 0, face: 'up' });
        await settle();
        const state = await readBlock();
        assert.equal(state.id, slab);
        assert.deepEqual(state.properties, { facing, type: 'bottom', waterlogged: 'false' });
        await command('setblock 0 100 0 air');
        await command('give @s minecraft:white_glazed_terracotta 1');
        await call('selectItem', { item: 'minecraft:white_glazed_terracotta' });
        await command(`tp @s ${x} 100 ${z} ${yaw} 20`);
        await call('useOn', { x: 0, y: 99, z: 0, face: 'up' });
        await settle();
        assert.equal((await readBlock()).properties.facing, facing);
        await call('selectItem', { item: slab });
        results.push(`placement ${facing} matches vanilla`);
    }
    await command('setblock 0 100 0 water');
    await command('tp @s 0.5 100 2.5 180 20');
    await call('useOn', { x: 0, y: 99, z: 0, face: 'up' });
    await settle();
    assert.deepEqual((await readBlock()).properties, { facing: 'south', type: 'bottom', waterlogged: 'true' });
    await command('tp @s 2.5 100 0.5 90 20');
    await call('useOn', { x: 0, y: 100, z: 0, face: 'up' });
    await settle();
    assert.deepEqual((await readBlock()).properties, { facing: 'south', type: 'double', waterlogged: 'false' });
    results.push('waterlogging and merging preserve facing and clear water');
    await command('setblock 0 100 0 air');
    await command('setblock 0 101 0 stone');
    await command('tp @s 0.5 100 2.5 180 20');
    await call('useOn', { x: 0, y: 101, z: 0, face: 'down' });
    await settle();
    assert.deepEqual((await readBlock()).properties, { facing: 'south', type: 'top', waterlogged: 'false' });
    results.push('upper slab placement');
    await command('setblock 0 101 0 air');
    for (const color of colors) {
        const item = `terracottathings:${color}_glazed_terracotta_slab`;
        await command('clear @s');
        await command(`give @s ${item} 2`);
        await call('selectItem', { item });
        await command('setblock 0 100 0 air');
        await command('tp @s 2.5 100 0.5 90 20');
        await call('useOn', { x: 0, y: 99, z: 0, face: 'up' });
        await settle();
        const state = await readBlock();
        assert.equal(state.id, item);
        assert.equal(state.properties.facing, 'east');
        results.push(`${color} slab placement`);
    }
    await command('setblock 1 100 0 stonecutter');
    const sources = ['terracotta', ...colors.map(c => `${c}_terracotta`), ...colors.map(c => `${c}_glazed_terracotta`)];
    for (const source of sources) {
        await call('closeScreen');
        await command('clear @s');
        await command(`give @s minecraft:${source} 4`);
        await command('tp @s 1.5 100 2.5 180 20');
        await call('useOn', { x: 1, y: 100, z: 0, face: 'up' });
        await call('waitFor', { condition: 'screen:StonecutterScreen' });
        const screen = await call('snapshot');
        const input = screen.container.slots.find(s => s.item === `minecraft:${source}`);
        assert.ok(input, `Missing input ${source}`);
        await call('clickSlot', { index: input.index, clickType: 'QUICK_MOVE' });
        // Stonecutter recipe buttons start at left+52, top+14, 16 pixels wide.
        const left = Math.floor((screen.guiWidth - 176) / 2);
        const top = Math.floor((screen.guiHeight - 166) / 2);
        for (const [offset, suffix, count] of [[0, 'slab', 2], [16, 'stairs', 1], [32, 'wall', 1]]) {
            await call('click', { x: left + 60 + offset, y: top + 21 });
            await settle();
            const snapshot = await call('snapshot');
            const output = snapshot.container.slots.find(s => s.index === 1);
            assert.equal(output?.item, `terracottathings:${source}_${suffix}`);
            assert.equal(output.count, count);
            results.push(`${source} -> ${count} ${suffix}`);
        }
        // Take one wall and verify server-authoritative ingredient consumption.
        await call('clickSlot', { index: 1 });
        await settle();
        const taken = await call('snapshot');
        assert.equal(taken.container.carried.item, `terracottathings:${source}_wall`);
        assert.equal(taken.container.carried.count, 1);
        assert.equal(taken.container.slots.find(s => s.index === 0).count, 3);
        results.push(`${source} ingredient consumption`);
        console.log(`PASS ${source}: 3 outputs and ingredient consumption`);
    }
    await call('closeScreen');
    await call('screenshot', { name: 'terracotta-regression-complete' });
    await writeFile(process.argv[2] ?? 'build/mctest-regression.json', JSON.stringify({ status, checks: results.length, results }, null, 2));
    console.log(`PASS ${results.length} checks`);
} finally {
    ws.close();
}
