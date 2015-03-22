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

import net.minecraft.item.Item;
import buildcraft.BuildCraftCore;
import buildcraft.BuildCraftEnergy;
import buildcraft.BuildCraftTransport;
import buildcraft.core.CreativeTabBuildCraft;
import buildcraft.transport.BlockGenericPipe;
import buildcraft.transport.ItemPipe;
import buildcraft.transport.Pipe;

import com.bioxx.tfc.Handlers.TFCFuelHandler;

import emris.bctfccrossover.items.ItemBuckets;
import emris.bctfccrossover.items.ItemGears;
import emris.bctfccrossover.items.ItemHeveaLog;
import emris.bctfccrossover.items.ItemLatexBowl;
import emris.bctfccrossover.items.ItemPipeFrames;
import emris.bctfccrossover.items.ItemRubber;
import emris.bctfccrossover.items.ItemWrenchGeneral;
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
import emris.bctfccrossover.pipes.structure.LeadPipeStructureItem;
import emris.bctfccrossover.pipes.transport.BlackBronzePipeItem;
import emris.bctfccrossover.pipes.transport.BlackSteelPipeItem;
import emris.bctfccrossover.pipes.transport.BlueSteelPipeItem;
import emris.bctfccrossover.pipes.transport.BrassPipeItem;
import emris.bctfccrossover.pipes.transport.BronzePipeItem;
import emris.bctfccrossover.pipes.transport.LeadPipeItem;
import emris.bctfccrossover.pipes.transport.RedSteelPipeItem;
import emris.bctfccrossover.pipes.transport.RoseGoldPipeItem;
import emris.bctfccrossover.pipes.transport.SteelPipeItem;
import emris.bctfccrossover.pipes.transport.SterlingSilverPipeItem;
import emris.bctfccrossover.pipes.transport.TinPipeItem;
import emris.bctfccrossover.pipes.transport.WroughtIronPipeItem;

public class BCTFCItems
{
	public static Item LatexBowl;
	public static Item Buckets;
	public static Item Rubber;
	public static Item Gears;
	public static Item Plans;
	public static Item PipeFrames;
	public static Item Hevea;

	public static Item TinPipeItem;
	public static Item LeadPipeItem;
	public static Item BronzePipeItem;
	public static Item WroughtIronPipeItem;
	public static Item SteelPipeItem;
	public static Item BlueSteelPipeItem;
	public static Item RedSteelPipeItem;
	public static Item BlackBronzePipeItem;
	public static Item RoseGoldPipeItem;
	public static Item BlackSteelPipeItem;
	public static Item SterlingSilverPipeItem;
	public static Item BrassPipeItem;

	public static Item TinPipeFluidsItem;
	public static Item LeadPipeFluidsItem;
	public static Item BronzePipeFluidsItem;
	public static Item WroughtIronPipeFluidsItem;
	public static Item SteelPipeFluidsItem;
	public static Item RedSteelPipeFluidsItem;
	public static Item BlackBronzePipeFluidsItem;
	public static Item RoseGoldPipeFluidsItem;

	public static Item CopperPipePowerItem;
	public static Item RoseGoldPipePowerItem;
	public static Item BlackBronzePipePowerItem;
	public static Item WroughtIronPipePowerItem;
	public static Item SteelPipePowerItem;
	public static Item PlatinumPipePowerItem;
	public static Item SilverPipePowerItem;

	public static Item LeadPipeStructureItem;

	public static Item CopperWrenchItem;
	public static Item BronzeWrenchItem;
	public static Item BismuthBronzeWrenchItem;
	public static Item BlackBronzeWrenchItem;
	public static Item WroughtIronWrenchItem;
	public static Item SteelWrenchItem;
	public static Item BlackSteelWrenchItem;
	public static Item BlueSteelWrenchItem;
	public static Item RedSteelWrenchItem;

	public static void setup()
	{
		System.out.println(new StringBuilder().append("[BCTFCcrossover] Setup Items").toString());

		// ===============Gears===============
		Gears = new ItemGears();
		BCTFCcrossover.proxy.registerItem(Gears);

		// ===============Buckets=============
		Buckets = new ItemBuckets();
		BCTFCcrossover.proxy.registerItem(Buckets);

		// ===============Latex=============
		LatexBowl = new ItemLatexBowl();
		BCTFCcrossover.proxy.registerItem(LatexBowl);

		// ===============Rubber==============
		Rubber = new ItemRubber();
		BCTFCcrossover.proxy.registerItem(Rubber);

		// ===============Pipe Frames=========
		PipeFrames = new ItemPipeFrames();
		BCTFCcrossover.proxy.registerItem(PipeFrames);

		// ===============Hevea Log=========
		Hevea = new ItemHeveaLog();
		BCTFCcrossover.proxy.registerItem(Hevea);
		TFCFuelHandler.registerFuel(Hevea, 800);

		// ===============Transport Pipes===============
		TinPipeItem = createPipe(TinPipeItem.class, "Tin Transport Pipe", CreativeTabBuildCraft.PIPES);
		LeadPipeItem = createPipe(LeadPipeItem.class, "Lead Transport Pipe", CreativeTabBuildCraft.PIPES);
		BronzePipeItem = createPipe(BronzePipeItem.class, "Bronze Transport Pipe", CreativeTabBuildCraft.PIPES);
		WroughtIronPipeItem = createPipe(WroughtIronPipeItem.class, "Wrought Iron Transport Pipe", CreativeTabBuildCraft.PIPES);
		SteelPipeItem = createPipe(SteelPipeItem.class, "Steel Transport Pipe", CreativeTabBuildCraft.PIPES);
		BlueSteelPipeItem = createPipe(BlueSteelPipeItem.class, "Blue Steel Transport Pipe", CreativeTabBuildCraft.PIPES);
		RedSteelPipeItem = createPipe(RedSteelPipeItem.class, "Red Steel Transport Pipe", CreativeTabBuildCraft.PIPES);
		BlackBronzePipeItem = createPipe(BlackBronzePipeItem.class, "Black Bronze Transport Pipe", CreativeTabBuildCraft.PIPES);
		RoseGoldPipeItem = createPipe(RoseGoldPipeItem.class, "Rose Gold Transport Pipe", CreativeTabBuildCraft.PIPES);
		BlackSteelPipeItem = createPipe(BlackSteelPipeItem.class, "Black Steel Transport Pipe", CreativeTabBuildCraft.PIPES);
		SterlingSilverPipeItem = createPipe(SterlingSilverPipeItem.class, "Sterling Silver Transport Pipe", CreativeTabBuildCraft.PIPES);
		BrassPipeItem = createPipe(BrassPipeItem.class, "Brass Transport Pipe", CreativeTabBuildCraft.PIPES);
		//BuildCraftTransport.pipeItemsQuartz
		//TODO
		//BuildCraftTransport.pipeItemsEmzuli
		//TODO

		// ===============Fluid Pipes===============
		TinPipeFluidsItem = createPipe(TinPipeFluidsItem.class, "Tin Fluid Pipe", CreativeTabBuildCraft.PIPES); // Wood
		LeadPipeFluidsItem = createPipe(LeadPipeFluidsItem.class, "Lead Fluid Pipe", CreativeTabBuildCraft.PIPES); // Cobblestone
		BronzePipeFluidsItem = createPipe(BronzePipeFluidsItem.class, "Bronze Fluid Pipe", CreativeTabBuildCraft.PIPES); // Stone
		WroughtIronPipeFluidsItem = createPipe(WroughtIronPipeFluidsItem.class, "Wrought Iron Fluid Pipe", CreativeTabBuildCraft.PIPES); // Iron
		SteelPipeFluidsItem = createPipe(SteelPipeFluidsItem.class, "Steel Fluid Pipe", CreativeTabBuildCraft.PIPES); // Gold
		RedSteelPipeFluidsItem = createPipe(RedSteelPipeFluidsItem.class, "Red Steel Fluid Pipe", CreativeTabBuildCraft.PIPES); // Emerald
		BlackBronzePipeFluidsItem = createPipe(BlackBronzePipeFluidsItem.class, "Black Bronze Fluid Pipe", CreativeTabBuildCraft.PIPES); // Void
		RoseGoldPipeFluidsItem = createPipe(RoseGoldPipeFluidsItem.class, "Rose Gold Fluid Pipe", CreativeTabBuildCraft.PIPES); // Sandstone

		// ===============Power Pipes===============
		CopperPipePowerItem = createPipe(CopperPipePowerItem.class, "Copper Kinesis Pipe", CreativeTabBuildCraft.PIPES); // Cobblestone
		RoseGoldPipePowerItem = createPipe(RoseGoldPipePowerItem.class, "Rose Gold Kinesis Pipe", CreativeTabBuildCraft.PIPES); // Stone
		BlackBronzePipePowerItem = createPipe(BlackBronzePipePowerItem.class, "Black Bronze Kinesis Pipe", CreativeTabBuildCraft.PIPES); // Wood
		WroughtIronPipePowerItem = createPipe(WroughtIronPipePowerItem.class, "Wrought Iron Kinesis Pipe", CreativeTabBuildCraft.PIPES); // Quartz
		SteelPipePowerItem = createPipe(SteelPipePowerItem.class, "Steel Kinesis Pipe", CreativeTabBuildCraft.PIPES); // Iron
		PlatinumPipePowerItem = createPipe(PlatinumPipePowerItem.class, "Platinum Kinesis Pipe", CreativeTabBuildCraft.PIPES); // Gold
		SilverPipePowerItem = createPipe(SilverPipePowerItem.class, "Silver Kinesis Pipe", CreativeTabBuildCraft.PIPES); // Diamond

		// ===============Structure Pipes===============
		LeadPipeStructureItem = createPipe(LeadPipeStructureItem.class, "Structure Pipe", CreativeTabBuildCraft.PIPES);

		// ===============Wrenches===============
		CopperWrenchItem = new ItemWrenchGeneral().setUnlocalizedName("CopperWrenchItem");
		BCTFCcrossover.proxy.registerItem(CopperWrenchItem);

		BismuthBronzeWrenchItem = new ItemWrenchGeneral().setUnlocalizedName("BismuthBronzeWrenchItem");
		BCTFCcrossover.proxy.registerItem(BismuthBronzeWrenchItem);

		BlackBronzeWrenchItem = new ItemWrenchGeneral().setUnlocalizedName("BlackBronzeWrenchItem");
		BCTFCcrossover.proxy.registerItem(BlackBronzeWrenchItem);

		BronzeWrenchItem = new ItemWrenchGeneral().setUnlocalizedName("BronzeWrenchItem");
		BCTFCcrossover.proxy.registerItem(BronzeWrenchItem);

		WroughtIronWrenchItem = new ItemWrenchGeneral().setUnlocalizedName("WroughtIronWrenchItem");
		BCTFCcrossover.proxy.registerItem(WroughtIronWrenchItem);

		SteelWrenchItem = new ItemWrenchGeneral().setUnlocalizedName("SteelWrenchItem");
		BCTFCcrossover.proxy.registerItem(SteelWrenchItem);

		BlackSteelWrenchItem = new ItemWrenchGeneral().setUnlocalizedName("BlackSteelWrenchItem");
		BCTFCcrossover.proxy.registerItem(BlackSteelWrenchItem);

		BlueSteelWrenchItem = new ItemWrenchGeneral().setUnlocalizedName("BlueSteelWrenchItem");
		BCTFCcrossover.proxy.registerItem(BlueSteelWrenchItem);

		RedSteelWrenchItem = new ItemWrenchGeneral().setUnlocalizedName("RedSteelWrenchItem");
		BCTFCcrossover.proxy.registerItem(RedSteelWrenchItem);

		removeFromCreativeTab();
	}

	@SuppressWarnings("rawtypes")
	private static Item createPipe(Class<? extends Pipe> clas, String descr, CreativeTabBuildCraft creativeTab)
	{
		//String name = Character.toLowerCase(clas.getSimpleName().charAt(0)) + clas.getSimpleName().substring(1);
		ItemPipe res = BlockGenericPipe.registerPipe(clas, creativeTab);
		res.setUnlocalizedName(clas.getSimpleName());
		return res;
	}

	private static void removeFromCreativeTab()
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
}