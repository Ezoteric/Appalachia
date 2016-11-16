package rtg.world.biome.realistic.vanilla;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;

import rtg.config.BiomeConfig;
import rtg.util.BlockUtil;
import rtg.util.CellNoise;
import rtg.util.CliffCalculator;
import rtg.util.OpenSimplexNoise;
import rtg.world.biome.deco.DecoBaseBiomeDecorations;
import rtg.world.biome.deco.DecoBoulder;
import rtg.world.biome.deco.DecoFallenTree;
import rtg.world.gen.surface.SurfaceBase;
import rtg.world.gen.terrain.TerrainBase;

public class RealisticBiomeVanillaIcePlains extends RealisticBiomeVanillaBase {

	public static Biome biome = Biomes.ICE_PLAINS;
	public static Biome river = Biomes.FROZEN_RIVER;
	
	public RealisticBiomeVanillaIcePlains() {

		super(biome, river);
	}

	@Override
	public void initConfig() {

		this.getConfig().addProperty(this.getConfig().ALLOW_LOGS).set(true);
	}

	@Override
	public TerrainBase initTerrain() {

		return new TerrainVanillaIcePlains();
	}

	public class TerrainVanillaIcePlains extends TerrainBase {

		public TerrainVanillaIcePlains() {

		}

		@Override
		public float generateNoise(OpenSimplexNoise simplex, CellNoise cell, int x, int y, float border, float river) {

			return terrainPlains(x, y, simplex, river, 160f, 10f, 60f, 200f, 65f);
		}
	}

	@Override
	public SurfaceBase initSurface() {

		return new SurfaceVanillaIcePlains(config, biome.topBlock, biome.fillerBlock, biome.topBlock, biome.topBlock);
	}

	public class SurfaceVanillaIcePlains extends SurfaceBase
	{
		private IBlockState cliffBlock1;
		private IBlockState cliffBlock2;

		public SurfaceVanillaIcePlains(BiomeConfig config, IBlockState top, IBlockState filler, IBlockState cliff1, IBlockState cliff2)
		{
			super(config, top, filler);

			cliffBlock1 = cliff1;
			cliffBlock2 = cliff2;
		}

		@Override
		public void paintTerrain(ChunkPrimer primer, int i, int j, int x, int y, int depth, World world, Random rand, OpenSimplexNoise simplex, CellNoise cell, float[] noise, float river, Biome[] base) {

			float c = CliffCalculator.calc(x, y, noise);
			boolean cliff = c > 1.4f ? true : false;

			for (int k = 255; k > -1; k--) {
				Block b = primer.getBlockState(x, k, y).getBlock();
				if (b == Blocks.AIR) {
					depth = -1;
				}
				else if (b == Blocks.STONE) {
					depth++;

					if(cliff)
					{
						if(depth > -1 && depth < 2)
						{
							primer.setBlockState(x, k, y, rand.nextInt(3) == 0 ? cliffBlock2 : cliffBlock1);
						}
						else if (depth < 10)
						{
							primer.setBlockState(x, k, y, cliffBlock1);
						}
					}
					else
					{
						if(depth == 0 && k > 61)
						{
							primer.setBlockState(x, k, y, topBlock);
						}
						else if(depth < 4)
						{
							primer.setBlockState(x, k, y, fillerBlock);
						}
					}
				}
			}
		}
	}

	@Override
	public void initDecos() {

		DecoBaseBiomeDecorations decoBaseBiomeDecorations = new DecoBaseBiomeDecorations();
		this.addDeco(decoBaseBiomeDecorations);

		DecoBoulder decoBoulder = new DecoBoulder();
		decoBoulder.checkRiver = true;
		decoBoulder.minRiver = 0.87f;
		decoBoulder.boulderBlock = Blocks.COBBLESTONE.getDefaultState();
		decoBoulder.chance = 16;
		decoBoulder.maxY = 95;
		decoBoulder.strengthFactor = 5f;
		this.addDeco(decoBoulder);

		DecoFallenTree decoFallenTree = new DecoFallenTree();
		decoFallenTree.logCondition = DecoFallenTree.LogCondition.NOISE_GREATER_AND_RANDOM_CHANCE;
		decoFallenTree.logConditionChance = 24;
		decoFallenTree.logBlock = BlockUtil.getStateLog(1);
		decoFallenTree.leavesBlock = BlockUtil.getStateLeaf(1);
		decoFallenTree.minSize = 1;
		decoFallenTree.maxSize = 5;
		this.addDeco(decoFallenTree, this.getConfig().ALLOW_LOGS.get());
	}
}
