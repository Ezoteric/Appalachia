package appalachia.block.fencegates;

import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.SoundType;

import appalachia.block.IAppalachiaBlock;
import appalachia.gui.AppalachiaTabs;

public class AppalachiaBlockFenceGate extends BlockFenceGate implements IAppalachiaBlock {

    private String slug;

    public AppalachiaBlockFenceGate(String unlocalizedName) {

        super(BlockPlanks.EnumType.BIRCH);
        this.setUnlocalizedName(unlocalizedName);
        this.setHardness(1.75F);
        this.setResistance(4.75F);
        this.setSoundType(SoundType.WOOD);
        this.setHarvestLevel("axe", 0);
        this.setCreativeTab(AppalachiaTabs.tabBlock);
        this.slug = unlocalizedName;
    }

    @Override
    public String registryName() {

        return String.join("_", this.slug.split("\\."));
    }
}