package com.maciej916.indreb.common.item.impl.armor;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.maciej916.indreb.common.api.enums.CustomArmorMaterial;
import com.maciej916.indreb.common.api.interfaces.item.IArmorProperties;
import com.maciej916.indreb.common.attributes.ModAttributes;
import com.maciej916.indreb.common.capability.radiation.IHasRadiation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;

public class RubberBoots extends ArmorItem implements IArmorProperties, IHasRadiation {

    public RubberBoots() {
        super(CustomArmorMaterial.RUBBER, Type.BOOTS, new Properties());
    }

    @Override
    public int getRadiationProtection() {
        return 1;
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        if (stack.getItem().equals(this)) {
            if (slot == getEquipmentSlot()) {
                Multimap<Attribute, AttributeModifier> modifiers = HashMultimap.create();
                modifiers.putAll(super.getAttributeModifiers(slot, stack));
                modifiers.put(ModAttributes.RADIATION_PROTECTION.get(), new AttributeModifier(ModAttributes.RADIATION_PROTECTION_MODIFIER.toString(), this.getRadiationProtection(), AttributeModifier.Operation.ADDITION));
                return modifiers;
            }
        }
        return super.getAttributeModifiers(slot, stack);
    }

}
