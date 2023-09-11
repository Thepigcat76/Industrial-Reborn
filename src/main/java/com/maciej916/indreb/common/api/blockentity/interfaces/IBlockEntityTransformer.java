package com.maciej916.indreb.common.api.blockentity.interfaces;

import com.maciej916.indreb.common.api.enums.EnergyTiers;

public interface IBlockEntityTransformer {

    EnergyTiers energyExtractTier();
    EnergyTiers energyReceiveTier();

}
