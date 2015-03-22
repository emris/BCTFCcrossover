package emris.bctfccrossover.core;

import net.minecraft.nbt.NBTTagList;

public class TreeSchematic
{
	private int id;
	private String path;
	private int height;
	private int width;
	private int length;
	private int centerWidth;
	private int centerLength;
	private int growthStage;
	private int logCount;
	private int[] blockArray;
	private byte[] dataArray;
	private NBTTagList te;
	private NBTTagList entities;

	public TreeSchematic()
	{}

	public int getID()
	{
		return id;
	}

	public void setID(int id)
	{
		this.id = id;
	}

	public String getPath()
	{
		return path;
	}

	public void setPath(String str)
	{
		path = str;
	}

	public int getHeight()
	{
		return height;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}

	public int getWidth()
	{
		return width;
	}

	public void setWidth(int width)
	{
		this.width = width;
	}
	
	public int getLength()
	{
		return length;
	}

	public void setLength(int length)
	{
		this.length = length;
	}

	public int getCenterWidth()
	{
		return centerWidth;
	}

	public void setCenterWidth(int i)
	{
		this.centerWidth = i;
	}

	public int getCenterLength()
	{
		return centerLength;
	}

	public void setCenterLength(int i)
	{
		this.centerLength = i;
	}

	public int getGrowthStage()
	{
		return growthStage;
	}

	public void setGrowthStage(int growthStage)
	{
		this.growthStage = growthStage;
	}

	public int getLogCount()
	{
		return logCount;
	}

	public void setLogCount(int logCount)
	{
		this.logCount = logCount;
	}

	public int[] getBlockArray()
	{
		return blockArray;
	}

	public void setBlockArray(int[] array)
	{
		this.blockArray = array;
	}

	public byte[] getDataArray()
	{
		return dataArray;
	}

	public void setDataArray(byte[] array)
	{
		this.dataArray = array;
	}

	public NBTTagList getTileEntities()
	{
		return te;
	}

	public void setTileEntities(NBTTagList tag)
	{
		this.te = tag;
	}

	public NBTTagList getEntities()
	{
		return entities;
	}

	public void setEntities(NBTTagList e)
	{
		this.entities = e;
	}
}
