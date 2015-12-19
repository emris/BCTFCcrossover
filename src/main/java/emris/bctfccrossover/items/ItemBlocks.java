package emris.bctfccrossover.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import buildcraft.core.BCCreativeTab;

public class ItemBlocks extends ItemBlock
{
	public ItemBlocks(Block b)
	{
		this(b, "blocks");
	}

	public ItemBlocks(Block b, String tabName)
	{
		super(b);
		setCreativeTab(BCCreativeTab.get(tabName));
	}

}
