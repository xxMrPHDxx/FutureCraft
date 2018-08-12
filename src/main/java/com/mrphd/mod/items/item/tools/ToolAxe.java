package com.mrphd.mod.items.item.tools;

import com.mrphd.mod.init.ModItems;
import com.mrphd.mod.util.IHasModel;
import com.mrphd.mod.util.Reference;

import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;

public class ToolAxe extends ItemAxe implements IHasModel {

	public ToolAxe(String name, ToolMaterial material) {
		super(material, 6.0f, -3.2f);
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
