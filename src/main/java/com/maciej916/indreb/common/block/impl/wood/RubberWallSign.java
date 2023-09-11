package com.maciej916.indreb.common.block.impl.wood;

import com.maciej916.indreb.common.api.block.ModWoodType;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.state.properties.WoodType;

public class RubberWallSign extends StandingSignBlock {

    public RubberWallSign() {
        super(Properties.of().strength(2.0F, 3.0F).sound(SoundType.WOOD), ModWoodType.RUBBER);
    }

}
