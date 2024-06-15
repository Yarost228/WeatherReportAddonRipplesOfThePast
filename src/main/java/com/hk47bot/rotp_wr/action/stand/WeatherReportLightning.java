package com.hk47bot.rotp_wr.action.stand;

import com.github.standobyte.jojo.action.ActionTarget;
import com.github.standobyte.jojo.action.ActionTarget.TargetType;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class WeatherReportLightning extends StandEntityAction {

    public WeatherReportLightning(StandEntityAction.Builder builder) {
        super(builder);
    }


    @Override
    public void standPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        if (!world.isClientSide()) {
            RayTraceResult target = standEntity.aimWithStandOrUser(25, task.getTarget());
            Vector3d pos = target.getLocation();
            if (pos != null) {
                LightningBoltEntity lightningboltentity = EntityType.LIGHTNING_BOLT.create(world);
                lightningboltentity.moveTo(pos);
                lightningboltentity.setCause(userPower.getUser() instanceof ServerPlayerEntity ? (ServerPlayerEntity) userPower.getUser() : null);
                LightningBoltEntity lightningboltentity1 = EntityType.LIGHTNING_BOLT.create(world);
                lightningboltentity1.moveTo(pos);
                lightningboltentity1.setCause(userPower.getUser() instanceof ServerPlayerEntity ? (ServerPlayerEntity) userPower.getUser() : null);
                world.addFreshEntity(lightningboltentity);
                world.addFreshEntity(lightningboltentity1);
                if (world.isRaining() && userPower.getResolveLevel() >= 3){
                    LightningBoltEntity lightningboltentity2 = EntityType.LIGHTNING_BOLT.create(world);
                    lightningboltentity2.moveTo(pos);
                    lightningboltentity2.setCause(userPower.getUser() instanceof ServerPlayerEntity ? (ServerPlayerEntity) userPower.getUser() : null);
                    LightningBoltEntity lightningboltentity21 = EntityType.LIGHTNING_BOLT.create(world);
                    lightningboltentity21.moveTo(pos);
                    lightningboltentity21.setCause(userPower.getUser() instanceof ServerPlayerEntity ? (ServerPlayerEntity) userPower.getUser() : null);
                    world.addFreshEntity(lightningboltentity21);
                    world.addFreshEntity(lightningboltentity2);
                }
                if (world.isThundering() && userPower.getResolveLevel() >= 4){
                    LightningBoltEntity lightningboltentity3 = EntityType.LIGHTNING_BOLT.create(world);
                    lightningboltentity3.moveTo(pos);
                    lightningboltentity3.setCause(userPower.getUser() instanceof ServerPlayerEntity ? (ServerPlayerEntity) userPower.getUser() : null);
                    LightningBoltEntity lightningboltentity31 = EntityType.LIGHTNING_BOLT.create(world);
                    lightningboltentity31.moveTo(pos);
                    lightningboltentity31.setCause(userPower.getUser() instanceof ServerPlayerEntity ? (ServerPlayerEntity) userPower.getUser() : null);
                    world.addFreshEntity(lightningboltentity31);
                    world.addFreshEntity(lightningboltentity3);
                }
            }
        }
    }
    @Override
    protected boolean standKeepsTarget(ActionTarget target) {
        return target.getType() == TargetType.ENTITY && target.getEntity() instanceof LivingEntity;
    }
}
