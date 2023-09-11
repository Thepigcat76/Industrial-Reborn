package com.maciej916.indreb.common.api.tier;

import com.maciej916.indreb.common.api.enums.EnergyTiers;

public enum TransformerTier {
    BASIC(EnergyTiers.BASIC, EnergyTiers.STANDARD),
    STANDARD(EnergyTiers.STANDARD, EnergyTiers.ADVANCED),
    ADVANCED(EnergyTiers.ADVANCED, EnergyTiers.SUPER),
    SUPER(EnergyTiers.SUPER, EnergyTiers.ULTRA);

    private final EnergyTiers minTier;
    private final EnergyTiers maxTier;

    TransformerTier(EnergyTiers minTier, EnergyTiers maxTier) {
        this.minTier = minTier;
        this.maxTier = maxTier;
    }

    public EnergyTiers getMinTier() {
        return minTier;
    }

    public EnergyTiers getMaxTier() {
        return maxTier;
    }
}
