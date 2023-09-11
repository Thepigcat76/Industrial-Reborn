package com.maciej916.indreb.common.api.screen;

import mezz.jei.api.gui.handlers.IGuiClickableArea;
import mezz.jei.api.gui.handlers.IGuiContainerHandler;
import mezz.jei.api.runtime.IClickableIngredient;
import net.minecraft.client.renderer.Rect2i;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class WidgetScreenHandler<Panel extends WidgetScreen<?>> implements IGuiContainerHandler<Panel> {

    @Override
    public List<Rect2i> getGuiExtraAreas(Panel containerScreen) {
        return containerScreen.getAreas();
    }

    @Override
    public Optional<IClickableIngredient<?>> getClickableIngredientUnderMouse(Panel containerScreen, double mouseX, double mouseY) {
        return Optional.empty();
    }

    @Override
    public Collection<IGuiClickableArea> getGuiClickableAreas(Panel containerScreen, double mouseX, double mouseY) {
        return Collections.emptyList();
    }
}