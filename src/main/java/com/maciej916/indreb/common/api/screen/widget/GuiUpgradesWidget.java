package com.maciej916.indreb.common.api.screen.widget;

import com.maciej916.indreb.IndReb;
import com.maciej916.indreb.common.api.blockentity.interfaces.IHasUpgrades;
import com.maciej916.indreb.common.api.interfaces.screen.IGuiHelper;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class GuiUpgradesWidget extends BaseWidget {

    private final IHasUpgrades upgrades;

    public GuiUpgradesWidget(IGuiHelper helper, IHasUpgrades upgrades) {
        super(helper, 175, 4, 24, 8 + (upgrades.getUpgradesSlots() * 18));
        this.upgrades = upgrades;
    }

    @Override
    protected void renderBackground(GuiGraphics guiGraphics, Minecraft pMinecraft, int pMouseX, int pMouseY) {
        RenderSystem.setShaderTexture(0, getResourceLocation());
        guiGraphics.blit(getResourceLocation(), getX(), getY(), (upgrades.getUpgradesSlots() - 1) * 25, 134, getWidth(), getHeight());
        super.renderBackground(guiGraphics, pMinecraft, pMouseX, pMouseY);
    }

    @Override
    public @NotNull ResourceLocation getResourceLocation() {
        return new ResourceLocation(IndReb.MODID, "textures/gui/container/common.png");
    }

    @Override
    public boolean addsExtraArea() {
        return true;
    }

    @Override
    protected void renderWidget(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {

    }
}
