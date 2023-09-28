package com.maciej916.indreb.common.api.experimental.gui;

import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;

public abstract class BaseScreen<Menu extends AbstractContainerMenu> extends AbstractContainerScreen<Menu> {
    public BaseScreen(Menu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }
}
