package emris.BCTFCcrossover.items;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import buildcraft.core.CreativeTabBuildCraft;
import buildcraft.core.utils.StringUtils;

public class ItemBlocks extends ItemBlock {

	public ItemBlocks(int par1) {
		super(par1);
		setCreativeTab(CreativeTabBuildCraft.MACHINES.get());
	}

	@Override
	public String getItemDisplayName(ItemStack itemstack) {
		return StringUtils.localize(getUnlocalizedName(itemstack));
	}

}
