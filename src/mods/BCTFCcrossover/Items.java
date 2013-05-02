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
import mods.BCTFCcrossover.pipes.liquids.TinPipeLiquidsItem;
import mods.BCTFCcrossover.pipes.power.CopperPipePowerItem;
import mods.BCTFCcrossover.pipes.power.SilverPipePowerItem;
import mods.BCTFCcrossover.pipes.power.TinPipePowerItem;
import mods.BCTFCcrossover.pipes.power.ZincPipePowerItem;
import mods.BCTFCcrossover.pipes.transport.TinPipeItem;
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
	public static Item WroughtIronPipeFrameItem;
	
	public static Item TinPipeItem;
	public static Item TinPipeFrameItem;
	public static Item TinPipeLiquidsItem;
	public static Item TinPipePowerItem;
	public static Item ZincPipeFrameItem;
	public static Item ZincPipePowerItem;
	public static Item CopperPipeFrameItem;
	public static Item CopperPipePowerItem;
	public static Item SilverPipeFrameItem;
	public static Item SilverPipePowerItem;
	
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
		GearPlanItem = (ItemGeneral) new ItemGeneral(getItemID(config,"item","GearPlanItem",ItemIDProvider.GearPlanItem)).setUnlocalizedName("GearPlanItem");
		GearPlanItem.setSize(EnumSize.MEDIUM); GearPlanItem.setWeight(EnumWeight.LIGHT);
		LanguageRegistry.addName(GearPlanItem, "Plan: Gear");
		BCTFCcrossover.proxy.registerItem(GearPlanItem);
		
		WrenchPlanItem = (ItemGeneral) new ItemGeneral(getItemID(config,"item","WrenchPlanItem",ItemIDProvider.WrenchPlanItem)).setUnlocalizedName("WrenchPlanItem");
		WrenchPlanItem.setSize(EnumSize.MEDIUM); WrenchPlanItem.setWeight(EnumWeight.LIGHT);
		LanguageRegistry.addName(WrenchPlanItem, "Plan: Wranch");
		BCTFCcrossover.proxy.registerItem(WrenchPlanItem);
		
		PipeFramePlanItem = (ItemGeneral) new ItemGeneral(getItemID(config,"item","PipeFramePlanItem",ItemIDProvider.PipeFramePlanItem)).setUnlocalizedName("PipeFramePlanItem");
		PipeFramePlanItem.setSize(EnumSize.MEDIUM); PipeFramePlanItem.setWeight(EnumWeight.LIGHT);
		LanguageRegistry.addName(PipeFramePlanItem, "Plan: Pipe Frame");
		BCTFCcrossover.proxy.registerItem(PipeFramePlanItem);
		
		// ===============Gears=======================
		
		// Not needed at the moment
//		BismuthGearItem = new ItemGeneral(getItemID(config,"item","BismuthGearItem",ItemIDProvider.)).setUnlocalizedName("BismuthGearItem");
//		LanguageRegistry.addName(BismuthGearItem, "Gear: Bismuth");
//		BCTFCcrossover.proxy.registerItem(BismuthGearItem);
//		TinGearItem = new ItemGeneral(getItemID(config,"item","TinGearItem",ItemIDProvider.)).setUnlocalizedName("TinGearItem");
//		LanguageRegistry.addName(TinGearItem, "Gear: Tin");
//		BCTFCcrossover.proxy.registerItem(TinGearItem);
//		ZincGearItem = new ItemGeneral(getItemID(config,"item","ZincGearItem",ItemIDProvider.)).setUnlocalizedName("ZincGearItem");
//		LanguageRegistry.addName(ZincGearItem, "Gear: Zinc");
//		BCTFCcrossover.proxy.registerItem(ZincGearItem);
//		CopperGearItem = new ItemGeneral(getItemID(config,"item","CopperGearItem",ItemIDProvider.)).setUnlocalizedName("CopperGearItem");
//		LanguageRegistry.addName(CopperGearItem, "Gear: Copper");
//		BCTFCcrossover.proxy.registerItem(CopperGearItem);

		BismuthBronzeGearItem = new ItemGeneral(getItemID(config,"item","BismuthBronzeGearItem",ItemIDProvider.BismuthBronzeGearItem)).setUnlocalizedName("BismuthBronzeGearItem");
		LanguageRegistry.addName(BismuthBronzeGearItem, "Gear: Bismuth Bronze");
		BCTFCcrossover.proxy.registerItem(BismuthBronzeGearItem);
		BlackBronzeGearItem = new ItemGeneral(getItemID(config,"item","BlackBronzeGearItem",ItemIDProvider.BlackBronzeGearItem)).setUnlocalizedName("BlackBronzeGearItem");
		LanguageRegistry.addName(BlackBronzeGearItem, "Gear: Black Bronze");
		BCTFCcrossover.proxy.registerItem(BlackBronzeGearItem);
		BronzeGearItem = new ItemGeneral(getItemID(config,"item","BronzeGearItem",ItemIDProvider.BronzeGearItem)).setUnlocalizedName("BronzeGearItem");
		LanguageRegistry.addName(BronzeGearItem, "Gear: Bronze");
		BCTFCcrossover.proxy.registerItem(BronzeGearItem);
		RoseGoldGearItem = new ItemGeneral(getItemID(config,"item","RoseGoldGearItem",ItemIDProvider.RoseGoldGearItem)).setUnlocalizedName("RoseGoldGearItem");
		LanguageRegistry.addName(RoseGoldGearItem, "Gear: Rose Gold");
		BCTFCcrossover.proxy.registerItem(RoseGoldGearItem);
		
		WroughtIronGearItem = new ItemGeneral(getItemID(config,"item","WroughtIronGearItem",ItemIDProvider.WroughtIronGearItem)).setUnlocalizedName("WroughtIronGearItem");
		LanguageRegistry.addName(WroughtIronGearItem, "Gear: Wrought Iron");
		BCTFCcrossover.proxy.registerItem(WroughtIronGearItem);

		SteelGearItem = new ItemGeneral(getItemID(config,"item","SteelGearItem",ItemIDProvider.SteelGearItem)).setUnlocalizedName("SteelGearItem");
		LanguageRegistry.addName(SteelGearItem, "Gear: Steel");
		BCTFCcrossover.proxy.registerItem(SteelGearItem);
		
		BlackSteelGearItem = new ItemGeneral(getItemID(config,"item","BlackSteelGearItem",ItemIDProvider.BlackSteelGearItem)).setUnlocalizedName("BlackSteelGearItem");
		LanguageRegistry.addName(BlackSteelGearItem, "Gear: Black Steel");
		BCTFCcrossover.proxy.registerItem(BlackSteelGearItem);
		
		BlueSteelGearItem = new ItemGeneral(getItemID(config,"item","BlueSteelGearItem",ItemIDProvider.BlueSteelGearItem)).setUnlocalizedName("BlueSteelGearItem");
		LanguageRegistry.addName(BlueSteelGearItem, "Gear: Blue Steel");
		BCTFCcrossover.proxy.registerItem(BlueSteelGearItem);
		RedSteelGearItem = new ItemGeneral(getItemID(config,"item","RedSteelGearItem",ItemIDProvider.RedSteelGearItem)).setUnlocalizedName("RedSteelGearItem");
		LanguageRegistry.addName(RedSteelGearItem, "Gear: Red Steel");
		BCTFCcrossover.proxy.registerItem(RedSteelGearItem);
		
		// Bucket
		WoodBucketOil = new ItemWoodBucketOil(getItemID(config, "item", "WoodBucketOil", ItemIDProvider.WoodBucketOil)).setUnlocalizedName("WoodBucketOil");
		LanguageRegistry.addName(WoodBucketOil, "Wooden Bucket with Oil");
		BCTFCcrossover.proxy.registerItem(WoodBucketOil);
		
		// Pipe Frames
		WroughtIronPipeFrameItem = new ItemGeneral(getItemID(config,"item","WroughtIronPipeFrameItem",ItemIDProvider.WroughtIronPipeFrameItem)).setUnlocalizedName("WroughtIronPipeFrameItem");
		LanguageRegistry.addName(WroughtIronPipeFrameItem, "Wrought Iron Pipe Frame");
		BCTFCcrossover.proxy.registerItem(WroughtIronPipeFrameItem);
		// Tin Pipe replaces Wood Pipe
		TinPipeFrameItem = new ItemGeneral(getItemID(config,"pipes","TinPipeFrameItem",ItemIDProvider.TinPipeFrameItem)).setUnlocalizedName("TinPipeFrameItem");
		LanguageRegistry.addName(TinPipeFrameItem, "Tin Pipe Frame");
		BCTFCcrossover.proxy.registerItem(TinPipeFrameItem);
		TinPipeItem = createPipe(getItemID(config,"pipes","TinPipeItem",ItemIDProvider.TinPipeItem), TinPipeItem.class, "Tin Transport Pipe");
		BCTFCcrossover.proxy.registerItem(TinPipeItem);
		TinPipeLiquidsItem = createPipe(getItemID(config,"pipes","TinPipeLiquidsItem",ItemIDProvider.TinPipeLiquidsItem), TinPipeLiquidsItem.class, "Tin Waterproof Pipe");
		BCTFCcrossover.proxy.registerItem(TinPipeLiquidsItem);
		TinPipePowerItem = createPipe(getItemID(config,"pipes","TinPipePowerItem",ItemIDProvider.TinPipePowerItem), TinPipePowerItem.class, "Tin Conductive Pipe");
		BCTFCcrossover.proxy.registerItem(TinPipePowerItem);
		// Zinc Pipe replaces Stone Power Pipe
		ZincPipeFrameItem = new ItemGeneral(getItemID(config,"pipes","ZincPipeFrameItem",ItemIDProvider.ZincPipeFrameItem)).setUnlocalizedName("ZincPipeFrameItem");
		LanguageRegistry.addName(ZincPipeFrameItem, "Zinc Pipe Frame");
		BCTFCcrossover.proxy.registerItem(ZincPipeFrameItem);
		ZincPipePowerItem = createPipe(getItemID(config,"pipes","ZincPipePowerItem",ItemIDProvider.ZincPipePowerItem), ZincPipePowerItem.class, "Zinc Condictive Pipe");
		BCTFCcrossover.proxy.registerItem(ZincPipePowerItem);
		// Copper Pipe replaces Gold Power Pipe
		CopperPipeFrameItem = new ItemGeneral(getItemID(config,"pipes","CopperPipeFrameItem",ItemIDProvider.CopperPipeFrameItem)).setUnlocalizedName("CopperPipeFrameItem");
		LanguageRegistry.addName(CopperPipeFrameItem, "Copper Pipe Frame");
		BCTFCcrossover.proxy.registerItem(CopperPipeFrameItem);
		CopperPipePowerItem = createPipe(getItemID(config,"pipes","CopperPipePowerItem",ItemIDProvider.CopperPipePowerItem), CopperPipePowerItem.class, "Copper Condictive Pipe");
		BCTFCcrossover.proxy.registerItem(CopperPipePowerItem);
		// Silver Power Pipe added for perfect conductivity
		SilverPipeFrameItem = new ItemGeneral(getItemID(config,"pipes","SilverPipeFrameItem",ItemIDProvider.SilverPipeFrameItem)).setUnlocalizedName("SilverPipeFrameItem");
		LanguageRegistry.addName(SilverPipeFrameItem, "Silver Pipe Frame");
		BCTFCcrossover.proxy.registerItem(SilverPipeFrameItem);
		SilverPipePowerItem = createPipe(getItemID(config,"pipes","SilverPipePowerItem",ItemIDProvider.SilverPipePowerItem), SilverPipePowerItem.class, "Silver Condictive Pipe");
		BCTFCcrossover.proxy.registerItem(SilverPipePowerItem);
		
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