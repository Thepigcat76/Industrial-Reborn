package com.maciej916.indreb.common.block.impl.machine.t_super.replicator;

import com.maciej916.indreb.common.api.block.BaseElectricMachineBlock;
import com.maciej916.indreb.common.api.enums.EnergyTiers;
import com.maciej916.indreb.common.block.ModBlocks;
import com.maciej916.indreb.common.config.impl.ServerConfig;
import com.maciej916.indreb.common.enums.EnumLang;
import com.maciej916.indreb.common.util.BlockEntityUtil;
import com.maciej916.indreb.common.util.BlockStateHelper;
import com.maciej916.indreb.common.util.Constants;
import com.maciej916.indreb.common.util.TextComponentUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;
import org.joml.Vector3fc;

import java.util.List;

public class BlockReplicator extends BaseElectricMachineBlock {

    public static final Vector3f PARTICLE_COLOR = new Vector3f(Vec3.fromRGB24(0XA1800e7c).toVector3f());

    public BlockReplicator() {
        super(EnergyTiers.SUPER,6, 0);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new BlockEntityReplicator(pos, state);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack pStack, @javax.annotation.Nullable BlockGetter pLevel, List<Component> pTooltip, @NotNull TooltipFlag pFlag) {
        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);

        pTooltip.add(TextComponentUtil.build(
                Component.translatable(EnumLang.ACCEPT.getTranslationKey()).withStyle(ChatFormatting.GRAY),
                Component.translatable(EnumLang.POWER_TICK.getTranslationKey(), TextComponentUtil.getFormattedStorageUnit(ServerConfig.super_tier_transfer.get(), Screen.hasShiftDown())).withStyle(getEnergyTier().getColor())
        ));

        pTooltip.add(TextComponentUtil.build(
                Component.translatable(EnumLang.CAPACITY.getTranslationKey()).withStyle(ChatFormatting.GRAY),
                Component.translatable(EnumLang.POWER.getTranslationKey(), TextComponentUtil.getFormattedStorageUnit(ServerConfig.replicator_energy_capacity.get(), Screen.hasShiftDown())).withStyle(getEnergyTier().getColor())
        ));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void animateTick(BlockState stateIn, Level level, BlockPos pos, RandomSource rand) {
        if (stateIn.getValue(BlockStateHelper.ACTIVE_PROPERTY)) {
            double d0 = (double)pos.getX() + 0.5D;
            double d1 = (double)pos.getY() + 1.05d;
            double d2 = (double)pos.getZ() + 0.5D;
            level.addParticle(new DustParticleOptions(PARTICLE_COLOR, 1.0F), d0, d1, d2, 0.0D, 0.0D, 0.0D);
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult trace) {
        if (!level.isClientSide) {
            if (!player.isShiftKeyDown()) {
                BlockEntity blockEntity = level.getBlockEntity(pos);
                if (blockEntity instanceof BlockEntityReplicator entityReplicator) {
                    if (BlockEntityUtil.useFillTank(player, hand, entityReplicator.firstTank)) {
                        return InteractionResult.PASS;
                    }
                }
            }
        }
        return super.use(state, level, pos, player, hand, trace);
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {

        BlockEntity entity = level.getBlockEntity(pos);
        if (entity instanceof BlockEntityReplicator entityReplicator) {
            if (level.getBlockState(fromPos).getBlock() == ModBlocks.PATTERN_STORAGE.get()) {
                entityReplicator.addPatternStorage(fromPos);
            } else {
                entityReplicator.removePatternStorage(fromPos);
            }
        }

        super.neighborChanged(state, level, pos, block, fromPos, isMoving);
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {

        BlockEntity entity = level.getBlockEntity(pos);
        if (entity instanceof BlockEntityReplicator entityReplicator) {
            for (Direction direction : Constants.DIRECTIONS) {
                BlockPos offsetPos = pos.relative(direction);
                if (level.getBlockState(offsetPos).getBlock() == ModBlocks.PATTERN_STORAGE.get()) {
                    entityReplicator.addPatternStorage(offsetPos);
                }
            }
        }

        super.onPlace(state, level, pos, oldState, isMoving);
    }
}
