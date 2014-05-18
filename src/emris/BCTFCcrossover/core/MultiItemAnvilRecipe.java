package emris.BCTFCcrossover.core;

import net.minecraft.item.ItemStack;
import TFC.API.Crafting.AnvilRecipe;
import TFC.API.Crafting.AnvilReq;

public class MultiItemAnvilRecipe extends AnvilRecipe
{
	ItemStack result;

	public MultiItemAnvilRecipe(ItemStack in, ItemStack in2, String p, AnvilReq req, ItemStack result)
	{
		super(in, in2, p, req, result);
		this.result = result;
	}

	@Override
	public ItemStack getCraftingResult()
	{
		return result.copy();
	}
}
