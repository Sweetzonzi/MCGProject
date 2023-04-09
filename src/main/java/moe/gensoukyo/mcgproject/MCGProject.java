package moe.gensoukyo.mcgproject;

import com.mojang.logging.LogUtils;
import moe.gensoukyo.mcgproject.block.*;
import moe.gensoukyo.mcgproject.registry.*;
import moe.gensoukyo.mcgproject.item.MCGMaterialItems;
import moe.gensoukyo.mcgproject.item.MCGPropItems;
import net.minecraft.Util;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(MCGProject.MOD_ID)
@Mod.EventBusSubscriber
public class MCGProject {
    public final static String MOD_ID = "mcgproject";
    public static final Logger logger = LogUtils.getLogger();//log输出相关
    public MCGProject(){
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();//获取Mod总线
        IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;//获取Forge总线
        //加载mod新增物品和方块至内存
        MCGMaterialItems.preregister();
        MCGPropItems.preregister();
        MCGNatureBlocks.preregister();
        MCGStructureBlocks.preregister();
        //注册新增物品、方块和实体
        ItemRegistry.ITEMS.register(modEventBus);
        BlockRegistry.BLOCKS.register(modEventBus);
        EntityRegistry.ENTITIES.register(modEventBus);
        //为特定方块添加全透明/半透明效果
        modEventBus.addListener(RenderRegistry::registerBlockRender);
        //注册实体模型
        modEventBus.addListener(RenderRegistry::onRegisterLayers);
        //注册实体渲染器
        modEventBus.addListener(RenderRegistry::registerRenderers);
        //替换玩家模型
        forgeEventBus.addListener(RenderRegistry::registerPlayerRenderers);
        //为可变色方块定义染色逻辑
        modEventBus.addListener(BlockColorRegistry::blockColorHandle);

    }
    @SubscribeEvent
    public static void welcomeLogin(PlayerEvent.PlayerLoggedInEvent event){
         Player player = event.getPlayer();
        player.sendMessage(new TextComponent("登录后发一条消息给玩家"),Util.NIL_UUID);
    }
}
