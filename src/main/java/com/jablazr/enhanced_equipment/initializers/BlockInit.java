package com.jablazr.enhanced_equipment.initializers;

import com.jablazr.enhanced_equipment.EnhancedEquipmentMod;
import com.jablazr.enhanced_equipment.blocks.CobaltBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, EnhancedEquipmentMod.MODID);

    public static final RegistryObject<CobaltBlock> COBALT_BLOCK = BLOCKS.register(CobaltBlock.registryName,
            () -> new CobaltBlock(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK)
            ));
}
