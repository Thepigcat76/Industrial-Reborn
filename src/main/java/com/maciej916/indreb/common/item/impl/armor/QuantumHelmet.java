package com.maciej916.indreb.common.item.impl.armor;

import com.maciej916.indreb.common.api.interfaces.item.IArmorProperties;
import net.minecraft.world.entity.EquipmentSlot;

public class QuantumHelmet extends QuantumArmor implements IArmorProperties {

    public QuantumHelmet() {
        super(EquipmentSlot.HEAD, 4);
    }

    @Override
    public  boolean supportsQuantumAbility() {
        return true;
    }

}
