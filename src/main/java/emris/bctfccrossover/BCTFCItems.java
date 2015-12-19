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
import buildcraft.core.BCCreativeTab;
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
		TinPipeItem = createPipe(TinPipeItem.class, "Tin Transport Pipe", BCCreativeTab.get("pipes"));
		LeadPipeItem = createPipe(LeadPipeItem.class, "Lead Transport Pipe", BCCreativeTab.get("pipes"));
		BronzePipeItem = createPipe(BronzePipeItem.class, "Bronze Transport Pipe", BCCreativeTab.get("pipes"));
		WroughtIronPipeItem = createPipe(WroughtIronPipeItem.class, "Wrought Iron Transport Pipe", BCCreativeTab.get("pipes"));
		SteelPipeItem = createPipe(SteelPipeItem.class, "Steel Transport Pipe", BCCreativeTab.get("pipes"));
		BlueSteelPipeItem = createPipe(BlueSteelPipeItem.class, "Blue Steel Transport Pipe", BCCreativeTab.get("pipes"));
		RedSteelPipeItem = createPipe(RedSteelPipeItem.class, "Red Steel Transport Pipe", BCCreativeTab.get("pipes"));
		BlackBronzePipeItem = createPipe(BlackBronzePipeItem.class, "Black Bronze Transport Pipe", BCCreativeTab.get("pipes"));
		RoseGoldPipeItem = createPipe(RoseGoldPipeItem.class, "Rose Gold Transport Pipe", BCCreativeTab.get("pipes"));
		BlackSteelPipeItem = createPipe(BlackSteelPipeItem.class, "Black Steel Transport Pipe", BCCreativeTab.get("pipes"));
		SterlingSilverPipeItem = createPipe(SterlingSilverPipeItem.class, "Sterling Silver Transport Pipe", BCCreativeTab.get("pipes"));
		BrassPipeItem = createPipe(BrassPipeItem.class, "Brass Transport Pipe", BCCreativeTab.get("pipes"));
		//BuildCraftTransport.pipeItemsQuartz
		//TODO
		//BuildCraftTransport.pipeItemsEmzuli
		//TODO

		// ===============Fluid Pipes===============
		TinPipeFluidsItem = createPipe(TinPipeFluidsItem.class, "Tin Fluid Pipe", BCCreativeTab.get("pipes")); // Wood
		LeadPipeFluidsItem = createPipe(LeadPipeFluidsItem.class, "Lead Fluid Pipe", BCCreativeTab.get("pipes")); // Cobblestone
		BronzePipeFluidsItem = createPipe(BronzePipeFluidsItem.class, "Bronze Fluid Pipe", BCCreativeTab.get("pipes")); // Stone
		WroughtIronPipeFluidsItem = createPipe(WroughtIronPipeFluidsItem.class, "Wrought Iron Fluid Pipe", BCCreativeTab.get("pipes")); // Iron
		SteelPipeFluidsItem = createPipe(SteelPipeFluidsItem.class, "Steel Fluid Pipe", BCCreativeTab.get("pipes")); // Gold
		RedSteelPipeFluidsItem = createPipe(RedSteelPipeFluidsItem.class, "Red Steel Fluid Pipe", BCCreativeTab.get("pipes")); // Emerald
		BlackBronzePipeFluidsItem = createPipe(BlackBronzePipeFluidsItem.class, "Black Bronze Fluid Pipe", BCCreativeTab.get("pipes")); // Void
		RoseGoldPipeFluidsItem = createPipe(RoseGoldPipeFluidsItem.class, "Rose Gold Fluid Pipe", BCCreativeTab.get("pipes")); // Sandstone

		// ===============Power Pipes===============
		CopperPipePowerItem = createPipe(CopperPipePowerItem.class, "Copper Kinesis Pipe", BCCreativeTab.get("pipes")); // Cobblestone
		RoseGoldPipePowerItem = createPipe(RoseGoldPipePowerItem.class, "Rose Gold Kinesis Pipe", BCCreativeTab.get("pipes")); // Stone
		BlackBronzePipePowerItem = createPipe(BlackBronzePipePowerItem.class, "Black Bronze Kinesis Pipe", BCCreativeTab.get("pipes")); // Wood
		WroughtIronPipePowerItem = createPipe(WroughtIronPipePowerItem.class, "Wrought Iron Kinesis Pipe", BCCreativeTab.get("pipes")); // Quartz
		SteelPipePowerItem = createPipe(SteelPipePowerItem.class, "Steel Kinesis Pipe", BCCreativeTab.get("pipes")); // Iron
		PlatinumPipePowerItem = createPipe(PlatinumPipePowerItem.class, "Platinum Kinesis Pipe", BCCreativeTab.get("pipes")); // Gold
		SilverPipePowerItem = createPipe(SilverPipePowerItem.class, "Silver Kinesis Pipe", BCCreativeTab.get("pipes")); // Diamond

		// ===============Structure Pipes===============
		LeadPipeStructureItem = createPipe(LeadPipeStructureItem.class, "Structure Pipe", BCCreativeTab.get("pipes"));

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
	}

	private static Item createPipe(Class<? extends Pipe<?>> clas, String descr, BCCreativeTab creativeTab)
	{
		//String name = Character.toLowerCase(clas.getSimpleName().charAt(0)) + clas.getSimpleName().substring(1);
		ItemPipe res = BlockGenericPipe.registerPipe(clas, creativeTab);
		res.setUnlocalizedName(clas.getSimpleName());
		return res;
	}

}