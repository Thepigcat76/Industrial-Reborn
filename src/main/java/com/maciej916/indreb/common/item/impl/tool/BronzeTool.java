package com.maciej916.indreb.common.item.impl.tool;

import com.maciej916.indreb.common.api.enums.ToolTypes;
import com.maciej916.indreb.common.api.tier.CustomTiers;
import net.minecraft.world.item.*;

public class BronzeTool {
    private final ToolTypes type;

    public BronzeTool(ToolTypes type) {
        this.type = type;
    }

    public Item getTool() {
        return switch (this.type) {
            case AXE -> new AxeItem(CustomTiers.BRONZE, 0f, 0f, new Item.Properties().stacksTo(1));
            case HOE -> new HoeItem(CustomTiers.BRONZE, 0, 0f, new Item.Properties().stacksTo(1));
            case SHOVEL -> new ShovelItem(CustomTiers.BRONZE, 0f, 0f, new Item.Properties().stacksTo(1));
            case SWORD -> new SwordItem(CustomTiers.BRONZE, 0, 0f, new Item.Properties().stacksTo(1));
            case PICKAXE -> new PickaxeItem(CustomTiers.BRONZE, 0, 0f, new Item.Properties().stacksTo(1));
        };
    }
}
