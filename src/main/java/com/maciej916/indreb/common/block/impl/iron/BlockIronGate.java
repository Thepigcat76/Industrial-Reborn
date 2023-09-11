package com.maciej916.indreb.common.block.impl.iron;

import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;

public class BlockIronGate extends FenceGateBlock {

    public BlockIronGate() {
        super(Properties.of().strength(3F, 5F).sound(SoundType.METAL).mapColor(MapColor.METAL), WoodType.BIRCH);
    }

}
