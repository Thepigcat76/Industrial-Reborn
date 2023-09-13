package com.maciej916.indreb.datagen.recipe.provider.custom;

import com.maciej916.indreb.common.fluid.impl.Biogas;
import com.maciej916.indreb.common.fluid.impl.Biomass;
import com.maciej916.indreb.common.item.ModItems;
import com.maciej916.indreb.datagen.recipe.builder.FermentingRecipeBuilder;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;

import java.util.function.Consumer;

public class FermentingRecipeProvider extends RecipeProvider {

    public FermentingRecipeProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

        FermentingRecipeBuilder.builder(Biogas.STILL_FLUID.getSource(), 200, 1400, 1f, ModItems.FERTILIZER.get())
                .setFluidInput(Biomass.STILL_FLUID.getSource(), 1000)
                .setExperience(1.5F)
                .setTickEnergyCost(8)
                .addCriterion("bio_chaff", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BIO_CHAFF.get()))
                .setGroup("fermenting")
                .save(consumer,"biogas");

    }
}
