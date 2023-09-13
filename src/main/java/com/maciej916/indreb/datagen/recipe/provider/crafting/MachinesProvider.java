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
import net.minecraft.world.level.block.Blocks;

import java.util.function.Consumer;

import static com.maciej916.indreb.IndReb.MODID;

public class MachinesProvider extends RecipeProvider {

    public MachinesProvider(PackOutput packOutput) {
        super(packOutput);
    }

    private ResourceLocation saveResource(String name) {
        return new ResourceLocation(MODID, "crafting/machine/advanced/" + name);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.SIMPLE_CRUSHER.get())
                .pattern("iii")
                .pattern("fCf")
                .pattern("xxx")
                .define('f', Items.FLINT)
                .define('C', Items.FURNACE)
                .define('x', Items.SMOOTH_STONE)
                .define('i', ModItemTags.FORGE_INGOTS_IRON)
                .group(MODID + "/machines/simple")
                .unlockedBy("furnace", InventoryChangeTrigger.TriggerInstance.hasItems(Items.FURNACE))
                .save(consumer, saveResource("simple_crusher"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.SIMPLE_COMPRESSOR.get())
                .pattern("iii")
                .pattern("sCs")
                .pattern("xxx")
                .define('C', Items.FURNACE)
                .define('x', Items.SMOOTH_STONE)
                .define('s', ModItemTags.FORGE_COBBLESTONE)
                .define('i', ModItemTags.FORGE_INGOTS_IRON)
                .group(MODID + "/machines/simple")
                .unlockedBy("furnace", InventoryChangeTrigger.TriggerInstance.hasItems(Items.FURNACE))
                .save(consumer, saveResource("simple_compressor"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.SIMPLE_EXTRACTOR.get())
                .pattern("iii")
                .pattern("TCT")
                .pattern("xxx")
                .define('C', Items.FURNACE)
                .define('x', Items.SMOOTH_STONE)
                .define('T', ModItems.TREETAP.get())
                .define('i', ModItemTags.FORGE_INGOTS_IRON)
                .group(MODID + "/machines/simple")
                .unlockedBy("furnace", InventoryChangeTrigger.TriggerInstance.hasItems(Items.FURNACE))
                .save(consumer, saveResource("simple_extractor"));


        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.IRON_FURNACE.get())
                .pattern("iii")
                .pattern("ifi")
                .pattern("iii")
                .define('f', Blocks.FURNACE)
                .define('i', ModItemTags.FORGE_PLATES_IRON)
                .group(MODID + "/machines/basic")
                .unlockedBy("item", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.FURNACE))
                .save(consumer, saveResource("iron_furnace"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.ELECTRIC_FURNACE.get())
                .pattern(" c ")
                .pattern("rIr")
                .pattern("   ")
                .define('I', ModBlocks.IRON_FURNACE.get())
                .define('c', ModItems.ELECTRONIC_CIRCUIT.get())
                .define('r', Items.REDSTONE)
                .group(MODID + "/machines/basic")
                .unlockedBy("iron_furnace", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.IRON_FURNACE.get()))
                .save(consumer, saveResource("electric_furnace"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.CRUSHER.get())
                .pattern("frf")
                .pattern("cCc")
                .pattern(" x ")
                .define('f', Items.FLINT)
                .define('r', ModBlocks.SIMPLE_CRUSHER.get())
                .define('C', ModBlocks.BASIC_MACHINE_CASING.get())
                .define('c', ModItemTags.FORGE_COBBLESTONE)
                .define('x', ModItems.ELECTRONIC_CIRCUIT.get())
                .group(MODID + "/machines/basic")
                .unlockedBy("simple_crusher", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.SIMPLE_CRUSHER.get()))
                .unlockedBy("basic_machine_casing", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.BASIC_MACHINE_CASING.get()))
                .save(consumer, saveResource("crusher"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.COMPRESSOR.get())
                .pattern("scs")
                .pattern("sCs")
                .pattern("sxs")
                .define('c', ModBlocks.SIMPLE_COMPRESSOR.get())
                .define('C', ModBlocks.BASIC_MACHINE_CASING.get())
                .define('x', ModItems.ELECTRONIC_CIRCUIT.get())
                .define('s', ModItemTags.FORGE_COBBLESTONE)
                .group(MODID + "/machines/basic")
                .unlockedBy("simple_compressor", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.SIMPLE_COMPRESSOR.get()))
                .unlockedBy("basic_machine_casing", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.BASIC_MACHINE_CASING.get()))
                .save(consumer, saveResource("compressor"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.EXTRACTOR.get())
                .pattern(" e ")
                .pattern("TCT")
                .pattern("TxT")
                .define('e', ModBlocks.SIMPLE_EXTRACTOR.get())
                .define('C', ModBlocks.BASIC_MACHINE_CASING.get())
                .define('x', ModItems.ELECTRONIC_CIRCUIT.get())
                .define('T', ModItems.TREETAP.get())
                .group(MODID + "/machines/basic")
                .unlockedBy("simple_extractor", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.SIMPLE_EXTRACTOR.get()))
                .unlockedBy("basic_machine_casing", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.BASIC_MACHINE_CASING.get()))
                .save(consumer, saveResource("extractor"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.SAWMILL.get())
                .pattern(" A ")
                .pattern("PCP")
                .pattern("PxP")
                .define('A', Items.IRON_AXE)
                .define('C', ModBlocks.BASIC_MACHINE_CASING.get())
                .define('x', ModItems.ELECTRONIC_CIRCUIT.get())
                .define('P', ItemTags.PLANKS)
                .group(MODID + "/machines/basic")
                .unlockedBy("basic_machine_casing", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.BASIC_MACHINE_CASING.get()))
                .save(consumer, saveResource("sawmill"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.EXTRUDER.get())
                .pattern(" p ")
                .pattern("cbc")
                .pattern("tet")
                .define('p', Items.PISTON)
                .define('c', ModItems.FLUID_CELL.get())
                .define('e', ModItems.ELECTRONIC_CIRCUIT.get())
                .define('b', ModBlocks.BASIC_MACHINE_CASING.get())
                .define('t', ModItemTags.FORGE_PLATES_TIN)
                .group(MODID + "/machines/basic")
                .unlockedBy("empty_cell", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.FLUID_CELL.get()))
                .unlockedBy("circuit", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ELECTRONIC_CIRCUIT.get()))
                .unlockedBy("basic", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.BASIC_MACHINE_CASING.get()))
                .save(consumer, saveResource("extruder"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.RECYCLER.get())
                .pattern(" g ")
                .pattern("dcd")
                .pattern("psp")
                .define('g', Items.GLOWSTONE_DUST)
                .define('d', Items.DIRT)
                .define('s', Items.SAND)
                .define('p', ModItemTags.FORGE_PLATES_IRON)
                .define('c', ModBlocks.COMPRESSOR.get())
                .group(MODID + "/machines/basic")
                .unlockedBy("glowstone_dust", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GLOWSTONE_DUST))
                .unlockedBy("dirt", InventoryChangeTrigger.TriggerInstance.hasItems(Items.DIRT))
                .unlockedBy("sand", InventoryChangeTrigger.TriggerInstance.hasItems(Items.SAND))
                .unlockedBy("iron_plate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_PLATE.get()))
                .unlockedBy("compressor", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.COMPRESSOR.get()))
                .save(consumer, saveResource("recycler"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.CANNING_MACHINE.get())
                .pattern("pep")
                .pattern("pbp")
                .pattern("ppp")
                .define('p', ModItemTags.FORGE_PLATES_TIN)
                .define('b', ModBlocks.BASIC_MACHINE_CASING.get())
                .define('e', ModItems.ELECTRONIC_CIRCUIT.get())
                .group(MODID + "/machines/basic")
                .unlockedBy("tin_plate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TIN_PLATE.get()))
                .unlockedBy("basic_machine_casing", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.BASIC_MACHINE_CASING.get()))
                .unlockedBy("electronic_circuit", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ELECTRONIC_CIRCUIT.get()))
                .save(consumer, saveResource("canning_machine"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.FLUID_ENRICHER.get())
                .pattern("ppp")
                .pattern("cbc")
                .pattern("pep")
                .define('p', ModItemTags.FORGE_PLATES_TIN)
                .define('b', ModBlocks.BASIC_MACHINE_CASING.get())
                .define('c', ModItems.FLUID_CELL.get())
                .define('e', ModItems.ELECTRONIC_CIRCUIT.get())
                .group(MODID + "/machines/basic")
                .unlockedBy("tin_plate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TIN_PLATE.get()))
                .unlockedBy("basic_machine_casing", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.BASIC_MACHINE_CASING.get()))
                .unlockedBy("electronic_circuit", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ELECTRONIC_CIRCUIT.get()))
                .unlockedBy("fluid_cell", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.FLUID_CELL.get()))
                .save(consumer, saveResource("fluid_enricher"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.METAL_FORMER.get())
                .pattern(" c ")
                .pattern("tbt")
                .pattern("hhh")
                .define('h', ModItems.COIL.get())
                .define('t', ModItems.TOOL_BOX.get())
                .define('b', ModItems.BASIC_MACHINE_CASING.get())
                .define('c', ModItems.ELECTRONIC_CIRCUIT.get())
                .group(MODID + "/machines/basic")
                .unlockedBy("coil", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COIL.get()))
                .unlockedBy("tool_box", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TOOL_BOX.get()))
                .unlockedBy("basic_machine_casing", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BASIC_MACHINE_CASING.get()))
                .unlockedBy("electronic_circuit", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ELECTRONIC_CIRCUIT.get()))
                .save(consumer, saveResource("metal_former"));


        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.ALLOY_SMELTER.get())
                .pattern(" e ")
                .pattern("fbf")
                .pattern(" h ")
                .define('f', ModBlocks.ELECTRIC_FURNACE.get())
                .define('e', ModItems.ADVANCED_CIRCUIT.get())
                .define('b', ModBlocks.BASIC_MACHINE_CASING.get())
                .define('h', ModItems.HEAT_CONDUCTOR.get())
                .group(MODID + "/machines/standard")
                .unlockedBy("electric_furnace", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.ELECTRIC_FURNACE.get()))
                .unlockedBy("basic_machine_casing", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.BASIC_MACHINE_CASING.get()))
                .unlockedBy("advanced_circuit", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ADVANCED_CIRCUIT.get()))
                .unlockedBy("heat_conductor", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.HEAT_CONDUCTOR.get()))
                .save(consumer, saveResource("alloy_smelter"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.FERMENTER.get())
                .pattern("pcp")
                .pattern("cbc")
                .pattern("php")
                .define('p', ModItemTags.FORGE_PLATES_TIN)
                .define('b', ModBlocks.BASIC_MACHINE_CASING.get())
                .define('c', ModItems.FLUID_CELL.get())
                .define('h', ModItems.HEAT_CONDUCTOR.get())
                .group(MODID + "/machines/standard")
                .unlockedBy("tin_plate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TIN_PLATE.get()))
                .unlockedBy("basic_machine_casing", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.BASIC_MACHINE_CASING.get()))
                .unlockedBy("fluid_cell", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.FLUID_CELL.get()))
                .unlockedBy("heat_conductor", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.HEAT_CONDUCTOR.get()))
                .save(consumer, saveResource("fermenter"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.ORE_WASHING_PLANT.get())
                .pattern("ppp")
                .pattern("cbc")
                .pattern("mem")
                .define('p', ModItemTags.FORGE_PLATES_IRON)
                .define('b', ModBlocks.BASIC_MACHINE_CASING.get())
                .define('c', Items.BUCKET)
                .define('e', ModItems.ELECTRONIC_CIRCUIT.get())
                .define('m', ModItems.ELECTRIC_MOTOR.get())
                .group(MODID + "/machines/standard")
                .unlockedBy("iron_plate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_PLATE.get()))
                .unlockedBy("basic_machine_casing", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.BASIC_MACHINE_CASING.get()))
                .unlockedBy("bucket", InventoryChangeTrigger.TriggerInstance.hasItems(Items.BUCKET))
                .unlockedBy("electronic_circuit", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ELECTRONIC_CIRCUIT.get()))
                .unlockedBy("electric_motor", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ELECTRIC_MOTOR.get()))
                .save(consumer, saveResource("ore_washing_plant"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.THERMAL_CENTRIFUGE.get())
                .pattern("chc")
                .pattern("pap")
                .pattern("pmp")
                .define('c', ModItems.COIL.get())
                .define('h', ModItems.HEAT_CONDUCTOR.get())
                .define('p', ModItemTags.FORGE_PLATES_IRON)
                .define('a', ModItems.ADVANCED_MACHINE_CASING.get())
                .define('m', ModItems.ELECTRIC_MOTOR.get())
                .group(MODID + "/machines/standard")
                .unlockedBy("iron_plate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_PLATE.get()))
                .unlockedBy("advanced_machine_casing", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ADVANCED_MACHINE_CASING.get()))
                .unlockedBy("heat_conductor", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.HEAT_CONDUCTOR.get()))
                .unlockedBy("coil", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COIL.get()))
                .unlockedBy("electric_motor", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ELECTRIC_MOTOR.get()))
                .save(consumer, saveResource("thermal_centrifuge"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.MATTER_FABRICATOR.get())
                .pattern("gcg")
                .pattern("ala")
                .pattern("gcg")
                .define('g', Items.GLOWSTONE_DUST)
                .define('l', ModItems.LAPOTRON_CRYSTAL.get())
                .define('a', ModItems.ADVANCED_MACHINE_CASING.get())
                .define('c', ModItems.ADVANCED_CIRCUIT.get())
                .group(MODID + "/advanced")
                .unlockedBy("glowstone_dust", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GLOWSTONE_DUST))
                .unlockedBy("lapotron_crystal", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LAPOTRON_CRYSTAL.get()))
                .unlockedBy("advanced_machine_casing", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ADVANCED_MACHINE_CASING.get()))
                .unlockedBy("advanced_circuit", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ADVANCED_CIRCUIT.get()))
                .save(consumer, saveResource("matter_fabricator"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.SCANNER.get())
                .pattern("igi")
                .pattern("mlm")
                .pattern("cac")
                .define('i', ModItemTags.FORGE_PLATES_IRON)
                .define('g', ModItems.REINFORCED_GLASS.get())
                .define('l', ModItems.LUMINATOR.get())
                .define('m', ModItems.ELECTRIC_MOTOR.get())
                .define('a', ModItems.ADVANCED_CIRCUIT.get())
                .define('c', ModItems.ADVANCED_MACHINE_CASING.get())
                .group(MODID + "/super")
                .unlockedBy("iron_plate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRON_PLATE.get()))
                .unlockedBy("reinforced_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.REINFORCED_GLASS.get()))
                .unlockedBy("luminator", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LUMINATOR.get()))
                .unlockedBy("electric_motor", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ELECTRIC_MOTOR.get()))
                .unlockedBy("advanced_circuit", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ADVANCED_CIRCUIT.get()))
                .unlockedBy("advanced_machine_casing", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ADVANCED_MACHINE_CASING.get()))
                .save(consumer, saveResource("scanner"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.REPLICATOR.get())
                .pattern("gsg")
                .pattern("ttt")
                .pattern("hmh")
                .define('g', ModItems.REINFORCED_GLASS.get())
                .define('s', ModItems.REINFORCED_STONE.get())
                .define('t', ModItems.TELEPORT_ANCHOR.get())
                .define('h', ModItems.HV_TRANSFORMER.get())
                .define('m', ModItems.MFE.get())
                .group(MODID + "/super")
                .unlockedBy("reinforced_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.REINFORCED_GLASS.get()))
                .unlockedBy("reinforced_stone", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.REINFORCED_STONE.get()))
                .unlockedBy("teleport_anchor", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TELEPORT_ANCHOR.get()))
                .unlockedBy("hv_transformer", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.HV_TRANSFORMER.get()))
                .unlockedBy("mfe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.MFE.get()))
                .save(consumer, saveResource("replicator"));


    }
}