<script setup lang="ts">
import { computed, nextTick, ref } from 'vue'
import { withBase } from 'vitepress'
import { colorName, data, FAMILY_NAMES, itemIcon, SHAPE_NAMES, SHAPE_PAGES, tagsOf, type Block, type Family, type Shape } from '../terracotta'
import RecipeCard from './RecipeCard.vue'

/** All mod blocks, filterable by shape, family and name. Set `shape` to show a single shape without its filter. */
const props = defineProps<{ shape?: Shape }>()

const shape = ref<Shape | 'all'>(props.shape ?? 'all')
const family = ref<Family | 'all'>('all')
const query = ref('')
const selected = ref<Block | null>(null)

const visible = computed(() => {
  const words = query.value.toLowerCase().split(/\s+/).filter(Boolean)
  return data.blocks.filter(
    (block) =>
      (shape.value === 'all' || block.shape === shape.value) &&
      (family.value === 'all' || block.family === family.value) &&
      words.every((word) => block.name.toLowerCase().includes(word) || block.id.includes(word)),
  )
})

const icon = (id: string) => itemIcon(id) ?? ''

const detail = ref<HTMLElement | null>(null)

async function toggle(block: Block) {
  selected.value = selected.value?.id === block.id ? null : block
  if (!selected.value) return
  await nextTick()
  detail.value?.scrollIntoView({ behavior: 'smooth', block: 'nearest' })
}

/** Tag ids the block is in, each once, noting whether the block, the item or both are tagged. */
const selectedTags = computed(() => {
  if (!selected.value) return []
  const byId = new Map<string, string[]>()
  for (const tag of tagsOf(selected.value.id)) byId.set(tag.id, [...(byId.get(tag.id) ?? []), tag.registry])
  return [...byId.entries()].map(([id, registries]) => ({ id, registries: registries.join(' + ') }))
})

const copied = ref(false)
async function copy(text: string) {
  try {
    await navigator.clipboard.writeText(text)
    copied.value = true
    setTimeout(() => (copied.value = false), 1200)
  } catch {
    // Clipboard access can be refused; the id stays selectable.
  }
}
</script>

<template>
  <div class="tt-gallery">
    <div class="filters">
      <div v-if="!props.shape" class="chips" role="radiogroup" aria-label="Shape">
        <button type="button" role="radio" :aria-checked="shape === 'all'" :class="{ active: shape === 'all' }" @click="shape = 'all'">All shapes</button>
        <button
          v-for="s in data.shapes"
          :key="s"
          type="button"
          role="radio"
          :aria-checked="shape === s"
          :class="{ active: shape === s }"
          @click="shape = s"
        >
          {{ SHAPE_NAMES[s] }}
        </button>
      </div>
      <div class="chips" role="radiogroup" aria-label="Terracotta type">
        <button type="button" role="radio" :aria-checked="family === 'all'" :class="{ active: family === 'all' }" @click="family = 'all'">All types</button>
        <button
          v-for="f in data.families"
          :key="f"
          type="button"
          role="radio"
          :aria-checked="family === f"
          :class="{ active: family === f }"
          @click="family = f"
        >
          {{ FAMILY_NAMES[f] }}
        </button>
      </div>
      <input v-model="query" type="search" placeholder="Filter by name, e.g. light blue" aria-label="Filter blocks by name" />
    </div>

    <p class="count">{{ visible.length }} of {{ props.shape ? data.blocks.filter((b) => b.shape === props.shape).length : data.blocks.length }} blocks</p>

    <div v-if="selected" ref="detail" class="detail">
      <img :src="icon(selected.id)" alt="" width="96" height="96" />
      <div class="detail-body">
        <h4>{{ selected.name }}</h4>
        <p>
          <code>{{ selected.id }}</code>
          <button type="button" class="copy" @click="copy(selected.id)">{{ copied ? 'Copied' : 'Copy id' }}</button>
        </p>
        <p class="tt-muted">
          {{ FAMILY_NAMES[selected.family] }} · {{ colorName(selected.color) }} ·
          <a :href="withBase(SHAPE_PAGES[selected.shape])">{{ SHAPE_NAMES[selected.shape] }}</a>
        </p>
        <p v-if="selectedTags.length" class="tt-muted">
          Tags:
          <span v-for="tag in selectedTags" :key="tag.id" class="tag"><code>#{{ tag.id }}</code> ({{ tag.registries }})</span>
        </p>
        <RecipeCard :block="selected.id" />
      </div>
      <button type="button" class="close" aria-label="Close details" @click="selected = null">✕</button>
    </div>

    <ul class="grid">
      <li v-for="block in visible" :key="block.id">
        <button type="button" :class="{ active: selected?.id === block.id }" :aria-pressed="selected?.id === block.id" @click="toggle(block)">
          <img :src="icon(block.id)" alt="" width="64" height="64" loading="lazy" />
          <span>{{ block.name }}</span>
        </button>
      </li>
    </ul>
    <p v-if="visible.length === 0" class="tt-muted">No blocks match.</p>
  </div>
</template>

<style scoped>
.filters {
  display: flex;
  flex-direction: column;
  gap: 8px;
  margin: 16px 0 8px;
}

.chips {
  display: flex;
  flex-wrap: wrap;
  gap: 6px;
}

.chips button {
  padding: 3px 12px;
  border: 1px solid var(--vp-c-divider);
  border-radius: 999px;
  font-size: 13px;
  color: var(--vp-c-text-2);
  transition: border-color 0.2s, color 0.2s;
}

.chips button:hover {
  color: var(--vp-c-text-1);
}

.chips button.active {
  border-color: var(--vp-c-brand-1);
  background: var(--vp-c-brand-soft);
  color: var(--vp-c-brand-1);
  font-weight: 600;
}

input {
  max-width: 320px;
  padding: 6px 10px;
  border: 1px solid var(--vp-c-divider);
  border-radius: 8px;
  background: var(--vp-c-bg-soft);
  font-size: 14px;
}

input:focus {
  border-color: var(--vp-c-brand-1);
}

.count {
  margin: 0 0 8px;
  font-size: 13px;
  color: var(--vp-c-text-2);
}

.grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(112px, 1fr));
  gap: 8px;
  padding: 0 !important;
  list-style: none;
}

.grid li {
  margin: 0 !important;
}

.grid button {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 4px;
  width: 100%;
  height: 100%;
  padding: 8px 6px;
  border: 1px solid var(--vp-c-divider);
  border-radius: 10px;
  font-size: 12px;
  line-height: 1.3;
  text-align: center;
  transition: border-color 0.2s, background-color 0.2s;
}

.grid button:hover {
  border-color: var(--vp-c-brand-2);
}

.grid button.active {
  border-color: var(--vp-c-brand-1);
  background: var(--vp-c-brand-soft);
}

button:focus-visible {
  outline: 2px solid var(--vp-c-brand-1);
  outline-offset: 1px;
}

.detail {
  position: relative;
  display: flex;
  flex-wrap: wrap;
  gap: 16px;
  align-items: flex-start;
  margin: 8px 0 16px;
  padding: 16px;
  border: 1px solid var(--vp-c-brand-1);
  border-radius: 12px;
  background: var(--vp-c-bg-soft);
  scroll-margin-top: calc(var(--vp-nav-height) + 16px);
}

.detail-body {
  flex: 1;
  min-width: 220px;
}

.detail h4 {
  margin: 0;
}

.detail p {
  margin: 4px 0;
}

.detail :deep(.tt-recipe) {
  background: var(--vp-c-bg);
}

.tag {
  display: inline-block;
  margin-left: 6px;
  white-space: nowrap;
}

.copy {
  margin-left: 8px;
  padding: 0 8px;
  border: 1px solid var(--vp-c-divider);
  border-radius: 6px;
  font-size: 12px;
}

.close {
  position: absolute;
  top: 8px;
  right: 10px;
  padding: 2px 6px;
  color: var(--vp-c-text-2);
}
</style>
