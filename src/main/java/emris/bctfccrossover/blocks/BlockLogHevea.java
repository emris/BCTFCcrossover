package emris.bctfccrossover.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.bioxx.tfc.Core.Recipes;
import com.bioxx.tfc.api.TFCItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import emris.bctfccrossover.BCTFCBlocks;
import emris.bctfccrossover.BCTFCItems;
import emris.bctfccrossover.Reference;
import emris.bctfccrossover.core.TreeRegistry;
import emris.bctfccrossover.core.TreeSchematic;
import emris.bctfccrossover.tileEntities.TETreeLog;

public class BlockLogHevea extends BlockContainer
{
	private IIcon iconTop;
	private IIcon iconV;
	private IIcon iconH;
	private static int damage = 0;
	private boolean isStoneTool = false;
	private Item[] StoneTools = new Item[]{TFCItems.IgInShovel, TFCItems.IgInAxe, TFCItems.IgInHoe, TFCItems.SedShovel, TFCItems.SedAxe,
		TFCItems.SedHoe, TFCItems.IgExShovel, TFCItems.IgExAxe, TFCItems.IgExHoe, TFCItems.MMShovel, TFCItems.MMAxe, TFCItems.MMHoe};

	public BlockLogHevea()
	{
		super(Material.wood);
		this.setTickRandomly(true);
	}

	@Override
	public int tickRate(World p_149738_1_)
	{
		return 20;
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random rand)
	{
		if(!world.isRemote)
		{
			//If the base TE somehow gets destroyed and the ProcessTree was not called
			TileEntity te = world.getTileEntity(x, y, z);
			if(te != null && te instanceof TETreeLog)
			{
				TETreeLog teLog = (TETreeLog) te;
				TileEntity teR = world.getTileEntity(teLog.baseX, teLog.baseY, teLog.baseZ);
				if(!teLog.isBase && teR == null)
					world.setBlock(x, y, z, Blocks.air, 0, 0x2);

				if(teLog.isBase)
				{
					if(!canTreeStay(world, x, y - 1, z))
						ProcessTree(world, null, x, y, z, false);
				}
			}
		}
	}

	@Override
	public void registerBlockIcons(IIconRegister reg)
	{
		iconTop = reg.registerIcon(Reference.ModID + ":HeveaLogTop");
		iconV = reg.registerIcon(Reference.ModID + ":HeveaLogV");
		iconH = reg.registerIcon(Reference.ModID + ":HeveaLogH");
	}

	public IIcon getIcon(int i)
	{
		if(i == 0)
			return iconV;
		else if(i == 1)
			return iconTop;
		else
			return iconH;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
	{
		if (side == 0 || side == 1)
			return iconTop;
		return iconV;
	}

	@Override
	public TileEntity createNewTileEntity(World w, int i)
	{
		return new TETreeLog();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item item, CreativeTabs tabs, List list)
	{
		list.add(new ItemStack(this, 1));
	}

	@Override
	public void harvestBlock(World world, EntityPlayer entityplayer, int x, int y, int z, int meta)
	{
	}

	@Override
	public void onBlockHarvested(World world, int x, int y, int z, int side, EntityPlayer entityplayer)
	{
	}

	@Override
	public boolean canBlockStay(World world, int x, int y, int z)
	{
		return true;
	}

	@Override
	public boolean canBeReplacedByLeaves(IBlockAccess world, int x, int y, int z)
	{
		return false;
	}

	@Override
	public int damageDropped(int dmg)
	{
		return dmg;
	}

	@Override
	public void onBlockExploded(World world, int x, int y, int z, Explosion explosion)
	{
		TileEntity te = world.getTileEntity(x, y, z);
		if(te != null && te instanceof TETreeLog)
		{
			TETreeLog teLog = (TETreeLog) te;
			TileEntity teR = world.getTileEntity(teLog.baseX, teLog.baseY, teLog.baseZ);
			if(teR != null && teR instanceof TETreeLog)
			{
				TETreeLog teRoot = (TETreeLog) teR;
				if(!teRoot.getDoingExplosion())
				{
					teRoot.setDoingExplosion(true);
					isStoneTool = true;
					ProcessTree(world, null, teLog.baseX, teLog.baseY, teLog.baseZ, true);
				}
			}
		}
	}

	@Override
	public boolean removedByPlayer(World world, EntityPlayer player, int x, int y, int z, boolean willHarvest)
	{
		if(!world.isRemote)
		{
			ItemStack equip = player.getCurrentEquippedItem();
			if(equip != null)
			{
				isStoneTool = false;
				for(int cnt = 0; cnt < this.StoneTools.length && !isStoneTool; cnt++)
				{
					if(equip.getItem() == this.StoneTools[cnt])
						isStoneTool = true;
				}
			}

			boolean ret = ProcessTree(world, player, x, y, z, !player.capabilities.isCreativeMode);

			if(ret)
				dmgTool(world, player);
			/*else if(equip != null && isValidTool(equip.getItem()))
				player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("msg.noTreeChop")));*/

			return ret;
		}
		return false;
	}

	@Override
	public Item getItemDropped(int i, Random random, int j)
	{
		return BCTFCItems.Hevea;
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block b)
	{
		//If the ground
		if (!world.isRemote)
		{
			TileEntity te = world.getTileEntity(x, y, z);
			if(te != null && te instanceof TETreeLog)
			{
				TETreeLog teLog = (TETreeLog) te;
				if(y == teLog.baseY - 1)
				{
					if(!canTreeStay(world, teLog.baseX, teLog.baseY - 1, teLog.baseZ))
						ProcessTree(world, null, x, y, z, false);
				}
			}
		}
	}

	public boolean isValidTool(Item tool)
	{
		boolean isValid = false;
		if(tool != null)
		{
			for(int cnt = 0; cnt < Recipes.Axes.length && !isValid; cnt++)
			{
				if(tool == Recipes.Axes[cnt]) isValid = true;
			}
			if(!isValid)
			{
				for(int cnt = 0; cnt < Recipes.Saws.length && !isValid; cnt++)
				{
					if(tool == Recipes.Saws[cnt]) isValid = true;
				}
			}
			if(!isValid)
			{
				for(int cnt = 0; cnt < Recipes.Hammers.length && !isValid; cnt++)
				{
					if(tool == Recipes.Hammers[cnt]) isValid = true;
				}
			}
			if(!isValid)
			{
				for(int cnt = 0; cnt < Recipes.Knives.length && !isValid; cnt++)
				{
					if(tool == Recipes.Knives[cnt]) isValid = true;
				}
			}
			if(!isValid)
			{
				for(int cnt = 0; cnt < Recipes.Chisels.length && !isValid; cnt++)
				{
					if(tool == Recipes.Chisels[cnt]) isValid = true;
				}
			}
			if(!isValid)
			{
				for(int cnt = 0; cnt < Recipes.Scythes.length && !isValid; cnt++)
				{
					if(tool == Recipes.Scythes[cnt]) isValid = true;
				}
			}
/*			if(!isValid)
			{
				for(int cnt = 0; cnt < TFCItems.Swards.length && !isValid; cnt++)
				{
					if(tool == TFCItems.Swards[cnt]) isValid = true;
				}
			}
			if(!isValid)
			{
				for(int cnt = 0; cnt < TFCItems.Maces.length && !isValid; cnt++)
				{
					if(tool == TFCItems.Maces[cnt]) isValid = true;
				}
			}
			if(!isValid)
			{
				for(int cnt = 0; cnt < TFCItems.Javelins.length && !isValid; cnt++)
				{
					if(tool == TFCItems.Javelins[cnt]) isValid = true;
				}
			}
			if(!isValid)
			{
				for(int cnt = 0; cnt < TFCItems.ProPicks.length && !isValid; cnt++)
				{
					if(tool == TFCItems.ProPicks[cnt]) isValid = true;
				}
			}
			if(!isValid)
			{
				for(int cnt = 0; cnt < TFCItems.Picks.length && !isValid; cnt++)
				{
					if(tool == TFCItems.Picks[cnt]) isValid = true;
				}
			}
			if(!isValid)
			{
				for(int cnt = 0; cnt < TFCItems.Shovels.length && !isValid; cnt++)
				{
					if(tool == TFCItems.Shovels[cnt]) isValid = true;
				}
			}
			if(!isValid)
			{
				for(int cnt = 0; cnt < TFCItems.Hoes.length && !isValid; cnt++)
				{
					if(tool == TFCItems.Hoes[cnt]) isValid = true;
				}
			}*/
		}
		return isValid;
	}

	//*****************
	// Private methods
	//*****************
	private boolean ProcessTree(World world, EntityPlayer player, int x, int y, int z, boolean dropItem)
	{
		if(!world.isRemote)
		{
			TileEntity te = world.getTileEntity(x, y, z);
			if(te != null && te instanceof TETreeLog)
			{
				TETreeLog teLog = (TETreeLog) te;

				//Allow chopping a tree only 1 blocks above the base block.
				//Being able to cut down a tree by chopping a branch block is strange.
				//if(!teLog.isBase && (y - teLog.baseY) > 1 && !player.capabilities.isCreativeMode) return false;

				//Allow only root block to be chopped
				if(!teLog.isBase && y != teLog.baseY && !player.capabilities.isCreativeMode) return false;

				if(!teLog.isBase)
					return ProcessTree(world, player, teLog.baseX, teLog.baseY, teLog.baseZ, dropItem);

				TreeSchematic schem = TreeRegistry.instance.getTreeSchematic(teLog.treeID, teLog.schemIndex, teLog.growthStage);
				if(schem == null)
				{
					//And this would be a BUG!
					System.out.println("Tree schematic is NULL, this is a BUG!!! -> ID:" + teLog.treeID + "  Index:" + teLog.schemIndex + "  Stage:" + teLog.growthStage);
					return false;
				}

				if(player != null && !player.capabilities.isCreativeMode)
				{
					//Check if a valid tool is being used and is not too damaged to chop this tree down
					ItemStack equip = player.getCurrentEquippedItem();

					if(equip == null)
					{
						//Breaking logs with bare hands is not allowed
						return false;
					}
					else
					{
						if(!isValidTool(equip.getItem())) return false;
						if(isValidTool(equip.getItem()) && (equip.getMaxDamage() - equip.getItemDamage()) < schem.getLogCount()) return false;
					}
				}

				int index;
				int id;
				damage = 0;
				for(int schemY = 0; schemY < schem.getHeight(); schemY++)
				{
					for(int schemZ = 0; schemZ < schem.getLength(); schemZ++)
					{
						for(int schemX = 0; schemX < schem.getWidth(); schemX++)
						{
							index = schemX + schem.getWidth() * (schemZ + schem.getLength() * schemY);
							id = schem.getBlockArray()[index];
							if(id != 0)
								ProcessRot(world, x, y, z, teLog.treeID, schem, schemX+1, schemY, schemZ+1, teLog.rotation, dropItem);
						}
					}
				}
				world.setBlock(x, y, z, Blocks.air);
				return true;
			}
		}
		return false;
	}

	private void ProcessRot(World world, int treeX, int treeY, int treeZ, int meta,
			TreeSchematic schem, int schemX, int schemY, int schemZ, int rot, boolean dropItem)
	{
		int localX = treeX + schem.getCenterWidth() - schemX;
		int localZ = treeZ + schem.getCenterLength() - schemZ;
		int localY = treeY + schemY;

		if(rot == 0)
		{
			localX = treeX - schem.getCenterWidth() + schemX;
			localZ = treeZ - schem.getCenterLength() + schemZ;
		}
		else if(rot == 1)
		{
			localX = treeX - schem.getCenterWidth() + schemX;
			localZ = treeZ + schem.getCenterLength() - schemZ;
		}
		else if(rot == 2)
		{
			localX = treeX + schem.getCenterWidth() - schemX;
			localZ = treeZ - schem.getCenterLength() + schemZ;
		}

		//Get the block that occupies the local coordinate
		Block localBlockID = world.getBlock(localX, localY, localZ);

		if(localBlockID == BCTFCBlocks.blockHevea)
		{
			TETreeLog log = (TETreeLog) world.getTileEntity(localX, localY, localZ);
			if(log != null && ((log.baseX == treeX && log.baseY == treeY && log.baseZ == treeZ)))
			{
				damage++;
				world.setBlock(localX, localY, localZ, Blocks.air, 0, 0x2);
				if(dropItem)
				{
					if(isStoneTool)
					{
						if(world.rand.nextInt(10) != 0)
							dropBlockAsItem(world, localX, localY, localZ, new ItemStack(BCTFCItems.Hevea));
					}
					else
						dropBlockAsItem(world, localX, localY, localZ, new ItemStack(BCTFCItems.Hevea));
				}
			}
		}
		else if(localBlockID == BCTFCBlocks.blockHeveaLeaves)
		{
			world.setBlock(localX, localY, localZ, Blocks.air, 0, 0x2);
		}
	}

	private void dmgTool(World world, EntityPlayer entityplayer)
	{
		//Tools that will get damaged when used to chop a tree down.
		if(!world.isRemote)
		{
			ItemStack equip = entityplayer.getCurrentEquippedItem();
			if(equip!=null && isValidTool(equip.getItem()))
			{
				if(damage + equip.getItemDamage() > equip.getMaxDamage())
				{
					ItemStack stack = entityplayer.inventory.getCurrentItem();
					entityplayer.renderBrokenItemStack(stack);
					entityplayer.worldObj.playSoundAtEntity(entityplayer, "random.break", 0.8F, 0.8F + entityplayer.worldObj.rand.nextFloat() * 0.4F);
					entityplayer.destroyCurrentEquippedItem();
				}
				else
					equip.damageItem(damage, entityplayer);
			}

			//If this method gets called more then ones by mistake,
			//make sure the second call will not make any damage.
			damage = 0;
		}
	}

	private boolean canTreeStay(World w, int x, int y, int z)
	{
		int k = 0;
		for(int i = -1; i < 2; i++)
		{
			for(int j = -1; j < 2; j++)
			{
				if(w.isAirBlock(x - i, y, z - j)) k++;
			}
		}
		if(k < 4) return true;
		return false;
	}
}
