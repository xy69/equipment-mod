package com.example.examplemod.events;

import com.example.examplemod.ExampleMod;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = ExampleMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EnhancedEquipmentEffectHandler {
    @SubscribeEvent
    public static void onEquipmentChanged(LivingEquipmentChangeEvent event) {
        if(event.getSlot().isArmor()) {

            int speedStrenght = 0;

            for (ItemStack armorSlot : event.getEntity().getArmorSlots()) {
                if (armorSlot.isEmpty()) continue;
                CompoundTag enhancementsTag = armorSlot.getOrCreateTagElement("enhancements");
                Tag isCobaltEnhanced = enhancementsTag.get("is_cobalt_enhanced");
                if (isCobaltEnhanced != null) {
                    if (isCobaltEnhanced.getType().isValue()) {
                        speedStrenght++;
                    }
                }
            }
            event.getEntity().removeEffect(MobEffects.MOVEMENT_SPEED);
            if(speedStrenght > 0) {
                event.getEntity().addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, -1, speedStrenght - 1));
            }
        } else {
            event.getEntity().removeEffect(MobEffects.DIG_SPEED);
            ItemStack itemStack = event.getTo();
            Item item = itemStack.getItem();
            CompoundTag enhancementsTag = itemStack.getOrCreateTagElement("enhancements");
            Tag isCobaltEnhanced = enhancementsTag.get("is_cobalt_enhanced");

            if(isCobaltEnhanced == null) return;

            if(item instanceof ShovelItem
            || item instanceof AxeItem
            || item instanceof HoeItem
            || item instanceof PickaxeItem) {
                event.getEntity().addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, -1, 1));
            }
        }
    }





    @SubscribeEvent
    public static void onNBTRender(ItemTooltipEvent event) {
        ItemStack itemStack = event.getItemStack();
        List<Component> toolTip = event.getToolTip();
        CompoundTag enhancements = itemStack.getTagElement("enhancements");
        if(enhancements == null) return;

        for (int i = 0; i < enhancements.getAllKeys().size(); i++) {
            toolTip.add(1, Component.literal("§1Cobalt Enhanced"));
        }


        for(int i = 0; i < toolTip.size(); i++) {
            String string = toolTip.get(i).getString();
            if(string.contains("NBT")) {
                String[] s = string.split(" ");
                int nrTags = Integer.parseInt(s[1]);
                if(nrTags <= 2) {
                    toolTip.remove(i);
                    i--;
                } else {
                    s[1] = String.valueOf((nrTags - 1));
                    String newTooltip = "§8";
                    for (String s1 : s) {
                        newTooltip += s1 + " ";
                    }
                    newTooltip = newTooltip.trim();
                    toolTip.set(i, Component.literal(newTooltip));
                }

            }
        }
    }

}
