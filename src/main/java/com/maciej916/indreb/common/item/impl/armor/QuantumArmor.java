package com.maciej916.indreb.common.item.impl.armor;

import com.maciej916.indreb.common.api.enums.CustomArmorMaterial;
import com.maciej916.indreb.common.api.enums.EnergyTier;
import com.maciej916.indreb.common.api.enums.EnergyType;
import com.maciej916.indreb.common.api.interfaces.item.IArmorProperties;
import com.maciej916.indreb.common.api.item.base.BaseElectricArmor;
import com.maciej916.indreb.common.capability.radiation.IHasRadiation;
import net.minecraft.world.entity.EquipmentSlot;

public class QuantumArmor extends BaseElectricArmor implements IHasRadiation {

    public final int radiationProtection;
    public QuantumArmor(EquipmentSlot slot, int radProtection) {
        super(CustomArmorMaterial.QUANTUM, slot, new Properties(), 0, 1000000, EnergyType.RECEIVE, EnergyTier.SUPER);
        this.radiationProtection = radProtection;
    }

    @Override
    public int getRadiationProtection() {
        return radiationProtection;
    }
}
