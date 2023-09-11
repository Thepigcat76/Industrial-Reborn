package com.maciej916.indreb.common.item.impl.tool;

import com.maciej916.indreb.common.api.enums.EnergyTiers;
import com.maciej916.indreb.common.util.wrench.WrenchHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class MultiTool extends ElectricHoe {
    public MultiTool(Tier tier, float attackDamage, float attackSpeed, int energyStored, int maxEnergy, int energyCostMine, int energyCostHurt, int energyCostTile, EnergyTiers energyTier) {
        super(tier, attackDamage, attackSpeed, energyStored, maxEnergy, energyCostMine, energyCostHurt, energyCostTile, energyTier);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level world = pContext.getLevel();
        BlockPos pos = pContext.getClickedPos();
        BlockState state = world.getBlockState(pos);
        if (!state.isAir() && WrenchHelper.getWrenchActions().containsKey(state.getBlock())) {
            return WrenchHelper.onWrenchUse(world.getBlockState(pos), world, pos, pContext.getPlayer(), pContext.getClickedFace()) ? InteractionResult.SUCCESS : InteractionResult.PASS;
        }
        return super.useOn(pContext);
    }
}
