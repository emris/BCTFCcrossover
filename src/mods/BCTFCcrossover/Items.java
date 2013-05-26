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
package mods.BCTFCcrossover;

import java.io.File;

import mods.BCTFCcrossover.core.IDProvider;
import mods.BCTFCcrossover.items.ItemBuckets;
import mods.BCTFCcrossover.items.ItemGears;
import mods.BCTFCcrossover.items.ItemGeneric;
import mods.BCTFCcrossover.items.ItemLatexBowl;
import mods.BCTFCcrossover.items.ItemPipeFrames;
import mods.BCTFCcrossover.items.ItemPlans;
import mods.BCTFCcrossover.items.ItemRubber;
import mods.BCTFCcrossover.items.ItemWrenchGeneral;
import mods.BCTFCcrossover.pipes.liquids.BlackBronzePipeLiquidsItem;
import mods.BCTFCcrossover.pipes.liquids.BronzePipeLiquidsItem;
import mods.BCTFCcrossover.pipes.liquids.LeadPipeLiquidsItem;
import mods.BCTFCcrossover.pipes.liquids.RedSteelPipeLiquidsItem;
import mods.BCTFCcrossover.pipes.liquids.RoseGoldPipeLiquidsItem;
import mods.BCTFCcrossover.pipes.liquids.SteelPipeLiquidsItem;
import mods.BCTFCcrossover.pipes.liquids.TinPipeLiquidsItem;
import mods.BCTFCcrossover.pipes.liquids.WroughtIronPipeLiquidsItem;
import mods.BCTFCcrossover.pipes.power.CopperPipePowerItem;
import mods.BCTFCcrossover.pipes.power.SilverPipePowerItem;
import mods.BCTFCcrossover.pipes.power.TinPipePowerItem;
import mods.BCTFCcrossover.pipes.power.ZincPipePowerItem;
import mods.BCTFCcrossover.pipes.structure.LeadPipeStructureItem;
import mods.BCTFCcrossover.pipes.transport.BlackBronzePipeItem;
import mods.BCTFCcrossover.pipes.transport.BlackSteelPipeItem;
import mods.BCTFCcrossover.pipes.transport.BlueSteelPipeItem;
import mods.BCTFCcrossover.pipes.transport.BronzePipeItem;
import mods.BCTFCcrossover.pipes.transport.LeadPipeItem;
import mods.BCTFCcrossover.pipes.transport.RedSteelPipeItem;
import mods.BCTFCcrossover.pipes.transport.RoseGoldPipeItem;
import mods.BCTFCcrossover.pipes.transport.SteelPipeItem;
import mods.BCTFCcrossover.pipes.transport.TinPipeItem;
import mods.BCTFCcrossover.pipes.transport.WroughtIronPipeItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;
import net.minecraftforge.liquids.LiquidDictionary;
import net.minecraftforge.liquids.LiquidStack;
import buildcraft.transport.BlockGenericPipe;
import buildcraft.transport.ItemPipe;
import buildcraft.transport.Pipe;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Items {
	public static LiquidStack LatexLiquid;
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

	public static Item TinPipeLiquidsItem;
	public static Item LeadPipeLiquidsItem;
	public static Item BronzePipeLiquidsItem;
	public static Item WroughtIronPipeLiquidsItem;
	public static Item SteelPipeLiquidsItem;
	public static Item RedSteelPipeLiquidsItem;
	public static Item BlackBronzePipeLiquidsItem;
	public static Item RoseGoldPipeLiquidsItem;

	public static Item TinPipePowerItem;
	public static Item ZincPipePowerItem;
	public static Item CopperPipePowerItem;
	public static Item SilverPipePowerItem;
	
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
	
	static Configuration config;
	
	public static void LoadItems() {
		try {
			config = new Configuration(new File(BCTFCcrossover.proxy.getMinecraftDir(), "/config/BCTFCcrossover.cfg"));
			config.load();
		} catch (Exception e) {
			System.out.println(new StringBuilder().append("[BCTFCcrossover] Config file ERROR!").toString());
			config = null;
		}
		
		System.out.println(new StringBuilder().append("[BCTFCcrossover] Loading Items").toString());
		
		// ===============Plans===============
		Plans = new ItemPlans(getItemID(config,"items","Plans",IDProvider.Plans));
			LanguageRegistry.addName(Plans, "Plan");
			BCTFCcrossover.proxy.registerItem(Plans);
		
		// ===============Gears===============
		Gears = new ItemGears(getItemID(config,"items","Gears",IDProvider.Gears));
			LanguageRegistry.addName(Gears, "Gear");
			BCTFCcrossover.proxy.registerItem(Gears);
		
		// ===============Buckets=============
		Buckets = new ItemBuckets(getItemID(config, "items", "Buckets", IDProvider.Buckets));
			LanguageRegistry.addName(Buckets, "Bucket");
			BCTFCcrossover.proxy.registerItem(Buckets);
			
		// ===============Latex=============
		Latex = new ItemGeneric(getItemID(config, "items", "Latex", IDProvider.Latex)).setUnlocalizedName("Latex");
			LanguageRegistry.addName(Latex, "Latex");
			BCTFCcrossover.proxy.registerItem(Latex);
		LatexBowl = new ItemLatexBowl(getItemID(config, "items", "LatexBowl", IDProvider.LatexBowl));
			LanguageRegistry.addName(LatexBowl, "LatexBowl");
			BCTFCcrossover.proxy.registerItem(LatexBowl);
		// Register Latex liquid
		LatexLiquid = LiquidDictionary.getOrCreateLiquid("Latex", new LiquidStack(Latex, 1));

		// ===============Rubber==============
		Rubber = new ItemRubber(getItemID(config, "items", "Rubber", IDProvider.Rubber));
			LanguageRegistry.addName(Rubber, "Rubber");
			BCTFCcrossover.proxy.registerItem(Rubber);

		// ===============Pipe Frames=========
		PipeFrames = new ItemPipeFrames(getItemID(config,"items","PipeFrames",IDProvider.PipeFrames));
			LanguageRegistry.addName(PipeFrames, "PipeFrame");
			BCTFCcrossover.proxy.registerItem(PipeFrames);

		// ===============Transport Pipes===============
		Item.itemsList[IDProvider.WoodPipe] = null;
		TinPipeItem = createPipe(getItemID(config,"pipes","TinPipeItem",IDProvider.TinPipeItem), TinPipeItem.class, "Extraction Pipe");
		BCTFCcrossover.proxy.registerItem(TinPipeItem);

		Item.itemsList[IDProvider.CobblestonePipe] = null;
		LeadPipeItem = createPipe(getItemID(config,"pipes","LeadPipeItem",IDProvider.LeadPipeItem), LeadPipeItem.class, "Transport Pipe 01");
		BCTFCcrossover.proxy.registerItem(LeadPipeItem);

		Item.itemsList[IDProvider.StonePipe] = null;
		BronzePipeItem = createPipe(getItemID(config,"pipes","BronzePipeItem",IDProvider.BronzePipeItem), BronzePipeItem.class, "Transport Pipe 02");
		BCTFCcrossover.proxy.registerItem(BronzePipeItem);
		
		Item.itemsList[IDProvider.IronPipe] = null;
		WroughtIronPipeItem = createPipe(getItemID(config,"pipes","WroughtIronPipeItem",IDProvider.WroughtIronPipeItem), WroughtIronPipeItem.class, "Junction Collector Pipe");
		BCTFCcrossover.proxy.registerItem(WroughtIronPipeItem);

		Item.itemsList[IDProvider.GoldPipe] = null;
		SteelPipeItem = createPipe(getItemID(config,"pipes","SteelPipeItem",IDProvider.SteelPipeItem), SteelPipeItem.class, "Advanced Transport Pipe");
		BCTFCcrossover.proxy.registerItem(SteelPipeItem);
		
		Item.itemsList[IDProvider.DiamondPipe] = null;
		BlueSteelPipeItem = createPipe(getItemID(config,"pipes","BlueSteelPipeItem",IDProvider.BlueSteelPipeItem), BlueSteelPipeItem.class, "Router Pipe");
		BCTFCcrossover.proxy.registerItem(BlueSteelPipeItem);
		
		Item.itemsList[IDProvider.EmeraldPipe] = null;
		RedSteelPipeItem = createPipe(getItemID(config,"pipes","RedSteelPipeItem",IDProvider.RedSteelPipeItem), RedSteelPipeItem.class, "Filter Extraction Pipe");
		BCTFCcrossover.proxy.registerItem(RedSteelPipeItem);
		
		Item.itemsList[IDProvider.VoidPipe] = null;
		BlackBronzePipeItem = createPipe(getItemID(config,"pipes","BlackBronzePipeItem",IDProvider.BlackBronzePipeItem), BlackBronzePipeItem.class, "Void Pipe");
		BCTFCcrossover.proxy.registerItem(BlackBronzePipeItem);
		
		Item.itemsList[IDProvider.SandstonePipe] = null;
		RoseGoldPipeItem = createPipe(getItemID(config,"pipes","RoseGoldPipeItem",IDProvider.RoseGoldPipeItem), RoseGoldPipeItem.class, "Transport Pipe Connector");
		BCTFCcrossover.proxy.registerItem(RoseGoldPipeItem);
		
		Item.itemsList[IDProvider.ObsidianPipe] = null;
		BlackSteelPipeItem = createPipe(getItemID(config,"pipes","BlackSteelPipeItem",IDProvider.BlackSteelPipeItem), BlackSteelPipeItem.class, "Suction Pipe");
		BCTFCcrossover.proxy.registerItem(BlackSteelPipeItem);

		// ===============Liquid Pipes===============
		Item.itemsList[IDProvider.WoodPipeLiquids] = null;
		TinPipeLiquidsItem = createPipe(getItemID(config,"pipes","TinPipeLiquidsItem",IDProvider.TinPipeLiquidsItem), TinPipeLiquidsItem.class, "Liquids Extraction Pipe");
		BCTFCcrossover.proxy.registerItem(TinPipeLiquidsItem);
		
		Item.itemsList[IDProvider.CobblestonePipeLiquids] = null;
		LeadPipeLiquidsItem = createPipe(getItemID(config,"pipes","LeadPipeLiquidsItem",IDProvider.LeadPipeLiquidsItem), LeadPipeLiquidsItem.class, "Liquids Transport Pipe 01");
		BCTFCcrossover.proxy.registerItem(LeadPipeLiquidsItem);
		
		Item.itemsList[IDProvider.StonePipeLiquids] = null;
		BronzePipeLiquidsItem = createPipe(getItemID(config,"pipes","BronzePipeLiquidsItem",IDProvider.BronzePipeLiquidsItem), BronzePipeLiquidsItem.class, "Liquids Transport Pipe 02");
		BCTFCcrossover.proxy.registerItem(BronzePipeLiquidsItem);
		
		Item.itemsList[IDProvider.IronPipeLiquids] = null;
		WroughtIronPipeLiquidsItem = createPipe(getItemID(config,"pipes","WroughtIronPipeLiquidsItem",IDProvider.WroughtIronPipeLiquidsItem), WroughtIronPipeLiquidsItem.class, "Liquids Junction Collector Pipe");
		BCTFCcrossover.proxy.registerItem(WroughtIronPipeLiquidsItem);
		
		Item.itemsList[IDProvider.GoldPipeLiquids] = null;
		SteelPipeLiquidsItem = createPipe(getItemID(config,"pipes","SteelPipeLiquidsItem",IDProvider.SteelPipeLiquidsItem), SteelPipeLiquidsItem.class, "Advanced Liquids Transport Pipe");
		BCTFCcrossover.proxy.registerItem(SteelPipeLiquidsItem);
		
		Item.itemsList[IDProvider.EmeraldPipeLiquids] = null;
		RedSteelPipeLiquidsItem = createPipe(getItemID(config,"pipes","RedSteelPipeLiquidsItem",IDProvider.RedSteelPipeLiquidsItem), RedSteelPipeLiquidsItem.class, "Advanced Liquids Extraction Pipe");
		BCTFCcrossover.proxy.registerItem(RedSteelPipeLiquidsItem);
		
		Item.itemsList[IDProvider.VoidPipeLiquids] = null;
		BlackBronzePipeLiquidsItem = createPipe(getItemID(config,"pipes","BlackBronzePipeLiquidsItem",IDProvider.BlackBronzePipeLiquidsItem), BlackBronzePipeLiquidsItem.class, "Liquids Void Pipe");
		BCTFCcrossover.proxy.registerItem(BlackBronzePipeLiquidsItem);
		
		Item.itemsList[IDProvider.SandstoneLiquids] = null;
		RoseGoldPipeLiquidsItem = createPipe(getItemID(config,"pipes","RoseGoldPipeLiquidsItem",IDProvider.RoseGoldPipeLiquidsItem), RoseGoldPipeLiquidsItem.class, "Liquids Pipe Connector");
		BCTFCcrossover.proxy.registerItem(RoseGoldPipeLiquidsItem);

		// ===============Power Pipes===============
		Item.itemsList[IDProvider.WoodPipePower] = null;
		TinPipePowerItem = createPipe(getItemID(config,"pipes","TinPipePowerItem",IDProvider.TinPipePowerItem), TinPipePowerItem.class, "Tin Conductive Pipe");
		BCTFCcrossover.proxy.registerItem(TinPipePowerItem);
		
		Item.itemsList[IDProvider.StonePipePower] = null;
		ZincPipePowerItem = createPipe(getItemID(config,"pipes","ZincPipePowerItem",IDProvider.ZincPipePowerItem), ZincPipePowerItem.class, "Zinc Condictive Pipe");
		BCTFCcrossover.proxy.registerItem(ZincPipePowerItem);
		
		Item.itemsList[IDProvider.GoldPipePower] = null;
		CopperPipePowerItem = createPipe(getItemID(config,"pipes","CopperPipePowerItem",IDProvider.CopperPipePowerItem), CopperPipePowerItem.class, "Copper Condictive Pipe");
		BCTFCcrossover.proxy.registerItem(CopperPipePowerItem);
		
		//NEW
		SilverPipePowerItem = createPipe(getItemID(config,"pipes","SilverPipePowerItem",IDProvider.SilverPipePowerItem), SilverPipePowerItem.class, "Silver Condictive Pipe");
		BCTFCcrossover.proxy.registerItem(SilverPipePowerItem);
		
		// ===============Structure Pipes===============
		Item.itemsList[IDProvider.StructurePipeCobblestone] = null;
		LeadPipeStructureItem = createPipe(getItemID(config,"pipes","LeadPipeStructureItem",IDProvider.LeadPipeStructureItem), LeadPipeStructureItem.class, "Structure Pipe");
		BCTFCcrossover.proxy.registerItem(LeadPipeStructureItem);
		
		// ===============Wrenches===============
		Item.itemsList[IDProvider.Wrench] = null;
		BismuthWrenchItem = new ItemWrenchGeneral(getItemID(config,"wrenches","BismuthWrenchItem",IDProvider.BismuthWrenchItem)).setUnlocalizedName("BismuthWrenchItem");
		LanguageRegistry.addName(BismuthWrenchItem, "Wrench: Bismuth");
		BCTFCcrossover.proxy.registerItem(BismuthWrenchItem);
		
		TinWrenchItem = new ItemWrenchGeneral(getItemID(config,"wrenches","TinWrenchItem",IDProvider.TinWrenchItem)).setUnlocalizedName("TinWrenchItem");
		LanguageRegistry.addName(TinWrenchItem, "Wrench: Tin");
		BCTFCcrossover.proxy.registerItem(TinWrenchItem);
		
		ZincWrenchItem = new ItemWrenchGeneral(getItemID(config,"wrenches","ZincWrenchItem",IDProvider.ZincWrenchItem)).setUnlocalizedName("ZincWrenchItem");
		LanguageRegistry.addName(ZincWrenchItem, "Wrench: Zinc");
		BCTFCcrossover.proxy.registerItem(ZincWrenchItem);
		
		CopperWrenchItem = new ItemWrenchGeneral(getItemID(config,"wrenches","CopperWrenchItem",IDProvider.CopperWrenchItem)).setUnlocalizedName("CopperWrenchItem");
		LanguageRegistry.addName(CopperWrenchItem, "Wrench: Copper");
		BCTFCcrossover.proxy.registerItem(CopperWrenchItem);
		
		BismuthBronzeWrenchItem = new ItemWrenchGeneral(getItemID(config,"wrenches","BismuthBronzeWrenchItem",IDProvider.BismuthBronzeWrenchItem)).setUnlocalizedName("BismuthBronzeWrenchItem");
		LanguageRegistry.addName(BismuthBronzeWrenchItem, "Wrench: Bismuth Bronze");
		BCTFCcrossover.proxy.registerItem(BismuthBronzeWrenchItem);
		
		BlackBronzeWrenchItem = new ItemWrenchGeneral(getItemID(config,"wrenches","BlackBronzeWrenchItem",IDProvider.BlackBronzeWrenchItem)).setUnlocalizedName("BlackBronzeWrenchItem");
		LanguageRegistry.addName(BlackBronzeWrenchItem, "Wrench: Black Bronze");
		BCTFCcrossover.proxy.registerItem(BlackBronzeWrenchItem);
		
		BronzeWrenchItem = new ItemWrenchGeneral(getItemID(config,"wrenches","BronzeWrenchItem",IDProvider.BronzeWrenchItem)).setUnlocalizedName("BronzeWrenchItem");
		LanguageRegistry.addName(BronzeWrenchItem, "Wrench: Bronze");
		BCTFCcrossover.proxy.registerItem(BronzeWrenchItem);
		
		RoseGoldWrenchItem = new ItemWrenchGeneral(getItemID(config,"wrenches","RoseGoldWrenchItem",IDProvider.RoseGoldWrenchItem)).setUnlocalizedName("RoseGoldWrenchItem");
		LanguageRegistry.addName(RoseGoldWrenchItem, "Wrench: Rose Gold");
		BCTFCcrossover.proxy.registerItem(RoseGoldWrenchItem);
		
		WroughtIronWrenchItem = new ItemWrenchGeneral(getItemID(config,"wrenches","WroughtIronWrenchItem",IDProvider.WroughtIronWrenchItem)).setUnlocalizedName("WroughtIronWrenchItem");
		LanguageRegistry.addName(WroughtIronWrenchItem, "Wrench: Wrought Iron");
		BCTFCcrossover.proxy.registerItem(WroughtIronWrenchItem);
		
		SteelWrenchItem = new ItemWrenchGeneral(getItemID(config,"wrenches","SteelWrenchItem",IDProvider.SteelWrenchItem)).setUnlocalizedName("SteelWrenchItem");
		LanguageRegistry.addName(SteelWrenchItem, "Wrench: Steel");
		BCTFCcrossover.proxy.registerItem(SteelWrenchItem);
		
		BlackSteelWrenchItem = new ItemWrenchGeneral(getItemID(config,"wrenches","BlackSteelWrenchItem",IDProvider.BlackSteelWrenchItem)).setUnlocalizedName("BlackSteelWrenchItem");
		LanguageRegistry.addName(BlackSteelWrenchItem, "Wrench: Black Steel");
		BCTFCcrossover.proxy.registerItem(BlackSteelWrenchItem);
		
		BlueSteelWrenchItem = new ItemWrenchGeneral(getItemID(config,"wrenches","BlueSteelWrenchItem",IDProvider.BlueSteelWrenchItem)).setUnlocalizedName("BlueSteelWrenchItem");
		LanguageRegistry.addName(BlueSteelWrenchItem, "Wrench: Blue Steel");
		BCTFCcrossover.proxy.registerItem(BlueSteelWrenchItem);
		
		RedSteelWrenchItem = new ItemWrenchGeneral(getItemID(config,"wrenches","RedSteelWrenchItem",IDProvider.RedSteelWrenchItem)).setUnlocalizedName("RedSteelWrenchItem");
		LanguageRegistry.addName(RedSteelWrenchItem, "Wrench: Red Steel");
		BCTFCcrossover.proxy.registerItem(RedSteelWrenchItem);

		
		if (config != null) {
			config.save();
		}
	}
	
	private static int getItemID(Configuration config, String heading, String item, int value) {
		if (config == null)	{
			return value;
		}
		try	{
			Property prop = config.get(heading, item, value);
			return prop.getInt(value);
		} catch (Exception e) {
			System.out.println(new StringBuilder().append("[BCTFCcrossover] ERROR adding Integer, config NOT loaded properly!").toString());
		}
		return value;
	}
	
	public static Item createPipe(int defaultID, Class<? extends Pipe> clas, String descr) {
		String name = Character.toLowerCase(clas.getSimpleName().charAt(0)) + clas.getSimpleName().substring(1);
		ItemPipe res = BlockGenericPipe.registerPipe(defaultID, clas);
		res.setUnlocalizedName(clas.getSimpleName());
		LanguageRegistry.addName(res, descr);
		return res;
	}
}