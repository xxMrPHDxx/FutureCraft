package com.mrphd.mod.init;

import java.util.HashMap;
import java.util.Map;

import com.mrphd.mod.items.block.BlockBase;
import com.mrphd.mod.items.item.ItemBase;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModSmeltingRecipes {

	public abstract static class Recipe {
		private Item input,output;
		private int count;
		public Recipe(Item input, Item output, int count) {
			this.input = input;
			this.output = output;
			this.count = count;
			
			RECIPES.put(input, this);
		}
		
		public Recipe(Item input, Item output) {
			this(input, output, 1);
		}
		
		public Recipe(Block block, Item output, int count) {
			this(Item.getItemFromBlock(block), output, count);
		}
		
		public Recipe(Block block, Item output) {
			this(Item.getItemFromBlock(block), output, 1);
		}
		
		public ItemStack getOutput() {
			return new ItemStack(output, count);
		}
		
		public abstract int getXp();
	}
	
	public static final Map<Object, Recipe> RECIPES = new HashMap<>();
	
	public static void init() {
		RECIPES.forEach((input, recipe) -> {
			if(input instanceof Block)
				GameRegistry.addSmelting((Block)input, recipe.getOutput(), recipe.getXp());
			else if(input instanceof Item)
				GameRegistry.addSmelting((Item)input, recipe.getOutput(), recipe.getXp());
		});
	}
	
	public static final Recipe QUARTZ_ORE = new Recipe(ModBlocks.QUARTZ_ORE, ModItems.QUARTZ, 4) {

		@Override
		public int getXp() {
			return 5;
		}
		
	}; 
	
}
