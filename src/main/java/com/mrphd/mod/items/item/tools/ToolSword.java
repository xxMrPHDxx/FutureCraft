package com.mrphd.mod.items.item.tools;

import java.util.Set;

import com.mrphd.mod.ModMain;
import com.mrphd.mod.init.ModItems;
import com.mrphd.mod.util.IHasModel;
import com.mrphd.mod.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class ToolSword extends ItemSword implements IHasModel {
	
	public ToolSword(String name, ToolMaterial material) {
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
