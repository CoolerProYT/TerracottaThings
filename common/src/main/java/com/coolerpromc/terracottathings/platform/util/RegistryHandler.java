package com.coolerpromc.terracottathings.platform.util;

import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public interface RegistryHandler<R, T> extends Supplier<T> {
    Identifier id();
    Holder<T> holder();
    default ResourceKey<R> key(){
        return (ResourceKey<R>) holder().unwrapKey().orElse(null);
    }

    interface Items<I extends Item> extends RegistryHandler<Item, I>, ItemLike {
        default ItemStack toStack() {
            return get().getDefaultInstance();
        }

        @Override
        default Item asItem(){
            return get();
        }
    }

    interface Blocks<B extends Block> extends RegistryHandler<Block, B>, ItemLike {
        @Override
        default Item asItem(){
            return get().asItem();
        }

        default ItemStack toStack() {
            return asItem().getDefaultInstance();
        }
    }
}