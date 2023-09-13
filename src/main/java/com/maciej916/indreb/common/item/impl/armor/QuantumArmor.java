package com.maciej916.indreb.common.item.impl.armor;

import com.maciej916.indreb.common.api.enums.CustomArmorMaterial;
import com.maciej916.indreb.common.api.enums.EnergyTiers;
import com.maciej916.indreb.common.api.enums.EnergyType;
import com.maciej916.indreb.common.api.item.base.BaseElectricArmor;
import com.maciej916.indreb.common.capability.radiation.IHasRadiation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;

public class QuantumArmor extends BaseElectricArmor implements IHasRadiation {

    public final int radiationProtection;
    public QuantumArmor(ArmorItem.Type type, int radProtection) {
        super(CustomArmorMaterial.QUANTUM, type, new Properties(), 0, 1000000, EnergyType.RECEIVE, EnergyTiers.SUPER);
        this.radiationProtection = radProtection;
    }

    @Override
    public int getRadiationProtection() {
        return radiationProtection;
    }
}
