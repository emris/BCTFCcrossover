package emris.bctfccrossover.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Random;
import java.util.Vector;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import emris.bctfccrossover.BCTFCcrossover;

public class TreeManager
{
	private Vector<Vector<TreeSchematic>> treeList;

	public TreeManager()
	{
		this.treeList = new Vector<Vector<TreeSchematic>>();
	}

	public void addSchem(TreeSchematic ts)
	{
		int growth = ts.getGrowthStage();
		if(treeList.size() <= growth)
			treeList.setSize(growth + 1);
		//System.out.println("Adding " + ts.getIndex() + ":" + ts.getPath() + ": Stage " + growth);
		if(treeList.get(growth) == null)
			treeList.set(growth, new Vector<TreeSchematic>());

		treeList.get(growth).add(ts);
	}

	public TreeSchematic getRandomSchematic(Random R)
	{
		Vector<TreeSchematic> v = treeList.get(R.nextInt(treeList.size()));
		if(v != null)
			return v.get(R.nextInt(v.size()));
		return null;
	}

	public TreeSchematic getRandomSchematic(Random R, int growthStage)
	{
		if(growthStage > treeList.size() - 1) return null;
		Vector<TreeSchematic> v = treeList.get(growthStage);
		if(v != null)
			return v.get(R.nextInt(v.size()));
		return null;
	}

	public TreeSchematic getSchematic(int schem, int growthStage)
	{
		if(growthStage > treeList.size() - 1) return null;
		Vector<TreeSchematic> v = treeList.get(growthStage);
		if(v != null)
			return v.get(schem);
		return null;
	}

	public static void setupTrees()
	{
		String path = "assets/bctfccrossover/schematics/trees/";
		TreeRegistry.instance.addWoodType(new TreeData("Hevea", 0, 10F, 15000F, 1F, 45F, 0F, 2F, false));
		loadTreeSchematics(path + "Hevea" + "/");
	}


	//*****************
	// Private methods
	//*****************
	private static void loadTreeSchematics(String path)
	{
		try
		{
			File root = new File(BCTFCcrossover.instance.getClass().getClassLoader().getResource(path).toURI());
			for( File f : root.listFiles())
			{
				int index = f.getName().indexOf('-');
				String schemType = f.getName().substring(0, index);
				if(f.isFile())
				{
					TreeSchematic schem = new TreeSchematic();
					schem.setPath(path + f.getName());
					if(loadSchemFile(schem))
						TreeRegistry.instance.RegisterTree(schem, schemType);
					else
						BCTFCcrossover.tfcbcLog.warning("Loading schematic " + schem.getPath() + " Failed!");
				}
			}
		}
		catch (URISyntaxException e)
		{
			e.printStackTrace();
		}
	}

	private static boolean loadSchemFile(TreeSchematic schem)
	{
		NBTTagCompound tree;
		try
		{
			InputStream fis = BCTFCcrossover.instance.getClass().getClassLoader().getResourceAsStream(schem.getPath());
			tree = CompressedStreamTools.readCompressed(fis);
			schem.setHeight(tree.getShort("Height"));
			schem.setWidth(tree.getShort("Width"));
			schem.setLength(tree.getShort("Length"));
			schem.setCenterWidth(getCenter(schem.getWidth()));
			schem.setCenterLength(getCenter(schem.getLength()));
			if(tree.hasKey("Blocks"))
			{
				byte[] b = tree.getByteArray("Blocks");
				int[] ba = new int[b.length];
				for(int i = 0; i < b.length; i++)
				{
					ba[i] = b[i];
				}
				schem.setBlockArray(ba);
			}
			else if(tree.hasKey("BlocksInt"))
			{
				schem.setBlockArray(tree.getIntArray("Blocks"));
			}
			schem.setDataArray(tree.getByteArray("Data"));
			schem.setTileEntities(tree.getTagList("TileEntities", 10));
			int num = schem.getPath().indexOf('_') + 1;
			schem.setID(Integer.parseInt(schem.getPath().substring(num, num + 2)));
			num = schem.getPath().indexOf('-') + 1;
			schem.setGrowthStage(Integer.parseInt(schem.getPath().substring(num, num + 1)));
			schem.setLogCount(countLogs(schem));
		}
		catch (FileNotFoundException e)
		{
			System.out.println("TFC FileNotFound: " + schem.getPath()); return false;
		}
		catch (IOException e)
		{
			System.out.println("TFC IOException: " + schem.getPath()); return false;
		}
		return true;
	}

	private static int getCenter(int v)
	{
		if(v % 2 == 1)
			return (v + 1) / 2;
		return v / 2;
	}

	private static int countLogs(TreeSchematic schem)
	{
		int index;
		int logCount = 0;
		int[] ba = schem.getBlockArray();

		for(int y = 0; y < schem.getHeight(); y++)
		{
			for(int z = 0; z < schem.getLength(); z++)
			{
				for(int x = 0; x < schem.getWidth(); x++)
				{
					index = x + schem.getWidth() * (z + schem.getLength() * y);
					if(Block.getBlockById(ba[index]).getMaterial() == Material.wood)
						logCount++;
				}
			}
		}
		return logCount;
	}
}
