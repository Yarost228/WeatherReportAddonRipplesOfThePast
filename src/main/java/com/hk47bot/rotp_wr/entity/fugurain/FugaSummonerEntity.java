package com.hk47bot.rotp_wr.entity.fugurain;

import com.hk47bot.rotp_wr.entity.fugurain.projectile.FugaProjectileEntity;
import com.hk47bot.rotp_wr.init.InitEntities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

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
            if (tickCount % 2 == 0) {
                Vector3d thisPos = position();
                for (int i = 0; i < 2; i++) {
                    FugaProjectileEntity fugaEntity = new FugaProjectileEntity(user, level);
                    Vector3d randomOffset = new Vector3d(
                            (random.nextDouble() * 32 - 0.5) * (random.nextDouble() - random.nextDouble()),
                            random.nextDouble() * 32 - 0.5,
                            (random.nextDouble() * 32 - 0.5) * (random.nextDouble() - random.nextDouble()));
                    Vector3d entityPosition = thisPos.add(randomOffset);
                    fugaEntity.moveTo(entityPosition);
                    fugaEntity.setDeltaMovement(0, -1.5, 0);
                    fugaEntity.setOwner(this);
                    level.addFreshEntity(fugaEntity);
                }
            }
            if (livetime == 400 || !this.level.isRaining()){
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

