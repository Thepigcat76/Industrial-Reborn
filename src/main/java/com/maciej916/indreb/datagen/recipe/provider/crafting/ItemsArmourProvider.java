package com.maciej916.indreb.datagen.recipe.provider.crafting;

import com.maciej916.indreb.common.block.ModBlocks;
import com.maciej916.indreb.common.item.ModItems;
import com.maciej916.indreb.common.tag.ModItemTags;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

import static com.maciej916.indreb.IndReb.MODID;

public class ItemsArmourProvider extends RecipeProvider {

    public ItemsArmourProvider(PackOutput packOutput) {
        super(packOutput);
    }

    private ResourceLocation saveResource(String name) {
        return new ResourceLocation(MODID, "crafting/items/armour/" + name);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BRONZE_HELMET.get())
                .pattern("bbb")
                .pattern("b b")
                .define('b', ModItemTags.FORGE_INGOTS_BRONZE)
                .group(MODID + "/items/bronze")
                .unlockedBy("bronze_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BRONZE_INGOT.get()))
                .save(consumer, saveResource("bronze_helmet"));
        
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BRONZE_CHESTPLATE.get())
                .pattern("b b")
                .pattern("bbb")
                .pattern("bbb")
                .define('b', ModItemTags.FORGE_INGOTS_BRONZE)
                .group(MODID + "/items/bronze")
                .unlockedBy("bronze_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BRONZE_INGOT.get()))
                .save(consumer, saveResource("bronze_chestplate"));
        
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BRONZE_LEGGINGS.get())
                .pattern("bbb")
                .pattern("b b")
                .pattern("b b")
                .define('b', ModItemTags.FORGE_INGOTS_BRONZE)
                .group(MODID + "/items/bronze")
                .unlockedBy("bronze_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BRONZE_INGOT.get()))
                .save(consumer, saveResource("bronze_leggings"));
        
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BRONZE_BOOTS.get())
                .pattern("b b")
                .pattern("b b")
                .define('b', ModItemTags.FORGE_INGOTS_BRONZE)
                .group(MODID + "/items/bronze")
                .unlockedBy("bronze_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BRONZE_INGOT.get()))
                .save(consumer, saveResource("bronze_boots"));
        
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.RUBBER_BOOTS.get())
                .pattern("r r")
                .pattern("r r")
                .pattern("rwr")
                .define('r', ModItems.RUBBER.get())
                .define('w', Items.WHITE_WOOL)
                .group(MODID + "/items/bronze")
                .unlockedBy("rubber", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RUBBER.get()))
                .unlockedBy("white_wool", InventoryChangeTrigger.TriggerInstance.hasItems(Items.WHITE_WOOL))
                .save(consumer, saveResource("rubber_boots"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.NIGHTVISION_GOGGLES.get())
                .pattern(" b ")
                .pattern("lgl")
                .pattern("rar")
                .define('b', ModItems.ADVANCED_BATTERY.get())
                .define('l', ModBlocks.LUMINATOR.get())
                .define('g', ModBlocks.REINFORCED_GLASS.get())
                .define('r', ModItems.RUBBER.get())
                .define('a', ModItems.ADVANCED_CIRCUIT.get())
                .group(MODID + "/items/armour")
                .unlockedBy("advanced_battery", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ADVANCED_BATTERY.get()))
                .unlockedBy("luminator", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.LUMINATOR.get()))
                .unlockedBy("reinforced_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.REINFORCED_GLASS.get()))
                .unlockedBy("rubber", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RUBBER.get()))
                .unlockedBy("advanced_circuit", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ADVANCED_CIRCUIT.get()))
                .save(consumer, saveResource("nightvision_goggles"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.NANO_HELMET.get())
                .pattern("cec")
                .pattern("cnc")
                .define('c', ModItems.CARBON_PLATE.get())
                .define('e', ModItems.ENERGY_CRYSTAL.get())
                .define('n', ModItems.NIGHTVISION_GOGGLES.get())
                .group(MODID + "/items/nano")
                .unlockedBy("carbon_plate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CARBON_PLATE.get()))
                .unlockedBy("energy_crystal", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENERGY_CRYSTAL.get()))
                .unlockedBy("nightvision_goggles", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NIGHTVISION_GOGGLES.get()))
                .save(consumer, saveResource("nano_helmet"));
        
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.NANO_CHESTPLATE.get())
                .pattern("c c")
                .pattern("cec")
                .pattern("ccc")
                .define('c', ModItems.CARBON_PLATE.get())
                .define('e', ModItems.ENERGY_CRYSTAL.get())
                .group(MODID + "/items/nano")
                .unlockedBy("carbon_plate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CARBON_PLATE.get()))
                .unlockedBy("energy_crystal", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENERGY_CRYSTAL.get()))
                .save(consumer, saveResource("nano_chestplate"));
        
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.NANO_LEGGINGS.get())
                .pattern("cec")
                .pattern("c c")
                .pattern("c c")
                .define('c', ModItems.CARBON_PLATE.get())
                .define('e', ModItems.ENERGY_CRYSTAL.get())
                .group(MODID + "/items/nano")
                .unlockedBy("carbon_plate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CARBON_PLATE.get()))
                .unlockedBy("energy_crystal", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENERGY_CRYSTAL.get()))
                .save(consumer, saveResource("nano_leggings"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.NANO_BOOTS.get())
                .pattern("cbc")
                .pattern("cec")
                .define('c', ModItems.CARBON_PLATE.get())
                .define('e', ModItems.ENERGY_CRYSTAL.get())
                .define('b', ModItems.RUBBER_BOOTS.get())
                .group(MODID + "/items/nano")
                .unlockedBy("carbon_plate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CARBON_PLATE.get()))
                .unlockedBy("energy_crystal", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENERGY_CRYSTAL.get()))
                .unlockedBy("rubber_boots", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RUBBER_BOOTS.get()))
                .save(consumer, saveResource("nano_boots"));


        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.HAZMAT_SUIT_HELMET.get())
                .pattern("owo")
                .pattern("plp")
                .pattern("wsw")
                .define('o', ModItemTags.FORGE_DYES_ORANGE)
                .define('w', ItemTags.WOOL)
                .define('p', ModItems.RADIATION_SHIELDING.get())
                .define('l', Items.LEATHER_HELMET)
                .define('s', ModItemTags.FORGE_PLATES_STEEL)
                .group(MODID + "/items/hazmat")
                .unlockedBy("radiation_shielding", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RADIATION_SHIELDING.get()))
                .save(consumer, saveResource("hazmat_suit_helmet"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.HAZMAT_SUIT_CHESTPLATE.get())
                .pattern("wpw")
                .pattern("olo")
                .pattern("pwp")
                .define('o', ModItemTags.FORGE_DYES_ORANGE)
                .define('w', ItemTags.WOOL)
                .define('p', ModItems.RADIATION_SHIELDING.get())
                .define('l', Items.LEATHER_CHESTPLATE)
                .group(MODID + "/items/hazmat")
                .unlockedBy("radiation_shielding", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RADIATION_SHIELDING.get()))
                .save(consumer, saveResource("hazmat_suit_chestplate"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.HAZMAT_SUIT_LEGGINGS.get())
                .pattern("owo")
                .pattern("plp")
                .pattern("w w")
                .define('o', ModItemTags.FORGE_DYES_ORANGE)
                .define('w', ItemTags.WOOL)
                .define('p', ModItems.RADIATION_SHIELDING.get())
                .define('l', Items.LEATHER_LEGGINGS)
                .group(MODID + "/items/hazmat")
                .unlockedBy("radiation_shielding", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RADIATION_SHIELDING.get()))
                .save(consumer, saveResource("hazmat_suit_leggings"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.HAZMAT_SUIT_BOOTS.get())
                .pattern("pop")
                .pattern("wlw")
                .define('o', ModItemTags.FORGE_DYES_BLACK)
                .define('p', ModItems.RADIATION_SHIELDING.get())
                .define('l', Items.LEATHER_BOOTS)
                .define('w', ItemTags.WOOL)
                .group(MODID + "/items/hazmat")
                .unlockedBy("radiation_shielding", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RADIATION_SHIELDING.get()))
                .save(consumer, saveResource("hazmat_suit_boots"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.QUANTUM_HELMET.get())
                .pattern("rlr")
                .pattern("ini")
                .pattern("aha")
                .define('r', ModItems.REINFORCED_GLASS.get())
                .define('l', ModItems.LAPOTRON_CRYSTAL.get())
                .define('n', ModItems.NANO_HELMET.get())
                .define('i', ModItems.IRIDIUM_PLATE.get())
                .define('a', ModItems.ADVANCED_CIRCUIT.get())
                .define('h', ModItems.HAZMAT_SUIT_HELMET.get())
                .group(MODID + "/items/quantum")
                .unlockedBy("iridum_plate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRIDIUM_PLATE.get()))
                .unlockedBy("lapotron_crystal", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LAPOTRON_CRYSTAL.get()))
                .save(consumer, saveResource("quantum_helmet"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.QUANTUM_CHESTPLATE.get())
                .pattern("ala")
                .pattern("ana")
                .pattern("rfr")
                .define('a', ModItems.ADVANCED_ALLOY_PLATE.get())
                .define('l', ModItems.LAPOTRON_CRYSTAL.get())
                .define('n', ModItems.NANO_CHESTPLATE.get())
                .define('r', ModItems.LAPOTRONIC_ENERGY_RELAY.get())
                .define('f', ModItems.IRIDIUM_NEUTRON_REFLECTOR.get())
                .group(MODID + "/items/quantum")
                .unlockedBy("iridum_plate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRIDIUM_PLATE.get()))
                .unlockedBy("lapotron_crystal", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LAPOTRON_CRYSTAL.get()))
                .save(consumer, saveResource("quantum_chestplate"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.QUANTUM_LEGGINGS.get())
                .pattern("ala")
                .pattern("rnr")
                .pattern("b b")
                .define('a', ModItems.ADVANCED_MACHINE_CASING.get())
                .define('l', ModItems.LAPOTRON_CRYSTAL.get())
                .define('r', ModItems.LAPOTRONIC_ENERGY_RELAY.get())
                .define('n', ModItems.NANO_LEGGINGS.get())
                .define('b', ModItems.BIOPLASTIC.get())
                .group(MODID + "/items/quantum")
                .unlockedBy("iridium_plate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRIDIUM_PLATE.get()))
                .unlockedBy("lapotron_crystal", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LAPOTRON_CRYSTAL.get()))
                .save(consumer, saveResource("quantum_leggings"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.QUANTUM_BOOTS.get())
                .pattern("ini")
                .pattern("rlr")
                .define('i', ModItems.IRIDIUM_PLATE.get())
                .define('n', ModItems.NANO_BOOTS.get())
                .define('r', ModItems.RUBBER_BOOTS.get())
                .define('l', ModItems.LAPOTRON_CRYSTAL.get())
                .group(MODID + "/items/quantum")
                .unlockedBy("iridium_plate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRIDIUM_PLATE.get()))
                .unlockedBy("lapotron_crystal", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LAPOTRON_CRYSTAL.get()))
                .save(consumer, saveResource("quantum_boots"));


    }
}