package com.mrphd.mod.util;

import java.util.HashSet;
import java.util.Set;

import com.mrphd.mod.init.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class Reference {

	// Mod Information
	public static final String MOD_ID = "cm";
	public static final String NAME = "Custom Mod";
	public static final String VERSION = "1.0";
	public static final String CLIENT_PROXY_CLASS = "com.mrphd.mod.proxy.ClientProxy";
	public static final String COMMON_PROXY_CLASS = "com.mrphd.mod.proxy.CommonProxy";
	
	// Gui stuff
	public static final int GUI_SINTERING_FURNACE = 0; 
	
	// Custom Creative Tabs
	public static final CreativeTabs CREATIVE_TAB = new CreativeTabs("modMainTab") {

		public ItemStack getTabIconItem() {
			return new ItemStack(ModBlocks.QUARTZ_ORE);
		}
		
	};
	
	// List of blocks?
	public static final Set<Block> NO_EFFECTIVE_BLOCK = new HashSet<>();
	
	// Font stuff
	public static final int FONT_COLOR = 4210752;
	
}
