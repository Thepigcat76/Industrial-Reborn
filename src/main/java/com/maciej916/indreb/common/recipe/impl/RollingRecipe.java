package com.maciej916.indreb.common.recipe.impl;

import com.google.gson.JsonObject;
import com.maciej916.indreb.common.api.recipe.BaseRecipe;
import com.maciej916.indreb.common.api.recipe.lib.IngredientCount;
import com.maciej916.indreb.common.recipe.ModRecipeType;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.ShapedRecipe;

import javax.annotation.Nullable;

public class RollingRecipe extends BaseRecipe {

    public static final Serializer SERIALIZER = new Serializer();

    public RollingRecipe(ResourceLocation id, IngredientCount ingredients, ItemStack result, int duration, int tickEnergyCost, float experience) {
        super(id, ingredients, result, duration, tickEnergyCost, experience);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipeType.ROLLING.get();
    }

    public static class Serializer implements RecipeSerializer<RollingRecipe> {

        @Override
        public RollingRecipe fromJson(ResourceLocation recipeId, JsonObject json) {

            IngredientCount ingredientCount = IngredientCount.fromJson(GsonHelper.getAsJsonArray(json, "ingredients"));
            ItemStack result = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "result"));

            int duration = GsonHelper.getAsInt(json, "duration", 180);
            int tickEnergyCost = GsonHelper.getAsInt(json, "tick_energy_cost", 8);
            float experience = GsonHelper.getAsFloat(json, "experience", 0);

            return new RollingRecipe(recipeId, ingredientCount, result, duration, tickEnergyCost, experience);
        }

        @Nullable
        @Override
        public RollingRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {

            IngredientCount ingredientCount = IngredientCount.fromNetwork(buffer);
            ItemStack result = buffer.readItem();
            int duration = buffer.readInt();
            int tickEnergyCost = buffer.readInt();
            float experience = buffer.readFloat();

            return new RollingRecipe(recipeId, ingredientCount, result, duration, tickEnergyCost, experience);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, RollingRecipe recipe) {
            recipe.getIngredientCount().toNetwork(buffer);
            buffer.writeItemStack(recipe.getResult(), false);
            buffer.writeInt(recipe.getDuration());
            buffer.writeInt(recipe.getTickEnergyCost());
            buffer.writeFloat(recipe.getExperience());
        }
    }
}
