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
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class WeatherReportLightning extends StandEntityAction {

    public WeatherReportLightning(StandEntityAction.Builder builder) {
        super(builder);
    }

    @Override
    public void onHoldTick(World world, LivingEntity user,IStandPower power, int ticksHeld, ActionTarget target, boolean requirementsFulfilled) {
        super.holdTick(world, user, power, ticksHeld, target, requirementsFulfilled);
        if (requirementsFulfilled && world.isClientSide()) {
            StandEntity standEntity = (StandEntity) power.getStandManifestation();
            RayTraceResult result = standEntity.precisionRayTrace(standEntity, 100);
            Vector3d pos = result.getLocation();
            world.addParticle(ParticleTypes.END_ROD, pos.x, pos.y(), pos.z(), 0, 0, 0);
        }
    }


    @Override
    public void standPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        if (!world.isClientSide()) {
            RayTraceResult result = standEntity.precisionRayTrace(standEntity, 100);
            Vector3d pos = result.getLocation();
            if (pos != null) {
                int lightningCount;
                if (world.isThundering()){
                    lightningCount = 8;
                }
                else if (!world.isRaining()){
                    lightningCount = 0;

                }
                else {
                    lightningCount = 3;
                }
                LightningBoltEntity bolt = EntityType.LIGHTNING_BOLT.create(world);
                bolt.moveTo(pos);
                bolt.setDamage(7 + lightningCount);
                world.addFreshEntity(bolt);
            }
        }
    }
    @Override
    protected boolean standKeepsTarget(ActionTarget target) {
        return target.getType() == TargetType.ENTITY && target.getEntity() instanceof LivingEntity;
    }
}
