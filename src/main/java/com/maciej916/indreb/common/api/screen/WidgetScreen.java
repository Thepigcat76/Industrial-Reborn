package com.maciej916.indreb.common.api.screen;

import com.maciej916.indreb.common.api.screen.widget.BaseWidget;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.Rect2i;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

import java.util.ArrayList;
import java.util.List;

public class WidgetScreen <T extends IndRebContainerMenu> extends BaseScreen<T> {

    private final List<BaseWidget> widgets = new ArrayList<>();

    public WidgetScreen(T menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    protected void addUsableWidget(BaseWidget widget) {
        widgets.add(widget);
        super.addRenderableWidget(widget);
    }

    protected void addRenderableOnlyWidget(BaseWidget widget) {
        widgets.add(widget);
        super.addRenderableOnly(widget);
    }

    protected void drawWidgets(boolean draw) {
        for (BaseWidget widget : widgets) widget.visible = draw;
    }

    @Override
    protected void renderTooltip(GuiGraphics pGuiGraphics, int pX, int pY) {
        super.renderTooltip(pGuiGraphics, pX, pY);
        for (BaseWidget widget : widgets) {
            widget.renderToolTip(this, pGuiGraphics, pX, pY);
        }
    }

    public List<Rect2i> getAreas() {
        List<Rect2i> extraAreas = new ArrayList<>();

        for (BaseWidget widget : widgets) {
            if (widget.addsExtraArea()) {
                extraAreas.add(new Rect2i(widget.getX(), widget.getY(), widget.getWidth(), widget.getHeight()));
            }
        }

        return extraAreas;
    }
}
