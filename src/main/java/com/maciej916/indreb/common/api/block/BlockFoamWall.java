package com.maciej916.indreb.common.api.block;

import com.maciej916.indreb.common.api.interfaces.item.IPainter;
import com.maciej916.indreb.common.sound.ModSounds;
import com.maciej916.indreb.common.util.RenderUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;
import org.joml.Vector3f;

import java.util.Random;

public class BlockFoamWall extends Block {

    public BlockFoamWall(MapColor color) {
        super(Properties.of().strength(5.0F, 4.0F).sound(SoundType.STONE).mapColor(color));
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {

        if (player.getItemInHand(interactionHand).getItem() instanceof IPainter painter) {
            if (painter.getState() == blockState) {
                return InteractionResult.PASS;
            } else {
                BlockPos dropPos = blockPos.relative(blockHitResult.getDirection());
                Random random = new Random();
                Direction dir = blockHitResult.getDirection();

                int rgbColor = painter.getColor().calculateRGBColor(MapColor.Brightness.NORMAL);
                Vector3f COLOR = new Vector3f(RenderUtils.getBlue(rgbColor), RenderUtils.getGreen(rgbColor), RenderUtils.getRed(rgbColor));
                for(int i = 0; i < 5; i++) {
                    double x,y,z;
                    if (dir == Direction.UP || dir == Direction.DOWN) {
                        x = dropPos.getX() + ((Math.random() * (0.8 - 0.2)) + 0.2);
                        y = dropPos.getY() + (dir == Direction.UP ? ((Math.random() * (0.2 - 0)) + 0) : ((Math.random() * (1 - 0.8)) + 0.8));
                        z = dropPos.getZ() + ((Math.random() * (0.8 - 0.2)) + 0.2);
                    } else {
                        y = dropPos.getY() + ((Math.random() * (0.8 - 0.2)) + 0.2);
                        if (dir == Direction.WEST || dir == Direction.EAST) {
                            x = dropPos.getX() + (dir == Direction.EAST ? ((Math.random() * (0.2 - 0)) + 0) : ((Math.random() * (1 - 0.8)) + 0.8));
                            z = dropPos.getZ() + ((Math.random() * (0.8 - 0.2)) + 0.2);
                        } else {
                            x = dropPos.getX() + ((Math.random() * (0.8 - 0.2)) + 0.2);
                            z = dropPos.getZ() + (dir == Direction.SOUTH ? ((Math.random() * (0.2 - 0)) + 0) : ((Math.random() * (1 - 0.8)) + 0.8));
                        }
                    }
                    level.addParticle(new DustParticleOptions(COLOR, 1.0F), x, y, z, 0.0D, 0.0D, 0.0D);
                }

                if (!level.isClientSide()) {
                    level.playSound(null, blockPos.getX(), blockPos.getY(), blockPos.getZ(), ModSounds.PAINTER.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                    level.setBlock(blockPos, painter.getState(), 2);
                    player.getItemInHand(interactionHand).hurtAndBreak(1, player, (i) -> level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_BREAK, SoundSource.BLOCKS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F)));
                }

                return InteractionResult.SUCCESS;
            }
        }

        return super.use(blockState, level, blockPos, player, interactionHand, blockHitResult);
    }

}
