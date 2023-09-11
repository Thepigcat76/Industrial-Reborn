package com.maciej916.indreb.common.api.tier;

import com.maciej916.indreb.common.api.enums.EnergyTiers;
import com.maciej916.indreb.common.api.enums.interfaces.EnergyTier;
import com.maciej916.indreb.common.api.tier.interfaces.CableTier;
import com.maciej916.indreb.common.util.Constants;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;

public enum CableTiers implements CableTier {
    TIN_CABLE(EnergyTiers.BASIC, "tin_cable", false, Block.Properties.of().strength(0.8F, 0.8F).sound(SoundType.WOOL)),
    TIN_CABLE_INSULATED(EnergyTiers.BASIC, "tin_cable_insulated", true, Block.Properties.of().strength(0.8F, 0.8F).sound(SoundType.WOOL)),
    COPPER_CABLE(EnergyTiers.STANDARD, "copper_cable", false, Block.Properties.of().strength(0.8F, 0.8F).sound(SoundType.WOOL)),
    COPPER_CABLE_INSULATED(EnergyTiers.STANDARD, "copper_cable_insulated", true, Block.Properties.of().strength(0.8F, 0.8F).sound(SoundType.WOOL)),
    GOLD_CABLE(EnergyTiers.ADVANCED, "gold_cable", false, Block.Properties.of().strength(0.8F, 0.8F).sound(SoundType.WOOL)),
    GOLD_CABLE_INSULATED(EnergyTiers.ADVANCED, "gold_cable_insulated", true, Block.Properties.of().strength(0.8F, 0.8F).sound(SoundType.WOOL)),
    HV_CABLE(EnergyTiers.SUPER, "hv_cable", false, Block.Properties.of().strength(0.8F, 0.8F).sound(SoundType.WOOL)),
    HV_CABLE_INSULATED(EnergyTiers.SUPER, "hv_cable_insulated", true, Block.Properties.of().strength(0.8F, 0.8F).sound(SoundType.WOOL)),
    GLASS_FIBRE_CABLE(EnergyTiers.ULTRA, "glass_fibre_cable", true, Block.Properties.of().strength(0.8F, 0.8F).sound(SoundType.GLASS));

    private final EnergyTier energyTier;

    private final String tier;
    private final boolean insulated;
    private final Block.Properties properties;

    CableTiers(EnergyTier energyTier, String tier, boolean insulated, Block.Properties properties) {
        this.energyTier = energyTier;
        this.tier = tier;
        this.insulated = insulated;
        this.properties = properties;
    }

    @Override
    public EnergyTier getEnergyTier() {
        return energyTier;
    }

    @Override
    public CableTier get(EnergyTier tier) {
        for (CableTiers transmitter : Constants.CABLE_TIERS) {
            if (transmitter.getEnergyTier() == tier) {
                return transmitter;
            }
        }
        return TIN_CABLE;
    }

    @Override
    public String getTier() {
        return tier;
    }

    @Override
    public boolean isInsulated() {
        return insulated;
    }

    @Override
    public Block.Properties getProperties() {
        return properties;
    }

}
