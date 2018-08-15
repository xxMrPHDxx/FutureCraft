package com.mrphd.mod.util.handlers;

import com.mrphd.mod.items.tileentity.TileEntitySinteringFurnace;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler {

	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntitySinteringFurnace.class, "sintering_furnace");
	}
	
}
