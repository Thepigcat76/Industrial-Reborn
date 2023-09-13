package com.maciej916.indreb.common.item.impl.armor;

import com.maciej916.indreb.common.api.interfaces.item.IArmorProperties;
import net.minecraft.world.entity.EquipmentSlot;

public class QuantumChestplate extends QuantumArmor implements IArmorProperties {

    public QuantumChestplate() {
        super(Type.CHESTPLATE, 4);
    }

    @Override
    public  boolean supportsQuantumAbility() {
        return true;
    }
}