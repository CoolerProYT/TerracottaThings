package com.coolerpromc.terracottathings.datagen;

import com.coolerpromc.terracottathings.Constants;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagCopyingItemTagProvider;

import java.util.concurrent.CompletableFuture;

public class TTBlockItemTagProvider extends BlockTagCopyingItemTagProvider {
    public TTBlockItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags) {
        super(output, lookupProvider, blockTags, Constants.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        copy(BlockTags.WALLS, ItemTags.WALLS);
        copy(BlockTags.SLABS, BlockItemTags.SLABS.item());
        copy(BlockTags.STAIRS, BlockItemTags.STAIRS.item());
        copy(BlockTags.BUTTONS, BlockItemTags.BUTTONS.item());
    }
}
