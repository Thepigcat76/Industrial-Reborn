package com.maciej916.indreb.common.world.rubber_tree;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;

import java.util.function.BiConsumer;

public class RubberFoliagePlacer extends BlobFoliagePlacer {
    public RubberFoliagePlacer(IntProvider provider, IntProvider provider1, int i) {
        super(provider, provider1, i);
    }

    @Override
    protected void createFoliage(LevelSimulatedReader pLevel, FoliageSetter pBlockSetter, RandomSource pRandom, TreeConfiguration pConfig, int pMaxFreeTreeHeight, FoliageAttachment pAttachment, int pFoliageHeight, int pFoliageRadius, int pOffset) {
        for (int i = pOffset + 2; i >= pOffset - pFoliageHeight - 1; --i) {
            int j = Math.max(pFoliageRadius + pAttachment.radiusOffset() - 1 - i / 2, 0);
            if (i >= 1) j = 0;
            this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos(), j, i, pAttachment.doubleTrunk());
        }
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int localX, int localY, int localZ, int range, boolean large) {
        return !(localY >= 0 && localZ == 0 && localX == 0) && localX == range && localZ == range && (random.nextInt(2) == 0 || localY == 0);
    }
}
