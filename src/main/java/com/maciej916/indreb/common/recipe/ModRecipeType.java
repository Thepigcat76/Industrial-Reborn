package com.maciej916.indreb.common.recipe;

import com.maciej916.indreb.common.recipe.impl.*;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.maciej916.indreb.IndReb.MODID;

public final class ModRecipeType {

    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, MODID);

    public static final RegistryObject<RecipeType<CrushingRecipe>> CRUSHING = registerType("crushing");
    public static final RegistryObject<RecipeType<CompressingRecipe>> COMPRESSING = registerType("compressing");
    public static final RegistryObject<RecipeType<ExtractingRecipe>> EXTRACTING = registerType("extracting");
    public static final RegistryObject<RecipeType<SawingRecipe>> SAWING = registerType("sawing");
    public static final RegistryObject<RecipeType<FluidExtrudingRecipe>> FLUID_EXTRUDING = registerType("fluid_extruding");
    public static final RegistryObject<RecipeType<CanningRecipe>> CANNING = registerType("canning");
    public static final RegistryObject<RecipeType<FluidEnrichingRecipe>> FLUID_ENRICHING = registerType("fluid_enriching");
    public static final RegistryObject<RecipeType<RecyclingRecipe>> RECYCLING = registerType("recycling");
    public static final RegistryObject<RecipeType<RollingRecipe>> ROLLING = registerType("rolling");
    public static final RegistryObject<RecipeType<CuttingRecipe>> CUTTING = registerType("cutting");
    public static final RegistryObject<RecipeType<ExtrudingRecipe>> EXTRUDING = registerType("extruding");

    public static final RegistryObject<RecipeType<AlloySmeltingRecipe>> ALLOY_SMELTING = registerType("alloy_smelting");
    public static final RegistryObject<RecipeType<FermentingRecipe>> FERMENTING = registerType("fermenting");
    public static final RegistryObject<RecipeType<OreWashingRecipe>> ORE_WASHING = registerType("ore_washing");
    public static final RegistryObject<RecipeType<ThermalCentrifugingRecipe>> THERMAL_CENTRIFUGING = registerType("thermal_centrifuging");

    public static final RegistryObject<RecipeType<ScanningRecipe>> SCANNING = registerType("scanning");

    public static final RegistryObject<RecipeType<ScrapBoxRecipe>> SCRAP_BOX = registerType("scrap_box");
    public static final RegistryObject<RecipeType<MatterAmplifierRecipe>> MATTER_AMPLIFIER = registerType("matter_amplifier");

    public static final RegistryObject<RecipeType<ElectricCraftingRecipe>> ELECTRIC_CRAFTING = registerType("electric_crafting");


    private static <T extends Recipe<?>> RegistryObject<RecipeType<T>> registerType(final String key) {
        return RECIPE_TYPES.register(key, () -> new RecipeType<>() {
            @Override
            public String toString() {
                return key;
            }
        });
    }

    public static void register(IEventBus eventBus) {
        RECIPE_TYPES.register(eventBus);
    }
}