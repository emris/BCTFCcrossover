package mods.BCTFCcrossover.Items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import TFC.Enums.EnumSize;
import TFC.Items.ItemTerra;
import buildcraft.core.CreativeTabBuildCraft;

public class ItemPlan extends ItemTerra
{
	public Icon icons;
	public ItemPlan(int i) 
	{
		super(i);
		setCreativeTab(CreativeTabBuildCraft.tabBuildCraft);
		setHasSubtypes(true);
	}
	
	@Override
    public Icon getIconFromDamage(int i)
    {
        return icons;
    }
	
	@Override
    public void updateIcons(IconRegister registerer)
    {
		icons = registerer.registerIcon("BCTFCcrossover:" + getUnlocalizedName().replace("item.", ""));
    }
	
	@Override
	public EnumSize getSize() {
		return EnumSize.MEDIUM;
	}
}
