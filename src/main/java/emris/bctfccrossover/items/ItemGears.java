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

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import buildcraft.core.CreativeTabBuildCraft;

import com.bioxx.tfc.Items.ItemTerra;
import com.bioxx.tfc.api.Enums.EnumSize;
import com.bioxx.tfc.api.Enums.EnumWeight;
import com.bioxx.tfc.api.Interfaces.ISize;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import emris.bctfccrossover.Reference;

public class ItemGears extends ItemTerra implements ISize
{
	private IIcon[] icons;

	public ItemGears()
	{
		this(CreativeTabBuildCraft.ITEMS);
	}

	public ItemGears(CreativeTabBuildCraft creativeTab)
	{
		super();
		setMaxDamage(0);
		setHasSubtypes(true);
		setCreativeTab(creativeTab.get());
		setUnlocalizedName("Gear");
		MetaNames = new String[]{"BismuthBronze", "BlackBronze", "Bronze", "Copper", "WroughtIron", "Steel", "BlackSteel", "BlueSteel", "RedSteel"};
	}

	@Override
	public EnumSize getSize(ItemStack is)
	{
		return EnumSize.MEDIUM;
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
	public IIcon getIconFromDamage(int meta)
	{
		return icons[meta];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister registerer)
	{
		icons = new IIcon[MetaNames.length];
		for(int i = 0; i < MetaNames.length; i++)
			icons[i] = registerer.registerIcon(Reference.ModID + ":" + this.getUnlocalizedName().replace("item.", "") + MetaNames[i]);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs tabs, List list)
	{
		for(int i = 0; i < MetaNames.length; i++)
			list.add(new ItemStack(this, 1, i));
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void addSizeInformation(ItemStack is, ISize object, List arraylist)
	{
		if(object.getSize(is)!= null && object.getWeight(is) != null)
			arraylist.add("\u2696" + object.getWeight(is).getName() + " \u21F2" + object.getSize(is).getName());
	}

	@SuppressWarnings("rawtypes")
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag)
	{
		ItemGears.addSizeInformation(is, this, list);
	}
}
