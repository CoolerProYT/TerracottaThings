package com.coolerpromc.terracottathings.platform.services;

import com.coolerpromc.terracottathings.Constants;
import com.coolerpromc.terracottathings.platform.util.CreativeTabOutput;
import com.coolerpromc.terracottathings.platform.util.RegistryHandler;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public interface IRegistryHelper {
    default <T extends Block> RegistryHandler.Blocks<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> func){
        return registerBlock(name, func, BlockBehaviour.Properties.of());
    }
    <T extends Block> RegistryHandler.Blocks<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> func, BlockBehaviour.Properties p);
    default <T extends Item> RegistryHandler.Items<T> registerItem(String name, Function<Item.Properties, T> func){
        return registerItem(name, func, new Item.Properties());
    }
    <T extends Item> RegistryHandler.Items<T> registerItem(String name, Function<Item.Properties, T> func, Item.Properties p);
    <T extends BlockItem> RegistryHandler.Items<T> registerBlockItem(String name, RegistryHandler.Blocks<? extends Block> block, BiFunction<Block, Item.Properties, T> item);
    RegistryHandler<CreativeModeTab> registerCreativeTab(String name, Supplier<ItemStack> icon, Component title, BiConsumer<CreativeTabOutput, CreativeModeTab.ItemDisplayParameters> entries);

    static ResourceKey<Block> blockKey(String name) {
        return ResourceKey.create(Registries.BLOCK, Constants.id(name));
    }
    static ResourceKey<Item> itemKey(String name) {
        return ResourceKey.create(Registries.ITEM, Constants.id(name));
    }
}
