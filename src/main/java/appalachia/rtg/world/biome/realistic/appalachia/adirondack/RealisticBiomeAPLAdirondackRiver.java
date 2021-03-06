package appalachia.rtg.world.biome.realistic.appalachia.adirondack;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;

import appalachia.api.AppalachiaBiomes;

import rtg.api.config.BiomeConfig;
import rtg.api.util.noise.OpenSimplexNoise;
import rtg.api.world.IRTGWorld;
import rtg.api.world.surface.SurfaceBase;
import rtg.api.world.terrain.TerrainBase;


public class RealisticBiomeAPLAdirondackRiver extends RealisticBiomeAPLAdirondackBase {

    public static Biome biome = AppalachiaBiomes.adirondackRiver;
    public static Biome river = AppalachiaBiomes.adirondackRiver;

    public RealisticBiomeAPLAdirondackRiver() {

        super(biome, river);
    }

    @Override
    public void initConfig() {

    }

    @Override
    public TerrainBase initTerrain() {

        return new TerrainAPLAdirondackRiver();
    }

    @Override
    public SurfaceBase initSurface() {

        return new SurfaceAPLAdirondackRiver(config);
    }

    public class SurfaceAPLAdirondackRiver extends SurfaceBase {

        public SurfaceAPLAdirondackRiver(BiomeConfig config) {

            super(config, Blocks.GRASS, (byte) 0, Blocks.DIRT, (byte) 0);
        }

        @Override
        public void paintTerrain(ChunkPrimer primer, int i, int j, int x, int z, int depth, IRTGWorld rtgWorld, float[] noise, float river, Biome[] base) {

            Random rand = rtgWorld.rand();
            OpenSimplexNoise simplex = rtgWorld.simplex();

            if (river > 0.05f && river + (simplex.noise2(i / 10f, j / 10f) * 0.15f) > 0.8f) {
                Block b;
                for (int k = 255; k > -1; k--) {
                    b = primer.getBlockState(x, k, z).getBlock();
                    if (b == Blocks.AIR) {
                        depth = -1;
                    }
                    else if (b != Blocks.WATER) {
                        depth++;

                        if (depth == 0 && k > 61) {
                            primer.setBlockState(x, k, z, Blocks.GRASS.getDefaultState());
                        }
                        else if (depth < 4) {
                            primer.setBlockState(x, k, z, Blocks.DIRT.getDefaultState());
                        }
                        else if (depth > 4) {
                            return;
                        }
                    }
                }
            }
        }
    }

    @Override
    public void initDecos() {

    }

    public class TerrainAPLAdirondackRiver extends TerrainBase {

        public TerrainAPLAdirondackRiver() {

        }

        @Override
        public float generateNoise(IRTGWorld rtgWorld, int x, int y, float border, float river) {

            return terrainFlatLakes(x, y, rtgWorld.simplex(), river, 3f, 60f);
        }
    }
}
