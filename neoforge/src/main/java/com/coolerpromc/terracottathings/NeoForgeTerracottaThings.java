package com.coolerpromc.terracottathings;


import com.coolerpromc.terracottathings.platform.NeoForgeRegistryHelper;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Constants.MODID)
public class NeoForgeTerracottaThings {
    public NeoForgeTerracottaThings(IEventBus eventBus) {
        TerracottaThings.init();
        NeoForgeRegistryHelper.register(eventBus);
    }
}