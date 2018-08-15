package com.mrphd.mod.items.block;

import java.util.Random;

import com.mrphd.mod.ModMain;
import com.mrphd.mod.init.ModBlocks;
import com.mrphd.mod.util.IHasModel;
import com.mrphd.mod.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public abstract class BlockBase extends Block implements IHasModel {
	
	public BlockBase(String name, Material blockMaterialIn, MapColor blockMapColorIn) {
		super(blockMaterialIn, blockMapColorIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Reference.CREATIVE_TAB);
		
		ModBlocks.add(this);
	}

	public BlockBase(String name, Material blockMaterialIn) {
		this(name, blockMaterialIn, blockMaterialIn.getMaterialMapColor());
	}
	
	@Override
	public Item get() {
		return Item.getItemFromBlock(this);
	}
	
	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random) {
		return 1;
	}

	public abstract Item getItemDropped(IBlockState state, Random random, int fortune);

}
