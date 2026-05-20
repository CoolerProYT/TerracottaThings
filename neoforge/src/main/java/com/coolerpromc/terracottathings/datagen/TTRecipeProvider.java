package com.coolerpromc.terracottathings.datagen;

import com.coolerpromc.terracottathings.Constants;
import com.coolerpromc.terracottathings.block.TTBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class TTRecipeProvider extends RecipeProvider {
    protected TTRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    protected void buildRecipes() {
        buttonBuilder(TTBlocks.TERRACOTTA_BUTTON.get(), Ingredient.of(Blocks.TERRACOTTA)).unlockedBy(getHasName(Blocks.TERRACOTTA), has(Blocks.TERRACOTTA)).save(output);
        pressurePlate(TTBlocks.TERRACOTTA_PRESSURE_PLATE.get(), Blocks.TERRACOTTA);
        stairBuilder(TTBlocks.TERRACOTTA_STAIRS, Ingredient.of(Blocks.TERRACOTTA)).unlockedBy(getHasName(Blocks.TERRACOTTA), has(Blocks.TERRACOTTA)).save(output);
        slab(RecipeCategory.BUILDING_BLOCKS, TTBlocks.TERRACOTTA_SLAB.get(), Blocks.TERRACOTTA);
        wall(RecipeCategory.BUILDING_BLOCKS, TTBlocks.TERRACOTTA_WALL.get(), Blocks.TERRACOTTA);

        buttonBuilder(TTBlocks.WHITE_TERRACOTTA_BUTTON.get(), Ingredient.of(Blocks.WHITE_TERRACOTTA)).unlockedBy(getHasName(Blocks.WHITE_TERRACOTTA), has(Blocks.WHITE_TERRACOTTA)).save(output);
        pressurePlate(TTBlocks.WHITE_TERRACOTTA_PRESSURE_PLATE.get(), Blocks.WHITE_TERRACOTTA);
        stairBuilder(TTBlocks.WHITE_TERRACOTTA_STAIRS, Ingredient.of(Blocks.WHITE_TERRACOTTA)).unlockedBy(getHasName(Blocks.WHITE_TERRACOTTA), has(Blocks.WHITE_TERRACOTTA)).save(output);
        slab(RecipeCategory.BUILDING_BLOCKS, TTBlocks.WHITE_TERRACOTTA_SLAB.get(), Blocks.WHITE_TERRACOTTA);
        wall(RecipeCategory.BUILDING_BLOCKS, TTBlocks.WHITE_TERRACOTTA_WALL.get(), Blocks.WHITE_TERRACOTTA);

        buttonBuilder(TTBlocks.ORANGE_TERRACOTTA_BUTTON.get(), Ingredient.of(Blocks.ORANGE_TERRACOTTA)).unlockedBy(getHasName(Blocks.ORANGE_TERRACOTTA), has(Blocks.ORANGE_TERRACOTTA)).save(output);
        pressurePlate(TTBlocks.ORANGE_TERRACOTTA_PRESSURE_PLATE.get(), Blocks.ORANGE_TERRACOTTA);
        stairBuilder(TTBlocks.ORANGE_TERRACOTTA_STAIRS, Ingredient.of(Blocks.ORANGE_TERRACOTTA)).unlockedBy(getHasName(Blocks.ORANGE_TERRACOTTA), has(Blocks.ORANGE_TERRACOTTA)).save(output);
        slab(RecipeCategory.BUILDING_BLOCKS, TTBlocks.ORANGE_TERRACOTTA_SLAB.get(), Blocks.ORANGE_TERRACOTTA);
        wall(RecipeCategory.BUILDING_BLOCKS, TTBlocks.ORANGE_TERRACOTTA_WALL.get(), Blocks.ORANGE_TERRACOTTA);

        buttonBuilder(TTBlocks.MAGENTA_TERRACOTTA_BUTTON.get(), Ingredient.of(Blocks.MAGENTA_TERRACOTTA)).unlockedBy(getHasName(Blocks.MAGENTA_TERRACOTTA), has(Blocks.MAGENTA_TERRACOTTA)).save(output);
        pressurePlate(TTBlocks.MAGENTA_TERRACOTTA_PRESSURE_PLATE.get(), Blocks.MAGENTA_TERRACOTTA);
        stairBuilder(TTBlocks.MAGENTA_TERRACOTTA_STAIRS, Ingredient.of(Blocks.MAGENTA_TERRACOTTA)).unlockedBy(getHasName(Blocks.MAGENTA_TERRACOTTA), has(Blocks.MAGENTA_TERRACOTTA)).save(output);
        slab(RecipeCategory.BUILDING_BLOCKS, TTBlocks.MAGENTA_TERRACOTTA_SLAB.get(), Blocks.MAGENTA_TERRACOTTA);
        wall(RecipeCategory.BUILDING_BLOCKS, TTBlocks.MAGENTA_TERRACOTTA_WALL.get(), Blocks.MAGENTA_TERRACOTTA);

        buttonBuilder(TTBlocks.LIGHT_BLUE_TERRACOTTA_BUTTON.get(), Ingredient.of(Blocks.LIGHT_BLUE_TERRACOTTA)).unlockedBy(getHasName(Blocks.LIGHT_BLUE_TERRACOTTA), has(Blocks.LIGHT_BLUE_TERRACOTTA)).save(output);
        pressurePlate(TTBlocks.LIGHT_BLUE_TERRACOTTA_PRESSURE_PLATE.get(), Blocks.LIGHT_BLUE_TERRACOTTA);
        stairBuilder(TTBlocks.LIGHT_BLUE_TERRACOTTA_STAIRS, Ingredient.of(Blocks.LIGHT_BLUE_TERRACOTTA)).unlockedBy(getHasName(Blocks.LIGHT_BLUE_TERRACOTTA), has(Blocks.LIGHT_BLUE_TERRACOTTA)).save(output);
        slab(RecipeCategory.BUILDING_BLOCKS, TTBlocks.LIGHT_BLUE_TERRACOTTA_SLAB.get(), Blocks.LIGHT_BLUE_TERRACOTTA);
        wall(RecipeCategory.BUILDING_BLOCKS, TTBlocks.LIGHT_BLUE_TERRACOTTA_WALL.get(), Blocks.LIGHT_BLUE_TERRACOTTA);

        buttonBuilder(TTBlocks.YELLOW_TERRACOTTA_BUTTON.get(), Ingredient.of(Blocks.YELLOW_TERRACOTTA)).unlockedBy(getHasName(Blocks.YELLOW_TERRACOTTA), has(Blocks.YELLOW_TERRACOTTA)).save(output);
        pressurePlate(TTBlocks.YELLOW_TERRACOTTA_PRESSURE_PLATE.get(), Blocks.YELLOW_TERRACOTTA);
        stairBuilder(TTBlocks.YELLOW_TERRACOTTA_STAIRS, Ingredient.of(Blocks.YELLOW_TERRACOTTA)).unlockedBy(getHasName(Blocks.YELLOW_TERRACOTTA), has(Blocks.YELLOW_TERRACOTTA)).save(output);
        slab(RecipeCategory.BUILDING_BLOCKS, TTBlocks.YELLOW_TERRACOTTA_SLAB.get(), Blocks.YELLOW_TERRACOTTA);
        wall(RecipeCategory.BUILDING_BLOCKS, TTBlocks.YELLOW_TERRACOTTA_WALL.get(), Blocks.YELLOW_TERRACOTTA);

        buttonBuilder(TTBlocks.LIME_TERRACOTTA_BUTTON.get(), Ingredient.of(Blocks.LIME_TERRACOTTA)).unlockedBy(getHasName(Blocks.LIME_TERRACOTTA), has(Blocks.LIME_TERRACOTTA)).save(output);
        pressurePlate(TTBlocks.LIME_TERRACOTTA_PRESSURE_PLATE.get(), Blocks.LIME_TERRACOTTA);
        stairBuilder(TTBlocks.LIME_TERRACOTTA_STAIRS, Ingredient.of(Blocks.LIME_TERRACOTTA)).unlockedBy(getHasName(Blocks.LIME_TERRACOTTA), has(Blocks.LIME_TERRACOTTA)).save(output);
        slab(RecipeCategory.BUILDING_BLOCKS, TTBlocks.LIME_TERRACOTTA_SLAB.get(), Blocks.LIME_TERRACOTTA);
        wall(RecipeCategory.BUILDING_BLOCKS, TTBlocks.LIME_TERRACOTTA_WALL.get(), Blocks.LIME_TERRACOTTA);

        buttonBuilder(TTBlocks.PINK_TERRACOTTA_BUTTON.get(), Ingredient.of(Blocks.PINK_TERRACOTTA)).unlockedBy(getHasName(Blocks.PINK_TERRACOTTA), has(Blocks.PINK_TERRACOTTA)).save(output);
        pressurePlate(TTBlocks.PINK_TERRACOTTA_PRESSURE_PLATE.get(), Blocks.PINK_TERRACOTTA);
        stairBuilder(TTBlocks.PINK_TERRACOTTA_STAIRS, Ingredient.of(Blocks.PINK_TERRACOTTA)).unlockedBy(getHasName(Blocks.PINK_TERRACOTTA), has(Blocks.PINK_TERRACOTTA)).save(output);
        slab(RecipeCategory.BUILDING_BLOCKS, TTBlocks.PINK_TERRACOTTA_SLAB.get(), Blocks.PINK_TERRACOTTA);
        wall(RecipeCategory.BUILDING_BLOCKS, TTBlocks.PINK_TERRACOTTA_WALL.get(), Blocks.PINK_TERRACOTTA);

        buttonBuilder(TTBlocks.GRAY_TERRACOTTA_BUTTON.get(), Ingredient.of(Blocks.GRAY_TERRACOTTA)).unlockedBy(getHasName(Blocks.GRAY_TERRACOTTA), has(Blocks.GRAY_TERRACOTTA)).save(output);
        pressurePlate(TTBlocks.GRAY_TERRACOTTA_PRESSURE_PLATE.get(), Blocks.GRAY_TERRACOTTA);
        stairBuilder(TTBlocks.GRAY_TERRACOTTA_STAIRS, Ingredient.of(Blocks.GRAY_TERRACOTTA)).unlockedBy(getHasName(Blocks.GRAY_TERRACOTTA), has(Blocks.GRAY_TERRACOTTA)).save(output);
        slab(RecipeCategory.BUILDING_BLOCKS, TTBlocks.GRAY_TERRACOTTA_SLAB.get(), Blocks.GRAY_TERRACOTTA);
        wall(RecipeCategory.BUILDING_BLOCKS, TTBlocks.GRAY_TERRACOTTA_WALL.get(), Blocks.GRAY_TERRACOTTA);

        buttonBuilder(TTBlocks.LIGHT_GRAY_TERRACOTTA_BUTTON.get(), Ingredient.of(Blocks.LIGHT_GRAY_TERRACOTTA)).unlockedBy(getHasName(Blocks.LIGHT_GRAY_TERRACOTTA), has(Blocks.LIGHT_GRAY_TERRACOTTA)).save(output);
        pressurePlate(TTBlocks.LIGHT_GRAY_TERRACOTTA_PRESSURE_PLATE.get(), Blocks.LIGHT_GRAY_TERRACOTTA);
        stairBuilder(TTBlocks.LIGHT_GRAY_TERRACOTTA_STAIRS, Ingredient.of(Blocks.LIGHT_GRAY_TERRACOTTA)).unlockedBy(getHasName(Blocks.LIGHT_GRAY_TERRACOTTA), has(Blocks.LIGHT_GRAY_TERRACOTTA)).save(output);
        slab(RecipeCategory.BUILDING_BLOCKS, TTBlocks.LIGHT_GRAY_TERRACOTTA_SLAB.get(), Blocks.LIGHT_GRAY_TERRACOTTA);
        wall(RecipeCategory.BUILDING_BLOCKS, TTBlocks.LIGHT_GRAY_TERRACOTTA_WALL.get(), Blocks.LIGHT_GRAY_TERRACOTTA);

        buttonBuilder(TTBlocks.CYAN_TERRACOTTA_BUTTON.get(), Ingredient.of(Blocks.CYAN_TERRACOTTA)).unlockedBy(getHasName(Blocks.CYAN_TERRACOTTA), has(Blocks.CYAN_TERRACOTTA)).save(output);
        pressurePlate(TTBlocks.CYAN_TERRACOTTA_PRESSURE_PLATE.get(), Blocks.CYAN_TERRACOTTA);
        stairBuilder(TTBlocks.CYAN_TERRACOTTA_STAIRS, Ingredient.of(Blocks.CYAN_TERRACOTTA)).unlockedBy(getHasName(Blocks.CYAN_TERRACOTTA), has(Blocks.CYAN_TERRACOTTA)).save(output);
        slab(RecipeCategory.BUILDING_BLOCKS, TTBlocks.CYAN_TERRACOTTA_SLAB.get(), Blocks.CYAN_TERRACOTTA);
        wall(RecipeCategory.BUILDING_BLOCKS, TTBlocks.CYAN_TERRACOTTA_WALL.get(), Blocks.CYAN_TERRACOTTA);

        buttonBuilder(TTBlocks.PURPLE_TERRACOTTA_BUTTON.get(), Ingredient.of(Blocks.PURPLE_TERRACOTTA)).unlockedBy(getHasName(Blocks.PURPLE_TERRACOTTA), has(Blocks.PURPLE_TERRACOTTA)).save(output);
        pressurePlate(TTBlocks.PURPLE_TERRACOTTA_PRESSURE_PLATE.get(), Blocks.PURPLE_TERRACOTTA);
        stairBuilder(TTBlocks.PURPLE_TERRACOTTA_STAIRS, Ingredient.of(Blocks.PURPLE_TERRACOTTA)).unlockedBy(getHasName(Blocks.PURPLE_TERRACOTTA), has(Blocks.PURPLE_TERRACOTTA)).save(output);
        slab(RecipeCategory.BUILDING_BLOCKS, TTBlocks.PURPLE_TERRACOTTA_SLAB.get(), Blocks.PURPLE_TERRACOTTA);
        wall(RecipeCategory.BUILDING_BLOCKS, TTBlocks.PURPLE_TERRACOTTA_WALL.get(), Blocks.PURPLE_TERRACOTTA);

        buttonBuilder(TTBlocks.BLUE_TERRACOTTA_BUTTON.get(), Ingredient.of(Blocks.BLUE_TERRACOTTA)).unlockedBy(getHasName(Blocks.BLUE_TERRACOTTA), has(Blocks.BLUE_TERRACOTTA)).save(output);
        pressurePlate(TTBlocks.BLUE_TERRACOTTA_PRESSURE_PLATE.get(), Blocks.BLUE_TERRACOTTA);
        stairBuilder(TTBlocks.BLUE_TERRACOTTA_STAIRS, Ingredient.of(Blocks.BLUE_TERRACOTTA)).unlockedBy(getHasName(Blocks.BLUE_TERRACOTTA), has(Blocks.BLUE_TERRACOTTA)).save(output);
        slab(RecipeCategory.BUILDING_BLOCKS, TTBlocks.BLUE_TERRACOTTA_SLAB.get(), Blocks.BLUE_TERRACOTTA);
        wall(RecipeCategory.BUILDING_BLOCKS, TTBlocks.BLUE_TERRACOTTA_WALL.get(), Blocks.BLUE_TERRACOTTA);

        buttonBuilder(TTBlocks.BROWN_TERRACOTTA_BUTTON.get(), Ingredient.of(Blocks.BROWN_TERRACOTTA)).unlockedBy(getHasName(Blocks.BROWN_TERRACOTTA), has(Blocks.BROWN_TERRACOTTA)).save(output);
        pressurePlate(TTBlocks.BROWN_TERRACOTTA_PRESSURE_PLATE.get(), Blocks.BROWN_TERRACOTTA);
        stairBuilder(TTBlocks.BROWN_TERRACOTTA_STAIRS, Ingredient.of(Blocks.BROWN_TERRACOTTA)).unlockedBy(getHasName(Blocks.BROWN_TERRACOTTA), has(Blocks.BROWN_TERRACOTTA)).save(output);
        slab(RecipeCategory.BUILDING_BLOCKS, TTBlocks.BROWN_TERRACOTTA_SLAB.get(), Blocks.BROWN_TERRACOTTA);
        wall(RecipeCategory.BUILDING_BLOCKS, TTBlocks.BROWN_TERRACOTTA_WALL.get(), Blocks.BROWN_TERRACOTTA);

        buttonBuilder(TTBlocks.GREEN_TERRACOTTA_BUTTON.get(), Ingredient.of(Blocks.GREEN_TERRACOTTA)).unlockedBy(getHasName(Blocks.GREEN_TERRACOTTA), has(Blocks.GREEN_TERRACOTTA)).save(output);
        pressurePlate(TTBlocks.GREEN_TERRACOTTA_PRESSURE_PLATE.get(), Blocks.GREEN_TERRACOTTA);
        stairBuilder(TTBlocks.GREEN_TERRACOTTA_STAIRS, Ingredient.of(Blocks.GREEN_TERRACOTTA)).unlockedBy(getHasName(Blocks.GREEN_TERRACOTTA), has(Blocks.GREEN_TERRACOTTA)).save(output);
        slab(RecipeCategory.BUILDING_BLOCKS, TTBlocks.GREEN_TERRACOTTA_SLAB.get(), Blocks.GREEN_TERRACOTTA);
        wall(RecipeCategory.BUILDING_BLOCKS, TTBlocks.GREEN_TERRACOTTA_WALL.get(), Blocks.GREEN_TERRACOTTA);

        buttonBuilder(TTBlocks.RED_TERRACOTTA_BUTTON.get(), Ingredient.of(Blocks.RED_TERRACOTTA)).unlockedBy(getHasName(Blocks.RED_TERRACOTTA), has(Blocks.RED_TERRACOTTA)).save(output);
        pressurePlate(TTBlocks.RED_TERRACOTTA_PRESSURE_PLATE.get(), Blocks.RED_TERRACOTTA);
        stairBuilder(TTBlocks.RED_TERRACOTTA_STAIRS, Ingredient.of(Blocks.RED_TERRACOTTA)).unlockedBy(getHasName(Blocks.RED_TERRACOTTA), has(Blocks.RED_TERRACOTTA)).save(output);
        slab(RecipeCategory.BUILDING_BLOCKS, TTBlocks.RED_TERRACOTTA_SLAB.get(), Blocks.RED_TERRACOTTA);
        wall(RecipeCategory.BUILDING_BLOCKS, TTBlocks.RED_TERRACOTTA_WALL.get(), Blocks.RED_TERRACOTTA);

        buttonBuilder(TTBlocks.BLACK_TERRACOTTA_BUTTON.get(), Ingredient.of(Blocks.BLACK_TERRACOTTA)).unlockedBy(getHasName(Blocks.BLACK_TERRACOTTA), has(Blocks.BLACK_TERRACOTTA)).save(output);
        pressurePlate(TTBlocks.BLACK_TERRACOTTA_PRESSURE_PLATE.get(), Blocks.BLACK_TERRACOTTA);
        stairBuilder(TTBlocks.BLACK_TERRACOTTA_STAIRS, Ingredient.of(Blocks.BLACK_TERRACOTTA)).unlockedBy(getHasName(Blocks.BLACK_TERRACOTTA), has(Blocks.BLACK_TERRACOTTA)).save(output);
        slab(RecipeCategory.BUILDING_BLOCKS, TTBlocks.BLACK_TERRACOTTA_SLAB.get(), Blocks.BLACK_TERRACOTTA);
        wall(RecipeCategory.BUILDING_BLOCKS, TTBlocks.BLACK_TERRACOTTA_WALL.get(), Blocks.BLACK_TERRACOTTA);

        buttonBuilder(TTBlocks.WHITE_GLAZED_TERRACOTTA_BUTTON.get(), Ingredient.of(Blocks.WHITE_GLAZED_TERRACOTTA)).unlockedBy(getHasName(Blocks.WHITE_GLAZED_TERRACOTTA), has(Blocks.WHITE_GLAZED_TERRACOTTA)).save(output);
        pressurePlate(TTBlocks.WHITE_GLAZED_TERRACOTTA_PRESSURE_PLATE.get(), Blocks.WHITE_GLAZED_TERRACOTTA);
        stairBuilder(TTBlocks.WHITE_GLAZED_TERRACOTTA_STAIRS, Ingredient.of(Blocks.WHITE_GLAZED_TERRACOTTA)).unlockedBy(getHasName(Blocks.WHITE_GLAZED_TERRACOTTA), has(Blocks.WHITE_GLAZED_TERRACOTTA)).save(output);
        slab(RecipeCategory.BUILDING_BLOCKS, TTBlocks.WHITE_GLAZED_TERRACOTTA_SLAB.get(), Blocks.WHITE_GLAZED_TERRACOTTA);
        wall(RecipeCategory.BUILDING_BLOCKS, TTBlocks.WHITE_GLAZED_TERRACOTTA_WALL.get(), Blocks.WHITE_GLAZED_TERRACOTTA);

        buttonBuilder(TTBlocks.ORANGE_GLAZED_TERRACOTTA_BUTTON.get(), Ingredient.of(Blocks.ORANGE_GLAZED_TERRACOTTA)).unlockedBy(getHasName(Blocks.ORANGE_GLAZED_TERRACOTTA), has(Blocks.ORANGE_GLAZED_TERRACOTTA)).save(output);
        pressurePlate(TTBlocks.ORANGE_GLAZED_TERRACOTTA_PRESSURE_PLATE.get(), Blocks.ORANGE_GLAZED_TERRACOTTA);
        stairBuilder(TTBlocks.ORANGE_GLAZED_TERRACOTTA_STAIRS, Ingredient.of(Blocks.ORANGE_GLAZED_TERRACOTTA)).unlockedBy(getHasName(Blocks.ORANGE_GLAZED_TERRACOTTA), has(Blocks.ORANGE_GLAZED_TERRACOTTA)).save(output);
        slab(RecipeCategory.BUILDING_BLOCKS, TTBlocks.ORANGE_GLAZED_TERRACOTTA_SLAB.get(), Blocks.ORANGE_GLAZED_TERRACOTTA);
        wall(RecipeCategory.BUILDING_BLOCKS, TTBlocks.ORANGE_GLAZED_TERRACOTTA_WALL.get(), Blocks.ORANGE_GLAZED_TERRACOTTA);

        buttonBuilder(TTBlocks.MAGENTA_GLAZED_TERRACOTTA_BUTTON.get(), Ingredient.of(Blocks.MAGENTA_GLAZED_TERRACOTTA)).unlockedBy(getHasName(Blocks.MAGENTA_GLAZED_TERRACOTTA), has(Blocks.MAGENTA_GLAZED_TERRACOTTA)).save(output);
        pressurePlate(TTBlocks.MAGENTA_GLAZED_TERRACOTTA_PRESSURE_PLATE.get(), Blocks.MAGENTA_GLAZED_TERRACOTTA);
        stairBuilder(TTBlocks.MAGENTA_GLAZED_TERRACOTTA_STAIRS, Ingredient.of(Blocks.MAGENTA_GLAZED_TERRACOTTA)).unlockedBy(getHasName(Blocks.MAGENTA_GLAZED_TERRACOTTA), has(Blocks.MAGENTA_GLAZED_TERRACOTTA)).save(output);
        slab(RecipeCategory.BUILDING_BLOCKS, TTBlocks.MAGENTA_GLAZED_TERRACOTTA_SLAB.get(), Blocks.MAGENTA_GLAZED_TERRACOTTA);
        wall(RecipeCategory.BUILDING_BLOCKS, TTBlocks.MAGENTA_GLAZED_TERRACOTTA_WALL.get(), Blocks.MAGENTA_GLAZED_TERRACOTTA);

        buttonBuilder(TTBlocks.LIGHT_BLUE_GLAZED_TERRACOTTA_BUTTON.get(), Ingredient.of(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA)).unlockedBy(getHasName(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA), has(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA)).save(output);
        pressurePlate(TTBlocks.LIGHT_BLUE_GLAZED_TERRACOTTA_PRESSURE_PLATE.get(), Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA);
        stairBuilder(TTBlocks.LIGHT_BLUE_GLAZED_TERRACOTTA_STAIRS, Ingredient.of(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA)).unlockedBy(getHasName(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA), has(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA)).save(output);
        slab(RecipeCategory.BUILDING_BLOCKS, TTBlocks.LIGHT_BLUE_GLAZED_TERRACOTTA_SLAB.get(), Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA);
        wall(RecipeCategory.BUILDING_BLOCKS, TTBlocks.LIGHT_BLUE_GLAZED_TERRACOTTA_WALL.get(), Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA);

        buttonBuilder(TTBlocks.YELLOW_GLAZED_TERRACOTTA_BUTTON.get(), Ingredient.of(Blocks.YELLOW_GLAZED_TERRACOTTA)).unlockedBy(getHasName(Blocks.YELLOW_GLAZED_TERRACOTTA), has(Blocks.YELLOW_GLAZED_TERRACOTTA)).save(output);
        pressurePlate(TTBlocks.YELLOW_GLAZED_TERRACOTTA_PRESSURE_PLATE.get(), Blocks.YELLOW_GLAZED_TERRACOTTA);
        stairBuilder(TTBlocks.YELLOW_GLAZED_TERRACOTTA_STAIRS, Ingredient.of(Blocks.YELLOW_GLAZED_TERRACOTTA)).unlockedBy(getHasName(Blocks.YELLOW_GLAZED_TERRACOTTA), has(Blocks.YELLOW_GLAZED_TERRACOTTA)).save(output);
        slab(RecipeCategory.BUILDING_BLOCKS, TTBlocks.YELLOW_GLAZED_TERRACOTTA_SLAB.get(), Blocks.YELLOW_GLAZED_TERRACOTTA);
        wall(RecipeCategory.BUILDING_BLOCKS, TTBlocks.YELLOW_GLAZED_TERRACOTTA_WALL.get(), Blocks.YELLOW_GLAZED_TERRACOTTA);

        buttonBuilder(TTBlocks.LIME_GLAZED_TERRACOTTA_BUTTON.get(), Ingredient.of(Blocks.LIME_GLAZED_TERRACOTTA)).unlockedBy(getHasName(Blocks.LIME_GLAZED_TERRACOTTA), has(Blocks.LIME_GLAZED_TERRACOTTA)).save(output);
        pressurePlate(TTBlocks.LIME_GLAZED_TERRACOTTA_PRESSURE_PLATE.get(), Blocks.LIME_GLAZED_TERRACOTTA);
        stairBuilder(TTBlocks.LIME_GLAZED_TERRACOTTA_STAIRS, Ingredient.of(Blocks.LIME_GLAZED_TERRACOTTA)).unlockedBy(getHasName(Blocks.LIME_GLAZED_TERRACOTTA), has(Blocks.LIME_GLAZED_TERRACOTTA)).save(output);
        slab(RecipeCategory.BUILDING_BLOCKS, TTBlocks.LIME_GLAZED_TERRACOTTA_SLAB.get(), Blocks.LIME_GLAZED_TERRACOTTA);
        wall(RecipeCategory.BUILDING_BLOCKS, TTBlocks.LIME_GLAZED_TERRACOTTA_WALL.get(), Blocks.LIME_GLAZED_TERRACOTTA);

        buttonBuilder(TTBlocks.PINK_GLAZED_TERRACOTTA_BUTTON.get(), Ingredient.of(Blocks.PINK_GLAZED_TERRACOTTA)).unlockedBy(getHasName(Blocks.PINK_GLAZED_TERRACOTTA), has(Blocks.PINK_GLAZED_TERRACOTTA)).save(output);
        pressurePlate(TTBlocks.PINK_GLAZED_TERRACOTTA_PRESSURE_PLATE.get(), Blocks.PINK_GLAZED_TERRACOTTA);
        stairBuilder(TTBlocks.PINK_GLAZED_TERRACOTTA_STAIRS, Ingredient.of(Blocks.PINK_GLAZED_TERRACOTTA)).unlockedBy(getHasName(Blocks.PINK_GLAZED_TERRACOTTA), has(Blocks.PINK_GLAZED_TERRACOTTA)).save(output);
        slab(RecipeCategory.BUILDING_BLOCKS, TTBlocks.PINK_GLAZED_TERRACOTTA_SLAB.get(), Blocks.PINK_GLAZED_TERRACOTTA);
        wall(RecipeCategory.BUILDING_BLOCKS, TTBlocks.PINK_GLAZED_TERRACOTTA_WALL.get(), Blocks.PINK_GLAZED_TERRACOTTA);

        buttonBuilder(TTBlocks.GRAY_GLAZED_TERRACOTTA_BUTTON.get(), Ingredient.of(Blocks.GRAY_GLAZED_TERRACOTTA)).unlockedBy(getHasName(Blocks.GRAY_GLAZED_TERRACOTTA), has(Blocks.GRAY_GLAZED_TERRACOTTA)).save(output);
        pressurePlate(TTBlocks.GRAY_GLAZED_TERRACOTTA_PRESSURE_PLATE.get(), Blocks.GRAY_GLAZED_TERRACOTTA);
        stairBuilder(TTBlocks.GRAY_GLAZED_TERRACOTTA_STAIRS, Ingredient.of(Blocks.GRAY_GLAZED_TERRACOTTA)).unlockedBy(getHasName(Blocks.GRAY_GLAZED_TERRACOTTA), has(Blocks.GRAY_GLAZED_TERRACOTTA)).save(output);
        slab(RecipeCategory.BUILDING_BLOCKS, TTBlocks.GRAY_GLAZED_TERRACOTTA_SLAB.get(), Blocks.GRAY_GLAZED_TERRACOTTA);
        wall(RecipeCategory.BUILDING_BLOCKS, TTBlocks.GRAY_GLAZED_TERRACOTTA_WALL.get(), Blocks.GRAY_GLAZED_TERRACOTTA);

        buttonBuilder(TTBlocks.LIGHT_GRAY_GLAZED_TERRACOTTA_BUTTON.get(), Ingredient.of(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA)).unlockedBy(getHasName(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA), has(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA)).save(output);
        pressurePlate(TTBlocks.LIGHT_GRAY_GLAZED_TERRACOTTA_PRESSURE_PLATE.get(), Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA);
        stairBuilder(TTBlocks.LIGHT_GRAY_GLAZED_TERRACOTTA_STAIRS, Ingredient.of(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA)).unlockedBy(getHasName(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA), has(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA)).save(output);
        slab(RecipeCategory.BUILDING_BLOCKS, TTBlocks.LIGHT_GRAY_GLAZED_TERRACOTTA_SLAB.get(), Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA);
        wall(RecipeCategory.BUILDING_BLOCKS, TTBlocks.LIGHT_GRAY_GLAZED_TERRACOTTA_WALL.get(), Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA);

        buttonBuilder(TTBlocks.CYAN_GLAZED_TERRACOTTA_BUTTON.get(), Ingredient.of(Blocks.CYAN_GLAZED_TERRACOTTA)).unlockedBy(getHasName(Blocks.CYAN_GLAZED_TERRACOTTA), has(Blocks.CYAN_GLAZED_TERRACOTTA)).save(output);
        pressurePlate(TTBlocks.CYAN_GLAZED_TERRACOTTA_PRESSURE_PLATE.get(), Blocks.CYAN_GLAZED_TERRACOTTA);
        stairBuilder(TTBlocks.CYAN_GLAZED_TERRACOTTA_STAIRS, Ingredient.of(Blocks.CYAN_GLAZED_TERRACOTTA)).unlockedBy(getHasName(Blocks.CYAN_GLAZED_TERRACOTTA), has(Blocks.CYAN_GLAZED_TERRACOTTA)).save(output);
        slab(RecipeCategory.BUILDING_BLOCKS, TTBlocks.CYAN_GLAZED_TERRACOTTA_SLAB.get(), Blocks.CYAN_GLAZED_TERRACOTTA);
        wall(RecipeCategory.BUILDING_BLOCKS, TTBlocks.CYAN_GLAZED_TERRACOTTA_WALL.get(), Blocks.CYAN_GLAZED_TERRACOTTA);

        buttonBuilder(TTBlocks.PURPLE_GLAZED_TERRACOTTA_BUTTON.get(), Ingredient.of(Blocks.PURPLE_GLAZED_TERRACOTTA)).unlockedBy(getHasName(Blocks.PURPLE_GLAZED_TERRACOTTA), has(Blocks.PURPLE_GLAZED_TERRACOTTA)).save(output);
        pressurePlate(TTBlocks.PURPLE_GLAZED_TERRACOTTA_PRESSURE_PLATE.get(), Blocks.PURPLE_GLAZED_TERRACOTTA);
        stairBuilder(TTBlocks.PURPLE_GLAZED_TERRACOTTA_STAIRS, Ingredient.of(Blocks.PURPLE_GLAZED_TERRACOTTA)).unlockedBy(getHasName(Blocks.PURPLE_GLAZED_TERRACOTTA), has(Blocks.PURPLE_GLAZED_TERRACOTTA)).save(output);
        slab(RecipeCategory.BUILDING_BLOCKS, TTBlocks.PURPLE_GLAZED_TERRACOTTA_SLAB.get(), Blocks.PURPLE_GLAZED_TERRACOTTA);
        wall(RecipeCategory.BUILDING_BLOCKS, TTBlocks.PURPLE_GLAZED_TERRACOTTA_WALL.get(), Blocks.PURPLE_GLAZED_TERRACOTTA);

        buttonBuilder(TTBlocks.BLUE_GLAZED_TERRACOTTA_BUTTON.get(), Ingredient.of(Blocks.BLUE_GLAZED_TERRACOTTA)).unlockedBy(getHasName(Blocks.BLUE_GLAZED_TERRACOTTA), has(Blocks.BLUE_GLAZED_TERRACOTTA)).save(output);
        pressurePlate(TTBlocks.BLUE_GLAZED_TERRACOTTA_PRESSURE_PLATE.get(), Blocks.BLUE_GLAZED_TERRACOTTA);
        stairBuilder(TTBlocks.BLUE_GLAZED_TERRACOTTA_STAIRS, Ingredient.of(Blocks.BLUE_GLAZED_TERRACOTTA)).unlockedBy(getHasName(Blocks.BLUE_GLAZED_TERRACOTTA), has(Blocks.BLUE_GLAZED_TERRACOTTA)).save(output);
        slab(RecipeCategory.BUILDING_BLOCKS, TTBlocks.BLUE_GLAZED_TERRACOTTA_SLAB.get(), Blocks.BLUE_GLAZED_TERRACOTTA);
        wall(RecipeCategory.BUILDING_BLOCKS, TTBlocks.BLUE_GLAZED_TERRACOTTA_WALL.get(), Blocks.BLUE_GLAZED_TERRACOTTA);

        buttonBuilder(TTBlocks.BROWN_GLAZED_TERRACOTTA_BUTTON.get(), Ingredient.of(Blocks.BROWN_GLAZED_TERRACOTTA)).unlockedBy(getHasName(Blocks.BROWN_GLAZED_TERRACOTTA), has(Blocks.BROWN_GLAZED_TERRACOTTA)).save(output);
        pressurePlate(TTBlocks.BROWN_GLAZED_TERRACOTTA_PRESSURE_PLATE.get(), Blocks.BROWN_GLAZED_TERRACOTTA);
        stairBuilder(TTBlocks.BROWN_GLAZED_TERRACOTTA_STAIRS, Ingredient.of(Blocks.BROWN_GLAZED_TERRACOTTA)).unlockedBy(getHasName(Blocks.BROWN_GLAZED_TERRACOTTA), has(Blocks.BROWN_GLAZED_TERRACOTTA)).save(output);
        slab(RecipeCategory.BUILDING_BLOCKS, TTBlocks.BROWN_GLAZED_TERRACOTTA_SLAB.get(), Blocks.BROWN_GLAZED_TERRACOTTA);
        wall(RecipeCategory.BUILDING_BLOCKS, TTBlocks.BROWN_GLAZED_TERRACOTTA_WALL.get(), Blocks.BROWN_GLAZED_TERRACOTTA);

        buttonBuilder(TTBlocks.GREEN_GLAZED_TERRACOTTA_BUTTON.get(), Ingredient.of(Blocks.GREEN_GLAZED_TERRACOTTA)).unlockedBy(getHasName(Blocks.GREEN_GLAZED_TERRACOTTA), has(Blocks.GREEN_GLAZED_TERRACOTTA)).save(output);
        pressurePlate(TTBlocks.GREEN_GLAZED_TERRACOTTA_PRESSURE_PLATE.get(), Blocks.GREEN_GLAZED_TERRACOTTA);
        stairBuilder(TTBlocks.GREEN_GLAZED_TERRACOTTA_STAIRS, Ingredient.of(Blocks.GREEN_GLAZED_TERRACOTTA)).unlockedBy(getHasName(Blocks.GREEN_GLAZED_TERRACOTTA), has(Blocks.GREEN_GLAZED_TERRACOTTA)).save(output);
        slab(RecipeCategory.BUILDING_BLOCKS, TTBlocks.GREEN_GLAZED_TERRACOTTA_SLAB.get(), Blocks.GREEN_GLAZED_TERRACOTTA);
        wall(RecipeCategory.BUILDING_BLOCKS, TTBlocks.GREEN_GLAZED_TERRACOTTA_WALL.get(), Blocks.GREEN_GLAZED_TERRACOTTA);

        buttonBuilder(TTBlocks.RED_GLAZED_TERRACOTTA_BUTTON.get(), Ingredient.of(Blocks.RED_GLAZED_TERRACOTTA)).unlockedBy(getHasName(Blocks.RED_GLAZED_TERRACOTTA), has(Blocks.RED_GLAZED_TERRACOTTA)).save(output);
        pressurePlate(TTBlocks.RED_GLAZED_TERRACOTTA_PRESSURE_PLATE.get(), Blocks.RED_GLAZED_TERRACOTTA);
        stairBuilder(TTBlocks.RED_GLAZED_TERRACOTTA_STAIRS, Ingredient.of(Blocks.RED_GLAZED_TERRACOTTA)).unlockedBy(getHasName(Blocks.RED_GLAZED_TERRACOTTA), has(Blocks.RED_GLAZED_TERRACOTTA)).save(output);
        slab(RecipeCategory.BUILDING_BLOCKS, TTBlocks.RED_GLAZED_TERRACOTTA_SLAB.get(), Blocks.RED_GLAZED_TERRACOTTA);
        wall(RecipeCategory.BUILDING_BLOCKS, TTBlocks.RED_GLAZED_TERRACOTTA_WALL.get(), Blocks.RED_GLAZED_TERRACOTTA);

        buttonBuilder(TTBlocks.BLACK_GLAZED_TERRACOTTA_BUTTON.get(), Ingredient.of(Blocks.BLACK_GLAZED_TERRACOTTA)).unlockedBy(getHasName(Blocks.BLACK_GLAZED_TERRACOTTA), has(Blocks.BLACK_GLAZED_TERRACOTTA)).save(output);
        pressurePlate(TTBlocks.BLACK_GLAZED_TERRACOTTA_PRESSURE_PLATE.get(), Blocks.BLACK_GLAZED_TERRACOTTA);
        stairBuilder(TTBlocks.BLACK_GLAZED_TERRACOTTA_STAIRS, Ingredient.of(Blocks.BLACK_GLAZED_TERRACOTTA)).unlockedBy(getHasName(Blocks.BLACK_GLAZED_TERRACOTTA), has(Blocks.BLACK_GLAZED_TERRACOTTA)).save(output);
        slab(RecipeCategory.BUILDING_BLOCKS, TTBlocks.BLACK_GLAZED_TERRACOTTA_SLAB.get(), Blocks.BLACK_GLAZED_TERRACOTTA);
        wall(RecipeCategory.BUILDING_BLOCKS, TTBlocks.BLACK_GLAZED_TERRACOTTA_WALL.get(), Blocks.BLACK_GLAZED_TERRACOTTA);
    }

    public static class Runner extends RecipeProvider.Runner{
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
