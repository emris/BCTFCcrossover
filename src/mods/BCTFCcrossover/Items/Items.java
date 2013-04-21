package mods.BCTFCcrossover.Items;

import java.io.File;

import mods.BCTFCcrossover.BCTFCcrossover;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Items {
	public static Item gearPlanItem;
	public static Item wranchPlanItem;
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
	
	static Configuration config;
	
	public static void LoadItems() {
        try {
            config = new Configuration(new File(BCTFCcrossover.proxy.getMinecraftDir(), "/config/BCTFCcrossover.cfg"));
            config.load();
        } catch (Exception e) {
            System.out.println(new StringBuilder().append("[BCTFCcrossover] Config file ERROR!").toString());
            config = null;
        }
		
		int num = 17500;
		// Plans
		gearPlanItem = new ItemPlan(getItemID(config,"item","gearPlanItem",num)).setUnlocalizedName("gearPlanItem");num++;
		LanguageRegistry.addName(gearPlanItem, "Plan: Gear");
		BCTFCcrossover.proxy.registerItem(gearPlanItem);
		wranchPlanItem = new ItemPlan(getItemID(config,"item","wranchPlanItem",num)).setUnlocalizedName("wranchPlanItem");num++;
		LanguageRegistry.addName(wranchPlanItem, "Plan: Wranch");
		BCTFCcrossover.proxy.registerItem(wranchPlanItem);
		
		// ===============Gears=======================
		
		// Not needed at the moment
//		BismuthGearItem = new ItemPlan(getItemID(config,"item","BismuthGearItem",num)).setUnlocalizedName("BismuthGearItem");num++;
//		LanguageRegistry.addName(BismuthGearItem, "Gear: Bismuth");
//		BCTFCcrossover.proxy.registerItem(BismuthGearItem);
//		TinGearItem = new ItemPlan(getItemID(config,"item","TinGearItem",num)).setUnlocalizedName("TinGearItem");num++;
//		LanguageRegistry.addName(TinGearItem, "Gear: Tin");
//		BCTFCcrossover.proxy.registerItem(TinGearItem);
//		ZincGearItem = new ItemPlan(getItemID(config,"item","ZincGearItem",num)).setUnlocalizedName("ZincGearItem");num++;
//		LanguageRegistry.addName(ZincGearItem, "Gear: Zinc");
//		BCTFCcrossover.proxy.registerItem(ZincGearItem);
//		CopperGearItem = new ItemPlan(getItemID(config,"item","CopperGearItem",num)).setUnlocalizedName("CopperGearItem");num++;
//		LanguageRegistry.addName(CopperGearItem, "Gear: Copper");
//		BCTFCcrossover.proxy.registerItem(CopperGearItem);

		BismuthBronzeGearItem = new ItemPlan(getItemID(config,"item","BismuthBronzeGearItem",num)).setUnlocalizedName("BismuthBronzeGearItem");num++;
		LanguageRegistry.addName(BismuthBronzeGearItem, "Gear: Bismuth Bronze");
		BCTFCcrossover.proxy.registerItem(BismuthBronzeGearItem);
		BlackBronzeGearItem = new ItemPlan(getItemID(config,"item","BlackBronzeGearItem",num)).setUnlocalizedName("BlackBronzeGearItem");num++;
		LanguageRegistry.addName(BlackBronzeGearItem, "Gear: Black Bronze");
		BCTFCcrossover.proxy.registerItem(BlackBronzeGearItem);
		BronzeGearItem = new ItemPlan(getItemID(config,"item","BronzeGearItem",num)).setUnlocalizedName("BronzeGearItem");num++;
		LanguageRegistry.addName(BronzeGearItem, "Gear: Bronze");
		BCTFCcrossover.proxy.registerItem(BronzeGearItem);
		RoseGoldGearItem = new ItemPlan(getItemID(config,"item","RoseGoldGearItem",num)).setUnlocalizedName("RoseGoldGearItem");num++;
		LanguageRegistry.addName(RoseGoldGearItem, "Gear: Rose Gold");
		BCTFCcrossover.proxy.registerItem(RoseGoldGearItem);
		
		WroughtIronGearItem = new ItemPlan(getItemID(config,"item","WroughtIronGearItem",num)).setUnlocalizedName("WroughtIronGearItem");num++;
		LanguageRegistry.addName(WroughtIronGearItem, "Gear: Wrought Iron");
		BCTFCcrossover.proxy.registerItem(WroughtIronGearItem);

		SteelGearItem = new ItemPlan(getItemID(config,"item","SteelGearItem",num)).setUnlocalizedName("SteelGearItem");num++;
		LanguageRegistry.addName(SteelGearItem, "Gear: Steel");
		BCTFCcrossover.proxy.registerItem(SteelGearItem);
		
		BlackSteelGearItem = new ItemPlan(getItemID(config,"item","BlackSteelGearItem",num)).setUnlocalizedName("BlackSteelGearItem");num++;
		LanguageRegistry.addName(BlackSteelGearItem, "Gear: Black Steel");
		BCTFCcrossover.proxy.registerItem(BlackSteelGearItem);
		
		BlueSteelGearItem = new ItemPlan(getItemID(config,"item","BlueSteelGearItem",num)).setUnlocalizedName("BlueSteelGearItem");num++;
		LanguageRegistry.addName(BlueSteelGearItem, "Gear: Blue Steel");
		BCTFCcrossover.proxy.registerItem(BlueSteelGearItem);
		RedSteelGearItem = new ItemPlan(getItemID(config,"item","RedSteelGearItem",num)).setUnlocalizedName("RedSteelGearItem");num++;
		LanguageRegistry.addName(RedSteelGearItem, "Gear: Red Steel");
		BCTFCcrossover.proxy.registerItem(RedSteelGearItem);
		
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
}