package com.maciej916.indreb.common.api.item.base;

import com.maciej916.indreb.common.api.enums.UpgradeTypes;
import com.maciej916.indreb.common.api.interfaces.item.IItemUpgrade;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class BaseUpgradeItem extends Item implements IItemUpgrade {

    private final UpgradeTypes upgradeType;

    public BaseUpgradeItem(UpgradeTypes upgradeType) {
        super(new Properties().stacksTo(16));
        this.upgradeType = upgradeType;
    }

    @Override
    public UpgradeTypes getUpgradeType() {
        return upgradeType;
    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return false;
    }

    @Override
    public boolean isRepairable(ItemStack stack) {
        return false;
    }

}
