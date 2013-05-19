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

import mods.BCTFCcrossover.core.CraftingHandler;
import mods.BCTFCcrossover.core.PipeIconProvider;
import mods.BCTFCcrossover.core.Recipes;
import mods.BCTFCcrossover.core.TextureHandler;
import mods.BCTFCcrossover.utils.Version;
import mods.BCTFCcrossover.worldGen.WorldGenOil;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.liquids.LiquidContainerData;
import net.minecraftforge.liquids.LiquidContainerRegistry;
import net.minecraftforge.liquids.LiquidDictionary;
import TFC.TFCItems;
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
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

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
		
		Blocks.LoadBlocks();
		Blocks.RegisterBlocks();
		Items.LoadItems();
		
		LiquidContainerRegistry.registerLiquid(new LiquidContainerData(LiquidDictionary.getLiquid("Oil", LiquidContainerRegistry.BUCKET_VOLUME), new ItemStack(Items.WoodBuckets, 1, 0), new ItemStack(TFCItems.WoodenBucketEmpty)));
		LiquidContainerRegistry.registerLiquid(new LiquidContainerData(LiquidDictionary.getLiquid("Fuel", LiquidContainerRegistry.BUCKET_VOLUME), new ItemStack(Items.WoodBuckets, 1, 1), new ItemStack(TFCItems.WoodenBucketEmpty)));
		LiquidContainerRegistry.registerLiquid(new LiquidContainerData(LiquidDictionary.getLiquid("Latex", LiquidContainerRegistry.BUCKET_VOLUME), new ItemStack(Items.WoodBuckets, 1, 2), new ItemStack(TFCItems.WoodenBucketEmpty)));
		LiquidContainerRegistry.registerLiquid(new LiquidContainerData(LiquidDictionary.getLiquid("Water", LiquidContainerRegistry.BUCKET_VOLUME), new ItemStack(TFCItems.WoodenBucketWater), new ItemStack(TFCItems.WoodenBucketEmpty)));
		MinecraftForge.EVENT_BUS.register(new TextureHandler());

		GameRegistry.registerWorldGenerator(new WorldGenOil(90, 200));
	}


	
	@Init
	public void load(FMLInitializationEvent evt) {
		proxy.registerOreDict();
		Recipes.loadRecipes();
		proxy.registerPipeRenderer();
		Localization.addLocalization("/lang/BCTFCcrossover/", "en_US");
		
		GameRegistry.registerCraftingHandler(new CraftingHandler());
	}
	
	@ServerStarting
	public void serverStarting(FMLServerStartingEvent event) {
		
	}
}
