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
package emris.BCTFCcrossover.core;

import java.io.File;

import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;
import buildcraft.BuildCraftCore;
import buildcraft.BuildCraftTransport;
import emris.BCTFCcrossover.BCTFCcrossover;

public class IDProvider {
	public static int Plans							= 25400;
	public static int Gears							= 25401;
	public static int Buckets						= 25402;
	public static int Rubber						= 25403;
	public static int PipeFrames					= 25404;
	//public static int ???							= 25405;
	public static int LatexBowl						= 25406;

	public static int TinPipeItem					= 25430;
	public static int LeadPipeItem					= 25431;
	public static int BronzePipeItem				= 25432;
	public static int WroughtIronPipeItem			= 25433;
	public static int SteelPipeItem					= 25434;
	public static int BlueSteelPipeItem				= 25435;
	public static int RedSteelPipeItem				= 25436;
	public static int BlackBronzePipeItem			= 25437;
	public static int RoseGoldPipeItem				= 25438;
	public static int BlackSteelPipeItem			= 25439;
	public static int SterlingSilverPipeItem		= 25440;
	public static int BrassPipeItem					= 25441;

	public static int TinPipeFluidsItem				= 25450;
	public static int LeadPipeFluidsItem			= 25451;
	public static int BronzePipeFluidsItem			= 25452;
	public static int WroughtIronPipeFluidsItem		= 25453;
	public static int SteelPipeFluidsItem			= 25454;
	public static int RedSteelPipeFluidsItem		= 25455;
	public static int BlackBronzePipeFluidsItem		= 25456;
	public static int RoseGoldPipeFluidsItem		= 25457;

	public static int CopperPipePowerItem			= 25470;
	public static int RoseGoldPipePowerItem			= 25471;
	public static int BlackBronzePipePowerItem		= 25472;
	public static int WroughtIronPipePowerItem		= 25473;
	public static int SteelPipePowerItem			= 25474;
	public static int PlatinumPipePowerItem			= 25475;

	public static int LeadPipeStructureItem			= 25490;

	public static int BismuthWrenchItem				= 25500;
	public static int TinWrenchItem					= 25501;
	public static int ZincWrenchItem				= 25502;
	public static int CopperWrenchItem				= 25503;
	public static int BismuthBronzeWrenchItem		= 25504;
	public static int BlackBronzeWrenchItem			= 25505;
	public static int BronzeWrenchItem				= 25506;
	public static int RoseGoldWrenchItem			= 25507;
	public static int WroughtIronWrenchItem			= 25508;
	public static int SteelWrenchItem				= 25509;
	public static int BlackSteelWrenchItem			= 25510;
	public static int BlueSteelWrenchItem			= 25511;
	public static int RedSteelWrenchItem			= 25512;

	// Blocks
	public static int Hevea							= 4050;
	public static int Latex							= 4051;

	// BC IDs
	// Item Pipes
	public static final int bcWoodPipe					= BuildCraftTransport.pipeItemsWood.itemID;
	public static final int bcCobblestonePipe			= BuildCraftTransport.pipeItemsCobblestone.itemID;
	public static final int bcStonePipe					= BuildCraftTransport.pipeItemsStone.itemID;
	public static final int bcIronPipe					= BuildCraftTransport.pipeItemsIron.itemID;
	public static final int bcGoldPipe					= BuildCraftTransport.pipeItemsGold.itemID;
	public static final int bcDiamondPipe				= BuildCraftTransport.pipeItemsDiamond.itemID;
	public static final int bcEmeraldPipe				= BuildCraftTransport.pipeItemsEmerald.itemID;
	public static final int bcVoidPipe					= BuildCraftTransport.pipeItemsVoid.itemID;
	public static final int bcSandstonePipe				= BuildCraftTransport.pipeItemsSandstone.itemID;
	public static final int bcObsidianPipe				= BuildCraftTransport.pipeItemsObsidian.itemID;
	public static final int bcDaizuliPipe				= BuildCraftTransport.pipeItemsDaizuli.itemID;
	public static final int bcLapisPipe					= BuildCraftTransport.pipeItemsLapis.itemID;
	public static final int bcQuartzPipe				= BuildCraftTransport.pipeItemsQuartz.itemID;
	// Fluid Pipes
	public static final int bcWoodPipeFluids			= BuildCraftTransport.pipeFluidsWood.itemID;
	public static final int bcCobblestonePipeFluids		= BuildCraftTransport.pipeFluidsCobblestone.itemID;
	public static final int bcStonePipeFluids			= BuildCraftTransport.pipeFluidsStone.itemID;
	public static final int bcIronPipeFluids			= BuildCraftTransport.pipeFluidsIron.itemID;
	public static final int bcGoldPipeFluids			= BuildCraftTransport.pipeFluidsGold.itemID;
	public static final int bcEmeraldPipeFluids			= BuildCraftTransport.pipeFluidsEmerald.itemID;
	public static final int bcVoidPipeFluids			= BuildCraftTransport.pipeFluidsVoid.itemID;
	public static final int bcSandstoneFluids			= BuildCraftTransport.pipeFluidsSandstone.itemID;
	// Structural Pipes
	public static final int bcStructurePipeCobblestone	= BuildCraftTransport.pipeStructureCobblestone.itemID;
	// Power Pipes
	public static final int bcCobblestonePipePower		= BuildCraftTransport.pipePowerCobblestone.itemID;
	public static final int bcStonePipePower			= BuildCraftTransport.pipePowerStone.itemID;
	public static final int bcWoodPipePower				= BuildCraftTransport.pipePowerWood.itemID;
	public static final int bcQuartzPipePower			= BuildCraftTransport.pipePowerQuartz.itemID;
	public static final int bcGoldPipePower				= BuildCraftTransport.pipePowerGold.itemID;
	public static final int bcDiamondPipePower			= BuildCraftTransport.pipePowerDiamond.itemID;
	// Wrench Tool
	public static final int Wrench						= BuildCraftCore.wrenchItem.itemID;

	static Configuration config;

	public static void setup() {
		try {
			config = new Configuration(new File(BCTFCcrossover.proxy.getMinecraftDir(), "/config/BCTFCcrossover.cfg"));
			config.load();
		} catch (Exception e) {
			System.out.println(new StringBuilder().append("[BCTFCcrossover] Config file ERROR!").toString());
			config = null;
		}

		// Items
		Plans = getItemID(config, "items", "Plans", Plans);
		Gears = getItemID(config, "items", "Gears", Gears);
		Buckets = getItemID(config, "items", "Buckets", Buckets);
		Rubber = getItemID(config, "items", "Rubber", Rubber);
		PipeFrames = getItemID(config, "items", "PipeFrames", PipeFrames);
		LatexBowl = getItemID(config, "items", "LatexBowl", LatexBowl);

		TinPipeItem = getItemID(config, "items", "TinPipeItem", TinPipeItem);
		LeadPipeItem = getItemID(config, "items", "LeadPipeItem", LeadPipeItem);
		BronzePipeItem = getItemID(config, "items", "BronzePipeItem", BronzePipeItem);
		WroughtIronPipeItem = getItemID(config, "items", "WroughtIronPipeItem", WroughtIronPipeItem);
		SteelPipeItem = getItemID(config, "items", "SteelPipeItem", SteelPipeItem);
		BlueSteelPipeItem = getItemID(config, "items", "BlueSteelPipeItem", BlueSteelPipeItem);
		RedSteelPipeItem = getItemID(config, "items", "RedSteelPipeItem", RedSteelPipeItem);
		BlackBronzePipeItem = getItemID(config, "items", "BlackBronzePipeItem", BlackBronzePipeItem);
		RoseGoldPipeItem = getItemID(config, "items", "RoseGoldPipeItem", RoseGoldPipeItem);
		BlackSteelPipeItem = getItemID(config, "items", "BlackSteelPipeItem", BlackSteelPipeItem);
		SterlingSilverPipeItem = getItemID(config, "items", "SterlingSilverPipeItem", SterlingSilverPipeItem);
		BrassPipeItem = getItemID(config, "items", "BrassPipeItem", BrassPipeItem);

		TinPipeFluidsItem = getItemID(config, "items", "TinPipeFluidsItem", TinPipeFluidsItem);
		LeadPipeFluidsItem = getItemID(config, "items", "LeadPipeFluidsItem", LeadPipeFluidsItem);
		BronzePipeFluidsItem = getItemID(config, "items", "BronzePipeFluidsItem", BronzePipeFluidsItem);
		WroughtIronPipeFluidsItem = getItemID(config, "items", "WroughtIronPipeFluidsItem", WroughtIronPipeFluidsItem);
		SteelPipeFluidsItem = getItemID(config, "items", "SteelPipeFluidsItem", SteelPipeFluidsItem);
		RedSteelPipeFluidsItem = getItemID(config, "items", "RedSteelPipeFluidsItem", RedSteelPipeFluidsItem);
		BlackBronzePipeFluidsItem = getItemID(config, "items", "BlackBronzePipeFluidsItem", BlackBronzePipeFluidsItem);
		RoseGoldPipeFluidsItem = getItemID(config, "items", "RoseGoldPipeFluidsItem", RoseGoldPipeFluidsItem);

		CopperPipePowerItem = getItemID(config, "items", "CopperPipePowerItem", CopperPipePowerItem);
		RoseGoldPipePowerItem = getItemID(config, "items", "RoseGoldPipePowerItem", RoseGoldPipePowerItem);
		BlackBronzePipePowerItem = getItemID(config, "items", "BlackBronzePipePowerItem", BlackBronzePipePowerItem);
		WroughtIronPipePowerItem = getItemID(config, "items", "WroughtIronPipePowerItem", WroughtIronPipePowerItem);
		SteelPipePowerItem = getItemID(config, "items", "SteelPipePowerItem", SteelPipePowerItem);
		PlatinumPipePowerItem = getItemID(config, "items", "PlatinumPipePowerItem", PlatinumPipePowerItem);

		LeadPipeStructureItem = getItemID(config, "items", "LeadPipeStructureItem", LeadPipeStructureItem);

		BismuthWrenchItem = getItemID(config, "items", "BismuthWrenchItem", BismuthWrenchItem);
		TinWrenchItem = getItemID(config, "items", "TinWrenchItem", TinWrenchItem);
		ZincWrenchItem = getItemID(config, "items", "ZincWrenchItem", ZincWrenchItem);
		CopperWrenchItem = getItemID(config, "items", "CopperWrenchItem", CopperWrenchItem);
		BismuthBronzeWrenchItem = getItemID(config, "items", "BismuthBronzeWrenchItem", BismuthBronzeWrenchItem);
		BlackBronzeWrenchItem = getItemID(config, "items", "BlackBronzeWrenchItem", BlackBronzeWrenchItem);
		BronzeWrenchItem = getItemID(config, "items", "BronzeWrenchItem", BronzeWrenchItem);
		RoseGoldWrenchItem = getItemID(config, "items", "RoseGoldWrenchItem", RoseGoldWrenchItem);
		WroughtIronWrenchItem = getItemID(config, "items", "WroughtIronWrenchItem", WroughtIronWrenchItem);
		SteelWrenchItem = getItemID(config, "items", "SteelWrenchItem", SteelWrenchItem);
		BlackSteelWrenchItem = getItemID(config, "items", "BlackSteelWrenchItem", BlackSteelWrenchItem);
		BlueSteelWrenchItem = getItemID(config, "items", "BlueSteelWrenchItem", BlueSteelWrenchItem);
		RedSteelWrenchItem = getItemID(config, "items", "RedSteelWrenchItem", RedSteelWrenchItem);

		// Blocks
		Hevea = getItemID(config, "blocks", "Hevea", Hevea);
		Latex = getItemID(config, "blocks", "Latex", Latex);


		if (config.hasChanged()) { config.save(); }
	}

	private static int getItemID(Configuration config, String heading, String item, int value) {
		if (config == null) {
			return value;
		}
		try {
			Property prop = config.get(heading, item, value);
			return prop.getInt(value);
		} catch (Exception e) {
			System.out.println(new StringBuilder().append("[BCTFCcrossover] ERROR adding Integer, config NOT loaded properly!").toString());
		}
		return value;
	}
}
