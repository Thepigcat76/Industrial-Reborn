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
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

import static com.maciej916.indreb.IndReb.MODID;

public class ItemsElectricProvider extends RecipeProvider {

    public ItemsElectricProvider(PackOutput packOutput) {
        super(packOutput);
    }

    private ResourceLocation saveResource(String name) {
        return new ResourceLocation(MODID, "crafting/items/tool/" + name);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BATTERY.get())
                .pattern(" C ")
                .pattern("TrT")
                .pattern("TrT")
                .define('C', ModBlocks.COPPER_CABLE_INSULATED.get())
                .define('r', Items.REDSTONE)
                .define('T', ModItemTags.FORGE_PLATES_TIN)
                .group(MODID + "/items/electric")
                .unlockedBy("copper_cable_insulated", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.COPPER_CABLE_INSULATED.get()))
                .save(consumer, saveResource("battery"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ADVANCED_BATTERY.get())
                .pattern("iri")
                .pattern("pbp")
                .pattern("iri")
                .define('i', ModBlocks.COPPER_CABLE_INSULATED.get())
                .define('r', Items.REDSTONE)
                .define('b', ModItems.BATTERY.get())
                .define('p', ModItemTags.FORGE_PLATES_COPPER)
                .group(MODID + "/items/electric")
                .unlockedBy("battery", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BATTERY.get()))
                .unlockedBy("copper_cable_insulated", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.COPPER_CABLE_INSULATED.get()))
                .save(consumer, saveResource("advanced_battery"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.LAPOTRON_CRYSTAL.get())
                .pattern("lal")
                .pattern("lel")
                .pattern("lal")
                .define('e', ModItems.ENERGY_CRYSTAL.get())
                .define('l', ModItemTags.FORGE_PLATES_LAPIS)
                .define('a', ModItems.ADVANCED_CIRCUIT.get())
                .group(MODID + "/items/electric")
                .unlockedBy("energy_crystal", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENERGY_CRYSTAL.get()))
                .unlockedBy("advanced_circuit", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ADVANCED_CIRCUIT.get()))
                .save(consumer, saveResource("lapotron_crystal"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.NANO_SABER.get())
                .pattern("ga ")
                .pattern("ga ")
                .pattern("cec")
                .define('c', ModItems.CARBON_PLATE.get())
                .define('e', ModItems.ENERGY_CRYSTAL.get())
                .define('g', Items.GLOWSTONE_DUST)
                .define('a', ModItems.ADVANCED_ALLOY_PLATE.get())
                .group(MODID + "/items/nano")
                .unlockedBy("carbon_plate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CARBON_PLATE.get()))
                .unlockedBy("energy_crystal", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENERGY_CRYSTAL.get()))
                .unlockedBy("glowstone_dust", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GLOWSTONE_DUST))
                .unlockedBy("advanced_alloy", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ADVANCED_ALLOY_PLATE.get()))
                .save(consumer, saveResource("nano_saber"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.MINING_DRILL.get())
                .pattern(" i ")
                .pattern("iii")
                .pattern("ipi")
                .define('i', ModItemTags.FORGE_PLATES_IRON)
                .define('p', ModItems.POWER_UNIT.get())
                .group(MODID + "/items/electric")
                .unlockedBy("iron_plate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_PLATE.get()))
                .unlockedBy("power_unit", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.POWER_UNIT.get()))
                .save(consumer, saveResource("mining_drill"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.DIAMOND_DRILL.get())
                .pattern(" d ")
                .pattern("dcd")
                .pattern(" a ")
                .define('c', ModItems.MINING_DRILL.get())
                .define('d', ModItemTags.FORGE_GEMS_DIAMOND)
                .define('a', ModItems.ADVANCED_BATTERY.get())
                .group(MODID + "/items/electric")
                .unlockedBy("mining_drill", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.MINING_DRILL.get()))
                .unlockedBy("diamond", InventoryChangeTrigger.TriggerInstance.hasItems(Items.DIAMOND))
                .unlockedBy("advanced_battery", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ADVANCED_BATTERY.get()))
                .save(consumer, saveResource("diamond_drill"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.IRIDIUM_DRILL.get())
                .pattern(" i ")
                .pattern("idi")
                .pattern(" e ")
                .define('d', ModItems.DIAMOND_DRILL.get())
                .define('i', ModItemTags.FORGE_PLATES_IRIDIUM)
                .define('e', ModItems.ENERGY_CRYSTAL.get())
                .group(MODID + "/items/electric")
                .unlockedBy("diamond_drill", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.DIAMOND_DRILL.get()))
                .unlockedBy("iridium_plate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRIDIUM_PLATE.get()))
                .unlockedBy("energy_crystal", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENERGY_CRYSTAL.get()))
                .save(consumer, saveResource("iridium_drill"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CHAINSAW.get())
                .pattern(" ii")
                .pattern("iii")
                .pattern("pi ")
                .define('i', ModItemTags.FORGE_PLATES_IRON)
                .define('p', ModItems.POWER_UNIT.get())
                .group(MODID + "/items/electric")
                .unlockedBy("iron_plate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_PLATE.get()))
                .unlockedBy("power_unit", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.POWER_UNIT.get()))
                .save(consumer, saveResource("chainsaw"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.DIAMOND_CHAINSAW.get())
                .pattern(" dd")
                .pattern(" cd")
                .pattern("a  ")
                .define('c', ModItems.CHAINSAW.get())
                .define('d', ModItemTags.FORGE_GEMS_DIAMOND)
                .define('a', ModItems.ADVANCED_BATTERY.get())
                .group(MODID + "/items/electric")
                .unlockedBy("chainsaw", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CHAINSAW.get()))
                .unlockedBy("diamond", InventoryChangeTrigger.TriggerInstance.hasItems(Items.DIAMOND))
                .unlockedBy("advanced_battery", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ADVANCED_BATTERY.get()))
                .save(consumer, saveResource("diamond_chainsaw"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.IRIDIUM_CHAINSAW.get())
                .pattern(" ii")
                .pattern(" ci")
                .pattern("e  ")
                .define('c', ModItems.DIAMOND_CHAINSAW.get())
                .define('i', ModItemTags.FORGE_PLATES_IRIDIUM)
                .define('e', ModItems.ENERGY_CRYSTAL.get())
                .group(MODID + "/items/electric")
                .unlockedBy("diamond_chainsaw", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.DIAMOND_CHAINSAW.get()))
                .unlockedBy("iridium_plate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRIDIUM_PLATE.get()))
                .unlockedBy("energy_crystal", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENERGY_CRYSTAL.get()))
                .save(consumer, saveResource("iridium_chainsaw"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ELECTRIC_HOE.get())
                .pattern("ii ")
                .pattern(" i ")
                .pattern(" s ")
                .define('i', ModItemTags.FORGE_PLATES_IRON)
                .define('s', ModItems.SMALL_POWER_UNIT.get())
                .group(MODID + "/items/electric")
                .unlockedBy("iron_plate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_PLATE.get()))
                .unlockedBy("small_power_unit", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SMALL_POWER_UNIT.get()))
                .save(consumer, saveResource("electric_hoe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ELECTRIC_TREETAP.get())
                .pattern("ts ")
                .define('t', ModItems.TREETAP.get())
                .define('s', ModItems.SMALL_POWER_UNIT.get())
                .group(MODID + "/items/electric")
                .unlockedBy("treetap", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TREETAP.get()))
                .unlockedBy("small_power_unit", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SMALL_POWER_UNIT.get()))
                .save(consumer, saveResource("electric_treetap"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ELECTRIC_WRENCH.get())
                .pattern("w ")
                .pattern("s ")
                .define('w', ModItems.WRENCH.get())
                .define('s', ModItems.SMALL_POWER_UNIT.get())
                .group(MODID + "/items/electric")
                .unlockedBy("wrench", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.WRENCH.get()))
                .unlockedBy("small_power_unit", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SMALL_POWER_UNIT.get()))
                .save(consumer, saveResource("electric_wrench"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.WIND_METER.get())
                .pattern(" t ")
                .pattern("tbt")
                .pattern(" ts")
                .define('t', ModItemTags.FORGE_PLATES_TIN)
                .define('b', ModItemTags.FORGE_PLATES_BRONZE)
                .define('s', ModItems.SMALL_POWER_UNIT.get())
                .group(MODID)
                .unlockedBy("tin_plate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TIN_PLATE.get()))
                .unlockedBy("bronze_plate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BRONZE_PLATE.get()))
                .unlockedBy("small_power_unit", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SMALL_POWER_UNIT.get()))
                .save(consumer, saveResource("wind_meter"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.MULTI_TOOL.get())
                .pattern("ctc")
                .pattern("aea")
                .pattern("wih")
                .define('c', ModItems.CARBON_PLATE.get())
                .define('t', ModItems.ELECTRIC_TREETAP.get())
                .define('a', ModItems.ADVANCED_ALLOY_PLATE.get())
                .define('e', ModItems.ENERGY_CRYSTAL.get())
                .define('w', ModItems.ELECTRIC_WRENCH.get())
                .define('i', ModItems.ADVANCED_CIRCUIT.get())
                .define('h', ModItems.ELECTRIC_HOE.get())
                .group(MODID + "/items/electric")
                .unlockedBy("carbon_plate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CARBON_PLATE.get()))
                .unlockedBy("electric_treetap", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ELECTRIC_TREETAP.get()))
                .unlockedBy("advanced_alloy", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ADVANCED_ALLOY_PLATE.get()))
                .unlockedBy("energy_crystal", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENERGY_CRYSTAL.get()))
                .unlockedBy("electric_wrench", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ELECTRIC_WRENCH.get()))
                .unlockedBy("advanced_circuit", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ADVANCED_CIRCUIT.get()))
                .unlockedBy("electric_hoe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ELECTRIC_HOE.get()))
                .save(consumer, saveResource("multi_tool"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CHARGING_BATTERY.get())
                .pattern("ebe")
                .pattern("b b")
                .pattern("ebe")
                .define('e', ModItems.ELECTRONIC_CIRCUIT.get())
                .define('b', ModItems.BATTERY.get())
                .group(MODID + "/items/electric")
                .unlockedBy("electronic_circuit", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ELECTRONIC_CIRCUIT.get()))
                .unlockedBy("battery", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BATTERY.get()))
                .save(consumer, saveResource("charging_battery"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CHARGING_ADVANCED_BATTERY.get())
                .pattern("hah")
                .pattern("aca")
                .pattern("hah")
                .define('h', ModItems.HEAT_EXCHANGER.get())
                .define('a', ModItems.ADVANCED_BATTERY.get())
                .define('c', ModItems.CHARGING_BATTERY.get())
                .group(MODID + "/items/electric")
                .unlockedBy("heat_exchanger", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.HEAT_EXCHANGER.get()))
                .unlockedBy("advanced_battery", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ADVANCED_BATTERY.get()))
                .unlockedBy("charging_battery", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CHARGING_BATTERY.get()))
                .save(consumer, saveResource("advanced_charging_battery"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CHARGING_ENERGY_CRYSTAL.get())
                .pattern("hah")
                .pattern("aca")
                .pattern("hah")
                .define('h', ModItems.COMPONENT_HEAT_EXCHANGER.get())
                .define('a', ModItems.ENERGY_CRYSTAL.get())
                .define('c', ModItems.CHARGING_ADVANCED_BATTERY.get())
                .group(MODID + "/items/electric")
                .unlockedBy("component_heat_exchanger", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COMPONENT_HEAT_EXCHANGER.get()))
                .unlockedBy("energy_crystal", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENERGY_CRYSTAL.get()))
                .unlockedBy("charging_advanced_battery", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CHARGING_ADVANCED_BATTERY.get()))
                .save(consumer, saveResource("charging_energy_crystal"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CHARGING_LAPOTRON_CRYSTAL.get())
                .pattern("hah")
                .pattern("aca")
                .pattern("hah")
                .define('h', ModItems.ADVANCED_HEAT_EXCHANGER.get())
                .define('a', ModItems.LAPOTRON_CRYSTAL.get())
                .define('c', ModItems.CHARGING_ENERGY_CRYSTAL.get())
                .group(MODID + "/items/electric")
                .unlockedBy("advanced_heat_exchanger", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ADVANCED_HEAT_EXCHANGER.get()))
                .unlockedBy("lapotron_crystal", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LAPOTRON_CRYSTAL.get()))
                .unlockedBy("charging_energy_crystal", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CHARGING_ENERGY_CRYSTAL.get()))
                .save(consumer, saveResource("charging_lapotron_crystal"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BASIC_TRANSPORTER.get())
                .pattern("pgp")
                .pattern("pcp")
                .pattern("hah")
                .define('p', ModItemTags.FORGE_PLATES_TIN)
                .define('g', Items.GLASS)
                .define('c', ModItems.ELECTRONIC_CIRCUIT.get())
                .define('h', ModItems.COPPER_CABLE_INSULATED.get())
                .define('a', ModItems.CHARGING_ADVANCED_BATTERY.get())
                .group(MODID + "/items/electric")
                .unlockedBy("tin_plate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TIN_PLATE.get()))
                .unlockedBy("glass", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GLASS))
                .unlockedBy("electronic_circuit", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ELECTRONIC_CIRCUIT.get()))
                .unlockedBy("copper_cable_insulated", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COPPER_CABLE_INSULATED.get()))
                .unlockedBy("charging_advanced_battery", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CHARGING_ADVANCED_BATTERY.get()))
                .save(consumer, saveResource("basic_transporter"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ADVANCED_TRANSPORTER.get())
                .pattern("pgp")
                .pattern("cbc")
                .pattern("hah")
                .define('p', ModItemTags.FORGE_PLATES_TIN)
                .define('g', ModItems.REINFORCED_GLASS.get())
                .define('b', ModItems.BASIC_TRANSPORTER.get())
                .define('c', ModItems.ADVANCED_CIRCUIT.get())
                .define('h', ModItems.GLASS_FIBRE_CABLE.get())
                .define('a', ModItems.CHARGING_ENERGY_CRYSTAL.get())
                .group(MODID + "/items/electric")
                .unlockedBy("tin_plate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TIN_PLATE.get()))
                .unlockedBy("reinforced_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.REINFORCED_GLASS.get()))
                .unlockedBy("basic_transporter", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BASIC_TRANSPORTER.get()))
                .unlockedBy("glass_fibre_cable", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GLASS_FIBRE_CABLE.get()))
                .unlockedBy("charging_energy_crystal", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CHARGING_ENERGY_CRYSTAL.get()))
                .unlockedBy("advanced_circuit", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ADVANCED_CIRCUIT.get()))
                .save(consumer, saveResource("advanced_transporter"));


    }
}