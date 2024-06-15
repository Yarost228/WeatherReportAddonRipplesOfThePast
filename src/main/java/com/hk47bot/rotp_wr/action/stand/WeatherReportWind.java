package com.hk47bot.rotp_wr.action.stand;

import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.entity.stand.StandPose;
import com.github.standobyte.jojo.init.ModParticles;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.github.standobyte.jojo.util.general.GeneralUtil;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class WeatherReportWind extends StandEntityAction {
    public static final StandPose WIND_BLOW = new StandPose("WR_WIND");

    public WeatherReportWind(StandEntityAction.Builder builder) {
        super(builder);
    }


    @Override
    public void standTickPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        double RANGE = 24;
        Vector3d wrLookVec = standEntity.getLookAngle();
        LivingEntity user = userPower.getUser();
        world.getEntities(standEntity, standEntity.getBoundingBox().inflate(RANGE, RANGE, RANGE),
                        entity -> wrLookVec.dot(entity.position().subtract(standEntity.position()).normalize()) > 0.886 && entity.distanceToSqr(standEntity) > 0.5)
                .forEach(entity -> {
                    if (entity.canUpdate()) {
                        double distance = entity.distanceTo(standEntity);
                        Vector3d pushVec = wrLookVec.normalize().scale(0.5 * standEntity.getStandEfficiency());
                        entity.setDeltaMovement(distance > 2 ?
                                entity.getDeltaMovement().add(pushVec.scale(1/distance*2))
                                : pushVec.scale(Math.max(distance - 1, 0)));

                    }
                });
        if (world.isClientSide()) {

            GeneralUtil.doFractionTimes(() -> {
                Vector3d userPos = standEntity.position().add(
                        (Math.random() - 0.5) * (user.getBbWidth() + 1.0),
                        Math.random() * (user.getBbHeight() + 1.0),
                        (Math.random() - 0.5) * (user.getBbWidth() + 1.0));
                Vector3d particlePos = userPos.add(wrLookVec.scale(2)
                        .xRot((float) (-(Math.random() * 2 - 1) * Math.PI / 6))
                        .yRot((float) (-(Math.random() * 2 - 1) * Math.PI / 6)));
                Vector3d vecToStand = userPos.subtract(particlePos).normalize().scale(0.75);
                world.addParticle(ModParticles.AIR_STREAM.get(), particlePos.x, particlePos.y, particlePos.z, -vecToStand.x,  -vecToStand.y, -vecToStand.z);
            }, 5);
        }
    }











    @Override
    public int getCooldownAdditional(IStandPower power, int ticksHeld) {
        int cooldown = super.getCooldownAdditional(power, ticksHeld);
        return cooldownFromHoldDuration(cooldown, power, ticksHeld);
    }
}




