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
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ForgeRegistryHelper implements IRegistryHelper {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Constants.MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Constants.MODID);

    @Override
    public <T extends Block> RegistryHandler.Blocks<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> func, BlockBehaviour.Properties p) {
        RegistryObject<T> deferredBlock = BLOCKS.register(name, () -> func.apply(p.setId(IRegistryHelper.blockKey(name))));

        return new RegistryHandler.Blocks<>() {
            @Override
            public Identifier id() {
                return deferredBlock.getId();
            }

            @Override
            public Holder<T> holder() {
                return deferredBlock.getHolder().orElse(null);
            }

            @Override
            public T get() {
                return deferredBlock.get();
            }
        };
    }

    @Override
    public <T extends Item> RegistryHandler.Items<T> registerItem(String name, Function<Item.Properties, T> func, Item.Properties p) {
        RegistryObject<T> deferredItem = ITEMS.register(name, () -> func.apply(p.setId(IRegistryHelper.itemKey(name))));

        return new RegistryHandler.Items<>() {
            @Override
            public Identifier id() {
                return deferredItem.getId();
            }

            @Override
            public Holder<T> holder() {
                return deferredItem.getHolder().orElse(null);
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
    public RegistryHandler<CreativeModeTab> registerCreativeTab(String name, Supplier<ItemStack> icon, Component title, BiConsumer<CreativeTabOutput, CreativeModeTab.ItemDisplayParameters> entries) {
        RegistryObject<CreativeModeTab> deferredHolder = CREATIVE_TABS.register(name, () -> CreativeModeTab.builder().icon(icon).title(title).displayItems((params, output) -> entries.accept(output::accept, params)).build());

        return new RegistryHandler<>() {
            @Override
            public Identifier id() {
                return deferredHolder.getId();
            }

            @Override
            public Holder<CreativeModeTab> holder() {
                return deferredHolder.getHolder().orElse(null);
            }

            @Override
            public CreativeModeTab get() {
                return deferredHolder.get();
            }
        };
    }

    public static void register(BusGroup busGroup){
        BLOCKS.register(busGroup);
        ITEMS.register(busGroup);
        CREATIVE_TABS.register(busGroup);
    }
}
