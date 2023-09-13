package com.maciej916.indreb.common.item.impl;

import com.maciej916.indreb.IndReb;
import com.maciej916.indreb.common.api.item.base.BaseItem;
import com.maciej916.indreb.common.item.ModItems;
import com.maciej916.indreb.common.recipe.ModRecipeType;
import com.maciej916.indreb.common.recipe.impl.ScrapBoxRecipe;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ScrapBox extends BaseItem {
    private static final List<ScrapBox> SCRAP_BOX = new ArrayList<>();

    public ScrapBox() {
        super(new Properties());
        SCRAP_BOX.add(this);
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return 1800;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        if (!level.isClientSide()) {
            ItemStack stack = openScrap(level);
            ItemEntity item = new ItemEntity(level, player.getX(), player.getY(), player.getZ(), stack);
            level.addFreshEntity(item);

            ItemStack scrapBoxStack = player.getItemInHand(interactionHand);
            scrapBoxStack.shrink(1);
        }

        return super.use(level, player, interactionHand);
    }

    public static ItemStack openScrap(Level level) {
        Optional<ScrapBoxRecipe> recipe = level.getRecipeManager().getRecipeFor(ModRecipeType.SCRAP_BOX.get(), new SimpleContainer(new ItemStack(ModItems.SCRAP_BOX.get())), level);
        return recipe.map(scrapBoxRecipe -> scrapBoxRecipe.getDrop().copy()).orElse(ItemStack.EMPTY);
    }

    @Nullable
    protected DispenseItemBehavior createDispenseBehavior() {
        return SCRAP_BOX_DISPENSE_BEHAVIOR;
    }

    private static final DispenseItemBehavior SCRAP_BOX_DISPENSE_BEHAVIOR = (source, stack) -> {
        Level level = source.getLevel();
        Direction direction = source.getBlockState().getValue(DispenserBlock.FACING);
        Position position = DispenserBlock.getDispensePosition(source);
        ItemStack itemStack = openScrap(level);
        DefaultDispenseItemBehavior.spawnItem(source.getLevel(), itemStack, 6, direction, position);
        level.levelEvent(2000, source.getPos(), direction.get3DDataValue());
        level.levelEvent(1000, source.getPos(), 0);
        stack.shrink(1);
        return stack;
    };

    @Mod.EventBusSubscriber(modid = IndReb.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    private static class CommonHandler {
        @SubscribeEvent
        public static void onCommonSetup(FMLCommonSetupEvent event) {
            SCRAP_BOX.forEach(item -> {
                DispenseItemBehavior dispenseBehavior = item.createDispenseBehavior();
                if (dispenseBehavior != null){
                    DispenserBlock.registerBehavior(item, dispenseBehavior);
                }
            });
        }
    }

}
