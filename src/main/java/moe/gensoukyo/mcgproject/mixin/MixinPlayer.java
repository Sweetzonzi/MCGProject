package moe.gensoukyo.mcgproject.mixin;

import moe.gensoukyo.mcgproject.mixininterface.IMixinLockTarget;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Player.class)//为原版Plyaer类新增成员变量和相应方法
public abstract class MixinPlayer extends LivingEntity implements IMixinLockTarget {
    //存储玩家当前锁定的目标
    private LivingEntity lockedTarget;

    protected MixinPlayer(EntityType<? extends LivingEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override//获取玩家当前锁定的目标
    public LivingEntity getTarget() {
        return lockedTarget;
    }

    @Override//更改玩家当前锁定的目标
    public void setTarget(LivingEntity newTarget) {
        this.lockedTarget = newTarget;
    }
}
