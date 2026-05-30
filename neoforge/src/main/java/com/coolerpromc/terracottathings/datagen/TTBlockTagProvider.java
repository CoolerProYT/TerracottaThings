package com.coolerpromc.terracottathings.datagen;

import com.coolerpromc.terracottathings.Constants;
import com.coolerpromc.terracottathings.block.TTBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class TTBlockTagProvider extends BlockTagsProvider {
    public TTBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, Constants.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
       /* tag(BlockTags.WALLS).add(TTBlocks.TERRACOTTA_WALL.get()).addAll(TTBlocks.DYED_TERRACOTTA_WALLS.asList()).addAll(TTBlocks.GLAZED_TERRACOTTA_WALLS.asList());
        tag(BlockTags.SLABS).add(TTBlocks.TERRACOTTA_SLAB.get()).addAll(TTBlocks.DYED_TERRACOTTA_SLABS.asList()).addAll(TTBlocks.GLAZED_TERRACOTTA_SLABS.asList());
        tag(BlockTags.STAIRS).add(TTBlocks.TERRACOTTA_STAIRS.get()).addAll(TTBlocks.DYED_TERRACOTTA_STAIRS.asList()).addAll(TTBlocks.GLAZED_TERRACOTTA_STAIRS.asList());
        tag(BlockTags.PRESSURE_PLATES).add(TTBlocks.TERRACOTTA_PRESSURE_PLATE.get()).addAll(TTBlocks.DYED_TERRACOTTA_PRESSURE_PLATES.asList()).addAll(TTBlocks.GLAZED_TERRACOTTA_PRESSURE_PLATES.asList());
        tag(BlockTags.BUTTONS).add(TTBlocks.TERRACOTTA_BUTTON.get()).addAll(TTBlocks.DYED_TERRACOTTA_BUTTONS.asList()).addAll(TTBlocks.GLAZED_TERRACOTTA_BUTTONS.asList());*/
    }
}
