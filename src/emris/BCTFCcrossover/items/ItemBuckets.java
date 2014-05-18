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

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import TFC.TFCItems;
import TFC.API.ISize;
import TFC.API.Enums.EnumSize;
import TFC.API.Enums.EnumWeight;
import TFC.Items.ItemTerra;
import buildcraft.BuildCraftEnergy;
import buildcraft.core.CreativeTabBuildCraft;
import buildcraft.core.utils.StringUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import emris.BCTFCcrossover.Items;
import emris.BCTFCcrossover.Reference;
import emris.BCTFCcrossover.utils.PlayerUtils;

public class ItemBuckets extends ItemTerra implements ISize
{
	private int metaSize = 6;
	private Icon[] icons = new Icon[metaSize];
	
	public ItemBuckets(int id)
	{
		super(id);
		setMaxDamage(0);
		setHasSubtypes(true);
		setCreativeTab(CreativeTabBuildCraft.MACHINES.get());
		setUnlocalizedName("Bucket");
		setContainerItem(TFCItems.WoodenBucketEmpty);
		MetaNames = new String[]{"Latex","Zinc","ZincWater","Steel","SteelOil","SteelFuel"};
	}

	@Override
	public ItemStack getContainerItemStack(ItemStack is)
	{
		if(is.getItemDamage() == 0)
			return new ItemStack(TFCItems.WoodenBucketEmpty);
		else if(is.getItemDamage() == 2)
			return new ItemStack(Items.Buckets, 1, 1);
		else if(is.getItemDamage() == 4)
			return new ItemStack(Items.Buckets, 1, 3);
		else if(is.getItemDamage() == 5)
			return new ItemStack(Items.Buckets, 1, 3);

		return super.getContainerItemStack(is);
	}

	@Override
	public EnumSize getSize(ItemStack is)
	{
		return EnumSize.MEDIUM;
	}
	
	@Override
	public EnumWeight getWeight(ItemStack is)
	{
		return EnumWeight.MEDIUM;
	}

	@Override
	public boolean canStack()
	{
		return false;
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
			list.add(new ItemStack(this,1,i));
	}
	
	@Override
	public String getItemDisplayName(ItemStack is)
	{
		return StringUtils.localize(getUnlocalizedName(is));
	}
	
	public static void addSizeInformation(ItemStack is, ISize object, List arraylist)
	{
		if(object.getSize(is) != null && object.getWeight(is) != null)
			arraylist.add("\u2696" + object.getWeight(is).getName() + " \u21F2" + object.getSize(is).getName());
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag)
	{
		this.addSizeInformation(is, this, list);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player)
	{
		MovingObjectPosition mop = PlayerUtils.getTargetBlock(player);
		if (mop != null)
		{
			int X = mop.blockX;
			int Y = mop.blockY;
			int Z = mop.blockZ;
			if (!world.canMineBlock(player, X, Y, Z)) { return is; }

			if (mop.typeOfHit == EnumMovingObjectType.TILE)
			{
				if (is.getItemDamage() == 1 || is.getItemDamage() == 3)
				{
					if (!player.canPlayerEdit(X, Y, Z, mop.sideHit, is))
						return is;

					FillBucketEvent event = new FillBucketEvent(player, is, world, mop);
					if (event.isCanceled())
						return is;

					if (event.getResult() == Event.Result.ALLOW)
						return event.result;

					//Pickup Oil
					else if(world.getBlockId(X, Y, Z) == BuildCraftEnergy.blockOil.blockID && is.getItemDamage() == 3)
					{
						world.setBlock(X, Y, Z, 0);
						if (player.capabilities.isCreativeMode)
							return is;
						return new ItemStack(Items.Buckets, 1, 4);
					}
					//Pickup Water
					if((world.getBlockId(X, Y, Z) == Block.waterStill.blockID)
						&& is.getItemDamage() == 1
						&& world.getBlockMetadata(X, Y, Z) <= 2)
					{
						world.setBlock(X, Y, Z, 0);
						if (player.capabilities.isCreativeMode)
							return is;
						return new ItemStack(Items.Buckets, 1, 2);
					}
				}

				if (is.getItemDamage() == 2 || is.getItemDamage() == 4)
				{
					if (mop.sideHit == 0) {--Y;}
					else if (mop.sideHit == 1) {++Y;}
					else if (mop.sideHit == 2) {--Z;}
					else if (mop.sideHit == 3) {++Z;}
					else if (mop.sideHit == 4) {--X;}
					else if (mop.sideHit == 5) {++X;}

					if (!player.canPlayerEdit(X, Y, Z, mop.sideHit, is))
						return is;

					if (world.isAirBlock(X, Y, Z) || !world.getBlockMaterial(X, Y, Z).isSolid())
					{
						if (world.provider.isHellWorld && is.getItemDamage() == 2)
						{
							world.playSoundEffect(X + 0.5D, Y + 0.5D, Z + 0.5D, "random.fizz", 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);
							for (int i = 0; i < 8; ++i)
								world.spawnParticle("largesmoke", X + Math.random(), Y + Math.random(), Z + Math.random(), 0.0D, 0.0D, 0.0D);
						}
						//Put Water
						else if(is.getItemDamage() == 2)
						{
							world.setBlock(X, Y, Z, Block.waterStill.blockID);
							if (player.capabilities.isCreativeMode)
								return is;
							return new ItemStack(Items.Buckets, 1, 1);
						}
						//Put Oil
						else if (is.getItemDamage() == 4)
						{
							world.setBlock(X, Y, Z, BuildCraftEnergy.blockOil.blockID);
							if (player.capabilities.isCreativeMode)
								return is;
							return new ItemStack(Items.Buckets, 1, 3);
						}
					}
				}
			}
		}
		return is;
	}
}
