package com.maciej916.indreb.common.screen.widget.button;

import com.maciej916.indreb.common.api.enums.GuiSprite;
import com.maciej916.indreb.common.api.interfaces.screen.IGuiHelper;
import com.maciej916.indreb.common.api.screen.widget.BaseButtonWidget;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import static com.maciej916.indreb.IndReb.MODID;

public class ChangeModeButtonWidget extends BaseButtonWidget {

    private final boolean showTooltip;

    public ChangeModeButtonWidget(IGuiHelper helper, int x, int y, Runnable leftClick, boolean showTooltip) {
        super(helper, x, y, GuiSprite.LARGE_BUTTON, leftClick, null);
        this.showTooltip = showTooltip;
    }

    @Override
    public void renderToolTip(Screen screen, GuiGraphics guiGraphics, int pMouseX, int pMouseY) {

        if (isHoveredOrFocused() && showTooltip) {
            guiGraphics.renderTooltip(screen.getMinecraft().font, Component.translatable("gui." + MODID + ".change_mode"), pMouseX, pMouseY);
        }

        super.renderToolTip(screen, guiGraphics, pMouseX, pMouseY);
    }

    @Override
    public void renderBackground(GuiGraphics guiGraphics, Minecraft pMinecraft, int pMouseX, int pMouseY) {
        super.renderBackground(guiGraphics, pMinecraft, pMouseX, pMouseY);

        RenderSystem.setShaderTexture(0, getResourceLocation());
        GuiSprite sprite = GuiSprite.TRANSFORMER_ICON;

        guiGraphics.blit(getResourceLocation(), getX() + sprite.getRenderOffsetLeft(), getY() + sprite.getRenderOffsetLeft(), sprite.getOffsetLeft(), sprite.getOffsetTop(), sprite.getWidth(), sprite.getHeight());
    }
}
