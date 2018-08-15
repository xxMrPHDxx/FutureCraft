package com.mrphd.mod.items.block;

import java.util.Random;

import com.mrphd.mod.init.ModItems;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class BlockQuartzOre extends BlockBase {

	public BlockQuartzOre(String name) {
		super(name, Material.ROCK);
		
		setSoundType(SoundType.STONE);
		setHardness(5.0f);
		setResistance(15.0f);
		setHarvestLevel("pickaxe", 1);
//		setLightLevel(1.0f);
//		setBlockUnbreakable();
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random random, int fortune) {
		return ModItems.QUARTZ;
	}
	
	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random) {
		int min = 1, max = 2, range = max - min + 1;
		return 1 + fortune * 2 / 3;
	}

}
