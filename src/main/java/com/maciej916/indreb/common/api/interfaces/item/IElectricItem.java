package com.maciej916.indreb.common.api.interfaces.item;

import com.maciej916.indreb.common.api.enums.EnergyTiers;
import com.maciej916.indreb.common.api.enums.EnergyType;
import com.maciej916.indreb.common.api.energy.interfaces.IEnergyStorage;
import net.minecraft.world.item.ItemStack;

public interface IElectricItem {

    EnergyTiers getEnergyTier();
    EnergyType getEnergyType();
    IEnergyStorage getEnergyStorage(ItemStack stack);
    default void tickElectric(ItemStack stack) {}

}
