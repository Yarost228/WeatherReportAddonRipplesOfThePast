package com.hk47bot.rotp_wr.entity.fugurain.projectile;

import com.github.standobyte.jojo.entity.damaging.projectile.ModdedProjectileEntity;
import com.github.standobyte.jojo.init.ModStatusEffects;
import com.hk47bot.rotp_wr.init.InitEffects;
import com.hk47bot.rotp_wr.init.InitEntities;

import com.hk47bot.rotp_wr.init.InitSounds;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.passive.fish.PufferfishEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.ParticleTypes;

import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class FugaProjectileEntity extends ModdedProjectileEntity {

    public FugaProjectileEntity(LivingEntity shooter, World world) {
        super(InitEntities.FUGU_PROJECTILE.get(), shooter, world);
    }

    public FugaProjectileEntity(EntityType<? extends  FugaProjectileEntity> type, World world) {
        super(type, world);
    }

    @Override
    public int ticksLifespan() {
        return 400;
    }

    @Override
    protected float getBaseDamage() {
        return 5.0F;
    }

    @Override
    protected float getMaxHardnessBreakable() {
        return 0;
    }

    @Override
    public boolean standDamage() {
        return false;
    }

    @Override
    protected void onHitBlock(BlockRayTraceResult blockRayTraceResult){
        double fishSummonChance = random.nextDouble();
        if (!this.level.isClientSide()){
            if (fishSummonChance > 0.1 && fishSummonChance < 0.15){
                PufferfishEntity pufferfish = EntityType.PUFFERFISH.create(this.level);
                CompoundNBT nbt = new CompoundNBT();
                nbt.putString("DeathLootTable", "empty");
                nbt.putInt("PuffState", 2);
                nbt.putBoolean("SummonedByRain", true);
                pufferfish.load(nbt);
                pufferfish.moveTo(blockRayTraceResult.getLocation().x(), blockRayTraceResult.getLocation().y()+1, blockRayTraceResult.getLocation().z());
                this.level.addFreshEntity(pufferfish);
            }
            if (fishSummonChance > 0.3 && fishSummonChance < 0.35){
                Vector3d hitPos = blockRayTraceResult.getLocation();
                AreaEffectCloudEntity cloud = new AreaEffectCloudEntity(this.level, hitPos.x, hitPos.y, hitPos.z);
                cloud.setRadius(2);
                cloud.setDuration(100);
                cloud.addEffect(new EffectInstance(Effects.POISON, 100));
                this.level.addFreshEntity(cloud);
            }
        }
        this.level.playLocalSound(this.getX(), this.getY(), this.getZ(), InitSounds.PUFFERFISH_SPLASH.get(), SoundCategory.WEATHER, 0.25F, 1, true);
        for (int i = 0; i < random.nextDouble()*10; i++){
            this.level.addParticle(ParticleTypes.SNEEZE,this.getX() - (double)(this.getBbWidth() + 1.0F) * 0.5D * (double) MathHelper.sin(this.getYHeadRot() * ((float)Math.PI / 180F)), this.getEyeY() - (double)0.1F, this.getZ() + (double)(this.getBbWidth() + 1.0F) * 0.5D * (double)MathHelper.cos(this.getYHeadRot() * ((float)Math.PI / 180F)), this.getX(), 0.0D, this.getZ());
        }
    }
    @Override
    protected void afterEntityHit(EntityRayTraceResult entityRayTraceResult, boolean entityHurt) {
        if (entityHurt) {
            Entity entity = entityRayTraceResult.getEntity();
            if (entity instanceof LivingEntity) {
                if (!this.level.isClientSide()){
                    LivingEntity target = (LivingEntity) entity;
                    target.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 120, 0));
                    target.addEffect(new EffectInstance(Effects.POISON, 90, 1));
                }
                this.level.playLocalSound(this.getX(), this.getY(), this.getZ(), InitSounds.PUFFERFISH_SPLASH.get(), SoundCategory.WEATHER, 0.25F, 1, true);
                for (int i = 0; i < random.nextDouble() * 10; i++) {
                    this.level.addParticle(ParticleTypes.SNEEZE,this.getX() - (double)(this.getBbWidth() + 1.0F) * 0.5D * (double) MathHelper.sin(this.getYHeadRot() * ((float)Math.PI / 180F)), this.getEyeY() - (double)0.1F, this.getZ() + (double)(this.getBbWidth() + 1.0F) * 0.5D * (double)MathHelper.cos(this.getYHeadRot() * ((float)Math.PI / 180F)), this.getX(), 0.0D, this.getZ());
                }
            }
        }
    }
    @Override
    public boolean canHitOwner() {return true;}
}

