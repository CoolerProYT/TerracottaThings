package com.coolerpromc.terracottathings.block.set;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class TTBlockSetTypes {
    public static final BlockSetType TERRACOTTA = new BlockSetType("terracotta", true, true, true, BlockSetType.PressurePlateSensitivity.MOBS, SoundType.STONE, SoundEvents.COPPER_DOOR_CLOSE, SoundEvents.COPPER_DOOR_OPEN, SoundEvents.COPPER_TRAPDOOR_CLOSE, SoundEvents.COPPER_TRAPDOOR_OPEN, SoundEvents.STONE_PRESSURE_PLATE_CLICK_OFF, SoundEvents.STONE_PRESSURE_PLATE_CLICK_ON, SoundEvents.STONE_BUTTON_CLICK_OFF, SoundEvents.STONE_BUTTON_CLICK_ON);
}
