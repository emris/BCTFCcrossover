package emris.bctfccrossover.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.bioxx.tfc.Core.TFCTabs;
import com.bioxx.tfc.Items.ItemTerra;
import com.bioxx.tfc.TileEntities.TELogPile;
import com.bioxx.tfc.api.TFCBlocks;
import com.bioxx.tfc.api.Enums.EnumSize;
import com.bioxx.tfc.api.Enums.EnumWeight;

import emris.bctfccrossover.BCTFCBlocks;
import emris.bctfccrossover.Reference;

public class ItemHeveaLog extends ItemTerra
{
	private IIcon icon;

	public ItemHeveaLog()
	{
		super();
		this.setUnlocalizedName("Hevea Log");
		this.setMaxDamage(0);
		this.setCreativeTab(TFCTabs.TFC_MATERIALS);
		this.setWeight(EnumWeight.MEDIUM);
		this.setSize(EnumSize.MEDIUM);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void getSubItems(Item item, CreativeTabs tabs, List list)
	{
		list.add(new ItemStack(this));
	}

	@Override
	public void registerIcons(IIconRegister registerer)
	{
		this.icon = registerer.registerIcon(Reference.ModID + ":HeveaLog");
	}

	@Override
	public IIcon getIconFromDamage(int meta)
	{
		return this.icon;
	}

	@Override
	public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		if(!world.isRemote)
		{
			if(entityplayer.isSneaking() && (world.getBlock(x, y, z) != TFCBlocks.logPile || (side != 1 && side != 0)))
			{
				int dir = MathHelper.floor_double(entityplayer.rotationYaw * 4F / 360F + 0.5D) & 3;
				if (side == 0) --y;
				else if (side == 1) ++y;
				else if (side == 2) --z;
				else if (side == 3) ++z;
				else if (side == 4) --x;
				else if (side == 5) ++x;

				if(world.canPlaceEntityOnSide(TFCBlocks.logPile, x, y, z, false, side, entityplayer, itemstack))
				{
					if (CreatePile(itemstack, entityplayer, world, x, y, z, side, dir))
					{
						itemstack.stackSize = itemstack.stackSize - 1;
						this.playSound(world, x, y, z);
					}
				}
				return true;
			}
			else if(world.getBlock(x, y, z) == TFCBlocks.logPile)
			{
				TELogPile te = (TELogPile)world.getTileEntity(x, y, z);
				if(te != null)
				{
					if(te.storage[0] != null && te.contentsMatch(0, itemstack))
						te.injectContents(0, 1);
					else if(te.storage[0] == null)
						te.addContents(0, new ItemStack(this, 1, itemstack.getItemDamage()));
					else if(te.storage[1] != null && te.contentsMatch(1, itemstack))
						te.injectContents(1, 1);
					else if(te.storage[1] == null)
						te.addContents(1, new ItemStack(this, 1, itemstack.getItemDamage()));
					else if(te.storage[2] != null && te.contentsMatch(2, itemstack))
						te.injectContents(2, 1);
					else if(te.storage[2] == null)
						te.addContents(2, new ItemStack(this, 1, itemstack.getItemDamage()));
					else if(te.storage[3] != null && te.contentsMatch(3, itemstack))
						te.injectContents(3, 1);
					else if(te.storage[3] == null)
						te.addContents(3, new ItemStack(this, 1, itemstack.getItemDamage()));
					else
					{
						int dir = MathHelper.floor_double(entityplayer.rotationYaw * 4F / 360F + 0.5D) & 3;
						if (side == 0) --y;
						else if (side == 1) ++y;
						else if (side == 2) --z;
						else if (side == 3) ++z;
						else if (side == 4) --x;
						else if (side == 5) ++x;

						if (!CreatePile(itemstack, entityplayer, world, x, y, z, side, dir))
							return true;
					}
					this.playSound(world, x, y, z);
					itemstack.stackSize = itemstack.stackSize - 1;
					return true;
				}

			}
			else
			{
				Block block = BCTFCBlocks.blockHeveaV;

				if(side == 0 && block.canPlaceBlockAt(world, x, y - 1, z) && world.canPlaceEntityOnSide(BCTFCBlocks.blockHeveaV, x, y - 1, z, false, side, null, itemstack))
				{
					world.setBlock(x, y - 1, z, block, 0, 0x2);
					itemstack.stackSize = itemstack.stackSize-1;
				}
				else if(side == 1 && block.canPlaceBlockAt(world, x, y + 1, z) && world.canPlaceEntityOnSide(BCTFCBlocks.blockHeveaV, x, y + 1, z, false, side, null, itemstack))
				{
					world.setBlock(x, y + 1, z, block, 0, 0x2);
					itemstack.stackSize = itemstack.stackSize-1;
				}
				else if(side == 2 && block.canPlaceBlockAt(world, x, y, z - 1) && world.canPlaceEntityOnSide(BCTFCBlocks.blockHeveaV, x, y, z - 1, false, side, null, itemstack))
				{
					setSide(world, itemstack, 0, side, x, y, z - 1);
				}
				else if(side == 3 && block.canPlaceBlockAt(world, x, y, z + 1) && world.canPlaceEntityOnSide(BCTFCBlocks.blockHeveaV, x, y, z + 1, false, side, null, itemstack))
				{
					setSide(world, itemstack, 0, side, x, y, z + 1);
				}
				else if(side == 4 && block.canPlaceBlockAt(world, x - 1, y, z) && world.canPlaceEntityOnSide(BCTFCBlocks.blockHeveaV, x - 1, y, z, false, side, null, itemstack))
				{
					setSide(world, itemstack, 0, side, x - 1, y, z);
				}
				else if(side == 5 && block.canPlaceBlockAt(world, x + 1, y, z) && world.canPlaceEntityOnSide(BCTFCBlocks.blockHeveaV, x + 1, y, z, false, side, null, itemstack))
				{
					setSide(world, itemstack, 0, side, x + 1, y, z);
				}
				this.playSound(world, x, y, z);
				return true;
			}
		}
		return false;
	}

	public boolean isValid(World world, int i, int j, int k)
	{
		if(world.isSideSolid(i, j - 1, k, ForgeDirection.UP))
		{
			TileEntity te = world.getTileEntity(i, j - 1, k);

			if (te instanceof TELogPile)
			{
				TELogPile lp = (TELogPile)te;

				if(lp != null)
				{
					if(lp.storage[0] == null || lp.storage[0].stackSize < 4) return false;
					if(lp.storage[1] == null || lp.storage[1].stackSize < 4) return false;
					if(lp.storage[2] == null || lp.storage[2].stackSize < 4) return false;
					if(lp.storage[3] == null || lp.storage[3].stackSize < 4) return false;
				}
			}
			return true;
		}
		return false;
	}

	private boolean CreatePile(ItemStack itemstack, EntityPlayer entityplayer, World world, int x, int y, int z, int side, int l)
	{
		TELogPile te = null;
		if(world.isAirBlock(x, y, z) && isValid(world, x, y, z))
		{
			world.setBlock(x, y, z, TFCBlocks.logPile, l, 3);
			te = (TELogPile)world.getTileEntity(x, y, z);
		}
		else
		{
			return false;
		}

		if(te != null)
		{
			te.storage[0] = new ItemStack(this,1,itemstack.getItemDamage());
			if(entityplayer.capabilities.isCreativeMode)
			{
				te.storage[0] = new ItemStack(this, 4, itemstack.getItemDamage());
				te.storage[1] = new ItemStack(this, 4, itemstack.getItemDamage());
				te.storage[2] = new ItemStack(this, 4, itemstack.getItemDamage());
				te.storage[3] = new ItemStack(this, 4, itemstack.getItemDamage());
			}
		}

		return true;
	}

	private void playSound(World world, int x, int y, int z)
	{
		world.playSoundEffect(x + 0.5, y + 0.5, z + 0.5, BCTFCBlocks.blockHevea.stepSound.func_150496_b(), (BCTFCBlocks.blockHevea.stepSound.getVolume() + 1.0F) / 2.0F, BCTFCBlocks.blockHevea.stepSound.getPitch() * 0.8F);
	}

	public void setSide(World world, ItemStack itemstack, int m, int side, int x, int y, int z)
	{
		Block log = BCTFCBlocks.blockHeveaH;

		if (side == 2 || side == 3)
		{
			world.setBlock(x, y, z, log, 0, 0x2);
			itemstack.stackSize = itemstack.stackSize - 1;
		}
		else if (side == 4 || side == 5)
		{
			world.setBlock(x, y, z, log, 0 | 8, 0x2);
			itemstack.stackSize = itemstack.stackSize - 1;
		}
	}
}
