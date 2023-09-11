package com.maciej916.indreb.common.item.impl.upgrade;

import com.maciej916.indreb.IndReb;
import com.maciej916.indreb.common.api.enums.UpgradeTypes;
import com.maciej916.indreb.common.api.item.base.BaseUpgradeItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class RedstoneSignalInverterUpgrade extends BaseUpgradeItem {

    public RedstoneSignalInverterUpgrade() {
        super(UpgradeTypes.REDSTONE_SIGNAL_INVERTER);
    }

    @Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> components, TooltipFlag tooltipFlag) {

        components.add(Component.translatable("redstone." + IndReb.MODID + ".inverter").withStyle(ChatFormatting.GRAY));

        super.appendHoverText(stack, level, components, tooltipFlag);
    }

}
