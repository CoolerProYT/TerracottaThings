<script setup lang="ts">
import { computed, ref, watch } from 'vue'
import { withBase } from 'vitepress'
import { itemIcon, itemName } from '../terracotta'

const props = withDefaults(defineProps<{ id?: string | null; count?: number; label?: boolean; link?: string | null }>(), {
  id: null,
  count: 1,
  label: false,
  link: null,
})

const name = computed(() => (props.id ? itemName(props.id) : ''))
const src = computed(() => (props.id ? itemIcon(props.id) : null))

// Falls back to initials when an item has no icon or the hosted icon fails to load.
const failed = ref(false)
watch(src, () => (failed.value = false))
const initials = computed(() =>
  name.value
    .split(' ')
    .filter((word) => /^[A-Z]/.test(word))
    .slice(0, 2)
    .map((word) => word[0])
    .join(''),
)
</script>

<template>
  <component :is="link ? 'a' : 'span'" :href="link ? withBase(link) : undefined" class="tt-item" :class="{ 'with-label': label }">
    <span class="tt-slot" :title="name" :aria-label="name" role="img">
      <img v-if="src && !failed" :src="src" alt="" loading="lazy" @error="failed = true" />
      <span v-else-if="id" class="tt-initials">{{ initials }}</span>
      <span v-if="count > 1" class="tt-count">{{ count }}</span>
    </span>
    <span v-if="label && id" class="tt-label">{{ name }}</span>
  </component>
</template>

<style scoped>
.tt-item {
  display: inline-flex;
  align-items: center;
  gap: 8px;
  vertical-align: middle;
  color: inherit;
  text-decoration: none;
}

a.tt-item:hover .tt-label {
  color: var(--vp-c-brand-1);
}

.tt-slot {
  position: relative;
  display: inline-flex;
  align-items: center;
  justify-content: center;
  width: 36px;
  height: 36px;
  flex: none;
  background: var(--tt-slot-bg);
  border: 2px solid;
  border-color: var(--tt-slot-dark) var(--tt-slot-light) var(--tt-slot-light) var(--tt-slot-dark);
}

.tt-slot img {
  width: 32px;
  height: 32px;
}

.tt-initials {
  font: 600 12px/1 var(--vp-font-family-mono);
  color: #fff;
  text-shadow: 1px 1px 0 #3f3f3f;
}

.tt-count {
  position: absolute;
  right: 1px;
  bottom: -1px;
  font: 700 12px/1 var(--vp-font-family-mono);
  color: #fff;
  text-shadow: 1px 1px 0 #3f3f3f;
}

.tt-label {
  font-weight: 500;
}
</style>
