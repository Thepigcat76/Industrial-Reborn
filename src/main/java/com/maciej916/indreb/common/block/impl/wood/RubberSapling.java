package com.maciej916.indreb.common.block.impl.wood;

import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.material.MapColor;

public class RubberSapling extends SaplingBlock {

    public RubberSapling(AbstractTreeGrower tree) {
        super(tree, Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().strength(0.0F).instabreak().sound(SoundType.GRASS));
    }
}
