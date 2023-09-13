package com.maciej916.indreb.common.screen.widget.text;

import com.maciej916.indreb.IndReb;
import com.maciej916.indreb.common.api.blockentity.interfaces.IBaseProgress;
import com.maciej916.indreb.common.api.interfaces.screen.IGuiHelper;
import com.maciej916.indreb.common.api.screen.widget.BaseWidget;
import com.maciej916.indreb.common.util.GuiUtil;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

public class TemperatureTextWidget extends BaseWidget {

    private final IBaseProgress progress;

    public TemperatureTextWidget(IGuiHelper helper, int x, int y, IBaseProgress progress) {
        super(helper, x, y, 73, 7);
        this.progress = progress;
    }

    @Override
    public void renderButton(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        MutableComponent component = Component.translatable("gui." + IndReb.MODID + ".temperature", GuiUtil.DECIMAL_FORMAT_1.format(progress.getCurrentProgress()) + " " + GuiUtil.DEGREE_SYMBOL + "C");
        GuiUtil.renderScaledCenter(guiGraphics, component, getX(), getWidth(), getY(), 0.8f, 4210752, false);
        super.renderButton(guiGraphics, mouseX, mouseY, partialTick);
    }
}
