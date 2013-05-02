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
package mods.BCTFCcrossover.pipes.transport;

import mods.BCTFCcrossover.BCTFCcrossover;
import mods.BCTFCcrossover.core.PipeIconProvider;
import net.minecraftforge.common.ForgeDirection;
import buildcraft.api.core.IIconProvider;
import buildcraft.api.power.IPowerProvider;
import buildcraft.api.power.PowerFramework;
import buildcraft.transport.PipeTransportItems;
import buildcraft.transport.pipes.PipeItemsWood;
import buildcraft.transport.pipes.PipeLogic;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class TinPipeItem extends PipeItemsWood {
	
	private IPowerProvider powerProvider;

	protected int standardIconIndex = PipeIconProvider.PipeTin_Standard;
	protected int solidIconIndex = PipeIconProvider.PipeTin_Solid;
	
	protected TinPipeItem(PipeTransportItems transport, PipeLogic logic, int itemID) {
		super(transport, logic, itemID);

		powerProvider = PowerFramework.currentFramework.createPowerProvider();
		powerProvider.configure(50, 1, 64, 1, 64);
		powerProvider.configurePowerPerdition(64, 1);
	}

	protected TinPipeItem(int itemID, PipeTransportItems transport) {
		super(itemID, transport);
	}

	public TinPipeItem(int itemID) {
		super(itemID);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIconProvider getIconProvider() {
		return BCTFCcrossover.instance.pipeIconProvider;
	}

	@Override
	public int getIconIndex(ForgeDirection direction) {
		if (direction == ForgeDirection.UNKNOWN)
			return standardIconIndex;
		else {
			int metadata = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);

			if (metadata == direction.ordinal())
				return solidIconIndex;
			else
				return standardIconIndex;
		}
	}
}
