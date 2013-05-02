/**
 *  Copyright (C) 2013  emris
 *  https://github.com/emris/BCTFCcrossover
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
package mods.BCTFCcrossover.items;

import java.util.List;

import mods.BCTFCcrossover.utils.PlayerUtils;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import TFC.Enums.EnumSize;
import TFC.Enums.EnumWeight;
import TFC.Items.ISize;
import buildcraft.BuildCraftEnergy;
import buildcraft.BuildCraftFactory;
import buildcraft.core.CreativeTabBuildCraft;
import buildcraft.core.utils.StringUtil;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemWoodBucketOil extends ItemBucket implements ISize {

	public ItemWoodBucketOil(int id) {
		super(id, BuildCraftEnergy.oilMoving.blockID);
		setCreativeTab(CreativeTabBuildCraft.tabBuildCraft);
	}

	@Override
	public EnumSize getSize() {
		return EnumSize.MEDIUM;
	}
	
	@Override
	public EnumWeight getWeight() {
		return null;
	}

	@Override
	public boolean canStack() {
		return false;
	}

	@Override
	public String getItemDisplayName(ItemStack itemstack) {
		return StringUtil.localize(getUnlocalizedName(itemstack));
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void updateIcons(IconRegister par1IconRegister) {
		this.iconIndex = par1IconRegister.registerIcon("BCTFCcrossover:" + getUnlocalizedName().replace("item.", ""));
	}
	
	public static void addSizeInformation(ISize object, List arraylist) {
		if(object.getSize()!= null && object.getWeight() != null)
			arraylist.add("\u2696" + object.getWeight().getName() + " \u21F2" + object.getSize().getName());
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		this.addSizeInformation(this, par3List);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World world, EntityPlayer par3EntityPlayer) {
		MovingObjectPosition mop = PlayerUtils.getTargetBlock(par3EntityPlayer);
		
		if (mop != null) {
			if (mop.typeOfHit == EnumMovingObjectType.TILE) {
				int bID = world.getBlockId(mop.blockX, mop.blockY, mop.blockZ);
				if (bID == BuildCraftFactory.tankBlock.blockID) {
					System.out.println("" + bID);
				}
			}
		}
		
		return par1ItemStack;
	}


}
