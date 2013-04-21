package mods.BCTFCcrossover;

import java.util.logging.Logger;

import mods.BCTFCcrossover.Items.Items;
import mods.BCTFCcrossover.Utils.Localization;
import mods.BCTFCcrossover.Utils.Version;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(name = "BCTFCcrossover", version = Version.VERSION, useMetadata = false, modid = "BCTFCcrossover", dependencies = "required-after:BuildCraft|Core;required-after:BuildCraft|Builders;required-after:BuildCraft|Energy;required-after:BuildCraft|Factory;required-after:BuildCraft|Silicon;required-after:BuildCraft|Transport;required-after:TerraFirmaCraft")
@NetworkMod(clientSideRequired = true, serverSideRequired = true, versionBounds = "[" + Version.VERSION + "]")
public class BCTFCcrossover {
	
	public static Logger tfcbcLog = Logger.getLogger("BCTFCcrossover");
	
	@Instance("BCTFCcrossover")
	public static BCTFCcrossover instance;
	
	@SidedProxy(clientSide = "mods.BCTFCcrossover.ClientProxy", serverSide = "mods.BCTFCcrossover.CommonProxy")
	public static CommonProxy proxy;
	
	@PreInit
	public void loadConfiguration(FMLPreInitializationEvent evt) {

		tfcbcLog.setParent(FMLLog.getLogger());
		tfcbcLog.info("Starting TFCBuildCraft " + Version.getVersion());
		tfcbcLog.info("Copyright (c) Emris_Morath, 2013");
		
		Items.LoadItems();
		
		Localization.addLocalization("/mods/BCTFCcrossover/lang/", "en_US");
	}

	@Init
	public void load(FMLInitializationEvent evt) {
		Recipes.loadRecipes();
	}
}
