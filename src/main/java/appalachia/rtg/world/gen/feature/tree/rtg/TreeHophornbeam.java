package appalachia.rtg.world.gen.feature.tree.rtg;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import appalachia.api.AppalachiaBlocks;
import appalachia.util.TreeLayer;

/**
 * Ostrya Virginiana (Hophornbeam)
 * <p>
 * This tree was designed by Lentebriesje and released as part of the 'Custom Tree Repository' project
 * on Planet Minecraft (http://www.planetminecraft.com/project/native-trees-of-europe-template-repository-1779952/).
 * It was converted into Java from its original schematic using the 'Schematic To Java Converter [For Modders]' program
 * by ThisIsMika (http://www.minecraftforum.net/forums/mapping-and-modding/minecraft-tools/2193206-schematic-to-java-converter-for-modders).
 * It has been modified slightly by WhichOnesPink to allow for random variation when generating in the world.
 */
public class TreeHophornbeam extends AppalachiaTree {

    public TreeHophornbeam() {
        super();
        this.setLogBlock(AppalachiaBlocks.log_hophornbeam_01.getDefaultState());
        this.setLeavesBlock(AppalachiaBlocks.leaves_hophornbeam_01.getDefaultState());
        this.setFallenLeavesBlock(AppalachiaBlocks.leaves_hophornbeam_01_fallen.getDefaultState());
        this.setSaplingBlock(AppalachiaBlocks.sapling_hophornbeam_01.getDefaultState());

        this.firstBlockOffsetX = 7;
        this.firstBlockOffsetZ = 8;
    }

    @Override
    public boolean generate(World world, Random rand, BlockPos pos) {
        this.init(world, rand, pos);
        this.buildTree(world, pos.getX(), pos.getY() - this.rootDepth(), pos.getZ(), this.logBlock, this.leavesBlock);
        this.generateTreeFromLayers(this.logBlock, this.leavesBlock);
        return true;
    }

    @Override
    public int rootDepth() {
        return 0;
    }

    @Override
    public int opaqueLeavesChance() {
        return 2;
    }

    protected void buildTree(World world, int x, int y, int z, IBlockState log, IBlockState leaves) {

        int currentY = y - 1;

        this.addTreeLayer((new TreeLayer(++currentY))
            .setLogs(
                new BlockPos(x+7, y+0, z+8)
            )
        );

        this.addTreeLayer((new TreeLayer(++currentY))
            .setLogs(
                new BlockPos(x+7, y+1, z+8)
            )
        );

        this.addTreeLayer((new TreeLayer(++currentY))
            .setLogs(
                new BlockPos(x+7, y+2, z+8)
            )
            .setLeaves(
                new BlockPos(x+9, y+2, z+3),
                new BlockPos(x+3, y+2, z+4),
                new BlockPos(x+4, y+2, z+4),
                new BlockPos(x+7, y+2, z+4),
                new BlockPos(x+9, y+2, z+4),
                new BlockPos(x+11, y+2, z+4),
                new BlockPos(x+10, y+2, z+5),
                new BlockPos(x+13, y+2, z+5),
                new BlockPos(x+2, y+2, z+6),
                new BlockPos(x+3, y+2, z+6),
                new BlockPos(x+4, y+2, z+6),
                new BlockPos(x+11, y+2, z+6),
                new BlockPos(x+12, y+2, z+6),
                new BlockPos(x+6, y+2, z+7),
                new BlockPos(x+7, y+2, z+7),
                new BlockPos(x+8, y+2, z+7),
                new BlockPos(x+9, y+2, z+7),
                new BlockPos(x+10, y+2, z+7),
                new BlockPos(x+3, y+2, z+8),
                new BlockPos(x+3, y+2, z+11),
                new BlockPos(x+4, y+2, z+11),
                new BlockPos(x+3, y+2, z+12),
                new BlockPos(x+8, y+2, z+12),
                new BlockPos(x+6, y+2, z+13),
                new BlockPos(x+6, y+2, z+14),
                new BlockPos(x+7, y+2, z+14)
            )
        );

        this.addTreeLayer((new TreeLayer(++currentY))
            .setLogs(
                new BlockPos(x+7, y+3, z+7),
                new BlockPos(x+7, y+3, z+8),
                new BlockPos(x+6, y+3, z+9)
            )
            .setLeaves(
                new BlockPos(x+8, y+3, z+0),
                new BlockPos(x+9, y+3, z+0),
                new BlockPos(x+7, y+3, z+1),
                new BlockPos(x+10, y+3, z+1),
                new BlockPos(x+7, y+3, z+2),
                new BlockPos(x+5, y+3, z+3),
                new BlockPos(x+6, y+3, z+3),
                new BlockPos(x+9, y+3, z+3),
                new BlockPos(x+12, y+3, z+3),
                new BlockPos(x+6, y+3, z+4),
                new BlockPos(x+3, y+3, z+5),
                new BlockPos(x+4, y+3, z+5),
                new BlockPos(x+5, y+3, z+5),
                new BlockPos(x+6, y+3, z+5),
                new BlockPos(x+7, y+3, z+5),
                new BlockPos(x+12, y+3, z+5),
                new BlockPos(x+1, y+3, z+6),
                new BlockPos(x+6, y+3, z+6),
                new BlockPos(x+7, y+3, z+6),
                new BlockPos(x+8, y+3, z+6),
                new BlockPos(x+9, y+3, z+6),
                new BlockPos(x+10, y+3, z+6),
                new BlockPos(x+2, y+3, z+7),
                new BlockPos(x+5, y+3, z+7),
                new BlockPos(x+8, y+3, z+7),
                new BlockPos(x+9, y+3, z+7),
                new BlockPos(x+10, y+3, z+7),
                new BlockPos(x+12, y+3, z+7),
                new BlockPos(x+13, y+3, z+7),
                new BlockPos(x+1, y+3, z+8),
                new BlockPos(x+5, y+3, z+8),
                new BlockPos(x+6, y+3, z+8),
                new BlockPos(x+8, y+3, z+8),
                new BlockPos(x+9, y+3, z+8),
                new BlockPos(x+5, y+3, z+9),
                new BlockPos(x+8, y+3, z+9),
                new BlockPos(x+9, y+3, z+9),
                new BlockPos(x+1, y+3, z+10),
                new BlockPos(x+5, y+3, z+10),
                new BlockPos(x+7, y+3, z+10),
                new BlockPos(x+10, y+3, z+10),
                new BlockPos(x+2, y+3, z+11),
                new BlockPos(x+5, y+3, z+11),
                new BlockPos(x+6, y+3, z+11),
                new BlockPos(x+11, y+3, z+11),
                new BlockPos(x+6, y+3, z+12),
                new BlockPos(x+5, y+3, z+13),
                new BlockPos(x+6, y+3, z+13),
                new BlockPos(x+8, y+3, z+13),
                new BlockPos(x+9, y+3, z+13),
                new BlockPos(x+6, y+3, z+14),
                new BlockPos(x+7, y+3, z+14)
            )
        );

        this.addTreeLayer((new TreeLayer(++currentY))
            .setLogs(
                new BlockPos(x+7, y+4, z+6),
                new BlockPos(x+7, y+4, z+8),
                new BlockPos(x+8, y+4, z+9),
                new BlockPos(x+5, y+4, z+10)
            )
            .setLeaves(
                new BlockPos(x+10, y+4, z+0),
                new BlockPos(x+5, y+4, z+1),
                new BlockPos(x+6, y+4, z+1),
                new BlockPos(x+7, y+4, z+1),
                new BlockPos(x+9, y+4, z+1),
                new BlockPos(x+3, y+4, z+2),
                new BlockPos(x+7, y+4, z+2),
                new BlockPos(x+8, y+4, z+2),
                new BlockPos(x+12, y+4, z+2),
                new BlockPos(x+2, y+4, z+3),
                new BlockPos(x+6, y+4, z+3),
                new BlockPos(x+9, y+4, z+3),
                new BlockPos(x+10, y+4, z+3),
                new BlockPos(x+11, y+4, z+3),
                new BlockPos(x+3, y+4, z+4),
                new BlockPos(x+5, y+4, z+4),
                new BlockPos(x+6, y+4, z+4),
                new BlockPos(x+7, y+4, z+4),
                new BlockPos(x+11, y+4, z+4),
                new BlockPos(x+12, y+4, z+4),
                new BlockPos(x+3, y+4, z+5),
                new BlockPos(x+5, y+4, z+5),
                new BlockPos(x+6, y+4, z+5),
                new BlockPos(x+7, y+4, z+5),
                new BlockPos(x+8, y+4, z+5),
                new BlockPos(x+9, y+4, z+5),
                new BlockPos(x+11, y+4, z+5),
                new BlockPos(x+13, y+4, z+5),
                new BlockPos(x+3, y+4, z+6),
                new BlockPos(x+4, y+4, z+6),
                new BlockPos(x+6, y+4, z+6),
                new BlockPos(x+9, y+4, z+6),
                new BlockPos(x+10, y+4, z+6),
                new BlockPos(x+11, y+4, z+6),
                new BlockPos(x+1, y+4, z+7),
                new BlockPos(x+5, y+4, z+7),
                new BlockPos(x+7, y+4, z+7),
                new BlockPos(x+10, y+4, z+7),
                new BlockPos(x+11, y+4, z+7),
                new BlockPos(x+13, y+4, z+7),
                new BlockPos(x+0, y+4, z+8),
                new BlockPos(x+1, y+4, z+8),
                new BlockPos(x+3, y+4, z+8),
                new BlockPos(x+6, y+4, z+8),
                new BlockPos(x+8, y+4, z+8),
                new BlockPos(x+10, y+4, z+8),
                new BlockPos(x+14, y+4, z+8),
                new BlockPos(x+2, y+4, z+9),
                new BlockPos(x+5, y+4, z+9),
                new BlockPos(x+6, y+4, z+9),
                new BlockPos(x+7, y+4, z+9),
                new BlockPos(x+9, y+4, z+9),
                new BlockPos(x+13, y+4, z+9),
                new BlockPos(x+3, y+4, z+10),
                new BlockPos(x+6, y+4, z+10),
                new BlockPos(x+7, y+4, z+10),
                new BlockPos(x+9, y+4, z+10),
                new BlockPos(x+10, y+4, z+10),
                new BlockPos(x+12, y+4, z+10),
                new BlockPos(x+2, y+4, z+11),
                new BlockPos(x+3, y+4, z+11),
                new BlockPos(x+4, y+4, z+11),
                new BlockPos(x+7, y+4, z+11),
                new BlockPos(x+9, y+4, z+11),
                new BlockPos(x+10, y+4, z+11),
                new BlockPos(x+2, y+4, z+12),
                new BlockPos(x+3, y+4, z+12),
                new BlockPos(x+4, y+4, z+12),
                new BlockPos(x+6, y+4, z+12),
                new BlockPos(x+4, y+4, z+13),
                new BlockPos(x+6, y+4, z+14),
                new BlockPos(x+9, y+4, z+14),
                new BlockPos(x+6, y+4, z+15)
            )
        );

        this.addTreeLayer((new TreeLayer(++currentY))
            .setLogs(
                new BlockPos(x+6, y+5, z+5),
                new BlockPos(x+7, y+5, z+8),
                new BlockPos(x+9, y+5, z+10),
                new BlockPos(x+4, y+5, z+11)
            )
            .setLeaves(
                new BlockPos(x+5, y+5, z+1),
                new BlockPos(x+9, y+5, z+1),
                new BlockPos(x+11, y+5, z+1),
                new BlockPos(x+6, y+5, z+2),
                new BlockPos(x+7, y+5, z+2),
                new BlockPos(x+9, y+5, z+2),
                new BlockPos(x+11, y+5, z+2),
                new BlockPos(x+1, y+5, z+3),
                new BlockPos(x+3, y+5, z+3),
                new BlockPos(x+4, y+5, z+3),
                new BlockPos(x+5, y+5, z+3),
                new BlockPos(x+6, y+5, z+3),
                new BlockPos(x+8, y+5, z+3),
                new BlockPos(x+4, y+5, z+4),
                new BlockPos(x+5, y+5, z+4),
                new BlockPos(x+6, y+5, z+4),
                new BlockPos(x+7, y+5, z+4),
                new BlockPos(x+8, y+5, z+4),
                new BlockPos(x+0, y+5, z+5),
                new BlockPos(x+1, y+5, z+5),
                new BlockPos(x+2, y+5, z+5),
                new BlockPos(x+3, y+5, z+5),
                new BlockPos(x+4, y+5, z+5),
                new BlockPos(x+8, y+5, z+5),
                new BlockPos(x+9, y+5, z+5),
                new BlockPos(x+10, y+5, z+5),
                new BlockPos(x+1, y+5, z+6),
                new BlockPos(x+2, y+5, z+6),
                new BlockPos(x+4, y+5, z+6),
                new BlockPos(x+5, y+5, z+6),
                new BlockPos(x+6, y+5, z+6),
                new BlockPos(x+7, y+5, z+6),
                new BlockPos(x+8, y+5, z+6),
                new BlockPos(x+9, y+5, z+6),
                new BlockPos(x+10, y+5, z+6),
                new BlockPos(x+14, y+5, z+6),
                new BlockPos(x+3, y+5, z+7),
                new BlockPos(x+4, y+5, z+7),
                new BlockPos(x+5, y+5, z+7),
                new BlockPos(x+7, y+5, z+7),
                new BlockPos(x+8, y+5, z+7),
                new BlockPos(x+9, y+5, z+7),
                new BlockPos(x+11, y+5, z+7),
                new BlockPos(x+0, y+5, z+8),
                new BlockPos(x+1, y+5, z+8),
                new BlockPos(x+2, y+5, z+8),
                new BlockPos(x+3, y+5, z+8),
                new BlockPos(x+4, y+5, z+8),
                new BlockPos(x+5, y+5, z+8),
                new BlockPos(x+6, y+5, z+8),
                new BlockPos(x+8, y+5, z+8),
                new BlockPos(x+9, y+5, z+8),
                new BlockPos(x+10, y+5, z+8),
                new BlockPos(x+11, y+5, z+8),
                new BlockPos(x+4, y+5, z+9),
                new BlockPos(x+5, y+5, z+9),
                new BlockPos(x+6, y+5, z+9),
                new BlockPos(x+7, y+5, z+9),
                new BlockPos(x+8, y+5, z+9),
                new BlockPos(x+9, y+5, z+9),
                new BlockPos(x+10, y+5, z+9),
                new BlockPos(x+1, y+5, z+10),
                new BlockPos(x+4, y+5, z+10),
                new BlockPos(x+5, y+5, z+10),
                new BlockPos(x+6, y+5, z+10),
                new BlockPos(x+7, y+5, z+10),
                new BlockPos(x+10, y+5, z+10),
                new BlockPos(x+3, y+5, z+11),
                new BlockPos(x+5, y+5, z+11),
                new BlockPos(x+6, y+5, z+11),
                new BlockPos(x+7, y+5, z+11),
                new BlockPos(x+8, y+5, z+11),
                new BlockPos(x+9, y+5, z+11),
                new BlockPos(x+10, y+5, z+11),
                new BlockPos(x+12, y+5, z+11),
                new BlockPos(x+2, y+5, z+12),
                new BlockPos(x+4, y+5, z+12),
                new BlockPos(x+5, y+5, z+12),
                new BlockPos(x+6, y+5, z+12),
                new BlockPos(x+7, y+5, z+12),
                new BlockPos(x+8, y+5, z+12),
                new BlockPos(x+10, y+5, z+12),
                new BlockPos(x+5, y+5, z+13),
                new BlockPos(x+6, y+5, z+13),
                new BlockPos(x+7, y+5, z+13),
                new BlockPos(x+8, y+5, z+13),
                new BlockPos(x+9, y+5, z+13),
                new BlockPos(x+10, y+5, z+13),
                new BlockPos(x+11, y+5, z+13),
                new BlockPos(x+12, y+5, z+13),
                new BlockPos(x+3, y+5, z+14),
                new BlockPos(x+4, y+5, z+14),
                new BlockPos(x+5, y+5, z+14),
                new BlockPos(x+8, y+5, z+14),
                new BlockPos(x+10, y+5, z+14),
                new BlockPos(x+6, y+5, z+15),
                new BlockPos(x+7, y+5, z+15),
                new BlockPos(x+8, y+5, z+15),
                new BlockPos(x+6, y+5, z+16)
            )
        );

        this.addTreeLayer((new TreeLayer(++currentY))
            .setLogs(
                new BlockPos(x+5, y+6, z+4),
                new BlockPos(x+7, y+6, z+8),
                new BlockPos(x+10, y+6, z+11)
            )
            .setLeaves(
                new BlockPos(x+5, y+6, z+1),
                new BlockPos(x+6, y+6, z+1),
                new BlockPos(x+3, y+6, z+2),
                new BlockPos(x+5, y+6, z+2),
                new BlockPos(x+6, y+6, z+2),
                new BlockPos(x+7, y+6, z+2),
                new BlockPos(x+9, y+6, z+2),
                new BlockPos(x+3, y+6, z+3),
                new BlockPos(x+8, y+6, z+3),
                new BlockPos(x+0, y+6, z+4),
                new BlockPos(x+1, y+6, z+4),
                new BlockPos(x+2, y+6, z+4),
                new BlockPos(x+3, y+6, z+4),
                new BlockPos(x+4, y+6, z+4),
                new BlockPos(x+6, y+6, z+4),
                new BlockPos(x+7, y+6, z+4),
                new BlockPos(x+8, y+6, z+4),
                new BlockPos(x+9, y+6, z+4),
                new BlockPos(x+2, y+6, z+5),
                new BlockPos(x+3, y+6, z+5),
                new BlockPos(x+4, y+6, z+5),
                new BlockPos(x+5, y+6, z+5),
                new BlockPos(x+6, y+6, z+5),
                new BlockPos(x+7, y+6, z+5),
                new BlockPos(x+8, y+6, z+5),
                new BlockPos(x+11, y+6, z+5),
                new BlockPos(x+2, y+6, z+6),
                new BlockPos(x+3, y+6, z+6),
                new BlockPos(x+4, y+6, z+6),
                new BlockPos(x+5, y+6, z+6),
                new BlockPos(x+6, y+6, z+6),
                new BlockPos(x+8, y+6, z+6),
                new BlockPos(x+9, y+6, z+6),
                new BlockPos(x+11, y+6, z+6),
                new BlockPos(x+3, y+6, z+7),
                new BlockPos(x+4, y+6, z+7),
                new BlockPos(x+5, y+6, z+7),
                new BlockPos(x+6, y+6, z+7),
                new BlockPos(x+7, y+6, z+7),
                new BlockPos(x+8, y+6, z+7),
                new BlockPos(x+9, y+6, z+7),
                new BlockPos(x+10, y+6, z+7),
                new BlockPos(x+11, y+6, z+7),
                new BlockPos(x+13, y+6, z+7),
                new BlockPos(x+4, y+6, z+8),
                new BlockPos(x+5, y+6, z+8),
                new BlockPos(x+6, y+6, z+8),
                new BlockPos(x+8, y+6, z+8),
                new BlockPos(x+9, y+6, z+8),
                new BlockPos(x+10, y+6, z+8),
                new BlockPos(x+11, y+6, z+8),
                new BlockPos(x+4, y+6, z+9),
                new BlockPos(x+5, y+6, z+9),
                new BlockPos(x+6, y+6, z+9),
                new BlockPos(x+7, y+6, z+9),
                new BlockPos(x+8, y+6, z+9),
                new BlockPos(x+9, y+6, z+9),
                new BlockPos(x+10, y+6, z+9),
                new BlockPos(x+11, y+6, z+9),
                new BlockPos(x+12, y+6, z+9),
                new BlockPos(x+3, y+6, z+10),
                new BlockPos(x+6, y+6, z+10),
                new BlockPos(x+7, y+6, z+10),
                new BlockPos(x+8, y+6, z+10),
                new BlockPos(x+10, y+6, z+10),
                new BlockPos(x+11, y+6, z+10),
                new BlockPos(x+12, y+6, z+10),
                new BlockPos(x+13, y+6, z+10),
                new BlockPos(x+2, y+6, z+11),
                new BlockPos(x+5, y+6, z+11),
                new BlockPos(x+6, y+6, z+11),
                new BlockPos(x+7, y+6, z+11),
                new BlockPos(x+8, y+6, z+11),
                new BlockPos(x+9, y+6, z+11),
                new BlockPos(x+12, y+6, z+11),
                new BlockPos(x+1, y+6, z+12),
                new BlockPos(x+2, y+6, z+12),
                new BlockPos(x+3, y+6, z+12),
                new BlockPos(x+4, y+6, z+12),
                new BlockPos(x+7, y+6, z+12),
                new BlockPos(x+8, y+6, z+12),
                new BlockPos(x+10, y+6, z+12),
                new BlockPos(x+11, y+6, z+12),
                new BlockPos(x+4, y+6, z+13),
                new BlockPos(x+8, y+6, z+13),
                new BlockPos(x+9, y+6, z+13),
                new BlockPos(x+3, y+6, z+14),
                new BlockPos(x+5, y+6, z+14),
                new BlockPos(x+9, y+6, z+14),
                new BlockPos(x+11, y+6, z+14),
                new BlockPos(x+5, y+6, z+15)
            )
        );

        this.addTreeLayer((new TreeLayer(++currentY))
            .setLeaves(
                new BlockPos(x+5, y+7, z+1),
                new BlockPos(x+9, y+7, z+2),
                new BlockPos(x+0, y+7, z+3),
                new BlockPos(x+5, y+7, z+3),
                new BlockPos(x+7, y+7, z+3),
                new BlockPos(x+8, y+7, z+3),
                new BlockPos(x+3, y+7, z+4),
                new BlockPos(x+4, y+7, z+4),
                new BlockPos(x+6, y+7, z+4),
                new BlockPos(x+2, y+7, z+5),
                new BlockPos(x+3, y+7, z+5),
                new BlockPos(x+5, y+7, z+5),
                new BlockPos(x+7, y+7, z+5),
                new BlockPos(x+8, y+7, z+5),
                new BlockPos(x+1, y+7, z+6),
                new BlockPos(x+3, y+7, z+6),
                new BlockPos(x+4, y+7, z+6),
                new BlockPos(x+5, y+7, z+6),
                new BlockPos(x+6, y+7, z+6),
                new BlockPos(x+7, y+7, z+6),
                new BlockPos(x+8, y+7, z+6),
                new BlockPos(x+9, y+7, z+6),
                new BlockPos(x+2, y+7, z+7),
                new BlockPos(x+3, y+7, z+7),
                new BlockPos(x+4, y+7, z+7),
                new BlockPos(x+6, y+7, z+7),
                new BlockPos(x+7, y+7, z+7),
                new BlockPos(x+9, y+7, z+7),
                new BlockPos(x+4, y+7, z+8),
                new BlockPos(x+6, y+7, z+8),
                new BlockPos(x+7, y+7, z+8),
                new BlockPos(x+8, y+7, z+8),
                new BlockPos(x+10, y+7, z+8),
                new BlockPos(x+2, y+7, z+9),
                new BlockPos(x+4, y+7, z+9),
                new BlockPos(x+5, y+7, z+9),
                new BlockPos(x+6, y+7, z+9),
                new BlockPos(x+7, y+7, z+9),
                new BlockPos(x+8, y+7, z+9),
                new BlockPos(x+3, y+7, z+10),
                new BlockPos(x+5, y+7, z+10),
                new BlockPos(x+6, y+7, z+10),
                new BlockPos(x+7, y+7, z+10),
                new BlockPos(x+8, y+7, z+10),
                new BlockPos(x+10, y+7, z+10),
                new BlockPos(x+4, y+7, z+11),
                new BlockPos(x+5, y+7, z+11),
                new BlockPos(x+6, y+7, z+11),
                new BlockPos(x+7, y+7, z+11),
                new BlockPos(x+8, y+7, z+11),
                new BlockPos(x+4, y+7, z+12),
                new BlockPos(x+5, y+7, z+12),
                new BlockPos(x+10, y+7, z+12),
                new BlockPos(x+4, y+7, z+13),
                new BlockPos(x+6, y+7, z+13),
                new BlockPos(x+9, y+7, z+13),
                new BlockPos(x+5, y+7, z+14),
                new BlockPos(x+6, y+7, z+14),
                new BlockPos(x+9, y+7, z+14),
                new BlockPos(x+11, y+7, z+14)
            )
        );

        this.addTreeLayer((new TreeLayer(++currentY))
            .setLeaves(
                new BlockPos(x+3, y+8, z+2),
                new BlockPos(x+6, y+8, z+2),
                new BlockPos(x+3, y+8, z+3),
                new BlockPos(x+5, y+8, z+3),
                new BlockPos(x+6, y+8, z+3),
                new BlockPos(x+7, y+8, z+4),
                new BlockPos(x+3, y+8, z+5),
                new BlockPos(x+4, y+8, z+5),
                new BlockPos(x+5, y+8, z+5),
                new BlockPos(x+6, y+8, z+5),
                new BlockPos(x+1, y+8, z+6),
                new BlockPos(x+3, y+8, z+6),
                new BlockPos(x+4, y+8, z+6),
                new BlockPos(x+5, y+8, z+6),
                new BlockPos(x+6, y+8, z+6),
                new BlockPos(x+7, y+8, z+6),
                new BlockPos(x+8, y+8, z+6),
                new BlockPos(x+10, y+8, z+6),
                new BlockPos(x+2, y+8, z+7),
                new BlockPos(x+3, y+8, z+7),
                new BlockPos(x+4, y+8, z+7),
                new BlockPos(x+5, y+8, z+7),
                new BlockPos(x+7, y+8, z+7),
                new BlockPos(x+8, y+8, z+7),
                new BlockPos(x+9, y+8, z+7),
                new BlockPos(x+3, y+8, z+8),
                new BlockPos(x+4, y+8, z+8),
                new BlockPos(x+5, y+8, z+8),
                new BlockPos(x+6, y+8, z+8),
                new BlockPos(x+7, y+8, z+8),
                new BlockPos(x+8, y+8, z+8),
                new BlockPos(x+9, y+8, z+8),
                new BlockPos(x+2, y+8, z+9),
                new BlockPos(x+4, y+8, z+9),
                new BlockPos(x+5, y+8, z+9),
                new BlockPos(x+6, y+8, z+9),
                new BlockPos(x+7, y+8, z+9),
                new BlockPos(x+8, y+8, z+9),
                new BlockPos(x+2, y+8, z+10),
                new BlockPos(x+4, y+8, z+10),
                new BlockPos(x+6, y+8, z+10),
                new BlockPos(x+7, y+8, z+10),
                new BlockPos(x+8, y+8, z+10),
                new BlockPos(x+3, y+8, z+11),
                new BlockPos(x+4, y+8, z+11),
                new BlockPos(x+5, y+8, z+11),
                new BlockPos(x+6, y+8, z+11),
                new BlockPos(x+9, y+8, z+11),
                new BlockPos(x+4, y+8, z+12),
                new BlockPos(x+10, y+8, z+12),
                new BlockPos(x+6, y+8, z+13),
                new BlockPos(x+7, y+8, z+13),
                new BlockPos(x+7, y+8, z+14)
            )
        );

        this.addTreeLayer((new TreeLayer(++currentY))
            .setLeaves(
                new BlockPos(x+5, y+9, z+3),
                new BlockPos(x+6, y+9, z+3),
                new BlockPos(x+7, y+9, z+5),
                new BlockPos(x+5, y+9, z+6),
                new BlockPos(x+6, y+9, z+6),
                new BlockPos(x+7, y+9, z+6),
                new BlockPos(x+9, y+9, z+6),
                new BlockPos(x+4, y+9, z+7),
                new BlockPos(x+5, y+9, z+7),
                new BlockPos(x+7, y+9, z+7),
                new BlockPos(x+10, y+9, z+7),
                new BlockPos(x+4, y+9, z+8),
                new BlockPos(x+5, y+9, z+8),
                new BlockPos(x+6, y+9, z+8),
                new BlockPos(x+7, y+9, z+8),
                new BlockPos(x+8, y+9, z+8),
                new BlockPos(x+2, y+9, z+9),
                new BlockPos(x+3, y+9, z+9),
                new BlockPos(x+4, y+9, z+9),
                new BlockPos(x+5, y+9, z+9),
                new BlockPos(x+6, y+9, z+9),
                new BlockPos(x+7, y+9, z+9),
                new BlockPos(x+9, y+9, z+9),
                new BlockPos(x+1, y+9, z+10),
                new BlockPos(x+4, y+9, z+10),
                new BlockPos(x+6, y+9, z+10),
                new BlockPos(x+8, y+9, z+10),
                new BlockPos(x+10, y+9, z+10),
                new BlockPos(x+11, y+9, z+10),
                new BlockPos(x+6, y+9, z+11),
                new BlockPos(x+10, y+9, z+11),
                new BlockPos(x+11, y+9, z+11),
                new BlockPos(x+4, y+9, z+12),
                new BlockPos(x+5, y+9, z+12),
                new BlockPos(x+10, y+9, z+12)
            )
        );

        this.addTreeLayer((new TreeLayer(++currentY))
            .setLeaves(
                new BlockPos(x+7, y+10, z+5),
                new BlockPos(x+4, y+10, z+6),
                new BlockPos(x+5, y+10, z+6),
                new BlockPos(x+6, y+10, z+6),
                new BlockPos(x+7, y+10, z+6),
                new BlockPos(x+2, y+10, z+7),
                new BlockPos(x+5, y+10, z+7),
                new BlockPos(x+2, y+10, z+8),
                new BlockPos(x+3, y+10, z+8),
                new BlockPos(x+4, y+10, z+8),
                new BlockPos(x+6, y+10, z+8),
                new BlockPos(x+7, y+10, z+8),
                new BlockPos(x+10, y+10, z+8),
                new BlockPos(x+3, y+10, z+9),
                new BlockPos(x+4, y+10, z+9),
                new BlockPos(x+5, y+10, z+9),
                new BlockPos(x+7, y+10, z+10),
                new BlockPos(x+8, y+10, z+10),
                new BlockPos(x+9, y+10, z+10),
                new BlockPos(x+7, y+10, z+11)
            )
        );

        this.addTreeLayer((new TreeLayer(++currentY))
            .setLeaves(
                new BlockPos(x+6, y+11, z+6),
                new BlockPos(x+7, y+11, z+6),
                new BlockPos(x+6, y+11, z+7),
                new BlockPos(x+7, y+11, z+7),
                new BlockPos(x+6, y+11, z+8),
                new BlockPos(x+5, y+11, z+9),
                new BlockPos(x+6, y+11, z+9),
                new BlockPos(x+8, y+11, z+9),
                new BlockPos(x+5, y+11, z+10),
                new BlockPos(x+7, y+11, z+10)
            )
        );

        this.addTreeLayer((new TreeLayer(++currentY))
            .setLeaves(
                new BlockPos(x+7, y+12, z+7),
                new BlockPos(x+5, y+12, z+8),
                new BlockPos(x+6, y+12, z+8)
            )
        );
    }
}
