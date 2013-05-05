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
package mods.BCTFCcrossover.core;

import java.util.List;
import java.util.Random;

import mods.BCTFCcrossover.BCTFCcrossover;
import mods.BCTFCcrossover.Items;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import TFC.TFCBlocks;
import TFC.TFCItems;
import TFC.Core.AnvilCraftingManagerTFC;
import TFC.Core.AnvilRecipe;
import TFC.Core.AnvilReq;
import TFC.Core.CraftingManagerTFC;
import TFC.Enums.CraftingRuleEnum;
import buildcraft.BuildCraftBuilders;
import buildcraft.BuildCraftCore;
import buildcraft.BuildCraftEnergy;
import buildcraft.BuildCraftFactory;
import buildcraft.BuildCraftSilicon;
import buildcraft.BuildCraftTransport;
import buildcraft.api.filler.FillerManager;
import buildcraft.api.recipes.AssemblyRecipe;
import buildcraft.builders.FillerFillAll;
import buildcraft.builders.FillerFillPyramid;
import buildcraft.builders.FillerFillStairs;
import buildcraft.builders.FillerFillWalls;
import buildcraft.builders.FillerFlattener;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes {

	public static void loadRecipes() {
		// Scribing Table Recipes
		CraftingManagerTFC.getInstance().addRecipe(new ItemStack(Items.GearPlanItem, 1), new Object[] { "# # #"," ### ","## ##"," ### ","# # #",Character.valueOf('#'), TFCItems.Ink});
		CraftingManagerTFC.getInstance().addRecipe(new ItemStack(Items.WrenchPlanItem, 1), new Object[] { " # # "," ### ","  #  ","  #  ","  #  ",Character.valueOf('#'), TFCItems.Ink});
		CraftingManagerTFC.getInstance().addRecipe(new ItemStack(Items.PipeFramePlanItem, 1), new Object[] { "#####","##  #","# # #","#  ##","#####",Character.valueOf('#'), TFCItems.Ink});
		
		// ========Remove BC Gear Recipes================
		RemoveRecipe(new ItemStack(BuildCraftCore.stoneGearItem));
		RemoveRecipe(new ItemStack(BuildCraftCore.woodenGearItem));
		RemoveRecipe(new ItemStack(BuildCraftCore.ironGearItem));
		RemoveRecipe(new ItemStack(BuildCraftCore.goldGearItem));
		RemoveRecipe(new ItemStack(BuildCraftCore.diamondGearItem));
		
		// Anvil Recipes
		AnvilCraftingManagerTFC anvil = AnvilCraftingManagerTFC.getInstance();
		for(int i = 0; i < 5; i++) {
			Random R = new Random (192865717);
			//int dam = i * 5;
			
			// Not needed at the moment
//			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.BismuthIngot), new ItemStack(Items.gearPlanItem), 20 + R.nextInt(55),CraftingRuleEnum.PUNCHLAST, CraftingRuleEnum.BENDNOTLAST, CraftingRuleEnum.DRAWNOTLAST, false, AnvilReq.STONE, new ItemStack(Items.BismuthGearItem, 1, dam)));
//			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.TinIngot), new ItemStack(Items.gearPlanItem),20 + R.nextInt(55),CraftingRuleEnum.PUNCHLAST, CraftingRuleEnum.BENDNOTLAST, CraftingRuleEnum.DRAWNOTLAST, false, AnvilReq.STONE, new ItemStack(Items.TinGearItem, 1, dam)));
//			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.ZincIngot), new ItemStack(Items.gearPlanItem),20 + R.nextInt(55),CraftingRuleEnum.PUNCHLAST, CraftingRuleEnum.BENDNOTLAST, CraftingRuleEnum.DRAWNOTLAST, false, AnvilReq.STONE, new ItemStack(Items.ZincGearItem, 1, dam)));
//			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.CopperIngot), new ItemStack(Items.gearPlanItem),20 + R.nextInt(55),CraftingRuleEnum.PUNCHLAST, CraftingRuleEnum.BENDNOTLAST, CraftingRuleEnum.DRAWNOTLAST, false, AnvilReq.COPPER, new ItemStack(Items.CopperGearItem, 1, dam)));
			
			// Instead of Wood
			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.BismuthBronzeIngot), new ItemStack(Items.GearPlanItem),20 + R.nextInt(55),CraftingRuleEnum.PUNCHLAST, CraftingRuleEnum.BENDNOTLAST, CraftingRuleEnum.DRAWNOTLAST, false, AnvilReq.BISMUTHBRONZE, new ItemStack(Items.BismuthBronzeGearItem, 1)));
			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.BlackBronzeIngot), new ItemStack(Items.GearPlanItem),20 + R.nextInt(55),CraftingRuleEnum.PUNCHLAST, CraftingRuleEnum.BENDNOTLAST, CraftingRuleEnum.DRAWNOTLAST, false, AnvilReq.BLACKBRONZE, new ItemStack(Items.BlackBronzeGearItem, 1)));
			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.BronzeIngot), new ItemStack(Items.GearPlanItem),20 + R.nextInt(55),CraftingRuleEnum.PUNCHLAST, CraftingRuleEnum.BENDNOTLAST, CraftingRuleEnum.DRAWNOTLAST, false, AnvilReq.BRONZE, new ItemStack(Items.BronzeGearItem, 1)));
			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.RoseGoldIngot), new ItemStack(Items.GearPlanItem),20 + R.nextInt(55),CraftingRuleEnum.PUNCHLAST, CraftingRuleEnum.BENDNOTLAST, CraftingRuleEnum.DRAWNOTLAST, false, AnvilReq.BRONZE, new ItemStack(Items.RoseGoldGearItem, 1)));
			// Instead of Stone
			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.WroughtIronIngot), new ItemStack(Items.GearPlanItem),20 + R.nextInt(55),CraftingRuleEnum.PUNCHLAST, CraftingRuleEnum.BENDNOTLAST, CraftingRuleEnum.DRAWNOTLAST, false, AnvilReq.WROUGHTIRON, new ItemStack(Items.WroughtIronGearItem, 1)));
			// Instead of Iron
			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.SteelIngot), new ItemStack(Items.GearPlanItem),20 + R.nextInt(55),CraftingRuleEnum.PUNCHLAST, CraftingRuleEnum.BENDNOTLAST, CraftingRuleEnum.DRAWNOTLAST, false, AnvilReq.STEEL, new ItemStack(Items.SteelGearItem, 1)));
			// Instead of Gold
			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.BlackSteelIngot), new ItemStack(Items.GearPlanItem),20 + R.nextInt(55),CraftingRuleEnum.PUNCHLAST, CraftingRuleEnum.BENDNOTLAST, CraftingRuleEnum.DRAWNOTLAST, false, AnvilReq.BLACKSTEEL, new ItemStack(Items.BlackSteelGearItem, 1)));
			// Instead of Diamond
			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.BlueSteelIngot), new ItemStack(Items.GearPlanItem),20 + R.nextInt(55),CraftingRuleEnum.PUNCHLAST, CraftingRuleEnum.BENDNOTLAST, CraftingRuleEnum.DRAWNOTLAST, false, AnvilReq.BLUESTEEL, new ItemStack(Items.BlueSteelGearItem, 1)));
			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.RedSteelIngot), new ItemStack(Items.GearPlanItem),20 + R.nextInt(55),CraftingRuleEnum.PUNCHLAST, CraftingRuleEnum.BENDNOTLAST, CraftingRuleEnum.DRAWNOTLAST, false, AnvilReq.REDSTEEL, new ItemStack(Items.RedSteelGearItem, 1)));
			
			// Wrench
			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.WroughtIronIngot), new ItemStack(Items.WrenchPlanItem),20 + R.nextInt(55),CraftingRuleEnum.HITLAST, CraftingRuleEnum.DRAWSECONDFROMLAST, CraftingRuleEnum.BENDTHIRDFROMLAST, false, AnvilReq.WROUGHTIRON, new ItemStack(BuildCraftCore.wrenchItem, 1)));
			
			// Anvil Pipe Frames
			anvil.addRecipe(new MultiItemAnvilRecipe(new ItemStack(TFCItems.TinSheet), new ItemStack(Items.PipeFramePlanItem),40 + R.nextInt(35),CraftingRuleEnum.HITLAST, CraftingRuleEnum.BENDSECONDFROMLAST, CraftingRuleEnum.BENDTHIRDFROMLAST, false, AnvilReq.STONE, new ItemStack(Items.TinPipeFrameItem, 8)));
			anvil.addRecipe(new MultiItemAnvilRecipe(new ItemStack(TFCItems.LeadSheet), new ItemStack(Items.PipeFramePlanItem),40 + R.nextInt(35),CraftingRuleEnum.HITLAST, CraftingRuleEnum.BENDSECONDFROMLAST, CraftingRuleEnum.BENDTHIRDFROMLAST, false, AnvilReq.COPPER, new ItemStack(Items.LeadPipeFrameItem, 8)));
			anvil.addRecipe(new MultiItemAnvilRecipe(new ItemStack(TFCItems.BronzeSheet), new ItemStack(Items.PipeFramePlanItem),40 + R.nextInt(35),CraftingRuleEnum.HITLAST, CraftingRuleEnum.BENDSECONDFROMLAST, CraftingRuleEnum.BENDTHIRDFROMLAST, false, AnvilReq.COPPER, new ItemStack(Items.BronzePipeFrameItem, 8)));
			anvil.addRecipe(new MultiItemAnvilRecipe(new ItemStack(TFCItems.WroughtIronSheet), new ItemStack(Items.PipeFramePlanItem),40 + R.nextInt(35),CraftingRuleEnum.HITLAST, CraftingRuleEnum.BENDSECONDFROMLAST, CraftingRuleEnum.BENDTHIRDFROMLAST, false, AnvilReq.BRONZE, new ItemStack(Items.WroughtIronPipeFrameItem, 8)));
			anvil.addRecipe(new MultiItemAnvilRecipe(new ItemStack(TFCItems.SteelSheet), new ItemStack(Items.PipeFramePlanItem),40 + R.nextInt(35),CraftingRuleEnum.HITLAST, CraftingRuleEnum.BENDSECONDFROMLAST, CraftingRuleEnum.BENDTHIRDFROMLAST, false, AnvilReq.WROUGHTIRON, new ItemStack(Items.SteelPipeFrameItem, 8)));
			anvil.addRecipe(new MultiItemAnvilRecipe(new ItemStack(TFCItems.BlueSteelSheet), new ItemStack(Items.PipeFramePlanItem),40 + R.nextInt(35),CraftingRuleEnum.HITLAST, CraftingRuleEnum.BENDSECONDFROMLAST, CraftingRuleEnum.BENDTHIRDFROMLAST, false, AnvilReq.BLACKSTEEL, new ItemStack(Items.BlueSteelPipeFrameItem, 8)));
			anvil.addRecipe(new MultiItemAnvilRecipe(new ItemStack(TFCItems.RedSteelSheet), new ItemStack(Items.PipeFramePlanItem),40 + R.nextInt(35),CraftingRuleEnum.HITLAST, CraftingRuleEnum.BENDSECONDFROMLAST, CraftingRuleEnum.BENDTHIRDFROMLAST, false, AnvilReq.BLACKSTEEL, new ItemStack(Items.RedSteelPipeFrameItem, 8)));
			anvil.addRecipe(new MultiItemAnvilRecipe(new ItemStack(TFCItems.BlackBronzeSheet), new ItemStack(Items.PipeFramePlanItem),40 + R.nextInt(35),CraftingRuleEnum.HITLAST, CraftingRuleEnum.BENDSECONDFROMLAST, CraftingRuleEnum.BENDTHIRDFROMLAST, false, AnvilReq.COPPER, new ItemStack(Items.BlackBronzePipeFrameItem, 8)));
			anvil.addRecipe(new MultiItemAnvilRecipe(new ItemStack(TFCItems.RoseGoldSheet), new ItemStack(Items.PipeFramePlanItem),40 + R.nextInt(35),CraftingRuleEnum.HITLAST, CraftingRuleEnum.BENDSECONDFROMLAST, CraftingRuleEnum.BENDTHIRDFROMLAST, false, AnvilReq.COPPER, new ItemStack(Items.RoseGoldPipeFrameItem, 8)));
			anvil.addRecipe(new MultiItemAnvilRecipe(new ItemStack(TFCItems.BlackSteelSheet), new ItemStack(Items.PipeFramePlanItem),40 + R.nextInt(35),CraftingRuleEnum.HITLAST, CraftingRuleEnum.BENDSECONDFROMLAST, CraftingRuleEnum.BENDTHIRDFROMLAST, false, AnvilReq.STEEL, new ItemStack(Items.BlackSteelPipeFrameItem, 8)));
			anvil.addRecipe(new MultiItemAnvilRecipe(new ItemStack(TFCItems.ZincSheet), new ItemStack(Items.PipeFramePlanItem),40 + R.nextInt(35),CraftingRuleEnum.HITLAST, CraftingRuleEnum.BENDSECONDFROMLAST, CraftingRuleEnum.BENDTHIRDFROMLAST, false, AnvilReq.STONE, new ItemStack(Items.ZincPipeFrameItem, 8)));
			anvil.addRecipe(new MultiItemAnvilRecipe(new ItemStack(TFCItems.CopperSheet), new ItemStack(Items.PipeFramePlanItem),40 + R.nextInt(35),CraftingRuleEnum.HITLAST, CraftingRuleEnum.BENDSECONDFROMLAST, CraftingRuleEnum.BENDTHIRDFROMLAST, false, AnvilReq.STONE, new ItemStack(Items.CopperPipeFrameItem, 8)));
			anvil.addRecipe(new MultiItemAnvilRecipe(new ItemStack(TFCItems.SilverSheet), new ItemStack(Items.PipeFramePlanItem),40 + R.nextInt(35),CraftingRuleEnum.HITLAST, CraftingRuleEnum.BENDSECONDFROMLAST, CraftingRuleEnum.BENDTHIRDFROMLAST, false, AnvilReq.COPPER, new ItemStack(Items.SilverPipeFrameItem, 8)));
		}

		// =================Transport Pipes========================
		// Tin replaces Wood
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeItemsWood));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.TinPipeItem, 1), new Object[] { " G ", "GFG", " G ",
			Character.valueOf('F'), Items.TinPipeFrameItem,
			Character.valueOf('G'), Block.thinGlass });
		// Replaces pipeItemsCobblestone
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeItemsCobblestone));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.LeadPipeItem, 1), new Object[] { " G ", "GFG", " G ",
			Character.valueOf('F'), Items.LeadPipeFrameItem,
			Character.valueOf('G'), Block.thinGlass });
		// Replaces pipeItemsStone
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeItemsStone));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.BronzePipeItem, 1), new Object[] { " G ", "GFG", " G ",
			Character.valueOf('F'), Items.BronzePipeFrameItem,
			Character.valueOf('G'), Block.thinGlass });
		// Replaces pipeItemsIron
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeItemsIron));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.WroughtIronPipeItem, 1), new Object[] { " G ", "GFG", " G ",
			Character.valueOf('F'), Items.WroughtIronPipeFrameItem,
			Character.valueOf('G'), Block.thinGlass });
		// Replaces pipeItemsGold
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeItemsGold));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.SteelPipeItem, 1), new Object[] { " G ", "GFG", " G ",
			Character.valueOf('F'), Items.SteelPipeFrameItem,
			Character.valueOf('G'), Block.thinGlass });
		// Replaces pipeItemsDiamond
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeItemsDiamond));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.BlueSteelPipeItem, 1), new Object[] { " G ", "GFG", " G ",
			Character.valueOf('F'), Items.BlueSteelPipeFrameItem,
			Character.valueOf('G'), Block.thinGlass });
		// Replaces pipeItemsEmerald
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeItemsEmerald));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.RedSteelPipeItem, 1), new Object[] { " G ", "GFG", " G ",
			Character.valueOf('F'), Items.RedSteelPipeFrameItem,
			Character.valueOf('G'), Block.thinGlass });
		// Replaces pipeItemsVoid
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeItemsVoid));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.BlackBronzePipeItem, 1), new Object[] { "RG ", "GFG", " GR",
			Character.valueOf('F'), Items.BlackBronzePipeFrameItem,
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('R'), Item.redstone });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.BlackBronzePipeItem, 1), new Object[] { " GR", "GFG", "RG ",
			Character.valueOf('F'), Items.BlackBronzePipeFrameItem,
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('R'), Item.redstone });
		// Replaces pipeItemsSandstone
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeItemsSandstone));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.RoseGoldPipeItem, 1), new Object[] { " G ", "GFG", " G ",
			Character.valueOf('F'), Items.RoseGoldPipeFrameItem,
			Character.valueOf('G'), Block.thinGlass });
		// Replaces pipeItemsObsidian
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeItemsObsidian));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.BlackSteelPipeItem, 1), new Object[] { " G ", "GFG", " G ",
			Character.valueOf('F'), Items.BlackSteelPipeFrameItem,
			Character.valueOf('G'), Block.thinGlass });
		
		// =================Structure Pipes========================
		// Replaces pipeStructureCobblestone
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeStructureCobblestone));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.LeadPipeStructureItem, 1), new Object[] { " G ", "GFG", " GR",
			Character.valueOf('F'), Items.LeadPipeFrameItem,
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('R'), Block.gravel });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.LeadPipeStructureItem, 1), new Object[] { " G ", "GFG", "RG ",
			Character.valueOf('F'), Items.LeadPipeFrameItem,
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('R'), Block.gravel });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.LeadPipeStructureItem, 1), new Object[] { " GR", "GFG", " G ",
			Character.valueOf('F'), Items.LeadPipeFrameItem,
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('R'), Block.gravel });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.LeadPipeStructureItem, 1), new Object[] { "RG ", "GFG", " G ",
			Character.valueOf('F'), Items.LeadPipeFrameItem,
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('R'), Block.gravel });

		// =================Waterproof Pipes========================
		// Replaces pipeLiquidsWood
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeLiquidsWood));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.TinPipeLiquidsItem, 1), new Object[] { "WGW", "GFG", "WGW",
			Character.valueOf('F'), Items.TinPipeFrameItem,
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('W'), BuildCraftTransport.pipeWaterproof });
		// Replaces pipeLiquidsCobblestone
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeLiquidsCobblestone));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.LeadPipeLiquidsItem, 1), new Object[] { "WGW", "GFG", "WGW",
			Character.valueOf('F'), Items.LeadPipeFrameItem,
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('W'), BuildCraftTransport.pipeWaterproof });
		// Replaces pipeLiquidsStone
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeLiquidsStone));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.BronzePipeLiquidsItem, 1), new Object[] { "WGW", "GFG", "WGW",
			Character.valueOf('F'), Items.BronzePipeFrameItem,
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('W'), BuildCraftTransport.pipeWaterproof });
		// Replaces pipeLiquidsIron
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeLiquidsIron));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.WroughtIronPipeLiquidsItem, 1), new Object[] { "WGW", "GFG", "WGW",
			Character.valueOf('F'), Items.WroughtIronPipeFrameItem,
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('W'), BuildCraftTransport.pipeWaterproof });
		// Replaces pipeLiquidsGold
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeLiquidsGold));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.SteelPipeLiquidsItem, 1), new Object[] { "WGW", "GFG", "WGW",
			Character.valueOf('F'), Items.SteelPipeFrameItem,
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('W'), BuildCraftTransport.pipeWaterproof });
		// Replaces pipeLiquidsEmerald
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeLiquidsEmerald));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.RedSteelPipeLiquidsItem, 1), new Object[] { "WGW", "GFG", "WGW",
			Character.valueOf('F'), Items.RedSteelPipeFrameItem,
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('W'), BuildCraftTransport.pipeWaterproof });
		// Replaces pipeLiquidsVoid
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeLiquidsVoid));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.BlackBronzePipeLiquidsItem, 1), new Object[] { "RGW", "GFG", "WGR",
			Character.valueOf('F'), Items.BlackBronzePipeFrameItem,
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('W'), BuildCraftTransport.pipeWaterproof,
			Character.valueOf('R'), Item.redstone });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.BlackBronzePipeLiquidsItem, 1), new Object[] { "WGR", "GFG", "RGW",
			Character.valueOf('F'), Items.BlackBronzePipeFrameItem,
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('W'), BuildCraftTransport.pipeWaterproof,
			Character.valueOf('R'), Item.redstone });
		// Replaces pipeLiquidsSandstone
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipeLiquidsSandstone));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.RoseGoldPipeLiquidsItem, 1), new Object[] { "WGW", "GFG", "WGW",
			Character.valueOf('F'), Items.RoseGoldPipeFrameItem,
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('W'), BuildCraftTransport.pipeWaterproof });

		// =================Power Pipes========================
		// Tin Conductive Pipe replaces Wood Conductive Pipe
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipePowerWood));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.TinPipePowerItem, 1), new Object[] { "WGW", "GFG", "WGW",
			Character.valueOf('F'), Items.TinPipeFrameItem,
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('W'), Item.redstone });
		// Zinc Conductive Pipe replaces Stone Conductive Pipe
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipePowerStone));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.ZincPipePowerItem, 1), new Object[] { "WGW", "GFG", "WGW",
			Character.valueOf('F'), Items.ZincPipeFrameItem,
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('W'), Item.redstone });
		// Copper Conductive Pipe replaces Gold Conductive Pipe
		RemoveRecipe(new ItemStack(BuildCraftTransport.pipePowerGold));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.CopperPipePowerItem, 1), new Object[] { "WGW", "GFG", "WGW",
			Character.valueOf('F'), Items.CopperPipeFrameItem,
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('W'), Item.redstone });
		// NEW better conductivity then Copper
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Items.SilverPipePowerItem, 1), new Object[] { "WGW", "GFG", "WGW",
			Character.valueOf('F'), Items.SilverPipeFrameItem,
			Character.valueOf('G'), Block.thinGlass,
			Character.valueOf('W'), Item.redstone });
		
		// ===================Engines=====================
		// Mechanical
		RemoveRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 0));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 0), new Object[] { "WWW", " S ", "GPG",
			Character.valueOf('W'), TFCBlocks.Planks,
			Character.valueOf('S'), Block.glass,
			Character.valueOf('G'), Items.BismuthBronzeGearItem,
			Character.valueOf('P'), Block.pistonBase });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 0), new Object[] { "WWW", " S ", "GPG",
			Character.valueOf('W'), TFCBlocks.Planks,
			Character.valueOf('S'), Block.glass,
			Character.valueOf('G'), Items.BlackBronzeGearItem,
			Character.valueOf('P'), Block.pistonBase });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 0), new Object[] { "WWW", " S ", "GPG",
			Character.valueOf('W'), TFCBlocks.Planks,
			Character.valueOf('S'), Block.glass,
			Character.valueOf('G'), Items.BronzeGearItem,
			Character.valueOf('P'), Block.pistonBase });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 0), new Object[] { "WWW", " S ", "GPG",
			Character.valueOf('W'), TFCBlocks.Planks,
			Character.valueOf('S'), Block.glass,
			Character.valueOf('G'), Items.RoseGoldGearItem,
			Character.valueOf('P'), Block.pistonBase });
		// Steam
		RemoveRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 1));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 1), new Object[] { "WWW", " S ", "GPG",
			Character.valueOf('W'), TFCBlocks.StoneIgInCobble,
			Character.valueOf('S'), Block.glass,
			Character.valueOf('G'), Items.WroughtIronGearItem,
			Character.valueOf('P'), Block.pistonBase });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 1), new Object[] { "WWW", " S ", "GPG",
			Character.valueOf('W'), TFCBlocks.StoneIgExCobble,
			Character.valueOf('S'), Block.glass,
			Character.valueOf('G'), Items.WroughtIronGearItem,
			Character.valueOf('P'), Block.pistonBase });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 1), new Object[] { "WWW", " S ", "GPG",
			Character.valueOf('W'), TFCBlocks.StoneSedCobble,
			Character.valueOf('S'), Block.glass,
			Character.valueOf('G'), Items.WroughtIronGearItem,
			Character.valueOf('P'), Block.pistonBase });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 1), new Object[] { "WWW", " S ", "GPG",
			Character.valueOf('W'), TFCBlocks.StoneMMCobble,
			Character.valueOf('S'), Block.glass,
			Character.valueOf('G'), Items.WroughtIronGearItem,
			Character.valueOf('P'), Block.pistonBase });
		// Combustion
		RemoveRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 2));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 2), new Object[] { "WWW", " S ", "GPG",
			Character.valueOf('W'), TFCItems.WroughtIronIngot,
			Character.valueOf('S'), Block.glass,
			Character.valueOf('G'), Items.SteelGearItem,
			Character.valueOf('P'), Block.pistonBase });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 2), new Object[] { "WWW", " S ", "GPG",
			Character.valueOf('W'), TFCItems.WroughtIronIngot,
			Character.valueOf('S'), Block.glass,
			Character.valueOf('G'), Items.SteelGearItem,
			Character.valueOf('P'), Block.pistonBase });
		
		// ==================Machines==========================
		// AutoWorkbench
		if (BuildCraftFactory.allowMining) {
			RemoveRecipe(new ItemStack(BuildCraftFactory.autoWorkbenchBlock));
			BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftFactory.autoWorkbenchBlock), new Object[] { " g ", "gwg", " g ",
				Character.valueOf('w'), Block.workbench,
				Character.valueOf('g'), Items.BismuthBronzeGearItem });
			BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftFactory.autoWorkbenchBlock), new Object[] { " g ", "gwg", " g ",
				Character.valueOf('w'), Block.workbench,
				Character.valueOf('g'), Items.BlackBronzeGearItem });
			BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftFactory.autoWorkbenchBlock), new Object[] { " g ", "gwg", " g ",
				Character.valueOf('w'), Block.workbench,
				Character.valueOf('g'), Items.BronzeGearItem });
			BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftFactory.autoWorkbenchBlock), new Object[] { " g ", "gwg", " g ",
				Character.valueOf('w'), Block.workbench,
				Character.valueOf('g'), Items.RoseGoldGearItem });
			// Mining Well
			RemoveRecipe(new ItemStack(BuildCraftFactory.miningWellBlock));
			BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftFactory.miningWellBlock, 1), new Object[] { "ipi", "igi", "iki",
				Character.valueOf('p'), Item.redstone,
				Character.valueOf('i'), TFCItems.SteelIngot,
				Character.valueOf('g'), Items.SteelGearItem,
				Character.valueOf('k'), TFCItems.SteelPick });
			// Quarry
			RemoveRecipe(new ItemStack(BuildCraftFactory.quarryBlock));
			BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftFactory.quarryBlock), new Object[] { "ipi", "gig", "dkd",
				Character.valueOf('i'), Items.SteelGearItem,
				Character.valueOf('p'), Item.redstone,
				Character.valueOf('g'), Items.BlackSteelGearItem,
				Character.valueOf('d'), Items.BlueSteelGearItem,
				Character.valueOf('k'), TFCItems.BlueSteelPick });
			BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftFactory.quarryBlock), new Object[] { "ipi", "gig", "dkd",
				Character.valueOf('i'), Items.SteelGearItem,
				Character.valueOf('p'), Item.redstone,
				Character.valueOf('g'), Items.BlackSteelGearItem,
				Character.valueOf('d'), Items.RedSteelGearItem,
				Character.valueOf('k'), TFCItems.RedSteelPick });
		} else {
			RemoveRecipe(new ItemStack(BuildCraftFactory.pumpBlock));
			BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftFactory.pumpBlock), new Object[] { "iri", "iTi", "gpg",
				Character.valueOf('r'), Item.redstone,
				Character.valueOf('i'), TFCItems.SteelIngot,
				Character.valueOf('T'), BuildCraftFactory.tankBlock,
				Character.valueOf('g'), Items.SteelGearItem,
				Character.valueOf('p'), BuildCraftTransport.pipeLiquidsGold });
		}

		// Refinery
		RemoveRecipe(new ItemStack(BuildCraftFactory.refineryBlock));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftFactory.refineryBlock), new Object[] { "   ", "RTR", "TGT",
			Character.valueOf('T'), BuildCraftFactory.tankBlock,
			Character.valueOf('G'), Items.BlueSteelGearItem,
			Character.valueOf('R'), Block.torchRedstoneActive });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftFactory.refineryBlock), new Object[] { "   ", "RTR", "TGT",
			Character.valueOf('T'), BuildCraftFactory.tankBlock,
			Character.valueOf('G'), Items.RedSteelGearItem,
			Character.valueOf('R'), Block.torchRedstoneActive });
		
		// Hopper
		if (!BuildCraftFactory.hopperDisabled) {
			RemoveRecipe(new ItemStack(BuildCraftFactory.hopperBlock));
			BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftFactory.hopperBlock), new Object[] { "ICI", "IGI", " I ",
				Character.valueOf('I'), TFCItems.WroughtIronIngot,
				Character.valueOf('C'), Block.chest,
				Character.valueOf('G'), Items.WroughtIronGearItem });
		}
		
		// ==================Builders==========================
		// Filler
		RemoveRecipe(new ItemStack(BuildCraftBuilders.fillerBlock));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftBuilders.fillerBlock, 1), new Object[] { "btb", "ycy", "gsg",
			Character.valueOf('b'), new ItemStack(Item.dyePowder, 1, 0),
			Character.valueOf('t'), BuildCraftBuilders.markerBlock,
			Character.valueOf('y'), new ItemStack(Item.dyePowder, 1, 11),
			Character.valueOf('c'), Block.workbench,
			Character.valueOf('g'), Items.BlackSteelGearItem,
			Character.valueOf('s'), Block.chest });
		// Builder
		RemoveRecipe(new ItemStack(BuildCraftBuilders.builderBlock));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftBuilders.builderBlock, 1), new Object[] { "btb", "ycy", "gsg",
			Character.valueOf('b'), new ItemStack(Item.dyePowder, 1, 0),
			Character.valueOf('t'), BuildCraftBuilders.markerBlock,
			Character.valueOf('y'), new ItemStack(Item.dyePowder, 1, 11),
			Character.valueOf('c'), Block.workbench,
			Character.valueOf('g'), Items.BlueSteelGearItem,
			Character.valueOf('s'), Block.chest });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftBuilders.builderBlock, 1), new Object[] { "btb", "ycy", "gsg",
			Character.valueOf('b'), new ItemStack(Item.dyePowder, 1, 0),
			Character.valueOf('t'), BuildCraftBuilders.markerBlock,
			Character.valueOf('y'), new ItemStack(Item.dyePowder, 1, 11),
			Character.valueOf('c'), Block.workbench,
			Character.valueOf('g'), Items.RedSteelGearItem,
			Character.valueOf('s'), Block.chest });
		// Architect
		RemoveRecipe(new ItemStack(BuildCraftBuilders.architectBlock));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftBuilders.architectBlock, 1), new Object[] { "btb", "ycy", "gsg",
			Character.valueOf('b'), new ItemStack(Item.dyePowder, 1, 0),
			Character.valueOf('t'), BuildCraftBuilders.markerBlock,
			Character.valueOf('y'), new ItemStack(Item.dyePowder, 1, 11),
			Character.valueOf('c'), Block.workbench,
			Character.valueOf('g'), Items.BlueSteelGearItem,
			Character.valueOf('s'), new ItemStack(BuildCraftBuilders.templateItem, 1) });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftBuilders.architectBlock, 1), new Object[] { "btb", "ycy", "gsg",
			Character.valueOf('b'), new ItemStack(Item.dyePowder, 1, 0),
			Character.valueOf('t'), BuildCraftBuilders.markerBlock,
			Character.valueOf('y'), new ItemStack(Item.dyePowder, 1, 11),
			Character.valueOf('c'), Block.workbench,
			Character.valueOf('g'), Items.RedSteelGearItem,
			Character.valueOf('s'), new ItemStack(BuildCraftBuilders.templateItem, 1) });
		// Library
		RemoveRecipe(new ItemStack(BuildCraftBuilders.libraryBlock));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftBuilders.libraryBlock, 1), new Object[] { "bbb", "bkb", "bbb",
			Character.valueOf('b'), new ItemStack(BuildCraftBuilders.blueprintItem),
			Character.valueOf('k'), Block.bookShelf });
		
		// ==================Filler Recipes======================
		for (int i = 0; i < 3; i++) {
			FillerManager.registry.addRecipe(new FillerFillAll(), new Object[] { "bbb", "bbb", "bbb",
				Character.valueOf('b'), new ItemStack(TFCBlocks.StoneIgInBrick, 1, i) });
			FillerManager.registry.addRecipe(new FillerFlattener(), new Object[] { "   ", "ggg", "bbb",
				Character.valueOf('g'), Block.glass,
				Character.valueOf('b'), new ItemStack(TFCBlocks.StoneIgInBrick, 1, i) });
			FillerManager.registry.addRecipe(new FillerFillWalls(), new Object[] { "bbb", "b b", "bbb",
				Character.valueOf('b'), new ItemStack(TFCBlocks.StoneIgInBrick, 1, i) });
			FillerManager.registry.addRecipe(new FillerFillPyramid(), new Object[] { "   ", " b ", "bbb",
				Character.valueOf('b'), new ItemStack(TFCBlocks.StoneIgInBrick, 1, i) });
			FillerManager.registry.addRecipe(new FillerFillStairs(), new Object[] { "  b", " bb", "bbb",
				Character.valueOf('b'), new ItemStack(TFCBlocks.StoneIgInBrick, 1, i) });
		}
		for (int i = 0; i < 4; i++) {
			FillerManager.registry.addRecipe(new FillerFillAll(), new Object[] { "bbb", "bbb", "bbb",
				Character.valueOf('b'), new ItemStack(TFCBlocks.StoneIgExBrick, 1, i) });
			FillerManager.registry.addRecipe(new FillerFlattener(), new Object[] { "   ", "ggg", "bbb",
				Character.valueOf('g'), Block.glass,
				Character.valueOf('b'), new ItemStack(TFCBlocks.StoneIgExBrick, 1, i) });
			FillerManager.registry.addRecipe(new FillerFillWalls(), new Object[] { "bbb", "b b", "bbb",
				Character.valueOf('b'), new ItemStack(TFCBlocks.StoneIgExBrick, 1, i) });
			FillerManager.registry.addRecipe(new FillerFillPyramid(), new Object[] { "   ", " b ", "bbb",
				Character.valueOf('b'), new ItemStack(TFCBlocks.StoneIgExBrick, 1, i) });
			FillerManager.registry.addRecipe(new FillerFillStairs(), new Object[] { "  b", " bb", "bbb",
				Character.valueOf('b'), new ItemStack(TFCBlocks.StoneIgExBrick, 1, i) });
		}
		for (int i = 0; i < 10; i++) {
			FillerManager.registry.addRecipe(new FillerFillAll(), new Object[] { "bbb", "bbb", "bbb",
				Character.valueOf('b'), new ItemStack(TFCBlocks.StoneSedBrick, 1, i) });
			FillerManager.registry.addRecipe(new FillerFlattener(), new Object[] { "   ", "ggg", "bbb",
				Character.valueOf('g'), Block.glass,
				Character.valueOf('b'), new ItemStack(TFCBlocks.StoneSedBrick, 1, i) });
			FillerManager.registry.addRecipe(new FillerFillWalls(), new Object[] { "bbb", "b b", "bbb",
				Character.valueOf('b'), new ItemStack(TFCBlocks.StoneSedBrick, 1, i) });
			FillerManager.registry.addRecipe(new FillerFillPyramid(), new Object[] { "   ", " b ", "bbb",
				Character.valueOf('b'), new ItemStack(TFCBlocks.StoneSedBrick, 1, i) });
			FillerManager.registry.addRecipe(new FillerFillStairs(), new Object[] { "  b", " bb", "bbb",
				Character.valueOf('b'), new ItemStack(TFCBlocks.StoneSedBrick, 1, i) });
		}
		for (int i = 0; i < 6; i++) {
			FillerManager.registry.addRecipe(new FillerFillAll(), new Object[] { "bbb", "bbb", "bbb",
				Character.valueOf('b'), new ItemStack(TFCBlocks.StoneMMBrick, 1, i) });
			FillerManager.registry.addRecipe(new FillerFlattener(), new Object[] { "   ", "ggg", "bbb",
				Character.valueOf('g'), Block.glass,
				Character.valueOf('b'), new ItemStack(TFCBlocks.StoneMMBrick, 1, i) });
			FillerManager.registry.addRecipe(new FillerFillWalls(), new Object[] { "bbb", "b b", "bbb",
				Character.valueOf('b'), new ItemStack(TFCBlocks.StoneMMBrick, 1, i) });
			FillerManager.registry.addRecipe(new FillerFillPyramid(), new Object[] { "   ", " b ", "bbb",
				Character.valueOf('b'), new ItemStack(TFCBlocks.StoneMMBrick, 1, i) });
			FillerManager.registry.addRecipe(new FillerFillStairs(), new Object[] { "  b", " bb", "bbb",
				Character.valueOf('b'), new ItemStack(TFCBlocks.StoneMMBrick, 1, i) });
		}
		
		// ==================Silicone==================
		RemoveRecipe(new ItemStack(BuildCraftSilicon.laserBlock));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftSilicon.laserBlock), new Object[] { "ORR", "DDR", "ORR",
			Character.valueOf('O'), Block.obsidian,
			Character.valueOf('R'), Item.redstone,
			Character.valueOf('D'), new ItemStack(TFCItems.GemDiamond,1,2), });
		
		RemoveRecipe(new ItemStack(BuildCraftSilicon.assemblyTableBlock));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftSilicon.assemblyTableBlock, 1, 0), new Object[] { "ORO", "ODO", "OGO",
			Character.valueOf('O'), Block.obsidian,
			Character.valueOf('R'), Item.redstone,
			Character.valueOf('D'), new ItemStack(TFCItems.GemDiamond,1,2),
			Character.valueOf('G'), Items.BlueSteelGearItem, });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftSilicon.assemblyTableBlock, 1, 0), new Object[] { "ORO", "ODO", "OGO",
			Character.valueOf('O'), Block.obsidian,
			Character.valueOf('R'), Item.redstone,
			Character.valueOf('D'), new ItemStack(TFCItems.GemDiamond,1,2),
			Character.valueOf('G'), Items.RedSteelGearItem, });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftSilicon.assemblyTableBlock, 1, 1), new Object[] { "OWO", "OCO", "ORO",
			Character.valueOf('O'), Block.obsidian,
			Character.valueOf('W'), Block.workbench,
			Character.valueOf('C'), Block.chest,
			Character.valueOf('R'), new ItemStack(BuildCraftSilicon.redstoneChipset, 1, 0), });
		
		// / REDSTONE CHIPSETS
		AssemblyRecipe.assemblyRecipes.add(new AssemblyRecipe(new ItemStack[] { new ItemStack(Item.redstone), new ItemStack(TFCItems.WroughtIronIngot) }, 20000, new ItemStack(BuildCraftSilicon.redstoneChipset, 1, 1)));
		AssemblyRecipe.assemblyRecipes.add(new AssemblyRecipe(new ItemStack[] { new ItemStack(Item.redstone), new ItemStack(TFCItems.GoldIngot) }, 40000, new ItemStack(BuildCraftSilicon.redstoneChipset, 1, 2)));
		AssemblyRecipe.assemblyRecipes.add(new AssemblyRecipe(new ItemStack[] { new ItemStack(Item.redstone), new ItemStack(TFCItems.GemDiamond,1,2) }, 80000, new ItemStack(BuildCraftSilicon.redstoneChipset, 1, 3)));
		// PULSATING CHIPSETS
		AssemblyRecipe.assemblyRecipes.add(new AssemblyRecipe(new ItemStack[] { new ItemStack(Item.redstone), new ItemStack(TFCItems.GemEmerald,1,2) }, 40000, new ItemStack(BuildCraftSilicon.redstoneChipset, 2, 4)));
		
		// BC Wires
		AssemblyRecipe.assemblyRecipes.remove(new ItemStack(BuildCraftTransport.redPipeWire));
		AssemblyRecipe.assemblyRecipes.remove(new ItemStack(BuildCraftTransport.bluePipeWire));
		AssemblyRecipe.assemblyRecipes.remove(new ItemStack(BuildCraftTransport.greenPipeWire));
		AssemblyRecipe.assemblyRecipes.remove(new ItemStack(BuildCraftTransport.yellowPipeWire));
		AssemblyRecipe.assemblyRecipes.add(new AssemblyRecipe(new ItemStack[] { new ItemStack(Item.dyePowder, 1, 1), new ItemStack(Item.redstone, 1), new ItemStack(TFCItems.CopperIngot, 1) }, 500, new ItemStack(BuildCraftTransport.redPipeWire, 8)));
		AssemblyRecipe.assemblyRecipes.add(new AssemblyRecipe(new ItemStack[] { new ItemStack(Item.dyePowder, 1, 4), new ItemStack(Item.redstone, 1), new ItemStack(TFCItems.CopperIngot, 1) }, 500, new ItemStack(BuildCraftTransport.bluePipeWire, 8)));
		AssemblyRecipe.assemblyRecipes.add(new AssemblyRecipe(new ItemStack[] { new ItemStack(Item.dyePowder, 1, 2), new ItemStack(Item.redstone, 1), new ItemStack(TFCItems.CopperIngot, 1) }, 500, new ItemStack(BuildCraftTransport.greenPipeWire, 8)));
		AssemblyRecipe.assemblyRecipes.add(new AssemblyRecipe(new ItemStack[] { new ItemStack(Item.dyePowder, 1, 11), new ItemStack(Item.redstone, 1), new ItemStack(TFCItems.CopperIngot, 1) }, 500, new ItemStack(BuildCraftTransport.yellowPipeWire, 8)));


		// ==========Things That make no sense...yet=============
		// Olivien as green dye. Not sure if this makes any sense
		GameRegistry.addShapelessRecipe(new ItemStack(Item.dyePowder, 4,2), new Object[] {new ItemStack(TFCItems.OreChunk, 1, 33)});
		
		// ===============Vanilla Recipes==================
		// Vanilla Pistons
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Block.pistonBase, 1), new Object[] { "www", "cic", "crc",
			Character.valueOf('w'), TFCBlocks.Planks,
			Character.valueOf('c'), TFCBlocks.StoneIgInCobble,
			Character.valueOf('i'), TFCItems.WroughtIronIngot,
			Character.valueOf('r'), Item.redstone });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Block.pistonBase, 1), new Object[] { "www", "cic", "crc",
			Character.valueOf('w'), TFCBlocks.Planks,
			Character.valueOf('c'), TFCBlocks.StoneIgExCobble,
			Character.valueOf('i'), TFCItems.WroughtIronIngot,
			Character.valueOf('r'), Item.redstone });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Block.pistonBase, 1), new Object[] { "www", "cic", "crc",
			Character.valueOf('w'), TFCBlocks.Planks,
			Character.valueOf('c'), TFCBlocks.StoneSedCobble,
			Character.valueOf('i'), TFCItems.WroughtIronIngot,
			Character.valueOf('r'), Item.redstone });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Block.pistonBase, 1), new Object[] { "www", "cic", "crc",
			Character.valueOf('w'), TFCBlocks.Planks,
			Character.valueOf('c'), TFCBlocks.StoneMMCobble,
			Character.valueOf('i'), TFCItems.WroughtIronIngot,
			Character.valueOf('r'), Item.redstone });

		// Bookshelf Recipe for Library
		for(int i = 0; i < 16; i++) {
			BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Block.bookShelf, 1), new Object[] { "ppp", "bbb", "ppp",
				Character.valueOf('p'), new ItemStack(TFCItems.SinglePlank,1,i),
				Character.valueOf('b'), Item.book });
		}

		// Vanilla Bucket
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Item.bucketEmpty), new Object[] { "I I", " I ",
				Character.valueOf('I'), TFCItems.WroughtIronIngot });
	}
	
	public static void RemoveRecipe(ItemStack resultItem) {
		List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
		for (int i = 0; i < recipes.size(); i++)
		{
			IRecipe tmpRecipe = recipes.get(i);
			if (tmpRecipe instanceof IRecipe) {
				IRecipe recipe = tmpRecipe;
				ItemStack recipeResult = recipe.getRecipeOutput();

				if (ItemStack.areItemStacksEqual(resultItem, recipeResult)) {
					recipes.remove(i--);
				}
			}
		}
	}
}
