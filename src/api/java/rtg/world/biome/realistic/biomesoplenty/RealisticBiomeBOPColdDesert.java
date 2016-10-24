package rtg.world.biome.realistic.biomesoplenty;

import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

import biomesoplenty.api.biome.BOPBiomes;

import rtg.api.biome.BiomeConfig;
import rtg.world.biome.deco.DecoBaseBiomeDecorations;
import rtg.world.gen.surface.biomesoplenty.SurfaceBOPColdDesert;
import rtg.world.gen.terrain.biomesoplenty.TerrainBOPColdDesert;

public class RealisticBiomeBOPColdDesert extends RealisticBiomeBOPBase {

    public static Biome biome = BOPBiomes.cold_desert.get();
    public static Biome river = Biomes.FROZEN_RIVER;

    public RealisticBiomeBOPColdDesert(BiomeConfig config) {

        super(config, biome, river,
            new TerrainBOPColdDesert(),
            new SurfaceBOPColdDesert(config,
                Blocks.SNOW.getDefaultState(), //Block top
                biome.fillerBlock, //Block filler,
                Blocks.SNOW.getDefaultState(), //IBlockState mixTop,
                biome.fillerBlock, //IBlockState mixFill,
                80f, //float mixWidth, 
                -0.15f, //float mixHeight, 
                10f, //float smallWidth, 
                0.5f //float smallStrength
            )
        );

        DecoBaseBiomeDecorations decoBaseBiomeDecorations = new DecoBaseBiomeDecorations();
        this.addDeco(decoBaseBiomeDecorations);
    }
}
