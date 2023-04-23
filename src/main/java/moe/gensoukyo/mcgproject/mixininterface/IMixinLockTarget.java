package moe.gensoukyo.mcgproject.mixininterface;

import net.minecraft.world.entity.LivingEntity;

public interface IMixinLockTarget {

    LivingEntity getTarget();
    void setTarget(LivingEntity lockedTarget);

}
