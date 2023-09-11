package com.maciej916.indreb.common.api.tier.interfaces;

import com.maciej916.indreb.common.api.enums.interfaces.EnergyTier;

public interface SolarPanelTier {
    int getTierLvl();
    EnergyTier getEnergyTier();
    String getTier();
    double getHeight();
    int getEnergyCapacity();

}
