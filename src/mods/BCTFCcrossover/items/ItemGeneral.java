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

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import TFC.Enums.EnumSize;
import TFC.Enums.EnumWeight;
import TFC.Items.ItemTerra;
import buildcraft.core.CreativeTabBuildCraft;
import buildcraft.core.utils.StringUtil;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemGeneral extends ItemTerra {
	public String iconName;
	private EnumSize itemSize;
	private EnumWeight itemWeight;

	public ItemGeneral(int i) {
		super(i);
		setCreativeTab(CreativeTabBuildCraft.tabBuildCraft);
		setSize(EnumSize.MEDIUM);
		setWeight(EnumWeight.MEDIUM);
	}
	
	@Override
	public Item setUnlocalizedName(String par1Str) {
		iconName = par1Str;
		return super.setUnlocalizedName(par1Str);
	}
	
	@Override
	public String getItemDisplayName(ItemStack itemstack) {
		return StringUtil.localize(getUnlocalizedName(itemstack));
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void updateIcons(IconRegister registerer) {
		this.iconIndex = registerer.registerIcon("BCTFCcrossover:" + iconName);
	}
	
	@Override
	public EnumSize getSize() {
		return itemSize;
	}
	public void setSize(EnumSize size) {
		itemSize = size;
	}

	@Override
	public EnumWeight getWeight() {
		return itemWeight;
	}
	public void setWeight(EnumWeight weight) {
		itemWeight = weight;
	}
}
