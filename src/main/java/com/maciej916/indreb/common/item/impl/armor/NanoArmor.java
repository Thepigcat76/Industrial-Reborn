package com.maciej916.indreb.common.item.impl.armor;

import com.maciej916.indreb.common.api.enums.CustomArmorMaterial;
import com.maciej916.indreb.common.api.enums.EnergyTiers;
import com.maciej916.indreb.common.api.enums.EnergyType;
import com.maciej916.indreb.common.api.item.base.BaseElectricArmor;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;

public class NanoArmor extends BaseElectricArmor {

    public NanoArmor(ArmorItem.Type type) {
        super(CustomArmorMaterial.NANO, type, new Properties(), 0, 100000, EnergyType.RECEIVE, EnergyTiers.ADVANCED);
    }

}
