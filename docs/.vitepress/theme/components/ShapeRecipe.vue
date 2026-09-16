<script setup lang="ts">
import { computed, ref } from 'vue'
import { data, type Shape } from '../terracotta'
import ColorPicker from './ColorPicker.vue'
import RecipeCard from './RecipeCard.vue'

/** The recipe for one block shape, with a picker for which terracotta it is made from. */
const props = defineProps<{ shape: Shape }>()

const base = ref('minecraft:terracotta')
const block = computed(() => data.blocks.find((b) => b.shape === props.shape && b.base === base.value))
</script>

<template>
  <div class="tt-shape-recipe">
    <ColorPicker v-model="base" />
    <RecipeCard v-if="block" :block="block.id" />
  </div>
</template>
