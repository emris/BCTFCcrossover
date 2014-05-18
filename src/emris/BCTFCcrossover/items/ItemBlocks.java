package emris.BCTFCcrossover.items;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import buildcraft.core.CreativeTabBuildCraft;
import buildcraft.core.utils.StringUtils;

public class ItemBlocks extends ItemBlock
{
	public ItemBlocks(int id)
	{
		super(id);
		setCreativeTab(CreativeTabBuildCraft.MACHINES.get());
	}

	@Override
	public String getItemDisplayName(ItemStack itemstack)
	{
		return StringUtils.localize(getUnlocalizedName(itemstack));
	}

}
