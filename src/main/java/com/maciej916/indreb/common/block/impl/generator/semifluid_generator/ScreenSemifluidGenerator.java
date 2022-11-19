package com.maciej916.indreb.common.block.impl.generator.semifluid_generator;

import com.maciej916.indreb.IndReb;
import com.maciej916.indreb.common.api.screen.IndRebScreen;
import com.maciej916.indreb.common.api.screen.widget.bar.GuiFluidStorageVerticalLargeWidget;
import com.maciej916.indreb.common.api.screen.widget.progress.GuiProgressFillWidget;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class ScreenSemifluidGenerator extends IndRebScreen<MenuSemifluidGenerator> {

    BlockEntitySemifluidGenerator entity;

    public ScreenSemifluidGenerator(MenuSemifluidGenerator menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        this.entity = (BlockEntitySemifluidGenerator) getEntity();
    }

    @Override
    public void initElements() {
        super.initElements();

        addRenderableOnlyWidget(new GuiProgressFillWidget(this, 62, 40, entity.progressFill));
        addRenderableOnlyWidget(new GuiFluidStorageVerticalLargeWidget(this, 80, 19, entity.fuelStorage));

    }

    @Override
    public void updateData() {
        super.updateData();
        entity.progressFill.setContainerDataBoth(menu.getData().get(2), menu.getData().get(3));
    }

    @Override
    public ResourceLocation getGuiLocation() {
        return new ResourceLocation(IndReb.MODID, "textures/gui/container/geo_generator.png");
    }
}