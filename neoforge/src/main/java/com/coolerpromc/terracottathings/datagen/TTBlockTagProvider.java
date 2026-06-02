package com.coolerpromc.terracottathings.datagen;

import com.coolerpromc.terracottathings.Constants;
import com.coolerpromc.terracottathings.block.TTBlocks;
import com.coolerpromc.terracottathings.platform.util.RegistryHandler;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagAppender;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ColorCollection;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class TTBlockTagProvider extends BlockTagsProvider {
    public TTBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, Constants.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        TagAppender<Block> wallsTag = tag(BlockTags.WALLS).add(TTBlocks.TERRACOTTA_WALL.key());
        ColorCollection.zipApply(TTBlocks.DYED_TERRACOTTA_WALLS, TTBlocks.GLAZED_TERRACOTTA_WALLS, (t, g) -> append(t, g, wallsTag));

        TagAppender<Block> slabsTag = tag(BlockTags.SLABS);
        ColorCollection.zipApply(TTBlocks.DYED_TERRACOTTA_SLABS, TTBlocks.GLAZED_TERRACOTTA_SLABS, (t, g) -> append(t, g, slabsTag));

        TagAppender<Block> stairsTag = tag(BlockTags.STAIRS);
        ColorCollection.zipApply(TTBlocks.DYED_TERRACOTTA_STAIRS, TTBlocks.GLAZED_TERRACOTTA_STAIRS, (t, g) -> append(t, g, stairsTag));

        TagAppender<Block> pressurePlatesTag = tag(BlockTags.PRESSURE_PLATES).add(TTBlocks.TERRACOTTA_PRESSURE_PLATE.key());
        ColorCollection.zipApply(TTBlocks.DYED_TERRACOTTA_PRESSURE_PLATES, TTBlocks.GLAZED_TERRACOTTA_PRESSURE_PLATES, (t, g) -> append(t, g, pressurePlatesTag));

        TagAppender<Block> buttonsTag = tag(BlockTags.BUTTONS).add(TTBlocks.TERRACOTTA_BUTTON.key());
        ColorCollection.zipApply(TTBlocks.DYED_TERRACOTTA_BUTTONS, TTBlocks.GLAZED_TERRACOTTA_BUTTONS, (t, g) -> append(t, g, buttonsTag));

        TagAppender<Block> pickaxeMineableTag = tag(BlockTags.MINEABLE_WITH_PICKAXE).add(TTBlocks.TERRACOTTA_SLAB.key()).add(TTBlocks.TERRACOTTA_STAIRS.key());
        ColorCollection.zipApply(TTBlocks.DYED_TERRACOTTA_SLABS, TTBlocks.GLAZED_TERRACOTTA_SLABS, (t, g) -> append(t, g, pickaxeMineableTag));
        ColorCollection.zipApply(TTBlocks.DYED_TERRACOTTA_STAIRS, TTBlocks.GLAZED_TERRACOTTA_STAIRS, (t, g) -> append(t, g, pickaxeMineableTag));
    }

    @SuppressWarnings("unchecked")
    private void append(RegistryHandler.Blocks<?> block1, RegistryHandler.Blocks<?> block2, TagAppender<Block> tag){
        tag.add(block1.key(), block2.key());
    }
}
