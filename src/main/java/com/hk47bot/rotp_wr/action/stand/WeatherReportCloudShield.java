package com.hk47bot.rotp_wr.action.stand;

import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.client.ClientUtil;
import com.github.standobyte.jojo.client.sound.ClientTickingSoundsHelper;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.entity.stand.StandPose;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.github.standobyte.jojo.power.impl.stand.StandInstance;
import com.hk47bot.rotp_wr.init.InitSounds;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class WeatherReportCloudShield extends StandEntityAction {
    public WeatherReportCloudShield(StandEntityAction.Builder builder) {
        super(builder
                .holdType()
                .staminaCostTick(2F)
                .standUserWalkSpeed(0.5F)
                .standPose(StandPose.BLOCK)
                .standOffsetFromUser(0, -0.4)
                .partsRequired(StandInstance.StandPart.ARMS));
    }

    @Override
    public void standTickPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
            LivingEntity user = userPower.getUser ();
            Random random = new Random ();
            world.getEntitiesOfClass(ProjectileEntity.class, user.getBoundingBox().inflate(2.5),
                    entity -> entity.isAlive()).forEach(projectile -> {
                        Vector3d randomOffset = new Vector3d((random.nextDouble () - random.nextDouble () ) * 0.5, (random.nextDouble ()  - random.nextDouble () ) * 0.5, (random.nextDouble ()  - random.nextDouble () ) * 0.5);
                        Vector3d lookVec = standEntity.getLookAngle().add(randomOffset);
                        if (!world.isClientSide ()){
                            projectile.setDeltaMovement(lookVec);
                        }
                        if (world.isClientSide ()){
                            world.addParticle(ParticleTypes.CLOUD, projectile.getX (), projectile.getY (), projectile.getZ (), 0, 0, 0);
                        }
                    });
    }
    @Override
    public void phaseTransition(World world, StandEntity standEntity, IStandPower standPower,
                                @Nullable Phase from, @Nullable Phase to, StandEntityTask task, int nextPhaseTicks) {
        if (world.isClientSide()) {
            if (to == Phase.PERFORM) {
                ClientTickingSoundsHelper.playStandEntityCancelableActionSound(standEntity,
                        InitSounds.WEATHER_REPORT_CLOUD_SHIELD.get(), this, Phase.PERFORM, 1.0F, 1.0F, true);
            }
            else if (from == Phase.PERFORM) {
                standEntity.playSound(InitSounds.WEATHER_REPORT_UNSUMMON.get(), 1.0F, 1.0F, ClientUtil.getClientPlayer());
            }
        }
    }
    }
