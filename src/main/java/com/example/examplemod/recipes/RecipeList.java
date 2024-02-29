package com.example.examplemod.recipes;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.ArrayList;
import java.util.List;

public class RecipeList {
    public static List<EnhancementRecipe> enhancementRecipes = new ArrayList<>();

    EnhancementRecipe COBALT_ENHANCEMENT_HELMET = registerRecipe(EquipmentType.HELMET, Items.LAPIS_LAZULI, "is_cobalt_enhanced");
    EnhancementRecipe COBALT_ENHANCEMENT_CHESTPLATE = registerRecipe(EquipmentType.CHESTPLATE, Items.LAPIS_LAZULI, "is_cobalt_enhanced");
    EnhancementRecipe COBALT_ENHANCEMENT_LEGGINS = registerRecipe(EquipmentType.LEGGINS, Items.LAPIS_LAZULI, "is_cobalt_enhanced");
    EnhancementRecipe COBALT_ENHANCEMENT_BOOTS = registerRecipe(EquipmentType.BOOTS, Items.LAPIS_LAZULI, "is_cobalt_enhanced");
    EnhancementRecipe COBALT_ENHANCEMENT_PICKAXE = registerRecipe(EquipmentType.PICKAXE, Items.LAPIS_LAZULI, "is_cobalt_enhanced");
    EnhancementRecipe COBALT_ENHANCEMENT_AXE = registerRecipe(EquipmentType.AXE, Items.LAPIS_LAZULI, "is_cobalt_enhanced");
    EnhancementRecipe COBALT_ENHANCEMENT_HOE = registerRecipe(EquipmentType.HOE, Items.LAPIS_LAZULI, "is_cobalt_enhanced");
    EnhancementRecipe COBALT_ENHANCEMENT_SHOVEL = registerRecipe(EquipmentType.SHOVEL, Items.LAPIS_LAZULI, "is_cobalt_enhanced");

    public static EnhancementRecipe registerRecipe(EquipmentType type, Item resource, String effect) {
        EnhancementRecipe recipe = new EnhancementRecipe(type, resource, effect);
        enhancementRecipes.add(recipe);

        return recipe;
    }
}
