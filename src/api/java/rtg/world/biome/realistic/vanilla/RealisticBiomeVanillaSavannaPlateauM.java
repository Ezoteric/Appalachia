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
import rtg.util.*;
import rtg.world.biome.deco.*;
import rtg.world.biome.deco.collection.DecoCollectionDesertRiver;
import rtg.world.gen.feature.tree.rtg.TreeRTG;
import rtg.world.gen.feature.tree.rtg.TreeRTGAcaciaBucheri;
import rtg.world.gen.surface.SurfaceBase;
import rtg.world.gen.terrain.TerrainBase;

public class RealisticBiomeVanillaSavannaPlateauM extends RealisticBiomeVanillaBase {

    public static Biome biome = Biomes.MUTATED_SAVANNA_ROCK;
    public static Biome river = Biomes.RIVER;

    public RealisticBiomeVanillaSavannaPlateauM() {

        super(biome, river);

        this.noLakes = true;
    }

    @Override
    public void initConfig() {}

    @Override
    public TerrainBase initTerrain() {

        return new TerrainVanillaSavannaPlateauM(true, 35f, 160f, 60f, 40f, 69f);
    }

    public class TerrainVanillaSavannaPlateauM extends TerrainBase {

        private float[] height;
        private int heightLength;
        private float strength;

        /*
         * Example parameters:
         *
         * allowed to generate rivers?
         * riverGen = true
         *
         * canyon jump heights
         * heightArray = new float[]{2.0f, 0.5f, 6.5f, 0.5f, 14.0f, 0.5f, 19.0f, 0.5f}
         *
         * strength of canyon jump heights
         * heightStrength = 35f
         *
         * canyon width (cliff to cliff)
         * canyonWidth = 160f
         *
         * canyon heigth (total heigth)
         * canyonHeight = 60f
         *
         * canyon strength
         * canyonStrength = 40f
         *
         */
        public TerrainVanillaSavannaPlateauM(boolean riverGen, float heightStrength, float canyonWidth, float canyonHeight, float canyonStrength, float baseHeight) {
            /**
             * Values come in pairs per layer. First is how high to step up.
             * 	Second is a value between 0 and 1, signifying when to step up.
             */
            height = new float[]{18f, 0.4f, 12f, 0.6f, 8f, 0.8f};
            strength = 10f;
            heightLength = height.length;
        }

        @Override
        public float generateNoise(OpenSimplexNoise simplex, CellNoise cell, int x, int y, float border, float river) {

            return terrainPlateau(x, y, simplex, river, height, border, strength, heightLength, 50f, true);
        }
    }

    @Override
    public SurfaceBase initSurface() {

        return new SurfaceVanillaSavannaPlateauM(config, biome.topBlock, biome.fillerBlock, 0);
    }

    @Override
    public Biome beachBiome() {
        return this.beachBiome(Biomes.BEACH);
    }

    public class SurfaceVanillaSavannaPlateauM extends SurfaceBase {

        private int grassRaise = 0;

        public SurfaceVanillaSavannaPlateauM(BiomeConfig config, IBlockState top, IBlockState fill, int grassHeight) {

            super(config, top, fill);
            grassRaise = grassHeight;
        }

        @Override
        public void paintTerrain(ChunkPrimer primer, int i, int j, int x, int z, int depth, World world, Random rand, OpenSimplexNoise simplex, CellNoise cell, float[] noise, float river, Biome[] base) {

            float c = CliffCalculator.calc(x, z, noise);
            boolean cliff = c > 1.3f;
            Block b;

            for(int k = 255; k > -1; k--)
            {
                b = primer.getBlockState(x, k, z).getBlock();
                if(b == Blocks.AIR)
                {
                    depth = -1;
                }
                else if (b == Blocks.STONE) {
                    depth++;

                    if (cliff) {
//                    if (!ConfigRTG.stoneSavannas) {
                        primer.setBlockState(x, k, z, CanyonColour.SAVANNA.getBlockForHeight(i, k, j));
//                    }
//                    else {
//                        if (depth > -1 && depth < 2) {
//                            if (rand.nextInt(3) == 0) {
//
//                                primer.setBlockState(x, k, z, hcCobble(world, i, j, x, y, k));
//                            }
//                            else {
//
//                                primer.setBlockState(x, k, z, hcStone(world, i, j, x, y, k));
//                            }
//                        }
//                        else if (depth < 10) {
//                            primer.setBlockState(x, k, z, hcStone(world, i, j, x, y, k));
//                        }
//                    }
                    }
                    else {

                        if (k > 74 + grassRaise)
                        {
                            if (depth == 0) {
                                if (rand.nextInt(5) == 0) {
                                    primer.setBlockState(x, k, z, BlockUtil.getStateDirt(1));
                                }
                                else {
                                    primer.setBlockState(x, k, z, topBlock);
                                }
                            }
                            else if (depth < 4) {
                                primer.setBlockState(x, k, z, fillerBlock);
                            }
                        }
                        else if (depth == 0 && k > 61) {
                            int r = (int)((k - (62 + grassRaise)) / 2f);
                            if(rand.nextInt(r + 2) == 0)
                            {
                                primer.setBlockState(x, k, z, Blocks.GRASS.getDefaultState());
                            }
                            else if(rand.nextInt((int)(r / 2f) + 2) == 0)
                            {
                                primer.setBlockState(x, k, z, BlockUtil.getStateDirt(1));
                            }
                            else
                            {
                                primer.setBlockState(x, k, z, topBlock);
                            }
                        }
                        else if (depth < 4) {
                            primer.setBlockState(x, k, z, fillerBlock);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void initDecos() {

        this.addDecoCollection(new DecoCollectionDesertRiver());

        DecoBoulder decoBoulder1 = new DecoBoulder();
        decoBoulder1.boulderBlock = Blocks.COBBLESTONE.getDefaultState();
        decoBoulder1.maxY = 80;
        decoBoulder1.chance = 24;
        this.addDeco(decoBoulder1);

        DecoBoulder decoBoulder2 = new DecoBoulder();
        decoBoulder2.boulderBlock = Blocks.COBBLESTONE.getDefaultState();
        decoBoulder1.minY = 110;
        decoBoulder2.chance = 24;
        this.addDeco(decoBoulder2);

        DecoShrub acaciaShrub = new DecoShrub();
        acaciaShrub.logBlock = Blocks.LOG2.getDefaultState();
        acaciaShrub.leavesBlock = Blocks.LEAVES2.getDefaultState();
        acaciaShrub.maxY = 160;
        acaciaShrub.strengthFactor = 3f;
        acaciaShrub.chance = 9;
        this.addDeco(acaciaShrub);

        TreeRTG acaciaTree = new TreeRTGAcaciaBucheri();
        acaciaTree.logBlock = Blocks.LOG2.getDefaultState();
        acaciaTree.leavesBlock = Blocks.LEAVES2.getDefaultState();
        acaciaTree.minTrunkSize = 12;
        acaciaTree.maxTrunkSize = 16;
        this.addTree(acaciaTree);

        DecoTree acaciaTrees = new DecoTree(acaciaTree);
        acaciaTrees.strengthFactorForLoops = 2f;
        acaciaTrees.treeType = DecoTree.TreeType.RTG_TREE;
        acaciaTrees.treeCondition = DecoTree.TreeCondition.RANDOM_CHANCE;
        acaciaTrees.treeConditionChance = 12;
        acaciaTrees.maxY = 160;
        this.addDeco(acaciaTrees);

        DecoCactus decoCactus = new DecoCactus();
        decoCactus.maxY = 160;
        decoCactus.loops = 60;
        decoCactus.chance = 8;
        this.addDeco(decoCactus);

        DecoDoubleGrass decoDoubleGrass = new DecoDoubleGrass();
        decoDoubleGrass.maxY = 128;
        decoDoubleGrass.strengthFactor = 3f;
        this.addDeco(decoDoubleGrass);

        DecoGrass decoGrass = new DecoGrass();
        decoGrass.maxY = 128;
        decoGrass.strengthFactor = 10f;
        this.addDeco(decoGrass);
    }
}
