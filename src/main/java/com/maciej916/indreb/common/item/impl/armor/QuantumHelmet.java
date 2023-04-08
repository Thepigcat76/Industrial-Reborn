package com.maciej916.indreb.common.item.impl.armor;

import com.maciej916.indreb.common.api.interfaces.item.IArmorProperties;
import net.minecraft.world.entity.EquipmentSlot;

public class QuantumHelmet extends QuantumArmor implements IArmorProperties {

    public QuantumHelmet() {
        super(EquipmentSlot.HEAD);
    }

    @Override
    public boolean supportsNightVision() {
        return true;
    }

}
