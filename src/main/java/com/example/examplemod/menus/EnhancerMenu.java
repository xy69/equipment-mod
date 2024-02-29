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

    }

    @Override
    protected boolean isValidBlock(BlockState p_39019_) {
        return true;
    }

    @Override
    public void createResult() {

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
