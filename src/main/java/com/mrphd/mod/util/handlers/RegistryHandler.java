package com.mrphd.mod.util.handlers;

import com.mrphd.mod.init.ModBlocks;
import com.mrphd.mod.init.ModItems;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class RegistryHandler {

	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		ModItems.registerAll(event.getRegistry());
		ModBlocks.registerItems(event.getRegistry());
	}
	
	@SubscribeEvent
	public static void OnBlockRegister(RegistryEvent.Register<Block> event) {
		ModBlocks.registerAll(event.getRegistry());
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {
		ModItems.registerModels();
		ModBlocks.registerModels();
	}
	
}
