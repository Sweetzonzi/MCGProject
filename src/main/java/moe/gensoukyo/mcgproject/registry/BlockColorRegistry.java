package moe.gensoukyo.mcgproject.registry;

import moe.gensoukyo.mcgproject.block.MCGNatureBlocks;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@OnlyIn(Dist.CLIENT)
public class BlockColorRegistry {//用来处理方块染色，如跟着生物群系走的水、草颜色
    @SubscribeEvent
    public static BlockColors blockColorHandle(ColorHandlerEvent.Block event){
        BlockColors blockcolors = event.getBlockColors();//拿blockcolors实例？
        blockcolors.register((p_92621_, pLevel, pBlockPos, p_92624_) -> {
            return pLevel != null && pBlockPos != null ? BiomeColors.getAverageWaterColor(pLevel, pBlockPos) : -1;
        }, MCGNatureBlocks.WATER_FARMLAND.get());
        return blockcolors;
    }
}
