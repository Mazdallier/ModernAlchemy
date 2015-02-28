package com.dyonovan.modernalchemy.blocks.machines;

import com.dyonovan.modernalchemy.ModernAlchemy;
import com.dyonovan.modernalchemy.blocks.BlockBase;
import com.dyonovan.modernalchemy.handlers.GuiHandler;
import com.dyonovan.modernalchemy.lib.Constants;
import com.dyonovan.modernalchemy.manual.component.ComponentBase;
import com.dyonovan.modernalchemy.manual.component.ComponentItemRender;
import com.dyonovan.modernalchemy.tileentity.machines.TileElectricBellows;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class BlockElectricBellows extends BlockBase {

    @SideOnly(Side.CLIENT)
    private IIcon front;

    public BlockElectricBellows() {
        super(Material.anvil);
        this.setBlockName(Constants.MODID + ":blockElectricBellows");
        this.setCreativeTab(ModernAlchemy.tabModernAlchemy);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconregister) {
        this.blockIcon = iconregister.registerIcon(Constants.MODID + ":bellows_side");
        this.front = iconregister.registerIcon(Constants.MODID + ":bellows_front");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2)
    {
        return par2 == 0 && par1 == 4 ? this.front : (par1 != par2 ? this.blockIcon : par1 != 0 ? this.front : blockIcon);
    }

    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemstack) {
        int l = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0) {
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        }

        if (l == 1) {
            world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        }

        if (l == 2) {
            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        }

        if (l == 3) {
            world.setBlockMetadataWithNotify(x, y, z, 4, 2);
        }
    }

    @Override
    public boolean hasTileEntity(int metadata) {
        return true;
    }


    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileElectricBellows();
    }

    @Override
    public List<ComponentBase> getManualComponents() {
        List<ComponentBase> parts = new ArrayList<ComponentBase>();
        parts.add(new ComponentItemRender(30, new ItemStack(this)));
        return parts;
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        super.onBlockActivated(world, x, y, z, player, par6, par7, par8, par9);

        if (world.isRemote)
        {
            return true;
        }
        else
        {
            TileElectricBellows tile = (TileElectricBellows)world.getTileEntity(x, y, z);
            if(tile != null) {
                player.openGui(ModernAlchemy.instance, GuiHandler.ELECTRIC_BELLOWS_GUI_ID, world, x, y, z);
            }
            return true;
        }
    }
}


