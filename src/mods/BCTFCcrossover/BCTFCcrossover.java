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
