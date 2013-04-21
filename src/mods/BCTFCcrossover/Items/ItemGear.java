package mods.BCTFCcrossover.Items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import TFC.Enums.EnumSize;
import TFC.Enums.EnumWeight;
import TFC.Items.ItemTerra;
import buildcraft.core.CreativeTabBuildCraft;

public class ItemGear extends ItemTerra {
	public Icon icons;
	public ItemGear(int id) {
		super(id);
		setCreativeTab(CreativeTabBuildCraft.tabBuildCraft);
	}
	
	@Override
	public Icon getIconFromDamage(int i)
	{
		return icons;
	}
	
	@Override
	public void updateIcons(IconRegister registerer)
	{
		icons = registerer.registerIcon("BCTFCcrossover:" + getUnlocalizedName().replace("item.", "") + "Gear");
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
	
}
