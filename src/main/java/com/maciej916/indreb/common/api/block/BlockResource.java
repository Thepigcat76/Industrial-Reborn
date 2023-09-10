package com.maciej916.indreb.common.api.block;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

public class BlockResource extends IndRebBlock {

    public BlockResource(float destroyTime, float explosionResistance, SoundType soundType) {
        super(Properties.of().strength(destroyTime, explosionResistance).sound(soundType));
    }

    public BlockResource(MapColor mapColor, float destroyTime, float explosionResistance, SoundType soundType) {
        super(Properties.of().strength(destroyTime, explosionResistance).sound(soundType).mapColor(mapColor));
    }

}
