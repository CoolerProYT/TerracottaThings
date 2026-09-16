<script setup lang="ts">
import { computed } from 'vue'
import { findRecipe, recipeFor } from '../terracotta'
import ItemSlot from './ItemSlot.vue'

/** Pass a recipe id, or `block` to show whichever recipe makes that block. */
const props = defineProps<{ id?: string; block?: string }>()

const recipe = computed(() => (props.block ? recipeFor(props.block) : props.id ? findRecipe(props.id) : undefined))

const STATIONS: Record<string, string> = {
  'minecraft:crafting_shaped': 'Crafting',
  'minecraft:crafting_shapeless': 'Shapeless',
  'minecraft:stonecutting': 'Stonecutter',
  'minecraft:smelting': 'Furnace',
}

/** Nine cells for the crafting grid, left to right, top to bottom. */
const grid = computed<(string | null)[]>(() => {
  const r = recipe.value
  if (!r) return []
  if (r.pattern && r.key) {
    const cells: (string | null)[] = []
    for (let row = 0; row < 3; row++) {
      for (let col = 0; col < 3; col++) {
        const symbol = r.pattern[row]?.[col] ?? ' '
        cells.push(symbol === ' ' ? null : r.key[symbol] ?? null)
      }
    }
    return cells
  }
  if (r.ingredients) {
    return Array.from({ length: 9 }, (_, i) => r.ingredients![i] ?? null)
  }
  return []
})
</script>

<template>
  <div v-if="recipe" class="tt-recipe">
    <ItemSlot v-if="recipe.ingredient" :id="recipe.ingredient" />
    <div v-else class="grid">
      <ItemSlot v-for="(cell, i) in grid" :id="cell" :key="i" />
    </div>
    <span class="arrow">
      <span class="station">{{ STATIONS[recipe.type] ?? recipe.type.split(':').pop() }}</span>
      ➜
    </span>
    <ItemSlot :id="recipe.result.id" :count="recipe.result.count" label />
  </div>
  <p v-else class="tt-muted">Recipe {{ id ?? block }} not found.</p>
</template>

<style scoped>
.tt-recipe {
  display: flex;
  flex-wrap: wrap;
  align-items: center;
  gap: 14px;
  margin: 12px 0;
  padding: 12px 16px;
  border: 1px solid var(--vp-c-divider);
  border-radius: 10px;
  background: var(--vp-c-bg-soft);
}

.grid {
  display: grid;
  grid-template-columns: repeat(3, 36px);
}

.arrow {
  display: flex;
  flex-direction: column;
  align-items: center;
  font-size: 22px;
  line-height: 1;
  color: var(--vp-c-text-2);
}

.station {
  font-size: 11px;
  text-transform: uppercase;
  letter-spacing: 0.04em;
}
</style>
