package com.coolerpromc.terracottathings.platform;

import com.coolerpromc.terracottathings.Constants;
import com.coolerpromc.terracottathings.platform.services.IRegistryHelper;
import com.coolerpromc.terracottathings.platform.util.CreativeTabOutput;
import com.coolerpromc.terracottathings.platform.util.RegistryHandler;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class NeoForgeRegistryHelper implements IRegistryHelper {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Constants.MODID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Constants.MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Constants.MODID);

    @Override
    public <T extends Block> RegistryHandler.Blocks<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> func, BlockBehaviour.Properties p) {
        DeferredBlock<T> deferredBlock = BLOCKS.registerBlock(name, func, () -> p);

        return new RegistryHandler.Blocks<>() {
            @Override
            public Identifier id() {
                return deferredBlock.getId();
            }

            @Override
            public Holder<T> holder() {
                return (Holder<T>) deferredBlock.getDelegate();
            }

            @Override
            public T get() {
                return deferredBlock.get();
            }
        };
    }

    @Override
    public <T extends Item> RegistryHandler.Items<T> registerItem(String name, Function<Item.Properties, T> func, Item.Properties p) {
        DeferredItem<T> deferredItem = ITEMS.registerItem(name, func, () -> p);

        return new RegistryHandler.Items<>() {
            @Override
            public Identifier id() {
                return deferredItem.getId();
            }

            @Override
            public Holder<T> holder() {
                return (Holder<T>) deferredItem.getDelegate();
            }

            @Override
            public T get() {
                return deferredItem.get();
            }
        };
    }

    @Override
    public <T extends BlockItem> RegistryHandler.Items<T> registerBlockItem(String name, RegistryHandler.Blocks<? extends Block> block, BiFunction<Block, Item.Properties, T> item) {
        return registerItem(name, properties -> item.apply(block.get(), properties));
    }

    @Override
    public RegistryHandler<CreativeModeTab, CreativeModeTab> registerCreativeTab(String name, Supplier<ItemStack> icon, Component title, BiConsumer<CreativeTabOutput, CreativeModeTab.ItemDisplayParameters> entries) {
        DeferredHolder<CreativeModeTab, CreativeModeTab> deferredHolder = CREATIVE_TABS.register(name, () -> CreativeModeTab.builder().icon(icon).title(title).displayItems((params, output) -> entries.accept(output::accept, params)).build());

        return new RegistryHandler<>() {
            @Override
            public Identifier id() {
                return deferredHolder.getId();
            }

            @Override
            public Holder<CreativeModeTab> holder() {
                return deferredHolder.getDelegate();
            }

            @Override
            public CreativeModeTab get() {
                return deferredHolder.get();
            }
        };
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
        CREATIVE_TABS.register(eventBus);
    }
}
