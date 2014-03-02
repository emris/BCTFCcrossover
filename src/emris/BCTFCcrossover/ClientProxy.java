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

import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.fluids.Fluid;
import buildcraft.transport.TransportProxyClient;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ClientProxy extends CommonProxy 
{	
	@Override
	public World getCurrentWorld() {
		return ModLoader.getMinecraftInstance().theWorld;
	}

	@Override
	public boolean isRemote() {
		return true;
	}

	@Override
	public File getMinecraftDir() {
		return ModLoader.getMinecraftInstance().mcDataDir;
	}

	/* LOCALIZATION */
	@Override
	public String getCurrentLanguage() {
		return Minecraft.getMinecraft().getLanguageManager().getCurrentLanguage().getLanguageCode();
	}

	@Override
	public void addName(Object obj, String s) {
		LanguageRegistry.addName(obj, s);
	}

	@Override
	public void addLocalization(String s1, String string) {
		LanguageRegistry.instance().addStringLocalization(s1, string);
	}

	@Override
	public String getItemDisplayName(ItemStack stack) {
		if (Item.itemsList[stack.itemID] == null)
			return "";

		return Item.itemsList[stack.itemID].getItemDisplayName(stack);
	}
	
	@Override
	public void registerPipeRenderer() {
		super.registerPipeRenderer();
		// Transport Pipes
		MinecraftForgeClient.registerItemRenderer(Items.TinPipeItem.itemID, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.LeadPipeItem.itemID, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.BronzePipeItem.itemID, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.WroughtIronPipeItem.itemID, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.SteelPipeItem.itemID, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.BlueSteelPipeItem.itemID, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.RedSteelPipeItem.itemID, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.BlackBronzePipeItem.itemID, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.RoseGoldPipeItem.itemID, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.BlackSteelPipeItem.itemID, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.SterlingSilverPipeItem.itemID, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.BrassPipeItem.itemID, TransportProxyClient.pipeItemRenderer);
		// Structure Pipes
		MinecraftForgeClient.registerItemRenderer(Items.LeadPipeStructureItem.itemID, TransportProxyClient.pipeItemRenderer);
		// Liquid Pipes
		MinecraftForgeClient.registerItemRenderer(Items.TinPipeFluidsItem.itemID, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.LeadPipeFluidsItem.itemID, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.BronzePipeFluidsItem.itemID, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.WroughtIronPipeFluidsItem.itemID, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.SteelPipeFluidsItem.itemID, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.RedSteelPipeFluidsItem.itemID, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.BlackBronzePipeFluidsItem.itemID, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.RoseGoldPipeFluidsItem.itemID, TransportProxyClient.pipeItemRenderer);
		// Conductive Pipes
		MinecraftForgeClient.registerItemRenderer(Items.CopperPipePowerItem.itemID, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.RoseGoldPipePowerItem.itemID, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.BlackBronzePipePowerItem.itemID, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.WroughtIronPipePowerItem.itemID, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.SteelPipePowerItem.itemID, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(Items.PlatinumPipePowerItem.itemID, TransportProxyClient.pipeItemRenderer);
	}

	@Override
	public void registerFluidIcons(Fluid f) {
		super.registerFluidIcons(f);
		f.setIcons(Blocks.blockLatex.getIcon(0, 0), Blocks.blockLatex.getIcon(1, 0));
	}
	
}
