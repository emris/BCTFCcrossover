package emris.bctfccrossover.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.bioxx.tfc.Core.Recipes;
import com.bioxx.tfc.api.TFCItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import emris.bctfccrossover.BCTFCBlocks;
import emris.bctfccrossover.BCTFCItems;

public class BlockLogHeveaV extends Block
{

	public BlockLogHeveaV()
	{
		super(Material.wood);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
	{
		return BCTFCBlocks.blockHevea.getIcon(side, meta);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item item, CreativeTabs tabs, List list)
	{
		list.add(new ItemStack(this, 1));
	}

	@Override
	public void registerBlockIcons(IIconRegister reg)
	{
		//Icons are registered in BlockLogHevea
	}

	@Override
	public int damageDropped(int dmg)
	{
		return dmg;
	}

	@Override
	public Item getItemDropped(int i, Random R, int j)
	{
		return BCTFCItems.Hevea;
	}

	@Override
	public void harvestBlock(World world, EntityPlayer entityplayer, int x, int y, int z, int meta)
	{
		boolean isValidTool = false;
		boolean isHammer = false;
		ItemStack equip = entityplayer.getCurrentEquippedItem();
		if(equip!=null)
		{
			isValidTool = ((BlockLogHevea) BCTFCBlocks.blockHevea).isValidTool(equip.getItem());

			if(isValidTool)
			{
				for(int cnt = 0; cnt < Recipes.hammers.length; cnt++)
				{
					if(equip.getItem() == Recipes.hammers[cnt])
						isHammer = true;
				}
			}
		}

		if(isHammer)
			world.spawnEntityInWorld(new EntityItem(world, x + 0.5, y + 0.5, z + 0.5, new ItemStack(TFCItems.stick, 1 + world.rand.nextInt(3))));
		else if(isValidTool)
			super.harvestBlock(world, entityplayer, x, y, z, meta);
		else
			world.setBlock(x, y, z, this, meta, 0x2);
	}
}
