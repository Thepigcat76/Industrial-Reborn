package com.maciej916.indreb.common.screen.widget.button;

import com.maciej916.indreb.common.api.enums.GuiSprite;
import com.maciej916.indreb.common.api.interfaces.screen.IGuiHelper;
import com.maciej916.indreb.common.api.screen.widget.BaseButtonWidget;
import com.maciej916.indreb.common.block.impl.machine.t_super.scanner.BlockEntityScanner;
import com.maciej916.indreb.common.enums.EnumLang;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;

public class ScannerClearButtonWidget extends BaseButtonWidget {

    private final BlockEntityScanner entity;

    public ScannerClearButtonWidget(IGuiHelper helper, BlockEntityScanner entity) {
        super(helper, 76, 36, GuiSprite.SCANNER_CLEAR, entity.clickCleanScanClient(), null);
        this.entity = entity;
    }

    @Override
    public void renderToolTip(Screen screen, GuiGraphics guiGraphics, int pMouseX, int pMouseY) {
        if (isHoveredOrFocused() && entity.getMode().getId() >= 4) {
            guiGraphics.renderTooltip(screen.getMinecraft().font, EnumLang.CLEAR_PATTERN.getTranslationComponent(), pMouseX, pMouseY);
        }
    }

    @Override
    protected boolean onLeftClick() {
        if (entity.getMode().getId() >= 4) {
            super.onLeftClick();
        }

        return false;
    }

    @Override
    public void renderBackground(GuiGraphics guiGraphics, Minecraft pMinecraft, int pMouseX, int pMouseY) {
        if (entity.getMode().getId() >= 4) {
            super.renderBackground(guiGraphics, pMinecraft, pMouseX, pMouseY);
        }
    }
}
