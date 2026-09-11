package com.coolerpromc.terracottathings.datagen;

import com.coolerpromc.terracottathings.Constants;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeProvider;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Set;

@EventBusSubscriber(modid = Constants.MODID)
public class TTDataGenerator {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event){
        TTBlockTagProvider blockTagProvider = event.createProvider(TTBlockTagProvider::new);

        event.createProvider(TTModelProvider::new);
        event.createProvider(TTLanguageProvider::new);
        event.createReloadableRegistryObjects(new RegistrySetBuilder()
            .add(RecipeProvider.asBootstrap(TTRecipeProvider::new))
            .add(Registries.LOOT_TABLE, new TTLootTableProvider()),
        Set.of("minecraft", Constants.MODID));
        event.createProvider((output, lookupProvider) -> new TTBlockItemTagProvider(output, lookupProvider, blockTagProvider.contentsGetter()));
    }
}
