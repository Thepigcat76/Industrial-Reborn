package com.maciej916.indreb.common.client.keys.impl;

import com.maciej916.indreb.common.api.interfaces.item.IArmorProperties;
import com.maciej916.indreb.common.capability.ModCapabilities;
import com.maciej916.indreb.common.capability.player.IPlayerCapability;
import com.maciej916.indreb.common.client.keys.ModKeys;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class FlightHandler {

    public static void toggleFlight(Player player) {
        if (ModKeys.QUANTUM_ABILITY_TOGGLE.consumeClick()) {
            boolean found = false;
            for (ItemStack stack : player.getArmorSlots()) {
                if (stack.getItem() instanceof IArmorProperties armorProperties) {
                    if (armorProperties.supportsFlight()) {
                        found = true;
                        break;
                    }
                }
            }

            if (found) {
                player.getCapability(ModCapabilities.PLAYER_CAPABILITY).ifPresent(cap -> toggle(cap, player, !cap.getFlight()));
            }
        }
    }

    public static void checkFlight(Player player) {
        player.getCapability(ModCapabilities.PLAYER_CAPABILITY).ifPresent(cap -> {
            boolean found = false;
            for (ItemStack stack : player.getArmorSlots()) {
                if (stack.getItem() instanceof IArmorProperties armorProperties) {
                    if (armorProperties.supportsFlight()) {
                        found = true;
                        break;
                    }
                }
            }

            if (!found && cap.getFlight()) {
                toggle(cap, player, false);
            }
        });
    }

    public static void toggle(IPlayerCapability cap, Player player, boolean enable) {
        if (enable) {
            player.getAbilities().mayfly = true;
            player.onUpdateAbilities();
        } else if (!player.isCreative()) {
            player.getAbilities().mayfly = false;
        }

        cap.setFlight(enable);
    }

}
