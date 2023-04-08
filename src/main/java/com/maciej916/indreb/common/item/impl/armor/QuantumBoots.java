package com.maciej916.indreb.common.item.impl.armor;

import com.maciej916.indreb.common.api.interfaces.item.IArmorProperties;
import net.minecraft.world.entity.EquipmentSlot;

public class QuantumBoots extends QuantumArmor implements IArmorProperties {

    public QuantumBoots() {
        super(EquipmentSlot.FEET);
    }

    @Override
    public boolean supportsJumpBoost() {
        return true;
    }
}