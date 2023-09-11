package com.maciej916.indreb.common.block.impl.wood;

import com.maciej916.indreb.common.api.block.ModBlockSetType;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

public class RubberPlate extends PressurePlateBlock {

    public RubberPlate() {
        super(PressurePlateBlock.Sensitivity.EVERYTHING, Properties.of().mapColor(MapColor.WOOD).strength(0.5F).sound(SoundType.WOOD), ModBlockSetType.RUBBER);
    }

}
