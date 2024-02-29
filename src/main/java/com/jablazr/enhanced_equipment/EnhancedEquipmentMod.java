package com.jablazr.enhanced_equipment;

import com.jablazr.enhanced_equipment.initializers.BlockInit;
import com.jablazr.enhanced_equipment.initializers.CreativeTabInit;
import com.jablazr.enhanced_equipment.initializers.ItemInit;
import com.jablazr.enhanced_equipment.initializers.MenuInit;
import com.jablazr.enhanced_equipment.screen.EnhancerScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(EnhancedEquipmentMod.MODID)
public class EnhancedEquipmentMod {
  public static final String MODID = "enhanced_equipment";

  public EnhancedEquipmentMod() {
    IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

    modEventBus.addListener(this::clientSetup);

    BlockInit.BLOCKS.register(modEventBus);
    ItemInit.ITEMS.register(modEventBus);
    CreativeTabInit.TABS.register(modEventBus);
    MenuInit.MENU_TYPES.register(modEventBus);
  }

  private void clientSetup(FMLClientSetupEvent event) {
    event.enqueueWork(
        () -> MenuScreens.register(MenuInit.ENHANCER_MENU.get(), EnhancerScreen::new));
  }
}
