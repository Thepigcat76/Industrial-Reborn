package com.maciej916.indreb.common.api.screen.widget;

import com.maciej916.indreb.IndReb;
import com.maciej916.indreb.common.api.blockentity.interfaces.IHasCooldown;
import com.maciej916.indreb.common.api.interfaces.screen.IGuiHelper;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class GuiCooldownWidget extends BaseWidget {

    private final IHasCooldown cooldown;

    public GuiCooldownWidget(IGuiHelper helper, IHasCooldown cooldown) {
        super(helper, 156, -15, 20, 16);
        this.cooldown = cooldown;
    }

    @Override
    public void renderToolTip(Screen screen, GuiGraphics guiGraphics, int pMouseX, int pMouseY) {
        Font font = screen.getMinecraft().font;
        if (isHoveredOrFocused()) {
            if (cooldown.getCooldown() > 0) {
                guiGraphics.renderTooltip(font, Component.translatable("gui." + IndReb.MODID + ".can_operate_in", cooldown.getCooldown()), pMouseX, pMouseY);
            } else {
                guiGraphics.renderTooltip(font, Component.translatable("gui." + IndReb.MODID + ".can_operate"), pMouseX, pMouseY);
            }
        }
    }

    @Override
    protected void renderBackground(GuiGraphics guiGraphics, Minecraft pMinecraft, int pMouseX, int pMouseY) {
        RenderSystem.setShaderTexture(0, getResourceLocation());
        if (cooldown.getCooldown()  == 0) {
            guiGraphics.blit(getResourceLocation(), getX(), getY(), 0, 100, getWidth(), getHeight());
        } else {
            guiGraphics.blit(getResourceLocation(), getX(), getY(), 0, 117, getWidth(), getHeight());
        }

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
}
