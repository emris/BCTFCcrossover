/*
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
package mods.BCTFCcrossover;

import java.util.List;
import java.util.Random;

import mods.BCTFCcrossover.Items.Items;
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
		CraftingManagerTFC.getInstance().addRecipe(new ItemStack(Items.gearPlanItem, 1), new Object[] { "# # #"," ### ","## ##"," ### ","# # #",Character.valueOf('#'), TFCItems.Ink});
		CraftingManagerTFC.getInstance().addRecipe(new ItemStack(Items.wranchPlanItem, 1), new Object[] { " # # "," ### ","  #  ","  #  ","  #  ",Character.valueOf('#'), TFCItems.Ink});
		
		// Anvil Recipes
		AnvilCraftingManagerTFC anvil = AnvilCraftingManagerTFC.getInstance();
		for(int i = 0; i < 5; i++) {
			Random R = new Random (192865717);
			int dam = i * 5;
			
			// Not needed at the moment
//			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.BismuthIngot), new ItemStack(Items.gearPlanItem), 20 + R.nextInt(55),CraftingRuleEnum.PUNCHLAST, CraftingRuleEnum.BENDNOTLAST, CraftingRuleEnum.DRAWNOTLAST, false, AnvilReq.STONE, new ItemStack(Items.BismuthGearItem, 1, dam)));
//			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.TinIngot), new ItemStack(Items.gearPlanItem),20 + R.nextInt(55),CraftingRuleEnum.PUNCHLAST, CraftingRuleEnum.BENDNOTLAST, CraftingRuleEnum.DRAWNOTLAST, false, AnvilReq.STONE, new ItemStack(Items.TinGearItem, 1, dam)));
//			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.ZincIngot), new ItemStack(Items.gearPlanItem),20 + R.nextInt(55),CraftingRuleEnum.PUNCHLAST, CraftingRuleEnum.BENDNOTLAST, CraftingRuleEnum.DRAWNOTLAST, false, AnvilReq.STONE, new ItemStack(Items.ZincGearItem, 1, dam)));
//			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.CopperIngot), new ItemStack(Items.gearPlanItem),20 + R.nextInt(55),CraftingRuleEnum.PUNCHLAST, CraftingRuleEnum.BENDNOTLAST, CraftingRuleEnum.DRAWNOTLAST, false, AnvilReq.COPPER, new ItemStack(Items.CopperGearItem, 1, dam)));
			
			// Instead of Wood
			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.BismuthBronzeIngot), new ItemStack(Items.gearPlanItem),20 + R.nextInt(55),CraftingRuleEnum.PUNCHLAST, CraftingRuleEnum.BENDNOTLAST, CraftingRuleEnum.DRAWNOTLAST, false, AnvilReq.BISMUTHBRONZE, new ItemStack(Items.BismuthBronzeGearItem, 1, dam)));
			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.BlackBronzeIngot), new ItemStack(Items.gearPlanItem),20 + R.nextInt(55),CraftingRuleEnum.PUNCHLAST, CraftingRuleEnum.BENDNOTLAST, CraftingRuleEnum.DRAWNOTLAST, false, AnvilReq.BLACKBRONZE, new ItemStack(Items.BlackBronzeGearItem, 1, dam)));
			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.BronzeIngot), new ItemStack(Items.gearPlanItem),20 + R.nextInt(55),CraftingRuleEnum.PUNCHLAST, CraftingRuleEnum.BENDNOTLAST, CraftingRuleEnum.DRAWNOTLAST, false, AnvilReq.BRONZE, new ItemStack(Items.BronzeGearItem, 1, dam)));
			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.RoseGoldIngot), new ItemStack(Items.gearPlanItem),20 + R.nextInt(55),CraftingRuleEnum.PUNCHLAST, CraftingRuleEnum.BENDNOTLAST, CraftingRuleEnum.DRAWNOTLAST, false, AnvilReq.BRONZE, new ItemStack(Items.RoseGoldGearItem, 1, dam)));
			// Instead of Stone
			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.WroughtIronIngot), new ItemStack(Items.gearPlanItem),20 + R.nextInt(55),CraftingRuleEnum.PUNCHLAST, CraftingRuleEnum.BENDNOTLAST, CraftingRuleEnum.DRAWNOTLAST, false, AnvilReq.WROUGHTIRON, new ItemStack(Items.WroughtIronGearItem, 1, dam)));
			// Instead of Iron
			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.SteelIngot), new ItemStack(Items.gearPlanItem),20 + R.nextInt(55),CraftingRuleEnum.PUNCHLAST, CraftingRuleEnum.BENDNOTLAST, CraftingRuleEnum.DRAWNOTLAST, false, AnvilReq.STEEL, new ItemStack(Items.SteelGearItem, 1, dam)));
			// Instead of Gold
			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.BlackSteelIngot), new ItemStack(Items.gearPlanItem),20 + R.nextInt(55),CraftingRuleEnum.PUNCHLAST, CraftingRuleEnum.BENDNOTLAST, CraftingRuleEnum.DRAWNOTLAST, false, AnvilReq.BLACKSTEEL, new ItemStack(Items.BlackSteelGearItem, 1, dam)));
			// Instead of Diamond
			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.BlueSteelIngot), new ItemStack(Items.gearPlanItem),20 + R.nextInt(55),CraftingRuleEnum.PUNCHLAST, CraftingRuleEnum.BENDNOTLAST, CraftingRuleEnum.DRAWNOTLAST, false, AnvilReq.BLUESTEEL, new ItemStack(Items.BlueSteelGearItem, 1, dam)));
			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.RedSteelIngot), new ItemStack(Items.gearPlanItem),20 + R.nextInt(55),CraftingRuleEnum.PUNCHLAST, CraftingRuleEnum.BENDNOTLAST, CraftingRuleEnum.DRAWNOTLAST, false, AnvilReq.REDSTEEL, new ItemStack(Items.RedSteelGearItem, 1, dam)));
			
			// Wrench
			anvil.addRecipe(new AnvilRecipe(new ItemStack(TFCItems.WroughtIronIngot), new ItemStack(Items.wranchPlanItem),20 + R.nextInt(55),CraftingRuleEnum.HITLAST, CraftingRuleEnum.DRAWSECONDFROMLAST, CraftingRuleEnum.BENDTHIRDFROMLAST, false, AnvilReq.WROUGHTIRON, new ItemStack(BuildCraftCore.wrenchItem, 1, dam)));
		}

		// ========Remove BC Gear Recipes================
		RemoveRecipe(new ItemStack(BuildCraftCore.stoneGearItem));
//		CraftingManagerTFC.getInstance().addRecipe(new ItemStack(BuildCraftCore.stoneGearItem, 1), new Object[] { "# # #"," ### ","## ##"," ### ","# # #", Character.valueOf('#'), new ItemStack(TFCItems.FlatRock, 1, 32767)});
//
		RemoveRecipe(new ItemStack(BuildCraftCore.woodenGearItem));
//		GameRegistry.addRecipe(new ItemStack(BuildCraftCore.woodenGearItem, 4), " I ", "ISI", " I ",
//				Character.valueOf('I'), new ItemStack(TFCItems.SinglePlank,1,0),
//				Character.valueOf('S'), TFCItems.TinChisel);
		RemoveRecipe(new ItemStack(BuildCraftCore.ironGearItem));
		RemoveRecipe(new ItemStack(BuildCraftCore.goldGearItem));
		RemoveRecipe(new ItemStack(BuildCraftCore.diamondGearItem));
		
		// ===================Engines=====================
		// Mechanical
		RemoveRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 0));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 0), new Object[] { "www", " g ", "GpG",
			Character.valueOf('w'), "plankWood",
			Character.valueOf('g'), Block.glass,
			Character.valueOf('G'), Items.BismuthBronzeGearItem,
			Character.valueOf('p'), Block.pistonBase });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 0), new Object[] { "www", " g ", "GpG",
			Character.valueOf('w'), "plankWood",
			Character.valueOf('g'), Block.glass,
			Character.valueOf('G'), Items.BlackBronzeGearItem,
			Character.valueOf('p'), Block.pistonBase });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 0), new Object[] { "www", " g ", "GpG",
			Character.valueOf('w'), "plankWood",
			Character.valueOf('g'), Block.glass,
			Character.valueOf('G'), Items.BronzeGearItem,
			Character.valueOf('p'), Block.pistonBase });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 0), new Object[] { "www", " g ", "GpG",
			Character.valueOf('w'), "plankWood",
			Character.valueOf('g'), Block.glass,
			Character.valueOf('G'), Items.RoseGoldGearItem,
			Character.valueOf('p'), Block.pistonBase });
		// Steam
		RemoveRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 1));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 1), new Object[] { "www", " g ", "GpG",
			Character.valueOf('w'), TFCBlocks.StoneIgInCobble,
			Character.valueOf('g'), Block.glass,
			Character.valueOf('G'), Items.WroughtIronGearItem,
			Character.valueOf('p'), Block.pistonBase });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 1), new Object[] { "www", " g ", "GpG",
			Character.valueOf('w'), TFCBlocks.StoneIgExCobble,
			Character.valueOf('g'), Block.glass,
			Character.valueOf('G'), Items.WroughtIronGearItem,
			Character.valueOf('p'), Block.pistonBase });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 1), new Object[] { "www", " g ", "GpG",
			Character.valueOf('w'), TFCBlocks.StoneSedCobble,
			Character.valueOf('g'), Block.glass,
			Character.valueOf('G'), Items.WroughtIronGearItem,
			Character.valueOf('p'), Block.pistonBase });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 1), new Object[] { "www", " g ", "GpG",
			Character.valueOf('w'), TFCBlocks.StoneMMCobble,
			Character.valueOf('g'), Block.glass,
			Character.valueOf('G'), Items.WroughtIronGearItem,
			Character.valueOf('p'), Block.pistonBase });
		// Combustion
		RemoveRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 2));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 2), new Object[] { "www", " g ", "GpG",
			Character.valueOf('w'), TFCItems.WroughtIronIngot,
			Character.valueOf('g'), Block.glass,
			Character.valueOf('G'), Items.SteelGearItem,
			Character.valueOf('p'), Block.pistonBase });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftEnergy.engineBlock, 1, 2), new Object[] { "www", " g ", "GpG",
			Character.valueOf('w'), TFCItems.WroughtIronIngot,
			Character.valueOf('g'), Block.glass,
			Character.valueOf('G'), Items.SteelGearItem,
			Character.valueOf('p'), Block.pistonBase });
		// Vanilla Pistons
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Block.pistonBase, 1), new Object[] { "www", "cic", "crc",
			Character.valueOf('w'), "plankWood",
			Character.valueOf('c'), TFCBlocks.StoneIgInCobble,
			Character.valueOf('i'), TFCItems.WroughtIronIngot,
			Character.valueOf('r'), Item.redstone });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Block.pistonBase, 1), new Object[] { "www", "cic", "crc",
			Character.valueOf('w'), "plankWood",
			Character.valueOf('c'), TFCBlocks.StoneIgExCobble,
			Character.valueOf('i'), TFCItems.WroughtIronIngot,
			Character.valueOf('r'), Item.redstone });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Block.pistonBase, 1), new Object[] { "www", "cic", "crc",
			Character.valueOf('w'), "plankWood",
			Character.valueOf('c'), TFCBlocks.StoneSedCobble,
			Character.valueOf('i'), TFCItems.WroughtIronIngot,
			Character.valueOf('r'), Item.redstone });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Block.pistonBase, 1), new Object[] { "www", "cic", "crc",
			Character.valueOf('w'), "plankWood",
			Character.valueOf('c'), TFCBlocks.StoneMMCobble,
			Character.valueOf('i'), TFCItems.WroughtIronIngot,
			Character.valueOf('r'), Item.redstone });
		// ====================================================
		
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
			BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftFactory.miningWellBlock, 1), new Object[] { "ipi", "igi", "iPi",
				Character.valueOf('p'), Item.redstone,
				Character.valueOf('i'), TFCItems.SteelIngot,
				Character.valueOf('g'), Items.SteelGearItem,
				Character.valueOf('P'), TFCItems.SteelPick });
			// Quarry
			RemoveRecipe(new ItemStack(BuildCraftFactory.quarryBlock));
			BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftFactory.quarryBlock), new Object[] { "ipi", "gig", "dDd",
				Character.valueOf('i'), Items.SteelGearItem,
				Character.valueOf('p'), Item.redstone,
				Character.valueOf('g'), Items.BlackSteelGearItem,
				Character.valueOf('d'), Items.BlueSteelGearItem,
				Character.valueOf('D'), TFCItems.BlueSteelPick });
			BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftFactory.quarryBlock), new Object[] { "ipi", "gig", "dDd",
				Character.valueOf('i'), Items.SteelGearItem,
				Character.valueOf('p'), Item.redstone,
				Character.valueOf('g'), Items.BlackSteelGearItem,
				Character.valueOf('d'), Items.RedSteelGearItem,
				Character.valueOf('D'), TFCItems.RedSteelPick });
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
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftBuilders.fillerBlock, 1), new Object[] { "btb", "ycy", "gCg",
			Character.valueOf('b'), new ItemStack(Item.dyePowder, 1, 0),
			Character.valueOf('t'), BuildCraftBuilders.markerBlock,
			Character.valueOf('y'), new ItemStack(Item.dyePowder, 1, 11),
			Character.valueOf('c'), Block.workbench,
			Character.valueOf('g'), Items.BlackSteelGearItem,
			Character.valueOf('C'), Block.chest });
		// Builder
		RemoveRecipe(new ItemStack(BuildCraftBuilders.builderBlock));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftBuilders.builderBlock, 1), new Object[] { "btb", "ycy", "gCg",
			Character.valueOf('b'), new ItemStack(Item.dyePowder, 1, 0),
			Character.valueOf('t'), BuildCraftBuilders.markerBlock,
			Character.valueOf('y'), new ItemStack(Item.dyePowder, 1, 11),
			Character.valueOf('c'), Block.workbench,
			Character.valueOf('g'), Items.BlueSteelGearItem,
			Character.valueOf('C'), Block.chest });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftBuilders.builderBlock, 1), new Object[] { "btb", "ycy", "gCg",
			Character.valueOf('b'), new ItemStack(Item.dyePowder, 1, 0),
			Character.valueOf('t'), BuildCraftBuilders.markerBlock,
			Character.valueOf('y'), new ItemStack(Item.dyePowder, 1, 11),
			Character.valueOf('c'), Block.workbench,
			Character.valueOf('g'), Items.RedSteelGearItem,
			Character.valueOf('C'), Block.chest });
		// Architect
		RemoveRecipe(new ItemStack(BuildCraftBuilders.architectBlock));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftBuilders.architectBlock, 1), new Object[] { "btb", "ycy", "gCg",
			Character.valueOf('b'), new ItemStack(Item.dyePowder, 1, 0),
			Character.valueOf('t'), BuildCraftBuilders.markerBlock,
			Character.valueOf('y'), new ItemStack(Item.dyePowder, 1, 11),
			Character.valueOf('c'), Block.workbench,
			Character.valueOf('g'), Items.BlueSteelGearItem,
			Character.valueOf('C'), new ItemStack(BuildCraftBuilders.templateItem, 1) });
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftBuilders.architectBlock, 1), new Object[] { "btb", "ycy", "gCg",
			Character.valueOf('b'), new ItemStack(Item.dyePowder, 1, 0),
			Character.valueOf('t'), BuildCraftBuilders.markerBlock,
			Character.valueOf('y'), new ItemStack(Item.dyePowder, 1, 11),
			Character.valueOf('c'), Block.workbench,
			Character.valueOf('g'), Items.RedSteelGearItem,
			Character.valueOf('C'), new ItemStack(BuildCraftBuilders.templateItem, 1) });
		// Library
		RemoveRecipe(new ItemStack(BuildCraftBuilders.libraryBlock));
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftBuilders.libraryBlock, 1), new Object[] { "bbb", "bBb", "bbb",
			Character.valueOf('b'), new ItemStack(BuildCraftBuilders.blueprintItem),
			Character.valueOf('B'), Block.bookShelf });
		// Bookshelf Recipe for Library
		for(int i = 0; i < 16; i++) {
			BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Block.bookShelf, 1), new Object[] { "ppp", "bbb", "ppp",
				Character.valueOf('p'), new ItemStack(TFCItems.SinglePlank,1,i),
				Character.valueOf('b'), Item.book });
		}
		
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
		
		// Silicone
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
		
		// Add sandstone for pipeItemsSandstone
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Block.sandStone), new Object[] {"##", "##", Character.valueOf('#'), TFCBlocks.Sand});
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Block.sandStone), new Object[] {"##", "##", Character.valueOf('#'), TFCBlocks.Sand2});
		
		// Add TFC Cobblestone pipe recipes
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftTransport.pipeItemsCobblestone, 8), new Object[] { "ABA", Character.valueOf('A'), TFCBlocks.StoneIgInCobble, Character.valueOf('B'), Block.glass } );
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftTransport.pipeItemsCobblestone, 8), new Object[] { "ABA", Character.valueOf('A'), TFCBlocks.StoneIgExCobble, Character.valueOf('B'), Block.glass } );
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftTransport.pipeItemsCobblestone, 8), new Object[] { "ABA", Character.valueOf('A'), TFCBlocks.StoneSedCobble, Character.valueOf('B'), Block.glass } );
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftTransport.pipeItemsCobblestone, 8), new Object[] { "ABA", Character.valueOf('A'), TFCBlocks.StoneMMCobble, Character.valueOf('B'), Block.glass } );
		// Add TFC Stone pipe recipes
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftTransport.pipeItemsStone, 8), new Object[] { "ABA", Character.valueOf('A'), TFCBlocks.StoneIgIn, Character.valueOf('B'), Block.glass } );
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftTransport.pipeItemsStone, 8), new Object[] { "ABA", Character.valueOf('A'), TFCBlocks.StoneIgEx, Character.valueOf('B'), Block.glass } );
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftTransport.pipeItemsStone, 8), new Object[] { "ABA", Character.valueOf('A'), TFCBlocks.StoneSed, Character.valueOf('B'), Block.glass } );
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftTransport.pipeItemsStone, 8), new Object[] { "ABA", Character.valueOf('A'), TFCBlocks.StoneMM, Character.valueOf('B'), Block.glass } );
		// Add TFC WroughtIronIngot pipe recipes
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftTransport.pipeItemsIron, 8), new Object[] { "ABA", Character.valueOf('A'), TFCItems.WroughtIronIngot, Character.valueOf('B'), Block.glass } );
		// Add TFC Gold pipe recipes
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftTransport.pipeItemsGold, 8), new Object[] { "ABA", Character.valueOf('A'), TFCItems.GoldIngot, Character.valueOf('B'), Block.glass } );
		// Add TFC Diamond pipe recipes
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftTransport.pipeItemsDiamond, 8), new Object[] { "ABA", Character.valueOf('A'), new ItemStack(TFCItems.GemDiamond,1,2), Character.valueOf('B'), Block.glass } );
		// Add TFC Emerald pipe recipes
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(BuildCraftTransport.pipeItemsEmerald, 8), new Object[] { "ABA", Character.valueOf('A'), new ItemStack(TFCItems.GemEmerald,1,2), Character.valueOf('B'), Block.glass } );
		
		// Vanilla Bucket
		BCTFCcrossover.proxy.addCraftingRecipe(new ItemStack(Item.bucketEmpty), new Object[] { "   ", "I I", " I ",
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
