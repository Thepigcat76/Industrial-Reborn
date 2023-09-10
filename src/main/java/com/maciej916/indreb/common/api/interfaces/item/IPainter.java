package com.maciej916.indreb.common.api.interfaces.item;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

public interface IPainter {

    MapColor getColor();
    BlockState getState();
}
