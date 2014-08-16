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

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import TFC.TFCBlocks;
import TFC.TFCItems;
import TFC.API.Crafting.AnvilManager;
import TFC.API.Crafting.AnvilRecipe;
import TFC.API.Crafting.AnvilReq;
import TFC.API.Crafting.PlanRecipe;
import TFC.API.Enums.RuleEnum;
import buildcraft.BuildCraftBuilders;
import buildcraft.BuildCraftCore;
import buildcraft.BuildCraftEnergy;
import buildcraft.BuildCraftFactory;
import buildcraft.BuildCraftSilicon;
import buildcraft.BuildCraftTransport;
import buildcraft.api.recipes.AssemblyRecipe;
import emris.BCTFCcrossover.BCTFCcrossover;
import emris.BCTFCcrossover.CommonProxy;
import emris.BCTFCcrossover.Items;

public class Recipes
{
	private static final CommonProxy proxy = BCTFCcrossover.proxy;

	public static void loadRecipes()
	{
		// Remove BC Recipes before we add our new ones
		removeBCRecipes();

		// Anvil Recipes
		AnvilManager anvil = AnvilManager.getInstance();

		// Add plans to anvil manager
		anvil.addPlan("gear", new PlanRecipe(new RuleEnum[] {RuleEnum.PUNCHLAST, RuleEnum.BENDNOTLAST, RuleEnum.DRAWNOTLAST}));
		anvil.addPlan("wrench", new PlanRecipe(new RuleEnum[] {RuleEnum.HITLAST, RuleEnum.DRAWSECONDFROMLAST, RuleEnum.BENDTHIRDFROMLAST}));
		anvil.addPlan("frame", new PlanRecipe(new RuleEnum[] {RuleEnum.HITLAST, RuleEnum.BENDSECONDFROMLAST, RuleEnum.BENDTHIRDFROMLAST}));

		// Instead of Wood
		anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.BismuthBronzeIngot), null, "gear", AnvilReq.BISMUTHBRONZE, new ItemStack(Items.Gears, 1, 0)));
		anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.BlackBronzeIngot), null, "gear", AnvilReq.BLACKBRONZE, new ItemStack(Items.Gears, 1, 1)));
		anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.BronzeIngot), null, "gear", AnvilReq.BRONZE, new ItemStack(Items.Gears, 1, 2)));
		anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.RoseGoldIngot), null, "gear", AnvilReq.COPPER, new ItemStack(Items.Gears, 1, 3)));
		// Instead of Stone
		anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.WroughtIronIngot), null, "gear", AnvilReq.WROUGHTIRON, new ItemStack(Items.Gears, 1, 4)));
		// Instead of Iron
		anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.SteelIngot), null, "gear", AnvilReq.STEEL, new ItemStack(Items.Gears, 1, 5)));
		// Instead of Gold
		anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.BlackSteelIngot), null, "gear", AnvilReq.BLACKSTEEL, new ItemStack(Items.Gears, 1, 6)));
		// Instead of Diamond
		anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.BlueSteelIngot), null, "gear", AnvilReq.BLUESTEEL, new ItemStack(Items.Gears, 1, 7)));
		anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.RedSteelIngot), null, "gear", AnvilReq.REDSTEEL, new ItemStack(Items.Gears, 1, 8)));

		// Wrench
		anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.CopperIngot), null, "wrench", AnvilReq.STONE, new ItemStack(Items.CopperWrenchItem, 1)));
		anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.BronzeIngot), null, "wrench", AnvilReq.COPPER, new ItemStack(Items.BronzeWrenchItem, 1)));
		anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.BismuthBronzeIngot), null, "wrench", AnvilReq.COPPER, new ItemStack(Items.BismuthBronzeWrenchItem, 1)));
		anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.BlackBronzeIngot), null, "wrench", AnvilReq.COPPER, new ItemStack(Items.BlackBronzeWrenchItem, 1)));
		anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.WroughtIronIngot), null, "wrench", AnvilReq.BRONZE, new ItemStack(Items.WroughtIronWrenchItem, 1)));
		anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.SteelIngot), null, "wrench", AnvilReq.WROUGHTIRON, new ItemStack(Items.SteelWrenchItem, 1)));
		anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.BlackSteelIngot), null, "wrench", AnvilReq.STEEL, new ItemStack(Items.BlackSteelWrenchItem, 1)));
		anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.BlueSteelIngot), null, "wrench", AnvilReq.BLACKSTEEL, new ItemStack(Items.BlueSteelWrenchItem, 1)));
		anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.RedSteelIngot), null, "wrench", AnvilReq.BLACKSTEEL, new ItemStack(Items.RedSteelWrenchItem, 1)));

		// Anvil Pipe Frames
		//OLD -> anvil.addRecipe(new MultiItemAnvilRecipe(new ItemStack(TFCItems.TinSheet), new ItemStack(Items.Plans, 1, 2),40 + R.nextInt(35),CraftingRuleEnum.HITLAST, CraftingRuleEnum.BENDSECONDFROMLAST, CraftingRuleEnum.BENDTHIRDFROMLAST, false, AnvilReq.STONE, new ItemStack(Items.PipeFrames, 8, 0)));
		anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.TinSheet), null, "frame", AnvilReq.STONE, new ItemStack(Items.PipeFrames, 8, 0)));
		anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.LeadSheet), null, "frame", AnvilReq.COPPER, new ItemStack(Items.PipeFrames, 8, 1)));
		anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.BronzeSheet), null, "frame", AnvilReq.COPPER, new ItemStack(Items.PipeFrames, 8, 2)));
		anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.WroughtIronSheet), null, "frame", AnvilReq.BRONZE, new ItemStack(Items.PipeFrames, 8, 3)));
		anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.SteelSheet), null, "frame", AnvilReq.WROUGHTIRON, new ItemStack(Items.PipeFrames, 8, 4)));
		anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.BlueSteelSheet), null, "frame", AnvilReq.BLACKSTEEL, new ItemStack(Items.PipeFrames, 8, 5)));
		anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.RedSteelSheet), null, "frame", AnvilReq.BLACKSTEEL, new ItemStack(Items.PipeFrames, 8, 6)));
		anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.BlackBronzeSheet), null, "frame", AnvilReq.COPPER, new ItemStack(Items.PipeFrames, 8, 7)));
		anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.RoseGoldSheet), null, "frame", AnvilReq.COPPER, new ItemStack(Items.PipeFrames, 8, 8)));
		anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.BlackSteelSheet), null, "frame", AnvilReq.STEEL, new ItemStack(Items.PipeFrames, 8, 9)));
		anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.ZincSheet), null, "frame", AnvilReq.STONE, new ItemStack(Items.PipeFrames, 8, 10)));
		anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.CopperSheet), null, "frame", AnvilReq.STONE, new ItemStack(Items.PipeFrames, 8, 11)));
		anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.SilverSheet), null, "frame", AnvilReq.COPPER, new ItemStack(Items.PipeFrames, 8, 12)));
		anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.PlatinumSheet), null, "frame", AnvilReq.STEEL, new ItemStack(Items.PipeFrames, 8, 13)));
		anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.SterlingSilverSheet), null, "frame", AnvilReq.COPPER, new ItemStack(Items.PipeFrames, 8, 14)));
		anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.BrassSheet), null, "frame", AnvilReq.STONE, new ItemStack(Items.PipeFrames, 8, 15)));

		//Buckets
		anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.ZincSheet), null, "bucket", AnvilReq.STONE, new ItemStack(Items.Buckets, 1, 1)));
		anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.SteelSheet), null, "bucket", AnvilReq.WROUGHTIRON, new ItemStack(Items.Buckets, 1, 3)));


		// =================Transport Pipes========================
		// Tin replaces pipeItemsWood
		proxy.addCraftingRecipe(new ItemStack(Items.TinPipeItem, 1), new Object[] { " G ", "GFG", " G ",
			Character.valueOf('F'), "pipeFrameTin",
			Character.valueOf('G'), Block.thinGlass });
		// Replaces pipeItemsCobblestone
		proxy.addCraftingRecipe(new ItemStack(Items.LeadPipeItem, 1), new Object[] { " G ", "GFG", " G ",
			Character.valueOf('F'), "pipeFrameLead",
			Character.valueOf('G'), Block.thinGlass });
		// Replaces pipeItemsStone
		proxy.addCraftingRecipe(new ItemStack(Items.BronzePipeItem, 1), new Object[] { " G ", "GFG", " G ",
			Character.valueOf('F'), "pipeFrameBronze",
			Character.valueOf('G'), Block.thinGlass });
		// Replaces pipeItemsIron
		proxy.addCraftingRecipe(new ItemStack(Items.WroughtIronPipeItem, 1), new Object[] { " G ", "GFG", " G ",
			Character.valueOf('F'), "pipeFrameWroughtIron",
			Character.valueOf('G'), Block.thinGlass });
		// Replaces pipeItemsGold
		proxy.addCraftingRecipe(new ItemStack(Items.SteelPipeItem, 1), new Object[] { " G ", "GFG", " G ",
			Character.valueOf('F'), "pipeFrameSteel",
			Character.valueOf('G'), Block.thinGlass });
		// Replaces pipeItemsDiamond
		proxy.addCraftingRecipe(new ItemStack(Items.BlueSteelPipeItem, 1), new Object[] { " G ", "GFG", " G ",
			Character.valueOf('F'), "pipeFrameBlueSteel",
			Character.valueOf('G'), Block.thinGlass });
		// Replaces pipeItemsEmerald
		proxy.addCraftingRecipe(new ItemStack(Items.RedSteelPipeItem, 1), new Object[] { " G ", "GFG", " G ",
			Character.valueOf('F'), "pipeFrameRedSteel",
			Character.valueOf('G'), Block.thinGlass });
		// Replaces pipeItemsVoid
		proxy.addCraftingRecipe(new ItemStack(Items.BlackBronzePipeItem, 1), new Object[] { "RG ", "GFG", " GR",
			Character.valueOf('F'), "pipeFrameBlackBronze",
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('R'), Item.redstone });
		proxy.addCraftingRecipe(new ItemStack(Items.BlackBronzePipeItem, 1), new Object[] { " GR", "GFG", "RG ",
			Character.valueOf('F'), "pipeFrameBlackBronze",
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('R'), Item.redstone });
		// Replaces pipeItemsSandstone
		proxy.addCraftingRecipe(new ItemStack(Items.RoseGoldPipeItem, 1), new Object[] { " G ", "GFG", " G ",
			Character.valueOf('F'), "pipeFrameRoseGold",
			Character.valueOf('G'), Block.thinGlass });
		// Replaces pipeItemsObsidian
		proxy.addCraftingRecipe(new ItemStack(Items.BlackSteelPipeItem, 1), new Object[] { " G ", "GFG", " G ",
			Character.valueOf('F'), "pipeFrameBlackSteel",
			Character.valueOf('G'), Block.thinGlass });
		// Replaces pipeItemsDaizuli
		proxy.addCraftingRecipe(new ItemStack(Items.SterlingSilverPipeItem, 1), new Object[] { " G ", "GFG", " G ",
			Character.valueOf('F'), "pipeFrameSterlingSilver",
			Character.valueOf('G'), Block.thinGlass });
		// Replaces pipeItemsLapis
		proxy.addCraftingRecipe(new ItemStack(Items.BrassPipeItem, 1), new Object[] { " G ", "GFG", " G ",
			Character.valueOf('F'), "pipeFrameBrass",
			Character.valueOf('G'), Block.thinGlass });
		//TODO
		// Replaces pipeItemsQuartz
		//proxy.addCraftingRecipe(new ItemStack(Items.????PipeItem, 1), new Object[] { " G ", "GFG", " G ",
		//	Character.valueOf('F'), "pipeFrame????",
		//	Character.valueOf('G'), Block.thinGlass });
		// Replaces pipeItemsEmzuli
		//proxy.addCraftingRecipe(new ItemStack(Items.????PipeItem, 1), new Object[] { " G ", "GFG", " G ",
		//	Character.valueOf('F'), "pipeFrame????",
		//	Character.valueOf('G'), Block.thinGlass });

		// =================Structure Pipes========================
		// Replaces pipeStructureCobblestone
		proxy.addCraftingRecipe(new ItemStack(Items.LeadPipeStructureItem, 1), new Object[] { " G ", "GFG", " GR",
			Character.valueOf('F'), "pipeFrameLead",
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('R'), Block.gravel });
		proxy.addCraftingRecipe(new ItemStack(Items.LeadPipeStructureItem, 1), new Object[] { " G ", "GFG", "RG ",
			Character.valueOf('F'), "pipeFrameLead",
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('R'), Block.gravel });
		proxy.addCraftingRecipe(new ItemStack(Items.LeadPipeStructureItem, 1), new Object[] { " GR", "GFG", " G ",
			Character.valueOf('F'), "pipeFrameLead",
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('R'), Block.gravel });
		proxy.addCraftingRecipe(new ItemStack(Items.LeadPipeStructureItem, 1), new Object[] { "RG ", "GFG", " G ",
			Character.valueOf('F'), "pipeFrameLead",
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('R'), Block.gravel });

		// =================Waterproof Pipes========================
		// Replaces pipeFluidsWood
		proxy.addCraftingRecipe(new ItemStack(Items.TinPipeFluidsItem, 1), new Object[] { "WGW", "GFG", "WGW",
			Character.valueOf('F'), "pipeFrameTin",
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('W'), "rubberGreen" });
		// Replaces pipeFluidsCobblestone
		proxy.addCraftingRecipe(new ItemStack(Items.LeadPipeFluidsItem, 1), new Object[] { "WGW", "GFG", "WGW",
			Character.valueOf('F'), "pipeFrameLead",
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('W'), "rubberGreen" });
		// Replaces pipeFluidsStone
		proxy.addCraftingRecipe(new ItemStack(Items.BronzePipeFluidsItem, 1), new Object[] { "WGW", "GFG", "WGW",
			Character.valueOf('F'), "pipeFrameBronze",
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('W'), "rubberGreen" });
		// Replaces pipeFluidsIron
		proxy.addCraftingRecipe(new ItemStack(Items.WroughtIronPipeFluidsItem, 1), new Object[] { "WGW", "GFG", "WGW",
			Character.valueOf('F'), "pipeFrameWroughtIron",
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('W'), "rubberGreen" });
		// Replaces pipeFluidsGold
		proxy.addCraftingRecipe(new ItemStack(Items.SteelPipeFluidsItem, 1), new Object[] { "WGW", "GFG", "WGW",
			Character.valueOf('F'), "pipeFrameSteel",
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('W'), "rubberGreen" });
		// Replaces pipeFluidsEmerald
		proxy.addCraftingRecipe(new ItemStack(Items.RedSteelPipeFluidsItem, 1), new Object[] { "WGW", "GFG", "WGW",
			Character.valueOf('F'), "pipeFrameRedSteel",
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('W'), "rubberGreen" });
		// Replaces pipeFluidsVoid
		proxy.addCraftingRecipe(new ItemStack(Items.BlackBronzePipeFluidsItem, 1), new Object[] { "RGW", "GFG", "WGR",
			Character.valueOf('F'), "pipeFrameBlackBronze",
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('W'), "rubberGreen",
			Character.valueOf('R'), Item.redstone });
		proxy.addCraftingRecipe(new ItemStack(Items.BlackBronzePipeFluidsItem, 1), new Object[] { "WGR", "GFG", "RGW",
			Character.valueOf('F'), "pipeFrameBlackBronze",
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('W'), "rubberGreen",
			Character.valueOf('R'), Item.redstone });
		// Replaces pipeFluidsSandstone
		proxy.addCraftingRecipe(new ItemStack(Items.RoseGoldPipeFluidsItem, 1), new Object[] { "WGW", "GFG", "WGW",
			Character.valueOf('F'), "pipeFrameRoseGold",
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('W'), "rubberGreen" });

		// =================Power Pipes========================
		// pipePowerCobblestone 8 MJ/t
		proxy.addCraftingRecipe(new ItemStack(Items.CopperPipePowerItem, 1), new Object[] { "WGW", "GFG", "WGW",
			Character.valueOf('F'), "pipeFrameCopper",
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('W'), Item.redstone });
		// pipePowerStone 16 MJ/t
		proxy.addCraftingRecipe(new ItemStack(Items.RoseGoldPipePowerItem, 1), new Object[] { "WGW", "GFG", "WGW",
			Character.valueOf('F'), "pipeFrameRoseGold",
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('W'), Item.redstone });
		// pipePowerWood 32 MJ/t
		proxy.addCraftingRecipe(new ItemStack(Items.BlackBronzePipePowerItem, 1), new Object[] { "WGW", "GFG", "WGW",
			Character.valueOf('F'), "pipeFrameBlackBronze",
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('W'), Item.redstone });
		// pipePowerQuartz 64 MJ/t
		proxy.addCraftingRecipe(new ItemStack(Items.WroughtIronPipePowerItem, 1), new Object[] { "WGW", "GFG", "WGW",
			Character.valueOf('F'), "pipeFrameWroughtIron",
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('W'), Item.redstone });
		// pipePowerIron 128 MJ/t
		proxy.addCraftingRecipe(new ItemStack(Items.SteelPipePowerItem, 1), new Object[] { "WGW", "GFG", "WGW",
			Character.valueOf('F'), "pipeFrameSteel",
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('W'), Item.redstone });
		// pipePowerGold 256 MJ/t
		proxy.addCraftingRecipe(new ItemStack(Items.PlatinumPipePowerItem, 1), new Object[] { "WGW", "GFG", "WGW",
			Character.valueOf('F'), "pipeFramePlatinum",
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('W'), Item.redstone });
		// pipePowerDiamond 1024 MJ/t
		proxy.addCraftingRecipe(new ItemStack(Items.SilverPipePowerItem, 1), new Object[] { "WGW", "GFG", "WGW",
			Character.valueOf('F'), "pipeFrameSilver",
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('W'), Item.redstone });


		// ===================Engines=====================
		// Mechanical
		proxy.addCraftingRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 0), new Object[] { "WWW", " S ", "GPG",
			Character.valueOf('W'), TFCBlocks.Planks,
			Character.valueOf('S'), Block.glass,
			Character.valueOf('G'), "gearBismuthBronze",
			Character.valueOf('P'), Block.pistonBase });
		proxy.addCraftingRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 0), new Object[] { "WWW", " S ", "GPG",
			Character.valueOf('W'), TFCBlocks.Planks,
			Character.valueOf('S'), Block.glass,
			Character.valueOf('G'), "gearBlackBronze",
			Character.valueOf('P'), Block.pistonBase });
		proxy.addCraftingRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 0), new Object[] { "WWW", " S ", "GPG",
			Character.valueOf('W'), TFCBlocks.Planks,
			Character.valueOf('S'), Block.glass,
			Character.valueOf('G'), "gearBronze",
			Character.valueOf('P'), Block.pistonBase });
		proxy.addCraftingRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 0), new Object[] { "WWW", " S ", "GPG",
			Character.valueOf('W'), TFCBlocks.Planks,
			Character.valueOf('S'), Block.glass,
			Character.valueOf('G'), "gearCopper",
			Character.valueOf('P'), Block.pistonBase });
		proxy.addCraftingRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 0), new Object[] { "WWW", " S ", "GPG",
			Character.valueOf('W'), TFCBlocks.Planks2,
			Character.valueOf('S'), Block.glass,
			Character.valueOf('G'), "gearBismuthBronze",
			Character.valueOf('P'), Block.pistonBase });
		proxy.addCraftingRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 0), new Object[] { "WWW", " S ", "GPG",
			Character.valueOf('W'), TFCBlocks.Planks2,
			Character.valueOf('S'), Block.glass,
			Character.valueOf('G'), "gearBlackBronze",
			Character.valueOf('P'), Block.pistonBase });
		proxy.addCraftingRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 0), new Object[] { "WWW", " S ", "GPG",
			Character.valueOf('W'), TFCBlocks.Planks2,
			Character.valueOf('S'), Block.glass,
			Character.valueOf('G'), "gearBronze",
			Character.valueOf('P'), Block.pistonBase });
		proxy.addCraftingRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 0), new Object[] { "WWW", " S ", "GPG",
			Character.valueOf('W'), TFCBlocks.Planks2,
			Character.valueOf('S'), Block.glass,
			Character.valueOf('G'), "gearCopper",
			Character.valueOf('P'), Block.pistonBase });
		// Steam
		proxy.addCraftingRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 1), new Object[] { "WWW", " S ", "GPG",
			Character.valueOf('W'), TFCBlocks.StoneIgInCobble,
			Character.valueOf('S'), Block.glass,
			Character.valueOf('G'), "gearWroughtIron",
			Character.valueOf('P'), Block.pistonBase });
		proxy.addCraftingRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 1), new Object[] { "WWW", " S ", "GPG",
			Character.valueOf('W'), TFCBlocks.StoneIgExCobble,
			Character.valueOf('S'), Block.glass,
			Character.valueOf('G'), "gearWroughtIron",
			Character.valueOf('P'), Block.pistonBase });
		proxy.addCraftingRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 1), new Object[] { "WWW", " S ", "GPG",
			Character.valueOf('W'), TFCBlocks.StoneSedCobble,
			Character.valueOf('S'), Block.glass,
			Character.valueOf('G'), "gearWroughtIron",
			Character.valueOf('P'), Block.pistonBase });
		proxy.addCraftingRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 1), new Object[] { "WWW", " S ", "GPG",
			Character.valueOf('W'), TFCBlocks.StoneMMCobble,
			Character.valueOf('S'), Block.glass,
			Character.valueOf('G'), "gearWroughtIron",
			Character.valueOf('P'), Block.pistonBase });
		// Combustion
		proxy.addCraftingRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 2), new Object[] { "WWW", " S ", "GPG",
			Character.valueOf('W'), TFCItems.WroughtIronIngot,
			Character.valueOf('S'), Block.glass,
			Character.valueOf('G'), "gearSteel",
			Character.valueOf('P'), Block.pistonBase });

		// ==================Machines==========================
		if (BuildCraftFactory.allowMining)
		{
			// AutoWorkbench
			proxy.addCraftingRecipe(new ItemStack(BuildCraftFactory.autoWorkbenchBlock), new Object[] {"pgp", "gcg", "pgp",
				Character.valueOf('c'), Block.chest,
				Character.valueOf('p'), "plankWood",
				Character.valueOf('g'), "gearBismuthBronze" });
			proxy.addCraftingRecipe(new ItemStack(BuildCraftFactory.autoWorkbenchBlock), new Object[] {"pgp", "gcg", "pgp",
				Character.valueOf('c'), Block.chest,
				Character.valueOf('p'), "plankWood",
				Character.valueOf('g'), "gearBlackBronze" });
			proxy.addCraftingRecipe(new ItemStack(BuildCraftFactory.autoWorkbenchBlock), new Object[] {"pgp", "gcg", "pgp",
				Character.valueOf('c'), Block.chest,
				Character.valueOf('p'), "plankWood",
				Character.valueOf('g'), "gearBronze" });
			proxy.addCraftingRecipe(new ItemStack(BuildCraftFactory.autoWorkbenchBlock), new Object[] {"pgp", "gcg", "pgp",
				Character.valueOf('c'), Block.chest,
				Character.valueOf('p'), "plankWood",
				Character.valueOf('g'), "gearCopper" });
			// Mining Well
			proxy.addCraftingRecipe(new ItemStack(BuildCraftFactory.miningWellBlock, 1), new Object[] { "ipi", "igi", "iki",
				Character.valueOf('p'), Item.redstone,
				Character.valueOf('i'), TFCItems.SteelIngot,
				Character.valueOf('g'), "gearSteel",
				Character.valueOf('k'), TFCItems.SteelPick });
			// Quarry
			proxy.addCraftingRecipe(new ItemStack(BuildCraftFactory.quarryBlock), new Object[] { "ipi", "gig", "dkd",
				Character.valueOf('i'), "gearSteel",
				Character.valueOf('p'), Item.redstone,
				Character.valueOf('g'), "gearBlackSteel",
				Character.valueOf('d'), "gearBlueSteel",
				Character.valueOf('k'), TFCItems.BlueSteelPick });
			proxy.addCraftingRecipe(new ItemStack(BuildCraftFactory.quarryBlock), new Object[] { "ipi", "gig", "dkd",
				Character.valueOf('i'), "gearSteel",
				Character.valueOf('p'), Item.redstone,
				Character.valueOf('g'), "gearBlackSteel",
				Character.valueOf('d'), "gearRedSteel",
				Character.valueOf('k'), TFCItems.RedSteelPick });
		}
		else
		{
			// Pump
			proxy.addCraftingRecipe(new ItemStack(BuildCraftFactory.pumpBlock), new Object[] { "iri", "iTi", "gpg",
				Character.valueOf('r'), Item.redstone,
				Character.valueOf('i'), TFCItems.SteelIngot,
				Character.valueOf('T'), BuildCraftFactory.tankBlock,
				Character.valueOf('g'), "gearSteel",
				Character.valueOf('p'), Items.SteelPipeFluidsItem });
		}

		// Refinery
		proxy.addCraftingRecipe(new ItemStack(BuildCraftFactory.refineryBlock), new Object[] { "   ", "RTR", "TGT",
			Character.valueOf('T'), BuildCraftFactory.tankBlock,
			Character.valueOf('G'), "gearBlueSteel",
			Character.valueOf('R'), Block.torchRedstoneActive });
		proxy.addCraftingRecipe(new ItemStack(BuildCraftFactory.refineryBlock), new Object[] { "   ", "RTR", "TGT",
			Character.valueOf('T'), BuildCraftFactory.tankBlock,
			Character.valueOf('G'), "gearRedSteel",
			Character.valueOf('R'), Block.torchRedstoneActive });

		// Hopper
		if (BuildCraftFactory.hopperBlock != null)
		{
			proxy.addCraftingRecipe(new ItemStack(BuildCraftFactory.hopperBlock), new Object[] { "ICI", "IGI", " I ",
				Character.valueOf('I'), TFCItems.WroughtIronIngot,
				Character.valueOf('C'), Block.chest,
				Character.valueOf('G'), "gearWroughtIron" });
		}

		// FloodGate
		if (BuildCraftFactory.floodGateBlock != null)
		{
			proxy.addCraftingRecipe(new ItemStack(BuildCraftFactory.floodGateBlock), new Object[] { "IGI", "FTF", "IFI",
				Character.valueOf('I'), TFCItems.WroughtIronIngot,
				Character.valueOf('T'), BuildCraftFactory.tankBlock != null ? BuildCraftFactory.tankBlock : Block.glass,
				Character.valueOf('G'), new ItemStack(Items.Gears, 1, 5),
				Character.valueOf('F'), Items.WroughtIronPipeFluidsItem });
		}

		// Filtered Buffer
		proxy.addCraftingRecipe(new ItemStack(BuildCraftTransport.filteredBufferBlock), new Object[] { "wdw", "wcw", "wpw",
			Character.valueOf('w'), "plankWood",
			Character.valueOf('d'), Items.BlueSteelPipeItem,
			Character.valueOf('c'), Block.chest,
			Character.valueOf('p'), Block.pistonBase});

		// ==================Builders==========================
		// Filler
		proxy.addCraftingRecipe(new ItemStack(BuildCraftBuilders.fillerBlock, 1), new Object[] { "btb", "ycy", "gsg",
			Character.valueOf('b'), new ItemStack(Item.dyePowder, 1, 0),
			Character.valueOf('t'), BuildCraftBuilders.markerBlock,
			Character.valueOf('y'), new ItemStack(Item.dyePowder, 1, 11),
			Character.valueOf('c'), BuildCraftFactory.autoWorkbenchBlock,
			Character.valueOf('g'), "gearBlackSteel",
			Character.valueOf('s'), Block.chest });

		// ==================Silicone==================
		proxy.addCraftingRecipe(new ItemStack(BuildCraftSilicon.laserBlock), new Object[] { "ORR", "DDR", "ORR",
			Character.valueOf('O'), Block.obsidian,
			Character.valueOf('R'), Item.redstone,
			Character.valueOf('D'), new ItemStack(TFCItems.GemDiamond, 1, 2), });
		proxy.addCraftingRecipe(new ItemStack(BuildCraftSilicon.assemblyTableBlock, 1, 0), new Object[] { "ORO", "ODO", "OGO",
			Character.valueOf('O'), Block.obsidian,
			Character.valueOf('R'), Item.redstone,
			Character.valueOf('D'), new ItemStack(TFCItems.GemDiamond, 1, 2),
			Character.valueOf('G'), "gearBlueSteel", });
		proxy.addCraftingRecipe(new ItemStack(BuildCraftSilicon.assemblyTableBlock, 1, 0), new Object[] { "ORO", "ODO", "OGO",
			Character.valueOf('O'), Block.obsidian,
			Character.valueOf('R'), Item.redstone,
			Character.valueOf('D'), new ItemStack(TFCItems.GemDiamond, 1, 2),
			Character.valueOf('G'), "gearRedSteel", });
		proxy.addCraftingRecipe(new ItemStack(BuildCraftSilicon.assemblyTableBlock, 1, 1), new Object[] { "OWO", "OCO", "ORO",
			Character.valueOf('O'), Block.obsidian,
			Character.valueOf('W'), BuildCraftFactory.autoWorkbenchBlock,
			Character.valueOf('C'), Block.chest,
			Character.valueOf('R'), new ItemStack(BuildCraftSilicon.redstoneChipset, 1, 0), });

		// / REDSTONE CHIPSETS
		AssemblyRecipe.assemblyRecipes.add(new AssemblyRecipe(new ItemStack[] { new ItemStack(Item.redstone), new ItemStack(TFCItems.WroughtIronIngot) }, 20000, new ItemStack(BuildCraftSilicon.redstoneChipset, 1, 1)));
		AssemblyRecipe.assemblyRecipes.add(new AssemblyRecipe(new ItemStack[] { new ItemStack(Item.redstone), new ItemStack(TFCItems.GoldIngot) }, 40000, new ItemStack(BuildCraftSilicon.redstoneChipset, 1, 2)));
		AssemblyRecipe.assemblyRecipes.add(new AssemblyRecipe(new ItemStack[] { new ItemStack(Item.redstone), new ItemStack(TFCItems.GemDiamond,1,2) }, 80000, new ItemStack(BuildCraftSilicon.redstoneChipset, 1, 3)));
		// PULSATING CHIPSETS
		AssemblyRecipe.assemblyRecipes.add(new AssemblyRecipe(new ItemStack[] { new ItemStack(Item.redstone), new ItemStack(TFCItems.GemEmerald,1,2) }, 40000, new ItemStack(BuildCraftSilicon.redstoneChipset, 2, 4)));

		// BC Wires
		AssemblyRecipe.assemblyRecipes.add(new AssemblyRecipe(new ItemStack[] { new ItemStack(Item.dyePowder, 1, 1), new ItemStack(Item.redstone, 1), new ItemStack(TFCItems.CopperIngot, 1) }, 500, new ItemStack(BuildCraftTransport.redPipeWire, 8)));
		AssemblyRecipe.assemblyRecipes.add(new AssemblyRecipe(new ItemStack[] { new ItemStack(Item.dyePowder, 1, 4), new ItemStack(Item.redstone, 1), new ItemStack(TFCItems.CopperIngot, 1) }, 500, new ItemStack(BuildCraftTransport.bluePipeWire, 8)));
		AssemblyRecipe.assemblyRecipes.add(new AssemblyRecipe(new ItemStack[] { new ItemStack(Item.dyePowder, 1, 2), new ItemStack(Item.redstone, 1), new ItemStack(TFCItems.CopperIngot, 1) }, 500, new ItemStack(BuildCraftTransport.greenPipeWire, 8)));
		AssemblyRecipe.assemblyRecipes.add(new AssemblyRecipe(new ItemStack[] { new ItemStack(Item.dyePowder, 1, 11), new ItemStack(Item.redstone, 1), new ItemStack(TFCItems.CopperIngot, 1) }, 500, new ItemStack(BuildCraftTransport.yellowPipeWire, 8)));

		// ==========Latex==========
		proxy.addCraftingRecipe(new ItemStack(Items.LatexBowl, 1), new Object[] { "fff", "fff", " b ",
			Character.valueOf('f'), Block.blocksList[37],
			Character.valueOf('b'), Item.bowlEmpty });
		proxy.addCraftingRecipe(new ItemStack(Items.Buckets, 1, 0), new Object[] { " f ", "fff", " b ",
			Character.valueOf('f'), "bowlLatex",
			Character.valueOf('b'), TFCItems.WoodenBucketEmpty });

		// ==========Rubber==========
		proxy.addCraftingRecipe(new ItemStack(Items.Rubber, 1, 15), new Object[] { "s", "b",
			Character.valueOf('s'), new ItemStack(TFCItems.Powder, 1, 3),
			Character.valueOf('b'), "bowlLatex" });
		proxy.addCraftingRecipe(new ItemStack(Items.Rubber, 4, 15), new Object[] { "s", "b",
			Character.valueOf('s'), new ItemStack(TFCItems.Powder, 1, 3),
			Character.valueOf('b'), "bucketLatex" });
		for(int i = 0; i < 16; i++)
		{
			proxy.addCraftingRecipe(new ItemStack(Items.Rubber, 1, i), new Object[] { "g", "s", "b",
				Character.valueOf('g'), new ItemStack(Item.dyePowder, 1 , i),
				Character.valueOf('s'), new ItemStack(TFCItems.Powder, 1, 3),
				Character.valueOf('b'), "bowlLatex" });
			proxy.addCraftingRecipe(new ItemStack(Items.Rubber, 4, i), new Object[] { "g", "s", "b",
				Character.valueOf('g'), new ItemStack(Item.dyePowder, 1 , i),
				Character.valueOf('s'), new ItemStack(TFCItems.Powder, 1, 3),
				Character.valueOf('b'), "bucketLatex" });
		}

		// ===============Vanilla Recipes==================
		// Vanilla Pistons
		proxy.addCraftingRecipe(new ItemStack(Block.pistonBase, 1), new Object[] { "www", "cic", "crc",
			Character.valueOf('w'), TFCBlocks.Planks,
			Character.valueOf('c'), TFCBlocks.StoneIgInCobble,
			Character.valueOf('i'), TFCItems.WroughtIronIngot,
			Character.valueOf('r'), Item.redstone });
		proxy.addCraftingRecipe(new ItemStack(Block.pistonBase, 1), new Object[] { "www", "cic", "crc",
			Character.valueOf('w'), TFCBlocks.Planks,
			Character.valueOf('c'), TFCBlocks.StoneIgExCobble,
			Character.valueOf('i'), TFCItems.WroughtIronIngot,
			Character.valueOf('r'), Item.redstone });
		proxy.addCraftingRecipe(new ItemStack(Block.pistonBase, 1), new Object[] { "www", "cic", "crc",
			Character.valueOf('w'), TFCBlocks.Planks,
			Character.valueOf('c'), TFCBlocks.StoneSedCobble,
			Character.valueOf('i'), TFCItems.WroughtIronIngot,
			Character.valueOf('r'), Item.redstone });
		proxy.addCraftingRecipe(new ItemStack(Block.pistonBase, 1), new Object[] { "www", "cic", "crc",
			Character.valueOf('w'), TFCBlocks.Planks,
			Character.valueOf('c'), TFCBlocks.StoneMMCobble,
			Character.valueOf('i'), TFCItems.WroughtIronIngot,
			Character.valueOf('r'), Item.redstone });
		proxy.addCraftingRecipe(new ItemStack(Block.pistonBase, 1), new Object[] { "www", "cic", "crc",
			Character.valueOf('w'), TFCBlocks.Planks2,
			Character.valueOf('c'), TFCBlocks.StoneIgInCobble,
			Character.valueOf('i'), TFCItems.WroughtIronIngot,
			Character.valueOf('r'), Item.redstone });
		proxy.addCraftingRecipe(new ItemStack(Block.pistonBase, 1), new Object[] { "www", "cic", "crc",
			Character.valueOf('w'), TFCBlocks.Planks2,
			Character.valueOf('c'), TFCBlocks.StoneIgExCobble,
			Character.valueOf('i'), TFCItems.WroughtIronIngot,
			Character.valueOf('r'), Item.redstone });
		proxy.addCraftingRecipe(new ItemStack(Block.pistonBase, 1), new Object[] { "www", "cic", "crc",
			Character.valueOf('w'), TFCBlocks.Planks2,
			Character.valueOf('c'), TFCBlocks.StoneSedCobble,
			Character.valueOf('i'), TFCItems.WroughtIronIngot,
			Character.valueOf('r'), Item.redstone });
		proxy.addCraftingRecipe(new ItemStack(Block.pistonBase, 1), new Object[] { "www", "cic", "crc",
			Character.valueOf('w'), TFCBlocks.Planks2,
			Character.valueOf('c'), TFCBlocks.StoneMMCobble,
			Character.valueOf('i'), TFCItems.WroughtIronIngot,
			Character.valueOf('r'), Item.redstone });
	}

	private static void removeBCRecipes()
	{
		// ========Remove BC Gear Recipes================
		RemoveRecipe(new ItemStack(BuildCraftCore.stoneGearItem));
		RemoveRecipe(new ItemStack(BuildCraftCore.woodenGearItem));
		RemoveRecipe(new ItemStack(BuildCraftCore.ironGearItem));
		RemoveRecipe(new ItemStack(BuildCraftCore.goldGearItem));
		RemoveRecipe(new ItemStack(BuildCraftCore.diamondGearItem));

		// =================Transport Pipes========================
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeItemsWood, 8));
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeItemsCobblestone, 8));
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeItemsStone, 8));
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeItemsIron, 8));
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeItemsGold, 8));
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeItemsDiamond, 8));
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeItemsEmerald, 8));
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeItemsVoid, 8));
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeItemsSandstone, 8));
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeItemsObsidian, 8));
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeItemsDaizuli, 8));
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeItemsLapis, 8));
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeItemsQuartz, 8));
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeItemsEmzuli, 8));

		// =================Structure Pipes========================
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeStructureCobblestone));

		// =================Waterproof Pipes========================
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeFluidsWood));
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeFluidsCobblestone));
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeFluidsStone));
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeFluidsIron));
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeFluidsGold));
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeFluidsEmerald));
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeFluidsVoid));
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeFluidsSandstone));

		// =================Power Pipes========================
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipePowerCobblestone));
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipePowerStone));
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipePowerWood));
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipePowerIron));
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipePowerQuartz));
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipePowerGold));
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipePowerDiamond));

		// ===================Engines=====================
		RemoveRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 0));
		RemoveRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 1));
		RemoveRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 2));

		// ==================Machines==========================
		if (BuildCraftFactory.allowMining)
		{
			RemoveRecipe(new ItemStack(BuildCraftFactory.autoWorkbenchBlock));
			RemoveRecipe(new ItemStack(BuildCraftFactory.miningWellBlock));
			RemoveRecipe(new ItemStack(BuildCraftFactory.quarryBlock));
		}
		else
		{
			RemoveRecipe(new ItemStack(BuildCraftFactory.pumpBlock));
		}
		RemoveRecipe(new ItemStack(BuildCraftFactory.refineryBlock));
		if (BuildCraftFactory.hopperBlock != null)
			RemoveRecipe(new ItemStack(BuildCraftFactory.hopperBlock));
		if (BuildCraftFactory.floodGateBlock != null)
			RemoveRecipe(new ItemStack(BuildCraftFactory.floodGateBlock));

		// ==================Builders==========================
		RemoveRecipe(new ItemStack(BuildCraftBuilders.fillerBlock));

		// ==================Silicone==================
		RemoveRecipe(new ItemStack(BuildCraftSilicon.laserBlock));
		RemoveRecipe(new ItemStack(BuildCraftSilicon.assemblyTableBlock, 1, 0));
		RemoveRecipe(new ItemStack(BuildCraftSilicon.assemblyTableBlock, 1, 1));

		// BC Wires
		AssemblyRecipe.assemblyRecipes.remove(new ItemStack(BuildCraftTransport.redPipeWire));
		AssemblyRecipe.assemblyRecipes.remove(new ItemStack(BuildCraftTransport.bluePipeWire));
		AssemblyRecipe.assemblyRecipes.remove(new ItemStack(BuildCraftTransport.greenPipeWire));
		AssemblyRecipe.assemblyRecipes.remove(new ItemStack(BuildCraftTransport.yellowPipeWire));
	}

	private static void RemoveRecipe(ItemStack resultItem)
	{
		List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
		for (int i = 0; i < recipes.size(); i++)
		{
			IRecipe tmpRecipe = recipes.get(i);
			if (tmpRecipe instanceof IRecipe)
			{
				IRecipe recipe = tmpRecipe;
				ItemStack recipeResult = recipe.getRecipeOutput();
				if (ItemStack.areItemStacksEqual(resultItem, recipeResult))
					recipes.remove(i--);
			}
		}
	}
}
