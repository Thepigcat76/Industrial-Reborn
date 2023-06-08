package com.maciej916.indreb.common.subscribe.event;

import com.maciej916.indreb.IndReb;
import com.maciej916.indreb.common.capability.ModCapabilities;
import com.maciej916.indreb.common.effects.ModEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = IndReb.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PlayerTickRadiationEffect {

    @SubscribeEvent
    public static void tick(TickEvent.PlayerTickEvent event) {
        MobEffectInstance radiation = new MobEffectInstance(ModEffects.RADIATION.get(), 10000, 0, false, false);
        radiation.setNoCounter(true);
        event.player.getCapability(ModCapabilities.PLAYER_CAPABILITY).ifPresent(cap -> {
            double radsLevel = cap.getPlayerRads();
            if (radsLevel > 0.05) {
                event.player.addEffect(radiation);
            }
        });
    }

    @SubscribeEvent
    public static void onEffectTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;

        if (player.hasEffect(ModEffects.RADIATION.get())) {
            MobEffectInstance poison = new MobEffectInstance(MobEffects.POISON, Objects.requireNonNull(player.getEffect(ModEffects.RADIATION.get())).getDuration(), 1, false, false);
            MobEffectInstance hunger = new MobEffectInstance(MobEffects.HUNGER, Objects.requireNonNull(player.getEffect(ModEffects.RADIATION.get())).getDuration(), 1, false, false);
            player.addEffect(poison);
            player.addEffect(hunger);
        }
    }
}
