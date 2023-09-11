package com.maciej916.indreb.common.api.enums;

import com.maciej916.indreb.common.api.enums.interfaces.EnergyTier;
import com.maciej916.indreb.common.config.impl.ServerConfig;
import com.maciej916.indreb.common.enums.EnumLang;
import net.minecraft.ChatFormatting;

public enum EnergyTiers implements EnergyTier {
    BASIC("Basic", EnumLang.TIER_BASIC, 1, ChatFormatting.GREEN),
    STANDARD("Standard", EnumLang.TIER_STANDARD,2, ChatFormatting.YELLOW),
    ADVANCED("Advanced", EnumLang.TIER_ADVANCED,3, ChatFormatting.RED),
    SUPER("Super", EnumLang.TIER_SUPER,4, ChatFormatting.BLUE),
    ULTRA("Ultra", EnumLang.TIER_ULTRA,5, ChatFormatting.GOLD),
    CREATIVE("Creative", EnumLang.TIER_CREATIVE,6, ChatFormatting.GRAY);

    private final String name;
    private final EnumLang lang;
    private final Integer lvl;
    private final ChatFormatting color;

    EnergyTiers(String name, EnumLang lang, Integer lvl, ChatFormatting color) {
        this.name = name;
        this.lang = lang;
        this.lvl = lvl;
        this.color = color;
    }

    public Integer getLvl() {
        return lvl;
    }

    public String getName() {
        return name;
    }

    public EnumLang getLang() {
        return lang;
    }

    public ChatFormatting getColor() {
        return color;
    }

    public int getBasicTransfer() {
        return switch (getTierFromLvl(lvl)) {
            case BASIC -> ServerConfig.basic_tier_transfer.get();
            case STANDARD -> ServerConfig.standard_tier_transfer.get();
            case ADVANCED -> ServerConfig.advanced_tier_transfer.get();
            case SUPER -> ServerConfig.super_tier_transfer.get();
            case ULTRA -> ServerConfig.ultra_tier_transfer.get();
            case CREATIVE -> ServerConfig.creative_tier_transfer.get();
        };
    }

    public static EnergyTiers getTierFromLvl(int lvl) {
        EnergyTiers[] currencies = EnergyTiers.values();
        for (EnergyTiers enumTier : currencies) {
            if (enumTier.getLvl() == lvl) {
                return enumTier;
            }
        }
        return BASIC;
    }
}
