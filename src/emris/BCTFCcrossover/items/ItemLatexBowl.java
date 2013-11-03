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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import TFC.API.ISize;
import TFC.API.Enums.EnumSize;
import TFC.API.Enums.EnumWeight;
import TFC.Items.ItemTerra;
import buildcraft.core.CreativeTabBuildCraft;
import buildcraft.core.utils.StringUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import emris.BCTFCcrossover.Reference;

public class ItemLatexBowl extends ItemTerra implements ISize {

	private String iconName;
	public ItemLatexBowl(int par1) {
		super(par1);
		setUnlocalizedName("LatexBowl");
		setContainerItem(Item.bowlEmpty);
		setCreativeTab(CreativeTabBuildCraft.MACHINES.get());
	}
	
	@Override
	public EnumSize getSize() {
		return EnumSize.SMALL;
	}

	@Override
	public EnumWeight getWeight() {
		return EnumWeight.LIGHT;
	}
	
	@Override
	public boolean canStack() {
		return false;
	}

	@Override
	public Item setUnlocalizedName(String par1Str) {
		iconName = par1Str;
		return super.setUnlocalizedName(par1Str);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(Reference.ModID + ":" + iconName);
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
}
