package com.maciej916.indreb.common.api.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;

public class BlockOre extends IndRebEntityBlock {

    public BlockOre(float destroyTime, float explosionResistance, SoundType soundType) {
        super(Block.Properties.of().strength(destroyTime, explosionResistance).sound(soundType));
    }

}
