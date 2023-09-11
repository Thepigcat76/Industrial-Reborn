package com.maciej916.indreb.common.block.impl.reinforced;

import com.maciej916.indreb.common.api.block.ModBlockSetType;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

public class ReinforcedDoor extends DoorBlock {

    public ReinforcedDoor() {
        super(Properties.of().strength(10.0F, 10000000000F).sound(SoundType.STONE).mapColor(MapColor.COLOR_BROWN), ModBlockSetType.REINFORCED);
    }

}
