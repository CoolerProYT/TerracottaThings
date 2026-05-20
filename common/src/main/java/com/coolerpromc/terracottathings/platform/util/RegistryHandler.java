package com.coolerpromc.terracottathings.platform.util;

import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public interface RegistryHandler<T> extends Supplier<T> {
    Identifier id();
    Holder<T> holder();

    interface Items<I extends Item> extends RegistryHandler<I>, ItemLike {
        default ItemStack toStack() {
            return get().getDefaultInstance();
        }

        @Override
        default Item asItem(){
            return get();
        }
    }

    interface Blocks<B extends Block> extends RegistryHandler<B>, ItemLike {
        @Override
        default Item asItem(){
            return get().asItem();
        }

        default ItemStack toStack() {
            return asItem().getDefaultInstance();
        }
    }
}