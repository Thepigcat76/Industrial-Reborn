package com.maciej916.indreb.common.api.screen.widget.text;

import com.maciej916.indreb.common.api.blockentity.interfaces.IBaseProgress;
import com.maciej916.indreb.common.api.interfaces.screen.IGuiHelper;
import com.maciej916.indreb.common.api.screen.widget.BaseWidget;
import com.maciej916.indreb.common.util.GuiUtil;
import net.minecraft.client.gui.GuiGraphics;

public class PercentProgressTextWidget extends BaseWidget {

    private final IBaseProgress progress;
    private final String prepend;
    private final String append;
    private final float scale;
    private final int color;
    private final boolean shadow;

    public PercentProgressTextWidget(IGuiHelper helper, int x, int y, int width, int height, IBaseProgress progress, String prepend, String append, float scale, int color, boolean shadow) {
        super(helper, x, y, width, height);
        this.progress = progress;
        this.prepend = prepend;
        this.append = append;
        this.scale = scale;
        this.color = color;
        this.shadow = shadow;
    }

    @Override
    protected void renderWidget(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        GuiUtil.renderScaled(pGuiGraphics, prepend + progress.getPercentProgressString() + append, getX(), getY(), scale, color, shadow);
        super.renderButton(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
    }
}
