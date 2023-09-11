package com.maciej916.indreb.common.item.impl.tool;

import com.maciej916.indreb.common.api.enums.EnergyTiers;
import com.maciej916.indreb.common.api.enums.EnergyType;
import com.maciej916.indreb.common.api.item.base.BaseElectricItem;
import net.minecraft.world.item.Item;

public class ElectricTreetap extends BaseElectricItem {

    public ElectricTreetap(int energyStored, int maxEnergy, EnergyTiers energyTier) {
        super(new Item.Properties(), energyStored, maxEnergy, EnergyType.RECEIVE, energyTier);
    }

}
