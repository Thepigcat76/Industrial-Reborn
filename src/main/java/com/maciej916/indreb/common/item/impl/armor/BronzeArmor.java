package com.maciej916.indreb.common.item.impl.armor;

import com.maciej916.indreb.common.api.enums.CustomArmorMaterial;
import com.maciej916.indreb.common.api.interfaces.item.IArmorProperties;
import net.minecraft.world.item.ArmorItem;

public class BronzeArmor extends ArmorItem implements IArmorProperties {

    public BronzeArmor(ArmorItem.Type type) {
        super(CustomArmorMaterial.BRONZE, type, new Properties());
    }

}
