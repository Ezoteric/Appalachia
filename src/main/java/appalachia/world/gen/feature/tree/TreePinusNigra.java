package appalachia.world.gen.feature.tree;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Pinus Nigra (Austrian Pine)
 */
public class TreePinusNigra extends AppalachiaTree {

    public TreePinusNigra() {

        super();
    }

    @Override
    public boolean generate(World world, Random rand, BlockPos pos) {

        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        IBlockState g = world.getBlockState(new BlockPos(x, y - 1, z));
        if (g != Blocks.GRASS.getDefaultState() && g != Blocks.DIRT.getDefaultState()) {
            return false;
        }

        int height = this.trunkSize;
        int leafheight = this.crownSize;
        float branchIncrease = 0.25f;

        for (int i = 0; i <= height; i++) {
            world.setBlockState(new BlockPos(x, y + i, z), this.logBlock, this.generateFlag);
        }
        buildLeaves(world, rand, x, y + height, z, 2);
        buildTrunk(world, rand, x, y, z);

        int dir = 0, b;
        float xd, yd, bl = 1f;
        for (int j = height; j >= height - leafheight; j--) {
            bl += branchIncrease;
            dir += rand.nextInt(180) + 90;
            dir -= dir > 360 ? 360 : 0;
            xd = (float) Math.cos(dir * Math.PI / 180f);
            yd = (float) Math.sin(dir * Math.PI / 180f);

            for (b = 0; b <= bl; b++) {
                //TODO: this.logMeta + 12 (meta)
                world.setBlockState(new BlockPos(x + (int) (b * xd), y + j, z + (int) (b * yd)), this.logBlock, this.generateFlag);
            }
            buildLeaves(world, rand, x, y + j, z, 2);
            buildLeaves(world, rand, x + (int) (b * xd), y + j, z + (int) (b * yd), 2);
        }

        return true;
    }

    public void buildLeaves(World world, Random rand, int x, int y, int z, int size) {

        if (!this.noLeaves) {

            int l;
            int t = (int) Math.pow(size, 2);
            for (int i = -size; i <= size; i++) {
                for (int j = -size; j <= size; j++) {
                    for (int k = -size; k <= size; k++) {
                        l = i * i + j * j + k * k;
                        if (l <= t) {
                            if (world.isAirBlock(new BlockPos(x + i, y + j, z + k)) && (l < t / 2 || rand.nextBoolean())) {
                                world.setBlockState(new BlockPos(x + i, y + j, z + k), this.leavesBlock, this.generateFlag);
                            }
                        }
                    }
                }
            }
        }
    }

    public void buildTrunk(World world, Random rand, int x, int y, int z) {

        int[] pos = new int[]{0, 0, 1, 0, 0, 1, -1, 0, 0, -1};
        int sh;
        for (int t = 0; t < 5; t++) {
            sh = rand.nextInt(3) + y;
            while (sh > y - 3) {
                if (world.getBlockState(new BlockPos(x + pos[t * 2], sh, z + pos[t * 2 + 1])) == Blocks.DIRT.getDefaultState()) {
                    break;
                }

                //TODO: this.logMeta + 12 (meta)
                world.setBlockState(new BlockPos(x + pos[t * 2], sh, z + pos[t * 2 + 1]), this.logBlock, this.generateFlag);
                sh--;
            }
        }
    }
}
