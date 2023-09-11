package com.maciej916.indreb.common.api.screen.widget;

import com.maciej916.indreb.IndReb;
import com.maciej916.indreb.common.api.enums.GuiSprite;
import com.maciej916.indreb.common.api.interfaces.screen.IGuiHelper;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public abstract class BaseButtonWidget extends BaseWidget {

    private final GuiSprite guiSprite;
    private final Runnable onLeftClick;
    private final Runnable onRightClick;

    public BaseButtonWidget(IGuiHelper helper, int x, int y, GuiSprite guiSprite, @Nullable Runnable onLeftClick, @Nullable Runnable onRightClick) {
        super(helper, x, y, guiSprite.getWidth(), guiSprite.getHeight());
        this.guiSprite = guiSprite;
        this.onLeftClick = onLeftClick;
        this.onRightClick = onRightClick;
    }

    @Override
    public boolean mouseClicked(double pMouseX, double pMouseY, int pButton) {
        if (this.active && this.visible) {
            boolean flag = this.clicked(pMouseX, pMouseY);
            if (flag) {
                if (pButton == 0) {
                    return onLeftClick();
                } else if (pButton == 1) {
                    return onRightClick();
                }
            }
        }
        return false;
    }

    protected boolean onLeftClick() {
        if (onLeftClick != null) {
            onLeftClick.run();
            playDownSound(Minecraft.getInstance().getSoundManager());
            return true;
        }

        return false;
    }

    protected boolean onRightClick() {
        if (onRightClick != null) {
            onRightClick.run();
            return true;
        }

        return false;
    }


    @Override
    public void renderBackground(GuiGraphics guiGraphics, Minecraft pMinecraft, int pMouseX, int pMouseY) {
        RenderSystem.setShaderTexture(0, getResourceLocation());
        if (isHoveredOrFocused()) {
            guiGraphics.blit(getResourceLocation(), getX(), getY(), guiSprite.getActiveOffsetLeft(), guiSprite.getActiveOffsetTop(), guiSprite.getActiveWidth(), guiSprite.getActiveHeight());
        } else {
            guiGraphics.blit(getResourceLocation(), getX(), getY(), guiSprite.getOffsetLeft(), guiSprite.getOffsetTop(), guiSprite.getWidth(), guiSprite.getHeight());
        }

        super.renderBackground(guiGraphics, pMinecraft, pMouseX, pMouseY);
    }

    @Override
    public @NotNull ResourceLocation getResourceLocation() {
        return new ResourceLocation(IndReb.MODID, "textures/gui/container/buttons.png");
    }
}
