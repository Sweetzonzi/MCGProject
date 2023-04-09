package moe.gensoukyo.mcgproject.entity.entity.projectile.template;

import moe.gensoukyo.mcgproject.entity.entity.projectile.KnifeProjectile;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

//有简易制导功能的投射物模板
public abstract class GuidedProjectile extends BasicProjectile{
    @Nullable
    private Entity target;//投射物当前锁定的目标
    private float trackPitch = 0;//俯仰跟踪能力，rad/tick
    private float trackYaw = 0;//水平跟踪能力，rad/tick

    //在世界的0，0，0处生成投射物
    protected GuidedProjectile(EntityType<? extends BasicProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    //根据坐标生成投射物
    protected GuidedProjectile(EntityType<? extends BasicProjectile> pEntityType, double pX, double pY, double pZ, Level pLevel){
        super(pEntityType,pX,pY,pZ,pLevel);
    }

    //在发射者的位置生成投射物
    protected GuidedProjectile(EntityType<? extends BasicProjectile> pEntityType, LivingEntity pShooter, Level pLevel) {
        super(pEntityType,pShooter,pLevel);
    }

    @Override
    public void tick() {
        track();
        super.tick();
    }

    protected void track(){
        if(this.getTarget()!=null){
            //获取目标方向
            Vec3 tgt = this.getTarget().getPosition(0).subtract(this.getPosition(0)).normalize();
            Vec3 v = this.getDeltaMovement();//获取速度方向
            float d0 = (float) v.length();//获取速度大小
            v.normalize();//速度方向单位化

            this.setDeltaMovement(tgt.scale(d0));
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        this.setTarget(null);
        super.onHitEntity(pResult);
    }

    public Entity getTarget() {
        return target;
    }

    public void setTarget(Entity target) {
        this.target = target;
    }

    public float getTrackPitch() {
        return trackPitch;
    }

    //俯仰跟踪角速度，degree/s
    public void setTrackPitch(float trackPitch) {
        this.trackPitch = (float) (trackPitch*Math.PI/180/20);//角度转弧度，秒转tick
    }

    public float getTrackYaw() {
        return trackYaw;
    }

    //水平跟踪角速度，degree/s
    public void setTrackYaw(float trackYaw) {
        this.trackYaw = (float) (trackYaw*Math.PI/180/20);//角度转弧度，秒转tick
    }
}
