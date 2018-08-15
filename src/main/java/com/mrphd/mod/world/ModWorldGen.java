package com.mrphd.mod.world;

import java.util.Random;

import com.mrphd.mod.init.ModBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class ModWorldGen implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator generator,IChunkProvider provider) {
		switch(world.provider.getDimension()) {
			case 0:
				generateOverworld(random, chunkX * 16, chunkZ * 16, world, generator, provider);
				break;
		}
	}
	
	private void generateOverworld(Random random, int x, int z, World world, IChunkGenerator generator, IChunkProvider provider) {
		generateOre(ModBlocks.QUARTZ_ORE.getDefaultState(), world, random, x, z, 12, 40, 4, 6, 8);
	}
	
	private void generateOre(IBlockState ore, World world, Random random, int x, int z, int minY, int maxY, int minSize, int maxSize, int chance) {
		int delta = maxY - minY;
		
		int xPos, yPos, zPos;
		for(int i=0;i<chance;i++) {
			xPos = x + random.nextInt(16);
			yPos = minY + random.nextInt(delta);
			zPos = z + random.nextInt(16);
			
			WorldGenMinable generator = new WorldGenMinable(ore, minSize + random.nextInt(maxSize - minSize + 1));
			generator.generate(world, random, new BlockPos(xPos,yPos,zPos));
		}
	}

}
