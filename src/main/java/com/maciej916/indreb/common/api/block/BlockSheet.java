package com.maciej916.indreb.common.api.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

public class BlockSheet extends IndRebBlock {

    public BlockSheet(MapColor mapColor, float strength, float speedFactor, SoundType soundType) {
        super(Block.Properties.of().mapColor(mapColor).strength(strength).speedFactor(speedFactor).sound(soundType));
    }

}
