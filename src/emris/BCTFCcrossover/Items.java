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

import net.minecraft.item.Item;
import buildcraft.BuildCraftCore;
import buildcraft.BuildCraftEnergy;
import buildcraft.BuildCraftTransport;
import buildcraft.transport.BlockGenericPipe;
import buildcraft.transport.ItemPipe;
import buildcraft.transport.Pipe;
import emris.BCTFCcrossover.core.IDProvider;
import emris.BCTFCcrossover.items.ItemBuckets;
import emris.BCTFCcrossover.items.ItemGears;
import emris.BCTFCcrossover.items.ItemLatexBowl;
import emris.BCTFCcrossover.items.ItemPipeFrames;
import emris.BCTFCcrossover.items.ItemRubber;
import emris.BCTFCcrossover.items.ItemWrenchGeneral;
import emris.BCTFCcrossover.pipes.fluids.BlackBronzePipeFluidsItem;
import emris.BCTFCcrossover.pipes.fluids.BronzePipeFluidsItem;
import emris.BCTFCcrossover.pipes.fluids.LeadPipeFluidsItem;
import emris.BCTFCcrossover.pipes.fluids.RedSteelPipeFluidsItem;
import emris.BCTFCcrossover.pipes.fluids.RoseGoldPipeFluidsItem;
import emris.BCTFCcrossover.pipes.fluids.SteelPipeFluidsItem;
import emris.BCTFCcrossover.pipes.fluids.TinPipeFluidsItem;
import emris.BCTFCcrossover.pipes.fluids.WroughtIronPipeFluidsItem;
import emris.BCTFCcrossover.pipes.power.BlackBronzePipePowerItem;
import emris.BCTFCcrossover.pipes.power.CopperPipePowerItem;
import emris.BCTFCcrossover.pipes.power.PlatinumPipePowerItem;
import emris.BCTFCcrossover.pipes.power.RoseGoldPipePowerItem;
import emris.BCTFCcrossover.pipes.power.SilverPipePowerItem;
import emris.BCTFCcrossover.pipes.power.SteelPipePowerItem;
import emris.BCTFCcrossover.pipes.power.WroughtIronPipePowerItem;
import emris.BCTFCcrossover.pipes.structure.LeadPipeStructureItem;
import emris.BCTFCcrossover.pipes.transport.BlackBronzePipeItem;
import emris.BCTFCcrossover.pipes.transport.BlackSteelPipeItem;
import emris.BCTFCcrossover.pipes.transport.BlueSteelPipeItem;
import emris.BCTFCcrossover.pipes.transport.BrassPipeItem;
import emris.BCTFCcrossover.pipes.transport.BronzePipeItem;
import emris.BCTFCcrossover.pipes.transport.LeadPipeItem;
import emris.BCTFCcrossover.pipes.transport.RedSteelPipeItem;
import emris.BCTFCcrossover.pipes.transport.RoseGoldPipeItem;
import emris.BCTFCcrossover.pipes.transport.SteelPipeItem;
import emris.BCTFCcrossover.pipes.transport.SterlingSilverPipeItem;
import emris.BCTFCcrossover.pipes.transport.TinPipeItem;
import emris.BCTFCcrossover.pipes.transport.WroughtIronPipeItem;

public class Items
{
	public static Item LatexBowl;

	public static Item Buckets;
	public static Item Rubber;
	public static Item Gears;
	public static Item Plans;
	public static Item PipeFrames;

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
		Gears = new ItemGears(IDProvider.Gears);
		BCTFCcrossover.proxy.addName(Gears, "Gear");
		BCTFCcrossover.proxy.registerItem(Gears);

		// ===============Buckets=============
		Buckets = new ItemBuckets(IDProvider.Buckets);
		BCTFCcrossover.proxy.addName(Buckets, "Bucket");
		BCTFCcrossover.proxy.registerItem(Buckets);

		// ===============Latex=============
		LatexBowl = new ItemLatexBowl(IDProvider.LatexBowl);
		BCTFCcrossover.proxy.addName(LatexBowl, "LatexBowl");
		BCTFCcrossover.proxy.registerItem(LatexBowl);

		// ===============Rubber==============
		Rubber = new ItemRubber(IDProvider.Rubber);
		BCTFCcrossover.proxy.addName(Rubber, "Rubber");
		BCTFCcrossover.proxy.registerItem(Rubber);

		// ===============Pipe Frames=========
		PipeFrames = new ItemPipeFrames(IDProvider.PipeFrames);
		BCTFCcrossover.proxy.addName(PipeFrames, "PipeFrame");
		BCTFCcrossover.proxy.registerItem(PipeFrames);

		// ===============Transport Pipes===============
		TinPipeItem = createPipe(IDProvider.TinPipeItem, TinPipeItem.class, "Tin Transport Pipe");
		LeadPipeItem = createPipe(IDProvider.LeadPipeItem, LeadPipeItem.class, "Lead Transport Pipe");
		BronzePipeItem = createPipe(IDProvider.BronzePipeItem, BronzePipeItem.class, "Bronze Transport Pipe");
		WroughtIronPipeItem = createPipe(IDProvider.WroughtIronPipeItem, WroughtIronPipeItem.class, "Wrought Iron Transport Pipe");
		SteelPipeItem = createPipe(IDProvider.SteelPipeItem, SteelPipeItem.class, "Steel Transport Pipe");
		BlueSteelPipeItem = createPipe(IDProvider.BlueSteelPipeItem, BlueSteelPipeItem.class, "Blue Steel Transport Pipe");
		RedSteelPipeItem = createPipe(IDProvider.RedSteelPipeItem, RedSteelPipeItem.class, "Red Steel Transport Pipe");
		BlackBronzePipeItem = createPipe(IDProvider.BlackBronzePipeItem, BlackBronzePipeItem.class, "Black Bronze Transport Pipe");
		RoseGoldPipeItem = createPipe(IDProvider.RoseGoldPipeItem, RoseGoldPipeItem.class, "Rose Gold Transport Pipe");
		BlackSteelPipeItem = createPipe(IDProvider.BlackSteelPipeItem, BlackSteelPipeItem.class, "Black Steel Transport Pipe");
		SterlingSilverPipeItem = createPipe(IDProvider.SterlingSilverPipeItem, SterlingSilverPipeItem.class, "Sterling Silver Transport Pipe");
		BrassPipeItem = createPipe(IDProvider.BrassPipeItem, BrassPipeItem.class, "Brass Transport Pipe");
		//BuildCraftTransport.pipeItemsQuartz
		//TODO
		//BuildCraftTransport.pipeItemsEmzuli
		//TODO

		// ===============Fluid Pipes===============
		TinPipeFluidsItem = createPipe(IDProvider.TinPipeFluidsItem, TinPipeFluidsItem.class, "Tin Fluid Pipe"); // Wood
		LeadPipeFluidsItem = createPipe(IDProvider.LeadPipeFluidsItem, LeadPipeFluidsItem.class, "Lead Fluid Pipe"); // Cobblestone
		BronzePipeFluidsItem = createPipe(IDProvider.BronzePipeFluidsItem, BronzePipeFluidsItem.class, "Bronze Fluid Pipe"); // Stone
		WroughtIronPipeFluidsItem = createPipe(IDProvider.WroughtIronPipeFluidsItem, WroughtIronPipeFluidsItem.class, "Wrought Iron Fluid Pipe"); // Iron
		SteelPipeFluidsItem = createPipe(IDProvider.SteelPipeFluidsItem, SteelPipeFluidsItem.class, "Steel Fluid Pipe"); // Gold
		RedSteelPipeFluidsItem = createPipe(IDProvider.RedSteelPipeFluidsItem, RedSteelPipeFluidsItem.class, "Red Steel Fluid Pipe"); // Emerald
		BlackBronzePipeFluidsItem = createPipe(IDProvider.BlackBronzePipeFluidsItem, BlackBronzePipeFluidsItem.class, "Black Bronze Fluid Pipe"); // Void
		RoseGoldPipeFluidsItem = createPipe(IDProvider.RoseGoldPipeFluidsItem, RoseGoldPipeFluidsItem.class, "Rose Gold Fluid Pipe"); // Sandstone

		// ===============Power Pipes===============
		CopperPipePowerItem = createPipe(IDProvider.CopperPipePowerItem, CopperPipePowerItem.class, "Copper Kinesis Pipe"); // Cobblestone
		RoseGoldPipePowerItem = createPipe(IDProvider.RoseGoldPipePowerItem, RoseGoldPipePowerItem.class, "Rose Gold Kinesis Pipe"); // Stone
		BlackBronzePipePowerItem = createPipe(IDProvider.BlackBronzePipePowerItem, BlackBronzePipePowerItem.class, "Black Bronze Kinesis Pipe"); // Wood
		WroughtIronPipePowerItem = createPipe(IDProvider.WroughtIronPipePowerItem, WroughtIronPipePowerItem.class, "Wrought Iron Kinesis Pipe"); // Quartz
		SteelPipePowerItem = createPipe(IDProvider.SteelPipePowerItem, SteelPipePowerItem.class, "Steel Kinesis Pipe"); // Iron
		PlatinumPipePowerItem = createPipe(IDProvider.PlatinumPipePowerItem, PlatinumPipePowerItem.class, "Platinum Kinesis Pipe"); // Gold
		SilverPipePowerItem = createPipe(IDProvider.SilverPipePowerItem, SilverPipePowerItem.class, "Silver Kinesis Pipe"); // Diamond

		// ===============Structure Pipes===============
		LeadPipeStructureItem = createPipe(IDProvider.LeadPipeStructureItem, LeadPipeStructureItem.class, "Structure Pipe");

		// ===============Wrenches===============
		CopperWrenchItem = new ItemWrenchGeneral(IDProvider.CopperWrenchItem).setUnlocalizedName("CopperWrenchItem");
		BCTFCcrossover.proxy.addName(CopperWrenchItem, "Wrench: Copper");
		BCTFCcrossover.proxy.registerItem(CopperWrenchItem);

		BismuthBronzeWrenchItem = new ItemWrenchGeneral(IDProvider.BismuthBronzeWrenchItem).setUnlocalizedName("BismuthBronzeWrenchItem");
		BCTFCcrossover.proxy.addName(BismuthBronzeWrenchItem, "Wrench: Bismuth Bronze");
		BCTFCcrossover.proxy.registerItem(BismuthBronzeWrenchItem);

		BlackBronzeWrenchItem = new ItemWrenchGeneral(IDProvider.BlackBronzeWrenchItem).setUnlocalizedName("BlackBronzeWrenchItem");
		BCTFCcrossover.proxy.addName(BlackBronzeWrenchItem, "Wrench: Black Bronze");
		BCTFCcrossover.proxy.registerItem(BlackBronzeWrenchItem);

		BronzeWrenchItem = new ItemWrenchGeneral(IDProvider.BronzeWrenchItem).setUnlocalizedName("BronzeWrenchItem");
		BCTFCcrossover.proxy.addName(BronzeWrenchItem, "Wrench: Bronze");
		BCTFCcrossover.proxy.registerItem(BronzeWrenchItem);

		WroughtIronWrenchItem = new ItemWrenchGeneral(IDProvider.WroughtIronWrenchItem).setUnlocalizedName("WroughtIronWrenchItem");
		BCTFCcrossover.proxy.addName(WroughtIronWrenchItem, "Wrench: Wrought Iron");
		BCTFCcrossover.proxy.registerItem(WroughtIronWrenchItem);

		SteelWrenchItem = new ItemWrenchGeneral(IDProvider.SteelWrenchItem).setUnlocalizedName("SteelWrenchItem");
		BCTFCcrossover.proxy.addName(SteelWrenchItem, "Wrench: Steel");
		BCTFCcrossover.proxy.registerItem(SteelWrenchItem);

		BlackSteelWrenchItem = new ItemWrenchGeneral(IDProvider.BlackSteelWrenchItem).setUnlocalizedName("BlackSteelWrenchItem");
		BCTFCcrossover.proxy.addName(BlackSteelWrenchItem, "Wrench: Black Steel");
		BCTFCcrossover.proxy.registerItem(BlackSteelWrenchItem);

		BlueSteelWrenchItem = new ItemWrenchGeneral(IDProvider.BlueSteelWrenchItem).setUnlocalizedName("BlueSteelWrenchItem");
		BCTFCcrossover.proxy.addName(BlueSteelWrenchItem, "Wrench: Blue Steel");
		BCTFCcrossover.proxy.registerItem(BlueSteelWrenchItem);

		RedSteelWrenchItem = new ItemWrenchGeneral(IDProvider.RedSteelWrenchItem).setUnlocalizedName("RedSteelWrenchItem");
		BCTFCcrossover.proxy.addName(RedSteelWrenchItem, "Wrench: Red Steel");
		BCTFCcrossover.proxy.registerItem(RedSteelWrenchItem);

		removeFromCreativeTab();
	}

	private static Item createPipe(int defaultID, Class<? extends Pipe> clas, String descr)
	{
		String name = Character.toLowerCase(clas.getSimpleName().charAt(0)) + clas.getSimpleName().substring(1);
		ItemPipe res = BlockGenericPipe.registerPipe(defaultID, clas);
		res.setUnlocalizedName(clas.getSimpleName());
		BCTFCcrossover.proxy.addName(res, descr);
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