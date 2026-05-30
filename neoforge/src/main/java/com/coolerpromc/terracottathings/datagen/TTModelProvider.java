package com.coolerpromc.terracottathings.datagen;

import com.coolerpromc.terracottathings.Constants;
import com.coolerpromc.terracottathings.block.TTBlocks;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class TTModelProvider extends ModelProvider {
    public TTModelProvider(PackOutput output) {
        super(output, Constants.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        registerAll(blockModels, TTBlocks.TERRACOTTA_BUTTON.get(), TTBlocks.TERRACOTTA_PRESSURE_PLATE.get(), TTBlocks.TERRACOTTA_STAIRS.get(), TTBlocks.TERRACOTTA_SLAB.get(), TTBlocks.TERRACOTTA_WALL.get(), Blocks.TERRACOTTA);
        /*for (DyeColor color : DyeColor.values()) {
            registerAll(blockModels, TTBlocks.DYED_TERRACOTTA_BUTTONS.pick(color).get(), TTBlocks.DYED_TERRACOTTA_PRESSURE_PLATES.pick(color).get(), TTBlocks.DYED_TERRACOTTA_STAIRS.pick(color).get(), TTBlocks.DYED_TERRACOTTA_SLABS.pick(color).get(), TTBlocks.DYED_TERRACOTTA_WALLS.pick(color).get(), Blocks.DYED_TERRACOTTA.pick(color));
            registerAll(blockModels, TTBlocks.GLAZED_TERRACOTTA_BUTTONS.pick(color).get(), TTBlocks.GLAZED_TERRACOTTA_PRESSURE_PLATES.pick(color).get(), TTBlocks.GLAZED_TERRACOTTA_STAIRS.pick(color).get(), TTBlocks.GLAZED_TERRACOTTA_SLABS.pick(color).get(), TTBlocks.GLAZED_TERRACOTTA_WALLS.pick(color).get(), Blocks.GLAZED_TERRACOTTA.pick(color));
        }*/
    }

    private void registerAll(BlockModelGenerators gen, Block button, Block pressurePlate, Block stairs, Block slab, Block wall, Block textureSource) {
        gen.familyWithExistingFullBlock(textureSource).button(button).pressurePlate(pressurePlate).stairs(stairs).slab(slab).wall(wall);
    }
}
