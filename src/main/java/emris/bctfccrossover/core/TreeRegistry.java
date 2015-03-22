package emris.bctfccrossover.core;

import java.util.HashMap;
import java.util.Random;
import java.util.Vector;

import emris.bctfccrossover.BCTFCcrossover;

public class TreeRegistry
{
	public static TreeRegistry instance = new TreeRegistry();
	private HashMap<String, TreeData> treeTypeHash = new HashMap<String, TreeData>();
	private Vector<TreeManager> treeList;

	public TreeRegistry()
	{
		treeList = new Vector<TreeManager>();
	}

	public void RegisterTree(TreeSchematic treeSchematic, String name)
	{
		int index = checkValidity(name);

		if(index < 0)
		{
			BCTFCcrossover.tfcbcLog.warning("Registering Tree Type \"" + name + "\" Failed!");
		}
		else
		{
			if(treeList.size() < treeTypeHash.size())
				treeList.setSize(treeTypeHash.size());

			if(treeList.get(index) == null)
				treeList.set(index, new TreeManager());

			treeList.get(index).addSchem(treeSchematic);
		}
	}

	public TreeSchematic getRandomTreeSchematic(Random R, int treeID)
	{
		return treeList.get(treeID).getRandomSchematic(R);
	}

	public TreeSchematic getRandomTreeSchematic(Random R, int treeID, int growthStage)
	{
		return treeList.get(treeID).getRandomSchematic(R, growthStage);
	}

	public TreeSchematic getTreeSchematic(int treeID, int schemID, int growthStage)
	{
		return treeList.get(treeID).getSchematic(schemID, growthStage);
	}

	public void addWoodType(TreeData configuration)
	{
		if(!treeTypeHash.containsKey(configuration.name))
		{
			treeTypeHash.put(configuration.name, configuration);
		}
	}

	public int checkValidity(String n)
	{
		int index = indexFromString(n);
		if(index >= 0 ) return index;
		return -1;
	}

	/**
	 * @param n Name of the Tree type. Used as the Key in the hash map for lookups.
	 * @return Tree index that is unique to that tree
	 */
	public int indexFromString(String n)
	{
		if(treeTypeHash.containsKey(n))
			return ((TreeData) treeTypeHash.get(n)).index;
		return -1;
	}

	/**
	 * @param n Name of the Tree type. Used as the Key in the hash map for lookups.
	 * @return Full TreeConfiguration file
	 */
	public TreeData treeFromString(String n)
	{
		if(treeTypeHash.containsKey(n))
			return ((TreeData) treeTypeHash.get(n));
		return null;
	}
	/**
	 * @param id The tree type ID.
	 * @return Full TreeConfiguration file
	 */
	public TreeData treeFromID(int id)
	{
		for(;treeTypeHash.values().iterator().hasNext();)
		{
			TreeData config = (TreeData)treeTypeHash.values().iterator().next();
			if(config.index == id)
				return config;
		}
		return null;
	}

	public TreeData getRandomTree()
	{
		int id = new Random().nextInt(treeTypeHash.values().toArray().length);
		return treeFromID(id);
	}
}
