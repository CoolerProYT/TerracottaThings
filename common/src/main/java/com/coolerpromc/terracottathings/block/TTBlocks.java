package com.coolerpromc.terracottathings.block;

import com.coolerpromc.terracottathings.Constants;
import com.coolerpromc.terracottathings.block.set.TTBlockSetTypes;
import com.coolerpromc.terracottathings.platform.Services;
import com.coolerpromc.terracottathings.platform.util.RegistryHandler;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Function;

public class TTBlocks {
    public static final RegistryHandler.Blocks<ButtonBlock> TERRACOTTA_BUTTON = registerBlock("terracotta_button", p -> new ButtonBlock(TTBlockSetTypes.TERRACOTTA, 20, p), buttonProps());
    public static final RegistryHandler.Blocks<ButtonBlock> WHITE_TERRACOTTA_BUTTON = registerBlock("white_terracotta_button", p -> new ButtonBlock(TTBlockSetTypes.TERRACOTTA, 20, p), buttonProps());
    public static final RegistryHandler.Blocks<ButtonBlock> ORANGE_TERRACOTTA_BUTTON = registerBlock("orange_terracotta_button", p -> new ButtonBlock(TTBlockSetTypes.TERRACOTTA, 20, p), buttonProps());
    public static final RegistryHandler.Blocks<ButtonBlock> MAGENTA_TERRACOTTA_BUTTON = registerBlock("magenta_terracotta_button", p -> new ButtonBlock(TTBlockSetTypes.TERRACOTTA, 20, p), buttonProps());
    public static final RegistryHandler.Blocks<ButtonBlock> LIGHT_BLUE_TERRACOTTA_BUTTON = registerBlock("light_blue_terracotta_button", p -> new ButtonBlock(TTBlockSetTypes.TERRACOTTA, 20, p), buttonProps());
    public static final RegistryHandler.Blocks<ButtonBlock> YELLOW_TERRACOTTA_BUTTON = registerBlock("yellow_terracotta_button", p -> new ButtonBlock(TTBlockSetTypes.TERRACOTTA, 20, p), buttonProps());
    public static final RegistryHandler.Blocks<ButtonBlock> LIME_TERRACOTTA_BUTTON = registerBlock("lime_terracotta_button", p -> new ButtonBlock(TTBlockSetTypes.TERRACOTTA, 20, p), buttonProps());
    public static final RegistryHandler.Blocks<ButtonBlock> PINK_TERRACOTTA_BUTTON = registerBlock("pink_terracotta_button", p -> new ButtonBlock(TTBlockSetTypes.TERRACOTTA, 20, p), buttonProps());
    public static final RegistryHandler.Blocks<ButtonBlock> GRAY_TERRACOTTA_BUTTON = registerBlock("gray_terracotta_button", p -> new ButtonBlock(TTBlockSetTypes.TERRACOTTA, 20, p), buttonProps());
    public static final RegistryHandler.Blocks<ButtonBlock> LIGHT_GRAY_TERRACOTTA_BUTTON = registerBlock("light_gray_terracotta_button", p -> new ButtonBlock(TTBlockSetTypes.TERRACOTTA, 20, p), buttonProps());
    public static final RegistryHandler.Blocks<ButtonBlock> CYAN_TERRACOTTA_BUTTON = registerBlock("cyan_terracotta_button", p -> new ButtonBlock(TTBlockSetTypes.TERRACOTTA, 20, p), buttonProps());
    public static final RegistryHandler.Blocks<ButtonBlock> PURPLE_TERRACOTTA_BUTTON = registerBlock("purple_terracotta_button", p -> new ButtonBlock(TTBlockSetTypes.TERRACOTTA, 20, p), buttonProps());
    public static final RegistryHandler.Blocks<ButtonBlock> BLUE_TERRACOTTA_BUTTON = registerBlock("blue_terracotta_button", p -> new ButtonBlock(TTBlockSetTypes.TERRACOTTA, 20, p), buttonProps());
    public static final RegistryHandler.Blocks<ButtonBlock> BROWN_TERRACOTTA_BUTTON = registerBlock("brown_terracotta_button", p -> new ButtonBlock(TTBlockSetTypes.TERRACOTTA, 20, p), buttonProps());
    public static final RegistryHandler.Blocks<ButtonBlock> GREEN_TERRACOTTA_BUTTON = registerBlock("green_terracotta_button", p -> new ButtonBlock(TTBlockSetTypes.TERRACOTTA, 20, p), buttonProps());
    public static final RegistryHandler.Blocks<ButtonBlock> RED_TERRACOTTA_BUTTON = registerBlock("red_terracotta_button", p -> new ButtonBlock(TTBlockSetTypes.TERRACOTTA, 20, p), buttonProps());
    public static final RegistryHandler.Blocks<ButtonBlock> BLACK_TERRACOTTA_BUTTON = registerBlock("black_terracotta_button", p -> new ButtonBlock(TTBlockSetTypes.TERRACOTTA, 20, p), buttonProps());

    public static final RegistryHandler.Blocks<PressurePlateBlock> TERRACOTTA_PRESSURE_PLATE = registerBlock("terracotta_pressure_plate", p -> new PressurePlateBlock(TTBlockSetTypes.TERRACOTTA, p), pressurePlateProps());
    public static final RegistryHandler.Blocks<PressurePlateBlock> WHITE_TERRACOTTA_PRESSURE_PLATE = registerBlock("white_terracotta_pressure_plate", p -> new PressurePlateBlock(TTBlockSetTypes.TERRACOTTA, p), pressurePlateProps());
    public static final RegistryHandler.Blocks<PressurePlateBlock> ORANGE_TERRACOTTA_PRESSURE_PLATE = registerBlock("orange_terracotta_pressure_plate", p -> new PressurePlateBlock(TTBlockSetTypes.TERRACOTTA, p), pressurePlateProps());
    public static final RegistryHandler.Blocks<PressurePlateBlock> MAGENTA_TERRACOTTA_PRESSURE_PLATE = registerBlock("magenta_terracotta_pressure_plate", p -> new PressurePlateBlock(TTBlockSetTypes.TERRACOTTA, p), pressurePlateProps());
    public static final RegistryHandler.Blocks<PressurePlateBlock> LIGHT_BLUE_TERRACOTTA_PRESSURE_PLATE = registerBlock("light_blue_terracotta_pressure_plate", p -> new PressurePlateBlock(TTBlockSetTypes.TERRACOTTA, p), pressurePlateProps());
    public static final RegistryHandler.Blocks<PressurePlateBlock> YELLOW_TERRACOTTA_PRESSURE_PLATE = registerBlock("yellow_terracotta_pressure_plate", p -> new PressurePlateBlock(TTBlockSetTypes.TERRACOTTA, p), pressurePlateProps());
    public static final RegistryHandler.Blocks<PressurePlateBlock> LIME_TERRACOTTA_PRESSURE_PLATE = registerBlock("lime_terracotta_pressure_plate", p -> new PressurePlateBlock(TTBlockSetTypes.TERRACOTTA, p), pressurePlateProps());
    public static final RegistryHandler.Blocks<PressurePlateBlock> PINK_TERRACOTTA_PRESSURE_PLATE = registerBlock("pink_terracotta_pressure_plate", p -> new PressurePlateBlock(TTBlockSetTypes.TERRACOTTA, p), pressurePlateProps());
    public static final RegistryHandler.Blocks<PressurePlateBlock> GRAY_TERRACOTTA_PRESSURE_PLATE = registerBlock("gray_terracotta_pressure_plate", p -> new PressurePlateBlock(TTBlockSetTypes.TERRACOTTA, p), pressurePlateProps());
    public static final RegistryHandler.Blocks<PressurePlateBlock> LIGHT_GRAY_TERRACOTTA_PRESSURE_PLATE = registerBlock("light_gray_terracotta_pressure_plate", p -> new PressurePlateBlock(TTBlockSetTypes.TERRACOTTA, p), pressurePlateProps());
    public static final RegistryHandler.Blocks<PressurePlateBlock> CYAN_TERRACOTTA_PRESSURE_PLATE = registerBlock("cyan_terracotta_pressure_plate", p -> new PressurePlateBlock(TTBlockSetTypes.TERRACOTTA, p), pressurePlateProps());
    public static final RegistryHandler.Blocks<PressurePlateBlock> PURPLE_TERRACOTTA_PRESSURE_PLATE = registerBlock("purple_terracotta_pressure_plate", p -> new PressurePlateBlock(TTBlockSetTypes.TERRACOTTA, p), pressurePlateProps());
    public static final RegistryHandler.Blocks<PressurePlateBlock> BLUE_TERRACOTTA_PRESSURE_PLATE = registerBlock("blue_terracotta_pressure_plate", p -> new PressurePlateBlock(TTBlockSetTypes.TERRACOTTA, p), pressurePlateProps());
    public static final RegistryHandler.Blocks<PressurePlateBlock> BROWN_TERRACOTTA_PRESSURE_PLATE = registerBlock("brown_terracotta_pressure_plate", p -> new PressurePlateBlock(TTBlockSetTypes.TERRACOTTA, p), pressurePlateProps());
    public static final RegistryHandler.Blocks<PressurePlateBlock> GREEN_TERRACOTTA_PRESSURE_PLATE = registerBlock("green_terracotta_pressure_plate", p -> new PressurePlateBlock(TTBlockSetTypes.TERRACOTTA, p), pressurePlateProps());
    public static final RegistryHandler.Blocks<PressurePlateBlock> RED_TERRACOTTA_PRESSURE_PLATE = registerBlock("red_terracotta_pressure_plate", p -> new PressurePlateBlock(TTBlockSetTypes.TERRACOTTA, p), pressurePlateProps());
    public static final RegistryHandler.Blocks<PressurePlateBlock> BLACK_TERRACOTTA_PRESSURE_PLATE = registerBlock("black_terracotta_pressure_plate", p -> new PressurePlateBlock(TTBlockSetTypes.TERRACOTTA, p), pressurePlateProps());

    public static final RegistryHandler.Blocks<StairBlock> TERRACOTTA_STAIRS = registerBlock("terracotta_stairs", p -> new StairBlock(Blocks.TERRACOTTA.defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA));
    public static final RegistryHandler.Blocks<StairBlock> WHITE_TERRACOTTA_STAIRS = registerBlock("white_terracotta_stairs", p -> new StairBlock(Blocks.WHITE_TERRACOTTA.defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_TERRACOTTA));
    public static final RegistryHandler.Blocks<StairBlock> ORANGE_TERRACOTTA_STAIRS = registerBlock("orange_terracotta_stairs", p -> new StairBlock(Blocks.ORANGE_TERRACOTTA.defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_TERRACOTTA));
    public static final RegistryHandler.Blocks<StairBlock> MAGENTA_TERRACOTTA_STAIRS = registerBlock("magenta_terracotta_stairs", p -> new StairBlock(Blocks.MAGENTA_TERRACOTTA.defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_TERRACOTTA));
    public static final RegistryHandler.Blocks<StairBlock> LIGHT_BLUE_TERRACOTTA_STAIRS = registerBlock("light_blue_terracotta_stairs", p -> new StairBlock(Blocks.LIGHT_BLUE_TERRACOTTA.defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_TERRACOTTA));
    public static final RegistryHandler.Blocks<StairBlock> YELLOW_TERRACOTTA_STAIRS = registerBlock("yellow_terracotta_stairs", p -> new StairBlock(Blocks.YELLOW_TERRACOTTA.defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_TERRACOTTA));
    public static final RegistryHandler.Blocks<StairBlock> LIME_TERRACOTTA_STAIRS = registerBlock("lime_terracotta_stairs", p -> new StairBlock(Blocks.LIME_TERRACOTTA.defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_TERRACOTTA));
    public static final RegistryHandler.Blocks<StairBlock> PINK_TERRACOTTA_STAIRS = registerBlock("pink_terracotta_stairs", p -> new StairBlock(Blocks.PINK_TERRACOTTA.defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_TERRACOTTA));
    public static final RegistryHandler.Blocks<StairBlock> GRAY_TERRACOTTA_STAIRS = registerBlock("gray_terracotta_stairs", p -> new StairBlock(Blocks.GRAY_TERRACOTTA.defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_TERRACOTTA));
    public static final RegistryHandler.Blocks<StairBlock> LIGHT_GRAY_TERRACOTTA_STAIRS = registerBlock("light_gray_terracotta_stairs", p -> new StairBlock(Blocks.LIGHT_GRAY_TERRACOTTA.defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_TERRACOTTA));
    public static final RegistryHandler.Blocks<StairBlock> CYAN_TERRACOTTA_STAIRS = registerBlock("cyan_terracotta_stairs", p -> new StairBlock(Blocks.CYAN_TERRACOTTA.defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_TERRACOTTA));
    public static final RegistryHandler.Blocks<StairBlock> PURPLE_TERRACOTTA_STAIRS = registerBlock("purple_terracotta_stairs", p -> new StairBlock(Blocks.PURPLE_TERRACOTTA.defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_TERRACOTTA));
    public static final RegistryHandler.Blocks<StairBlock> BLUE_TERRACOTTA_STAIRS = registerBlock("blue_terracotta_stairs", p -> new StairBlock(Blocks.BLUE_TERRACOTTA.defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_TERRACOTTA));
    public static final RegistryHandler.Blocks<StairBlock> BROWN_TERRACOTTA_STAIRS = registerBlock("brown_terracotta_stairs", p -> new StairBlock(Blocks.BROWN_TERRACOTTA.defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_TERRACOTTA));
    public static final RegistryHandler.Blocks<StairBlock> GREEN_TERRACOTTA_STAIRS = registerBlock("green_terracotta_stairs", p -> new StairBlock(Blocks.GREEN_TERRACOTTA.defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_TERRACOTTA));
    public static final RegistryHandler.Blocks<StairBlock> RED_TERRACOTTA_STAIRS = registerBlock("red_terracotta_stairs", p -> new StairBlock(Blocks.RED_TERRACOTTA.defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(Blocks.RED_TERRACOTTA));
    public static final RegistryHandler.Blocks<StairBlock> BLACK_TERRACOTTA_STAIRS = registerBlock("black_terracotta_stairs", p -> new StairBlock(Blocks.BLACK_TERRACOTTA.defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_TERRACOTTA));

    public static final RegistryHandler.Blocks<SlabBlock> TERRACOTTA_SLAB = registerBlock("terracotta_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA));
    public static final RegistryHandler.Blocks<SlabBlock> WHITE_TERRACOTTA_SLAB = registerBlock("white_terracotta_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_TERRACOTTA));
    public static final RegistryHandler.Blocks<SlabBlock> ORANGE_TERRACOTTA_SLAB = registerBlock("orange_terracotta_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_TERRACOTTA));
    public static final RegistryHandler.Blocks<SlabBlock> MAGENTA_TERRACOTTA_SLAB = registerBlock("magenta_terracotta_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_TERRACOTTA));
    public static final RegistryHandler.Blocks<SlabBlock> LIGHT_BLUE_TERRACOTTA_SLAB = registerBlock("light_blue_terracotta_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_TERRACOTTA));
    public static final RegistryHandler.Blocks<SlabBlock> YELLOW_TERRACOTTA_SLAB = registerBlock("yellow_terracotta_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_TERRACOTTA));
    public static final RegistryHandler.Blocks<SlabBlock> LIME_TERRACOTTA_SLAB = registerBlock("lime_terracotta_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_TERRACOTTA));
    public static final RegistryHandler.Blocks<SlabBlock> PINK_TERRACOTTA_SLAB = registerBlock("pink_terracotta_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_TERRACOTTA));
    public static final RegistryHandler.Blocks<SlabBlock> GRAY_TERRACOTTA_SLAB = registerBlock("gray_terracotta_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_TERRACOTTA));
    public static final RegistryHandler.Blocks<SlabBlock> LIGHT_GRAY_TERRACOTTA_SLAB = registerBlock("light_gray_terracotta_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_TERRACOTTA));
    public static final RegistryHandler.Blocks<SlabBlock> CYAN_TERRACOTTA_SLAB = registerBlock("cyan_terracotta_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_TERRACOTTA));
    public static final RegistryHandler.Blocks<SlabBlock> PURPLE_TERRACOTTA_SLAB = registerBlock("purple_terracotta_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_TERRACOTTA));
    public static final RegistryHandler.Blocks<SlabBlock> BLUE_TERRACOTTA_SLAB = registerBlock("blue_terracotta_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_TERRACOTTA));
    public static final RegistryHandler.Blocks<SlabBlock> BROWN_TERRACOTTA_SLAB = registerBlock("brown_terracotta_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_TERRACOTTA));
    public static final RegistryHandler.Blocks<SlabBlock> GREEN_TERRACOTTA_SLAB = registerBlock("green_terracotta_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_TERRACOTTA));
    public static final RegistryHandler.Blocks<SlabBlock> RED_TERRACOTTA_SLAB = registerBlock("red_terracotta_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_TERRACOTTA));
    public static final RegistryHandler.Blocks<SlabBlock> BLACK_TERRACOTTA_SLAB = registerBlock("black_terracotta_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_TERRACOTTA));

    public static final RegistryHandler.Blocks<WallBlock> TERRACOTTA_WALL = registerBlock("terracotta_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA));
    public static final RegistryHandler.Blocks<WallBlock> WHITE_TERRACOTTA_WALL = registerBlock("white_terracotta_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_TERRACOTTA));
    public static final RegistryHandler.Blocks<WallBlock> ORANGE_TERRACOTTA_WALL = registerBlock("orange_terracotta_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_TERRACOTTA));
    public static final RegistryHandler.Blocks<WallBlock> MAGENTA_TERRACOTTA_WALL = registerBlock("magenta_terracotta_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_TERRACOTTA));
    public static final RegistryHandler.Blocks<WallBlock> LIGHT_BLUE_TERRACOTTA_WALL = registerBlock("light_blue_terracotta_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_TERRACOTTA));
    public static final RegistryHandler.Blocks<WallBlock> YELLOW_TERRACOTTA_WALL = registerBlock("yellow_terracotta_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_TERRACOTTA));
    public static final RegistryHandler.Blocks<WallBlock> LIME_TERRACOTTA_WALL = registerBlock("lime_terracotta_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_TERRACOTTA));
    public static final RegistryHandler.Blocks<WallBlock> PINK_TERRACOTTA_WALL = registerBlock("pink_terracotta_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_TERRACOTTA));
    public static final RegistryHandler.Blocks<WallBlock> GRAY_TERRACOTTA_WALL = registerBlock("gray_terracotta_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_TERRACOTTA));
    public static final RegistryHandler.Blocks<WallBlock> LIGHT_GRAY_TERRACOTTA_WALL = registerBlock("light_gray_terracotta_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_TERRACOTTA));
    public static final RegistryHandler.Blocks<WallBlock> CYAN_TERRACOTTA_WALL = registerBlock("cyan_terracotta_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_TERRACOTTA));
    public static final RegistryHandler.Blocks<WallBlock> PURPLE_TERRACOTTA_WALL = registerBlock("purple_terracotta_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_TERRACOTTA));
    public static final RegistryHandler.Blocks<WallBlock> BLUE_TERRACOTTA_WALL = registerBlock("blue_terracotta_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_TERRACOTTA));
    public static final RegistryHandler.Blocks<WallBlock> BROWN_TERRACOTTA_WALL = registerBlock("brown_terracotta_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_TERRACOTTA));
    public static final RegistryHandler.Blocks<WallBlock> GREEN_TERRACOTTA_WALL = registerBlock("green_terracotta_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_TERRACOTTA));
    public static final RegistryHandler.Blocks<WallBlock> RED_TERRACOTTA_WALL = registerBlock("red_terracotta_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_TERRACOTTA));
    public static final RegistryHandler.Blocks<WallBlock> BLACK_TERRACOTTA_WALL = registerBlock("black_terracotta_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_TERRACOTTA));

    public static final RegistryHandler.Blocks<ButtonBlock> WHITE_GLAZED_TERRACOTTA_BUTTON = registerBlock("white_glazed_terracotta_button", p -> new ButtonBlock(TTBlockSetTypes.TERRACOTTA, 20, p), buttonProps());
    public static final RegistryHandler.Blocks<ButtonBlock> ORANGE_GLAZED_TERRACOTTA_BUTTON = registerBlock("orange_glazed_terracotta_button", p -> new ButtonBlock(TTBlockSetTypes.TERRACOTTA, 20, p), buttonProps());
    public static final RegistryHandler.Blocks<ButtonBlock> MAGENTA_GLAZED_TERRACOTTA_BUTTON = registerBlock("magenta_glazed_terracotta_button", p -> new ButtonBlock(TTBlockSetTypes.TERRACOTTA, 20, p), buttonProps());
    public static final RegistryHandler.Blocks<ButtonBlock> LIGHT_BLUE_GLAZED_TERRACOTTA_BUTTON = registerBlock("light_blue_glazed_terracotta_button", p -> new ButtonBlock(TTBlockSetTypes.TERRACOTTA, 20, p), buttonProps());
    public static final RegistryHandler.Blocks<ButtonBlock> YELLOW_GLAZED_TERRACOTTA_BUTTON = registerBlock("yellow_glazed_terracotta_button", p -> new ButtonBlock(TTBlockSetTypes.TERRACOTTA, 20, p), buttonProps());
    public static final RegistryHandler.Blocks<ButtonBlock> LIME_GLAZED_TERRACOTTA_BUTTON = registerBlock("lime_glazed_terracotta_button", p -> new ButtonBlock(TTBlockSetTypes.TERRACOTTA, 20, p), buttonProps());
    public static final RegistryHandler.Blocks<ButtonBlock> PINK_GLAZED_TERRACOTTA_BUTTON = registerBlock("pink_glazed_terracotta_button", p -> new ButtonBlock(TTBlockSetTypes.TERRACOTTA, 20, p), buttonProps());
    public static final RegistryHandler.Blocks<ButtonBlock> GRAY_GLAZED_TERRACOTTA_BUTTON = registerBlock("gray_glazed_terracotta_button", p -> new ButtonBlock(TTBlockSetTypes.TERRACOTTA, 20, p), buttonProps());
    public static final RegistryHandler.Blocks<ButtonBlock> LIGHT_GRAY_GLAZED_TERRACOTTA_BUTTON = registerBlock("light_gray_glazed_terracotta_button", p -> new ButtonBlock(TTBlockSetTypes.TERRACOTTA, 20, p), buttonProps());
    public static final RegistryHandler.Blocks<ButtonBlock> CYAN_GLAZED_TERRACOTTA_BUTTON = registerBlock("cyan_glazed_terracotta_button", p -> new ButtonBlock(TTBlockSetTypes.TERRACOTTA, 20, p), buttonProps());
    public static final RegistryHandler.Blocks<ButtonBlock> PURPLE_GLAZED_TERRACOTTA_BUTTON = registerBlock("purple_glazed_terracotta_button", p -> new ButtonBlock(TTBlockSetTypes.TERRACOTTA, 20, p), buttonProps());
    public static final RegistryHandler.Blocks<ButtonBlock> BLUE_GLAZED_TERRACOTTA_BUTTON = registerBlock("blue_glazed_terracotta_button", p -> new ButtonBlock(TTBlockSetTypes.TERRACOTTA, 20, p), buttonProps());
    public static final RegistryHandler.Blocks<ButtonBlock> BROWN_GLAZED_TERRACOTTA_BUTTON = registerBlock("brown_glazed_terracotta_button", p -> new ButtonBlock(TTBlockSetTypes.TERRACOTTA, 20, p), buttonProps());
    public static final RegistryHandler.Blocks<ButtonBlock> GREEN_GLAZED_TERRACOTTA_BUTTON = registerBlock("green_glazed_terracotta_button", p -> new ButtonBlock(TTBlockSetTypes.TERRACOTTA, 20, p), buttonProps());
    public static final RegistryHandler.Blocks<ButtonBlock> RED_GLAZED_TERRACOTTA_BUTTON = registerBlock("red_glazed_terracotta_button", p -> new ButtonBlock(TTBlockSetTypes.TERRACOTTA, 20, p), buttonProps());
    public static final RegistryHandler.Blocks<ButtonBlock> BLACK_GLAZED_TERRACOTTA_BUTTON = registerBlock("black_glazed_terracotta_button", p -> new ButtonBlock(TTBlockSetTypes.TERRACOTTA, 20, p), buttonProps());

    public static final RegistryHandler.Blocks<PressurePlateBlock> WHITE_GLAZED_TERRACOTTA_PRESSURE_PLATE = registerBlock("white_glazed_terracotta_pressure_plate", p -> new PressurePlateBlock(TTBlockSetTypes.TERRACOTTA, p), pressurePlateProps());
    public static final RegistryHandler.Blocks<PressurePlateBlock> ORANGE_GLAZED_TERRACOTTA_PRESSURE_PLATE = registerBlock("orange_glazed_terracotta_pressure_plate", p -> new PressurePlateBlock(TTBlockSetTypes.TERRACOTTA, p), pressurePlateProps());
    public static final RegistryHandler.Blocks<PressurePlateBlock> MAGENTA_GLAZED_TERRACOTTA_PRESSURE_PLATE = registerBlock("magenta_glazed_terracotta_pressure_plate", p -> new PressurePlateBlock(TTBlockSetTypes.TERRACOTTA, p), pressurePlateProps());
    public static final RegistryHandler.Blocks<PressurePlateBlock> LIGHT_BLUE_GLAZED_TERRACOTTA_PRESSURE_PLATE = registerBlock("light_blue_glazed_terracotta_pressure_plate", p -> new PressurePlateBlock(TTBlockSetTypes.TERRACOTTA, p), pressurePlateProps());
    public static final RegistryHandler.Blocks<PressurePlateBlock> YELLOW_GLAZED_TERRACOTTA_PRESSURE_PLATE = registerBlock("yellow_glazed_terracotta_pressure_plate", p -> new PressurePlateBlock(TTBlockSetTypes.TERRACOTTA, p), pressurePlateProps());
    public static final RegistryHandler.Blocks<PressurePlateBlock> LIME_GLAZED_TERRACOTTA_PRESSURE_PLATE = registerBlock("lime_glazed_terracotta_pressure_plate", p -> new PressurePlateBlock(TTBlockSetTypes.TERRACOTTA, p), pressurePlateProps());
    public static final RegistryHandler.Blocks<PressurePlateBlock> PINK_GLAZED_TERRACOTTA_PRESSURE_PLATE = registerBlock("pink_glazed_terracotta_pressure_plate", p -> new PressurePlateBlock(TTBlockSetTypes.TERRACOTTA, p), pressurePlateProps());
    public static final RegistryHandler.Blocks<PressurePlateBlock> GRAY_GLAZED_TERRACOTTA_PRESSURE_PLATE = registerBlock("gray_glazed_terracotta_pressure_plate", p -> new PressurePlateBlock(TTBlockSetTypes.TERRACOTTA, p), pressurePlateProps());
    public static final RegistryHandler.Blocks<PressurePlateBlock> LIGHT_GRAY_GLAZED_TERRACOTTA_PRESSURE_PLATE = registerBlock("light_gray_glazed_terracotta_pressure_plate", p -> new PressurePlateBlock(TTBlockSetTypes.TERRACOTTA, p), pressurePlateProps());
    public static final RegistryHandler.Blocks<PressurePlateBlock> CYAN_GLAZED_TERRACOTTA_PRESSURE_PLATE = registerBlock("cyan_glazed_terracotta_pressure_plate", p -> new PressurePlateBlock(TTBlockSetTypes.TERRACOTTA, p), pressurePlateProps());
    public static final RegistryHandler.Blocks<PressurePlateBlock> PURPLE_GLAZED_TERRACOTTA_PRESSURE_PLATE = registerBlock("purple_glazed_terracotta_pressure_plate", p -> new PressurePlateBlock(TTBlockSetTypes.TERRACOTTA, p), pressurePlateProps());
    public static final RegistryHandler.Blocks<PressurePlateBlock> BLUE_GLAZED_TERRACOTTA_PRESSURE_PLATE = registerBlock("blue_glazed_terracotta_pressure_plate", p -> new PressurePlateBlock(TTBlockSetTypes.TERRACOTTA, p), pressurePlateProps());
    public static final RegistryHandler.Blocks<PressurePlateBlock> BROWN_GLAZED_TERRACOTTA_PRESSURE_PLATE = registerBlock("brown_glazed_terracotta_pressure_plate", p -> new PressurePlateBlock(TTBlockSetTypes.TERRACOTTA, p), pressurePlateProps());
    public static final RegistryHandler.Blocks<PressurePlateBlock> GREEN_GLAZED_TERRACOTTA_PRESSURE_PLATE = registerBlock("green_glazed_terracotta_pressure_plate", p -> new PressurePlateBlock(TTBlockSetTypes.TERRACOTTA, p), pressurePlateProps());
    public static final RegistryHandler.Blocks<PressurePlateBlock> RED_GLAZED_TERRACOTTA_PRESSURE_PLATE = registerBlock("red_glazed_terracotta_pressure_plate", p -> new PressurePlateBlock(TTBlockSetTypes.TERRACOTTA, p), pressurePlateProps());
    public static final RegistryHandler.Blocks<PressurePlateBlock> BLACK_GLAZED_TERRACOTTA_PRESSURE_PLATE = registerBlock("black_glazed_terracotta_pressure_plate", p -> new PressurePlateBlock(TTBlockSetTypes.TERRACOTTA, p), pressurePlateProps());

    public static final RegistryHandler.Blocks<StairBlock> WHITE_GLAZED_TERRACOTTA_STAIRS = registerBlock("white_glazed_terracotta_stairs", p -> new StairBlock(Blocks.WHITE_GLAZED_TERRACOTTA.defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_GLAZED_TERRACOTTA));
    public static final RegistryHandler.Blocks<StairBlock> ORANGE_GLAZED_TERRACOTTA_STAIRS = registerBlock("orange_glazed_terracotta_stairs", p -> new StairBlock(Blocks.ORANGE_GLAZED_TERRACOTTA.defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_GLAZED_TERRACOTTA));
    public static final RegistryHandler.Blocks<StairBlock> MAGENTA_GLAZED_TERRACOTTA_STAIRS = registerBlock("magenta_glazed_terracotta_stairs", p -> new StairBlock(Blocks.MAGENTA_GLAZED_TERRACOTTA.defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_GLAZED_TERRACOTTA));
    public static final RegistryHandler.Blocks<StairBlock> LIGHT_BLUE_GLAZED_TERRACOTTA_STAIRS = registerBlock("light_blue_glazed_terracotta_stairs", p -> new StairBlock(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA.defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA));
    public static final RegistryHandler.Blocks<StairBlock> YELLOW_GLAZED_TERRACOTTA_STAIRS = registerBlock("yellow_glazed_terracotta_stairs", p -> new StairBlock(Blocks.YELLOW_GLAZED_TERRACOTTA.defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_GLAZED_TERRACOTTA));
    public static final RegistryHandler.Blocks<StairBlock> LIME_GLAZED_TERRACOTTA_STAIRS = registerBlock("lime_glazed_terracotta_stairs", p -> new StairBlock(Blocks.LIME_GLAZED_TERRACOTTA.defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_GLAZED_TERRACOTTA));
    public static final RegistryHandler.Blocks<StairBlock> PINK_GLAZED_TERRACOTTA_STAIRS = registerBlock("pink_glazed_terracotta_stairs", p -> new StairBlock(Blocks.PINK_GLAZED_TERRACOTTA.defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_GLAZED_TERRACOTTA));
    public static final RegistryHandler.Blocks<StairBlock> GRAY_GLAZED_TERRACOTTA_STAIRS = registerBlock("gray_glazed_terracotta_stairs", p -> new StairBlock(Blocks.GRAY_GLAZED_TERRACOTTA.defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_GLAZED_TERRACOTTA));
    public static final RegistryHandler.Blocks<StairBlock> LIGHT_GRAY_GLAZED_TERRACOTTA_STAIRS = registerBlock("light_gray_glazed_terracotta_stairs", p -> new StairBlock(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA.defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA));
    public static final RegistryHandler.Blocks<StairBlock> CYAN_GLAZED_TERRACOTTA_STAIRS = registerBlock("cyan_glazed_terracotta_stairs", p -> new StairBlock(Blocks.CYAN_GLAZED_TERRACOTTA.defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_GLAZED_TERRACOTTA));
    public static final RegistryHandler.Blocks<StairBlock> PURPLE_GLAZED_TERRACOTTA_STAIRS = registerBlock("purple_glazed_terracotta_stairs", p -> new StairBlock(Blocks.PURPLE_GLAZED_TERRACOTTA.defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_GLAZED_TERRACOTTA));
    public static final RegistryHandler.Blocks<StairBlock> BLUE_GLAZED_TERRACOTTA_STAIRS = registerBlock("blue_glazed_terracotta_stairs", p -> new StairBlock(Blocks.BLUE_GLAZED_TERRACOTTA.defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_GLAZED_TERRACOTTA));
    public static final RegistryHandler.Blocks<StairBlock> BROWN_GLAZED_TERRACOTTA_STAIRS = registerBlock("brown_glazed_terracotta_stairs", p -> new StairBlock(Blocks.BROWN_GLAZED_TERRACOTTA.defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_GLAZED_TERRACOTTA));
    public static final RegistryHandler.Blocks<StairBlock> GREEN_GLAZED_TERRACOTTA_STAIRS = registerBlock("green_glazed_terracotta_stairs", p -> new StairBlock(Blocks.GREEN_GLAZED_TERRACOTTA.defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_GLAZED_TERRACOTTA));
    public static final RegistryHandler.Blocks<StairBlock> RED_GLAZED_TERRACOTTA_STAIRS = registerBlock("red_glazed_terracotta_stairs", p -> new StairBlock(Blocks.RED_GLAZED_TERRACOTTA.defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(Blocks.RED_GLAZED_TERRACOTTA));
    public static final RegistryHandler.Blocks<StairBlock> BLACK_GLAZED_TERRACOTTA_STAIRS = registerBlock("black_glazed_terracotta_stairs", p -> new StairBlock(Blocks.BLACK_GLAZED_TERRACOTTA.defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_GLAZED_TERRACOTTA));

    public static final RegistryHandler.Blocks<SlabBlock> WHITE_GLAZED_TERRACOTTA_SLAB = registerBlock("white_glazed_terracotta_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_GLAZED_TERRACOTTA));
    public static final RegistryHandler.Blocks<SlabBlock> ORANGE_GLAZED_TERRACOTTA_SLAB = registerBlock("orange_glazed_terracotta_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_GLAZED_TERRACOTTA));
    public static final RegistryHandler.Blocks<SlabBlock> MAGENTA_GLAZED_TERRACOTTA_SLAB = registerBlock("magenta_glazed_terracotta_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_GLAZED_TERRACOTTA));
    public static final RegistryHandler.Blocks<SlabBlock> LIGHT_BLUE_GLAZED_TERRACOTTA_SLAB = registerBlock("light_blue_glazed_terracotta_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA));
    public static final RegistryHandler.Blocks<SlabBlock> YELLOW_GLAZED_TERRACOTTA_SLAB = registerBlock("yellow_glazed_terracotta_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_GLAZED_TERRACOTTA));
    public static final RegistryHandler.Blocks<SlabBlock> LIME_GLAZED_TERRACOTTA_SLAB = registerBlock("lime_glazed_terracotta_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_GLAZED_TERRACOTTA));
    public static final RegistryHandler.Blocks<SlabBlock> PINK_GLAZED_TERRACOTTA_SLAB = registerBlock("pink_glazed_terracotta_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_GLAZED_TERRACOTTA));
    public static final RegistryHandler.Blocks<SlabBlock> GRAY_GLAZED_TERRACOTTA_SLAB = registerBlock("gray_glazed_terracotta_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_GLAZED_TERRACOTTA));
    public static final RegistryHandler.Blocks<SlabBlock> LIGHT_GRAY_GLAZED_TERRACOTTA_SLAB = registerBlock("light_gray_glazed_terracotta_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA));
    public static final RegistryHandler.Blocks<SlabBlock> CYAN_GLAZED_TERRACOTTA_SLAB = registerBlock("cyan_glazed_terracotta_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_GLAZED_TERRACOTTA));
    public static final RegistryHandler.Blocks<SlabBlock> PURPLE_GLAZED_TERRACOTTA_SLAB = registerBlock("purple_glazed_terracotta_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_GLAZED_TERRACOTTA));
    public static final RegistryHandler.Blocks<SlabBlock> BLUE_GLAZED_TERRACOTTA_SLAB = registerBlock("blue_glazed_terracotta_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_GLAZED_TERRACOTTA));
    public static final RegistryHandler.Blocks<SlabBlock> BROWN_GLAZED_TERRACOTTA_SLAB = registerBlock("brown_glazed_terracotta_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_GLAZED_TERRACOTTA));
    public static final RegistryHandler.Blocks<SlabBlock> GREEN_GLAZED_TERRACOTTA_SLAB = registerBlock("green_glazed_terracotta_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_GLAZED_TERRACOTTA));
    public static final RegistryHandler.Blocks<SlabBlock> RED_GLAZED_TERRACOTTA_SLAB = registerBlock("red_glazed_terracotta_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_GLAZED_TERRACOTTA));
    public static final RegistryHandler.Blocks<SlabBlock> BLACK_GLAZED_TERRACOTTA_SLAB = registerBlock("black_glazed_terracotta_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_GLAZED_TERRACOTTA));

    public static final RegistryHandler.Blocks<WallBlock> WHITE_GLAZED_TERRACOTTA_WALL = registerBlock("white_glazed_terracotta_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_GLAZED_TERRACOTTA));
    public static final RegistryHandler.Blocks<WallBlock> ORANGE_GLAZED_TERRACOTTA_WALL = registerBlock("orange_glazed_terracotta_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_GLAZED_TERRACOTTA));
    public static final RegistryHandler.Blocks<WallBlock> MAGENTA_GLAZED_TERRACOTTA_WALL = registerBlock("magenta_glazed_terracotta_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_GLAZED_TERRACOTTA));
    public static final RegistryHandler.Blocks<WallBlock> LIGHT_BLUE_GLAZED_TERRACOTTA_WALL = registerBlock("light_blue_glazed_terracotta_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA));
    public static final RegistryHandler.Blocks<WallBlock> YELLOW_GLAZED_TERRACOTTA_WALL = registerBlock("yellow_glazed_terracotta_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_GLAZED_TERRACOTTA));
    public static final RegistryHandler.Blocks<WallBlock> LIME_GLAZED_TERRACOTTA_WALL = registerBlock("lime_glazed_terracotta_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_GLAZED_TERRACOTTA));
    public static final RegistryHandler.Blocks<WallBlock> PINK_GLAZED_TERRACOTTA_WALL = registerBlock("pink_glazed_terracotta_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_GLAZED_TERRACOTTA));
    public static final RegistryHandler.Blocks<WallBlock> GRAY_GLAZED_TERRACOTTA_WALL = registerBlock("gray_glazed_terracotta_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_GLAZED_TERRACOTTA));
    public static final RegistryHandler.Blocks<WallBlock> LIGHT_GRAY_GLAZED_TERRACOTTA_WALL = registerBlock("light_gray_glazed_terracotta_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA));
    public static final RegistryHandler.Blocks<WallBlock> CYAN_GLAZED_TERRACOTTA_WALL = registerBlock("cyan_glazed_terracotta_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_GLAZED_TERRACOTTA));
    public static final RegistryHandler.Blocks<WallBlock> PURPLE_GLAZED_TERRACOTTA_WALL = registerBlock("purple_glazed_terracotta_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_GLAZED_TERRACOTTA));
    public static final RegistryHandler.Blocks<WallBlock> BLUE_GLAZED_TERRACOTTA_WALL = registerBlock("blue_glazed_terracotta_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_GLAZED_TERRACOTTA));
    public static final RegistryHandler.Blocks<WallBlock> BROWN_GLAZED_TERRACOTTA_WALL = registerBlock("brown_glazed_terracotta_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_GLAZED_TERRACOTTA));
    public static final RegistryHandler.Blocks<WallBlock> GREEN_GLAZED_TERRACOTTA_WALL = registerBlock("green_glazed_terracotta_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_GLAZED_TERRACOTTA));
    public static final RegistryHandler.Blocks<WallBlock> RED_GLAZED_TERRACOTTA_WALL = registerBlock("red_glazed_terracotta_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_GLAZED_TERRACOTTA));
    public static final RegistryHandler.Blocks<WallBlock> BLACK_GLAZED_TERRACOTTA_WALL = registerBlock("black_glazed_terracotta_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_GLAZED_TERRACOTTA));

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