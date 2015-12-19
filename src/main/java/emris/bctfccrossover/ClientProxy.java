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
import buildcraft.BuildCraftCore;
import buildcraft.BuildCraftEnergy;
import buildcraft.BuildCraftTransport;
import buildcraft.transport.TransportProxyClient;
import codechicken.nei.api.API;
import cpw.mods.fml.common.Loader;

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
		f.setIcons(BCTFCBlocks.blockLatex.getIcon(0, 0), BCTFCBlocks.blockLatex.getIcon(1, 0));
	}

	@Override
	public void registerTileEntities(boolean b)
	{
		super.registerTileEntities(false);
	}

	@Override
	public void hideCreativeTabItems()
	{
		// Remove BC gears
		BuildCraftCore.woodenGearItem.setCreativeTab(null);
		BuildCraftCore.stoneGearItem.setCreativeTab(null);
		BuildCraftCore.ironGearItem.setCreativeTab(null);
		BuildCraftCore.goldGearItem.setCreativeTab(null);
		BuildCraftCore.diamondGearItem.setCreativeTab(null);

		// Remove BC buckets
		BuildCraftEnergy.bucketFuel.setCreativeTab(null);
		BuildCraftEnergy.bucketOil.setCreativeTab(null);

		// Remove BC transport pipes
		BuildCraftTransport.pipeItemsWood.setCreativeTab(null);
		BuildCraftTransport.pipeItemsCobblestone.setCreativeTab(null);
		BuildCraftTransport.pipeItemsStone.setCreativeTab(null);
		BuildCraftTransport.pipeItemsIron.setCreativeTab(null);
		BuildCraftTransport.pipeItemsGold.setCreativeTab(null);
		BuildCraftTransport.pipeItemsDiamond.setCreativeTab(null);
		BuildCraftTransport.pipeItemsEmerald.setCreativeTab(null);
		BuildCraftTransport.pipeItemsVoid.setCreativeTab(null);
		BuildCraftTransport.pipeItemsSandstone.setCreativeTab(null);
		BuildCraftTransport.pipeItemsObsidian.setCreativeTab(null);
		BuildCraftTransport.pipeItemsDaizuli.setCreativeTab(null);
		BuildCraftTransport.pipeItemsLapis.setCreativeTab(null);
		BuildCraftTransport.pipeItemsQuartz.setCreativeTab(null);
		BuildCraftTransport.pipeItemsEmzuli.setCreativeTab(null);

		// Remove BC fluid pipes
		BuildCraftTransport.pipeFluidsWood.setCreativeTab(null);
		BuildCraftTransport.pipeFluidsCobblestone.setCreativeTab(null);
		BuildCraftTransport.pipeFluidsStone.setCreativeTab(null);
		BuildCraftTransport.pipeFluidsIron.setCreativeTab(null);
		BuildCraftTransport.pipeFluidsGold.setCreativeTab(null);
		BuildCraftTransport.pipeFluidsEmerald.setCreativeTab(null);
		BuildCraftTransport.pipeFluidsVoid.setCreativeTab(null);
		BuildCraftTransport.pipeFluidsSandstone.setCreativeTab(null);

		// Remove BC kinesis pipes
		BuildCraftTransport.pipePowerCobblestone.setCreativeTab(null);
		BuildCraftTransport.pipePowerStone.setCreativeTab(null);
		BuildCraftTransport.pipePowerWood.setCreativeTab(null);
		BuildCraftTransport.pipePowerQuartz.setCreativeTab(null);
		BuildCraftTransport.pipePowerIron.setCreativeTab(null);
		BuildCraftTransport.pipePowerGold.setCreativeTab(null);
		BuildCraftTransport.pipePowerDiamond.setCreativeTab(null);

		// Remove BC structure pipe
		BuildCraftTransport.pipeStructureCobblestone.setCreativeTab(null);

		// Remove BC wranch item
		BuildCraftCore.wrenchItem.setCreativeTab(null);

		// Remove BC pipe sealant item
		BuildCraftTransport.pipeWaterproof.setCreativeTab(null);

		// Remove BC water and oil spring blocks
		BuildCraftCore.springBlock.setCreativeTab(null);
	}

	@Override
	public void hideNEIItems()
	{
		if (Loader.isModLoaded("NotEnoughItems"))
		{
			// Remove BC gears
			API.hideItem(new ItemStack(BuildCraftCore.woodenGearItem));
			API.hideItem(new ItemStack(BuildCraftCore.stoneGearItem));
			API.hideItem(new ItemStack(BuildCraftCore.ironGearItem));
			API.hideItem(new ItemStack(BuildCraftCore.goldGearItem));
			API.hideItem(new ItemStack(BuildCraftCore.diamondGearItem));

			// Remove BC buckets
			API.hideItem(new ItemStack(BuildCraftEnergy.bucketFuel));
			API.hideItem(new ItemStack(BuildCraftEnergy.bucketOil));
			//API.hideItem(new ItemStack(BuildCraftEnergy.bucketRedPlasma));

			// Remove BC transport pipes
			API.hideItem(new ItemStack(BuildCraftTransport.pipeItemsWood));
			API.hideItem(new ItemStack(BuildCraftTransport.pipeItemsCobblestone));
			API.hideItem(new ItemStack(BuildCraftTransport.pipeItemsStone));
			API.hideItem(new ItemStack(BuildCraftTransport.pipeItemsIron));
			API.hideItem(new ItemStack(BuildCraftTransport.pipeItemsGold));
			API.hideItem(new ItemStack(BuildCraftTransport.pipeItemsDiamond));
			API.hideItem(new ItemStack(BuildCraftTransport.pipeItemsEmerald));
			API.hideItem(new ItemStack(BuildCraftTransport.pipeItemsVoid));
			API.hideItem(new ItemStack(BuildCraftTransport.pipeItemsSandstone));
			API.hideItem(new ItemStack(BuildCraftTransport.pipeItemsObsidian));
			API.hideItem(new ItemStack(BuildCraftTransport.pipeItemsDaizuli));
			API.hideItem(new ItemStack(BuildCraftTransport.pipeItemsLapis));
			API.hideItem(new ItemStack(BuildCraftTransport.pipeItemsQuartz));
			API.hideItem(new ItemStack(BuildCraftTransport.pipeItemsEmzuli));

			// Remove BC fluid pipes
			API.hideItem(new ItemStack(BuildCraftTransport.pipeFluidsWood));
			API.hideItem(new ItemStack(BuildCraftTransport.pipeFluidsCobblestone));
			API.hideItem(new ItemStack(BuildCraftTransport.pipeFluidsStone));
			API.hideItem(new ItemStack(BuildCraftTransport.pipeFluidsIron));
			API.hideItem(new ItemStack(BuildCraftTransport.pipeFluidsGold));
			API.hideItem(new ItemStack(BuildCraftTransport.pipeFluidsEmerald));
			API.hideItem(new ItemStack(BuildCraftTransport.pipeFluidsVoid));
			API.hideItem(new ItemStack(BuildCraftTransport.pipeFluidsSandstone));

			// Remove BC kinesis pipes
			API.hideItem(new ItemStack(BuildCraftTransport.pipePowerCobblestone));
			API.hideItem(new ItemStack(BuildCraftTransport.pipePowerStone));
			API.hideItem(new ItemStack(BuildCraftTransport.pipePowerWood));
			API.hideItem(new ItemStack(BuildCraftTransport.pipePowerQuartz));
			API.hideItem(new ItemStack(BuildCraftTransport.pipePowerIron));
			API.hideItem(new ItemStack(BuildCraftTransport.pipePowerGold));
			API.hideItem(new ItemStack(BuildCraftTransport.pipePowerDiamond));

			// Remove BC structure pipe
			API.hideItem(new ItemStack(BuildCraftTransport.pipeStructureCobblestone));

			// Remove BC wranch item
			API.hideItem(new ItemStack(BuildCraftTransport.pipeWaterproof));

			// Remove BC pipe sealant item
			API.hideItem(new ItemStack(BuildCraftCore.wrenchItem));

			// Remove BC water and oil spring blocks
			API.hideItem(new ItemStack(BuildCraftCore.springBlock));
		}
	}
}
