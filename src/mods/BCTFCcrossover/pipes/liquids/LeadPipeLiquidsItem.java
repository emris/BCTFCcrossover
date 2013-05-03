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
package mods.BCTFCcrossover.pipes.liquids;

import mods.BCTFCcrossover.BCTFCcrossover;
import mods.BCTFCcrossover.core.PipeIconProvider;
import net.minecraftforge.common.ForgeDirection;
import buildcraft.api.core.IIconProvider;
import buildcraft.transport.pipes.PipeLiquidsCobblestone;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class LeadPipeLiquidsItem extends PipeLiquidsCobblestone {

	public LeadPipeLiquidsItem(int itemID) {
		super(itemID);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIconProvider getIconProvider() {
		return BCTFCcrossover.instance.pipeIconProvider;
	}

	@Override
	public int getIconIndex(ForgeDirection direction) {
		return PipeIconProvider.PipeLiquidsLead;
	}
}