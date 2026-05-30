package com.coolerpromc.terracottathings.item;

import com.coolerpromc.terracottathings.Constants;
import com.coolerpromc.terracottathings.block.TTBlocks;
import com.coolerpromc.terracottathings.platform.Services;
import com.coolerpromc.terracottathings.platform.util.RegistryHandler;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;

public class TTCreativeTabs {
    public static final RegistryHandler<CreativeModeTab> TERRACOTTA_THINGS = Services.REGISTRY.registerCreativeTab(
            "terracotta_things",
            TTBlocks.TERRACOTTA_BUTTON::toStack,
            Component.translatable("itemGroup.terracottathings.terracotta_things"),
            (output, params) -> {
                output.accept(TTBlocks.TERRACOTTA_BUTTON);
                TTBlocks.DYED_TERRACOTTA_BUTTONS.forEach(output::accept);
                TTBlocks.GLAZED_TERRACOTTA_BUTTONS.forEach(output::accept);
                output.accept(TTBlocks.TERRACOTTA_PRESSURE_PLATE);
                TTBlocks.DYED_TERRACOTTA_PRESSURE_PLATES.forEach(output::accept);
                TTBlocks.GLAZED_TERRACOTTA_PRESSURE_PLATES.forEach(output::accept);
                output.accept(TTBlocks.TERRACOTTA_STAIRS);
                TTBlocks.DYED_TERRACOTTA_STAIRS.forEach(output::accept);
                TTBlocks.GLAZED_TERRACOTTA_STAIRS.forEach(output::accept);
                output.accept(TTBlocks.TERRACOTTA_SLAB);
                TTBlocks.DYED_TERRACOTTA_SLABS.forEach(output::accept);
                TTBlocks.GLAZED_TERRACOTTA_SLABS.forEach(output::accept);
                output.accept(TTBlocks.TERRACOTTA_WALL);
                TTBlocks.DYED_TERRACOTTA_WALLS.forEach(output::accept);
                TTBlocks.GLAZED_TERRACOTTA_WALLS.forEach(output::accept);
            }
    );

    public static void init() {
        Constants.LOGGER.info("Registering TerracottaThings Creative Tabs.");
    }
}
