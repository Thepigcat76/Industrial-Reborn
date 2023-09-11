package com.maciej916.indreb.common.api.screen.widget.bar;

import com.maciej916.indreb.IndReb;
import com.maciej916.indreb.common.api.blockentity.interfaces.IBaseProgress;
import com.maciej916.indreb.common.api.enums.GuiSprite;
import com.maciej916.indreb.common.api.interfaces.screen.IGuiHelper;
import com.maciej916.indreb.common.api.screen.widget.BaseProgressWidget;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class GuiHeatBarHorizontalWidget extends BaseProgressWidget {

    public GuiHeatBarHorizontalWidget(IGuiHelper helper, int x, int y, IBaseProgress progress) {
        super(helper, x, y, progress, GuiSprite.HEAT_VERTICAL, Direction.HORIZONTAL, false);
    }

    @Override
    public void renderToolTip(Screen screen, GuiGraphics guiGraphics, int pMouseX, int pMouseY) {
        if (isHoveredOrFocused()) {
            guiGraphics.renderTooltip(screen.getMinecraft().font, Component.translatable("tooltip." + IndReb.MODID + ".heat", getProgress().getPercentProgressString() + "%"), pMouseX, pMouseY);
        }
        super.renderToolTip(screen, guiGraphics, pMouseX, pMouseY);
    }

    @Override
    public @NotNull ResourceLocation getResourceLocation() {
        return new ResourceLocation(IndReb.MODID, "textures/gui/container/common.png");
    }

}
