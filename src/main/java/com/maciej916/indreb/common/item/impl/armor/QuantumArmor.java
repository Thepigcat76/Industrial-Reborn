package com.maciej916.indreb.common.item.impl.armor;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.maciej916.indreb.common.api.enums.CustomArmorMaterial;
import com.maciej916.indreb.common.api.enums.EnergyTier;
import com.maciej916.indreb.common.api.enums.EnergyType;
import com.maciej916.indreb.common.api.interfaces.item.IArmorProperties;
import com.maciej916.indreb.common.api.item.base.BaseElectricArmor;
import com.maciej916.indreb.common.attributes.ModAttributes;
import com.maciej916.indreb.common.capability.radiation.IHasRadiation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;

public class QuantumArmor extends BaseElectricArmor implements IArmorProperties, IHasRadiation {

    public final int radiationProtection;

    public QuantumArmor(EquipmentSlot slot, int radiationProtection) {
        super(CustomArmorMaterial.QUANTUM, slot, new Properties(), 0, 1000000, EnergyType.RECEIVE, EnergyTier.SUPER);
        this.radiationProtection = radiationProtection;
    }


    @Override
    public int getRadiationProtection() {
        return radiationProtection;
    }
}
