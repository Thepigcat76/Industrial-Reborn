package com.maciej916.indreb.common.block.impl.wood;

import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

public class StrippedRubberWood extends RotatedPillarBlock {

    public StrippedRubberWood() {
        super(Properties.of().strength(2.0F).sound(SoundType.WOOD).mapColor(MapColor.WOOD));
    }

}
