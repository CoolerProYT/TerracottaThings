# Terracotta Things wiki

VitePress site for the mod. Block names, recipes and tags are read from the mod's datagen output, so regenerate the mod's data before building when it changes.

```bash
./gradlew :neoforge:runData   # from the repository root, when mod data changed
cd docs
npm install
npm run dev                   # syncs data, then serves http://localhost:5173
npm run build                 # syncs data, then builds to .vitepress/dist
```

`npm run sync` (run automatically by `dev` and `build`) writes `.vitepress/data/data.json`, which is git-ignored.

## Block icons

The mod's blocks reuse vanilla textures and have no item textures of their own, so their icons are rendered from the block models and hosted with the vanilla renders, at `https://storage.googleapis.com/coolerpromc/textures/terracottathings/<block>.png` (1024x1024). Vanilla items, such as the terracotta in recipes, load from `.../textures/minecraft/`. The URL is set in `.vitepress/theme/terracotta.ts`.

Re-render and upload them when blocks are added or their models change:

```bash
npm run icons                 # renders to .icons/ (git-ignored); needs the project built once, for the Minecraft jar in the Gradle cache
npm run icons:upload          # copies .icons/*.png to gs://coolerpromc/textures/terracottathings/, needs gcloud signed in
```

To render from another jar, run `node scripts/render-icons.mjs path/to/minecraft-client.jar`.

## Publishing

`.github/workflows/docs.yml` builds the site and deploys it to GitHub Pages on every push to the repository's default branch, or when run by hand from the Actions tab. Before the first run, set **Settings > Pages > Source** to **GitHub Actions**.

The site is built for the root of its custom domain, https://terracottathings.coolerpromc.com, set in **Settings > Pages > Custom domain**. To serve it from `https://<user>.github.io/TerracottaThings/` instead, remove `DOCS_BASE: /` from the build step.
