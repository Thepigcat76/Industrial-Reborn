package com.maciej916.indreb.common.api.screen.widget;

import com.maciej916.indreb.IndReb;
import com.maciej916.indreb.common.api.blockentity.interfaces.IBaseProgress;
import com.maciej916.indreb.common.api.enums.GuiSprite;
import com.maciej916.indreb.common.api.interfaces.screen.IGuiHelper;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public abstract class BaseProgressWidget extends BaseWidget {

    private final IBaseProgress progress;
    private GuiSprite guiSprite;
    private final Direction direction;
    private final boolean reverse;
    private int x;
    private int y;

    public BaseProgressWidget(IGuiHelper helper, int x, int y, IBaseProgress progress, GuiSprite guiSprite, Direction direction, boolean reverse) {
        super(helper, x, y, guiSprite.getWidth(), guiSprite.getHeight());
        this.progress = progress;
        this.guiSprite = guiSprite;
        this.direction = direction;
        this.reverse = reverse;
        this.x = x;
        this.y = y;
    }

    public void setProgressType(int x, int y, GuiSprite guiSprite) {
        this.x = x;
        this.y = y;
        this.setProgressType(guiSprite);
    }

    public void setProgressType(GuiSprite guiSprite) {
        this.guiSprite = guiSprite;
        this.width = guiSprite.getWidth();
        this.height = guiSprite.getHeight();
    }

    public IBaseProgress getProgress() {
        return progress;
    }

    public GuiSprite getGuiSprite() {
        return guiSprite;
    }

    public Direction getDirection() {
        return direction;
    }

    public boolean isReverse() {
        return reverse;
    }

    @Override
    public void renderBackground(GuiGraphics guiGraphics, Minecraft pMinecraft, int pMouseX, int pMouseY) {
        RenderSystem.setShaderTexture(0, getResourceLocation());

        guiGraphics.blit(getResourceLocation(), getX(), getY(), guiSprite.getOffsetLeft(), guiSprite.getOffsetTop(), guiSprite.getWidth(), guiSprite.getHeight());

        float currProgress = Math.min(progress.getPercentProgress(), 100);
        int scaleX = Math.round(currProgress / 100 * guiSprite.getActiveHeight());
        int scaleY = Math.round(currProgress / 100 * guiSprite.getActiveWidth());

        switch (direction) {
            case VERTICAL:
                if (reverse) {
                    guiGraphics.blit(
                            getResourceLocation(),
                            getX() + guiSprite.getRenderOffsetLeft(),
                            getY() + guiSprite.getRenderOffsetTop() + guiSprite.getActiveHeight() - scaleX,
                            guiSprite.getActiveOffsetLeft(),
                            guiSprite.getActiveOffsetTop() + guiSprite.getActiveHeight() - scaleX,
                            guiSprite.getActiveWidth(),
                            scaleX
                    );
                } else {
                    guiGraphics.blit(
                            getResourceLocation(),
                            getX() + guiSprite.getRenderOffsetLeft(),
                            getY() + guiSprite.getRenderOffsetTop() + scaleX,
                            guiSprite.getActiveOffsetLeft(), guiSprite.getActiveOffsetTop() + scaleX,
                            guiSprite.getActiveWidth(),
                            scaleX * -1
                    );
                }
                break;
            case HORIZONTAL:
                if (reverse) {
                    guiGraphics.blit(
                            getResourceLocation(),
                            getX() + guiSprite.getRenderOffsetLeft(),
                            getY() + guiSprite.getRenderOffsetTop(),
                            guiSprite.getActiveOffsetLeft(),
                            guiSprite.getActiveOffsetTop(),
                            guiSprite.getActiveWidth() - scaleY,
                            guiSprite.getActiveHeight()
                    );
                } else {
                    guiGraphics.blit(
                            getResourceLocation(),
                            getX() + guiSprite.getRenderOffsetLeft(),
                            getY() + guiSprite.getRenderOffsetTop(),
                            guiSprite.getActiveOffsetLeft(),
                            guiSprite.getActiveOffsetTop(),
                            scaleY,
                            guiSprite.getActiveHeight()
                    );
                }
                break;
        }

        super.renderBackground(guiGraphics, pMinecraft, pMouseX, pMouseY);
    }

    @Override
    public @NotNull ResourceLocation getResourceLocation() {
        return new ResourceLocation(IndReb.MODID, "textures/gui/container/process.png");
    }

    public enum Direction {
        VERTICAL,
        HORIZONTAL
    }
}
