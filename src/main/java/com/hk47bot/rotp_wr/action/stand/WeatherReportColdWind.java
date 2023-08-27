package com.hk47bot.rotp_wr.action.stand;

import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.init.ModParticles;
import com.github.standobyte.jojo.init.ModStatusEffects;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.github.standobyte.jojo.util.general.GeneralUtil;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class WeatherReportColdWind extends StandEntityAction {

    public WeatherReportColdWind(StandEntityAction.Builder builder) {
        super(builder);
    }
    
    private static final double RANGE = 16;
    @Override
    public void standTickPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        Vector3d wrLookVec = standEntity.getLookAngle();
        world.getEntities(standEntity, standEntity.getBoundingBox().inflate(RANGE, RANGE, RANGE), 
                entity -> wrLookVec.dot(entity.position().subtract(standEntity.position()).normalize()) > 0.886 && entity.distanceToSqr(standEntity) > 0.5
                && (/*standEntity.isManuallyControlled() || */!entity.is(standEntity.getUser()))).forEach(entity -> {
                    if (entity.canUpdate()) {
                        double distance = entity.distanceTo(standEntity);
                        Vector3d pushVec = wrLookVec.normalize().scale(0.5 * standEntity.getStandEfficiency());
                        entity.setDeltaMovement(distance > 2 ? 
                                entity.getDeltaMovement().add(pushVec.scale(1/distance*2))
                                : pushVec.scale(Math.max(distance - 1, 0)));
                        Entity effecttarget = entity;
                        if (effecttarget instanceof LivingEntity){
                            LivingEntity effectTarget = (LivingEntity) effecttarget;
                        effectTarget.addEffect(new EffectInstance(ModStatusEffects.FREEZE.get(), 15, 0));
                    }
                };
                });
                    
        if (world.isClientSide()) {
            GeneralUtil.doFractionTimes(() -> {
                LivingEntity user = userPower.getUser();
                Vector3d userPos = user.position().add(
                    (Math.random() - 0.5) * (user.getBbWidth() + 1.0), 
                    Math.random() * (user.getBbHeight() + 1.0), 
                    (Math.random() - 0.5) * (user.getBbWidth() + 1.0));
                Vector3d particlePos = userPos.add(wrLookVec.scale(2)
                .xRot((float) ((Math.random() * 2 - 1) * Math.PI / 6))
                .yRot((float) ((Math.random() * 2 - 1) * Math.PI / 6)));
                Vector3d vecToStand = userPos.subtract(particlePos).normalize().scale(0.75);
                world.addParticle(ModParticles.AIR_STREAM.get(), particlePos.x, particlePos.y, particlePos.z, -vecToStand.x,  -vecToStand.y, -vecToStand.z);
            }, 5);
            GeneralUtil.doFractionTimes(() -> {
                LivingEntity user = userPower.getUser();
                Vector3d userPos = user.position().add(
                    (Math.random() - 0.5) * (user.getBbWidth() + 1.0), 
                    Math.random() * (user.getBbHeight() + 1.0), 
                    (Math.random() - 0.5) * (user.getBbWidth() + 1.0));
                Vector3d particlePos = userPos.add(wrLookVec.scale(2)
                .xRot((float) ((Math.random() * 2 - 1) * Math.PI / 6))
                .yRot((float) ((Math.random() * 2 - 1) * Math.PI / 6)));
                Vector3d vecToStand = userPos.subtract(particlePos).normalize().scale(0.75);
                world.addParticle(ParticleTypes.CLOUD, particlePos.x, particlePos.y, particlePos.z, -vecToStand.x,  -vecToStand.y, -vecToStand.z);
            }, 5);
        }
    }
}