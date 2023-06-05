package moe.gensoukyo.mcgproject.network;

import moe.gensoukyo.mcgproject.mixininterface.IMixinLockTarget;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class PacketLockTarget {

    public PacketLockTarget() {
    }

    public PacketLockTarget(FriendlyByteBuf buf) {//解码
    }

    public void toBytes(FriendlyByteBuf buf) {//编码，只需要告诉服务器玩家按下了按键，不需要传输数据，故留空
    }
    //处理实际按下锁定目标键后的行为
    public boolean handle(Supplier<NetworkEvent.Context> context) {
        NetworkEvent.Context ctx = context.get();
        //此处开始为服务端
        ctx.enqueueWork(() -> {
            Player player = ctx.getSender();
            if (player != null){
                EntityHitResult hitResult = ProjectileUtil.getEntityHitResult(//获取目标,范围128格
                        player,
                        player.getEyePosition(),
                        player.getEyePosition().add(player.getViewVector(1).scale(128)),
                        player.getBoundingBox().expandTowards(player.getViewVector(1).scale(128)).inflate(1.0D),
                        (e)-> !(e instanceof Projectile),
                        128*128);
                LivingEntity tgt = null;
                if(hitResult != null && hitResult.getEntity()instanceof LivingEntity){
                    tgt = (LivingEntity) hitResult.getEntity();
                }
                if(tgt!=null){
                    player.sendMessage(tgt.getName(),player.getUUID());
                    ((IMixinLockTarget)player).setTarget(tgt);
                }
                else{
                    if(((IMixinLockTarget)player).getTarget()!=null&&((IMixinLockTarget)player).getTarget().isAlive()){
                        player.sendMessage(new TextComponent("解除锁定"),player.getUUID());
                    }
                    else{
                        player.sendMessage(new TextComponent("无目标"),player.getUUID());
                    }
                    ((IMixinLockTarget)player).setTarget(null);
                }
            }
        });
        ctx.setPacketHandled(true);
        return true;
    }
}
