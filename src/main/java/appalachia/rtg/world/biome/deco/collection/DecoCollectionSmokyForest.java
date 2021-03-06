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
 * American Sweetgum, Loblolly Pine, Flowering Dogwood, Black Walnut, American Elm,
 * Sycamore, Persimmon, Blue Beech, River Birch, Shortleaf Pine
 */
public class DecoCollectionSmokyForest extends DecoCollectionBase {

    protected static int treeMaxY = 220;
    protected static int shrubMaxY = 220;

    public DecoCollectionSmokyForest(BiomeConfig config) {

        super(config);

        // American Sweetgum.
        AppalachiaTree treeAmericanSweetgum = new TreeAmericanSweetgum();
        this.addTree(treeAmericanSweetgum);
        DecoTree decoAmericanSweetgum = new DecoTree(treeAmericanSweetgum);
        decoAmericanSweetgum.setMaxY(treeMaxY);
        this.addDeco(decoAmericanSweetgum);

        // Loblolly Pine.
        AppalachiaTree treeLoblollyPine = new TreeLoblollyPine();
        this.addTree(treeLoblollyPine);
        DecoTree decoLoblollyPine = new DecoTree(treeLoblollyPine);
        decoLoblollyPine.setMaxY(treeMaxY);
        this.addDeco(decoLoblollyPine);

        // Flowering Dogwood.
        AppalachiaTree treeFloweringDogwood = new TreeFloweringDogwood();
        this.addTree(treeFloweringDogwood);
        DecoTree decoFloweringDogwood = new DecoTree(treeFloweringDogwood);
        decoFloweringDogwood.setMaxY(treeMaxY);
        this.addDeco(decoFloweringDogwood);

        // Black Walnut.
        AppalachiaTree treeBlackWalnut = new TreeBlackWalnut();
        this.addTree(treeBlackWalnut);
        DecoTree decoBlackWalnut = new DecoTree(treeBlackWalnut);
        decoBlackWalnut.setMaxY(treeMaxY);
        this.addDeco(decoBlackWalnut);

        // American Elm.
        AppalachiaTree treeAmericanElm = new TreeAmericanElm();
        this.addTree(treeAmericanElm);
        DecoTree decoAmericanElm = new DecoTree(treeAmericanElm);
        decoAmericanElm.setMaxY(treeMaxY);
        this.addDeco(decoAmericanElm);

        // Sycamore.
        AppalachiaTree treeSycamore = new TreeSycamore();
        this.addTree(treeSycamore);
        DecoTree decoSycamore = new DecoTree(treeSycamore);
        decoSycamore.setMaxY(treeMaxY);
        this.addDeco(decoSycamore);

        // Persimmon.
        AppalachiaTree treePersimmon = new TreePersimmon();
        this.addTree(treePersimmon);
        DecoTree decoPersimmon = new DecoTree(treePersimmon);
        decoPersimmon.setMaxY(treeMaxY);
        this.addDeco(decoPersimmon);

        // Blue Beech.
        AppalachiaTree treeBlueBeech = new TreeBlueBeech();
        this.addTree(treeBlueBeech);
        DecoTree decoBlueBeech = new DecoTree(treeBlueBeech);
        decoBlueBeech.setMaxY(treeMaxY);
        this.addDeco(decoBlueBeech);

        // River Birch.
        AppalachiaTree treeRiverBirch = new TreeRiverBirch();
        this.addTree(treeRiverBirch);
        DecoTree decoRiverBirch = new DecoTree(treeRiverBirch);
        decoRiverBirch.setMaxY(treeMaxY);
        this.addDeco(decoRiverBirch);

        // Shortleaf Pine.
        AppalachiaTree treeShortleafPine = new TreeShortleafPine();
        this.addTree(treeShortleafPine);
        DecoTree decoShortleafPine = new DecoTree(treeShortleafPine);
        decoShortleafPine.setMaxY(treeMaxY);
        this.addDeco(decoShortleafPine);

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
