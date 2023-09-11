package com.maciej916.indreb.common.block.impl.wood;

import com.maciej916.indreb.common.block.ModBlocks;
import com.maciej916.indreb.common.util.BlockStateHelper;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.Nullable;

public class RubberWood extends RotatedPillarBlock {

    public RubberWood() {
        super(Properties.of().strength(2.0F).sound(SoundType.WOOD).mapColor(MapColor.WOOD));
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {

        if (toolAction == ToolActions.AXE_STRIP) {
            return ModBlocks.STRIPPED_RUBBER_WOOD.get().defaultBlockState().setValue(BlockStateHelper.AXIS_PROPERTY, state.getValue(BlockStateHelper.AXIS_PROPERTY));
        }

        return super.getToolModifiedState(state, context, toolAction, simulate);
    }

}
