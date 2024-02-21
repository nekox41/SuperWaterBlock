package com.aameow.superwaterblock.block;

import com.aameow.superwaterblock.SuperWaterBlock;
import com.aameow.superwaterblock.tile.TileSuperWaterBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtils;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;

import javax.annotation.Nullable;

public class BlockSuperWaterBlock extends Block {

  public BlockSuperWaterBlock(String name) {
    super(Material.ROCK);
    setRegistryName(SuperWaterBlock.MODID, name);
    setTranslationKey("superwaterblock:" + name);
    setCreativeTab(SuperWaterBlock.SWB_TAB);
  }

  @Override
  public boolean onBlockActivated(
      World worldIn,
      BlockPos pos,
      IBlockState state,
      EntityPlayer playerIn,
      EnumHand hand,
      EnumFacing facing,
      float hitX,
      float hitY,
      float hitZ) {
    ItemStack heldItem = playerIn.getHeldItem(hand);
    TileEntity tileEntity = worldIn.getTileEntity(pos);
    // 获取到 TileEntity
    if (tileEntity != null) {
      IFluidHandler capability =
          tileEntity.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, facing);
      // 判断是否为 Fluid Handler Capability
      if (capability == null) return false;
      return FluidUtil.interactWithFluidHandler(playerIn, hand, capability);
    }
    return false;
  }

  /**
   * Called throughout the code as a replacement for block instanceof BlockContainer Moving this to
   * the Block base class allows for mods that wish to extend vanilla blocks, and also want to have
   * a tile entity on that block, may.
   *
   * <p>Return true from this function to specify this block has a tile entity.
   *
   * @param state State of the current block
   * @return True if block has a tile entity, false otherwise
   */
  @Override
  public boolean hasTileEntity(IBlockState state) {
    return true;
  }

  /**
   * Called throughout the code as a replacement for ITileEntityProvider.createNewTileEntity Return
   * the same thing you would from that function. This will fall back to
   * ITileEntityProvider.createNewTileEntity(World) if this block is a ITileEntityProvider
   *
   * @param world
   * @param state The state of the current block
   * @return A instance of a class extending TileEntity
   */
  @Nullable
  @Override
  public TileEntity createTileEntity(World world, IBlockState state) {
    return new TileSuperWaterBlock();
  }
}
