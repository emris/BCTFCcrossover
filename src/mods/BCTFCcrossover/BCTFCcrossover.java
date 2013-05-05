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

import java.util.logging.Logger;

import mods.BCTFCcrossover.core.PipeIconProvider;
import mods.BCTFCcrossover.core.Recipes;
import mods.BCTFCcrossover.utils.Version;
import mods.BCTFCcrossover.worldGen.WorldGenOil;
import net.minecraft.block.Block;
import net.minecraftforge.liquids.LiquidDictionary;
import net.minecraftforge.liquids.LiquidStack;
import buildcraft.api.core.IIconProvider;
import buildcraft.core.utils.Localization;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.Mod.ServerStarting;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(name = "BCTFCcrossover", version = Version.VERSION, useMetadata = false, modid = "BCTFCcrossover", dependencies = "required-after:BuildCraft|Core;required-after:BuildCraft|Builders;required-after:BuildCraft|Energy;required-after:BuildCraft|Factory;required-after:BuildCraft|Silicon;required-after:BuildCraft|Transport;required-after:TerraFirmaCraft")
@NetworkMod(clientSideRequired = true, serverSideRequired = true, versionBounds = "[" + Version.VERSION + "]")
public class BCTFCcrossover {
	
	public IIconProvider pipeIconProvider = new PipeIconProvider();
	
	public static Logger tfcbcLog = Logger.getLogger("BCTFCcrossover");
	
	@Instance("BCTFCcrossover")
	public static BCTFCcrossover instance;
	
	@SidedProxy(clientSide = "mods.BCTFCcrossover.ClientProxy", serverSide = "mods.BCTFCcrossover.CommonProxy")
	public static CommonProxy proxy;
	
	@PreInit
	public void loadConfiguration(FMLPreInitializationEvent evt) {

		tfcbcLog.setParent(FMLLog.getLogger());
		tfcbcLog.info("Starting BCTFCcrossover " + Version.getVersion());
		tfcbcLog.info("Copyright (c) emris, 2013");
		
		Items.LoadItems();
		
		GameRegistry.registerWorldGenerator(new WorldGenOil(90, 200));
	}

	@Init
	public void load(FMLInitializationEvent evt) {
		Recipes.loadRecipes();
		proxy.registerPipeRenderer();
		Localization.addLocalization("/lang/BCTFCcrossover/", "en_US");
	}
	
	@ServerStarting
	public void serverStarting(FMLServerStartingEvent event) {
		
	}
}
