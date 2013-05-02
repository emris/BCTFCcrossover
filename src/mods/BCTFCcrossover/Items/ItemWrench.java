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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import TFC.Enums.EnumSize;
import TFC.Enums.EnumWeight;
import TFC.Items.ItemTerra;
import buildcraft.api.tools.IToolWrench;

public class ItemWrench extends ItemTerra implements IToolWrench {
	public Icon icons;
	public ItemWrench(int id) {
		super(id);

	}
	
	@Override
	public void updateIcons(IconRegister registerer) {
		icons = registerer.registerIcon("BCTFCcrossover:" + getUnlocalizedName().replace("item.", "") + "Gear");
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		// TODO Auto-generated method stub
		return super.getUnlocalizedName(itemstack);
	}

	@Override
	public boolean canStack() {
		// TODO Auto-generated method stub
		return super.canStack();
	}

	@Override
	public EnumSize getSize() {
		return EnumSize.MEDIUM;
	}

	@Override
	public EnumWeight getWeight() 
	{
		return EnumWeight.MEDIUM;
	}

	@Override
	public boolean canWrench(EntityPlayer player, int x, int y, int z) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void wrenchUsed(EntityPlayer player, int x, int y, int z) {
		// TODO Auto-generated method stub
		
	}



}
