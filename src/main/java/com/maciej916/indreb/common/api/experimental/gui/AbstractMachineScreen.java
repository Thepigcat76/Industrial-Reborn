package com.maciej916.indreb.common.api.experimental.gui;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public abstract class AbstractMachineScreen<Menu extends AbstractMachineMenu> extends BaseScreen<Menu> {
    public AbstractMachineScreen(Menu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }
}
