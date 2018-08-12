package com.mrphd.mod.items.item;

import com.mrphd.mod.ModMain;
import com.mrphd.mod.init.ModItems;
import com.mrphd.mod.util.IHasModel;
import com.mrphd.mod.util.Reference;

import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {

	public ItemBase(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Reference.CREATIVE_TAB);
		
		ModItems.add(this);
	}

	@Override
	public Item get() {
		return this;
	}
	
}
