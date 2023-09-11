package com.maciej916.indreb.common.block.impl.wood;

import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;

public class RubberGate extends FenceGateBlock {

    public RubberGate() {
        super(Properties.of().strength(2.0F, 3.0F).sound(SoundType.WOOD).mapColor(MapColor.WOOD), WoodType.JUNGLE);
    }

}
