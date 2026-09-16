<script setup lang="ts">
import { computed } from 'vue'
import { baseBlocks, FAMILY_NAMES, itemName, type Family } from '../terracotta'
import ItemSlot from './ItemSlot.vue'

/** Picks one of the 33 terracotta blocks the mod builds on; v-model is the vanilla block id. */
const model = defineModel<string>({ required: true })

const groups = computed(() => {
  const byFamily = new Map<Family, string[]>()
  for (const { base, family } of baseBlocks()) {
    // Plain terracotta sits with the dyed colors, as it does in the game.
    const group = family === 'plain' ? 'dyed' : family
    byFamily.set(group, [...(byFamily.get(group) ?? []), base])
  }
  return [...byFamily.entries()].map(([family, bases]) => ({
    label: family === 'glazed' ? FAMILY_NAMES.glazed : 'Terracotta',
    bases,
  }))
})
</script>

<template>
  <div class="tt-picker">
    <div v-for="group in groups" :key="group.label" class="group" role="radiogroup" :aria-label="group.label">
      <span class="group-label">{{ group.label }}</span>
      <div class="swatches">
        <button
          v-for="base in group.bases"
          :key="base"
          type="button"
          role="radio"
          :aria-checked="model === base"
          :class="{ active: model === base }"
          :title="itemName(base)"
          @click="model = base"
        >
          <ItemSlot :id="base" />
        </button>
      </div>
    </div>
    <p class="picked">{{ itemName(model) }}</p>
  </div>
</template>

<style scoped>
.tt-picker {
  margin: 12px 0;
}

.group {
  display: flex;
  flex-wrap: wrap;
  align-items: center;
  gap: 4px 12px;
  margin-bottom: 6px;
}

.group-label {
  width: 130px;
  font-size: 13px;
  color: var(--vp-c-text-2);
}

.swatches {
  display: flex;
  flex-wrap: wrap;
  gap: 2px;
}

button {
  padding: 2px;
  border: 2px solid transparent;
  border-radius: 6px;
  line-height: 0;
  cursor: pointer;
}

button:hover {
  border-color: var(--vp-c-divider);
}

button.active {
  border-color: var(--vp-c-brand-1);
}

button:focus-visible {
  outline: 2px solid var(--vp-c-brand-1);
  outline-offset: 1px;
}

.picked {
  margin: 4px 0 0;
  font-weight: 600;
}
</style>
