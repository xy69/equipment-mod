package com.jablazr.enhanced_equipment.initializers;

import com.jablazr.enhanced_equipment.EnhancedEquipmentMod;
import com.jablazr.enhanced_equipment.blocks.CobaltBlock;
import com.jablazr.enhanced_equipment.blocks.EnhancerBlock;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
  public static final DeferredRegister<Block> BLOCKS =
      DeferredRegister.create(ForgeRegistries.BLOCKS, EnhancedEquipmentMod.MODID);

  public static final RegistryObject<CobaltBlock> COBALT_BLOCK =
      BLOCKS.register(
          CobaltBlock.registryName,
          () -> new CobaltBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK)));

  public static final RegistryObject<DropExperienceBlock> EXAMPLE_ORE =
      BLOCKS.register(
          "example_ore",
          () ->
              new DropExperienceBlock(
                  UniformInt.of(4, 7), BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE)));

  public static final RegistryObject<DropExperienceBlock> DEEPSLATE_EXAMPLE_ORE =
      BLOCKS.register(
          "deepslate_example_ore",
          () ->
              new DropExperienceBlock(
                  UniformInt.of(4, 7),
                  BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_DIAMOND_ORE)));

  public static final RegistryObject<DropExperienceBlock> NETHER_EXAMPLE_ORE =
      BLOCKS.register(
          "nether_example_ore",
          () ->
              new DropExperienceBlock(
                  UniformInt.of(4, 7),
                  BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_QUARTZ_ORE)));

  public static final RegistryObject<DropExperienceBlock> END_EXAMPLE_ORE =
      BLOCKS.register(
          "end_example_ore",
          () ->
              new DropExperienceBlock(
                  UniformInt.of(4, 7), BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));

  public static final RegistryObject<Block> ENHANCER_BLOCK =
      BLOCKS.register(
          "enhancer_block",
          () ->
              new EnhancerBlock(
                  BlockBehaviour.Properties.ofFullCopy(Blocks.ANVIL)
                      .mapColor(MapColor.CLAY)
                      .strength(5.0f, 17f)
                      .instrument(NoteBlockInstrument.BANJO)
                      .lightLevel(state -> 10)
                      .requiresCorrectToolForDrops()
                      .pushReaction(PushReaction.DESTROY)));
}
