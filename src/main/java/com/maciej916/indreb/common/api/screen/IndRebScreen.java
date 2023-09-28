package com.maciej916.indreb.common.api.screen;

import com.maciej916.indreb.common.api.blockentity.interfaces.IHasCooldown;
import com.maciej916.indreb.common.api.blockentity.interfaces.IHasExp;
import com.maciej916.indreb.common.api.blockentity.interfaces.IHasUpgrades;
import com.maciej916.indreb.common.api.energy.interfaces.IBlockEntityEnergy;
import com.maciej916.indreb.common.api.enums.GuiSprite;
import com.maciej916.indreb.common.api.screen.widget.button.GuiExpButtonWidget;
import com.maciej916.indreb.common.api.screen.widget.button.GuiInfoButtonWidget;
import com.maciej916.indreb.common.api.screen.widget.GuiCooldownWidget;
import com.maciej916.indreb.common.api.screen.widget.GuiSlotWidget;
import com.maciej916.indreb.common.api.screen.widget.GuiUpgradesWidget;
import com.maciej916.indreb.common.api.screen.widget.bar.GuiEnergyBarHorizontalWidget;
import com.maciej916.indreb.common.api.screen.widget.bar.GuiEnergyBarVerticalWidget;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class IndRebScreen <T extends IndRebContainerMenu> extends WidgetScreen<T> {

    boolean drawWidgets = true;

    public IndRebScreen(T menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    public void setDrawWidgets(boolean drawWidgets) {
        this.drawWidgets = drawWidgets;
    }

    public void updateData() {
        if (getEntity() instanceof IHasCooldown cooldown) {
            cooldown.setCooldown(menu.getContainerData().getIntData(-1));
        }
    }

    public void initElements() {
        if (getEntity().hasBaseStorage()) getEntity().getBaseStorage().getBaseSlots().forEach(sl -> addRenderableOnlyWidget(new GuiSlotWidget(this, sl)));
        if (getEntity().hasElectricStorage()) getEntity().getElectricStorage().getElectricSlots().forEach(sl -> addRenderableOnlyWidget(new GuiSlotWidget(this, sl)));

        if (getEntity() instanceof IHasCooldown cooldown) {
            addRenderableOnlyWidget(new GuiCooldownWidget(this, cooldown));
        }

        if (getEntity() instanceof IHasUpgrades upgrades) {
            addRenderableOnlyWidget(new GuiUpgradesWidget(this, upgrades));
            getEntity().getUpgradesStorage().getUpgradeSlots().forEach(sl -> addRenderableOnlyWidget(new GuiSlotWidget(this, sl)));
        }

        if (getEntity() instanceof IBlockEntityEnergy energyBlock) {
            if (energyBlock.showBarInGui() && getEntity().hasEnergyStorage()) {
                if (energyBlock.showVertical()) {
                    addRenderableOnlyWidget(new GuiEnergyBarVerticalWidget(this, energyBlock.leftOffsetVertical(), energyBlock.topOffsetVertical(), getEntity().getEnergyStorage()));
                } else {
                    addRenderableOnlyWidget(new GuiEnergyBarHorizontalWidget(this, energyBlock.leftOffsetHorizontal(), energyBlock.topOffsetHorizontal(), getEntity().getEnergyStorage()));
                }
            }
        }

        int topOffset = 5;

        if (getEntity() instanceof IHasUpgrades upgrades) {
            addRenderableOnlyWidget(new GuiInfoButtonWidget(this, topOffset, upgrades));
            topOffset += GuiSprite.LEFT_BUTTON.getHeight() + 3;
        }

        if (getEntity() instanceof IHasExp expCollector) {
            if (expCollector.hasExpButton()) {
                addUsableWidget(new GuiExpButtonWidget(this, topOffset, expCollector));
                topOffset += GuiSprite.LEFT_BUTTON.getHeight() + 3;
            }
        }
    }


    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        System.out.println("Rendering");
        updateData();
        super.renderBg(pGuiGraphics, pPartialTick, pMouseX, pMouseY);
    }

    @Override
    public void init() {
        super.init();
        initElements();
        drawWidgets(drawWidgets);
    }
}
