package com.maciej916.indreb.common.block.impl.wood;

import com.maciej916.indreb.common.block.ModBlocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.material.MapColor;

public class RubberStairs extends StairBlock {

    public RubberStairs() {
        super(() -> ModBlocks.RUBBER_PLANKS.get().defaultBlockState(), Properties.of().strength(2.0F, 3.0F).sound(SoundType.WOOD).mapColor(MapColor.WOOD));
    }

}
