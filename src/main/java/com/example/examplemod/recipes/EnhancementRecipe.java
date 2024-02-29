package com.example.examplemod.recipes;


import net.minecraft.world.item.Item;



public class EnhancementRecipe {
    public final EquipmentType type;
    public final Item resource;

    public final String effect;

    public EnhancementRecipe(EquipmentType type, Item resource, String effect) {
        this.type = type;
        this.resource = resource;
        this.effect = effect;
    }
}