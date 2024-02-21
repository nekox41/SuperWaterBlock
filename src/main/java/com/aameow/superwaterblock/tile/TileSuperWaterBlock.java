package com.aameow.superwaterblock.tile;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;

import javax.annotation.Nullable;

public class TileSuperWaterBlock extends TileEntity {
  private final IFluidHandler tank =
      new FluidTank(32000) {
        private final FluidStack MAX_WATER = new FluidStack(FluidRegistry.WATER, Integer.MAX_VALUE);

        @Override
        public FluidStack getFluid() {
          return MAX_WATER;
        }

        @Override
        public int getFluidAmount() {
          return Integer.MAX_VALUE;
        }

        @Override
        public int getCapacity() {
          return Integer.MAX_VALUE;
        }

        @Override
        public FluidStack drain(FluidStack resource, boolean doDrain) {
          if (resource.getFluid() == FluidRegistry.WATER) return resource.copy();
          return super.drain(resource, doDrain);
        }

        @Override
        public FluidStack drain(int maxDrain, boolean doDrain) {
          return new FluidStack(FluidRegistry.WATER, maxDrain);
        }
      };

  /**
   * @param capability The capability to check
   * @param facing The Side to check from: CAN BE NULL. Null is defined to represent 'internal' or
   *     'self'
   */
  @Override
  public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
    return capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY
        || super.hasCapability(capability, facing);
  }

  /**
   * @param capability The capability to check
   * @param facing The Side to check from, <strong>CAN BE NULL</strong>. Null is defined to
   *     represent 'internal' or 'self'
   * @return
   * @param <T>
   */
  @Nullable
  @Override
  public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
    if (capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) {
      return CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY.cast(this.tank);
    } else {
      return super.getCapability(capability, facing);
    }
  }
}
