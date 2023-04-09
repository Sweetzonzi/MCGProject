package moe.gensoukyo.mcgproject.geckolib.renderer.entity;

import moe.gensoukyo.mcgproject.entity.entity.livingentity.ReplacedPlayerEntity;
import moe.gensoukyo.mcgproject.geckolib.model.entity.ReplacedPlayerModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoReplacedEntityRenderer;

public class ReplacedPlayerRenderer extends GeoReplacedEntityRenderer<ReplacedPlayerEntity> {

    public ReplacedPlayerRenderer(EntityRendererProvider.Context renderProvider) {
        super(renderProvider, new ReplacedPlayerModel(), new ReplacedPlayerEntity());
    }
}
