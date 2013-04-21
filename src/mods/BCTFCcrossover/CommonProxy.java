package mods.BCTFCcrossover;

import java.io.File;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy implements IGuiHandler
{

	public void registerRenderInformation() {
		// NOOP on server
	}

	public File getMinecraftDir() {
		return ModLoader.getMinecraftServerInstance().getFile("");/*new File(".");*/
	}
	
	public void takenFromCrafting(EntityPlayer entityplayer, ItemStack itemstack, IInventory iinventory){
		GameRegistry.onItemCrafted(entityplayer, itemstack, iinventory);  
	}

	public boolean isRemote() {
		return false;
	}
	
	public World getCurrentWorld() {
		return null;
	}
	
	public void registerTranslations() {
	}

	public void registerItem(Item item) {
		GameRegistry.registerItem(item, item.getUnlocalizedName().replace("item.", ""));
	}
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCurrentLanguage() {
		return null;
	}

	public void addName(Object obj, String s) {
	}

	public void addLocalization(String s1, String string) {
	}

	public String getItemDisplayName(ItemStack stack) {
		return "";
	}
	
	public void addCraftingRecipe(ItemStack result, Object[] recipe) {
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(result, recipe));
		//GameRegistry.addRecipe(result, recipe);
	}

	public void addShapelessRecipe(ItemStack result, Object[] recipe) {
		GameRegistry.addShapelessRecipe(result, recipe);
	}
	
}
