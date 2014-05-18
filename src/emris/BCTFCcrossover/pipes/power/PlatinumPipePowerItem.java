package emris.BCTFCcrossover.pipes.power;

import net.minecraftforge.common.ForgeDirection;
import buildcraft.api.core.IIconProvider;
import buildcraft.transport.pipes.PipePowerDiamond;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import emris.BCTFCcrossover.BCTFCcrossover;
import emris.BCTFCcrossover.core.PipeIconProvider;

public class PlatinumPipePowerItem extends PipePowerDiamond
{
	public PlatinumPipePowerItem(int itemID)
	{
		super(itemID);
		transport.initFromPipe(getClass());
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIconProvider getIconProvider()
	{
		return BCTFCcrossover.instance.pipeIconProvider;
	}

	@Override
	public int getIconIndex(ForgeDirection direction)
	{
		return PipeIconProvider.TYPE.PipePowerPlatinum.ordinal();
	}
}
