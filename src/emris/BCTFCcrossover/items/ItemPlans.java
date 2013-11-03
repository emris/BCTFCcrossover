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
package emris.BCTFCcrossover.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import TFC.API.ISize;
import TFC.API.Enums.EnumSize;
import TFC.API.Enums.EnumWeight;
import TFC.Items.ItemTerra;
import buildcraft.core.CreativeTabBuildCraft;
import buildcraft.core.utils.StringUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import emris.BCTFCcrossover.Reference;

public class ItemPlans extends ItemTerra implements ISize {

	private int metaSize = 3;
	private Icon[] icons = new Icon[metaSize];
	
	public ItemPlans(int id) {
		super(id);
		setMaxDamage(0);
		setHasSubtypes(true);
		setCreativeTab(CreativeTabBuildCraft.MACHINES.get());
		setUnlocalizedName("Plan");
		MetaNames = new String[]{"Gear","Wrench","PipeFrame"};
	}

	@Override
	public EnumSize getSize() {
		return EnumSize.MEDIUM;
	}
	
	@Override
	public EnumWeight getWeight() {
		return EnumWeight.MEDIUM;
	}

	@Override
	public boolean canStack() {
		return false;
	}

	@Override
	public Icon getIconFromDamage(int meta) {
		return icons[meta];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister registerer) {
		for(int i = 0; i < metaSize; i++)
			icons[i] = registerer.registerIcon(Reference.ModID + ":" + this.getUnlocalizedName().replace("item.", "") + MetaNames[i]);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List list) {
		for(int i = 0; i < metaSize; i++) {
			list.add(new ItemStack(this,1,i));
		}
	}
	
	@Override
	public String getItemDisplayName(ItemStack itemstack) {
		return StringUtils.localize(getUnlocalizedName(itemstack));
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

//	@Override
//	public ItemStack onItemRightClick(ItemStack par1ItemStack, World world, EntityPlayer par3EntityPlayer) {
//		MovingObjectPosition mop = PlayerUtils.getTargetBlock(par3EntityPlayer);
//		
//		if (mop != null) {
//			if (mop.typeOfHit == EnumMovingObjectType.TILE) {
//				int bID = world.getBlockId(mop.blockX, mop.blockY, mop.blockZ);
//				if (bID == BuildCraftFactory.tankBlock.blockID) {
//					System.out.println("" + bID);
//				}
//			}
//		}
//		
//		return par1ItemStack;
//	}


}
