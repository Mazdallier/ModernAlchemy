package com.dyonovan.modernalchemy.tileentity.teslacoil;

import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyHandler;
import com.dyonovan.modernalchemy.tileentity.BaseTile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileTeslaBase extends BaseTile implements IEnergyHandler {

    protected EnergyStorage energy = new EnergyStorage(1000, 1000, 1000);

    public TileTeslaBase() {

    }

    @Override
    public void onWrench(EntityPlayer player) {
        if(getTileInDirection(ForgeDirection.UP) instanceof TileTeslaStand)
            ((TileTeslaStand)getTileInDirection(ForgeDirection.UP)).onWrench(player);
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        energy.readFromNBT(tag);
    }

    @Override
    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
        energy.writeToNBT(tag);
    }

    @Override
    public int receiveEnergy(ForgeDirection side, int maxReceive, boolean simulate) {
        return energy.receiveEnergy(maxReceive, simulate);
    }

    @Override
    public int extractEnergy(ForgeDirection side, int maxReceive, boolean simulate) {
        return energy.extractEnergy(maxReceive, simulate);
    }

    @Override
    public int getEnergyStored(ForgeDirection forgeDirection) {
        return energy.getEnergyStored();
    }

    @Override
    public int getMaxEnergyStored(ForgeDirection forgeDirection) {
        return energy.getMaxEnergyStored();
    }

    @Override
    public boolean canConnectEnergy(ForgeDirection side) {
        return side == ForgeDirection.DOWN;
    }

    @Override
    public void updateEntity() {
        if ((energy.getEnergyStored() > 0)) {

            TileEntity tile = worldObj.getTileEntity(xCoord, yCoord + 1, zCoord);
            if (tile instanceof TileTeslaStand) {
                energy.extractEnergy(((IEnergyHandler) tile).receiveEnergy(ForgeDirection.DOWN, energy.extractEnergy(energy.getMaxExtract(), true), false), false);
            }
        }
    }
}
