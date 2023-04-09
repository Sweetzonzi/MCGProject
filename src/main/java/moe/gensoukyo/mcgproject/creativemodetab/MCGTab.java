package moe.gensoukyo.mcgproject.creativemodetab;

import moe.gensoukyo.mcgproject.block.MCGNatureBlocks;
import moe.gensoukyo.mcgproject.item.MCGPropItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class MCGTab {
    public static final CreativeModeTab MCG_NATURE = new CreativeModeTab("mcg_nature") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(MCGNatureBlocks.IVY.get());
        }
    };
    public static final CreativeModeTab MCG_PROP = new CreativeModeTab("mcg_prop") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(MCGPropItems.TESTER.get());
        }
    };
}
