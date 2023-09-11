package com.maciej916.indreb.common.block.impl.wood;

import com.maciej916.indreb.common.api.block.ModBlockSetType;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.material.MapColor;
public class RubberTrapDoor extends TrapDoorBlock {

    public RubberTrapDoor() {
        super(Properties.of().strength(3.0F).sound(SoundType.WOOD).mapColor(MapColor.WOOD), ModBlockSetType.RUBBER);
    }

}
