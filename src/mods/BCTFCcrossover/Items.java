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

import mods.BCTFCcrossover.core.ItemIDProvider;
import mods.BCTFCcrossover.items.ItemGeneral;
import mods.BCTFCcrossover.items.ItemWoodBucketOil;
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
import TFC.Enums.EnumSize;
import TFC.Enums.EnumWeight;
import buildcraft.transport.BlockGenericPipe;
import buildcraft.transport.ItemPipe;
import buildcraft.transport.Pipe;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Items {
	public static ItemGeneral GearPlanItem;
	public static ItemGeneral WrenchPlanItem;
	public static ItemGeneral PipeFramePlanItem;
	public static Item BismuthGearItem;
	public static Item BismuthBronzeGearItem;
	public static Item BlackBronzeGearItem;
	public static Item BlackSteelGearItem;
	public static Item BlueSteelGearItem;
	public static Item BronzeGearItem;
	public static Item CopperGearItem;
	public static Item WroughtIronGearItem;
	public static Item RedSteelGearItem;
	public static Item RoseGoldGearItem;
	public static Item SteelGearItem;
	public static Item TinGearItem;
	public static Item ZincGearItem;

	public static Item WoodBucketOil;
	
	public static Item TinPipeFrameItem;
	public static Item LeadPipeFrameItem;
	public static Item BronzePipeFrameItem;
	public static Item WroughtIronPipeFrameItem;
	public static Item SteelPipeFrameItem;
	public static Item BlueSteelPipeFrameItem;
	public static Item RedSteelPipeFrameItem;
	public static Item BlackBronzePipeFrameItem;
	public static Item RoseGoldPipeFrameItem;
	public static Item BlackSteelPipeFrameItem;
	public static Item ZincPipeFrameItem;
	public static Item CopperPipeFrameItem;
	public static Item SilverPipeFrameItem;
	
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
	
	static Configuration config;
	
	public static void LoadItems() {
        try {
            config = new Configuration(new File(BCTFCcrossover.proxy.getMinecraftDir(), "/config/BCTFCcrossover.cfg"));
            config.load();
        } catch (Exception e) {
            System.out.println(new StringBuilder().append("[BCTFCcrossover] Config file ERROR!").toString());
            config = null;
        }
		
		// Plans
		GearPlanItem = (ItemGeneral) new ItemGeneral(getItemID(config,"plans","GearPlanItem",ItemIDProvider.GearPlanItem)).setUnlocalizedName("GearPlanItem");
			GearPlanItem.setSize(EnumSize.MEDIUM); GearPlanItem.setWeight(EnumWeight.LIGHT);
			LanguageRegistry.addName(GearPlanItem, "Plan: Gear");
			BCTFCcrossover.proxy.registerItem(GearPlanItem);
		WrenchPlanItem = (ItemGeneral) new ItemGeneral(getItemID(config,"plans","WrenchPlanItem",ItemIDProvider.WrenchPlanItem)).setUnlocalizedName("WrenchPlanItem");
			WrenchPlanItem.setSize(EnumSize.MEDIUM); WrenchPlanItem.setWeight(EnumWeight.LIGHT);
			LanguageRegistry.addName(WrenchPlanItem, "Plan: Wranch");
			BCTFCcrossover.proxy.registerItem(WrenchPlanItem);
		PipeFramePlanItem = (ItemGeneral) new ItemGeneral(getItemID(config,"plans","PipeFramePlanItem",ItemIDProvider.PipeFramePlanItem)).setUnlocalizedName("PipeFramePlanItem");
			PipeFramePlanItem.setSize(EnumSize.MEDIUM); PipeFramePlanItem.setWeight(EnumWeight.LIGHT);
			LanguageRegistry.addName(PipeFramePlanItem, "Plan: Pipe Frame");
			BCTFCcrossover.proxy.registerItem(PipeFramePlanItem);
		
		// ===============Gears=======================
		
		// Not needed at the moment
//		BismuthGearItem = new ItemGeneral(getItemID(config,"gears","BismuthGearItem",ItemIDProvider.)).setUnlocalizedName("BismuthGearItem");
//			LanguageRegistry.addName(BismuthGearItem, "Gear: Bismuth");
//			BCTFCcrossover.proxy.registerItem(BismuthGearItem);
//		TinGearItem = new ItemGeneral(getItemID(config,"gears","TinGearItem",ItemIDProvider.)).setUnlocalizedName("TinGearItem");
//			LanguageRegistry.addName(TinGearItem, "Gear: Tin");
//			BCTFCcrossover.proxy.registerItem(TinGearItem);
//		ZincGearItem = new ItemGeneral(getItemID(config,"gears","ZincGearItem",ItemIDProvider.)).setUnlocalizedName("ZincGearItem");
//			LanguageRegistry.addName(ZincGearItem, "Gear: Zinc");
//			BCTFCcrossover.proxy.registerItem(ZincGearItem);
//		CopperGearItem = new ItemGeneral(getItemID(config,"gears","CopperGearItem",ItemIDProvider.)).setUnlocalizedName("CopperGearItem");
//			LanguageRegistry.addName(CopperGearItem, "Gear: Copper");
//			BCTFCcrossover.proxy.registerItem(CopperGearItem);
		BismuthBronzeGearItem = new ItemGeneral(getItemID(config,"gears","BismuthBronzeGearItem",ItemIDProvider.BismuthBronzeGearItem)).setUnlocalizedName("BismuthBronzeGearItem");
			LanguageRegistry.addName(BismuthBronzeGearItem, "Gear: Bismuth Bronze");
			BCTFCcrossover.proxy.registerItem(BismuthBronzeGearItem);
		BlackBronzeGearItem = new ItemGeneral(getItemID(config,"gears","BlackBronzeGearItem",ItemIDProvider.BlackBronzeGearItem)).setUnlocalizedName("BlackBronzeGearItem");
			LanguageRegistry.addName(BlackBronzeGearItem, "Gear: Black Bronze");
			BCTFCcrossover.proxy.registerItem(BlackBronzeGearItem);
		BronzeGearItem = new ItemGeneral(getItemID(config,"gears","BronzeGearItem",ItemIDProvider.BronzeGearItem)).setUnlocalizedName("BronzeGearItem");
			LanguageRegistry.addName(BronzeGearItem, "Gear: Bronze");
			BCTFCcrossover.proxy.registerItem(BronzeGearItem);
		RoseGoldGearItem = new ItemGeneral(getItemID(config,"gears","RoseGoldGearItem",ItemIDProvider.RoseGoldGearItem)).setUnlocalizedName("RoseGoldGearItem");
			LanguageRegistry.addName(RoseGoldGearItem, "Gear: Rose Gold");
			BCTFCcrossover.proxy.registerItem(RoseGoldGearItem);
		WroughtIronGearItem = new ItemGeneral(getItemID(config,"gears","WroughtIronGearItem",ItemIDProvider.WroughtIronGearItem)).setUnlocalizedName("WroughtIronGearItem");
			LanguageRegistry.addName(WroughtIronGearItem, "Gear: Wrought Iron");
			BCTFCcrossover.proxy.registerItem(WroughtIronGearItem);
		SteelGearItem = new ItemGeneral(getItemID(config,"gears","SteelGearItem",ItemIDProvider.SteelGearItem)).setUnlocalizedName("SteelGearItem");
			LanguageRegistry.addName(SteelGearItem, "Gear: Steel");
			BCTFCcrossover.proxy.registerItem(SteelGearItem);
		BlackSteelGearItem = new ItemGeneral(getItemID(config,"gears","BlackSteelGearItem",ItemIDProvider.BlackSteelGearItem)).setUnlocalizedName("BlackSteelGearItem");
			LanguageRegistry.addName(BlackSteelGearItem, "Gear: Black Steel");
			BCTFCcrossover.proxy.registerItem(BlackSteelGearItem);
		BlueSteelGearItem = new ItemGeneral(getItemID(config,"gears","BlueSteelGearItem",ItemIDProvider.BlueSteelGearItem)).setUnlocalizedName("BlueSteelGearItem");
			LanguageRegistry.addName(BlueSteelGearItem, "Gear: Blue Steel");
			BCTFCcrossover.proxy.registerItem(BlueSteelGearItem);
		RedSteelGearItem = new ItemGeneral(getItemID(config,"gears","RedSteelGearItem",ItemIDProvider.RedSteelGearItem)).setUnlocalizedName("RedSteelGearItem");
			LanguageRegistry.addName(RedSteelGearItem, "Gear: Red Steel");
			BCTFCcrossover.proxy.registerItem(RedSteelGearItem);
		
		// ===============Bucket===============
		WoodBucketOil = new ItemWoodBucketOil(getItemID(config, "items", "WoodBucketOil", ItemIDProvider.WoodBucketOil)).setUnlocalizedName("WoodBucketOil");
			LanguageRegistry.addName(WoodBucketOil, "Wooden Bucket with Oil");
			BCTFCcrossover.proxy.registerItem(WoodBucketOil);
		
		// ===============Pipe Frames===============
		TinPipeFrameItem = new ItemGeneral(getItemID(config,"pipe frames","TinPipeFrameItem",ItemIDProvider.TinPipeFrameItem)).setUnlocalizedName("TinPipeFrameItem");
			LanguageRegistry.addName(TinPipeFrameItem, "Frame: Tin Pipe");
			BCTFCcrossover.proxy.registerItem(TinPipeFrameItem);
		LeadPipeFrameItem = new ItemGeneral(getItemID(config,"pipe frames","LeadPipeFrameItem",ItemIDProvider.LeadPipeFrameItem)).setUnlocalizedName("LeadPipeFrameItem");
			LanguageRegistry.addName(LeadPipeFrameItem, "Frame: Lead Pipe");
			BCTFCcrossover.proxy.registerItem(LeadPipeFrameItem);
		BronzePipeFrameItem = new ItemGeneral(getItemID(config,"pipe frames","BronzePipeFrameItem",ItemIDProvider.BronzePipeFrameItem)).setUnlocalizedName("BronzePipeFrameItem");
			LanguageRegistry.addName(BronzePipeFrameItem, "Frame: Bronze Pipe");
			BCTFCcrossover.proxy.registerItem(BronzePipeFrameItem);
		WroughtIronPipeFrameItem = new ItemGeneral(getItemID(config,"pipe frames","WroughtIronPipeFrameItem",ItemIDProvider.WroughtIronPipeFrameItem)).setUnlocalizedName("WroughtIronPipeFrameItem");
			LanguageRegistry.addName(WroughtIronPipeFrameItem, "Frame: Wrought Iron Pipe");
			BCTFCcrossover.proxy.registerItem(WroughtIronPipeFrameItem);
		SteelPipeFrameItem = new ItemGeneral(getItemID(config,"pipe frames","SteelPipeFrameItem",ItemIDProvider.SteelPipeFrameItem)).setUnlocalizedName("SteelPipeFrameItem");
			LanguageRegistry.addName(SteelPipeFrameItem, "Frame: Steel Pipe");
			BCTFCcrossover.proxy.registerItem(SteelPipeFrameItem);
		BlueSteelPipeFrameItem = new ItemGeneral(getItemID(config,"pipe frames","BlueSteelPipeFrameItem",ItemIDProvider.BlueSteelPipeFrameItem)).setUnlocalizedName("BlueSteelPipeFrameItem");
			LanguageRegistry.addName(BlueSteelPipeFrameItem, "Frame: Blue Steel Pipe");
			BCTFCcrossover.proxy.registerItem(BlueSteelPipeFrameItem);
		RedSteelPipeFrameItem = new ItemGeneral(getItemID(config,"pipe frames","RedSteelPipeFrameItem",ItemIDProvider.RedSteelPipeFrameItem)).setUnlocalizedName("RedSteelPipeFrameItem");
			LanguageRegistry.addName(RedSteelPipeFrameItem, "Frame: Red Steel Pipe");
			BCTFCcrossover.proxy.registerItem(RedSteelPipeFrameItem);
		BlackBronzePipeFrameItem = new ItemGeneral(getItemID(config,"pipe frames","BlackBronzePipeFrameItem",ItemIDProvider.BlackBronzePipeFrameItem)).setUnlocalizedName("BlackBronzePipeFrameItem");
			LanguageRegistry.addName(BlackBronzePipeFrameItem, "Frame: Black Bronze Pipe");
			BCTFCcrossover.proxy.registerItem(BlackBronzePipeFrameItem);
		RoseGoldPipeFrameItem = new ItemGeneral(getItemID(config,"pipe frames","RoseGoldPipeFrameItem",ItemIDProvider.RoseGoldPipeFrameItem)).setUnlocalizedName("RoseGoldPipeFrameItem");
			LanguageRegistry.addName(RoseGoldPipeFrameItem, "Frame: Rose Gold Pipe");
			BCTFCcrossover.proxy.registerItem(RoseGoldPipeFrameItem);
		BlackSteelPipeFrameItem = new ItemGeneral(getItemID(config,"pipe frames","BlackSteelPipeFrameItem",ItemIDProvider.BlackSteelPipeFrameItem)).setUnlocalizedName("BlackSteelPipeFrameItem");
			LanguageRegistry.addName(BlackSteelPipeFrameItem, "Frame: Black Steel Pipe");
			BCTFCcrossover.proxy.registerItem(BlackSteelPipeFrameItem);
		ZincPipeFrameItem = new ItemGeneral(getItemID(config,"pipe frames","ZincPipeFrameItem",ItemIDProvider.ZincPipeFrameItem)).setUnlocalizedName("ZincPipeFrameItem");
			LanguageRegistry.addName(ZincPipeFrameItem, "Frame: Zinc Pipe");
			BCTFCcrossover.proxy.registerItem(ZincPipeFrameItem);
		CopperPipeFrameItem = new ItemGeneral(getItemID(config,"pipe frames","CopperPipeFrameItem",ItemIDProvider.CopperPipeFrameItem)).setUnlocalizedName("CopperPipeFrameItem");
			LanguageRegistry.addName(CopperPipeFrameItem, "Frame: Copper Pipe");
			BCTFCcrossover.proxy.registerItem(CopperPipeFrameItem);
		SilverPipeFrameItem = new ItemGeneral(getItemID(config,"pipe frames","SilverPipeFrameItem",ItemIDProvider.SilverPipeFrameItem)).setUnlocalizedName("SilverPipeFrameItem");
			LanguageRegistry.addName(SilverPipeFrameItem, "Frame: Silver Pipe");
			BCTFCcrossover.proxy.registerItem(SilverPipeFrameItem);

		// ===============Transport Pipes===============
		Item.itemsList[ItemIDProvider.WoodPipe] = null;
		TinPipeItem = createPipe(getItemID(config,"pipes","TinPipeItem",ItemIDProvider.TinPipeItem), TinPipeItem.class, "Extraction Pipe");
		BCTFCcrossover.proxy.registerItem(TinPipeItem);

		Item.itemsList[ItemIDProvider.CobblestonePipe] = null;
		LeadPipeItem = createPipe(getItemID(config,"pipes","LeadPipeItem",ItemIDProvider.LeadPipeItem), LeadPipeItem.class, "Transport Pipe 01");
		BCTFCcrossover.proxy.registerItem(LeadPipeItem);

		Item.itemsList[ItemIDProvider.StonePipe] = null;
		BronzePipeItem = createPipe(getItemID(config,"pipes","BronzePipeItem",ItemIDProvider.BronzePipeItem), BronzePipeItem.class, "Transport Pipe 02");
		BCTFCcrossover.proxy.registerItem(BronzePipeItem);
		
		Item.itemsList[ItemIDProvider.IronPipe] = null;
		WroughtIronPipeItem = createPipe(getItemID(config,"pipes","WroughtIronPipeItem",ItemIDProvider.WroughtIronPipeItem), WroughtIronPipeItem.class, "Junction Collector Pipe");
		BCTFCcrossover.proxy.registerItem(WroughtIronPipeItem);

		Item.itemsList[ItemIDProvider.GoldPipe] = null;
		SteelPipeItem = createPipe(getItemID(config,"pipes","SteelPipeItem",ItemIDProvider.SteelPipeItem), SteelPipeItem.class, "Advanced Transport Pipe");
		BCTFCcrossover.proxy.registerItem(SteelPipeItem);
		
		Item.itemsList[ItemIDProvider.DiamondPipe] = null;
		BlueSteelPipeItem = createPipe(getItemID(config,"pipes","BlueSteelPipeItem",ItemIDProvider.BlueSteelPipeItem), BlueSteelPipeItem.class, "Router Pipe");
		BCTFCcrossover.proxy.registerItem(BlueSteelPipeItem);
		
		Item.itemsList[ItemIDProvider.EmeraldPipe] = null;
		RedSteelPipeItem = createPipe(getItemID(config,"pipes","RedSteelPipeItem",ItemIDProvider.RedSteelPipeItem), RedSteelPipeItem.class, "Filter Extraction Pipe");
		BCTFCcrossover.proxy.registerItem(RedSteelPipeItem);
		
		Item.itemsList[ItemIDProvider.VoidPipe] = null;
		BlackBronzePipeItem = createPipe(getItemID(config,"pipes","BlackBronzePipeItem",ItemIDProvider.BlackBronzePipeItem), BlackBronzePipeItem.class, "Void Pipe");
		BCTFCcrossover.proxy.registerItem(BlackBronzePipeItem);
		
		Item.itemsList[ItemIDProvider.SandstonePipe] = null;
		RoseGoldPipeItem = createPipe(getItemID(config,"pipes","RoseGoldPipeItem",ItemIDProvider.RoseGoldPipeItem), RoseGoldPipeItem.class, "Transport Pipe Connector");
		BCTFCcrossover.proxy.registerItem(RoseGoldPipeItem);
		
		Item.itemsList[ItemIDProvider.ObsidianPipe] = null;
		BlackSteelPipeItem = createPipe(getItemID(config,"pipes","BlackSteelPipeItem",ItemIDProvider.BlackSteelPipeItem), BlackSteelPipeItem.class, "Suction Pipe");
		BCTFCcrossover.proxy.registerItem(BlackSteelPipeItem);

		// ===============Liquid Pipes===============
		Item.itemsList[ItemIDProvider.WoodPipeLiquids] = null;
		TinPipeLiquidsItem = createPipe(getItemID(config,"pipes","TinPipeLiquidsItem",ItemIDProvider.TinPipeLiquidsItem), TinPipeLiquidsItem.class, "Liquids Extraction Pipe");
		BCTFCcrossover.proxy.registerItem(TinPipeLiquidsItem);
		
		Item.itemsList[ItemIDProvider.CobblestonePipeLiquids] = null;
		LeadPipeLiquidsItem = createPipe(getItemID(config,"pipes","LeadPipeLiquidsItem",ItemIDProvider.LeadPipeLiquidsItem), LeadPipeLiquidsItem.class, "Liquids Transport Pipe 01");
		BCTFCcrossover.proxy.registerItem(LeadPipeLiquidsItem);
		
		Item.itemsList[ItemIDProvider.StonePipeLiquids] = null;
		BronzePipeLiquidsItem = createPipe(getItemID(config,"pipes","BronzePipeLiquidsItem",ItemIDProvider.BronzePipeLiquidsItem), BronzePipeLiquidsItem.class, "Liquids Transport Pipe 02");
		BCTFCcrossover.proxy.registerItem(BronzePipeLiquidsItem);
		
		Item.itemsList[ItemIDProvider.IronPipeLiquids] = null;
		WroughtIronPipeLiquidsItem = createPipe(getItemID(config,"pipes","WroughtIronPipeLiquidsItem",ItemIDProvider.WroughtIronPipeLiquidsItem), WroughtIronPipeLiquidsItem.class, "Liquids Junction Collector Pipe");
		BCTFCcrossover.proxy.registerItem(WroughtIronPipeLiquidsItem);
		
		Item.itemsList[ItemIDProvider.GoldPipeLiquids] = null;
		SteelPipeLiquidsItem = createPipe(getItemID(config,"pipes","SteelPipeLiquidsItem",ItemIDProvider.SteelPipeLiquidsItem), SteelPipeLiquidsItem.class, "Advanced Liquids Transport Pipe");
		BCTFCcrossover.proxy.registerItem(SteelPipeLiquidsItem);
		
		Item.itemsList[ItemIDProvider.EmeraldPipeLiquids] = null;
		RedSteelPipeLiquidsItem = createPipe(getItemID(config,"pipes","RedSteelPipeLiquidsItem",ItemIDProvider.RedSteelPipeLiquidsItem), RedSteelPipeLiquidsItem.class, "Advanced Liquids Extraction Pipe");
		BCTFCcrossover.proxy.registerItem(RedSteelPipeLiquidsItem);
		
		Item.itemsList[ItemIDProvider.VoidPipeLiquids] = null;
		BlackBronzePipeLiquidsItem = createPipe(getItemID(config,"pipes","BlackBronzePipeLiquidsItem",ItemIDProvider.BlackBronzePipeLiquidsItem), BlackBronzePipeLiquidsItem.class, "Liquids Void Pipe");
		BCTFCcrossover.proxy.registerItem(BlackBronzePipeLiquidsItem);
		
		Item.itemsList[ItemIDProvider.SandstoneLiquids] = null;
		RoseGoldPipeLiquidsItem = createPipe(getItemID(config,"pipes","RoseGoldPipeLiquidsItem",ItemIDProvider.RoseGoldPipeLiquidsItem), RoseGoldPipeLiquidsItem.class, "Liquids Pipe Connector");
		BCTFCcrossover.proxy.registerItem(RoseGoldPipeLiquidsItem);

		// ===============Power Pipes===============
		Item.itemsList[ItemIDProvider.WoodPipePower] = null;
		TinPipePowerItem = createPipe(getItemID(config,"pipes","TinPipePowerItem",ItemIDProvider.TinPipePowerItem), TinPipePowerItem.class, "Tin Conductive Pipe");
		BCTFCcrossover.proxy.registerItem(TinPipePowerItem);
		
		Item.itemsList[ItemIDProvider.StonePipePower] = null;
		ZincPipePowerItem = createPipe(getItemID(config,"pipes","ZincPipePowerItem",ItemIDProvider.ZincPipePowerItem), ZincPipePowerItem.class, "Zinc Condictive Pipe");
		BCTFCcrossover.proxy.registerItem(ZincPipePowerItem);
		
		Item.itemsList[ItemIDProvider.GoldPipePower] = null;
		CopperPipePowerItem = createPipe(getItemID(config,"pipes","CopperPipePowerItem",ItemIDProvider.CopperPipePowerItem), CopperPipePowerItem.class, "Copper Condictive Pipe");
		BCTFCcrossover.proxy.registerItem(CopperPipePowerItem);
		
		//NEW
		SilverPipePowerItem = createPipe(getItemID(config,"pipes","SilverPipePowerItem",ItemIDProvider.SilverPipePowerItem), SilverPipePowerItem.class, "Silver Condictive Pipe");
		BCTFCcrossover.proxy.registerItem(SilverPipePowerItem);
		
		// ===============Structure Pipes===============
		Item.itemsList[ItemIDProvider.StructurePipeCobblestone] = null;
		LeadPipeStructureItem = createPipe(getItemID(config,"pipes","LeadPipeStructureItem",ItemIDProvider.LeadPipeStructureItem), LeadPipeStructureItem.class, "Structure Pipe");
		BCTFCcrossover.proxy.registerItem(LeadPipeStructureItem);
		
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