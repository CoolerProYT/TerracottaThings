import DefaultTheme from 'vitepress/theme'
import type { Theme } from 'vitepress'
import BlockGallery from './components/BlockGallery.vue'
import ColorExplorer from './components/ColorExplorer.vue'
import ItemSlot from './components/ItemSlot.vue'
import RecipeCard from './components/RecipeCard.vue'
import ShapeRecipe from './components/ShapeRecipe.vue'
import TagTable from './components/TagTable.vue'
import './style.css'

export default {
  extends: DefaultTheme,
  enhanceApp({ app }) {
    app.component('BlockGallery', BlockGallery)
    app.component('ColorExplorer', ColorExplorer)
    app.component('ItemSlot', ItemSlot)
    app.component('RecipeCard', RecipeCard)
    app.component('ShapeRecipe', ShapeRecipe)
    app.component('TagTable', TagTable)
  },
} satisfies Theme
