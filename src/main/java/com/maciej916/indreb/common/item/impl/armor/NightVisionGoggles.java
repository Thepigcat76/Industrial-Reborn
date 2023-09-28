package com.maciej916.indreb.common.item.impl.armor;

import com.maciej916.indreb.common.api.enums.CustomArmorMaterial;
import com.maciej916.indreb.common.api.interfaces.item.IArmorProperties;
import net.minecraft.world.item.ArmorItem;

public class NightVisionGoggles extends ArmorItem implements IArmorProperties {

    public NightVisionGoggles() {
        super(CustomArmorMaterial.NIGHTVISION, Type.HELMET, new Properties());
    }

    @Override
    public boolean supportsNightVision() {
        return true;
    }
}
