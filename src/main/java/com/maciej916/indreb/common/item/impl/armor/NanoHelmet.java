package com.maciej916.indreb.common.item.impl.armor;

import com.maciej916.indreb.common.api.interfaces.item.IArmorProperties;
import net.minecraft.world.entity.EquipmentSlot;

public class NanoHelmet extends NanoArmor implements IArmorProperties {

    public NanoHelmet() {
        super(Type.HELMET);
    }

    @Override
    public boolean supportsNightVision() {
        return true;
    }
}
