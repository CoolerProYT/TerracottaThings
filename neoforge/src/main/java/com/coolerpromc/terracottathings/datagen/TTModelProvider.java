package com.coolerpromc.terracottathings.datagen;

import com.coolerpromc.terracottathings.Constants;
import com.coolerpromc.terracottathings.block.TTBlocks;
import com.coolerpromc.terracottathings.block.GlazedTerracottaSlabBlock;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.block.SlabBlock;
import static net.minecraft.client.data.models.BlockModelGenerators.*;
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
        for (DyeColor color : DyeColor.values()) {
            registerAll(blockModels, TTBlocks.DYED_TERRACOTTA_BUTTONS.pick(color).get(), TTBlocks.DYED_TERRACOTTA_PRESSURE_PLATES.pick(color).get(), TTBlocks.DYED_TERRACOTTA_STAIRS.pick(color).get(), TTBlocks.DYED_TERRACOTTA_SLABS.pick(color).get(), TTBlocks.DYED_TERRACOTTA_WALLS.pick(color).get(), Blocks.DYED_TERRACOTTA.pick(color));
            registerAll(blockModels, TTBlocks.GLAZED_TERRACOTTA_BUTTONS.pick(color).get(), TTBlocks.GLAZED_TERRACOTTA_PRESSURE_PLATES.pick(color).get(), TTBlocks.GLAZED_TERRACOTTA_STAIRS.pick(color).get(), TTBlocks.GLAZED_TERRACOTTA_SLABS.pick(color).get(), TTBlocks.GLAZED_TERRACOTTA_WALLS.pick(color).get(), Blocks.GLAZED_TERRACOTTA.pick(color));
        }
    }

    private void registerAll(BlockModelGenerators gen, Block button, Block pressurePlate, Block stairs, Block slab, Block wall, Block textureSource) {
        var family = gen.familyWithExistingFullBlock(textureSource).button(button).pressurePlate(pressurePlate).stairs(stairs).wall(wall);
        if (slab instanceof GlazedTerracottaSlabBlock) {
            var textures = TextureMapping.cube(textureSource);
            var bottom = ModelTemplates.SLAB_BOTTOM.create(slab, textures, gen.modelOutput);
            var top = ModelTemplates.SLAB_TOP.create(slab, textures, gen.modelOutput);
            gen.blockStateOutput.accept(MultiVariantGenerator.dispatch(slab)
                .with(PropertyDispatch.initial(SlabBlock.TYPE)
                    .select(SlabType.BOTTOM, plainVariant(bottom))
                    .select(SlabType.TOP, plainVariant(top))
                    .select(SlabType.DOUBLE, plainVariant(ModelLocationUtils.getModelLocation(textureSource))))
                .with(PropertyDispatch.modify(GlazedTerracottaSlabBlock.FACING)
                    .select(Direction.SOUTH, NOP).select(Direction.WEST, Y_ROT_90)
                    .select(Direction.NORTH, Y_ROT_180).select(Direction.EAST, Y_ROT_270)));
            gen.registerSimpleItemModel(slab, bottom);
        } else {
            family.slab(slab);
        }
    }
}
