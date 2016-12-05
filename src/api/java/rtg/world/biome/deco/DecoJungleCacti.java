package rtg.world.biome.deco;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.WorldGenerator;

import net.minecraftforge.event.terraingen.TerrainGen;
import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.CACTUS;

import rtg.api.world.RTGWorld;
import rtg.world.biome.realistic.RealisticBiomeBase;
import rtg.world.gen.feature.WorldGenJungleCacti;

/**
 * @author WhichOnesPink
 */
public class DecoJungleCacti extends DecoBase {

    public float strengthFactor;
    public int maxY;
    public boolean sandOnly;
    public int extraHeight;
    public byte sandMeta;

    public DecoJungleCacti() {

        super();

        /**
         * Default values.
         * These can be overridden when configuring the Deco object in the realistic biome.
         */
        this.strengthFactor = 8f;
        this.maxY = 255; // No height limit by default.
        this.sandOnly = false;
        this.extraHeight = 7;
        this.sandMeta = (byte) 1;

        this.addDecoTypes(DecoType.CACTUS);
    }

    @Override
    public void generate(RealisticBiomeBase biome, RTGWorld rtgWorld, Random rand, int worldX, int worldZ, float strength, float river, boolean hasPlacedVillageBlocks) {

        if (this.allowed) {

            if (TerrainGen.decorate(rtgWorld.world, rand, new BlockPos(worldX, 0, worldZ), CACTUS)) {

                WorldGenerator worldGenerator = new WorldGenJungleCacti(this.sandOnly, rand.nextInt(this.extraHeight), this.sandMeta);

                for (int i = 0; i < this.strengthFactor * strength; i++) {
                    int intX = worldX + rand.nextInt(16);// + 8;
                    int intY = rand.nextInt(160);
                    int intZ = worldZ + rand.nextInt(16);// + 8;

                    if (intY < this.maxY) {
                        worldGenerator.generate(rtgWorld.world, rand, new BlockPos(intX, intY, intZ));
                    }
                }
            }
        }
    }
}
