package com.maciej916.indreb.common.block.impl.wood;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

public class RubberPlanks extends Block {

    public RubberPlanks() {
        super(Properties.of().strength(2.0F).sound(SoundType.WOOD).mapColor(MapColor.WOOD));
    }

}
