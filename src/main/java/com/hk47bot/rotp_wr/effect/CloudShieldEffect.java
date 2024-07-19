package com.hk47bot.rotp_wr.effect;

import com.github.standobyte.jojo.entity.damaging.projectile.ownerbound.OwnerBoundProjectileEntity;
import com.github.standobyte.jojo.potion.UncurableEffect;
import com.github.standobyte.jojo.util.general.GeneralUtil;
import com.hk47bot.rotp_wr.RotpWeatherReportAddon;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectType;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RotpWeatherReportAddon.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CloudShieldEffect extends UncurableEffect {

    public CloudShieldEffect(EffectType type, int color){
        super(type, color);
    }

    public void applyEffectTick(LivingEntity user, int amplifier) {
        World world = user.level;
        world.getEntitiesOfClass(ProjectileEntity.class, user.getBoundingBox().inflate(3.5),
                entity -> entity != null && entity.isAlive() && !entity.isPickable() && !(entity instanceof OwnerBoundProjectileEntity)).forEach(projectile -> {
            Vector3d stop = new Vector3d(0, projectile.getDeltaMovement().y()/2, 0);
            projectile.setDeltaMovement(stop);
            if (world.isClientSide()) {
                world.addParticle(ParticleTypes.CLOUD, projectile.getX(), projectile.getY(), projectile.getZ(), 0, 0, 0);
            }
        });
        if (world.isClientSide()){
            GeneralUtil.doFractionTimes(() ->
                    world.addParticle(ParticleTypes.CLOUD, false, user.getRandomX(2.5), user.getRandomY() + 0.5, user.getRandomZ(2.5), 0, 0.0625, 0),
                    3);
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
