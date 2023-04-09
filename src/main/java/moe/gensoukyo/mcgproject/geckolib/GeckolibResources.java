package moe.gensoukyo.mcgproject.geckolib;

import moe.gensoukyo.mcgproject.MCGProject;
import net.minecraft.resources.ResourceLocation;

public class GeckolibResources {//储存所有Geckolib模型，动画和材质的资源路径
    //实体---------------------------------------------------------------------------
    //替换玩家模型
    public static final ResourceLocation REPLACED_PLAYER_MODEL = new ResourceLocation(MCGProject.MOD_ID,
            "geo/player.geo.json");
    public static final ResourceLocation REPLACED_PLAYER_TEXTURE = new ResourceLocation(MCGProject.MOD_ID,
            "textures/entity/player.png");
    public static final ResourceLocation REPLACED_PLAYER_ANIMATIONS = new ResourceLocation(MCGProject.MOD_ID,
            "animations/player.animation.json");
    //飞刀投射物
    public static final ResourceLocation KNIFE_MODEL = new ResourceLocation(MCGProject.MOD_ID,
            "geo/knife.geo.json");
    public static final ResourceLocation KNIFE_TEXTURE = new ResourceLocation(MCGProject.MOD_ID,
            "textures/entity/knife.png");
    public static final ResourceLocation KNIFE_ANIMATIONS = new ResourceLocation(MCGProject.MOD_ID,
            "animations/knife.animation.json");
}
