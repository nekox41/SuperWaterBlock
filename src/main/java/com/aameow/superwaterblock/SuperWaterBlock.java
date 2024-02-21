package com.aameow.superwaterblock;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = SuperWaterBlock.MODID, name = SuperWaterBlock.NAME, version = SuperWaterBlock.VERSION)
public class SuperWaterBlock {
  public static final String MODID = "superwaterblock";
  public static final String NAME = "Super WaterB lock";
  public static final String VERSION = "1.0";

  private static Logger logger;

  //  @SidedProxy(clientSide = "com.aameow.superwaterblock.client.ClientProxy", serverSide =
  // "com.aameow.superwaterblock.CommonProxy")
  //  public static  Proxy PROXY;

  public static final CreativeTabs SWB_TAB =
      new CreativeTabs("superwaterblock") {
        @Override
        public ItemStack createIcon() {
          return new ItemStack(Items.DIAMOND);
        }
      };

  @EventHandler
  public void preInit(FMLPreInitializationEvent event) {
    logger = event.getModLog();
  }

  @EventHandler
  public void init(FMLInitializationEvent event) {}
}
