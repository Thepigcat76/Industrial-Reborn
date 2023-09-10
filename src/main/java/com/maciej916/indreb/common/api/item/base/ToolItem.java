package com.maciej916.indreb.common.api.item.base;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ToolItem extends Item {

    public ToolItem(int maxDamage) {
        super(new Properties().stacksTo(1).durability(maxDamage).setNoRepair());
    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return false;
    }

    @Override
    public boolean isRepairable(ItemStack stack) {
        return false;
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        ItemStack result = itemStack.copy();
        result.setDamageValue(itemStack.getDamageValue() + 1);
        return result.getDamageValue() >= result.getMaxDamage() ? ItemStack.EMPTY : result;
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }

}
