package com.maciej916.indreb.common.block.impl.wood;

import com.maciej916.indreb.common.api.block.ModBlockSetType;
import com.maciej916.indreb.common.api.block.ModWoodType;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.material.MapColor;

public class RubberStandingSign extends StandingSignBlock {

    public RubberStandingSign() {
        super(Properties.of().noCollission().strength(1.0F).sound(SoundType.WOOD).mapColor(MapColor.WOOD), ModWoodType.RUBBER);
    }

}
