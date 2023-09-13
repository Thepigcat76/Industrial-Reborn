package com.maciej916.indreb.common.item.impl;

import com.maciej916.indreb.common.api.interfaces.item.IPainter;
import com.maciej916.indreb.common.api.item.base.ToolItem;
import com.maciej916.indreb.common.block.ModBlocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;

public class Painter extends ToolItem implements IPainter {

    private final MapColor color;
    private static final HashMap<MapColor, RegistryObject<Block>> COLOR_TO_BLOCK = new HashMap<>() {{
        put(MapColor.WOOL, ModBlocks.CONSTRUCTION_FOAM_WALL_WHITE);
        put(MapColor.COLOR_RED, ModBlocks.CONSTRUCTION_FOAM_WALL_RED);
        put(MapColor.COLOR_ORANGE, ModBlocks.CONSTRUCTION_FOAM_WALL_ORANGE);
        put(MapColor.COLOR_PINK, ModBlocks.CONSTRUCTION_FOAM_WALL_PINK);
        put(MapColor.COLOR_YELLOW, ModBlocks.CONSTRUCTION_FOAM_WALL_YELLOW);
        put(MapColor.COLOR_LIGHT_GREEN, ModBlocks.CONSTRUCTION_FOAM_WALL_LIME);
        put(MapColor.COLOR_GREEN, ModBlocks.CONSTRUCTION_FOAM_WALL_GREEN);
        put(MapColor.COLOR_LIGHT_BLUE, ModBlocks.CONSTRUCTION_FOAM_WALL_LIGHT_BLUE);
        put(MapColor.COLOR_CYAN, ModBlocks.CONSTRUCTION_FOAM_WALL_CYAN);
        put(MapColor.COLOR_BLUE, ModBlocks.CONSTRUCTION_FOAM_WALL_BLUE);
        put(MapColor.COLOR_MAGENTA, ModBlocks.CONSTRUCTION_FOAM_WALL_MAGENTA);
        put(MapColor.COLOR_PURPLE, ModBlocks.CONSTRUCTION_FOAM_WALL_PURPLE);
        put(MapColor.COLOR_BROWN, ModBlocks.CONSTRUCTION_FOAM_WALL_BROWN);
        put(MapColor.COLOR_GRAY, ModBlocks.CONSTRUCTION_FOAM_WALL_GRAY);
        put(MapColor.COLOR_LIGHT_GRAY, ModBlocks.CONSTRUCTION_FOAM_WALL_LIGHT_GRAY);
        put(MapColor.COLOR_BLACK, ModBlocks.CONSTRUCTION_FOAM_WALL_BLACK);
    }};

    public Painter(MapColor color) {
        super(32);
        this.color = color;
    }

    public MapColor getColor() {
        return color;
    }

    public BlockState getState() {
        return COLOR_TO_BLOCK.get(color).get().defaultBlockState();
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return false;
    }
}
