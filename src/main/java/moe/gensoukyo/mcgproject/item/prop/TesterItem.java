package moe.gensoukyo.mcgproject.item.prop;

import moe.gensoukyo.mcgproject.entity.entity.projectile.KnifeProjectile;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class TesterItem extends Item {
    public TesterItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pLevel.isClientSide) {
            for (int i = 0; i <1; i++) {//i为投射物数量
                KnifeProjectile knife = new KnifeProjectile(pLevel, pPlayer);//创建
                knife.shootFromRotation(pPlayer,pPlayer.getXRot(), pPlayer.getYRot(), 0F, 0.4F, 45F);//根据头朝向发射
                EntityHitResult hitResult = ProjectileUtil.getEntityHitResult(//获取目标
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
                knife.setTarget(tgt);//录入目标
                pLevel.addFreshEntity(knife);
            }
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }

}
