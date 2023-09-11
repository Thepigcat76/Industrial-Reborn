package com.maciej916.indreb.common.block.impl.wood;

import com.maciej916.indreb.common.api.block.IndRebBlock;
import com.maciej916.indreb.common.api.energy.interfaces.IEnergyStorage;
import com.maciej916.indreb.common.api.interfaces.block.IStateAxis;
import com.maciej916.indreb.common.api.interfaces.block.IStateRubberLog;
import com.maciej916.indreb.common.api.interfaces.item.IElectricItem;
import com.maciej916.indreb.common.block.ModBlocks;
import com.maciej916.indreb.common.item.ModItems;
import com.maciej916.indreb.common.sound.ModSounds;
import com.maciej916.indreb.common.tag.ModItemTags;
import com.maciej916.indreb.common.util.BlockStateHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.Nullable;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RubberLog extends IndRebBlock implements IStateRubberLog, IStateAxis {

    public RubberLog() {
        super(Block.Properties.of().strength(2.0F, 3.0F).sound(SoundType.WOOD).randomTicks());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return switch (rot) {
            case COUNTERCLOCKWISE_90, CLOCKWISE_90 -> switch (state.getValue(BlockStateHelper.AXIS_PROPERTY)) {
                case X -> state.setValue(BlockStateHelper.AXIS_PROPERTY, Direction.Axis.Z);
                case Z -> state.setValue(BlockStateHelper.AXIS_PROPERTY, Direction.Axis.X);
                default -> state;
            };
            default -> state;
        };
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(BlockStateHelper.AXIS_PROPERTY, pContext.getClickedFace().getAxis());
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult trace) {
        ItemStack stack = player.getItemInHand(hand);
        if (stack.is(ModItemTags.TREETAP))  {
            return dropRubber(player, player.getItemInHand(hand), state, level, pos, trace);
        }
        return super.use(state, level, pos, player, hand, trace);
    }

    private InteractionResult dropRubber(Player player, ItemStack itemStack, BlockState state, Level level, BlockPos pos, BlockHitResult trace) {
        if (level.isClientSide()) return InteractionResult.PASS;
        Random random = new Random();

        if (itemStack.getItem() instanceof IElectricItem electricItem) {
            IEnergyStorage energy = electricItem.getEnergyStorage(itemStack);
            if (energy.energyStored() == 0) return InteractionResult.PASS;
            energy.consumeEnergy(50, false);
        } else {
            itemStack.hurtAndBreak(1, player, (i) -> level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_BREAK, SoundSource.BLOCKS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F)));
        }

        int dropCount = 0;
        if (isWet(state)) {
            dropCount = ThreadLocalRandom.current().nextInt(1, 3 + 1);
            BlockPos dropPos = pos.relative(trace.getDirection());

            Containers.dropItemStack(level, dropPos.getX(), dropPos.getY(), dropPos.getZ(), new ItemStack(ModItems.STICKY_RESIN.get(), dropCount));

            state = this.setWet(state, false);
            state = this.setDry(state, true);

            level.setBlock(pos, state, 2);
        } else if (isDry(state)) {
            dropCount = ThreadLocalRandom.current().nextInt(0, 1 + 1);
            if (dropCount > 0) {
                BlockPos dropPos = pos.relative(trace.getDirection());
                Containers.dropItemStack(level, dropPos.getX(), dropPos.getY(), dropPos.getZ(), new ItemStack(ModItems.STICKY_RESIN.get(), dropCount));
            }
            state = this.setDry(state, false);
            level.setBlock(pos, state, 2);
        }

        if (dropCount > 0) {
            level.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.TREETAP.get(), SoundSource.NEUTRAL, 1F, 0.8F / (random.nextFloat() * 0.4F + 0.8F));
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (isDry(pState)) {
            int count = ThreadLocalRandom.current().nextInt(0, 5 + 1);
            if (count == 0) {
                pState = this.setWet(pState, true);
                pState = this.setDry(pState, false);
                pLevel.setBlock(pPos, pState, 2);
            }
        }
        super.randomTick(pState, pLevel, pPos, pRandom);
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {

        if (toolAction == ToolActions.AXE_STRIP) {
            return ModBlocks.STRIPPED_RUBBER_LOG.get().defaultBlockState().setValue(BlockStateHelper.AXIS_PROPERTY, state.getValue(BlockStateHelper.AXIS_PROPERTY));
        }

        return super.getToolModifiedState(state, context, toolAction, simulate);
    }
}
