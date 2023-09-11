package com.maciej916.indreb.common.block.impl.reinforced;

import net.minecraft.world.level.block.AbstractGlassBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

public class ReinforcedGlass extends AbstractGlassBlock {

    public ReinforcedGlass() {
        super(Properties.of().strength(10.0F, 10000000000F).sound(SoundType.GLASS).mapColor(MapColor.COLOR_BROWN).noOcclusion());
    }

}
