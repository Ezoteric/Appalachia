package appalachia.world.gen.feature.tree;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Cocos Nucifera (Coconut Palm)
 */
public class TreeCocosNucifera extends AppalachiaTree {

    private static int leavesLength = 133;
    private static int[] leaves = new int[]{
        1, 0, 0,
        2, 0, 0,
        3, -1, 0,
        3, -2, 0,
        -1, 0, 0,
        -2, 0, 0,
        -3, -1, 0,
        -3, -2, 0,
        0, 0, 1,
        0, 0, 2,
        0, -1, 3,
        0, -2, 3,
        0, 0, -1,
        0, 0, -2,
        0, -1, -3,
        0, -2, -3,
        0, 1, 0,
        1, 1, 1,
        -1, 1, -1,
        -1, 1, 1,
        1, 1, -1,
        1, 2, 0,
        -1, 2, 0,
        0, 2, 1,
        0, 2, -1,
        2, 3, 0,
        3, 3, 0,
        4, 2, 0,
        -2, 3, 0,
        -3, 3, 0,
        -4, 2, 0,
        0, 3, 2,
        0, 3, 3,
        0, 2, 4,
        0, 3, -2,
        0, 3, -3,
        0, 2, -4,
        2, 2, -2,
        -2, 2, 2,
        -2, 2, -2,
        2, 2, 2,
        3, 2, -3,
        -3, 2, 3,
        -3, 2, -3,
        3, 2, 3
    };

    private static int cocoasLength = 16;
    private static int[] cocoas = new int[]{
        2, 0, -2, 1,
        1, 1, -2, 0,
        0, 0, -2, -1,
        3, -1, -2, 0
    };

    public TreeCocosNucifera() {

        super();

        this.logBlock = Blocks.LOG.getStateFromMeta(3);
        this.leavesBlock = Blocks.LEAVES.getStateFromMeta(3);
        this.trunkSize = 8;
        this.crownSize = 7;
    }

    @Override
    public boolean generate(World world, Random rand, BlockPos pos) {

        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        IBlockState b = world.getBlockState(new BlockPos(x, y - 1, z));
        boolean validGroundBlock = false;

        for (int i = 0; i < this.validGroundBlocks.size(); i++) {
            if (b == this.validGroundBlocks.get(i)) {
                validGroundBlock = true;
                break;
            }
        }

        if (!validGroundBlock) {
            return false;
        }

        double horDir = getRandomDir(rand);
        float verDir = 0.3f + rand.nextFloat() * 0.4f;
        float length = (float) (this.trunkSize + this.crownSize);
        float posX = (float) x;
        float posY = (float) y;
        float posZ = (float) z;
        float c = 0f;
        float loss = 0f;

        if (verDir < 0f) {
            verDir = -verDir;
        }

        float velY = 1f - verDir;

        if (verDir > 1f) {
            verDir = 1f - (verDir - 1f);
        }

        float velX = (float) Math.cos(horDir * Math.PI / 180D) * verDir;
        float velZ = (float) Math.sin(horDir * Math.PI / 180D) * verDir;

        while (c < length) {
            // TODO: this.logMeta + 12 (meta)
            world.setBlockState(new BlockPos((int) posX, (int) posY, (int) posZ), this.logBlock, this.generateFlag);

            if (c < length - 3) {
                loss = Math.abs(velX) + Math.abs(velZ);
                posX += velX *= 0.9f;
                posZ += velZ *= 0.9f;
                loss = loss - (Math.abs(velX) + Math.abs(velZ));
                posY += velY += loss;
            }
            else {
                posY += velY;
            }

            c += 1f;
        }

        x = (int) posX;
        y = (int) posY - 1;
        z = (int) posZ;

        if (!this.noLeaves) {

            for (int j = 0; j < leavesLength; j += 3) {
                world.setBlockState(new BlockPos(x + leaves[j], y + leaves[j + 1], z + leaves[j + 2]), this.leavesBlock, this.generateFlag);
            }
        }

        for (int k = 0; k < cocoasLength; k += 4) {
            if (rand.nextInt(20) == 0) {
                //TODO: cocoas[k + 0] + 8 (meta)
                world.setBlockState(new BlockPos(x + cocoas[k + 1], y + cocoas[k + 2], z + cocoas[k + 3]), Blocks.COCOA.getDefaultState(), this.generateFlag);
            }
        }

        return true;
    }

    public double getRandomDir(Random rand) {

        switch (rand.nextInt(4)) {
            case 0:
                return -180D;
            case 1:
                return -90D;
            case 2:
                return 0D;
            case 3:
                return 90D;
        }
        return 0D;
    }
}
