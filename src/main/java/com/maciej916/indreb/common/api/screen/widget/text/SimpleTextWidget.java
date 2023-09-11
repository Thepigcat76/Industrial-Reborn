package com.maciej916.indreb.common.api.screen.widget.text;

import com.maciej916.indreb.common.api.interfaces.screen.IGuiHelper;
import com.maciej916.indreb.common.api.screen.widget.BaseWidget;
import com.maciej916.indreb.common.util.GuiUtil;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.MutableComponent;

public class SimpleTextWidget extends BaseWidget {

    private final MutableComponent component;
    private final float scale;
    private final int color;
    private final boolean shadow;

    public SimpleTextWidget(IGuiHelper helper, int x, int y, int width, int height, MutableComponent component,  float scale, int color, boolean shadow) {
        super(helper, x, y, width, height);
        this.component = component;
        this.scale = scale;
        this.color = color;
        this.shadow = shadow;
    }

    @Override
    public void renderButton(GuiGraphics guiGraphics, int pMouseX, int pMouseY, float pPartialTicks) {
        GuiUtil.renderScaled(guiGraphics, component.getString(), getX(), getY(), scale, color, shadow);
        super.renderButton(guiGraphics, pMouseX, pMouseY, pPartialTicks);
    }

    @Override
    protected void renderWidget(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {

    }
}
