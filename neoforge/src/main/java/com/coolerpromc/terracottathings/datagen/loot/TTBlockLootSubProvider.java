package com.coolerpromc.terracottathings.datagen.loot;

import com.coolerpromc.terracottathings.Constants;
import com.coolerpromc.terracottathings.block.TTBlocks;
import com.coolerpromc.terracottathings.platform.util.RegistryHandler;
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
        TTBlocks.DYED_TERRACOTTA_BUTTONS.map(RegistryHandler.Blocks::get).forEach(this::dropSelf);
        TTBlocks.GLAZED_TERRACOTTA_BUTTONS.map(RegistryHandler.Blocks::get).forEach(this::dropSelf);

        dropSelf(TTBlocks.TERRACOTTA_PRESSURE_PLATE.get());
        TTBlocks.DYED_TERRACOTTA_PRESSURE_PLATES.map(RegistryHandler.Blocks::get).forEach(this::dropSelf);
        TTBlocks.GLAZED_TERRACOTTA_PRESSURE_PLATES.map(RegistryHandler.Blocks::get).forEach(this::dropSelf);

        dropSelf(TTBlocks.TERRACOTTA_STAIRS.get());
        TTBlocks.DYED_TERRACOTTA_STAIRS.map(RegistryHandler.Blocks::get).forEach(this::dropSelf);
        TTBlocks.GLAZED_TERRACOTTA_STAIRS.map(RegistryHandler.Blocks::get).forEach(this::dropSelf);

        add(TTBlocks.TERRACOTTA_SLAB.get(), this::createSlabItemTable);
        TTBlocks.DYED_TERRACOTTA_SLABS.map(RegistryHandler.Blocks::get).forEach(b -> add(b, this::createSlabItemTable));
        TTBlocks.GLAZED_TERRACOTTA_SLABS.map(RegistryHandler.Blocks::get).forEach(b -> add(b, this::createSlabItemTable));

        dropSelf(TTBlocks.TERRACOTTA_WALL.get());
        TTBlocks.DYED_TERRACOTTA_WALLS.map(RegistryHandler.Blocks::get).forEach(this::dropSelf);
        TTBlocks.GLAZED_TERRACOTTA_WALLS.map(RegistryHandler.Blocks::get).forEach(this::dropSelf);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BuiltInRegistries.BLOCK.stream().filter(block -> Optional.of(BuiltInRegistries.BLOCK.getKey(block)).filter(key -> key.getNamespace().equals(Constants.MODID)).isPresent()).collect(Collectors.toSet());
    }
}
