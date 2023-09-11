package com.maciej916.indreb.common.block.impl.wood;

import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

public class RubberLeaves extends LeavesBlock {

    public RubberLeaves() {
        super(Properties.of().strength(0.2F).randomTicks().sound(SoundType.GRASS).mapColor(MapColor.PLANT).noOcclusion());
    }
}
