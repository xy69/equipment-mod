package com.example.examplemod.menus;

import com.example.examplemod.init.MenuInit;
import com.example.examplemod.recipes.EnhancementRecipe;
import com.example.examplemod.recipes.EquipmentType;
import com.example.examplemod.recipes.RecipeList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;

public class EnhancerMenu extends ItemCombinerMenu {

    @javax.annotation.Nullable
    private String itemName;

    public int repairItemCountCost;


    public EnhancerMenu(int pContainerId, Inventory pInventory, FriendlyByteBuf friendlyByteBuf) {
        this(pContainerId, pInventory, ContainerLevelAccess.NULL);
    }


    public EnhancerMenu(int pContainerId, Inventory pPlayerInventory, ContainerLevelAccess pContainerLevelAccess) {
        super(MenuInit.ENHANCER_MENU.get(), pContainerId, pPlayerInventory, pContainerLevelAccess);
    }



    @Override
    protected boolean mayPickup(Player p_39023_, boolean p_39024_) {
        return (p_39023_.getAbilities().instabuild);
    }

    @Override
    protected void onTake(Player p_150474_, ItemStack p_150475_) {
        this.inputSlots.setItem(0, ItemStack.EMPTY);
        ItemStack resourceStack = this.inputSlots.getItem(1);
        ItemStack resourceStackCopy = resourceStack.copy();
        int newResourceStackCount = resourceStackCopy.getCount() - 1;
        if(newResourceStackCount > 0) {
            resourceStackCopy.setCount(newResourceStackCount);
            this.inputSlots.setItem(1, resourceStackCopy);
        } else {
            this.inputSlots.setItem(1, ItemStack.EMPTY);
        }
        broadcastChanges();
    }

    @Override
    protected boolean isValidBlock(BlockState p_39019_) {
        return true;
    }

    @Override
    public void createResult() {
        ItemStack itemStack = this.inputSlots.getItem(0);
        ItemStack resourceStack = this.inputSlots.getItem(1);
        Optional<EquipmentType> type = getEquipmentType(itemStack);

        if(type.isEmpty()) return;

        Item resource = resourceStack.getItem();

        List<EnhancementRecipe> allRecipes = RecipeList.enhancementRecipes;

        Optional<EnhancementRecipe> chosenRecipe = allRecipes.stream().filter((recipe) -> recipe.type == type.get() && recipe.resource == resource).findFirst();


        if(itemStack.isEmpty() || chosenRecipe.isEmpty()) {
            this.resultSlots.setItem(0, ItemStack.EMPTY);
        } else {
            ItemStack itemStack1 = itemStack.copy();
            CompoundTag enhancements = itemStack1.getOrCreateTagElement("enhancements");
            enhancements.putBoolean(chosenRecipe.get().effect, true);

            this.resultSlots.setItem(0, itemStack1);
        }
        this.broadcastChanges();
    }

    @NotNull
    private static Optional<EquipmentType> getEquipmentType(ItemStack itemStack) {
        Optional<EquipmentType> type = Optional.empty();
        Item item = itemStack.getItem();
        if(item instanceof ArmorItem armorItem) {
            ArmorItem.Type itemType = armorItem.getType();
            if(itemType == ArmorItem.Type.HELMET) {
                type = Optional.of(EquipmentType.HELMET);
            } else if(itemType == ArmorItem.Type.CHESTPLATE) {
                type = Optional.of(EquipmentType.CHESTPLATE);
            }else if(itemType == ArmorItem.Type.LEGGINGS) {
                type = Optional.of(EquipmentType.LEGGINS);
            }else if(itemType == ArmorItem.Type.BOOTS) {
                type = Optional.of(EquipmentType.BOOTS);
            }
        } else if(item instanceof ShovelItem) {
            type = Optional.of(EquipmentType.SHOVEL);
        } else if(item instanceof AxeItem) {
            type = Optional.of(EquipmentType.AXE);
        } else if(item instanceof HoeItem) {
            type = Optional.of(EquipmentType.HOE);
        } else if(item instanceof PickaxeItem) {
            type = Optional.of(EquipmentType.PICKAXE);
        }
        return type;
    }


    @Override
    protected ItemCombinerMenuSlotDefinition createInputSlotDefinitions() {
        return ItemCombinerMenuSlotDefinition.create().withSlot(0, 27, 36, (p_266635_) -> {
            return true;
        }).withSlot(1, 76, 36, (p_266634_) -> {
            return true;
        }).withResultSlot(2, 134, 36).build();
    }
}
