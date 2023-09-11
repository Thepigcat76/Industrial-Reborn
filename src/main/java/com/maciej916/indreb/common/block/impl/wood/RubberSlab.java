package com.maciej916.indreb.common.block.impl.wood;

import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

public class RubberSlab extends SlabBlock {

    public RubberSlab() {
        super(Properties.of().strength(2.0F, 3.0F).sound(SoundType.WOOD).mapColor(MapColor.WOOD));
    }

}
