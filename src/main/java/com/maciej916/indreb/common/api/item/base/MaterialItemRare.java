package com.maciej916.indreb.common.api.item.base;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

@Deprecated
public class MaterialItemRare extends Item {

    public MaterialItemRare() {
        super(new Properties());
    }

    @Override
    public Rarity getRarity(ItemStack stack) {
        return Rarity.RARE;
    }
}
