<script setup lang="ts">
import { computed, ref } from 'vue'
import { withBase } from 'vitepress'
import { data, itemIcon, SHAPE_PAGES } from '../terracotta'
import ColorPicker from './ColorPicker.vue'
import RecipeCard from './RecipeCard.vue'

/** Every block made from one terracotta color, with its recipe. */
const base = ref('minecraft:terracotta')
const blocks = computed(() => data.blocks.filter((block) => block.base === base.value))
const icon = (id: string) => itemIcon(id) ?? ''
</script>

<template>
  <div class="tt-explorer">
    <ColorPicker v-model="base" />
    <div class="cards">
      <div v-for="block in blocks" :key="block.id" class="card">
        <img :src="icon(block.id)" alt="" width="72" height="72" />
        <div class="body">
          <a class="shape" :href="withBase(SHAPE_PAGES[block.shape])">{{ block.name }}</a>
          <code class="id">{{ block.id }}</code>
          <RecipeCard :block="block.id" />
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.cards {
  display: grid;
  gap: 12px;
  margin-top: 16px;
}

.card {
  display: flex;
  gap: 16px;
  align-items: center;
  padding: 12px 16px;
  border: 1px solid var(--vp-c-divider);
  border-radius: 12px;
}

.card img {
  flex: none;
}

.body {
  min-width: 0;
}

.shape {
  display: block;
  font-weight: 600;
}

.id {
  font-size: 12px;
  overflow-wrap: anywhere;
}

.body :deep(.tt-recipe) {
  margin-bottom: 0;
  background: transparent;
  border: none;
  padding: 0;
}

@media (max-width: 480px) {
  .card {
    align-items: flex-start;
  }

  .card img {
    width: 48px;
    height: 48px;
  }
}
</style>
