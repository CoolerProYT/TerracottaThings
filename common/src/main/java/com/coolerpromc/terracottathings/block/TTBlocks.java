package com.coolerpromc.terracottathings.block;

import com.coolerpromc.terracottathings.Constants;
import com.coolerpromc.terracottathings.block.set.TTBlockSetTypes;
import com.coolerpromc.terracottathings.platform.Services;
import com.coolerpromc.terracottathings.platform.util.RegistryHandler;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class TTBlocks {
    public static final RegistryHandler.Blocks<ButtonBlock> TERRACOTTA_BUTTON = registerBlock("terracotta_button", p -> new ButtonBlock(TTBlockSetTypes.TERRACOTTA, 20, p), buttonProps());
    public static final RegistryHandler.Blocks<PressurePlateBlock> TERRACOTTA_PRESSURE_PLATE = registerBlock("terracotta_pressure_plate", p -> new PressurePlateBlock(TTBlockSetTypes.TERRACOTTA, p), pressurePlateProps());
    public static final RegistryHandler.Blocks<StairBlock> TERRACOTTA_STAIRS = registerBlock("terracotta_stairs", p -> new StairBlock(Blocks.TERRACOTTA.defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA));
    public static final RegistryHandler.Blocks<SlabBlock> TERRACOTTA_SLAB = registerBlock("terracotta_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA));
    public static final RegistryHandler.Blocks<WallBlock> TERRACOTTA_WALL = registerBlock("terracotta_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA));

    public static final ColorCollection<RegistryHandler.Blocks<ButtonBlock>> DYED_TERRACOTTA_BUTTONS = dyedVariants("terracotta_button", p -> new ButtonBlock(TTBlockSetTypes.TERRACOTTA, 20, p), TTBlocks::buttonProps);
    public static final ColorCollection<RegistryHandler.Blocks<PressurePlateBlock>> DYED_TERRACOTTA_PRESSURE_PLATES = dyedVariants("terracotta_pressure_plate", p -> new PressurePlateBlock(TTBlockSetTypes.TERRACOTTA, p), TTBlocks::pressurePlateProps);
    public static final ColorCollection<RegistryHandler.Blocks<StairBlock>> DYED_TERRACOTTA_STAIRS = dyedVariants("terracotta_stairs", Blocks.DYED_TERRACOTTA, (base, p) -> new StairBlock(base.defaultBlockState(), p));
    public static final ColorCollection<RegistryHandler.Blocks<SlabBlock>> DYED_TERRACOTTA_SLABS = dyedVariants("terracotta_slab", Blocks.DYED_TERRACOTTA, (base, p) -> new SlabBlock(p));
    public static final ColorCollection<RegistryHandler.Blocks<WallBlock>> DYED_TERRACOTTA_WALLS = dyedVariants("terracotta_wall", Blocks.DYED_TERRACOTTA, (base, p) -> new WallBlock(p));

    public static final ColorCollection<RegistryHandler.Blocks<ButtonBlock>> GLAZED_TERRACOTTA_BUTTONS = dyedVariants("glazed_terracotta_button", p -> new ButtonBlock(TTBlockSetTypes.TERRACOTTA, 20, p), TTBlocks::buttonProps);
    public static final ColorCollection<RegistryHandler.Blocks<PressurePlateBlock>> GLAZED_TERRACOTTA_PRESSURE_PLATES = dyedVariants("glazed_terracotta_pressure_plate", p -> new PressurePlateBlock(TTBlockSetTypes.TERRACOTTA, p), TTBlocks::pressurePlateProps);
    public static final ColorCollection<RegistryHandler.Blocks<StairBlock>> GLAZED_TERRACOTTA_STAIRS = dyedVariants("glazed_terracotta_stairs", Blocks.GLAZED_TERRACOTTA, (base, p) -> new StairBlock(base.defaultBlockState(), p));
    public static final ColorCollection<RegistryHandler.Blocks<SlabBlock>> GLAZED_TERRACOTTA_SLABS = dyedVariants("glazed_terracotta_slab", Blocks.GLAZED_TERRACOTTA, (base, p) -> new SlabBlock(p));
    public static final ColorCollection<RegistryHandler.Blocks<WallBlock>> GLAZED_TERRACOTTA_WALLS = dyedVariants("glazed_terracotta_wall", Blocks.GLAZED_TERRACOTTA, (base, p) -> new WallBlock(p));

    private static ColorCollection<String> names(String suffix) {
        return ColorCollection.prefixWithColor(ColorCollection.create(suffix));
    }

    private static <T extends Block> ColorCollection<RegistryHandler.Blocks<T>> dyedVariants(String suffix, Function<BlockBehaviour.Properties, T> factory, Supplier<BlockBehaviour.Properties> props) {
        return names(suffix).map(name -> registerBlock(name, factory, props.get()));
    }

    private static <T extends Block> ColorCollection<RegistryHandler.Blocks<T>> dyedVariants(String suffix, ColorCollection<Block> bases, BiFunction<Block, BlockBehaviour.Properties, T> factory) {
        return ColorCollection.zipMap(names(suffix), bases, (name, base) -> registerBlock(name, p -> factory.apply(base, p), BlockBehaviour.Properties.ofFullCopy(base)));
    }

    private static BlockBehaviour.Properties buttonProps() {
        return BlockBehaviour.Properties.of().noCollision().strength(0.5F).pushReaction(PushReaction.DESTROY);
    }

    private static BlockBehaviour.Properties pressurePlateProps() {
        return BlockBehaviour.Properties.of().noCollision().strength(0.5F).pushReaction(PushReaction.DESTROY);
    }

    private static <T extends Block> RegistryHandler.Blocks<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> func, BlockBehaviour.Properties properties){
        RegistryHandler.Blocks<T> blocks = Services.REGISTRY.registerBlock(name, func, properties);
        Services.REGISTRY.registerBlockItem(name, blocks, (block, properties1) -> new BlockItem(block, properties1.useBlockDescriptionPrefix()));
        return blocks;
    }

    public static void init() {
        Constants.LOGGER.info("Registering TerracottaThings Blocks.");
    }
}