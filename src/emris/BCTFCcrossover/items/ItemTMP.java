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

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import TFC.Items.ItemTerra;
import buildcraft.core.CreativeTabBuildCraft;
import buildcraft.core.utils.StringUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import emris.BCTFCcrossover.Reference;

public class ItemTMP extends ItemTerra
{
	public String iconName;

	public ItemTMP(int id)
	{
		super(id);
		setCreativeTab(CreativeTabBuildCraft.MACHINES.get());
	}
	
	@Override
	public Item setUnlocalizedName(String s)
	{
		iconName = s;
		return super.setUnlocalizedName(s);
	}
	
	@Override
	public String getItemDisplayName(ItemStack is)
	{
		return StringUtils.localize(getUnlocalizedName(is));
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister registerer)
	{
		this.itemIcon = registerer.registerIcon(Reference.ModID + ":" + iconName);
	}
}
