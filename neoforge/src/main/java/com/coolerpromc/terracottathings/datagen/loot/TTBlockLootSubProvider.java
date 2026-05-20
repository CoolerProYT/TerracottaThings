package com.coolerpromc.terracottathings.datagen.loot;

import com.coolerpromc.terracottathings.Constants;
import com.coolerpromc.terracottathings.block.TTBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class TTBlockLootSubProvider extends BlockLootSubProvider {
    public TTBlockLootSubProvider(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    protected void generate() {
        dropSelf(TTBlocks.TERRACOTTA_BUTTON.get());
        dropSelf(TTBlocks.WHITE_TERRACOTTA_BUTTON.get());
        dropSelf(TTBlocks.ORANGE_TERRACOTTA_BUTTON.get());
        dropSelf(TTBlocks.MAGENTA_TERRACOTTA_BUTTON.get());
        dropSelf(TTBlocks.LIGHT_BLUE_TERRACOTTA_BUTTON.get());
        dropSelf(TTBlocks.YELLOW_TERRACOTTA_BUTTON.get());
        dropSelf(TTBlocks.LIME_TERRACOTTA_BUTTON.get());
        dropSelf(TTBlocks.PINK_TERRACOTTA_BUTTON.get());
        dropSelf(TTBlocks.GRAY_TERRACOTTA_BUTTON.get());
        dropSelf(TTBlocks.LIGHT_GRAY_TERRACOTTA_BUTTON.get());
        dropSelf(TTBlocks.CYAN_TERRACOTTA_BUTTON.get());
        dropSelf(TTBlocks.PURPLE_TERRACOTTA_BUTTON.get());
        dropSelf(TTBlocks.BLUE_TERRACOTTA_BUTTON.get());
        dropSelf(TTBlocks.BROWN_TERRACOTTA_BUTTON.get());
        dropSelf(TTBlocks.GREEN_TERRACOTTA_BUTTON.get());
        dropSelf(TTBlocks.RED_TERRACOTTA_BUTTON.get());
        dropSelf(TTBlocks.BLACK_TERRACOTTA_BUTTON.get());
        dropSelf(TTBlocks.WHITE_GLAZED_TERRACOTTA_BUTTON.get());
        dropSelf(TTBlocks.ORANGE_GLAZED_TERRACOTTA_BUTTON.get());
        dropSelf(TTBlocks.MAGENTA_GLAZED_TERRACOTTA_BUTTON.get());
        dropSelf(TTBlocks.LIGHT_BLUE_GLAZED_TERRACOTTA_BUTTON.get());
        dropSelf(TTBlocks.YELLOW_GLAZED_TERRACOTTA_BUTTON.get());
        dropSelf(TTBlocks.LIME_GLAZED_TERRACOTTA_BUTTON.get());
        dropSelf(TTBlocks.PINK_GLAZED_TERRACOTTA_BUTTON.get());
        dropSelf(TTBlocks.GRAY_GLAZED_TERRACOTTA_BUTTON.get());
        dropSelf(TTBlocks.LIGHT_GRAY_GLAZED_TERRACOTTA_BUTTON.get());
        dropSelf(TTBlocks.CYAN_GLAZED_TERRACOTTA_BUTTON.get());
        dropSelf(TTBlocks.PURPLE_GLAZED_TERRACOTTA_BUTTON.get());
        dropSelf(TTBlocks.BLUE_GLAZED_TERRACOTTA_BUTTON.get());
        dropSelf(TTBlocks.BROWN_GLAZED_TERRACOTTA_BUTTON.get());
        dropSelf(TTBlocks.GREEN_GLAZED_TERRACOTTA_BUTTON.get());
        dropSelf(TTBlocks.RED_GLAZED_TERRACOTTA_BUTTON.get());
        dropSelf(TTBlocks.BLACK_GLAZED_TERRACOTTA_BUTTON.get());

        dropSelf(TTBlocks.TERRACOTTA_PRESSURE_PLATE.get());
        dropSelf(TTBlocks.WHITE_TERRACOTTA_PRESSURE_PLATE.get());
        dropSelf(TTBlocks.ORANGE_TERRACOTTA_PRESSURE_PLATE.get());
        dropSelf(TTBlocks.MAGENTA_TERRACOTTA_PRESSURE_PLATE.get());
        dropSelf(TTBlocks.LIGHT_BLUE_TERRACOTTA_PRESSURE_PLATE.get());
        dropSelf(TTBlocks.YELLOW_TERRACOTTA_PRESSURE_PLATE.get());
        dropSelf(TTBlocks.LIME_TERRACOTTA_PRESSURE_PLATE.get());
        dropSelf(TTBlocks.PINK_TERRACOTTA_PRESSURE_PLATE.get());
        dropSelf(TTBlocks.GRAY_TERRACOTTA_PRESSURE_PLATE.get());
        dropSelf(TTBlocks.LIGHT_GRAY_TERRACOTTA_PRESSURE_PLATE.get());
        dropSelf(TTBlocks.CYAN_TERRACOTTA_PRESSURE_PLATE.get());
        dropSelf(TTBlocks.PURPLE_TERRACOTTA_PRESSURE_PLATE.get());
        dropSelf(TTBlocks.BLUE_TERRACOTTA_PRESSURE_PLATE.get());
        dropSelf(TTBlocks.BROWN_TERRACOTTA_PRESSURE_PLATE.get());
        dropSelf(TTBlocks.GREEN_TERRACOTTA_PRESSURE_PLATE.get());
        dropSelf(TTBlocks.RED_TERRACOTTA_PRESSURE_PLATE.get());
        dropSelf(TTBlocks.BLACK_TERRACOTTA_PRESSURE_PLATE.get());
        dropSelf(TTBlocks.WHITE_GLAZED_TERRACOTTA_PRESSURE_PLATE.get());
        dropSelf(TTBlocks.ORANGE_GLAZED_TERRACOTTA_PRESSURE_PLATE.get());
        dropSelf(TTBlocks.MAGENTA_GLAZED_TERRACOTTA_PRESSURE_PLATE.get());
        dropSelf(TTBlocks.LIGHT_BLUE_GLAZED_TERRACOTTA_PRESSURE_PLATE.get());
        dropSelf(TTBlocks.YELLOW_GLAZED_TERRACOTTA_PRESSURE_PLATE.get());
        dropSelf(TTBlocks.LIME_GLAZED_TERRACOTTA_PRESSURE_PLATE.get());
        dropSelf(TTBlocks.PINK_GLAZED_TERRACOTTA_PRESSURE_PLATE.get());
        dropSelf(TTBlocks.GRAY_GLAZED_TERRACOTTA_PRESSURE_PLATE.get());
        dropSelf(TTBlocks.LIGHT_GRAY_GLAZED_TERRACOTTA_PRESSURE_PLATE.get());
        dropSelf(TTBlocks.CYAN_GLAZED_TERRACOTTA_PRESSURE_PLATE.get());
        dropSelf(TTBlocks.PURPLE_GLAZED_TERRACOTTA_PRESSURE_PLATE.get());
        dropSelf(TTBlocks.BLUE_GLAZED_TERRACOTTA_PRESSURE_PLATE.get());
        dropSelf(TTBlocks.BROWN_GLAZED_TERRACOTTA_PRESSURE_PLATE.get());
        dropSelf(TTBlocks.GREEN_GLAZED_TERRACOTTA_PRESSURE_PLATE.get());
        dropSelf(TTBlocks.RED_GLAZED_TERRACOTTA_PRESSURE_PLATE.get());
        dropSelf(TTBlocks.BLACK_GLAZED_TERRACOTTA_PRESSURE_PLATE.get());

        dropSelf(TTBlocks.TERRACOTTA_STAIRS.get());
        dropSelf(TTBlocks.WHITE_TERRACOTTA_STAIRS.get());
        dropSelf(TTBlocks.ORANGE_TERRACOTTA_STAIRS.get());
        dropSelf(TTBlocks.MAGENTA_TERRACOTTA_STAIRS.get());
        dropSelf(TTBlocks.LIGHT_BLUE_TERRACOTTA_STAIRS.get());
        dropSelf(TTBlocks.YELLOW_TERRACOTTA_STAIRS.get());
        dropSelf(TTBlocks.LIME_TERRACOTTA_STAIRS.get());
        dropSelf(TTBlocks.PINK_TERRACOTTA_STAIRS.get());
        dropSelf(TTBlocks.GRAY_TERRACOTTA_STAIRS.get());
        dropSelf(TTBlocks.LIGHT_GRAY_TERRACOTTA_STAIRS.get());
        dropSelf(TTBlocks.CYAN_TERRACOTTA_STAIRS.get());
        dropSelf(TTBlocks.PURPLE_TERRACOTTA_STAIRS.get());
        dropSelf(TTBlocks.BLUE_TERRACOTTA_STAIRS.get());
        dropSelf(TTBlocks.BROWN_TERRACOTTA_STAIRS.get());
        dropSelf(TTBlocks.GREEN_TERRACOTTA_STAIRS.get());
        dropSelf(TTBlocks.RED_TERRACOTTA_STAIRS.get());
        dropSelf(TTBlocks.BLACK_TERRACOTTA_STAIRS.get());
        dropSelf(TTBlocks.WHITE_GLAZED_TERRACOTTA_STAIRS.get());
        dropSelf(TTBlocks.ORANGE_GLAZED_TERRACOTTA_STAIRS.get());
        dropSelf(TTBlocks.MAGENTA_GLAZED_TERRACOTTA_STAIRS.get());
        dropSelf(TTBlocks.LIGHT_BLUE_GLAZED_TERRACOTTA_STAIRS.get());
        dropSelf(TTBlocks.YELLOW_GLAZED_TERRACOTTA_STAIRS.get());
        dropSelf(TTBlocks.LIME_GLAZED_TERRACOTTA_STAIRS.get());
        dropSelf(TTBlocks.PINK_GLAZED_TERRACOTTA_STAIRS.get());
        dropSelf(TTBlocks.GRAY_GLAZED_TERRACOTTA_STAIRS.get());
        dropSelf(TTBlocks.LIGHT_GRAY_GLAZED_TERRACOTTA_STAIRS.get());
        dropSelf(TTBlocks.CYAN_GLAZED_TERRACOTTA_STAIRS.get());
        dropSelf(TTBlocks.PURPLE_GLAZED_TERRACOTTA_STAIRS.get());
        dropSelf(TTBlocks.BLUE_GLAZED_TERRACOTTA_STAIRS.get());
        dropSelf(TTBlocks.BROWN_GLAZED_TERRACOTTA_STAIRS.get());
        dropSelf(TTBlocks.GREEN_GLAZED_TERRACOTTA_STAIRS.get());
        dropSelf(TTBlocks.RED_GLAZED_TERRACOTTA_STAIRS.get());
        dropSelf(TTBlocks.BLACK_GLAZED_TERRACOTTA_STAIRS.get());

        add(TTBlocks.TERRACOTTA_SLAB.get(), this::createSlabItemTable);
        add(TTBlocks.WHITE_TERRACOTTA_SLAB.get(), this::createSlabItemTable);
        add(TTBlocks.ORANGE_TERRACOTTA_SLAB.get(), this::createSlabItemTable);
        add(TTBlocks.MAGENTA_TERRACOTTA_SLAB.get(), this::createSlabItemTable);
        add(TTBlocks.LIGHT_BLUE_TERRACOTTA_SLAB.get(), this::createSlabItemTable);
        add(TTBlocks.YELLOW_TERRACOTTA_SLAB.get(), this::createSlabItemTable);
        add(TTBlocks.LIME_TERRACOTTA_SLAB.get(), this::createSlabItemTable);
        add(TTBlocks.PINK_TERRACOTTA_SLAB.get(), this::createSlabItemTable);
        add(TTBlocks.GRAY_TERRACOTTA_SLAB.get(), this::createSlabItemTable);
        add(TTBlocks.LIGHT_GRAY_TERRACOTTA_SLAB.get(), this::createSlabItemTable);
        add(TTBlocks.CYAN_TERRACOTTA_SLAB.get(), this::createSlabItemTable);
        add(TTBlocks.PURPLE_TERRACOTTA_SLAB.get(), this::createSlabItemTable);
        add(TTBlocks.BLUE_TERRACOTTA_SLAB.get(), this::createSlabItemTable);
        add(TTBlocks.BROWN_TERRACOTTA_SLAB.get(), this::createSlabItemTable);
        add(TTBlocks.GREEN_TERRACOTTA_SLAB.get(), this::createSlabItemTable);
        add(TTBlocks.RED_TERRACOTTA_SLAB.get(), this::createSlabItemTable);
        add(TTBlocks.BLACK_TERRACOTTA_SLAB.get(), this::createSlabItemTable);
        add(TTBlocks.WHITE_GLAZED_TERRACOTTA_SLAB.get(), this::createSlabItemTable);
        add(TTBlocks.ORANGE_GLAZED_TERRACOTTA_SLAB.get(), this::createSlabItemTable);
        add(TTBlocks.MAGENTA_GLAZED_TERRACOTTA_SLAB.get(), this::createSlabItemTable);
        add(TTBlocks.LIGHT_BLUE_GLAZED_TERRACOTTA_SLAB.get(), this::createSlabItemTable);
        add(TTBlocks.YELLOW_GLAZED_TERRACOTTA_SLAB.get(), this::createSlabItemTable);
        add(TTBlocks.LIME_GLAZED_TERRACOTTA_SLAB.get(), this::createSlabItemTable);
        add(TTBlocks.PINK_GLAZED_TERRACOTTA_SLAB.get(), this::createSlabItemTable);
        add(TTBlocks.GRAY_GLAZED_TERRACOTTA_SLAB.get(), this::createSlabItemTable);
        add(TTBlocks.LIGHT_GRAY_GLAZED_TERRACOTTA_SLAB.get(), this::createSlabItemTable);
        add(TTBlocks.CYAN_GLAZED_TERRACOTTA_SLAB.get(), this::createSlabItemTable);
        add(TTBlocks.PURPLE_GLAZED_TERRACOTTA_SLAB.get(), this::createSlabItemTable);
        add(TTBlocks.BLUE_GLAZED_TERRACOTTA_SLAB.get(), this::createSlabItemTable);
        add(TTBlocks.BROWN_GLAZED_TERRACOTTA_SLAB.get(), this::createSlabItemTable);
        add(TTBlocks.GREEN_GLAZED_TERRACOTTA_SLAB.get(), this::createSlabItemTable);
        add(TTBlocks.RED_GLAZED_TERRACOTTA_SLAB.get(), this::createSlabItemTable);
        add(TTBlocks.BLACK_GLAZED_TERRACOTTA_SLAB.get(), this::createSlabItemTable);

        dropSelf(TTBlocks.TERRACOTTA_WALL.get());
        dropSelf(TTBlocks.WHITE_TERRACOTTA_WALL.get());
        dropSelf(TTBlocks.ORANGE_TERRACOTTA_WALL.get());
        dropSelf(TTBlocks.MAGENTA_TERRACOTTA_WALL.get());
        dropSelf(TTBlocks.LIGHT_BLUE_TERRACOTTA_WALL.get());
        dropSelf(TTBlocks.YELLOW_TERRACOTTA_WALL.get());
        dropSelf(TTBlocks.LIME_TERRACOTTA_WALL.get());
        dropSelf(TTBlocks.PINK_TERRACOTTA_WALL.get());
        dropSelf(TTBlocks.GRAY_TERRACOTTA_WALL.get());
        dropSelf(TTBlocks.LIGHT_GRAY_TERRACOTTA_WALL.get());
        dropSelf(TTBlocks.CYAN_TERRACOTTA_WALL.get());
        dropSelf(TTBlocks.PURPLE_TERRACOTTA_WALL.get());
        dropSelf(TTBlocks.BLUE_TERRACOTTA_WALL.get());
        dropSelf(TTBlocks.BROWN_TERRACOTTA_WALL.get());
        dropSelf(TTBlocks.GREEN_TERRACOTTA_WALL.get());
        dropSelf(TTBlocks.RED_TERRACOTTA_WALL.get());
        dropSelf(TTBlocks.BLACK_TERRACOTTA_WALL.get());
        dropSelf(TTBlocks.WHITE_GLAZED_TERRACOTTA_WALL.get());
        dropSelf(TTBlocks.ORANGE_GLAZED_TERRACOTTA_WALL.get());
        dropSelf(TTBlocks.MAGENTA_GLAZED_TERRACOTTA_WALL.get());
        dropSelf(TTBlocks.LIGHT_BLUE_GLAZED_TERRACOTTA_WALL.get());
        dropSelf(TTBlocks.YELLOW_GLAZED_TERRACOTTA_WALL.get());
        dropSelf(TTBlocks.LIME_GLAZED_TERRACOTTA_WALL.get());
        dropSelf(TTBlocks.PINK_GLAZED_TERRACOTTA_WALL.get());
        dropSelf(TTBlocks.GRAY_GLAZED_TERRACOTTA_WALL.get());
        dropSelf(TTBlocks.LIGHT_GRAY_GLAZED_TERRACOTTA_WALL.get());
        dropSelf(TTBlocks.CYAN_GLAZED_TERRACOTTA_WALL.get());
        dropSelf(TTBlocks.PURPLE_GLAZED_TERRACOTTA_WALL.get());
        dropSelf(TTBlocks.BLUE_GLAZED_TERRACOTTA_WALL.get());
        dropSelf(TTBlocks.BROWN_GLAZED_TERRACOTTA_WALL.get());
        dropSelf(TTBlocks.GREEN_GLAZED_TERRACOTTA_WALL.get());
        dropSelf(TTBlocks.RED_GLAZED_TERRACOTTA_WALL.get());
        dropSelf(TTBlocks.BLACK_GLAZED_TERRACOTTA_WALL.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BuiltInRegistries.BLOCK.stream().filter(block -> Optional.of(BuiltInRegistries.BLOCK.getKey(block)).filter(key -> key.getNamespace().equals(Constants.MODID)).isPresent()).collect(Collectors.toSet());
    }
}
