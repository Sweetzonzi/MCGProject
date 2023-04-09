package moe.gensoukyo.mcgproject.entity.entity.projectile;

import moe.gensoukyo.mcgproject.entity.entity.projectile.template.BasicProjectile;
import moe.gensoukyo.mcgproject.entity.entity.projectile.template.GuidedProjectile;
import moe.gensoukyo.mcgproject.registry.EntityRegistry;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class KnifeProjectile extends GuidedProjectile {
    //构造方法
    public KnifeProjectile(EntityType<? extends BasicProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    //根据坐标生成投射物
    public KnifeProjectile(Level pLevel, double pX, double pY, double pZ) {
        super(EntityRegistry.KNIFE_PROJECTILE.get(), pX, pY, pZ, pLevel);
    }
    //在发射者的位置生成投射物
    public KnifeProjectile(Level pLevel, LivingEntity pShooter) {
        super(EntityRegistry.KNIFE_PROJECTILE.get(), pShooter, pLevel);
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        pResult.getEntity().hurt(DamageSource.MAGIC,0);
        super.onHitEntity(pResult);
    }
}
