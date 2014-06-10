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
	static int worldHeight;
	static Boolean infoStop;
	int Min = 5; // Minimum Height
	int Max = 130; // Maximum Height

	public WorldGenOil() {}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		chunkX *= 16;
		chunkZ *= 16;
		int height = random.nextInt(15) + 5;
		int size = random.nextInt(40) + 20;
		int amount = random.nextInt(20) + 20;

		createOil(BuildCraftEnergy.blockOil.blockID, 0, new int[]{TFCBlocks.StoneSed.blockID, -1},/*spawn in sedimentary stone*/
				/*rarity-100*/100,
				/*Size-80*/size,
				/*Amount-60*/amount,
				/*height*/height,
				/*diameter-300*/40,
				/*vDensity-10*/40,
				/*hDensity-120*/90,
				world, random, chunkX, chunkZ, Min, Max, "Oil", false);
	}

	private static void createOil(int i, int j, int[] Layers, int rarity, int veinSize, int veinAmount, int height, int diameter,
			int vDensity, int hDensity, World world, Random rand, int chunkX, int chunkZ, int min, int max, String name, boolean vein)
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
							diameter, vDensity, hDensity, vein).generate(world, rand, chunkX, chunkZ, min, max, name);
				}
				n += 2;
			}
		}
	}
}
