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
package emris.BCTFCcrossover;

import net.minecraft.item.Item;
import buildcraft.transport.BlockGenericPipe;
import buildcraft.transport.ItemPipe;
import buildcraft.transport.Pipe;
import cpw.mods.fml.common.registry.LanguageRegistry;
import emris.BCTFCcrossover.core.IDProvider;
import emris.BCTFCcrossover.items.ItemBuckets;
import emris.BCTFCcrossover.items.ItemGears;
import emris.BCTFCcrossover.items.ItemGeneric;
import emris.BCTFCcrossover.items.ItemLatexBowl;
import emris.BCTFCcrossover.items.ItemPipeFrames;
import emris.BCTFCcrossover.items.ItemPlans;
import emris.BCTFCcrossover.items.ItemRubber;
import emris.BCTFCcrossover.items.ItemWrenchGeneral;
import emris.BCTFCcrossover.pipes.fluids.BlackBronzePipeFluidsItem;
import emris.BCTFCcrossover.pipes.fluids.BronzePipeFluidsItem;
import emris.BCTFCcrossover.pipes.fluids.LeadPipeFluidsItem;
import emris.BCTFCcrossover.pipes.fluids.RedSteelPipeFluidsItem;
import emris.BCTFCcrossover.pipes.fluids.RoseGoldPipeFluidsItem;
import emris.BCTFCcrossover.pipes.fluids.SteelPipeFluidsItem;
import emris.BCTFCcrossover.pipes.fluids.TinPipeFluidsItem;
import emris.BCTFCcrossover.pipes.fluids.WroughtIronPipeFluidsItem;
import emris.BCTFCcrossover.pipes.power.BlackBronzePipePowerItem;
import emris.BCTFCcrossover.pipes.power.CopperPipePowerItem;
import emris.BCTFCcrossover.pipes.power.PlatinumPipePowerItem;
import emris.BCTFCcrossover.pipes.power.RoseGoldPipePowerItem;
import emris.BCTFCcrossover.pipes.power.SteelPipePowerItem;
import emris.BCTFCcrossover.pipes.power.WroughtIronPipePowerItem;
import emris.BCTFCcrossover.pipes.structure.LeadPipeStructureItem;
import emris.BCTFCcrossover.pipes.transport.BlackBronzePipeItem;
import emris.BCTFCcrossover.pipes.transport.BlackSteelPipeItem;
import emris.BCTFCcrossover.pipes.transport.BlueSteelPipeItem;
import emris.BCTFCcrossover.pipes.transport.BrassPipeItem;
import emris.BCTFCcrossover.pipes.transport.BronzePipeItem;
import emris.BCTFCcrossover.pipes.transport.LeadPipeItem;
import emris.BCTFCcrossover.pipes.transport.RedSteelPipeItem;
import emris.BCTFCcrossover.pipes.transport.RoseGoldPipeItem;
import emris.BCTFCcrossover.pipes.transport.SteelPipeItem;
import emris.BCTFCcrossover.pipes.transport.SterlingSilverPipeItem;
import emris.BCTFCcrossover.pipes.transport.TinPipeItem;
import emris.BCTFCcrossover.pipes.transport.WroughtIronPipeItem;

public class Items {
	public static Item Latex;
	public static Item LatexBowl;
	
	public static Item Buckets;
	public static Item Rubber;
	public static Item Gears;
	public static Item Plans;
	public static Item PipeFrames;
	
	public static Item TinPipeItem;
	public static Item LeadPipeItem;
	public static Item BronzePipeItem;
	public static Item WroughtIronPipeItem;
	public static Item SteelPipeItem;
	public static Item BlueSteelPipeItem;
	public static Item RedSteelPipeItem;
	public static Item BlackBronzePipeItem;
	public static Item RoseGoldPipeItem;
	public static Item BlackSteelPipeItem;
	public static Item SterlingSilverPipeItem;
	public static Item BrassPipeItem;

	public static Item TinPipeFluidsItem;
	public static Item LeadPipeFluidsItem;
	public static Item BronzePipeFluidsItem;
	public static Item WroughtIronPipeFluidsItem;
	public static Item SteelPipeFluidsItem;
	public static Item RedSteelPipeFluidsItem;
	public static Item BlackBronzePipeFluidsItem;
	public static Item RoseGoldPipeFluidsItem;

	public static Item CopperPipePowerItem;
	public static Item RoseGoldPipePowerItem;
	public static Item BlackBronzePipePowerItem;
	public static Item WroughtIronPipePowerItem;
	public static Item SteelPipePowerItem;
	public static Item PlatinumPipePowerItem;
	
	public static Item LeadPipeStructureItem;
	
	public static Item BismuthWrenchItem;
	public static Item TinWrenchItem;
	public static Item ZincWrenchItem;
	public static Item CopperWrenchItem;
	public static Item BismuthBronzeWrenchItem;
	public static Item BlackBronzeWrenchItem;
	public static Item BronzeWrenchItem;
	public static Item RoseGoldWrenchItem;
	public static Item WroughtIronWrenchItem;
	public static Item SteelWrenchItem;
	public static Item BlackSteelWrenchItem;
	public static Item BlueSteelWrenchItem;
	public static Item RedSteelWrenchItem;
	
	public static void LoadItems() {
		System.out.println(new StringBuilder().append("[BCTFCcrossover] Loading Items").toString());
		
		// ===============Plans===============
		Plans = new ItemPlans(IDProvider.Plans);
			LanguageRegistry.addName(Plans, "Plan");
			BCTFCcrossover.proxy.registerItem(Plans);
		
		// ===============Gears===============
		Gears = new ItemGears(IDProvider.Gears);
			LanguageRegistry.addName(Gears, "Gear");
			BCTFCcrossover.proxy.registerItem(Gears);
		
		// ===============Buckets=============
		Buckets = new ItemBuckets(IDProvider.Buckets);
			LanguageRegistry.addName(Buckets, "Bucket");
			BCTFCcrossover.proxy.registerItem(Buckets);
			
		// ===============Latex=============
		Latex = new ItemGeneric(IDProvider.Latex).setUnlocalizedName("Latex");
			LanguageRegistry.addName(Latex, "Latex");
			BCTFCcrossover.proxy.registerItem(Latex);
		LatexBowl = new ItemLatexBowl(IDProvider.LatexBowl);
			LanguageRegistry.addName(LatexBowl, "LatexBowl");
			BCTFCcrossover.proxy.registerItem(LatexBowl);

		// ===============Rubber==============
		Rubber = new ItemRubber(IDProvider.Rubber);
			LanguageRegistry.addName(Rubber, "Rubber");
			BCTFCcrossover.proxy.registerItem(Rubber);

		// ===============Pipe Frames=========
		PipeFrames = new ItemPipeFrames(IDProvider.PipeFrames);
			LanguageRegistry.addName(PipeFrames, "PipeFrame");
			BCTFCcrossover.proxy.registerItem(PipeFrames);

		// ===============Transport Pipes===============
		Item.itemsList[IDProvider.bcWoodPipe] = null;
		TinPipeItem = createPipe(IDProvider.TinPipeItem, TinPipeItem.class, "Extraction Pipe");
		BCTFCcrossover.proxy.registerItem(TinPipeItem);

		Item.itemsList[IDProvider.bcCobblestonePipe] = null;
		LeadPipeItem = createPipe(IDProvider.LeadPipeItem, LeadPipeItem.class, "Transport Pipe 01");
		BCTFCcrossover.proxy.registerItem(LeadPipeItem);

		Item.itemsList[IDProvider.bcStonePipe] = null;
		BronzePipeItem = createPipe(IDProvider.BronzePipeItem, BronzePipeItem.class, "Transport Pipe 02");
		BCTFCcrossover.proxy.registerItem(BronzePipeItem);
		
		Item.itemsList[IDProvider.bcIronPipe] = null;
		WroughtIronPipeItem = createPipe(IDProvider.WroughtIronPipeItem, WroughtIronPipeItem.class, "Junction Collector Pipe");
		BCTFCcrossover.proxy.registerItem(WroughtIronPipeItem);

		Item.itemsList[IDProvider.bcGoldPipe] = null;
		SteelPipeItem = createPipe(IDProvider.SteelPipeItem, SteelPipeItem.class, "Advanced Transport Pipe");
		BCTFCcrossover.proxy.registerItem(SteelPipeItem);
		
		Item.itemsList[IDProvider.bcDiamondPipe] = null;
		BlueSteelPipeItem = createPipe(IDProvider.BlueSteelPipeItem, BlueSteelPipeItem.class, "Router Pipe");
		BCTFCcrossover.proxy.registerItem(BlueSteelPipeItem);
		
		Item.itemsList[IDProvider.bcEmeraldPipe] = null;
		RedSteelPipeItem = createPipe(IDProvider.RedSteelPipeItem, RedSteelPipeItem.class, "Filter Extraction Pipe");
		BCTFCcrossover.proxy.registerItem(RedSteelPipeItem);
		
		Item.itemsList[IDProvider.bcVoidPipe] = null;
		BlackBronzePipeItem = createPipe(IDProvider.BlackBronzePipeItem, BlackBronzePipeItem.class, "Void Pipe");
		BCTFCcrossover.proxy.registerItem(BlackBronzePipeItem);
		
		Item.itemsList[IDProvider.bcSandstonePipe] = null;
		RoseGoldPipeItem = createPipe(IDProvider.RoseGoldPipeItem, RoseGoldPipeItem.class, "Transport Pipe Connector");
		BCTFCcrossover.proxy.registerItem(RoseGoldPipeItem);
		
		Item.itemsList[IDProvider.bcObsidianPipe] = null;
		BlackSteelPipeItem = createPipe(IDProvider.BlackSteelPipeItem, BlackSteelPipeItem.class, "Suction Pipe");
		BCTFCcrossover.proxy.registerItem(BlackSteelPipeItem);

		Item.itemsList[IDProvider.bcDaizuliPipe] = null;
		SterlingSilverPipeItem = createPipe(IDProvider.SterlingSilverPipeItem, SterlingSilverPipeItem.class, "Color Routing Pipe");
		BCTFCcrossover.proxy.registerItem(SterlingSilverPipeItem);
		
		Item.itemsList[IDProvider.bcLapisPipe] = null;
		BrassPipeItem = createPipe(IDProvider.BrassPipeItem, BrassPipeItem.class, "Color Tagging Pipe");
		BCTFCcrossover.proxy.registerItem(BrassPipeItem);
		
		Item.itemsList[IDProvider.bcQuartzPipe] = null;
//		BlackSteelPipeItem = createPipe(IDProvider.BlackSteelPipeItem, BlackSteelPipeItem.class, "Inverted Filter Extraction Pipe");
//		BCTFCcrossover.proxy.registerItem(BlackSteelPipeItem);
		
		// ===============Fluid Pipes===============
		Item.itemsList[IDProvider.bcWoodPipeFluids] = null;
		TinPipeFluidsItem = createPipe(IDProvider.TinPipeFluidsItem, TinPipeFluidsItem.class, "Fluids Extraction Pipe");
		BCTFCcrossover.proxy.registerItem(TinPipeFluidsItem);
		
		Item.itemsList[IDProvider.bcCobblestonePipeFluids] = null;
		LeadPipeFluidsItem = createPipe(IDProvider.LeadPipeFluidsItem, LeadPipeFluidsItem.class, "Fluids Transport Pipe 01");
		BCTFCcrossover.proxy.registerItem(LeadPipeFluidsItem);
		
		Item.itemsList[IDProvider.bcStonePipeFluids] = null;
		BronzePipeFluidsItem = createPipe(IDProvider.BronzePipeFluidsItem, BronzePipeFluidsItem.class, "Fluids Transport Pipe 02");
		BCTFCcrossover.proxy.registerItem(BronzePipeFluidsItem);
		
		Item.itemsList[IDProvider.bcIronPipeFluids] = null;
		WroughtIronPipeFluidsItem = createPipe(IDProvider.WroughtIronPipeFluidsItem, WroughtIronPipeFluidsItem.class, "Fluids Junction Collector Pipe");
		BCTFCcrossover.proxy.registerItem(WroughtIronPipeFluidsItem);
		
		Item.itemsList[IDProvider.bcGoldPipeFluids] = null;
		SteelPipeFluidsItem = createPipe(IDProvider.SteelPipeFluidsItem, SteelPipeFluidsItem.class, "Advanced Fluids Transport Pipe");
		BCTFCcrossover.proxy.registerItem(SteelPipeFluidsItem);
		
		Item.itemsList[IDProvider.bcEmeraldPipeFluids] = null;
		RedSteelPipeFluidsItem = createPipe(IDProvider.RedSteelPipeFluidsItem, RedSteelPipeFluidsItem.class, "Advanced Fluids Extraction Pipe");
		BCTFCcrossover.proxy.registerItem(RedSteelPipeFluidsItem);
		
		Item.itemsList[IDProvider.bcVoidPipeFluids] = null;
		BlackBronzePipeFluidsItem = createPipe(IDProvider.BlackBronzePipeFluidsItem, BlackBronzePipeFluidsItem.class, "Fluids Void Pipe");
		BCTFCcrossover.proxy.registerItem(BlackBronzePipeFluidsItem);
		
		Item.itemsList[IDProvider.bcSandstoneFluids] = null;
		RoseGoldPipeFluidsItem = createPipe(IDProvider.RoseGoldPipeFluidsItem, RoseGoldPipeFluidsItem.class, "Fluids Pipe Connector");
		BCTFCcrossover.proxy.registerItem(RoseGoldPipeFluidsItem);

		// ===============Power Pipes===============
		Item.itemsList[IDProvider.bcCobblestonePipePower] = null;
		CopperPipePowerItem = createPipe(IDProvider.CopperPipePowerItem, CopperPipePowerItem.class, "Copper Conductive Pipe");
		BCTFCcrossover.proxy.registerItem(CopperPipePowerItem);

		Item.itemsList[IDProvider.bcStonePipePower] = null;
		RoseGoldPipePowerItem = createPipe(IDProvider.RoseGoldPipePowerItem, RoseGoldPipePowerItem.class, "Rose Gold Conductive Pipe");
		BCTFCcrossover.proxy.registerItem(RoseGoldPipePowerItem);

		Item.itemsList[IDProvider.bcWoodPipePower] = null;
		BlackBronzePipePowerItem = createPipe(IDProvider.BlackBronzePipePowerItem, BlackBronzePipePowerItem.class, "Black Bronze Conductive Pipe");
		BCTFCcrossover.proxy.registerItem(BlackBronzePipePowerItem);

		Item.itemsList[IDProvider.bcQuartzPipePower] = null;
		WroughtIronPipePowerItem = createPipe(IDProvider.WroughtIronPipePowerItem, WroughtIronPipePowerItem.class, "Wrought Iron Conductive Pipe");
		BCTFCcrossover.proxy.registerItem(WroughtIronPipePowerItem);

		Item.itemsList[IDProvider.bcGoldPipePower] = null;
		SteelPipePowerItem = createPipe(IDProvider.SteelPipePowerItem, SteelPipePowerItem.class, "Steel Conductive Pipe");
		BCTFCcrossover.proxy.registerItem(SteelPipePowerItem);

		Item.itemsList[IDProvider.bcDiamondPipePower] = null;
		PlatinumPipePowerItem = createPipe(IDProvider.PlatinumPipePowerItem, PlatinumPipePowerItem.class, "Platinum Conductive Pipe");
		BCTFCcrossover.proxy.registerItem(PlatinumPipePowerItem);

		// ===============Structure Pipes===============
		Item.itemsList[IDProvider.bcStructurePipeCobblestone] = null;
		LeadPipeStructureItem = createPipe(IDProvider.LeadPipeStructureItem, LeadPipeStructureItem.class, "Structure Pipe");
		BCTFCcrossover.proxy.registerItem(LeadPipeStructureItem);
		
		// ===============Wrenches===============
		Item.itemsList[IDProvider.Wrench] = null;
		BismuthWrenchItem = new ItemWrenchGeneral(IDProvider.BismuthWrenchItem).setUnlocalizedName("BismuthWrenchItem");
		LanguageRegistry.addName(BismuthWrenchItem, "Wrench: Bismuth");
		BCTFCcrossover.proxy.registerItem(BismuthWrenchItem);
		
		TinWrenchItem = new ItemWrenchGeneral(IDProvider.TinWrenchItem).setUnlocalizedName("TinWrenchItem");
		LanguageRegistry.addName(TinWrenchItem, "Wrench: Tin");
		BCTFCcrossover.proxy.registerItem(TinWrenchItem);
		
		ZincWrenchItem = new ItemWrenchGeneral(IDProvider.ZincWrenchItem).setUnlocalizedName("ZincWrenchItem");
		LanguageRegistry.addName(ZincWrenchItem, "Wrench: Zinc");
		BCTFCcrossover.proxy.registerItem(ZincWrenchItem);
		
		CopperWrenchItem = new ItemWrenchGeneral(IDProvider.CopperWrenchItem).setUnlocalizedName("CopperWrenchItem");
		LanguageRegistry.addName(CopperWrenchItem, "Wrench: Copper");
		BCTFCcrossover.proxy.registerItem(CopperWrenchItem);
		
		BismuthBronzeWrenchItem = new ItemWrenchGeneral(IDProvider.BismuthBronzeWrenchItem).setUnlocalizedName("BismuthBronzeWrenchItem");
		LanguageRegistry.addName(BismuthBronzeWrenchItem, "Wrench: Bismuth Bronze");
		BCTFCcrossover.proxy.registerItem(BismuthBronzeWrenchItem);
		
		BlackBronzeWrenchItem = new ItemWrenchGeneral(IDProvider.BlackBronzeWrenchItem).setUnlocalizedName("BlackBronzeWrenchItem");
		LanguageRegistry.addName(BlackBronzeWrenchItem, "Wrench: Black Bronze");
		BCTFCcrossover.proxy.registerItem(BlackBronzeWrenchItem);
		
		BronzeWrenchItem = new ItemWrenchGeneral(IDProvider.BronzeWrenchItem).setUnlocalizedName("BronzeWrenchItem");
		LanguageRegistry.addName(BronzeWrenchItem, "Wrench: Bronze");
		BCTFCcrossover.proxy.registerItem(BronzeWrenchItem);
		
		RoseGoldWrenchItem = new ItemWrenchGeneral(IDProvider.RoseGoldWrenchItem).setUnlocalizedName("RoseGoldWrenchItem");
		LanguageRegistry.addName(RoseGoldWrenchItem, "Wrench: Rose Gold");
		BCTFCcrossover.proxy.registerItem(RoseGoldWrenchItem);
		
		WroughtIronWrenchItem = new ItemWrenchGeneral(IDProvider.WroughtIronWrenchItem).setUnlocalizedName("WroughtIronWrenchItem");
		LanguageRegistry.addName(WroughtIronWrenchItem, "Wrench: Wrought Iron");
		BCTFCcrossover.proxy.registerItem(WroughtIronWrenchItem);
		
		SteelWrenchItem = new ItemWrenchGeneral(IDProvider.SteelWrenchItem).setUnlocalizedName("SteelWrenchItem");
		LanguageRegistry.addName(SteelWrenchItem, "Wrench: Steel");
		BCTFCcrossover.proxy.registerItem(SteelWrenchItem);
		
		BlackSteelWrenchItem = new ItemWrenchGeneral(IDProvider.BlackSteelWrenchItem).setUnlocalizedName("BlackSteelWrenchItem");
		LanguageRegistry.addName(BlackSteelWrenchItem, "Wrench: Black Steel");
		BCTFCcrossover.proxy.registerItem(BlackSteelWrenchItem);
		
		BlueSteelWrenchItem = new ItemWrenchGeneral(IDProvider.BlueSteelWrenchItem).setUnlocalizedName("BlueSteelWrenchItem");
		LanguageRegistry.addName(BlueSteelWrenchItem, "Wrench: Blue Steel");
		BCTFCcrossover.proxy.registerItem(BlueSteelWrenchItem);
		
		RedSteelWrenchItem = new ItemWrenchGeneral(IDProvider.RedSteelWrenchItem).setUnlocalizedName("RedSteelWrenchItem");
		LanguageRegistry.addName(RedSteelWrenchItem, "Wrench: Red Steel");
		BCTFCcrossover.proxy.registerItem(RedSteelWrenchItem);
	}
	
	public static Item createPipe(int defaultID, Class<? extends Pipe> clas, String descr) {
		String name = Character.toLowerCase(clas.getSimpleName().charAt(0)) + clas.getSimpleName().substring(1);
		ItemPipe res = BlockGenericPipe.registerPipe(defaultID, clas);
		res.setUnlocalizedName(clas.getSimpleName());
		LanguageRegistry.addName(res, descr);
		return res;
	}
}