package com.mrphd.mod.util;

import com.mrphd.mod.ModMain;

import net.minecraft.item.Item;

public interface IHasModel {

	public Item get();
	
	public default void registerModels() {
		ModMain.proxy.registerItemRenderer(get(), 0, "inventory");
	}
	
}
