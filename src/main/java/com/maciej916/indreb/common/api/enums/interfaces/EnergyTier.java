package com.maciej916.indreb.common.api.enums.interfaces;

import com.maciej916.indreb.common.enums.EnumLang;
import net.minecraft.ChatFormatting;

public interface EnergyTier {
    Integer getLvl();
    String getName();
    EnumLang getLang();
    ChatFormatting getColor();
    int getBasicTransfer();
}
