package com.maciej916.indreb.common.api.tier.interfaces;

import com.maciej916.indreb.common.api.enums.EnergyTiers;

public interface BatteryBoxTier {
    int getEnergyCapacity();
    int getEnergyStored();
    EnergyTiers getEnergyTier();
}
