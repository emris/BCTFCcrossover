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
 *  
 *  This is based on TerraFirmaCraft -- http://terrafirmacraft.com
 */
package emris.BCTFCcrossover.worldGen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import TFC.TFCBlocks;
import TFC.WorldGen.DataLayer;
import TFC.WorldGen.TFCWorldChunkManager;
import buildcraft.BuildCraftEnergy;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenOil implements IWorldGenerator
{
	public WorldGenOil() {}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		chunkX *= 16;
		chunkZ *= 16;

		int oil = BuildCraftEnergy.blockOil.blockID;
		int meta = 0;
		int[] stoneLayer = new int[]{TFCBlocks.StoneSed.blockID, -1}; /*spawn in sedimentary stone*/
		int rarity = 90;
		int size = random.nextInt(40) + 20;
		int amount = random.nextInt(10) + 30;
		int height = random.nextInt(5) + 5;
		int diameter = random.nextInt(40) + 80;
		int vDensity = 90;
		int hDensity = 40;
		int Min = 5; // Minimum Height
		int Max = 90; // Maximum Height

		createOil(oil, meta, stoneLayer, rarity, size, amount, height, diameter, vDensity, hDensity,
				world, random, chunkX, chunkZ, Min, Max, false);
	}

	private static void createOil(int i, int j, int[] Layers, int rarity, int veinSize, int veinAmount, int height, int diameter,
			int vDensity, int hDensity, World world, Random rand, int chunkX, int chunkZ, int min, int max, boolean vein)
	{
		if(world.getWorldChunkManager() instanceof TFCWorldChunkManager)
		{
			for(int n = 0; n < Layers.length / 2; )
			{
				DataLayer rockLayer1 = ((TFCWorldChunkManager)world.getWorldChunkManager()).getRockLayerAt(chunkX, chunkZ, 0);
				DataLayer rockLayer2 = ((TFCWorldChunkManager)world.getWorldChunkManager()).getRockLayerAt(chunkX, chunkZ, 1);
				DataLayer rockLayer3 = ((TFCWorldChunkManager)world.getWorldChunkManager()).getRockLayerAt(chunkX, chunkZ, 2);

				if((rockLayer1.data1 == Layers[n] && (rockLayer1.data2 == Layers[n+1] || Layers[n+1] == -1)) ||
						(rockLayer2.data1 == Layers[n] && (rockLayer2.data2 == Layers[n+1] || Layers[n+1] == -1)) ||
						(rockLayer3.data1 == Layers[n] && (rockLayer3.data2 == Layers[n+1] || Layers[n+1] == -1)))
				{
					new GenOil(i, j, Layers[n], Layers[n + 1], rarity, veinSize, veinAmount, height,
							diameter, vDensity, hDensity, vein).generate(world, rand, chunkX, chunkZ, min, max);
				}
				n += 2;
			}
		}
	}
}
