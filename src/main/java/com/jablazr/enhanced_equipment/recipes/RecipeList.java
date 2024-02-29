package com.jablazr.enhanced_equipment.recipes;

import com.jablazr.enhanced_equipment.initializers.ItemInit;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.world.item.Item;

public class RecipeList {
  public static List<EnhancementRecipe> enhancementRecipes = new ArrayList<>();

  static EnhancementRecipe COBALT_ENHANCEMENT_HELMET =
      registerRecipe(EquipmentType.HELMET, ItemInit.COBALT_INGOT.get(), "is_cobalt_enhanced");
  static EnhancementRecipe COBALT_ENHANCEMENT_CHESTPLATE =
      registerRecipe(EquipmentType.CHESTPLATE, ItemInit.COBALT_INGOT.get(), "is_cobalt_enhanced");
  static EnhancementRecipe COBALT_ENHANCEMENT_LEGGINS =
      registerRecipe(EquipmentType.LEGGINS, ItemInit.COBALT_INGOT.get(), "is_cobalt_enhanced");
  static EnhancementRecipe COBALT_ENHANCEMENT_BOOTS =
      registerRecipe(EquipmentType.BOOTS, ItemInit.COBALT_INGOT.get(), "is_cobalt_enhanced");
  static EnhancementRecipe COBALT_ENHANCEMENT_PICKAXE =
      registerRecipe(EquipmentType.PICKAXE, ItemInit.COBALT_INGOT.get(), "is_cobalt_enhanced");
  static EnhancementRecipe COBALT_ENHANCEMENT_AXE =
      registerRecipe(EquipmentType.AXE, ItemInit.COBALT_INGOT.get(), "is_cobalt_enhanced");
  static EnhancementRecipe COBALT_ENHANCEMENT_HOE =
      registerRecipe(EquipmentType.HOE, ItemInit.COBALT_INGOT.get(), "is_cobalt_enhanced");
  static EnhancementRecipe COBALT_ENHANCEMENT_SHOVEL =
      registerRecipe(EquipmentType.SHOVEL, ItemInit.COBALT_INGOT.get(), "is_cobalt_enhanced");

  public static EnhancementRecipe registerRecipe(EquipmentType type, Item resource, String effect) {
    EnhancementRecipe recipe = new EnhancementRecipe(type, resource, effect);
    enhancementRecipes.add(recipe);

    return recipe;
  }
}
