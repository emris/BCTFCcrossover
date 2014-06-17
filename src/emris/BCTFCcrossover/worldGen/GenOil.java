/**
 * Based on:
 * http://www.minecraftforum.net/topic/330485-162spsmp-marcopolos-mods-better-ore-distributionv271-beta-trap-friendly-cactus-and-practical-tnt/
 */
package emris.BCTFCcrossover.worldGen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import TFC.Chunkdata.ChunkData;
import TFC.Chunkdata.ChunkDataManager;

public class GenOil extends WorldGenerator
{
	private static ArrayList oreList = new ArrayList();
	private static boolean genBeforeCheck;
	public static int MPChunk_X;
	public static int MPChunk_Z;
	private int x_Chunk;
	private int z_Chunk;
	public int MPBlockID;
	private int minableBlockMeta;
	public static int MPPrevX;
	public static int MPPrevZ;
	public static int MPPrevID;
	public static int MPPrevMeta;
	public static int mineCount;
	private static Random rand;
	private static World worldObj;
	private int rarity = 2;
	private int veinSi = 2;
	private int veinAm = 2;
	private int height = 2;
	private int mineHeight = 2;
	private int diameter = 2;
	private int vDens = 2;
	private int hDens = 2;
	private int genInBlock = 1;
	private int genInBlockMeta = 1;
	private boolean useMarcoVeins = false;
	private int minableBlockId;
	private int numberOfBlocks;

	public GenOil(int i, int j, int layerId, int layerMeta, int rarity, int veinSize, 
			int veinAmount, int height, int diameter, int vDensity, int hDensity, boolean vein)
	{
		this.minableBlockId = i;
		this.minableBlockMeta = j;
		this.genInBlock= layerId;
		this.genInBlockMeta = layerMeta;
		this.rarity = rarity;
		this.veinSi = veinSize;
		this.veinAm = veinAmount;
		this.height = height;
		this.diameter = diameter;
		this.vDens = vDensity;
		this.hDens = hDensity;
		this.useMarcoVeins = vein;
	}

	/**
	 *  takes a set of current global variables and checks to see if this ore has spawned before in this chunk
	 */
	public boolean generateBeforeCheck()
	{
		genBeforeCheck = false;
		genBeforeCheck = oreList.contains(Arrays.asList(MPBlockID, minableBlockMeta));

		if(oreList.contains(Arrays.asList(MPBlockID, minableBlockMeta)) == false)
			oreList.add(Arrays.asList(MPBlockID, minableBlockMeta));
		return genBeforeCheck;
	}

	void createMine(World world, Random rand, int x, int z)
	{
		for(int loopCount = 0; loopCount < veinAm; loopCount++)
		{
			int temp1 = mPCalculateDensity(diameter, hDens);
			int temp2 = mineHeight + mPCalculateDensity(height, vDens);
			int temp3 = mPCalculateDensity(diameter, hDens);
			int posX = x + temp1;
			int posY = temp2;
			int posZ = z + temp3;

			if(useMarcoVeins == false)
				BODgenerate(world, rand, posX, posY, posZ, veinSi); // generate based on values
			else
				BODgenerateVein(world, rand, posX, posY, posZ, veinSi);
		}
	}

	public boolean generate(World world, Random random, int x, int z, int min, int max)
	{
		MPChunk_X = x;
		MPChunk_Z = z;
		rand = random;
		worldObj = world;
		mineCount = 0; // this is a new chunk, so list gets set to the beginning
		oreList.clear(); // clear the list of ores, this is a new chunk
		MPBlockID = minableBlockId;// set output block ID

		if(MPChunk_X != MPPrevX || MPChunk_Z != MPPrevZ || MPPrevID != MPBlockID || minableBlockMeta != MPPrevMeta)
		{
			if (generateBeforeCheck() == false)
			{
				MPPrevX = MPChunk_X;
				MPPrevZ = MPChunk_Z;
				x_Chunk = MPChunk_X;
				z_Chunk = MPChunk_Z;
				MPPrevID = MPBlockID;
				MPPrevMeta = minableBlockMeta;
				mineHeight = min + rand.nextInt(max-min);

				if (rarity == 1 || (rarity > 0 && rand.nextInt(rarity) == 0))
					createMine(worldObj, rand, x_Chunk, z_Chunk);
			}
		}
		return true;
	}

	public int mPCalculateDensity(int oreDistance, float oreDensity) // returns the density value
	{
		int loopCount = 0;
		int densityValuePassInner = 0;
		int densityValuePass = 0;
		oreDensity = oreDensity * .01F;
		oreDensity = (oreDensity * (oreDistance >> 1)) + 1F;// establishes number of times to loop
		loopCount = (int)(oreDensity); //stores number of times to loop
		densityValuePassInner = ((oreDistance/loopCount)); // distance devided by number of times it will loop, establishes the number for randomization
		densityValuePassInner += (((oreDistance - (densityValuePassInner*loopCount))/loopCount));
		densityValuePass = 0;
		while (loopCount > 0) // loops to acumulate random values
		{
			densityValuePass = densityValuePass + rand.nextInt(densityValuePassInner); // acumulate randoms
			loopCount = loopCount - 1; // decriment loop
		}
		return densityValuePass; // return proccesed random value
	}

	public boolean BODgenerateVein(World world, Random rand, int parX, int parY, int parZ, int xyz)
	{
		int posX = parX;
		int posY = parY;
		int posZ = parZ;
		int tempPosX = 0;
		int tempPosY = 0;
		int tempPosZ = 0;
		int posX2 = 0;
		int posY2 = 0;
		int posZ2 = 0;
		int directionX = 0;
		int directionY = 0;
		int directionZ = 0;
		int directionX2 = 0;
		int directionY2 = 0;
		int directionZ2 = 0;
		int directionX3 = 0;
		int directionY3 = 0;
		int directionZ3 = 0;
		int directionChange = 0;
		int directionChange2 = 0;
		int blocksToUse = xyz;//input number of blocks per vein
		int blocksToUse2 = 0;

		for(int blocksMade = 0; blocksMade <= blocksToUse;) // make veins
		{
			blocksToUse2 = 1 + (blocksToUse/30);
			directionChange = rand.nextInt(6);
			directionX = rand.nextInt(2);
			directionY = rand.nextInt(2);
			directionZ = rand.nextInt(2);

			for(int blocksMade1 = 0; blocksMade1 <= blocksToUse2; ) // make branch
			{
				boolean isCorrectRockType = (world.getBlockId(posX, posY, posZ) == this.genInBlock);
				boolean isCorrectMeta = (world.getBlockMetadata(posX, posY, posZ) == this.genInBlockMeta || this.genInBlockMeta == -1);

				if(directionX == 0 && directionChange != 1) posX = posX + rand.nextInt(2);
				if(directionX == 1 && directionChange != 1) posX = posX - rand.nextInt(2);
				if(directionY == 0 && directionChange != 2) posY = posY + rand.nextInt(2);
				if(directionY == 1 && directionChange != 2) posY = posY - rand.nextInt(2);
				if(directionZ == 0 && directionChange != 3) posZ = posZ + rand.nextInt(2);
				if(directionZ == 1 && directionChange != 3) posZ = posZ - rand.nextInt(2);

				if(rand.nextInt(4) == 0)
				{
					posX2 = posX2 + rand.nextInt(2);
					posY2 = posY2 + rand.nextInt(2);
					posZ2 = posZ2 + rand.nextInt(2);
					posX2 = posX2 - rand.nextInt(2);
					posY2 = posY2 - rand.nextInt(2);
					posZ2 = posZ2 - rand.nextInt(2);
				}

				if(rand.nextInt(3) == 0) // make sub-branch
				{
					posX2 = posX;
					posY2 = posY;
					posZ2 = posZ;
					directionX2 = rand.nextInt(2);
					directionY2 = rand.nextInt(2);
					directionZ2 = rand.nextInt(2);
					directionChange2 = rand.nextInt(6);

					if(directionX2 == 0 && directionChange2 != 0) posX2 = posX2 + rand.nextInt(2);
					if(directionY2 == 0 && directionChange2 != 1) posY2 = posY2 + rand.nextInt(2);
					if(directionZ2 == 0 && directionChange2 != 2) posZ2 = posZ2 + rand.nextInt(2);
					if(directionX2 == 1 && directionChange2 != 0) posX2 = posX2 - rand.nextInt(2);
					if(directionY2 == 1 && directionChange2 != 1) posY2 = posY2 - rand.nextInt(2);
					if(directionZ2 == 1 && directionChange2 != 2) posZ2 = posZ2 - rand.nextInt(2);

					for(int blocksMade2 = 0; blocksMade2 <= (1 + (blocksToUse2 / 5)); )
					{
						if(directionX2 == 0 && directionChange2 != 0) posX2 = posX2 + rand.nextInt(2);
						if(directionY2 == 0 && directionChange2 != 1) posY2 = posY2 + rand.nextInt(2);
						if(directionZ2 == 0 && directionChange2 != 2) posZ2 = posZ2 + rand.nextInt(2);
						if(directionX2 == 1 && directionChange2 != 0) posX2 = posX2 - rand.nextInt(2);
						if(directionY2 == 1 && directionChange2 != 1) posY2 = posY2 - rand.nextInt(2);
						if(directionZ2 == 1 && directionChange2 != 2) posZ2 = posZ2 - rand.nextInt(2);

						int localX = posX & 15;
						int localZ = posZ & 15;
						ChunkData data = ChunkDataManager.getData(posX >> 4, posZ >> 4);
						int hm = data != null ? data.heightmap[localX + localZ * 16] : 0;
						posY = Math.min(255, posY + hm);

						if(isCorrectRockType && isCorrectMeta)
						{
							world.setBlock(posX, posY, posZ, MPBlockID, minableBlockMeta, 2);
							//System.out.println("OIL: "+posX+":"+posY+":"+posZ);
						}

						blocksMade++;
						blocksMade1++;
						blocksMade2++;
					}
				}

				int localX = posX & 15;
				int localZ = posZ & 15;
				ChunkData data = ChunkDataManager.getData(posX >> 4, posZ >> 4);
				int hm = data != null ? data.heightmap[localX + localZ * 16] : 0;
				posY = Math.min(255, posY + hm);

				if(isCorrectRockType && isCorrectMeta)
				{
					world.setBlock(posX, posY, posZ, MPBlockID, minableBlockMeta, 2);
					//System.out.println("OIL: "+posX+":"+posY+":"+posZ);
				}

				blocksMade++;
				blocksMade1++;
			}

			parX = parX + (rand.nextInt(3) - 1);
			parY = parY + (rand.nextInt(3) - 1);
			parZ = parZ + (rand.nextInt(3) - 1);
			posX = parX;
			posY = parY;
			posZ = parZ;
		}
		return true;
	}

	public boolean BODgenerate(World world, Random rand, int par3, int par4, int par5, int xyz)
	{

		//==========================================mp mod
		numberOfBlocks = xyz; //input number of blocks per vein

		//==========================================mp mod
		float var6 = rand.nextFloat() * (float)Math.PI;
		double var7 = par3 + 8 + MathHelper.sin(var6) * numberOfBlocks / 8.0F;
		double var9 = par3 + 8 - MathHelper.sin(var6) * numberOfBlocks / 8.0F;
		double var11 = par5 + 8 + MathHelper.cos(var6) * numberOfBlocks / 8.0F;
		double var13 = par5 + 8 - MathHelper.cos(var6) * numberOfBlocks / 8.0F;
		double var15 = par4 + rand.nextInt(3) - 2;
		double var17 = par4 + rand.nextInt(3) - 2;

		for (int var19 = 0; var19 <= numberOfBlocks; ++var19)
		{
			double var20 = var7 + (var9 - var7) * var19 / numberOfBlocks;
			double var22 = var15 + (var17 - var15) * var19 / numberOfBlocks;
			double var24 = var11 + (var13 - var11) * var19 / numberOfBlocks;
			double var26 = rand.nextDouble() * this.numberOfBlocks / 16.0D;
			double var28 = (MathHelper.sin(var19 * (float)Math.PI / numberOfBlocks) + 1.0F) * var26 + 1.0D;
			double var30 = (MathHelper.sin(var19 * (float)Math.PI / numberOfBlocks) + 1.0F) * var26 + 1.0D;
			int var32 = MathHelper.floor_double(var20 - var28 / 2.0D);
			int var33 = MathHelper.floor_double(var22 - var30 / 2.0D);
			int var34 = MathHelper.floor_double(var24 - var28 / 2.0D);
			int var35 = MathHelper.floor_double(var20 + var28 / 2.0D);
			int var36 = MathHelper.floor_double(var22 + var30 / 2.0D);
			int var37 = MathHelper.floor_double(var24 + var28 / 2.0D);

			for (int posX = var32; posX <= var35; ++posX)
			{
				double var39 = (posX + 0.5D - var20) / (var28 / 2.0D);

				if (var39 * var39 < 1.0D)
				{
					for (int posY = var33; posY <= var36; ++posY)
					{
						double var42 = (posY + 0.5D - var22) / (var30 / 2.0D);

						if (var39 * var39 + var42 * var42 < 1.0D)
							for (int posZ = var34; posZ <= var37; ++posZ)
							{
								double var45 = (posZ + 0.5D - var24) / (var28 / 2.0D);

								int localX = posX & 15;
								int localZ = posZ & 15;
								ChunkData data = ChunkDataManager.getData(posX >> 4, posZ >> 4);
								int hm = data != null ? data.heightmap[localX + localZ * 16] : 0;
								posY = Math.min(255, posY + hm);

								int m = world.getBlockMetadata(posX, posY, posZ);
								int id = world.getBlockId(posX, posY, posZ);
								boolean isCorrectRockType = world.getBlockId(posX, posY, posZ) == this.genInBlock;
								boolean isCorrectMeta = (m == this.genInBlockMeta || this.genInBlockMeta == -1);

								if(isCorrectRockType && isCorrectMeta)
								{
									if (var39 * var39 + var42 * var42 + var45 * var45 < 1.0D)
									{
										world.setBlock(posX, posY, posZ, MPBlockID, minableBlockMeta, 2);
										System.out.println("OIL: "+posX+":"+posY+":"+posZ);
									}
								}
							}
					}
				}
			}
		}
		return true;
	}

	@Override
	public boolean generate(World world, Random random, int i, int j, int k)
	{
		return false;
	}
}