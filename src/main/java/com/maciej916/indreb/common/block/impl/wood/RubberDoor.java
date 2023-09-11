package com.maciej916.indreb.common.block.impl.wood;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;

public class RubberDoor extends DoorBlock {

    public RubberDoor() {
        super(Properties.of().strength(2.0F, 3.0F).sound(SoundType.WOOD).mapColor(MapColor.WOOD), BlockSetType.JUNGLE);
    }
}
