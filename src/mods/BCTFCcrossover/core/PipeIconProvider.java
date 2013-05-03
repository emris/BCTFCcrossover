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
package mods.BCTFCcrossover.core;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import buildcraft.api.core.IIconProvider;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PipeIconProvider implements IIconProvider {

	public static final int PipeTin							= 0;
	public static final int PipeTin_Solid					= 1;
	public static final int PipeLiquidsTin					= 2;
	public static final int PipePowerTin					= 3;
	public static final int PipePowerZinc					= 4;
	public static final int PipePowerCopper					= 5;
	public static final int PipePowerSilver					= 6;
	public static final int PipeLead						= 7;
	public static final int PipeLiquidsLead					= 8;
	public static final int PipeStructureLead				= 9;
	public static final int PipeBronze						= 10;
	public static final int PipeLiquidsBronze				= 11;
	public static final int PipeWroughtIron					= 12;
	public static final int PipeWroughtIron_Solid			= 13;
	public static final int PipeLiquidsWroughtIron			= 14;
	public static final int PipeSteel						= 15;
	public static final int PipeLiquidsSteel				= 16;
	public static final int PipeBlueSteel					= 17;
	public static final int PipeBlueSteel_down				= 18;
	public static final int PipeBlueSteel_east				= 19;
	public static final int PipeBlueSteel_north				= 20;
	public static final int PipeBlueSteel_south				= 21;
	public static final int PipeBlueSteel_up				= 22;
	public static final int PipeBlueSteel_west				= 23;
	public static final int PipeRedSteel					= 24;
	public static final int PipeRedSteel_Solid				= 25;
	public static final int PipeLiquidsRedSteel				= 26;
	public static final int PipeBlackBronze					= 27;
	public static final int PipeLiquidsBlackBronze			= 28;
	public static final int PipeRoseGold					= 29;
	public static final int PipeLiquidsRoseGold				= 30;
	public static final int PipeBlackSteel					= 31;
	
	public static final int MAX					= 32;
	
	@SideOnly(Side.CLIENT)
	private Icon[] _icons;
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int iconIndex) {
		return _icons[iconIndex];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		_icons = new Icon[PipeIconProvider.MAX];
		
		_icons[PipeIconProvider.PipeTin] = iconRegister.registerIcon("BCTFCcrossover:PipeTin");
		_icons[PipeIconProvider.PipeTin_Solid] = iconRegister.registerIcon("BCTFCcrossover:PipeTin_Solid");
		_icons[PipeIconProvider.PipeLiquidsTin] = iconRegister.registerIcon("BCTFCcrossover:PipeLiquidsTin");
		_icons[PipeIconProvider.PipePowerTin] = iconRegister.registerIcon("BCTFCcrossover:PipePowerTin");
		_icons[PipeIconProvider.PipePowerZinc] = iconRegister.registerIcon("BCTFCcrossover:PipePowerZinc");
		_icons[PipeIconProvider.PipePowerCopper] = iconRegister.registerIcon("BCTFCcrossover:PipePowerCopper");
		_icons[PipeIconProvider.PipePowerSilver] = iconRegister.registerIcon("BCTFCcrossover:PipePowerSilver");
		_icons[PipeIconProvider.PipeLead] = iconRegister.registerIcon("BCTFCcrossover:PipeLead");
		_icons[PipeIconProvider.PipeLiquidsLead] = iconRegister.registerIcon("BCTFCcrossover:PipeLiquidsLead");
		_icons[PipeIconProvider.PipeStructureLead] = iconRegister.registerIcon("BCTFCcrossover:PipeStructureLead");
		_icons[PipeIconProvider.PipeBronze] = iconRegister.registerIcon("BCTFCcrossover:PipeBronze");
		_icons[PipeIconProvider.PipeLiquidsBronze] = iconRegister.registerIcon("BCTFCcrossover:PipeLiquidsBronze");
		_icons[PipeIconProvider.PipeWroughtIron] = iconRegister.registerIcon("BCTFCcrossover:PipeWroughtIron");
		_icons[PipeIconProvider.PipeWroughtIron_Solid] = iconRegister.registerIcon("BCTFCcrossover:PipeWroughtIron_Solid");
		_icons[PipeIconProvider.PipeLiquidsWroughtIron] = iconRegister.registerIcon("BCTFCcrossover:PipeLiquidsWroughtIron");
		_icons[PipeIconProvider.PipeSteel] = iconRegister.registerIcon("BCTFCcrossover:PipeSteel");
		_icons[PipeIconProvider.PipeLiquidsSteel] = iconRegister.registerIcon("BCTFCcrossover:PipeLiquidsSteel");
		_icons[PipeIconProvider.PipeBlueSteel] = iconRegister.registerIcon("BCTFCcrossover:PipeBlueSteel");
		_icons[PipeIconProvider.PipeBlueSteel_down] = iconRegister.registerIcon("BCTFCcrossover:PipeBlueSteel_down");
		_icons[PipeIconProvider.PipeBlueSteel_east] = iconRegister.registerIcon("BCTFCcrossover:PipeBlueSteel_east");
		_icons[PipeIconProvider.PipeBlueSteel_north] = iconRegister.registerIcon("BCTFCcrossover:PipeBlueSteel_north");
		_icons[PipeIconProvider.PipeBlueSteel_south] = iconRegister.registerIcon("BCTFCcrossover:PipeBlueSteel_south");
		_icons[PipeIconProvider.PipeBlueSteel_up] = iconRegister.registerIcon("BCTFCcrossover:PipeBlueSteel_up");
		_icons[PipeIconProvider.PipeBlueSteel_west] = iconRegister.registerIcon("BCTFCcrossover:PipeBlueSteel_west");
		_icons[PipeIconProvider.PipeRedSteel] = iconRegister.registerIcon("BCTFCcrossover:PipeRedSteel");
		_icons[PipeIconProvider.PipeRedSteel_Solid] = iconRegister.registerIcon("BCTFCcrossover:PipeRedSteel_Solid");
		_icons[PipeIconProvider.PipeLiquidsRedSteel] = iconRegister.registerIcon("BCTFCcrossover:PipeLiquidsRedSteel");
		_icons[PipeIconProvider.PipeBlackBronze] = iconRegister.registerIcon("BCTFCcrossover:PipeBlackBronze");
		_icons[PipeIconProvider.PipeLiquidsBlackBronze] = iconRegister.registerIcon("BCTFCcrossover:PipeLiquidsBlackBronze");
		_icons[PipeIconProvider.PipeRoseGold] = iconRegister.registerIcon("BCTFCcrossover:PipeRoseGold");
		_icons[PipeIconProvider.PipeLiquidsRoseGold] = iconRegister.registerIcon("BCTFCcrossover:PipeLiquidsRoseGold");
		_icons[PipeIconProvider.PipeBlackSteel] = iconRegister.registerIcon("BCTFCcrossover:PipeBlackSteel");

		
	}
}
