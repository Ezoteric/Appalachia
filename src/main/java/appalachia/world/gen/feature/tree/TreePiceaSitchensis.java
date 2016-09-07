package appalachia.world.gen.feature.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Picea Sitchensis (Sitka Spruce)
 */
public class TreePiceaSitchensis extends AppalachiaTree {

    public TreePiceaSitchensis() {

        super();

        this.logBlock = Blocks.LOG.getStateFromMeta(1);
        this.leavesBlock = Blocks.LEAVES.getStateFromMeta(1);
        this.trunkSize = 8;
        this.crownSize = 10;
        this.noLeaves = false;

        this.validGroundBlocks = new ArrayList<IBlockState>(Arrays.asList(Blocks.GRASS.getDefaultState(), Blocks.DIRT.getDefaultState()));
    }

    @Override
    public boolean generate(World world, Random rand, BlockPos pos) {

        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();

        IBlockState g = world.getBlockState(new BlockPos(x, y - 1, z));
        boolean validGroundBlock = false;

        for (int i = 0; i < this.validGroundBlocks.size(); i++) {
            if (g == this.validGroundBlocks.get(i)) {
                validGroundBlock = true;
                break;
            }
        }

        if (!validGroundBlock) {
            return false;
        }

        int i;
        for (i = 0; i < this.trunkSize; i++) {
            world.setBlockState(new BlockPos(x, y, z), this.logBlock, this.generateFlag);
            y++;
        }

        int pX = 0;
        int pZ = 0;
        for (i = 0; i < this.crownSize; i++) {
            if (rand.nextInt(2) == 0 && i < this.crownSize - 2) {
                int dX = -1 + rand.nextInt(3);
                int dZ = -1 + rand.nextInt(3);

                if (dX == 0 && dZ == 0) {
                    dX = -1 + rand.nextInt(3);
                    dZ = -1 + rand.nextInt(3);
                }

                if (pX == dX && rand.nextBoolean()) {
                    dX = -dX;
                }
                if (pZ == dZ && rand.nextBoolean()) {
                    dZ = -dZ;
                }

                pX = dX;
                pZ = dZ;

                buildBranch(world, rand, x, y, z, dX, dZ, i < this.crownSize - 10 ? 2 : 1, i < this.crownSize - 6 ? 2 : 1);
            }
            world.setBlockState(new BlockPos(x, y, z), this.logBlock, this.generateFlag);

            if (i < this.crownSize - 2) {
                if (rand.nextBoolean()) {
                    buildLeaves(world, x, y, z + 1);
                }
                if (rand.nextBoolean()) {
                    buildLeaves(world, x, y, z - 1);
                }
                if (rand.nextBoolean()) {
                    buildLeaves(world, x + 1, y, z);
                }
                if (rand.nextBoolean()) {
                    buildLeaves(world, x - 1, y, z);
                }
            }

            y++;
        }

        buildLeaves(world, x, y - 1, z + 1);
        buildLeaves(world, x, y - 1, z - 1);
        buildLeaves(world, x + 1, y - 1, z);
        buildLeaves(world, x - 1, y - 1, z);
        buildLeaves(world, x, y, z);

        return true;
    }

    public void buildBranch(World world, Random rand, int x, int y, int z, int dX, int dZ, int logLength, int leaveSize) {

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                for (int k = 0; k < 2; k++) {
                    if (Math.abs(i) + Math.abs(j) + Math.abs(k) < leaveSize + 1) {
                        buildLeaves(world, x + i + (dX * logLength), y + k, z + j + (dZ * logLength));
                    }
                }
            }
        }

        for (int m = 1; m <= logLength; m++) {
            world.setBlockState(new BlockPos(x + (dX * m), y, z + (dZ * m)), this.logBlock, this.generateFlag);
        }
    }

    public void buildLeaves(World world, int x, int y, int z) {

        if (!this.noLeaves) {

            IBlockState b = world.getBlockState(new BlockPos(x, y, z));
            if (b.getMaterial() == Material.AIR) {
                world.setBlockState(new BlockPos(x, y, z), this.leavesBlock, this.generateFlag);
            }
        }
    }
}
