package appalachia.item.slabs;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;

import appalachia.api.AppalachiaBlocks;
import appalachia.block.planks.BlockPlanksOakH20S160;

public class ItemSlabOakH20S160 extends AppalachiaItemSlab {

    public ItemSlabOakH20S160(Block block) {

        super(block);
    }

    @Override
    protected IBlockState getFullBlock() {

        return AppalachiaBlocks.planks_oak_20_160.getDefaultState().withProperty(BlockPlanksOakH20S160.DOUBLE, Boolean.valueOf(true));
    }
}