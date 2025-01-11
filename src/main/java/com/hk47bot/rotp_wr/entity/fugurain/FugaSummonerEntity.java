package com.hk47bot.rotp_wr.entity.fugurain;

import com.github.standobyte.jojo.util.general.GeneralUtil;
import com.hk47bot.rotp_wr.RotpWeatherReportAddon;
import com.hk47bot.rotp_wr.entity.fugurain.projectile.FugaProjectileEntity;
import com.hk47bot.rotp_wr.init.InitEntities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.fish.PufferfishEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FugaSummonerEntity extends Entity {

    private int livetime;
    private LivingEntity user;

    public FugaSummonerEntity(World world) {
        this(InitEntities.FUGU_SUMMONER.get(), world);
    }

    public FugaSummonerEntity(EntityType<?> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void tick() {
        super.tick();
        ++this.livetime;
        if (!level.isClientSide()) {
            List<LivingEntity> targets = level.getEntitiesOfClass(LivingEntity.class, new AxisAlignedBB(this.blockPosition()).inflate(256), livingEntity -> !(livingEntity instanceof PufferfishEntity));
            Vector3d thisPos = position();
            GeneralUtil.doFractionTimes(() -> {
                FugaProjectileEntity fugaEntity = new FugaProjectileEntity(user, level);
                Vector3d randomOffset = new Vector3d(
                (random.nextDouble() * 256 - 0.5) * (random.nextDouble() - random.nextDouble()),
                random.nextDouble() * 32 - 0.5,
                (random.nextDouble() * 256 - 0.5) * (random.nextDouble() - random.nextDouble()));
                Vector3d pufferfishPosition = thisPos.add(randomOffset);
                fugaEntity.moveTo(pufferfishPosition);
                fugaEntity.setDeltaMovement(0, -1.5, 0);
                fugaEntity.setOwner(this);
                level.addFreshEntity(fugaEntity);
            }, 4);
            GeneralUtil.doFractionTimes(()-> {
                FugaProjectileEntity fugaEntity = new FugaProjectileEntity(user, level);
                Random dropRandom = new Random();
                float targetingChance = dropRandom.nextFloat();
                if (targetingChance > 0.2 && targetingChance < 0.21){
                    targets.stream().findAny().ifPresent(livingEntity -> {
                        Vector3d posAbove = new Vector3d(livingEntity.getX(), this.getY() + random.nextDouble() * 32 - 0.5, livingEntity.getZ());
                        fugaEntity.moveTo(posAbove);
                        fugaEntity.setDeltaMovement(0, -1.5, 0);
                        fugaEntity.setOwner(this);
                        level.addFreshEntity(fugaEntity);
                    });
                }
            }, 2);
            if (livetime == 2400 || !this.level.isRaining()){
                this.remove();

            }
        }
    }
    public void setUser(LivingEntity user){
        this.user = user;
    }
    public LivingEntity getUser(){
        return user;
    }



    @Override
    protected void defineSynchedData() {}

    @Override
    protected void readAdditionalSaveData(CompoundNBT compound) {
        compound.putInt("Age", livetime);
    }

    @Override
    protected void addAdditionalSaveData(CompoundNBT compound) {
        livetime = compound.getInt("Age");
    }

    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
    
}

