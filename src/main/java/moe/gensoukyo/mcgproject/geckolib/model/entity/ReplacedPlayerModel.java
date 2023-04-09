package moe.gensoukyo.mcgproject.geckolib.model.entity;

import moe.gensoukyo.mcgproject.geckolib.GeckolibResources;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ReplacedPlayerModel extends AnimatedGeoModel {
    @Override
    public ResourceLocation getModelLocation(Object object) {
        return GeckolibResources.REPLACED_PLAYER_MODEL;
    }

    @Override
    public ResourceLocation getTextureLocation(Object object) {
        return GeckolibResources.REPLACED_PLAYER_TEXTURE;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(Object animatable) {
        return GeckolibResources.REPLACED_PLAYER_ANIMATIONS;
    }
}
