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

public class ItemRubber extends ItemTerra implements ISize
{
	public int metaSize = 16;
	private Icon[] icons = new Icon[metaSize];
	
	public ItemRubber(int id)
	{
		super(id);
		setMaxDamage(0);
		setHasSubtypes(true);
		setCreativeTab(CreativeTabBuildCraft.MACHINES.get());
		setUnlocalizedName("Rubber");
		MetaNames = new String[]{"Black","Red","Green","Brown","Blue","Purple","Cyan","LightGray","Gray","Pink","LimeGreen","Yellow","LightBlue","Magenta","Orange","White"};
	}
	
	@Override
	public EnumSize getSize(ItemStack is)
	{
		return EnumSize.SMALL;
	}
	
	@Override
	public EnumWeight getWeight(ItemStack is)
	{
		return EnumWeight.LIGHT;
	}

	@Override
	public boolean canStack()
	{
		return true;
	}

	@Override
	public Icon getIconFromDamage(int meta)
	{
		return icons[meta];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister registerer)
	{
		for(int i = 0; i < metaSize; i++)
			icons[i] = registerer.registerIcon(Reference.ModID + ":" + this.getUnlocalizedName().replace("item.", "") + MetaNames[i]);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(int par1, CreativeTabs tabs, List list)
	{
		for(int i = 0; i < metaSize; i++)
			list.add(new ItemStack(this, 1, i));
	}
	
	@Override
	public String getItemDisplayName(ItemStack is)
	{
		return StringUtils.localize(getUnlocalizedName(is));
	}
	
	public static void addSizeInformation(ItemStack is, ISize object, List arraylist)
	{
		if(object.getSize(is)!= null && object.getWeight(is) != null)
			arraylist.add("\u2696" + object.getWeight(is).getName() + " \u21F2" + object.getSize(is).getName());
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag)
	{
		this.addSizeInformation(is, this, list);
	}
	
	public final int getMetaSize()
	{
		return metaSize;
	}
}
