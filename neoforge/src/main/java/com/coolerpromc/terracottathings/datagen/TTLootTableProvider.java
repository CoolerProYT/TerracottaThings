package com.coolerpromc.terracottathings.datagen;

import com.coolerpromc.terracottathings.datagen.loot.TTBlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class TTLootTableProvider extends LootTableProvider {
    public TTLootTableProvider() {
        super(Set.of(), List.of(new SubProviderEntry(TTBlockLootSubProvider::new, LootContextParamSets.BLOCK)));
    }
}
