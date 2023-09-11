package com.maciej916.indreb.common.block.impl.wood;

import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

public class RubberFence extends FenceBlock {

    public RubberFence() {
        super(Properties.of().mapColor(MapColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD));
    }

}
