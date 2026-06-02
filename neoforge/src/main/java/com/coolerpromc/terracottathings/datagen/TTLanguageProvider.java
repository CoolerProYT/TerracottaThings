package com.coolerpromc.terracottathings.datagen;

import com.coolerpromc.terracottathings.Constants;
import com.coolerpromc.terracottathings.block.TTBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.DyeColor;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class TTLanguageProvider extends LanguageProvider {
    public TTLanguageProvider(PackOutput output) {
        super(output, Constants.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.terracottathings.terracotta_things", "Terracotta Things");

        add(TTBlocks.TERRACOTTA_BUTTON.get(),"Terracotta Button");
        add(TTBlocks.TERRACOTTA_PRESSURE_PLATE.get(),"Terracotta Pressure Plate");
        add(TTBlocks.TERRACOTTA_STAIRS.get(),"Terracotta Stairs");
        add(TTBlocks.TERRACOTTA_SLAB.get(),"Terracotta Slab");
        add(TTBlocks.TERRACOTTA_WALL.get(),"Terracotta Wall");

        for (DyeColor color : DyeColor.values()) {
            String title = toTitleCase(color.getName());

            add(TTBlocks.DYED_TERRACOTTA_BUTTONS.pick(color).get(),title + " Terracotta Button");
            add(TTBlocks.DYED_TERRACOTTA_PRESSURE_PLATES.pick(color).get(),title + " Terracotta Pressure Plate");
            add(TTBlocks.DYED_TERRACOTTA_STAIRS.pick(color).get(),title + " Terracotta Stairs");
            add(TTBlocks.DYED_TERRACOTTA_SLABS.pick(color).get(),title + " Terracotta Slab");
            add(TTBlocks.DYED_TERRACOTTA_WALLS.pick(color).get(),title + " Terracotta Wall");

            add(TTBlocks.GLAZED_TERRACOTTA_BUTTONS.pick(color).get(),title + " Glazed Terracotta Button");
            add(TTBlocks.GLAZED_TERRACOTTA_PRESSURE_PLATES.pick(color).get(),title + " Glazed Terracotta Pressure Plate");
            add(TTBlocks.GLAZED_TERRACOTTA_STAIRS.pick(color).get(),title + " Glazed Terracotta Stairs");
            add(TTBlocks.GLAZED_TERRACOTTA_SLABS.pick(color).get(),title + " Glazed Terracotta Slab");
            add(TTBlocks.GLAZED_TERRACOTTA_WALLS.pick(color).get(),title + " Glazed Terracotta Wall");
        }
    }

    private static String toTitleCase(String name) {
        String[] parts = name.split("_");
        StringBuilder sb = new StringBuilder();
        for (String part : parts) {
            if (!sb.isEmpty()) sb.append(' ');
            sb.append(Character.toUpperCase(part.charAt(0)));
            sb.append(part.substring(1));
        }
        return sb.toString();
    }
}