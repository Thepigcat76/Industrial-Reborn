package com.maciej916.indreb.common.item.impl.tool;

import com.maciej916.indreb.IndReb;
import com.maciej916.indreb.common.api.blockentity.interfaces.IIndRebBlockEntity;
import com.maciej916.indreb.common.api.energy.BasicEnergyStorage;
import com.maciej916.indreb.common.api.enums.EnergyType;
import com.maciej916.indreb.common.api.item.base.BaseItem;
import com.maciej916.indreb.common.util.TextComponentUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class IEMeter extends Item {
    public IEMeter() {
        super(new Item.Properties());
    }

    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        components.add(Component.translatable("ie." + IndReb.MODID + ".desc").withStyle(ChatFormatting.GRAY));
        super.appendHoverText(p_41421_, level, components, flag);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();

        if (!level.isClientSide()) {
            BlockPos pos = context.getClickedPos();
            Player player = context.getPlayer();

            if (player != null && player.isShiftKeyDown()) {
                BlockState blockState = level.getBlockState(pos);
//                if (blockState.getBlock() instanceof IBlockCable) {
//                    IEnergyCore capCore = CapabilityUtil.getCapabilityHelper(level, ModCapabilities.ENERGY_CORE).getValue();
//                    if (capCore != null) {
//                        EnergyNetwork network = capCore.getNetworks().getNetwork(pos);
//                        if (network != null) {
//                            int generators = 0;
//                            int machines = 0;
//                            int batteries = 0;
//                            for (BlockPos elPos : network.getElectrics()) {
//                                BlockEntity entity = level.getBlockEntity(elPos);
//                                IEnergyStorage cap = CapabilityUtil.getCapabilityHelper(entity, ModCapabilities.ENERGY, null).getValue();
//                                if (cap != null) {
//                                    generators += cap.energyType() == EnergyType.EXTRACT ? 1 : 0;
//                                    machines += cap.energyType() == EnergyType.RECEIVE ? 1 : 0;
//                                    batteries += cap.energyType() == EnergyType.BOTH ? 1 : 0;
//                                }
//                            }
//
//                            ChatFormatting color = network.getEnergyTier().getColor();
//                            player.displayClientMessage(Component.literal("====================================").withStyle(ChatFormatting.GRAY), false);
//                            player.displayClientMessage(Component.translatable("ie." + IndReb.MODID + ".network_info"), false);
//                            player.displayClientMessage(Component.literal(""), false);
//                            player.displayClientMessage(Component.translatable("tooltip." + IndReb.MODID + ".current_voltage", network.getEnergyFlowing() != null ? Component.translatable(network.getEnergyFlowing().getLang().getTranslationKey()).withStyle(network.getEnergyFlowing().getColor()) : Component.literal("-")), false);
//                            player.displayClientMessage(Component.translatable("tooltip." + IndReb.MODID + ".power_tier", Component.translatable(network.getEnergyTier().getLang().getTranslationKey()).withStyle(color)), false);
//                            player.displayClientMessage(Component.translatable("tooltip." + IndReb.MODID + ".transfer", Component.translatable(TextComponentUtil.getFormattedLong(network.getEnergyTier().getBasicTransfer()) + " IE/t").withStyle(color)), false);
//                            player.displayClientMessage(Component.translatable("ie." + IndReb.MODID + ".connected_generators",Component.literal(String.valueOf(generators)).withStyle(color)), false);
//                            player.displayClientMessage(Component.translatable("ie." + IndReb.MODID + ".connected_machines",Component.literal(String.valueOf(machines)).withStyle(color)), false);
//                            player.displayClientMessage(Component.translatable("ie." + IndReb.MODID + ".connected_batteries",Component.literal(String.valueOf(batteries)).withStyle(color)), false);
//                            player.displayClientMessage(Component.translatable("tooltip." + IndReb.MODID + ".stored_capacity",Component.literal(TextComponentUtil.getFormattedLong(network.energyStored()) + " IE").withStyle(color),Component.literal(TextComponentUtil.getFormattedLong(network.maxEnergy()) + " IE").withStyle(color)), false);
//                            player.displayClientMessage(Component.literal("====================================").withStyle(ChatFormatting.GRAY), false);
//
//                            return InteractionResult.SUCCESS;
//                        }
//                    }
//                }

                BlockEntity blockEntity = level.getBlockEntity(pos);
                if (blockEntity instanceof IIndRebBlockEntity indRebBlockEntity) {
                    if (indRebBlockEntity.hasEnergyStorage()) {
                        BasicEnergyStorage energyStorage = indRebBlockEntity.getEnergyStorage();
                        ChatFormatting color = energyStorage.energyTier().getColor();

                        player.displayClientMessage(Component.literal("====================================").withStyle(ChatFormatting.GRAY), false);
                        player.displayClientMessage(Component.translatable("ie." + IndReb.MODID + ".machine_info"), false);
                        player.displayClientMessage(Component.literal(""), false);

                        player.displayClientMessage(Component.translatable("tooltip." + IndReb.MODID + ".power_tier", Component.translatable(energyStorage.energyTier().getLang().getTranslationKey()).withStyle(color)), false);
                        player.displayClientMessage(Component.translatable("tooltip." + IndReb.MODID + ".transfer", Component.translatable(TextComponentUtil.getFormattedLong(energyStorage.energyTier().getBasicTransfer()) + " IE/t").withStyle(color)), false);

                        if (energyStorage.energyType() == EnergyType.EXTRACT) {
                            player.displayClientMessage(Component.translatable("ie." + IndReb.MODID + ".last_generated", Component.translatable(TextComponentUtil.getFormattedLong(energyStorage.lastGenerated()) + " IE/t").withStyle(color)), false);
                            player.displayClientMessage(Component.translatable("ie." + IndReb.MODID + ".total_generated", Component.translatable(TextComponentUtil.getFormattedLong(energyStorage.totalGenerated()) + " IE").withStyle(color)), false);
                        }

                        if (energyStorage.energyType() == EnergyType.RECEIVE) {
                            player.displayClientMessage(Component.translatable("ie." + IndReb.MODID + ".last_consumed", Component.translatable(TextComponentUtil.getFormattedLong(energyStorage.lastConsumed()) + " IE/t").withStyle(color)), false);
                            player.displayClientMessage(Component.translatable("ie." + IndReb.MODID + ".total_consumed", Component.translatable(TextComponentUtil.getFormattedLong(energyStorage.totalConsumed()) + " IE").withStyle(color)), false);
                        }

                        player.displayClientMessage(Component.translatable("tooltip." + IndReb.MODID + ".stored_capacity",Component.literal(TextComponentUtil.getFormattedLong(energyStorage.energyStored()) + " IE").withStyle(color),Component.literal(TextComponentUtil.getFormattedLong(energyStorage.maxEnergy()) + " IE").withStyle(color)), false);
                        player.displayClientMessage(Component.literal("====================================").withStyle(ChatFormatting.GRAY), false);

                        return InteractionResult.SUCCESS;
                    }
                }
            }
        }
        return super.useOn(context);
    }
}
