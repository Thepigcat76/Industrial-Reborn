package com.maciej916.indreb.common.block.impl.machine.t_standard.ore_washing_plant;

import com.maciej916.indreb.IndReb;
import com.maciej916.indreb.common.api.screen.IndRebScreen;
import com.maciej916.indreb.common.api.screen.widget.bar.GuiFluidStorageVerticalWidget;
import com.maciej916.indreb.common.api.screen.widget.progress.GuiProgressFillWidget;
import com.maciej916.indreb.common.api.screen.widget.progress.OreWashingProgressWidget;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class ScreenOreWashingPlant extends IndRebScreen<MenuOreWashingPlant> {

    BlockEntityOreWashingPlant entity;

    public ScreenOreWashingPlant(MenuOreWashingPlant menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        this.entity = (BlockEntityOreWashingPlant) getEntity();
    }

    @Override
    public void initElements() {
        super.initElements();

        addRenderableOnlyWidget(new OreWashingProgressWidget(this, 90, 32, entity.progressRecipe));
        addRenderableOnlyWidget(new GuiProgressFillWidget(this, 9, 39, entity.progressFill));
        addRenderableOnlyWidget(new GuiFluidStorageVerticalWidget(this, 27, 18, entity.firstTank));
    }

    @Override
    public void updateData() {
        super.updateData();
        menu.getContainerData().updateProgressFloatData(0, entity.progressRecipe);
        menu.getContainerData().updateProgressIntData(1, entity.progressFill);
    }

    @Override
    public ResourceLocation getGuiLocation() {
        return new ResourceLocation(IndReb.MODID, "textures/gui/container/ore_washing_plant.png");
    }
}
