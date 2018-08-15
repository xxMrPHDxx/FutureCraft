package com.mrphd.mod.items.tileentity;

import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import com.mrphd.mod.init.ModBlocks;
import com.mrphd.mod.init.ModItems;

import net.minecraft.item.ItemStack;

public class SinteringFurnaceRecipes {

	public static final SinteringFurnaceRecipes INSTANCE = new SinteringFurnaceRecipes();
	private final Table<ItemStack, ItemStack, ItemStack> smeltingList = HashBasedTable.create();
	private final Map<ItemStack, Float> experienceList = Maps.newHashMap();
	
	public static SinteringFurnaceRecipes getInstance() { return INSTANCE; }
	
	private SinteringFurnaceRecipes() {
		add(new ItemStack(ModBlocks.QUARTZ_ORE), new ItemStack(ModBlocks.QUARTZ_ORE), new ItemStack(ModItems.QUARTZ, 3), 18f);
	}
	
	public void add(ItemStack input1, ItemStack input2, ItemStack result, float exp) {
		if(getSinteringResult(input1, input2) != ItemStack.EMPTY) return;
		this.smeltingList.put(input1, input2, result);
		this.experienceList.put(result, Float.valueOf(exp));
	}
	
	public ItemStack getSinteringResult(ItemStack input1, ItemStack input2) {
		for(Entry<ItemStack, Map<ItemStack, ItemStack>> entry : this.smeltingList.columnMap().entrySet()) {
			if(this.compareItemStacks(input1, (ItemStack)entry.getKey())) {
				for(Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet()) {
					if(this.compareItemStacks(input2, (ItemStack)entry.getKey())) {
						return (ItemStack)ent.getValue();
					}
				}
			}
		}
		return ItemStack.EMPTY;
	}
	
	private boolean compareItemStacks(ItemStack s1, ItemStack s2) {
		return s2.getItem() == s1.getItem() && (s2.getMetadata() == 32767 || s2.getMetadata() == s1.getMetadata());
	}
	
	public Table<ItemStack, ItemStack, ItemStack> getDualSmeltingList(){
		return this.smeltingList;
	}
	
	public float getExperience(ItemStack stack) {
		for(Entry<ItemStack, Float> entry : this.experienceList.entrySet()) {
			if(this.compareItemStacks(stack, (ItemStack)entry.getKey())) {
				return ((Float)entry.getValue()).floatValue();
			}
		}
		return 0f;
	}
	
}
