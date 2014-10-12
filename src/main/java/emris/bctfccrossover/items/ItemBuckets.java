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

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import buildcraft.BuildCraftEnergy;
import buildcraft.core.CreativeTabBuildCraft;

import com.bioxx.tfc.TFCBlocks;
import com.bioxx.tfc.TFCItems;
import com.bioxx.tfc.Items.ItemTerra;
import com.bioxx.tfc.api.Enums.EnumSize;
import com.bioxx.tfc.api.Enums.EnumWeight;
import com.bioxx.tfc.api.Interfaces.ISize;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import emris.bctfccrossover.BCTFCItems;
import emris.bctfccrossover.Reference;
import emris.bctfccrossover.utils.McColor;
import emris.bctfccrossover.utils.PlayerUtils;

public class ItemBuckets extends ItemTerra implements ISize
{
	private IIcon[] icons;

	public ItemBuckets()
	{
		this(CreativeTabBuildCraft.ITEMS);
	}

	public ItemBuckets(CreativeTabBuildCraft creativeTab)
	{
		super();
		setMaxDamage(0);
		setHasSubtypes(true);
		setCreativeTab(creativeTab.get());
		setUnlocalizedName("Bucket");
		setContainerItem(TFCItems.WoodenBucketEmpty);
		MetaNames = new String[]{"Latex","Zinc","ZincWater","Steel","SteelOil","SteelFuel"};
	}

	/*@Override
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
	}*/

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
			list.add(new ItemStack(this,1,i));
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void addSizeInformation(ItemStack is, ISize object, List arraylist)
	{
		if(object.getSize(is) != null && object.getWeight(is) != null)
			arraylist.add("\u2696" + object.getWeight(is).getName() + " \u21F2" + object.getSize(is).getName());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag)
	{
		ItemBuckets.addSizeInformation(is, this, list);
		if(is.hasTagCompound() && is.stackTagCompound.hasKey("LiquidType"))
		{
			if(is.stackTagCompound.getString("LiquidType").equalsIgnoreCase("freshWater"))
				list.add(McColor.darkAqua + StatCollector.translateToLocal("gui.bucketFreshWater"));
			else if(is.stackTagCompound.getString("LiquidType").equalsIgnoreCase("saltWater"))
				list.add(McColor.darkAqua + StatCollector.translateToLocal("gui.bucketSaltWater"));
			else
				list.add(McColor.darkAqua + StatCollector.translateToLocal("gui.bucketHotWater"));
		}
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

			if (mop.typeOfHit == MovingObjectType.BLOCK)
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
					else if(world.getBlock(X, Y, Z) == BuildCraftEnergy.blockOil && is.getItemDamage() == 3)
					{
						if (!player.capabilities.isCreativeMode)
							world.setBlockToAir(X, Y, Z);
						return new ItemStack(BCTFCItems.Buckets, 1, 4);
					}
					//Pickup Water
					if(isWater(world.getBlock(X, Y, Z)) && is.getItemDamage() == 1 && world.getBlockMetadata(X, Y, Z) <= 2)
					{
						ItemStack waterBucket = new ItemStack(BCTFCItems.Buckets, 1, 2);
						NBTTagCompound nbttc = new NBTTagCompound();
						nbttc.setString("LiquidType", getWaterType(world.getBlock(X, Y, Z)));
						waterBucket.setTagCompound(nbttc);
						if (!player.capabilities.isCreativeMode)
							world.setBlockToAir(X, Y, Z);
						return waterBucket;
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

					if (world.isAirBlock(X, Y, Z) || !world.getBlock(X, Y, Z).getMaterial().isSolid())
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
							if(is.hasTagCompound() && is.stackTagCompound.hasKey("LiquidType"))
								world.setBlock(X, Y, Z, getWaterType(is.stackTagCompound.getString("LiquidType")));
							else
								world.setBlock(X, Y, Z, getWaterType("freshWater"));

							if (player.capabilities.isCreativeMode)
								return is;
							return new ItemStack(BCTFCItems.Buckets, 1, 1);
						}
						//Put Oil
						else if (is.getItemDamage() == 4)
						{
							world.setBlock(X, Y, Z, BuildCraftEnergy.blockOil);
							if (player.capabilities.isCreativeMode)
								return is;
							return new ItemStack(BCTFCItems.Buckets, 1, 3);
						}
					}
				}
			}
		}
		return is;
	}

	private String getWaterType(Block block)
	{
		if(block == TFCBlocks.SaltWater || block == TFCBlocks.SaltWaterStationary) return "saltWater";
		if(block == TFCBlocks.HotWater || block == TFCBlocks.HotWaterStationary) return "hotWater";
		return "freshWater";
	}

	private Block getWaterType(String s)
	{
		if(s.equalsIgnoreCase("saltWater")) return TFCBlocks.SaltWaterStationary;
		if(s.equalsIgnoreCase("hotWater")) return TFCBlocks.HotWaterStationary;
		return TFCBlocks.FreshWaterStationary;
	}

	private static boolean isWater(Block block)
	{
		return block == TFCBlocks.SaltWater
				|| block == TFCBlocks.SaltWaterStationary
				|| block == TFCBlocks.FreshWater
				|| block == TFCBlocks.FreshWaterStationary
				|| block == TFCBlocks.HotWater
				|| block == TFCBlocks.HotWaterStationary;
	}
}
