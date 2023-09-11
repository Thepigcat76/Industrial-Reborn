package com.maciej916.indreb.common.api.tier.interfaces;

import com.maciej916.indreb.common.api.enums.interfaces.EnergyTier;
import net.minecraft.world.level.block.Block;

public interface CableTier {
    CableTier get(EnergyTier energyTier);
    String getTier();
    boolean isInsulated();
    Block.Properties getProperties();
    EnergyTier getEnergyTier();
}
