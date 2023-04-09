package moe.gensoukyo.mcgproject.block;

import moe.gensoukyo.mcgproject.creativemodetab.MCGTab;
import moe.gensoukyo.mcgproject.registry.BlockRegistry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.RegistryObject;

public class MCGStructureBlocks {
    public static void preregister(){}
    //方块----------------------------------------------------
    //
    public static final RegistryObject<Block> ROCKX = BlockRegistry.registerBlock("rockx",
            ()->new Block(BlockBehaviour.Properties.of(Material.STONE).noCollission()), MCGTab.MCG_NATURE);
}
