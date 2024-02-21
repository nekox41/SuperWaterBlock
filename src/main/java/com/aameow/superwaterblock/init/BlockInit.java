package com.aameow.superwaterblock.init;

import com.aameow.superwaterblock.SuperWaterBlock;
import com.aameow.superwaterblock.block.BlockSuperWaterBlock;
import com.aameow.superwaterblock.tile.TileSuperWaterBlock;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber(modid = SuperWaterBlock.MODID)
public class BlockInit {

  private static final Block SUPER_WATER_BLOCK = new BlockSuperWaterBlock("block");

  @SubscribeEvent
  public static void registerBlocks(RegistryEvent.Register<Block> event) {
    event.getRegistry().registerAll(SUPER_WATER_BLOCK);
    GameRegistry.registerTileEntity(
        TileSuperWaterBlock.class,
        new ResourceLocation(SuperWaterBlock.MODID, "super_water_block"));
  }

  @SubscribeEvent
  public static void registerItem(RegistryEvent.Register<Item> event) {
    event
        .getRegistry()
        .registerAll(
            new ItemBlock(SUPER_WATER_BLOCK).setRegistryName(SuperWaterBlock.MODID, "block"));
  }

  @SubscribeEvent
  public static void registerModel(ModelRegistryEvent event) {
    ModelLoader.setCustomModelResourceLocation(
        Item.getItemFromBlock(SUPER_WATER_BLOCK),
        0,
        new ModelResourceLocation(SUPER_WATER_BLOCK.getRegistryName(), "inventory"));
  }
}
