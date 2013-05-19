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

import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;

public class Blocks {

//	public static Block Dandelion;
	
	static Configuration config;
	
	public static void RegisterBlocks() {
//		GameRegistry.registerBlock(Dandelion, "Dandelion");
	}
	
	public static void LoadBlocks() {
		try {
			config = new Configuration(new File(BCTFCcrossover.proxy.getMinecraftDir(), "/config/BCTFCcrossover.cfg"));
			config.load();
		} catch (Exception e) {
			System.out.println(new StringBuilder().append("[BCTFCcrossover] Config file ERROR!").toString());
			config = null;
		}
		
		System.out.println(new StringBuilder().append("[BCTFCcrossover] Loading Blocks").toString());
		
//		Blocks.Dandelion = new BlockDandelion(getItemID(config, "blocks", "Dandelion", IDProvider.Dandelion));
		
		if (config != null) {
			config.save();
		}
	}
	
	private static int getItemID(Configuration config, String heading, String item, int value) {
		if (config == null)	{
			return value;
		}
		
		try	{
			Property prop = config.get(heading, item, value);
			return prop.getInt(value);
		} catch (Exception e) {
			System.out.println(new StringBuilder().append("[BCTFCcrossover] ERROR adding Integer, config NOT loaded properly!").toString());
		}
		
		return value;
	}
}
