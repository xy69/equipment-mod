package com.example.examplemod.init;

import com.example.examplemod.ExampleMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MODID);

    public static final RegistryObject<BlockItem> ENHANCER_BLOCK_ITEM = ITEMS.register("enhancer_block",
            () -> new BlockItem(BlockInit.ENHANCER_BLOCK.get(),
                    new Item.Properties()
                            .rarity(Rarity.UNCOMMON)));

}
