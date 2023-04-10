package com.maciej916.indreb.datagen.recipe.provider.crafting;

import com.maciej916.indreb.common.block.ModBlocks;
import com.maciej916.indreb.common.item.ModItems;
import com.maciej916.indreb.common.tag.ModItemTags;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

import static com.maciej916.indreb.IndReb.MODID;

public class ItemsCircuitProvider extends RecipeProvider {

    public ItemsCircuitProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

    private ResourceLocation saveResource(String name) {
        return new ResourceLocation(MODID, "crafting/items/circuit/" + name);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {

        ShapedRecipeBuilder.shaped(ModItems.ELECTRONIC_CIRCUIT.get())
                .pattern("ccc")
                .pattern("rir")
                .pattern("ccc")
                .define('c', ModBlocks.COPPER_CABLE_INSULATED.get())
                .define('i', ModItemTags.FORGE_PLATES_IRON)
                .define('r', Items.REDSTONE)
                .group(MODID + "/items/circuit")
                .unlockedBy("copper_cable_insulated", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.COPPER_CABLE_INSULATED.get()))
                .save(consumer, saveResource("electronic_circuit"));

        ShapedRecipeBuilder.shaped(ModItems.ADVANCED_CIRCUIT.get())
                .pattern("rgr")
                .pattern("lel")
                .pattern("rgr")
                .define('e', ModItems.ELECTRONIC_CIRCUIT.get())
                .define('l', ModItemTags.FORGE_PLATES_LAPIS)
                .define('g', Items.GLOWSTONE_DUST)
                .define('r', Items.REDSTONE)
                .group(MODID + "/items/circuit")
                .unlockedBy("copper_cable_insulated", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.COPPER_CABLE_INSULATED.get()))
                .unlockedBy("item", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.COPPER_CABLE_INSULATED.get()))
                .save(consumer, saveResource("advanced_circuit"));

        ShapedRecipeBuilder.shaped(ModItems.LAPOTRONIC_ENERGY_RELAY.get(), 4)
                .pattern("ibi")
                .pattern("hlh")
                .pattern("ibi")
                .define('i', ModItems.IRIDIUM_PLATE.get())
                .define('b', ModItems.BIOPLASTIC.get())
                .define('h', ModItems.HAFNIUM_PELLET.get())
                .define('l', ModItems.LAPOTRON_CRYSTAL.get())
                .group(MODID + "/items/circuit")
                .unlockedBy("iridium_plate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.IRIDIUM_PLATE.get()))
                .unlockedBy("lapotron_crystal", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LAPOTRON_CRYSTAL.get()))
                .unlockedBy("hafnium_pellet", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.HAFNIUM_PELLET.get()))
                .save(consumer, saveResource("lapotronic_energy_relay"));


    }
}