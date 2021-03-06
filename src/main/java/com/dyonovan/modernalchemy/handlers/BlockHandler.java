package com.dyonovan.modernalchemy.handlers;

import com.dyonovan.modernalchemy.blocks.arcfurnace.BlockArcFurnaceCore;
import com.dyonovan.modernalchemy.blocks.arcfurnace.dummies.*;
import com.dyonovan.modernalchemy.blocks.fluids.BlockFluidActinium;
import com.dyonovan.modernalchemy.blocks.fluids.BlockFluidCompressedAir;
import com.dyonovan.modernalchemy.blocks.machines.BlockCompressor;
import com.dyonovan.modernalchemy.blocks.machines.BlockPatternRecorder;
import com.dyonovan.modernalchemy.blocks.machines.BlockSolidifier;
import com.dyonovan.modernalchemy.blocks.ore.BlockOreActinium;
import com.dyonovan.modernalchemy.blocks.replicator.BlockReplicatorStand;
import com.dyonovan.modernalchemy.blocks.replicator.BlockReplicatorFrame;
import com.dyonovan.modernalchemy.blocks.replicator.BlockReplicatorCPU;
import com.dyonovan.modernalchemy.blocks.teslacoil.BlockTeslaBase;
import com.dyonovan.modernalchemy.blocks.teslacoil.BlockTeslaCoil;
import com.dyonovan.modernalchemy.blocks.teslacoil.BlockTeslaStand;
import com.dyonovan.modernalchemy.fluids.FluidActinium;
import com.dyonovan.modernalchemy.fluids.FluidCompressedAir;
import com.dyonovan.modernalchemy.tileentity.arcfurnace.TileArcFurnaceCore;
import com.dyonovan.modernalchemy.tileentity.arcfurnace.dummies.*;
import com.dyonovan.modernalchemy.tileentity.machines.TileCompressor;
import com.dyonovan.modernalchemy.tileentity.machines.TilePatternRecorder;
import com.dyonovan.modernalchemy.tileentity.machines.TileSolidifier;
import com.dyonovan.modernalchemy.tileentity.replicator.TileReplicatorFrame;
import com.dyonovan.modernalchemy.tileentity.replicator.TileReplicatorCPU;
import com.dyonovan.modernalchemy.tileentity.replicator.TileReplicatorStand;
import com.dyonovan.modernalchemy.tileentity.teslacoil.TileTeslaBase;
import com.dyonovan.modernalchemy.tileentity.teslacoil.TileTeslaCoil;
import com.dyonovan.modernalchemy.tileentity.teslacoil.TileTeslaStand;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class BlockHandler {

    public static Fluid fluidActinium, fluidCompressedAir;
    public static Block blockArcFurnaceDummy, blockArcFurnaceDummyItemIO, blockArcFurnaceDummyAirValue, blockArcFurnaceDummyOutputValue, blockArcFurnaceDummyEnergy, blockArcFurnaceCore, blockTeslaStand, blockCoil;
    public static Block blockOreActinium, blockFluidActinium, blockCompressor, blockFluidAir, blockReplicatorStand;
    public static Block blockPatternRecorder, blockSolidifier, blockTeslaBase, blockReplicatorFrame, blockReplicatorCPU;

    public static void init() {
        //Actinium Fluid Registration
        fluidActinium = new FluidActinium();
        FluidRegistry.registerFluid(fluidActinium);
        blockFluidActinium = new BlockFluidActinium();
        GameRegistry.registerBlock(blockFluidActinium, "fluidActinium");

        //Fluid Compressed Air
        fluidCompressedAir = new FluidCompressedAir();
        FluidRegistry.registerFluid(fluidCompressedAir);
        blockFluidAir = new BlockFluidCompressedAir();
        GameRegistry.registerBlock(blockFluidAir, "blockFluidAir");

        //Ore Actinium
        blockOreActinium = new BlockOreActinium();
        GameRegistry.registerBlock(blockOreActinium, "oreActinium");

        //Block Compressor
        blockCompressor = new BlockCompressor();
        GameRegistry.registerBlock(blockCompressor, "blockCompressor");
        GameRegistry.registerTileEntity(TileCompressor.class, "teCompressor");

        //Solidifier
        blockSolidifier = new BlockSolidifier();
        GameRegistry.registerBlock(blockSolidifier, "blockSolidifier");
        GameRegistry.registerTileEntity(TileSolidifier.class, "blockSolidifier");

        // Block Pattern Recorder
        blockPatternRecorder = new BlockPatternRecorder();
        GameRegistry.registerBlock(blockPatternRecorder, "patternRecorder");
        GameRegistry.registerTileEntity(TilePatternRecorder.class, "patternRecorder");

        //ArcFurnaceCore
        blockArcFurnaceCore = new BlockArcFurnaceCore();
        GameRegistry.registerBlock(blockArcFurnaceCore, "arcFurnaceCore");
        GameRegistry.registerTileEntity(TileArcFurnaceCore.class, "arcFurnaceCore");

        //ArcFurnaceDummy
        blockArcFurnaceDummy = new BlockDummy("arcFurnaceDummy");
        GameRegistry.registerBlock(blockArcFurnaceDummy, "arcFurnaceDummy");
        GameRegistry.registerTileEntity(TileDummy.class, "tileDummy");

        //ArcFurnaceDummy Energy
        blockArcFurnaceDummyEnergy = new BlockDummyEnergyReciever("arcFurnaceDummyEnergy");
        GameRegistry.registerBlock(blockArcFurnaceDummyEnergy, "arcFurnaceDummyEnergy");
        GameRegistry.registerTileEntity(TileDummyEnergyReciever.class, "tileDummyEnergy");

        //ArcFurnaceDummyItemIO
        blockArcFurnaceDummyItemIO = new BlockItemIODummy("arcFurnaceDummyItemIO");
        GameRegistry.registerBlock(blockArcFurnaceDummyItemIO, "arcFurnaceDummyItemIO");
        GameRegistry.registerTileEntity(TileDummyItemIO.class, "tileDummyItemIO");

        //ArcFurnaceDummyAirValue
        blockArcFurnaceDummyAirValue = new BlockDummyAirValve("arcFurnaceDummyAirValue");
        GameRegistry.registerBlock(blockArcFurnaceDummyAirValue, "arcFurnaceDummyAirValve");
        GameRegistry.registerTileEntity(TileDummyAirValve.class, "tileDummyAirValve");

        //ArcFurnaceDummyOutputValue
        blockArcFurnaceDummyOutputValue = new BlockDummyOutputValve("arcFurnaceDummyOutputValue");
        GameRegistry.registerBlock(blockArcFurnaceDummyOutputValue, "arcFurnaceDummyOutputValve");
        GameRegistry.registerTileEntity(TileDummyOutputValve.class, "tileDummyOutputValve");

        //Tesla Base
        blockTeslaBase = new BlockTeslaBase();
        GameRegistry.registerBlock(blockTeslaBase, "blockTeslaBase");
        GameRegistry.registerTileEntity(TileTeslaBase.class, "blockTeslaBase");

        //Tesla Stand
        blockTeslaStand = new BlockTeslaStand();
        GameRegistry.registerBlock(blockTeslaStand, "blockTeslaStand");
        GameRegistry.registerTileEntity(TileTeslaStand.class, "blockTeslaStand");

        //Tesla Coil
        blockCoil = new BlockTeslaCoil();
        GameRegistry.registerBlock(blockCoil, "blockCoil");
        GameRegistry.registerTileEntity(TileTeslaCoil.class, "blockCoil");

        //BlockFrameEnergy
        blockReplicatorCPU = new BlockReplicatorCPU();
        GameRegistry.registerBlock(blockReplicatorCPU, "blockReplicatorCPU");
        GameRegistry.registerTileEntity(TileReplicatorCPU.class, "blockReplicatorCPU");

        //BlockFrame
        blockReplicatorFrame = new BlockReplicatorFrame();
        GameRegistry.registerBlock(blockReplicatorFrame, "blockReplicatorFrame");
        GameRegistry.registerTileEntity(TileReplicatorFrame.class, "blockReplicatorFrame");

        //BlockCenterStand
        blockReplicatorStand = new BlockReplicatorStand();
        GameRegistry.registerBlock(blockReplicatorStand, "blockReplicatorStand");
        GameRegistry.registerTileEntity(TileReplicatorStand.class, "blockReplicatorStand");
    }
}