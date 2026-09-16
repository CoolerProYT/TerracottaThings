<script setup lang="ts">
import { data, SHAPE_NAMES, type Shape } from '../terracotta'
import ItemSlot from './ItemSlot.vue'

/**
 * Vanilla tags the mod adds blocks to, with which shapes each one covers and any block of that shape left out.
 * Block and item tags with the same id and members share a row.
 */
const rows: { id: string; registries: string[]; values: string[]; members: number; shapes: Shape[]; missing: string[] }[] = []
for (const tag of data.tags) {
  const same = rows.find((row) => row.id === tag.id && row.values.join() === tag.values.join())
  if (same) {
    same.registries.push(tag.registry)
    continue
  }
  const members = data.blocks.filter((block) => tag.values.includes(block.id))
  const shapes = data.shapes.filter((shape) => members.some((block) => block.shape === shape))
  const missing = data.blocks.filter((block) => shapes.includes(block.shape) && !tag.values.includes(block.id)).map((block) => block.id)
  rows.push({ id: tag.id, registries: [tag.registry], values: tag.values, members: members.length, shapes, missing })
}

const shapeList = (shapes: Shape[]) => shapes.map((shape) => SHAPE_NAMES[shape].toLowerCase()).join(', ')
</script>

<template>
  <table class="tt-tags">
    <thead>
      <tr>
        <th>Tag</th>
        <th>For</th>
        <th>Blocks</th>
        <th>Covers</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="row in rows" :key="row.registries.join() + row.id">
        <td class="tag"><code>#{{ row.id }}</code></td>
        <td>{{ row.registries.join(', ') }}</td>
        <td>{{ row.members }}</td>
        <td>
          All {{ shapeList(row.shapes) }}
          <span v-if="row.missing.length" class="missing">
            except
            <ItemSlot v-for="id in row.missing" :id="id" :key="id" label />
          </span>
        </td>
      </tr>
    </tbody>
  </table>
</template>

<style scoped>
.tag {
  white-space: nowrap;
}

.missing {
  display: inline-flex;
  flex-wrap: wrap;
  align-items: center;
  gap: 6px;
  color: var(--vp-c-text-2);
}
</style>
