/*
package moe.gensoukyo.mcgproject.registry;

import com.mojang.blaze3d.platform.InputConstants;
import moe.gensoukyo.mcgproject.MCGProject;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = MCGProject.MOD_ID, value = Dist.CLIENT)
public class HotKeyRegistry {

    //本地化用的键
    public static final String KEY_CATEGORIES_MCGPROJECT = "key.categories.mcgproject";
    public static final String KEY_LOCK_TARGET = "key.mcgproject.locktarget";

    public static KeyMapping lockTargetKeyMapping;

    public static void init() {
        lockTargetKeyMapping = new KeyMapping(KEY_LOCK_TARGET, KeyConflictContext.IN_GAME, InputConstants.getKey("key.keyboard.q"), KEY_CATEGORIES_MCGPROJECT);
        ClientRegistry.registerKeyBinding(lockTargetKeyMapping);
    }

    @SubscribeEvent
    public static void onKeyInput(InputEvent.KeyInputEvent event) {
        if (lockTargetKeyMapping.consumeClick()) {
            //Messages.sendToServer(new PacketLockTarget());
            System.out.println("q is pressed");
        }
    }

    @SubscribeEvent
    public static void onClientInit(FMLClientSetupEvent event){
        MinecraftForge.EVENT_BUS.addListener(HotKeyRegistry::onKeyInput);
        init();
    }
}
*/
