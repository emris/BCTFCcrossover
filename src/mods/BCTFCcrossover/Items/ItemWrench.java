package mods.BCTFCcrossover.Items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import TFC.Enums.EnumSize;
import TFC.Enums.EnumWeight;
import TFC.Items.ItemTerra;
import buildcraft.api.tools.IToolWrench;

public class ItemWrench extends ItemTerra implements IToolWrench {
	public Icon icons;
	public ItemWrench(int id) {
		super(id);

	}
	
	@Override
	public void updateIcons(IconRegister registerer) {
		icons = registerer.registerIcon("BCTFCcrossover:" + getUnlocalizedName().replace("item.", "") + "Gear");
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		// TODO Auto-generated method stub
		return super.getUnlocalizedName(itemstack);
	}

	@Override
	public boolean canStack() {
		// TODO Auto-generated method stub
		return super.canStack();
	}

	@Override
	public EnumSize getSize() {
		return EnumSize.MEDIUM;
	}

	@Override
	public EnumWeight getWeight() 
	{
		return EnumWeight.MEDIUM;
	}

	@Override
	public boolean canWrench(EntityPlayer player, int x, int y, int z) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void wrenchUsed(EntityPlayer player, int x, int y, int z) {
		// TODO Auto-generated method stub
		
	}



}
