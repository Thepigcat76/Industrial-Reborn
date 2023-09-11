package com.maciej916.indreb.common.block.impl.generator.reactor.nuclear_reactor;

import com.maciej916.indreb.common.api.block.BaseMachineBlock;
import com.maciej916.indreb.common.api.blockentity.interfaces.IIndRebBlockEntity;
import com.maciej916.indreb.common.api.enums.EnergyTiers;
import com.maciej916.indreb.common.api.multiblock.MultiBlockTools;
import com.maciej916.indreb.common.block.ModBlocks;
import com.maciej916.indreb.common.enums.EnumLang;
import com.maciej916.indreb.common.multiblock.reactor.IReactorPart;
import com.maciej916.indreb.common.multiblock.reactor.ReactorMultiBlock;
import com.maciej916.indreb.common.multiblock.reactor.ReactorPartIndex;
import com.maciej916.indreb.common.tag.ModBlockTags;
import com.maciej916.indreb.common.util.BlockStateHelper;
import com.maciej916.indreb.common.util.TextComponentUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BlockNuclearReactor extends BaseMachineBlock implements IReactorPart {


    public BlockNuclearReactor() {
        super(0, 0);

    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new BlockEntityNuclearReactor(pos, state);
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
//        if (oldState.getBlock() != oldState.getBlock()) {
//            ReactorMultiBlock.formMultiBlock(level, pos, state);
//        }

        super.onPlace(state, level, pos, oldState, isMoving);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult trace) {

        if (state.getValue(BlockStateHelper.REACTOR_PART) != ReactorPartIndex.UNFORMED) {
            BlockEntity entity = level.getBlockEntity(pos);
            if (entity instanceof IIndRebBlockEntity && entity instanceof MenuProvider menuProvider) {
                if (!level.isClientSide()) {
                    NetworkHooks.openScreen(((ServerPlayer)player), menuProvider, pos);
                }
                return InteractionResult.sidedSuccess(level.isClientSide());
            }
        }

        return InteractionResult.PASS;
    }

    @Override
    public void onRemove(BlockState oldState, Level level, BlockPos blockPos, BlockState newState, boolean isMoving) {
        if (!level.isClientSide()) {
            if (oldState.getBlock() != newState.getBlock()) {
                MultiBlockTools.breakMultiblock(ReactorMultiBlock.INSTANCE, level, blockPos, oldState, newState);
            }
        }

        super.onRemove(oldState, level, blockPos, newState, isMoving);
    }

    @Nullable
    public static BlockPos getControllerPos(Level level, BlockPos pos) {
        BlockState state = level.getBlockState(pos);
        if (state.getBlock() == ModBlocks.NUCLEAR_REACTOR.get() && state.getValue(BlockStateHelper.REACTOR_PART) != ReactorPartIndex.UNFORMED) {
            return pos;
        }

        if (state.is(ModBlockTags.REACTOR_PART) && state.getValue(BlockStateHelper.REACTOR_PART) != ReactorPartIndex.UNFORMED) {
            ReactorPartIndex index = state.getValue(BlockStateHelper.REACTOR_PART);
            BlockPos bottomLeft = pos.offset(-index.getDx(), -index.getDy(), -index.getDz());
            ReactorPartIndex reactorIndex = ReactorPartIndex.P111;
            BlockPos p = bottomLeft.offset(reactorIndex.getDx(), reactorIndex.getDy(), reactorIndex.getDz());
            if (reactorIndex.testPlacement(level, p, true)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @javax.annotation.Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(TextComponentUtil.build(
                Component.translatable(EnumLang.POWER_TIER.getTranslationKey()).withStyle(ChatFormatting.GRAY),
                EnergyTiers.BASIC.getLang().getTranslationComponent().withStyle(EnergyTiers.BASIC.getColor()),
                Component.literal(" - ").withStyle(ChatFormatting.GRAY),
                EnergyTiers.SUPER.getLang().getTranslationComponent().withStyle(EnergyTiers.SUPER.getColor())
        ));

        pTooltip.add(TextComponentUtil.build(
                Component.translatable(EnumLang.MULTIBLOK_PART.getTranslationKey()).withStyle(ChatFormatting.GRAY),
                Component.literal(" 3x3x3").withStyle(ChatFormatting.DARK_GRAY)
        ));
    }
}
