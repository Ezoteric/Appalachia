package appalachia.rtg.world.biome.deco.collection;

import net.minecraft.init.Blocks;

import appalachia.api.AppalachiaBlocks;
import appalachia.api.block.IAppalachiaBlockLeavesFallen;
import appalachia.block.leaves.AppalachiaBlockLeaves;
import appalachia.block.leaves.fallen.AppalachiaBlockLeavesFallen;
import appalachia.block.logs.AppalachiaBlockLog;
import appalachia.block.vines.AppalachiaBlockVine;
import appalachia.rtg.world.gen.feature.tree.rtg.*;

import rtg.api.config.BiomeConfig;
import rtg.api.world.deco.*;
import rtg.api.world.deco.collection.DecoCollectionBase;
import rtg.api.world.deco.helper.DecoHelper5050;


/**
 * @author WhichOnesPink
 * Balsam Fir, Sugar Maple, American Basswood, Yellow Birch, Red Spruce, Eastern Hemlock
 */
public class DecoCollectionAdirondackMountains extends DecoCollectionBase {

    protected static int treeMaxY = 220;
    protected static int shrubMaxY = 220;

    public DecoCollectionAdirondackMountains(BiomeConfig config) {

        super(config);

        // Balsam Fir.
        AppalachiaTree treeBalsamFir = new TreeBalsamFir();
        this.addTree(treeBalsamFir);
        DecoTree decoBalsamFir = new DecoTree(treeBalsamFir);
        decoBalsamFir.setMaxY(treeMaxY);
        this.addDeco(decoBalsamFir);

        // Sugar Maple.
        AppalachiaTree treeSugarMaple = new TreeSugarMaple();
        this.addTree(treeSugarMaple);
        DecoTree decoSugarMaple = new DecoTree(treeSugarMaple);
        decoSugarMaple.setMaxY(treeMaxY);
        this.addDeco(decoSugarMaple);

        // American Basswood.
        AppalachiaTree treeAmericanBasswood = new TreeAmericanBasswood();
        this.addTree(treeAmericanBasswood);
        DecoTree decoAmericanBasswood = new DecoTree(treeAmericanBasswood);
        decoAmericanBasswood.setMaxY(treeMaxY);
        this.addDeco(decoAmericanBasswood);

        // Yellow Birch.
        AppalachiaTree treeYellowBirch = new TreeYellowBirch();
        this.addTree(treeYellowBirch);
        DecoTree decoYellowBirch = new DecoTree(treeYellowBirch);
        decoYellowBirch.setMaxY(treeMaxY);
        this.addDeco(decoYellowBirch);

        // Red Spruce.
        AppalachiaTree treeRedSpruce = new TreeRedSpruce();
        this.addTree(treeRedSpruce);
        DecoTree decoRedSpruce = new DecoTree(treeRedSpruce);
        decoRedSpruce.setMaxY(treeMaxY);
        this.addDeco(decoRedSpruce);

        // Eastern Hemlock.
        AppalachiaTree treeEasternHemlock = new TreeEasternHemlock();
        this.addTree(treeEasternHemlock);
        DecoTree decoEasternHemlock = new DecoTree(treeEasternHemlock);
        decoEasternHemlock.setMaxY(treeMaxY);
        this.addDeco(decoEasternHemlock);

        // Add some fallen trees of the oak and spruce variety (50/50 distribution).
        DecoFallenTree decoFallenOak = new DecoFallenTree();
        decoFallenOak.setLogCondition(DecoFallenTree.LogCondition.RANDOM_CHANCE);
        decoFallenOak.setLogConditionChance(16);
        decoFallenOak.setMaxY(80);
        decoFallenOak.setLogBlock(AppalachiaBlockLog.getRandomLog().getDefaultState());
        decoFallenOak.setLeavesBlock(AppalachiaBlockLeaves.getRandomLeaves().getDefaultState());
        decoFallenOak.setMinSize(3);
        decoFallenOak.setMaxSize(6);
        DecoFallenTree decoFallenSpruce = new DecoFallenTree();
        decoFallenSpruce.setLogCondition(DecoFallenTree.LogCondition.RANDOM_CHANCE);
        decoFallenSpruce.setLogConditionChance(24);
        decoFallenSpruce.setMaxY(80);
        decoFallenSpruce.setLogBlock(AppalachiaBlockLog.getRandomLog().getDefaultState());
        decoFallenSpruce.setLeavesBlock(AppalachiaBlockLeaves.getRandomLeaves().getDefaultState());
        decoFallenSpruce.setMinSize(3);
        decoFallenSpruce.setMaxSize(6);
        DecoHelper5050 decoFallenTree = new DecoHelper5050(decoFallenOak, decoFallenSpruce);
        this.addDeco(decoFallenTree);

        // Shrubs to fill in the blanks.
        DecoShrub decoShrubOak = new DecoShrub();
        decoShrubOak.setSize(1);
        decoShrubOak.setMinY(64);
        decoShrubOak.setMaxY(shrubMaxY);
        decoShrubOak.setStrengthFactor(8f);
        decoShrubOak.setChance(2);
        this.addDeco(decoShrubOak);

        DecoBoulder decoBoulder1 = new DecoBoulder();
        decoBoulder1.setBoulderBlock(Blocks.COBBLESTONE.getDefaultState());
        decoBoulder1.setMaxY(80);
        decoBoulder1.setChance(16);
        decoBoulder1.setStrengthFactor(1f);
        this.addDeco(decoBoulder1);

        // Fallen leaves.
        DecoLayer decoFallenLeaves = new DecoLayer(AppalachiaBlockLeavesFallen.getRandomFallenLeaves().getDefaultState(), IAppalachiaBlockLeavesFallen.LAYERS);
        decoFallenLeaves.setLoops(8);
        this.addDeco(decoFallenLeaves);

        // Only 1-block-tall flowers so we can see the trees better.
        // And only white ones because they go with everything.
        DecoFlowersRTG decoFlowers1 = new DecoFlowersRTG();
        decoFlowers1.setFlowers(new int[]{3, 6});
        decoFlowers1.setMaxY(shrubMaxY);
        decoFlowers1.setStrengthFactor(6f);
        this.addDeco(decoFlowers1);

        // Very rare 2-block-tall flowers. (TODO: Replace these with Appalachian flora.)
        DecoFlowersRTG decoFlowers2 = new DecoFlowersRTG();
        decoFlowers2.setFlowers(new int[]{12, 13});
        decoFlowers2.setMinY(63);
        decoFlowers2.setMaxY(180);
        decoFlowers2.setLoops(3);
        this.addDeco(decoFlowers2);

        // Poison ivy.
        DecoVines decoPoisonIvy = new DecoVines();
        decoPoisonIvy.setVineBlock(AppalachiaBlocks.vine_poison_ivy_01);
        decoPoisonIvy.setStrengthFactor(12f);
        decoPoisonIvy.setPropNorth(AppalachiaBlockVine.NORTH);
        decoPoisonIvy.setPropEast(AppalachiaBlockVine.EAST);
        decoPoisonIvy.setPropSouth(AppalachiaBlockVine.SOUTH);
        decoPoisonIvy.setPropWest(AppalachiaBlockVine.WEST);
        this.addDeco(decoPoisonIvy);
    }
}
