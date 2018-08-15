package com.mrphd.mod.init;

import java.util.ArrayList;
import java.util.List;

import com.mrphd.mod.items.block.BlockBase;
import com.mrphd.mod.items.block.BlockSinteringFurnace;
import com.mrphd.mod.items.block.BlockQuartzOre;
import com.mrphd.mod.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {

	private static final List<Block> BLOCKS = new ArrayList<>();

	public static final Block QUARTZ_ORE = new BlockQuartzOre("quartz_ore");
	public static final Block SINTERING_FURNACE = new BlockSinteringFurnace("sintering_furnace");
	
	public static final void add(Block block) {
		BLOCKS.add(block);
	}
	
	public static final void registerAll(IForgeRegistry<Block> registry) {
		BLOCKS.forEach(block -> {
			registry.register(block);
		});
	}
	
	public static final void registerItems(IForgeRegistry<Item> registry) {
		BLOCKS.forEach(block -> {
			if(block instanceof Block) {
				registry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
			}
		});
	}
	
	public static final void registerModels() {
		BLOCKS.forEach(block -> {
			if(block instanceof Block) {
				Item item = Item.getItemFromBlock(block);
				if(item instanceof IHasModel) {
					((IHasModel)item).registerModels();
				}
				
				if(block instanceof IHasModel) {
					((IHasModel)block).registerModels();
				}
			}
		});
	}
	
}
