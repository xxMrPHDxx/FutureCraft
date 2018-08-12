package com.mrphd.mod.init;

import java.util.ArrayList;
import java.util.List;

import com.mrphd.mod.items.item.ItemQuartz;
import com.mrphd.mod.items.item.tools.ToolAxe;
import com.mrphd.mod.items.item.tools.ToolHoe;
import com.mrphd.mod.items.item.tools.ToolPickaxe;
import com.mrphd.mod.items.item.tools.ToolSpade;
import com.mrphd.mod.items.item.tools.ToolSword;
import com.mrphd.mod.util.IHasModel;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {

	private static final List<Item> ITEMS = new ArrayList<>();
	
	public static final void add(Item block) {
		ITEMS.add(block);
	}
	
	public static final void registerAll(IForgeRegistry<Item> registry) {
		ITEMS.forEach(item -> {
			registry.register(item);
		});
	}
	
	public static final void registerModels() {
		ITEMS.forEach(item -> {
			if(item instanceof IHasModel) {
				((IHasModel)item).registerModels();
			}
		});
	}
	
	// ITEMS
	public static final Item QUARTZ = new ItemQuartz("quartz");
	
	// MATERIALS
	public static final ToolMaterial MATERIAL_QUARTZ = EnumHelper.addToolMaterial(
		"material_quartz", 		// Name
		1, 						// Harvest Level
		280, 					// Max Uses
		2.5f, 					// Efficiency
		2.0f, 					// Damage
		4						// Enchantability
	);
	
	// TOOLS
	public static final ItemSword QUARTZ_SWORD = new ToolSword("quartz_sword", MATERIAL_QUARTZ);
	public static final ItemSpade QUARTZ_SHOVEL = new ToolSpade("quartz_shovel", MATERIAL_QUARTZ);
	public static final ItemPickaxe QUARTZ_PICKAXE = new ToolPickaxe("quartz_pickaxe", MATERIAL_QUARTZ);
	public static final ItemHoe QUARTZ_HOE = new ToolHoe("quartz_hoe", MATERIAL_QUARTZ);
	public static final ItemAxe QUARTZ_AXE = new ToolAxe("quartz_axe", MATERIAL_QUARTZ);
	
}
