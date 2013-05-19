/**
 *  Copyright (C) 2013  emris
 *  https://github.com/emris/BCTFCcrossover
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
package mods.BCTFCcrossover;

import java.io.File;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy {

	public File getMinecraftDir() {
		return ModLoader.getMinecraftServerInstance().getFile("");/*new File(".");*/
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
	
	public void registerOreDict() {
		// Register Rubber to OreDictionery
		String[] rubberNames = new String[]{"rubberBlack", "rubberRed", "rubberGreen", "rubberBrown", "rubberBlue", "rubberPurple", "rubberCyan", "rubberLightGray", "rubberGray", "rubberPink", "rubberLimeGreen", "rubberYellow", "rubberLightBlue", "rubberMagenta", "rubberOrange", "rubberWhite"};
		for (int i = 0; i < rubberNames.length; ++i) {
			OreDictionary.registerOre(rubberNames[i], new ItemStack(Items.Rubber.itemID, 1, i));
		}
		String[] woodBucketNames = new String[]{"woodBucketOil", "woodBucketFuel", "woodBucketLatex"};
		for (int i = 0; i < woodBucketNames.length; ++i) {
			OreDictionary.registerOre(woodBucketNames[i], new ItemStack(Items.WoodBuckets.itemID, 1, i));
		}
		String[] pipeFrameNames = new String[]{"pipeFrameTin", "pipeFrameLead", "pipeFrameBronze", "pipeFrameWroughtIron", "pipeFrameSteel", "pipeFrameBlueSteel", "pipeFrameRedSteel", "pipeFrameBlackBronze", "pipeFrameRoseGold", "pipeFrameBlackSteel", "pipeFrameZinc", "pipeFrameCopper", "pipeFrameSilver"};
		for (int i = 0; i < pipeFrameNames.length; ++i) {
			OreDictionary.registerOre(pipeFrameNames[i], new ItemStack(Items.PipeFrames.itemID, 1, i));
		}
		String[] gearNames= new String[]{"gearBismuthBronze", "gearBlackBronze", "gearBronze", "gearRoseGold", "gearWroughtIron", "gearSteel", "gearBlackSteel", "gearBlueSteel", "gearRedSteel"};
		for (int i = 0; i < gearNames.length; ++i) {
			OreDictionary.registerOre(gearNames[i], new ItemStack(Items.Gears.itemID, 1, i));
		}
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
//		GameRegistry.addRecipe(result, recipe);
	}

	public void addShapelessRecipe(ItemStack result, Object[] recipe) {
		GameRegistry.addShapelessRecipe(result, recipe);
	}

	public void registerPipeRenderer() {
	}

}
