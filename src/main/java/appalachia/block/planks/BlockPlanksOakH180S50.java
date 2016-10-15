package appalachia.block.planks;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

import appalachia.api.AppalachiaBlocks;
import appalachia.block.IAppalachiaBlock;

public class BlockPlanksOakH180S50 extends AppalachiaBlockPlanks implements IAppalachiaBlock {

    public BlockPlanksOakH180S50() {

        super("planks.oak.180.50");
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {

        return Item.getItemFromBlock(state.getValue(DOUBLE).booleanValue() ? AppalachiaBlocks.slab_oak_180_50 : this);
    }

    @Override
    public String registryName() {

        return super.registryName();
    }
}