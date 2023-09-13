package com.maciej916.indreb.datagen;

import com.maciej916.indreb.datagen.loot.LootModifiers;
import com.maciej916.indreb.datagen.loot.ModBlockLootTables;
import com.maciej916.indreb.datagen.loot.ModLoottableProvider;
import com.maciej916.indreb.datagen.recipe.provider.BlastingRecipeProvider;
import com.maciej916.indreb.datagen.recipe.provider.SmeltingRecipeProvider;
import com.maciej916.indreb.datagen.recipe.provider.StonecuttingRecipeProvider;
import com.maciej916.indreb.datagen.recipe.provider.crafting.*;
import com.maciej916.indreb.datagen.recipe.provider.custom.*;
import com.maciej916.indreb.datagen.tags.TagsBlock;
import com.maciej916.indreb.datagen.tags.TagsItem;
import com.maciej916.indreb.datagen.texture.BlockTextures;
import com.maciej916.indreb.datagen.texture.ItemTextures;
import com.maciej916.indreb.datagen.world.ModWorldGenProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeClient(), new BlockTextures(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new ItemTextures(packOutput, existingFileHelper));

        TagsBlock blockTags = new TagsBlock(packOutput, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new TagsItem(packOutput, lookupProvider, blockTags.contentsGetter(), existingFileHelper));

        generator.addProvider(event.includeServer(), new LootModifiers(packOutput));

        /* RECIPES */

        generator.addProvider(event.includeServer(), new CompressingRecipeProvider(packOutput));
        generator.addProvider(event.includeServer(), new CrushingRecipeProvider(packOutput));
        generator.addProvider(event.includeServer(), new ExtractingRecipeProvider(packOutput));
        generator.addProvider(event.includeServer(), new SawingRecipeProvider(packOutput));
        generator.addProvider(event.includeServer(), new FluidExtrudingRecipeProvider(packOutput));
        generator.addProvider(event.includeServer(), new CanningRecipeProvider(packOutput));
        generator.addProvider(event.includeServer(), new FluidEnrichingProvider(packOutput));
        generator.addProvider(event.includeServer(), new RecyclingRecipeProvider(packOutput));
        generator.addProvider(event.includeServer(), new CuttingRecipeProvider(packOutput));
        generator.addProvider(event.includeServer(), new RollingRecipeProvider(packOutput));
        generator.addProvider(event.includeServer(), new ExtrudingRecipeProvider(packOutput));

        generator.addProvider(event.includeServer(), new AlloySmeltingRecipeProvider(packOutput));
        generator.addProvider(event.includeServer(), new FermentingRecipeProvider(packOutput));
        generator.addProvider(event.includeServer(), new OreWashingProvider(packOutput));
        generator.addProvider(event.includeServer(), new ThermalCentrifugingProvider(packOutput));

        generator.addProvider(event.includeServer(), new ScanningProvider(packOutput));

        generator.addProvider(event.includeServer(), new ScrapBoxProvider(packOutput));
        generator.addProvider(event.includeServer(), new MatterAmplifierProvider(packOutput));

        generator.addProvider(event.includeServer(), new SmeltingRecipeProvider(packOutput));
        generator.addProvider(event.includeServer(), new BlastingRecipeProvider(packOutput));
        generator.addProvider(event.includeServer(), new StonecuttingRecipeProvider(packOutput));

        generator.addProvider(event.includeServer(), new ReinforcedStoneProvider(packOutput));
        generator.addProvider(event.includeServer(), new ConstructionFoamProvider(packOutput));
        generator.addProvider(event.includeServer(), new BlockProvider(packOutput));
        generator.addProvider(event.includeServer(), new CasingProvider(packOutput));
        generator.addProvider(event.includeServer(), new IronProvider(packOutput));
        generator.addProvider(event.includeServer(), new WoodProvider(packOutput));
        generator.addProvider(event.includeServer(), new DecorationProvider(packOutput));
        generator.addProvider(event.includeServer(), new ExplosiveProvider(packOutput));
        generator.addProvider(event.includeServer(), new CableProvider(packOutput));
        generator.addProvider(event.includeServer(), new MiscProvider(packOutput));
        generator.addProvider(event.includeServer(), new EnergyStorageProvider(packOutput));
        generator.addProvider(event.includeServer(), new GeneratorProvider(packOutput));
        generator.addProvider(event.includeServer(), new MachinesProvider(packOutput));

        generator.addProvider(event.includeServer(), new ItemsReactorProvider(packOutput));
        generator.addProvider(event.includeServer(), new ItemsUpgradeProvider(packOutput));
        generator.addProvider(event.includeServer(), new ItemsCanProvider(packOutput));
        generator.addProvider(event.includeServer(), new ItemsToolProvider(packOutput));
        generator.addProvider(event.includeServer(), new ItemsPainterProvider(packOutput));
        generator.addProvider(event.includeServer(), new ItemsElectricProvider(packOutput));
        generator.addProvider(event.includeServer(), new ItemsCropProvider(packOutput));
        generator.addProvider(event.includeServer(), new ItemsBasicProvider(packOutput));
        generator.addProvider(event.includeServer(), new ItemsCircuitProvider(packOutput));
        generator.addProvider(event.includeServer(), new ItemsStorageProvider(packOutput));
        generator.addProvider(event.includeServer(), new ItemsHammerProvider(packOutput));
        generator.addProvider(event.includeServer(), new ItemsArmourProvider(packOutput));


        /* LOOT TABLES */

        generator.addProvider(event.includeServer(), ModLoottableProvider.create(packOutput));

        /* WORLD GEN */
        generator.addProvider(event.includeServer(), new ModWorldGenProvider(packOutput, lookupProvider));

    }
}
