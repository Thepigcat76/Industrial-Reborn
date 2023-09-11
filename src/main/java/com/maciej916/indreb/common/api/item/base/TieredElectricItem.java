package com.maciej916.indreb.common.api.item.base;

import com.maciej916.indreb.common.api.enums.EnergyTiers;
import com.maciej916.indreb.common.api.enums.EnergyType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Vanishable;

public abstract class TieredElectricItem extends BaseElectricItem implements Vanishable {
    private final Tier tier;

    public TieredElectricItem(Tier tier, Properties properties, int energyStored, int maxEnergy, EnergyType energyType, EnergyTiers energyTier) {
        super(properties, energyStored, maxEnergy, energyType, energyTier);
        this.tier = tier;
    }

    public Tier getTier() {
        return this.tier;
    }

    @Override
    public int getEnchantmentValue() {
        return this.tier.getEnchantmentValue();
    }

    @Override
    public boolean isValidRepairItem(ItemStack stack, ItemStack stack_2) {
        return this.tier.getRepairIngredient().test(stack_2) || super.isValidRepairItem(stack, stack_2);
    }

}
