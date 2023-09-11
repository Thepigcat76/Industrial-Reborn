package com.maciej916.indreb.common.item.impl.tool;

import com.maciej916.indreb.common.api.energy.interfaces.IEnergyStorage;
import com.maciej916.indreb.common.api.enums.EnergyTiers;
import com.maciej916.indreb.common.api.enums.EnergyType;
import com.maciej916.indreb.common.api.item.base.BaseElectricDiggerItem;
import com.maciej916.indreb.common.api.tier.CustomTiers;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Optional;

public class ElectricChainsaw extends BaseElectricDiggerItem {

    private final int energyCostMine;
    private final int energyCostHurt;

    public ElectricChainsaw(Tier tier, float attackDamage, float attackSpeed, int energyStored, int maxEnergy, int energyCostMine, int energyCostHurt, EnergyTiers energyTier) {
        super(tier, attackDamage, attackSpeed, BlockTags.MINEABLE_WITH_AXE, new Item.Properties(), energyStored, maxEnergy, EnergyType.RECEIVE, energyTier);
        this.energyCostMine = energyCostMine;
        this.energyCostHurt = energyCostHurt;
    }

    @Override
    public Rarity getRarity(ItemStack stack) {
        return getTier() == CustomTiers.IRIDIUM ? Rarity.RARE : Rarity.COMMON;
    }

    @Override
    public int getHurtEnergyCost() {
        return energyCostMine;
    }

    @Override
    public int getMineCost() {
        return energyCostHurt;
    }

    @Override
    public void fillItemCategory(CreativeModeTab tab, NonNullList<ItemStack> itemStacks) {
        if (tab == CreativeModeTab.TAB_TOOLS) itemStacks.add(new ItemStack(this));
        super.fillItemCategory(tab, itemStacks);
    }

    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        ItemStack itemstack = useOnContext.getItemInHand();
        IEnergyStorage energy = getEnergyStorage(itemstack);
        if (energy.energyStored() > 1) {
            Level level = useOnContext.getLevel();
            BlockPos blockpos = useOnContext.getClickedPos();
            Player player = useOnContext.getPlayer();
            BlockState blockstate = level.getBlockState(blockpos);
            Optional<BlockState> optional = Optional.ofNullable(blockstate.getToolModifiedState(useOnContext, net.minecraftforge.common.ToolActions.AXE_STRIP, false));
            Optional<BlockState> optional1 = Optional.ofNullable(blockstate.getToolModifiedState(useOnContext, net.minecraftforge.common.ToolActions.AXE_SCRAPE, false));
            Optional<BlockState> optional2 = Optional.ofNullable(blockstate.getToolModifiedState(useOnContext, net.minecraftforge.common.ToolActions.AXE_WAX_OFF, false));
            Optional<BlockState> optional3 = Optional.empty();
            if (optional.isPresent()) {
                level.playSound(player, blockpos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
                optional3 = optional;
            } else if (optional1.isPresent()) {
                level.playSound(player, blockpos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.levelEvent(player, 3005, blockpos, 0);
                optional3 = optional1;
            } else if (optional2.isPresent()) {
                level.playSound(player, blockpos, SoundEvents.AXE_WAX_OFF, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.levelEvent(player, 3004, blockpos, 0);
                optional3 = optional2;
            }

            if (optional3.isPresent()) {
                if (player instanceof ServerPlayer) {
                    CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer)player, blockpos, itemstack);
                }

                level.setBlock(blockpos, optional3.get(), 11);
                if (player != null) {
                    getEnergyStorage(itemstack).consumeEnergy(20, false);
                }

                return InteractionResult.sidedSuccess(level.isClientSide);
            } else {
                return InteractionResult.PASS;
            }
        }

        return InteractionResult.PASS;
    }

    @Override
    public boolean canPerformAction(ItemStack itemStack, net.minecraftforge.common.ToolAction toolAction) {
        return net.minecraftforge.common.ToolActions.DEFAULT_AXE_ACTIONS.contains(toolAction) && getEnergyStorage(itemStack).energyStored() > 0;
    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return true;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }
}
