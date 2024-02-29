package com.example.examplemod.init;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.menus.EnhancerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MenuInit {
    public static final DeferredRegister<MenuType<?>> MENU_TYPES =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, ExampleMod.MODID);

    public static final RegistryObject<MenuType<EnhancerMenu>> ENHANCER_MENU = MENU_TYPES.register("enhancer_menu",
            () -> IForgeMenuType.create(EnhancerMenu::new));

}
