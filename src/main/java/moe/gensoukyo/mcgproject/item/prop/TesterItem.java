package moe.gensoukyo.mcgproject.item.prop;

import moe.gensoukyo.mcgproject.entity.entity.projectile.KnifeProjectile;
import moe.gensoukyo.mcgproject.registry.EntityRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.registries.RegistryObject;

public class TesterItem extends Item {
    public TesterItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pLevel.isClientSide) {
            for (int i = 0; i <1; i++) {
                KnifeProjectile knife = new KnifeProjectile(pLevel, pPlayer);
                knife.shootFromRotation(pPlayer,pPlayer.getXRot(), pPlayer.getYRot(), 0F, 0.4F, 45F);
                EntityHitResult hitResult = ProjectileUtil.getEntityHitResult(
                        pPlayer,
                        pPlayer.getEyePosition(),
                        pPlayer.getEyePosition().add(pPlayer.getViewVector(1).scale(64)),
                        pPlayer.getBoundingBox().expandTowards(pPlayer.getViewVector(1).scale(64)).inflate(1.0D),
                        (e)-> !(e instanceof Projectile),
                        64*64);
                Entity tgt = null;
                if(hitResult != null){
                    tgt = hitResult.getEntity();
                }
                if(tgt!=null){pPlayer.sendMessage(tgt.getName(),pPlayer.getUUID());}
                knife.setTarget(tgt);
                pLevel.addFreshEntity(knife);
            }
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }

}
