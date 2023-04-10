package com.maciej916.indreb.common.item.impl.armor;

import com.maciej916.indreb.common.api.interfaces.item.IArmorProperties;
import net.minecraft.world.entity.EquipmentSlot;

public class QuantumBoots extends QuantumArmor implements IArmorProperties {

    public QuantumBoots() {
        super(EquipmentSlot.FEET, 4);
    }

    @Override
    public boolean supportsQuantumAbility() {
        return true;
    }
}