package emris.bctfccrossover.pipes.transport;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.ForgeDirection;
import buildcraft.api.core.IIconProvider;
import buildcraft.transport.pipes.PipeItemsQuartz;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import emris.bctfccrossover.BCTFCcrossover;
import emris.bctfccrossover.core.PipeIconProvider;

public class SterlingSilverPipeItem extends PipeItemsQuartz
{
	public SterlingSilverPipeItem(Item item)
	{
		super(item);
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
		return PipeIconProvider.TYPE.PipeSterlingSilver.ordinal();
	}
}
