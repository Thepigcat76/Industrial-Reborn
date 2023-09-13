package com.maciej916.indreb.common.subscribe.event;

import com.maciej916.indreb.IndReb;
import com.maciej916.indreb.common.block.impl.cable.BlockCable;
import com.maciej916.indreb.common.capability.ModCapabilities;
import com.maciej916.indreb.common.energy.EnergyNetwork;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = IndReb.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PlayerTickEventElectric {

    public static final DamageSource ELECTRICITY = new DamageSource(Holder.direct(new DamageType("electricity", 0F)));

    @SubscribeEvent
    public static void event(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        Level level = event.player.level();

        if (!level.isClientSide()) {
            if (level.getGameTime() % 20 == 0) {
                BlockPos pos = player.blockPosition();
                for (int i = 0; i < 3; i++) {
                    BlockPos offsetPos = pos.offset(0, i, 0);
                    BlockState state = level.getBlockState(offsetPos);
                    if (state.getBlock() instanceof BlockCable bc) {
                        if (!bc.getCableTier().isInsulated()) {
                            level.getCapability(ModCapabilities.ENERGY_CORE).ifPresent(energy -> {
                                EnergyNetwork net = energy.getNetworks().getNetwork(offsetPos);
                                if (net != null && net.getEnergy() > 0) {
                                    net.setEnergy(0);
                                    player.hurt(ELECTRICITY, net.getCurrentTier().getLvl());
                                }
                            });
                        }
                    }
                }
            }
        }
    }
}
