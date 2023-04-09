package moe.gensoukyo.mcgproject.block;

import moe.gensoukyo.mcgproject.block.nature.IvyBlock;
import moe.gensoukyo.mcgproject.block.nature.WaterFarmBlock;
import moe.gensoukyo.mcgproject.creativemodetab.MCGTab;
import moe.gensoukyo.mcgproject.registry.BlockRegistry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.RegistryObject;

public class MCGNatureBlocks{
    public static void preregister(){}
    //方块----------------------------------------------------
    //爬山虎
    public static final RegistryObject<Block> IVY = BlockRegistry.registerBlock("ivy",
            ()->new IvyBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT).noCollission()), MCGTab.MCG_NATURE);
    //三叶草
    public static final RegistryObject<Block> CLOVER = BlockRegistry.registerBlock("clover",
            ()->new Block(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT).noCollission()), MCGTab.MCG_NATURE);
    //带四叶草三叶草
    public static final RegistryObject<Block> LUCKY_CLOVER = BlockRegistry.registerBlock("lucky_clover",
            ()->new Block(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT).noCollission()), MCGTab.MCG_NATURE);
    //水稻苗
    public static final RegistryObject<Block> PADDY = BlockRegistry.registerBlock("paddy",
            ()->new Block(BlockBehaviour.Properties.of(Material.PLANT).noCollission()), MCGTab.MCG_NATURE);
    //稀疏水稻苗
    public static final RegistryObject<Block> PADDY_SPARSE = BlockRegistry.registerBlock("paddy_sparse",
            ()->new Block(BlockBehaviour.Properties.of(Material.PLANT).noCollission()), MCGTab.MCG_NATURE);
    //密植水稻苗
    public static final RegistryObject<Block> PADDY_DENSE = BlockRegistry.registerBlock("paddy_dense",
            ()->new Block(BlockBehaviour.Properties.of(Material.PLANT).noCollission()), MCGTab.MCG_NATURE);
    //水田
    public static final RegistryObject<Block> WATER_FARMLAND = BlockRegistry.registerBlock("water_farmland",
            ()->new WaterFarmBlock(BlockBehaviour.Properties.of(Material.DIRT).randomTicks().strength(0.6F).sound(SoundType.GRAVEL)), MCGTab.MCG_NATURE);
}
