package emris.bctfccrossover.blocks;

import net.minecraft.util.IIcon;
import emris.bctfccrossover.BCTFCBlocks;

public class BlockLogHeveaH extends BlockLogHeveaV
{
	public BlockLogHeveaH()
	{
		super();
	}

	@Override
	public IIcon getIcon(int side, int meta)
	{
		int dir = meta >> 3;
		if(dir == 0)
		{
			if(side == 0 || side == 1)
				return ((BlockLogHevea)BCTFCBlocks.blockHevea).getIcon(0);
			else if(side == 2 || side == 3)
				return ((BlockLogHevea)BCTFCBlocks.blockHevea).getIcon(1);
			else
				return ((BlockLogHevea)BCTFCBlocks.blockHevea).getIcon(2);
		}
		else
		{
			if(side == 0 || side == 1 || side == 2 || side == 3)
				return ((BlockLogHevea)BCTFCBlocks.blockHevea).getIcon(2);
			else
				return ((BlockLogHevea)BCTFCBlocks.blockHevea).getIcon(1);
		}
	}

	@Override
	public int damageDropped(int dmg)
	{
		return (dmg & 7);
	}
}
