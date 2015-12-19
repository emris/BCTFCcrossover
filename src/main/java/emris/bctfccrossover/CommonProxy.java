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

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import buildcraft.BuildCraftTransport;
import buildcraft.transport.PipeTransportFluids;
import buildcraft.transport.PipeTransportPower;
import buildcraft.transport.TransportConstants;
import cpw.mods.fml.common.registry.GameRegistry;
import emris.bctfccrossover.pipes.fluids.BlackBronzePipeFluidsItem;
import emris.bctfccrossover.pipes.fluids.BronzePipeFluidsItem;
import emris.bctfccrossover.pipes.fluids.LeadPipeFluidsItem;
import emris.bctfccrossover.pipes.fluids.RedSteelPipeFluidsItem;
import emris.bctfccrossover.pipes.fluids.RoseGoldPipeFluidsItem;
import emris.bctfccrossover.pipes.fluids.SteelPipeFluidsItem;
import emris.bctfccrossover.pipes.fluids.TinPipeFluidsItem;
import emris.bctfccrossover.pipes.fluids.WroughtIronPipeFluidsItem;
import emris.bctfccrossover.pipes.power.BlackBronzePipePowerItem;
import emris.bctfccrossover.pipes.power.CopperPipePowerItem;
import emris.bctfccrossover.pipes.power.PlatinumPipePowerItem;
import emris.bctfccrossover.pipes.power.RoseGoldPipePowerItem;
import emris.bctfccrossover.pipes.power.SilverPipePowerItem;
import emris.bctfccrossover.pipes.power.SteelPipePowerItem;
import emris.bctfccrossover.pipes.power.WroughtIronPipePowerItem;
import emris.bctfccrossover.tileEntities.TETreeLog;

public class CommonProxy
{
	public File getMinecraftDir()
	{
		return MinecraftServer.getServer().getFile("");
	}
	
	public boolean isRemote()
	{
		return false;
	}
	
	public World getCurrentWorld()
	{
		return MinecraftServer.getServer().getEntityWorld();
	}

	public void registerItem(Item item)
	{
		GameRegistry.registerItem(item, item.getUnlocalizedName().replace("item.", ""));
	}
	
	public void registerOreDict()
	{
		// Register Rubber to OreDictionery
		String[] rubberNames = new String[]{"rubberBlack", "rubberRed", "rubberGreen",
				"rubberBrown","rubberBlue", "rubberPurple", "rubberCyan", "rubberLightGray",
				"rubberGray", "rubberPink", "rubberLimeGreen", "rubberYellow", "rubberLightBlue",
				"rubberMagenta", "rubberOrange", "rubberWhite"};
		for (int i = 0; i < rubberNames.length; ++i)
			OreDictionary.registerOre(rubberNames[i], new ItemStack(BCTFCItems.Rubber, 1, i));

		String[] woodBucketNames = new String[]{"bucketLatex","bucketZinc","bucketZincWater",
				"bucketSteel", "bucketSteelOil","bucketSteelFuel"};
		for (int i = 0; i < woodBucketNames.length; ++i)
			OreDictionary.registerOre(woodBucketNames[i], new ItemStack(BCTFCItems.Buckets, 1, i));

		String[] pipeFrameNames = new String[]{"pipeFrameTin", "pipeFrameLead", "pipeFrameBronze",
				"pipeFrameWroughtIron", "pipeFrameSteel", "pipeFrameBlueSteel", "pipeFrameRedSteel",
				"pipeFrameBlackBronze", "pipeFrameRoseGold", "pipeFrameBlackSteel", "pipeFrameZinc",
				"pipeFrameCopper", "pipeFrameSilver", "pipeFramePlatinum", "pipeFrameSterlingSilver",
				"pipeFrameBrass"};
		for (int i = 0; i < pipeFrameNames.length; ++i)
			OreDictionary.registerOre(pipeFrameNames[i], new ItemStack(BCTFCItems.PipeFrames, 1, i));

		String[] gearNames= new String[]{"gearBismuthBronze", "gearBlackBronze", "gearBronze", "gearCopper",
				"gearWroughtIron", "gearSteel", "gearBlackSteel", "gearBlueSteel", "gearRedSteel"};
		for (int i = 0; i < gearNames.length; ++i)
			OreDictionary.registerOre(gearNames[i], new ItemStack(BCTFCItems.Gears, 1, i));

		OreDictionary.registerOre("bowlLatex", new ItemStack(BCTFCItems.LatexBowl, 1, 0));
	}

	public String getItemDisplayName(ItemStack stack)
	{
		return "";
	}
	
	@SuppressWarnings("unchecked")
	public void addCraftingRecipe(ItemStack result, Object... recipe)
	{
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(result, recipe));
	}

	public void addShapelessRecipe(ItemStack result, Object... recipe)
	{
		GameRegistry.addShapelessRecipe(result, recipe);
	}

	public void registerPowerPipeCapacities()
	{
		PipeTransportPower.powerCapacities.put(CopperPipePowerItem.class, TransportConstants.PIPE_POWER_BASE_CAP);
		PipeTransportPower.powerCapacities.put(RoseGoldPipePowerItem.class, 2 * TransportConstants.PIPE_POWER_BASE_CAP);
		PipeTransportPower.powerCapacities.put(BlackBronzePipePowerItem.class, 4 * TransportConstants.PIPE_POWER_BASE_CAP);
		PipeTransportPower.powerCapacities.put(WroughtIronPipePowerItem.class, 8 * TransportConstants.PIPE_POWER_BASE_CAP);
		PipeTransportPower.powerCapacities.put(SteelPipePowerItem.class, 16 * TransportConstants.PIPE_POWER_BASE_CAP);
		PipeTransportPower.powerCapacities.put(PlatinumPipePowerItem.class, 32 * TransportConstants.PIPE_POWER_BASE_CAP);
		PipeTransportPower.powerCapacities.put(SilverPipePowerItem.class, 128 * TransportConstants.PIPE_POWER_BASE_CAP);

		PipeTransportPower.powerResistances.put(CopperPipePowerItem.class, 0.05F);
		PipeTransportPower.powerResistances.put(RoseGoldPipePowerItem.class, 0.025F);
		PipeTransportPower.powerResistances.put(BlackBronzePipePowerItem.class, 0.0F);
		PipeTransportPower.powerResistances.put(WroughtIronPipePowerItem.class, 0.0125F);
		PipeTransportPower.powerResistances.put(SteelPipePowerItem.class, 0.0125F);
		PipeTransportPower.powerResistances.put(PlatinumPipePowerItem.class, 0.003125F);
		PipeTransportPower.powerResistances.put(SilverPipePowerItem.class, 0.0F);
	}

	public void registerFluidPipeCapacities()
	{
		PipeTransportFluids.fluidCapacities.put(TinPipeFluidsItem.class, 1 * BuildCraftTransport.pipeFluidsBaseFlowRate);
		PipeTransportFluids.fluidCapacities.put(LeadPipeFluidsItem.class, 1 * BuildCraftTransport.pipeFluidsBaseFlowRate);
		PipeTransportFluids.fluidCapacities.put(BronzePipeFluidsItem.class, 2 * BuildCraftTransport.pipeFluidsBaseFlowRate);
		PipeTransportFluids.fluidCapacities.put(WroughtIronPipeFluidsItem.class, 4 * BuildCraftTransport.pipeFluidsBaseFlowRate);
		PipeTransportFluids.fluidCapacities.put(SteelPipeFluidsItem.class, 8 * BuildCraftTransport.pipeFluidsBaseFlowRate);
		PipeTransportFluids.fluidCapacities.put(RedSteelPipeFluidsItem.class, 4 * BuildCraftTransport.pipeFluidsBaseFlowRate);
		PipeTransportFluids.fluidCapacities.put(BlackBronzePipeFluidsItem.class, 1 * BuildCraftTransport.pipeFluidsBaseFlowRate);
		PipeTransportFluids.fluidCapacities.put(RoseGoldPipeFluidsItem.class, 2 * BuildCraftTransport.pipeFluidsBaseFlowRate);
	}

	public void registerTileEntities(boolean b)
	{
		GameRegistry.registerTileEntity(TETreeLog.class, "TETreeLog");
	}

	//NOOP at Server
	public void registerPipeRenderer() {}
	public void registerFluidIcons(Fluid f) {}
	public void hideCreativeTabItems() {}
	public void hideNEIItems() {}
}
