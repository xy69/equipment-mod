package com.jablazr.enhanced_equipment.initializers;

import com.jablazr.enhanced_equipment.EnhancedEquipmentMod;
import com.jablazr.enhanced_equipment.blocks.CobaltBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.jablazr.enhanced_equipment.initializers.CreativeTabInit.addToTab;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EnhancedEquipmentMod.MODID);
    public static final RegistryObject<BlockItem> COBALT_BLOCK_ITEM = addToTab(ITEMS.register(CobaltBlock.registryName,
            () -> new BlockItem(BlockInit.COBALT_BLOCK.get(),
                    new Item.Properties()
                            .rarity(Rarity.UNCOMMON)
            )));
}
