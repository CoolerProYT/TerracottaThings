package com.coolerpromc.terracottathings.datagen;

import com.coolerpromc.terracottathings.Constants;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = Constants.MODID)
public class TTDataGenerator {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event){
        TTBlockTagProvider blockTagProvider = event.createProvider(TTBlockTagProvider::new);

        event.createProvider(TTModelProvider::new);
        event.createProvider(TTLanguageProvider::new);
        event.createProvider(TTLootTableProvider::new);
        event.createProvider(TTRecipeProvider.Runner::new);
        event.createProvider((output, lookupProvider) -> new TTBlockItemTagProvider(output, lookupProvider, blockTagProvider.contentsGetter()));
    }
}
