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
package emris.bctfccrossover.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import buildcraft.core.BCCreativeTab;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import emris.bctfccrossover.Reference;

public class ItemGeneric extends Item
{
	private String iconName;

	public ItemGeneric()
	{
		this("items");
	}

	public ItemGeneric(String tabName)
	{
		super();
		setCreativeTab(BCCreativeTab.get(tabName));
	}

	@Override
	public Item setUnlocalizedName(String s)
	{
		iconName = s;
		return super.setUnlocalizedName(s);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register)
	{
		this.itemIcon = register.registerIcon(Reference.ModID + ":" + iconName);
	}
}
