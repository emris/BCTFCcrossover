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
package emris.bctfccrossover.worldGen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import com.bioxx.tfc.Core.TFC_Climate;
import com.bioxx.tfc.Core.TFC_Core;
import com.bioxx.tfc.WorldGen.TFCBiome;
import com.bioxx.tfc.WorldGen.TFCWorldChunkManager;

import cpw.mods.fml.common.IWorldGenerator;
import emris.bctfccrossover.BCTFCBlocks;
import emris.bctfccrossover.core.TreeData;
import emris.bctfccrossover.core.TreeRegistry;
import emris.bctfccrossover.core.TreeSchematic;
import emris.bctfccrossover.tileEntities.TETreeLog;

public class WorldGenHevea implements IWorldGenerator
{
	private int treeID = 0;
	private int growthStage = 0;
	private int baseX = 0;
	private int baseY = 0;
	private int baseZ = 0;
	private float evt;
	private float rainfall;
	private float temp;

	public WorldGenHevea()
	{}

	public WorldGenHevea(int gs)
	{
		growthStage = gs;
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		chunkX *= 16;
		chunkZ *= 16;

		if(world.getWorldChunkManager() instanceof TFCWorldChunkManager)
		{
			growthStage = random.nextInt(4) + 1;
			if(random.nextInt(100) < 5)
				growthStage = 6;

			//Get a random tree schematic
			TreeSchematic schem = TreeRegistry.instance.getRandomTreeSchematic(random, treeID, growthStage);
			if(schem == null) return;

			TFCBiome biome = (TFCBiome) world.getBiomeGenForCoords(chunkX, chunkZ);
			if(biome == TFCBiome.ocean || biome == TFCBiome.DeepOcean || biome == TFCBiome.swampland) return;

			rainfall = TFC_Climate.getRainfall(world, chunkX, 0, chunkZ);
			evt = TFC_Climate.getCacheManager(world).getEVTLayerAt(chunkX + 8, chunkZ + 8).floatdata1;

			int xCoord = 0;
			int zCoord = 0;
			int yCoord = 0;
			boolean isAirAbove = false;
			int numTrees = 1;
			for(int l = 0; l < numTrees; l++)
			{
				xCoord = chunkX + random.nextInt(16);
				zCoord = chunkZ + random.nextInt(16);
				yCoord = world.getHeightValue(xCoord, zCoord);
				temp = TFC_Climate.getBioTemperatureHeight(world, xCoord, world.getHeightValue(xCoord, zCoord), zCoord);
				Block b = world.getBlock(xCoord, yCoord - 1, zCoord);
				isAirAbove = world.isAirBlock(xCoord, yCoord, zCoord);

				if(getNearWater(world, xCoord, yCoord - 1, zCoord))
				{
					rainfall*=2;
					evt /= 2;
				}

				if(growthStage <= 5
						&& canGrowHere(world, b, xCoord, yCoord - 1, zCoord, 2)
						&& random.nextInt(21) < treeSpawnChance()
						&& isAirAbove)
				{
					genTree(schem, treeID, world, xCoord, yCoord, zCoord);
				}
				else if(growthStage == 6
						&& canGrowHere(world, b, xCoord, yCoord - 1, zCoord, 3)
						&& random.nextInt(21) < treeSpawnChance()
						&& isAirAbove)
				{
					genTree(schem, treeID, world, xCoord, yCoord, zCoord);
				}
			}
		}
	}

	public boolean forceGen(World world, int xCoord, int yCoord, int zCoord)
	{
		//Get a random tree schematic
		TreeSchematic schem = TreeRegistry.instance.getRandomTreeSchematic(world.rand, treeID, growthStage);
		if(schem == null) return false;

		return genTree(schem, treeID, world, xCoord, yCoord + 1, zCoord);
	}



	//*****************
	// Private methods
	//*****************
	private boolean genTree(TreeSchematic schem, int meta, World world, int treeX, int treeY, int treeZ)
	{
		int rot = world.rand.nextInt(4);
		int index;
		int id;
		boolean doBase = false;

		this.baseX = treeX-1;
		this.baseY = treeY;
		this.baseZ = treeZ-1;

		for(int y = 0; y < schem.getHeight(); y++)
		{
			for(int z = 0; z < schem.getLength(); z++)
			{
				for(int x = 0; x < schem.getWidth(); x++)
				{
					index = x + schem.getWidth() * (z + schem.getLength() * y);
					id = schem.getBlockArray()[index];
					doBase = (y == 0 && x == schem.getCenterWidth() - 1 && z == schem.getCenterLength() - 1);
					if(id != 0 || doBase)
						Process(world, baseX, baseY, baseZ, meta, schem, x + 1, y, z + 1, rot, doBase, Block.getBlockById(id));
				}
			}
		}

		return true;
	}

	private void Process(World world, int treeX, int treeY, int treeZ, int meta,
			TreeSchematic schem, int schemX, int schemY, int schemZ, int rot, boolean doBase, Block b)
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

		Block block = BCTFCBlocks.blockHevea;
		Block leaves = BCTFCBlocks.blockHeveaLeaves;
		int localMeta = meta;

		if(localX == treeX && schemY == 0 && localZ == treeZ || doBase)
		{
			world.setBlock(localX, localY, localZ, block, localMeta, 0x2);
			TETreeLog te = (TETreeLog) world.getTileEntity(localX, localY, localZ);
			te.isBase = true;
			te.schemIndex = (byte) schem.getID();
			te.treeID = (byte) meta;
			te.rotation = (byte) rot;
			te.growthStage = (byte) ((TreeSchematic) schem).getGrowthStage();
		}
		else
		{
			if(b.getMaterial() == Material.wood)
			{
				world.setBlock(localX, localY, localZ, block, localMeta, 0x2);
				TETreeLog te = (TETreeLog) world.getTileEntity(localX, localY, localZ);
				te.Setup(baseX, baseY, baseZ);
			}
			else
			{
				if(world.getBlock(localX, localY, localZ).canBeReplacedByLeaves(world, localX, localY, localZ))
				{
					world.setBlock(localX, localY, localZ, leaves, localMeta, 0x2);
					TETreeLog te = (TETreeLog) world.getTileEntity(localX, localY, localZ);
					te.Setup(baseX, baseY, baseZ);
				}
			}
		}
	}

	private boolean isBlockValid(Block block)
	{
		return TFC_Core.isGrass(block)
				|| TFC_Core.isDirt(block)
				|| TFC_Core.isClay(block);
	}

	private boolean canGrowHere(World world, Block block, int x, int y, int z, int rad)
	{
		boolean ret = true;
		Block ground;
		Block above;

		outerloop:
			for(int i = -rad; i <= rad; i++)
			{
				for(int k = -rad; k <= rad; k++)
				{
					ground = world.getBlock(x + i, y, z + k);
					above = world.getBlock(x + i, y + 1, z + k);
					if(above == BCTFCBlocks.blockHevea)
					{
						ret = false;
						break outerloop;
					}
					if(!isBlockValid(ground))
					{
						ret = false;
						break outerloop;
					}
				}
			}

		return ret;
	}

	private int treeSpawnChance()
	{
		int ret = 0;
		TreeData td = TreeRegistry.instance.treeFromID(0);
		if(temp >= td.minTemp && temp <= td.maxTemp) ret += 5;
		if(rainfall >= td.minRain && rainfall <= td.maxRain) ret += 5;
		if(evt >= td.minEVT && evt <= td.maxEVT) ret += 10;
		return ret;
	}

	private boolean getNearWater(World world, int x, int y, int z)
	{
		for (int x1 = -4; x1 < 5; ++x1)
		{
			for (int z1 = -4; z1 < 5; ++z1)
			{
				for (int y1 = -2; y1 < 1; ++y1)
				{
					if(world.blockExists(x + x1, y + y1, z + z1) == true && TFC_Core.isWater(world.getBlock(x + x1, y + y1, z + z1)))
						return true;
				}
			}
		}
		return false;
	}
}
