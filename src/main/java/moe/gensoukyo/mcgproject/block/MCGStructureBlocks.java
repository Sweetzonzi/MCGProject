package moe.gensoukyo.mcgproject.block;

import moe.gensoukyo.mcgproject.creativemodetab.MCGTab;
import moe.gensoukyo.mcgproject.registry.BlockRegistry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.RegistryObject;

public class MCGStructureBlocks {
    public static void preregister(){}
    //方块----------------------------------------------------
    //海鼠壁
    public static final RegistryObject<Block> NAMAKO = BlockRegistry.registerBlock("namako",
            ()->new Block(BlockBehaviour.Properties.of(Material.STONE)), MCGTab.MCG_STRUCTURE);
    //榻榻米
    public static final RegistryObject<Block> TATAMI = BlockRegistry.registerBlock("tatami",
            ()->new Block(BlockBehaviour.Properties.of(Material.WOOL).sound(SoundType.WOOL)), MCGTab.MCG_STRUCTURE);
    //榻榻米(无边线)
    public static final RegistryObject<Block> TATAMI_NO_SIDE = BlockRegistry.registerBlock("tatami_no_side",
            ()->new Block(BlockBehaviour.Properties.of(Material.WOOL).sound(SoundType.WOOL)), MCGTab.MCG_STRUCTURE);
}
