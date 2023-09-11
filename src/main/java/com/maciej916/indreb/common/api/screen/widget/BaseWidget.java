package com.maciej916.indreb.common.api.screen.widget;

import com.maciej916.indreb.common.api.interfaces.screen.IGuiHelper;
import com.maciej916.indreb.common.api.interfaces.screen.IWidget;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public abstract class BaseWidget extends AbstractWidget implements IWidget {

    IGuiHelper helper;
    private final int x;
    private final int y;

    public BaseWidget(IGuiHelper helper, int x, int y, int width, int height) {
        super(helper.getGuiLeft() + x, helper.getGuiTop() + y, width, height, Component.literal(""));
        this.helper = helper;
        this.x = x;
        this.y = y;
    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput pNarrationElementOutput) {

    }

    protected void renderBackground(GuiGraphics guiGraphics, Minecraft pMinecraft, int pMouseX, int pMouseY) {}

    @Override
    public boolean addsExtraArea() {
        return false;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void renderButton(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        Minecraft minecraft = Minecraft.getInstance();
        this.renderWidget(guiGraphics, mouseX, mouseY, partialTick);
        // heelo
    }

    public boolean isShiftDown() {
        return Screen.hasShiftDown();
    }

    public void renderToolTip(Screen screen, GuiGraphics guiGraphics, int pMouseX, int pMouseY) {
    }

    @NotNull
    public ResourceLocation getResourceLocation() {
        return WIDGETS_LOCATION;
    }

    @Override
    protected void renderWidget(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {

    }
}
