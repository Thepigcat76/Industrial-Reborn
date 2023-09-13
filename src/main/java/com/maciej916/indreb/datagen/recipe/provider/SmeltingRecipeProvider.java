package com.maciej916.indreb.datagen.recipe.provider;

import com.maciej916.indreb.common.item.ModItems;
import com.maciej916.indreb.common.tag.ModItemTags;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Consumer;

import static com.maciej916.indreb.IndReb.MODID;

public class SmeltingRecipeProvider extends RecipeProvider {

    public SmeltingRecipeProvider(PackOutput packOutput) {
        super(packOutput);
    }

    private ResourceLocation saveResource(String name) {
        return new ResourceLocation(MODID, "smelting/" + name);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {


        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItemTags.FORGE_RAW_MATERIALS_TIN), RecipeCategory.MISC, ModItems.TIN_INGOT.get(), 0.8f, 200)
                .unlockedBy("raw_tin", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RAW_TIN.get()))
                .save(consumer, saveResource("raw_tin_tin_ingot"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItemTags.FORGE_ORE_TIN), RecipeCategory.MISC, ModItems.TIN_INGOT.get(), 0.8f, 200)
                .unlockedBy("tin_ore", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TIN_ORE.get()))
                .save(consumer, saveResource("tin_ore_tin_ingot"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItemTags.FORGE_DUSTS_TIN), RecipeCategory.MISC, ModItems.TIN_INGOT.get(), 0.8f, 200)
                .unlockedBy("tin_dust", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TIN_DUST.get()))
                .save(consumer, saveResource("tin_dust_tin_ingot"));


        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItemTags.FORGE_RAW_MATERIALS_LEAD), RecipeCategory.MISC, ModItems.LEAD_INGOT.get(), 0.8f, 200)
                .unlockedBy("raw_lead", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RAW_LEAD.get()))
                .save(consumer, saveResource("raw_lead_lead_ingot"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItemTags.FORGE_ORE_LEAD), RecipeCategory.MISC, ModItems.LEAD_INGOT.get(), 0.8f, 200)
                .unlockedBy("lead_ore", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LEAD_ORE.get()))
                .save(consumer, saveResource("lead_ore_lead_ingot"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItemTags.FORGE_DUSTS_LEAD), RecipeCategory.MISC, ModItems.LEAD_INGOT.get(), 0.8f, 200)
                .unlockedBy("lead_dust", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LEAD_DUST.get()))
                .save(consumer, saveResource("lead_dust_lead_ingot"));


        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItemTags.FORGE_RAW_MATERIALS_URANIUM), RecipeCategory.MISC, ModItems.URANIUM_INGOT.get(), 0.8f, 200)
                .unlockedBy("raw_uranium", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RAW_URANIUM.get()))
                .save(consumer, saveResource("raw_uranium_uranium_ingot"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItemTags.FORGE_ORE_URANIUM), RecipeCategory.MISC, ModItems.URANIUM_INGOT.get(), 0.8f, 200)
                .unlockedBy("uranium_ore", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.URANIUM_ORE.get()))
                .save(consumer, saveResource("uranium_ore_uranium_ingot"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItemTags.FORGE_DUSTS_URANIUM), RecipeCategory.MISC, ModItems.URANIUM_INGOT.get(), 0.8f, 200)
                .unlockedBy("uranium_dust", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.URANIUM_DUST.get()))
                .save(consumer, saveResource("uranium_dust_uranium_ingot"));


        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItemTags.FORGE_RAW_MATERIALS_SILVER), RecipeCategory.MISC, ModItems.SILVER_INGOT.get(), 0.8f, 200)
                .unlockedBy("raw_silver", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RAW_SILVER.get()))
                .save(consumer, saveResource("raw_silver_silver_ingot"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItemTags.FORGE_ORE_SILVER), RecipeCategory.MISC, ModItems.SILVER_INGOT.get(), 0.8f, 200)
                .unlockedBy("silver_ore", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SILVER_ORE.get()))
                .save(consumer, saveResource("silver_ore_silver_ingot"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItemTags.FORGE_DUSTS_SILVER), RecipeCategory.MISC, ModItems.SILVER_INGOT.get(), 0.8f, 200)
                .unlockedBy("silver_dust", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SILVER_DUST.get()))
                .save(consumer, saveResource("silver_dust_silver_ingot"));


        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItemTags.FORGE_DUSTS_COPPER), RecipeCategory.MISC, Items.COPPER_INGOT, 0.8f, 200)
                .unlockedBy("copper_dust", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_DUST.get()))
                .save(consumer, saveResource("copper_dust_copper_ingot"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItemTags.FORGE_DUSTS_IRON), RecipeCategory.MISC, Items.IRON_INGOT, 0.8f, 200)
                .unlockedBy("iron_dust", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_DUST.get()))
                .save(consumer, saveResource("iron_dust_iron_ingot"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItemTags.FORGE_DUSTS_GOLD), RecipeCategory.MISC, Items.GOLD_INGOT, 0.8f, 200)
                .unlockedBy("gold_dust", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GOLD_DUST.get()))
                .save(consumer, saveResource("gold_dust_gold_ingot"));


        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.REINFORCED_STONE.get()), RecipeCategory.MISC, ModItems.SMOOTH_REINFORCED_STONE.get(), 0.1f, 200)
                .unlockedBy("reinforced_stone", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.REINFORCED_STONE.get()))
                .save(consumer, saveResource("smooth_reinforced_stone"));

    }
}