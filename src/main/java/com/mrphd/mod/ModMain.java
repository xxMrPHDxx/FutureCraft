package com.mrphd.mod;

import com.mrphd.mod.init.ModSmeltingRecipes;
import com.mrphd.mod.proxy.CommonProxy;
import com.mrphd.mod.util.Reference;
import com.mrphd.mod.util.handlers.RegistryHandler;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

@Mod(modid=Reference.MOD_ID, name=Reference.NAME, version=Reference.VERSION)
public class ModMain {

	@Instance
	public static ModMain instance;
	
	@SidedProxy(clientSide=Reference.CLIENT_PROXY_CLASS, serverSide=Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event) {
		
	}
	
	@EventHandler
	public static void Init(FMLInitializationEvent event) {
		ModSmeltingRecipes.init();
	}
	
	@EventHandler
	public static void PostInit(FMLPostInitializationEvent event) {
//		GameRegistry.registerWorldGenerator(generator, modGenerationWeight);
	}
	
}
