package com.coolerpromc.terracottathings.datagen;

import com.coolerpromc.terracottathings.datagen.loot.TTBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class TTLootTableProvider extends LootTableProvider {
    public TTLootTableProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, Set.of(), List.of(new SubProviderEntry(TTBlockLootSubProvider::new, LootContextParamSets.BLOCK)), registries);
    }
}
