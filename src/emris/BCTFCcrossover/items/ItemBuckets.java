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

public class ItemBuckets extends ItemTerra implements ISize {

	private int metaSize = 6;
	private Icon[] icons = new Icon[metaSize];
	
	public ItemBuckets(int id) {
		super(id);
		setMaxDamage(0);
		setHasSubtypes(true);
		setCreativeTab(CreativeTabBuildCraft.tabBuildCraft);
		setUnlocalizedName("Bucket");
		setContainerItem(TFCItems.WoodenBucketEmpty);
		MetaNames = new String[]{"Latex","Zinc","ZincWater","Steel","SteelOil","SteelFuel"};
	}

	@Override
	public ItemStack getContainerItemStack(ItemStack itemStack) {
		if(itemStack.getItemDamage() == 0) {
			return new ItemStack(TFCItems.WoodenBucketEmpty);
		}
		else if(itemStack.getItemDamage() == 2) {
			return new ItemStack(Items.Buckets, 1, 1);
		}
		else if(itemStack.getItemDamage() == 4) {
			return new ItemStack(Items.Buckets, 1, 3);
		}
		else if(itemStack.getItemDamage() == 5) {
			return new ItemStack(Items.Buckets, 1, 3);
		}
		return super.getContainerItemStack(itemStack);
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

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World world, EntityPlayer par3EntityPlayer) {
		MovingObjectPosition mop = PlayerUtils.getTargetBlock(par3EntityPlayer);
		if (mop != null) {
			int X = mop.blockX;
			int Y = mop.blockY;
			int Z = mop.blockZ;
			if (!world.canMineBlock(par3EntityPlayer, X, Y, Z)) { return par1ItemStack; }

			if (mop.typeOfHit == EnumMovingObjectType.TILE) {
				if (par1ItemStack.getItemDamage() == 1 || par1ItemStack.getItemDamage() == 3) {
					if (!par3EntityPlayer.canPlayerEdit(X, Y, Z, mop.sideHit, par1ItemStack)) {
						return par1ItemStack;
					}
					FillBucketEvent event = new FillBucketEvent(par3EntityPlayer, par1ItemStack, world, mop);
					if (event.isCanceled()) {
						return par1ItemStack;
					}
					if (event.getResult() == Event.Result.ALLOW) {
						return event.result;
					}
					//Pickup Oil
					else if(world.getBlockId(X, Y, Z) == BuildCraftEnergy.blockOil.blockID && par1ItemStack.getItemDamage() == 3) {
						world.setBlock(X, Y, Z, 0);
						if (par3EntityPlayer.capabilities.isCreativeMode) {
							return par1ItemStack;
						}
						return new ItemStack(Items.Buckets, 1, 4);
					}
					//Pickup Water
					if((world.getBlockId(X, Y, Z) == Block.waterStill.blockID)
						&& par1ItemStack.getItemDamage() == 1
						&& world.getBlockMetadata(X, Y, Z) <=2)
					{
						world.setBlock(X, Y, Z, 0);
						if (par3EntityPlayer.capabilities.isCreativeMode) {
							return par1ItemStack;
						}
						return new ItemStack(Items.Buckets, 1, 2);
					}
				}

				if (par1ItemStack.getItemDamage() == 2 || par1ItemStack.getItemDamage() == 4) {
					if (mop.sideHit == 0) {--Y;}
					else if (mop.sideHit == 1) {++Y;}
					else if (mop.sideHit == 2) {--Z;}
					else if (mop.sideHit == 3) {++Z;}
					else if (mop.sideHit == 4) {--X;}
					else if (mop.sideHit == 5) {++X;}
					if (!par3EntityPlayer.canPlayerEdit(X, Y, Z, mop.sideHit, par1ItemStack)) {
						return par1ItemStack;
					}
					if (world.isAirBlock(X, Y, Z) || !world.getBlockMaterial(X, Y, Z).isSolid()) {
						if (world.provider.isHellWorld && par1ItemStack.getItemDamage() == 2) {
							world.playSoundEffect(X + 0.5D, Y + 0.5D, Z + 0.5D, "random.fizz", 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);
							for (int i = 0; i < 8; ++i) {
								world.spawnParticle("largesmoke", X + Math.random(), Y + Math.random(), Z + Math.random(), 0.0D, 0.0D, 0.0D);
							}
						}
						//Put Water
						else if(par1ItemStack.getItemDamage() == 2) {
							world.setBlock(X, Y, Z, Block.waterStill.blockID);
							if (par3EntityPlayer.capabilities.isCreativeMode) {
								return par1ItemStack;
							}
							return new ItemStack(Items.Buckets, 1, 1);
						}
						//Put Oil
						else if (par1ItemStack.getItemDamage() == 4) {
							world.setBlock(X, Y, Z, BuildCraftEnergy.blockOil.blockID);
							if (par3EntityPlayer.capabilities.isCreativeMode) {
								return par1ItemStack;
							}
							return new ItemStack(Items.Buckets, 1, 3);
						}
					}
				}
			}
		}
		return par1ItemStack;
	}
}
