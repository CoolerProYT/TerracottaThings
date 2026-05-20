package com.coolerpromc.terracottathings.platform;

import com.coolerpromc.terracottathings.Constants;
import com.coolerpromc.terracottathings.platform.services.IRegistryHelper;
import com.coolerpromc.terracottathings.platform.util.CreativeTabOutput;
import com.coolerpromc.terracottathings.platform.util.RegistryHandler;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
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

public class FabricRegistryHelper implements IRegistryHelper {
    @Override
    public <T extends Block> RegistryHandler.Blocks<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> func, BlockBehaviour.Properties p) {
        Identifier id = Constants.id(name);
        Holder<T> holder = Registry.registerForHolder(BuiltInRegistries.BLOCK, id, func.apply(p.setId(IRegistryHelper.blockKey(name))));

        return new RegistryHandler.Blocks<>(){
            @Override
            public T get() {
                return holder.value();
            }

            @Override
            public Identifier id() {
                return id;
            }

            @Override
            public Holder<T> holder() {
                return holder;
            }
        };
    }

    @Override
    public <T extends Item> RegistryHandler.Items<T> registerItem(String name, Function<Item.Properties, T> func, Item.Properties p) {
        Identifier id = Constants.id(name);
        Holder<T> holder = Registry.registerForHolder(BuiltInRegistries.ITEM, id, func.apply(p.setId(IRegistryHelper.itemKey(name))));

        return new RegistryHandler.Items<>() {
            @Override
            public Identifier id() {
                return id;
            }

            @Override
            public Holder<T> holder() {
                return holder;
            }

            @Override
            public T get() {
                return holder.value();
            }
        };
    }

    @Override
    public <T extends BlockItem> RegistryHandler.Items<T> registerBlockItem(String name, RegistryHandler.Blocks<? extends Block> block, BiFunction<Block, Item.Properties, T> item) {
        return registerItem(name, properties -> item.apply(block.get(), properties));
    }

    @Override
    public RegistryHandler<CreativeModeTab> registerCreativeTab(String name, Supplier<ItemStack> icon, Component title, BiConsumer<CreativeTabOutput, CreativeModeTab.ItemDisplayParameters> entries) {
        Identifier id = Constants.id(name);
        Holder<CreativeModeTab> holder = Registry.registerForHolder(BuiltInRegistries.CREATIVE_MODE_TAB, id, FabricCreativeModeTab.builder()
                .icon(icon)
                .title(title)
                .displayItems((parameters, output) -> entries.accept(output::accept, parameters))
                .build());

        return new RegistryHandler<>() {
            @Override
            public Identifier id() {
                return id;
            }

            @Override
            public Holder<CreativeModeTab> holder() {
                return holder;
            }

            @Override
            public CreativeModeTab get() {
                return holder.value();
            }
        };
    }
}
