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
package mods.BCTFCcrossover.core;

import mods.BCTFCcrossover.Items;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import TFC.TFCItems;
import TFC.Core.Recipes;
import cpw.mods.fml.common.ICraftingHandler;

public class CraftingHandler implements ICraftingHandler {

	@Override
	public void onCrafting(EntityPlayer player, ItemStack item,	IInventory craftMatrix) {
		if(craftMatrix != null) {
			if(item.itemID == Items.Rubber.itemID) {
				for(int i = 0; i < craftMatrix.getSizeInventory(); i++) {
					if(craftMatrix.getStackInSlot(i) == null) {
						continue;
					}
					if(craftMatrix.getStackInSlot(i).itemID == Items.WoodBuckets.itemID) {
						ItemStack b = new ItemStack(TFCItems.WoodenBucketEmpty);
						if(b != null) {
							craftMatrix.setInventorySlotContents(i, b);
							craftMatrix.getStackInSlot(i).stackSize = 2;
						}
					}
				}
			}
			
			if(item.itemID == Item.dyePowder.itemID && item.getItemDamage() == 2) {
				Item[] tfcHammers = Recipes.Hammers;
				for(int i = 0; i < craftMatrix.getSizeInventory(); i++) {
					if(craftMatrix.getStackInSlot(i) == null) {
						continue;
					}
					for(int j = 0; j < tfcHammers.length; j++) {
						if(craftMatrix.getStackInSlot(i).itemID == tfcHammers[j].itemID) {
							ItemStack tfcHammer = craftMatrix.getStackInSlot(i).copy();
							if(tfcHammer != null) {
								tfcHammer.damageItem(1, player);
								if(tfcHammer.getItemDamage() != 0 || player.capabilities.isCreativeMode) {
									craftMatrix.setInventorySlotContents(i, tfcHammer);
									craftMatrix.getStackInSlot(i).stackSize = 2;
								}
							}
						}
					}
				}
			}
			
		}
	}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) {
		// TODO Auto-generated method stub
	}

}
