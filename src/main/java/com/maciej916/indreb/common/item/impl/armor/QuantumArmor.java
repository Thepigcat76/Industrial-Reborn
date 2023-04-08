package com.maciej916.indreb.common.item.impl.armor;

import com.maciej916.indreb.common.api.enums.CustomArmorMaterial;
import com.maciej916.indreb.common.api.enums.EnergyTier;
import com.maciej916.indreb.common.api.enums.EnergyType;
import com.maciej916.indreb.common.api.item.base.BaseElectricArmor;
import net.minecraft.world.entity.EquipmentSlot;

public class QuantumArmor extends BaseElectricArmor {

    public QuantumArmor(EquipmentSlot slot) {
        super(CustomArmorMaterial.QUANTUM, slot, new Properties(), 0, 1000000, EnergyType.RECEIVE, EnergyTier.ULTRA);
    }

}
