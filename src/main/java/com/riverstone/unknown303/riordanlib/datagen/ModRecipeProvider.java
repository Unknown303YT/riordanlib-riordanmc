package com.riverstone.unknown303.riordanlib.datagen;

import com.riverstone.unknown303.riordanlib.RiordanMod;
import com.riverstone.unknown303.riordanlib.blocks.ModBlocks;
import com.riverstone.unknown303.riordanlib.items.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        woodFromLogs(pWriter, ModBlocks.PINE_WOOD.get(), ModBlocks.PINE_LOG.get());
        woodFromLogs(pWriter, ModBlocks.STRIPPED_PINE_WOOD.get(), ModBlocks.STRIPPED_PINE_LOG.get());

        planksFromLog(pWriter, ModBlocks.PINE_PLANKS.get(), ModBlocks.PINE_LOG.get(), false);
        planksFromLog(pWriter, ModBlocks.PINE_PLANKS.get(), ModBlocks.PINE_WOOD.get(), true);
        planksFromLog(pWriter, ModBlocks.PINE_PLANKS.get(), ModBlocks.STRIPPED_PINE_LOG.get(), true);
        planksFromLog(pWriter, ModBlocks.PINE_PLANKS.get(), ModBlocks.STRIPPED_PINE_WOOD.get(), true);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.PINE_SIGN.get(), 3)
                .pattern("PPP")
                .pattern("PPP")
                .pattern(" S ")
                .define('P', ModBlocks.PINE_PLANKS.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModBlocks.PINE_PLANKS.get()), has(ModBlocks.PINE_PLANKS.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.PINE_HANGING_SIGN.get(), 6)
                .pattern("C C")
                .pattern("SSS")
                .pattern("SSS")
                .define('C', Items.CHAIN)
                .define('S', ModBlocks.STRIPPED_PINE_LOG.get())
                .unlockedBy(getHasName(ModBlocks.STRIPPED_PINE_LOG.get()), has(ModBlocks.STRIPPED_PINE_LOG.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TRANSPORTATION, ModItems.PINE_BOAT.get())
                .pattern("P P")
                .pattern("PPP")
                .define('P', ModBlocks.PINE_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.PINE_PLANKS.get()), has(ModBlocks.PINE_PLANKS.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TRANSPORTATION, ModItems.PINE_CHEST_BOAT.get())
                .requires(ModItems.PINE_BOAT.get())
                .requires(Items.CHEST)
                .unlockedBy(getHasName(ModItems.PINE_BOAT.get()), has(ModItems.PINE_BOAT.get()))
                .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pWriter, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pWriter, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pWriter, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pWriter, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pWriter, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pWriter, RiordanMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }

    protected static void planksFromLog(Consumer<FinishedRecipe> pWriter, ItemLike pPlanks, ItemLike pLogs, boolean isDifferent) {
        if (isDifferent) {
            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, pPlanks, 4)
                    .requires(pLogs).group("planks")
                    .unlockedBy("has_log", has(pLogs))
                    .save(pWriter, RiordanMod.MOD_ID + ":" + getItemName(pPlanks) + "_from_" + getItemName(pLogs));
        } else {
            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, pPlanks, 4)
                    .requires(pLogs).group("planks")
                    .unlockedBy("has_log", has(pLogs))
                    .save(pWriter, RiordanMod.MOD_ID + ":" + getItemName(pPlanks) + "_from_" + getItemName(pLogs));
        }
    }
}
