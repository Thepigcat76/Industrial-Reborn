package com.maciej916.indreb.common.api.tier;

import com.maciej916.indreb.common.api.enums.EnergyTiers;
import com.maciej916.indreb.common.api.tier.interfaces.BatteryBoxTier;
import com.maciej916.indreb.common.config.impl.ServerConfig;

public enum BatteryBoxTiers implements BatteryBoxTier {
    BASIC(EnergyTiers.BASIC, 0),
    STANDARD(EnergyTiers.STANDARD, 0),
    ADVANCED(EnergyTiers.ADVANCED, 0),
    SUPER(EnergyTiers.SUPER, 0);

    private final EnergyTiers energyTier;
    private final int energyStored;


    BatteryBoxTiers(EnergyTiers energyTier, int energyStored) {
        this.energyTier = energyTier;
        this.energyStored = energyStored;
    }

    @Override
    public EnergyTiers getEnergyTier() {
        return energyTier;
    }

    @Override
    public int getEnergyStored() {
        return energyStored;
    }

    @Override
    public int getEnergyCapacity() {
        return switch (energyTier) {
            case BASIC -> ServerConfig.wooden_battery_box_capacity.get();
            case STANDARD -> ServerConfig.cesu_capacity.get();
            case ADVANCED -> ServerConfig.mfe_capacity.get();
            case SUPER -> ServerConfig.mfsu_capacity.get();
            default -> ServerConfig.wooden_battery_box_capacity.get();
        };
    }
}
