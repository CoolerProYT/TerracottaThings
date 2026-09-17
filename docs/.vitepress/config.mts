import { defineConfig } from 'vitepress'

// GitHub Pages serves a project site from /<repository>/. For a custom domain or a user site, build with DOCS_BASE=/.
const base = process.env.DOCS_BASE ?? '/TerracottaThings/'

// Block icons are hosted with the vanilla renders; see scripts/render-icons.mjs.
const icon = 'https://storage.googleapis.com/coolerpromc/textures/terracottathings/orange_glazed_terracotta_stairs.png'

export default defineConfig({
  title: 'Terracotta Things',
  description: 'Buttons, pressure plates, stairs, slabs and walls for every terracotta and glazed terracotta color. Minecraft 26.3, Fabric and NeoForge.',
  base,
  cleanUrls: true,
  srcExclude: ['README.md', 'scripts/**'],
  head: [['link', { rel: 'icon', type: 'image/png', href: icon }]],
  themeConfig: {
    logo: { src: icon, alt: '' },
    nav: [
      { text: 'Guide', link: '/guide/getting-started' },
      { text: 'All blocks', link: '/guide/blocks' },
      { text: 'Modpacks', link: '/reference/' },
    ],
    sidebar: [
      {
        text: 'Guide',
        items: [
          { text: 'Getting started', link: '/guide/getting-started' },
          { text: 'All blocks', link: '/guide/blocks' },
          { text: 'Blocks by color', link: '/guide/colors' },
        ],
      },
      {
        text: 'Blocks',
        items: [
          { text: 'Buttons', link: '/guide/buttons' },
          { text: 'Pressure plates', link: '/guide/pressure-plates' },
          { text: 'Stairs', link: '/guide/stairs' },
          { text: 'Slabs', link: '/guide/slabs' },
          { text: 'Walls', link: '/guide/walls' },
        ],
      },
      {
        text: 'For modpacks',
        items: [
          { text: 'Overview', link: '/reference/' },
          { text: 'Block ids', link: '/reference/ids' },
          { text: 'Tags', link: '/reference/tags' },
          { text: 'Changing recipes', link: '/reference/recipes' },
        ],
      },
      { text: 'FAQ', link: '/faq' },
    ],
    socialLinks: [{ icon: 'github', link: 'https://github.com/CoolerProYT/TerracottaThings' }],
    search: { provider: 'local' },
    outline: { level: [2, 3] },
    footer: { message: 'Released under the MIT License.' },
  },
})
