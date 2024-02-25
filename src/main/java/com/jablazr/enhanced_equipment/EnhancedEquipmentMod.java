package com.jablazr.enhanced_equipment;

import com.jablazr.enhanced_equipment.initializers.BlockInit;
import com.jablazr.enhanced_equipment.initializers.CreativeTabInit;
import com.jablazr.enhanced_equipment.initializers.ItemInit;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(EnhancedEquipmentMod.MODID)
public class EnhancedEquipmentMod
{
    public static final String MODID = "enhanced_equipment";

    public EnhancedEquipmentMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        BlockInit.BLOCKS.register(modEventBus);
        ItemInit.ITEMS.register(modEventBus);
        CreativeTabInit.TABS.register(modEventBus);
    }
}
