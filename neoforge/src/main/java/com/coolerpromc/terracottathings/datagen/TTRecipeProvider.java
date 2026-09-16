package com.coolerpromc.terracottathings.datagen;

import com.coolerpromc.terracottathings.Constants;
import com.coolerpromc.terracottathings.block.TTBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class TTRecipeProvider extends RecipeProvider {
    protected TTRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    protected void buildRecipes() {
        // Undyed base
        terracottaVariants(TTBlocks.TERRACOTTA_BUTTON.get(), TTBlocks.TERRACOTTA_PRESSURE_PLATE.get(), TTBlocks.TERRACOTTA_STAIRS.get(), TTBlocks.TERRACOTTA_SLAB.get(), TTBlocks.TERRACOTTA_WALL.get(), Blocks.TERRACOTTA);

        for (DyeColor color : DyeColor.values()) {
            Block dyedSource = Blocks.DYED_TERRACOTTA.pick(color);
            terracottaVariants(TTBlocks.DYED_TERRACOTTA_BUTTONS.pick(color).get(), TTBlocks.DYED_TERRACOTTA_PRESSURE_PLATES.pick(color).get(), TTBlocks.DYED_TERRACOTTA_STAIRS.pick(color).get(), TTBlocks.DYED_TERRACOTTA_SLABS.pick(color).get(), TTBlocks.DYED_TERRACOTTA_WALLS.pick(color).get(), dyedSource);

            Block glazedSource = Blocks.GLAZED_TERRACOTTA.pick(color);
            terracottaVariants(TTBlocks.GLAZED_TERRACOTTA_BUTTONS.pick(color).get(), TTBlocks.GLAZED_TERRACOTTA_PRESSURE_PLATES.pick(color).get(), TTBlocks.GLAZED_TERRACOTTA_STAIRS.pick(color).get(), TTBlocks.GLAZED_TERRACOTTA_SLABS.pick(color).get(), TTBlocks.GLAZED_TERRACOTTA_WALLS.pick(color).get(), glazedSource);
        }
    }

    private void terracottaVariants(Block button, Block pressurePlate, Block stairs, Block slab, Block wall, Block source) {
        buttonBuilder(button, Ingredient.of(source)).unlockedBy(getHasName(source), has(source)).save(output);
        pressurePlate(pressurePlate, source);
        stairBuilder(stairs, Ingredient.of(source)).unlockedBy(getHasName(source), has(source)).save(output);
        slab(RecipeCategory.BUILDING_BLOCKS, slab, source);
        wall(RecipeCategory.BUILDING_BLOCKS, wall, source);
    }

    public static class Runner extends RecipeProvider.Runner {
        protected Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
            return new TTRecipeProvider(registries, output);
        }

        @Override
        public String getName() {
            return Constants.MOD_NAME + " Recipes";
        }
    }
}