package com.maciej916.indreb.common.api.experimental.gui;

import net.minecraft.world.inventory.MenuType;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractMachineMenu extends BaseMenu {
    protected AbstractMachineMenu(@Nullable MenuType<?> pMenuType, int pContainerId) {
        super(pMenuType, pContainerId);
    }
}
