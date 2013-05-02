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

	public static final int PipeTin_Standard				= 0;
	public static final int PipeTin_Solid					= 1;
	public static final int PipeLiquidsTin_Standard			= 2;
	public static final int PipePowerTin_Standard			= 3;
	public static final int PipePowerZinc					= 4;
	public static final int PipePowerCopper					= 5;
	public static final int PipePowerSilver					= 6;
	
	
	public static final int MAX					= 7;
	
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
		
		_icons[PipeIconProvider.PipeTin_Standard] = iconRegister.registerIcon("BCTFCcrossover:PipeTin_Standard");
		_icons[PipeIconProvider.PipeTin_Solid] = iconRegister.registerIcon("BCTFCcrossover:PipeTin_Solid");
		_icons[PipeIconProvider.PipeLiquidsTin_Standard] = iconRegister.registerIcon("BCTFCcrossover:PipeLiquidsTin_Standard");
		_icons[PipeIconProvider.PipePowerTin_Standard] = iconRegister.registerIcon("BCTFCcrossover:PipePowerTin_Standard");
		_icons[PipeIconProvider.PipePowerZinc] = iconRegister.registerIcon("BCTFCcrossover:PipePowerZinc");
		_icons[PipeIconProvider.PipePowerCopper] = iconRegister.registerIcon("BCTFCcrossover:PipePowerCopper");
		_icons[PipeIconProvider.PipePowerSilver] = iconRegister.registerIcon("BCTFCcrossover:PipePowerSilver");
		
	}
}
