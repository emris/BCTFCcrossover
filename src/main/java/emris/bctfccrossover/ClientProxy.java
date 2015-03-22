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
package emris.bctfccrossover;

import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.fluids.Fluid;
import buildcraft.transport.TransportProxyClient;

public class ClientProxy extends CommonProxy
{
	@Override
	public World getCurrentWorld()
	{
		return Minecraft.getMinecraft().theWorld;
	}

	@Override
	public boolean isRemote()
	{
		return true;
	}

	@Override
	public File getMinecraftDir()
	{
		return Minecraft.getMinecraft().mcDataDir;
	}

	@Override
	public String getItemDisplayName(ItemStack stack)
	{
		if (stack.getItem() == null)
			return "";
		
		return stack.getDisplayName();
	}
	
	@Override
	public void registerPipeRenderer()
	{
		super.registerPipeRenderer();
		// Transport Pipes
		MinecraftForgeClient.registerItemRenderer(BCTFCItems.TinPipeItem, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(BCTFCItems.LeadPipeItem, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(BCTFCItems.BronzePipeItem, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(BCTFCItems.WroughtIronPipeItem, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(BCTFCItems.SteelPipeItem, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(BCTFCItems.BlueSteelPipeItem, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(BCTFCItems.RedSteelPipeItem, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(BCTFCItems.BlackBronzePipeItem, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(BCTFCItems.RoseGoldPipeItem, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(BCTFCItems.BlackSteelPipeItem, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(BCTFCItems.SterlingSilverPipeItem, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(BCTFCItems.BrassPipeItem, TransportProxyClient.pipeItemRenderer);
		// Structure Pipes
		MinecraftForgeClient.registerItemRenderer(BCTFCItems.LeadPipeStructureItem, TransportProxyClient.pipeItemRenderer);
		// Liquid Pipes
		MinecraftForgeClient.registerItemRenderer(BCTFCItems.TinPipeFluidsItem, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(BCTFCItems.LeadPipeFluidsItem, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(BCTFCItems.BronzePipeFluidsItem, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(BCTFCItems.WroughtIronPipeFluidsItem, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(BCTFCItems.SteelPipeFluidsItem, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(BCTFCItems.RedSteelPipeFluidsItem, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(BCTFCItems.BlackBronzePipeFluidsItem, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(BCTFCItems.RoseGoldPipeFluidsItem, TransportProxyClient.pipeItemRenderer);
		// Conductive Pipes
		MinecraftForgeClient.registerItemRenderer(BCTFCItems.CopperPipePowerItem, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(BCTFCItems.RoseGoldPipePowerItem, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(BCTFCItems.BlackBronzePipePowerItem, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(BCTFCItems.WroughtIronPipePowerItem, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(BCTFCItems.SteelPipePowerItem, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(BCTFCItems.PlatinumPipePowerItem, TransportProxyClient.pipeItemRenderer);
		MinecraftForgeClient.registerItemRenderer(BCTFCItems.SilverPipePowerItem, TransportProxyClient.pipeItemRenderer);
	}

	@Override
	public void registerFluidIcons(Fluid f)
	{
		super.registerFluidIcons(f);
		f.setIcons(BCTFCBlocks.blockLatex.getIcon(0, 0), BCTFCBlocks.blockLatex.getIcon(1, 0));
	}

	@Override
	public void registerTileEntities(boolean b)
	{
		super.registerTileEntities(false);
	}
}
