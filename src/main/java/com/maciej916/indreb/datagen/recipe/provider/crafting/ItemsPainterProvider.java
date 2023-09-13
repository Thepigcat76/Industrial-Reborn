package com.maciej916.indreb.datagen.recipe.provider.crafting;

import com.maciej916.indreb.common.item.ModItems;
import com.maciej916.indreb.common.tag.ModItemTags;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

import static com.maciej916.indreb.IndReb.MODID;

public class ItemsPainterProvider extends RecipeProvider {

    public ItemsPainterProvider(PackOutput packOutput) {
        super(packOutput);
    }

    private ResourceLocation saveResource(String name) {
        return new ResourceLocation(MODID, "crafting/items/tool/" + name);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.PAINTER.get())
                .pattern("www")
                .pattern("  i")
                .pattern(" i ")
                .define('i', ModItemTags.FORGE_RODS_IRON)
                .define('w', Items.WHITE_WOOL)
                .group(MODID + "/items/painter")
                .unlockedBy("iron_rod", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_ROD.get()))
                .unlockedBy("white_wool", InventoryChangeTrigger.TriggerInstance.hasItems(Items.WHITE_WOOL))
                .save(consumer, saveResource("painter"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ModItems.PAINTER_WHITE.get())
                .requires(ModItems.PAINTER.get())
                .requires(Items.BONE_MEAL)
                .group(MODID + "/items/painter")
                .unlockedBy("painter", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PAINTER.get()))
                .unlockedBy("bone_meal", InventoryChangeTrigger.TriggerInstance.hasItems(Items.BONE_MEAL))
                .save(consumer, saveResource("painter_white"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ModItems.PAINTER_RED.get())
                .requires(ModItems.PAINTER.get())
                .requires(Items.RED_DYE)
                .group(MODID + "/items/painter")
                .unlockedBy("painter", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PAINTER.get()))
                .unlockedBy("red_dye", InventoryChangeTrigger.TriggerInstance.hasItems(Items.RED_DYE))
                .save(consumer, saveResource("painter_red"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ModItems.PAINTER_ORANGE.get())
                .requires(ModItems.PAINTER.get())
                .requires(Items.ORANGE_DYE)
                .group(MODID + "/items/painter")
                .unlockedBy("painter", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PAINTER.get()))
                .unlockedBy("orange_dye", InventoryChangeTrigger.TriggerInstance.hasItems(Items.ORANGE_DYE))
                .save(consumer, saveResource("painter_orange"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ModItems.PAINTER_PINK.get())
                .requires(ModItems.PAINTER.get())
                .requires(Items.PINK_DYE)
                .group(MODID + "/items/painter")
                .unlockedBy("painter", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PAINTER.get()))
                .unlockedBy("pink_dye", InventoryChangeTrigger.TriggerInstance.hasItems(Items.PINK_DYE))
                .save(consumer, saveResource("painter_pink"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ModItems.PAINTER_YELLOW.get())
                .requires(ModItems.PAINTER.get())
                .requires(Items.YELLOW_DYE)
                .group(MODID + "/items/painter")
                .unlockedBy("painter", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PAINTER.get()))
                .unlockedBy("yellow_dye", InventoryChangeTrigger.TriggerInstance.hasItems(Items.YELLOW_DYE))
                .save(consumer, saveResource("painter_yellow"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ModItems.PAINTER_LIME.get())
                .requires(ModItems.PAINTER.get())
                .requires(Items.LIME_DYE)
                .group(MODID + "/items/painter")
                .unlockedBy("painter", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PAINTER.get()))
                .unlockedBy("lime_dye", InventoryChangeTrigger.TriggerInstance.hasItems(Items.LIME_DYE))
                .save(consumer, saveResource("painter_lime"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ModItems.PAINTER_GREEN.get())
                .requires(ModItems.PAINTER.get())
                .requires(Items.GREEN_DYE)
                .group(MODID + "/items/painter")
                .unlockedBy("painter", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PAINTER.get()))
                .unlockedBy("green_dye", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GREEN_DYE))
                .save(consumer, saveResource("painter_green"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ModItems.PAINTER_LIGHT_BLUE.get())
                .requires(ModItems.PAINTER.get())
                .requires(Items.LIGHT_BLUE_DYE)
                .group(MODID + "/items/painter")
                .unlockedBy("painter", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PAINTER.get()))
                .unlockedBy("light_blue_dye", InventoryChangeTrigger.TriggerInstance.hasItems(Items.LIGHT_BLUE_DYE))
                .save(consumer, saveResource("painter_light_blue"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ModItems.PAINTER_CYAN.get())
                .requires(ModItems.PAINTER.get())
                .requires(Items.CYAN_DYE)
                .group(MODID + "/items/painter")
                .unlockedBy("painter", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PAINTER.get()))
                .unlockedBy("cyan_dye", InventoryChangeTrigger.TriggerInstance.hasItems(Items.CYAN_DYE))
                .save(consumer, saveResource("painter_cyan"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ModItems.PAINTER_BLUE.get())
                .requires(ModItems.PAINTER.get())
                .requires(Items.BLUE_DYE)
                .group(MODID + "/items/painter")
                .unlockedBy("painter", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PAINTER.get()))
                .unlockedBy("blue_dye", InventoryChangeTrigger.TriggerInstance.hasItems(Items.BLUE_DYE))
                .save(consumer, saveResource("painter_blue"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ModItems.PAINTER_MAGENTA.get())
                .requires(ModItems.PAINTER.get())
                .requires(Items.MAGENTA_DYE)
                .group(MODID + "/items/painter")
                .unlockedBy("painter", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PAINTER.get()))
                .unlockedBy("magenta_dye", InventoryChangeTrigger.TriggerInstance.hasItems(Items.MAGENTA_DYE))
                .save(consumer, saveResource("painter_magenta"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ModItems.PAINTER_PURPLE.get())
                .requires(ModItems.PAINTER.get())
                .requires(Items.PURPLE_DYE)
                .group(MODID + "/items/painter")
                .unlockedBy("painter", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PAINTER.get()))
                .unlockedBy("purple_dye", InventoryChangeTrigger.TriggerInstance.hasItems(Items.PURPLE_DYE))
                .save(consumer, saveResource("painter_purple"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ModItems.PAINTER_BROWN.get())
                .requires(ModItems.PAINTER.get())
                .requires(Items.BROWN_DYE)
                .group(MODID + "/items/painter")
                .unlockedBy("painter", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PAINTER.get()))
                .unlockedBy("brown_dye", InventoryChangeTrigger.TriggerInstance.hasItems(Items.BROWN_DYE))
                .save(consumer, saveResource("painter_brown"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ModItems.PAINTER_GRAY.get())
                .requires(ModItems.PAINTER.get())
                .requires(Items.GRAY_DYE)
                .group(MODID + "/items/painter")
                .unlockedBy("painter", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PAINTER.get()))
                .unlockedBy("gray_dye", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GRAY_DYE))
                .save(consumer, saveResource("painter_gray"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ModItems.PAINTER_LIGHT_GRAY.get())
                .requires(ModItems.PAINTER.get())
                .requires(Items.LIGHT_GRAY_DYE)
                .group(MODID + "/items/painter")
                .unlockedBy("painter", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PAINTER.get()))
                .unlockedBy("light_gray_dye", InventoryChangeTrigger.TriggerInstance.hasItems(Items.LIGHT_GRAY_DYE))
                .save(consumer, saveResource("painter_light_gray"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ModItems.PAINTER_BLACK.get())
                .requires(ModItems.PAINTER.get())
                .requires(Items.BLACK_DYE)
                .group(MODID + "/items/painter")
                .unlockedBy("painter", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PAINTER.get()))
                .unlockedBy("black_dye", InventoryChangeTrigger.TriggerInstance.hasItems(Items.BLACK_DYE))
                .save(consumer, saveResource("painter_black"));


    }
}