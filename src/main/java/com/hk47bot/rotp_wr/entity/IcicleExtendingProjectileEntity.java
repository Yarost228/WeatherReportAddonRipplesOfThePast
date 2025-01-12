package com.hk47bot.rotp_wr.entity;

import com.github.standobyte.jojo.entity.damaging.projectile.ownerbound.OwnerBoundProjectileEntity;
import com.github.standobyte.jojo.init.ModStatusEffects;
import com.github.standobyte.jojo.util.general.GeneralUtil;
import com.github.standobyte.jojo.util.mod.JojoModUtil;
import com.hk47bot.rotp_wr.init.InitEffects;
import com.hk47bot.rotp_wr.init.InitEntities;
import com.hk47bot.rotp_wr.init.InitSounds;
import com.hk47bot.rotp_wr.init.InitStands;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class IcicleExtendingProjectileEntity extends OwnerBoundProjectileEntity {

    public IcicleExtendingProjectileEntity(World world, LivingEntity entity) {
        super(InitEntities.ICICLE_STRIKE_PROJECTILE.get(), entity, world);
    }

    public IcicleExtendingProjectileEntity(EntityType<? extends IcicleExtendingProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public boolean standDamage() {
        return true;
    }

    @Override
    public float getBaseDamage() {
        return 5.0F;
    }

    @Override
    protected float getMaxHardnessBreakable() {
        return 0.0F;
    }

    @Override
    protected void afterBlockHit(BlockRayTraceResult blockRayTraceResult, boolean blockDestroyed) {
        playSound(InitSounds.WEATHER_REPORT_AIR_FRICTION_PUNCH.get(), 1.0F, 1.0F);
        setIsRetracting(true);
    }

    @Override
    protected boolean hurtTarget(Entity target, LivingEntity owner) {
        playSound(InitSounds.WEATHER_REPORT_AIR_FRICTION_PUNCH.get(), 1.0F, 1.0F);
        if (target instanceof LivingEntity){
            LivingEntity livingTarget = (LivingEntity) target;
            if (JojoModUtil.canBleed(livingTarget)){
                livingTarget.addEffect(new EffectInstance(ModStatusEffects.BLEEDING.get(), 100, 2, false, false, true));
            }
        }
        return super.hurtTarget(target, owner);
    }

    @Override
    protected void afterEntityHit(EntityRayTraceResult entityRayTraceResult, boolean entityHurt) {
        super.afterEntityHit(entityRayTraceResult, entityHurt);
        setIsRetracting(true);
    }

    @Override
    public int ticksLifespan() {
        return InitStands.WEATHER_REPORT_ICICLE_STRIKE.get().getStandActionTicks(null, null);
    }

    @Override
    protected float movementSpeed() {
        return 0.75F;
    }

    @Override
    protected int timeAtFullLength() {
        return 4;
    }

    @Override
    protected float retractSpeed() {
        return 0.5F;
    }

    @Override
    public boolean isBodyPart() {
        return true;
    }
    @Override
        public void onAddedToWorld() {
        super.onAddedToWorld();
        if (this.level.isClientSide()){
            World world = this.level;
            GeneralUtil.doFractionTimes(() -> {
                world.addParticle(ParticleTypes.CLOUD, this.getX(1)-0.35D, this.getY()-0.3D, this.getZ(1) + 0.25D, this.getDeltaMovement().x(), this.getDeltaMovement().y(), this.getDeltaMovement().z());
            }, 5);
        }
    }

    private static final Vector3d OFFSET = new Vector3d(-0.35D, -0.25D, 0.25D);
    @Override
    protected Vector3d getOwnerRelativeOffset() {
        return OFFSET;
    }
}

