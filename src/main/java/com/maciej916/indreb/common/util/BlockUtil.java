package com.maciej916.indreb.common.util;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class BlockUtil {

    public static BlockBehaviour.Properties BLOCK_MACHINE_ACTIVE = BlockBehaviour.Properties
            .of()
            .strength(2F, 3F)
            .sound(SoundType.METAL);

    public static BlockBehaviour.Properties BLOCK_MACHINE_NOT_ACTIVE = BlockBehaviour.Properties
            .of()
            .strength(2F, 3F)
            .sound(SoundType.METAL);

}
