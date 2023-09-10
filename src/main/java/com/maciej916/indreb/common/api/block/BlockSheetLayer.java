package com.maciej916.indreb.common.api.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

public class BlockSheetLayer extends SnowLayerBlock {

    public BlockSheetLayer(MapColor mapColor, float strength, float speedFactor, SoundType soundType) {
        super(Block.Properties.of().mapColor(mapColor).strength(strength).speedFactor(speedFactor).sound(soundType));
    }
}
