package com.maciej916.indreb.common.api.item.base;

import com.maciej916.indreb.common.api.enums.EnergyTiers;
import com.maciej916.indreb.common.api.enums.EnergyType;

public class EnergyStorageItem extends BaseElectricItem {

    public EnergyStorageItem(int energyStored, int maxEnergy, EnergyType energyType, EnergyTiers energyTier) {
        super(new Properties(), energyStored, maxEnergy, energyType, energyTier);
    }

}
