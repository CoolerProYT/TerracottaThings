package com.coolerpromc.terracottathings;

import com.coolerpromc.terracottathings.platform.ForgeRegistryHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Constants.MODID)
public class ForgeTerracottaThings {

    public ForgeTerracottaThings(FMLJavaModLoadingContext context) {
        TerracottaThings.init();
        ForgeRegistryHelper.register(context.getModBusGroup());
    }
}