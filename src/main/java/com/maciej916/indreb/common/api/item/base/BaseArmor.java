package com.maciej916.indreb.common.api.item.base;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
@Deprecated
public abstract class BaseArmor extends ArmorItem {

    public BaseArmor(ArmorMaterial material, Type type) {
        super(material, type, new Properties());
    }

}
