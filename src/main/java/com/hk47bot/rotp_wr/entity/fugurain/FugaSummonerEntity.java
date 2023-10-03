package com.hk47bot.rotp_wr.entity.fugurain;

import com.hk47bot.rotp_wr.init.InitEntities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.fish.PufferfishEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class FugaSummonerEntity extends Entity {

        private int livetime;

        public FugaSummonerEntity(World world) {
        this(InitEntities.FUGU_SUMMONER.get(), world);
    }

    public FugaSummonerEntity(EntityType<?> entityType, World world) {
        super(entityType, world);
    };
    @Override
    public void tick() {
        super.tick();
        ++this.livetime;
        if (!level.isClientSide()) {
            if (tickCount % 2 == 0) {
                Vector3d thisPos = position();
                
                for (int i = 0; i < 4; i++) {
                    Entity fugaEntity = new PufferfishEntity(EntityType.PUFFERFISH, level);
                    CompoundNBT nbt = new CompoundNBT();
                    nbt.putString("DeathLootTable", "empty");
                    nbt.putInt("PuffState", 2);
                    fugaEntity.load(nbt);
                    Vector3d randomOffset = new Vector3d(
                            random.nextDouble() * 16 - 0.5,
                            random.nextDouble() * 16 - 0.5,
                            random.nextDouble() * 16 - 0.5);
                    Vector3d entityPosition = thisPos.add(randomOffset);
                    fugaEntity.moveTo(entityPosition);
                    level.addFreshEntity(fugaEntity);
                    
                }
                
                if (livetime % 100 == 0){
                }
            }
            if (livetime == 400 || this.level.isRaining() == false){
                this.remove();

            }
        }
    }

    




    @Override
    protected void defineSynchedData() {}

    @Override
    protected void readAdditionalSaveData(CompoundNBT compound) {}

        @Override
    protected void addAdditionalSaveData(CompoundNBT compound) {
    }

    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
    
}

