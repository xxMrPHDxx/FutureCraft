package com.mrphd.mod.items.item.tools;

import com.mrphd.mod.ModMain;
import com.mrphd.mod.init.ModItems;
import com.mrphd.mod.util.IHasModel;
import com.mrphd.mod.util.Reference;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemHoe;

public class ToolHoe extends ItemHoe implements IHasModel {

	public ToolHoe(String name, ToolMaterial material) {
		super(material);
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
