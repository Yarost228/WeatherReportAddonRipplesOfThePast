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
                Entity fugaEntity = new PufferfishEntity(EntityType.PUFFERFISH, level);
                Entity fugaEntity2 = new PufferfishEntity(EntityType.PUFFERFISH, level);
                Entity fugaEntity3 = new PufferfishEntity(EntityType.PUFFERFISH, level);
                Entity fugaEntity4 = new PufferfishEntity(EntityType.PUFFERFISH, level);
                CompoundNBT nbt = new CompoundNBT();
                nbt.putString("DeathLootTable", "empty");
                fugaEntity.load(nbt);
                fugaEntity2.load(nbt);
                fugaEntity3.load(nbt);
                fugaEntity4.load(nbt);
                CompoundNBT nbt2 = new CompoundNBT();
                nbt2.putInt("PuffState", 2);
                fugaEntity.load(nbt2);
                fugaEntity2.load(nbt2);
                fugaEntity3.load(nbt2);
                fugaEntity4.load(nbt2);
                Vector3d thisPos = position();
                Vector3d randomOffset = new Vector3d(
                        random.nextDouble() * 16 - 0.5,
                        random.nextDouble() * 16 - 0.5,
                        random.nextDouble() * 16 - 0.5);
                Vector3d thisPos2 = position();
                Vector3d randomOffset2 = new Vector3d(
                        random.nextDouble() * -16 - 0.5,
                        random.nextDouble() * 16 - 0.5,
                        random.nextDouble() * 16 - 0.5);
                Vector3d thisPos3 = position();
                Vector3d randomOffset3 = new Vector3d(
                        random.nextDouble() * -16 - 0.5,
                        random.nextDouble() * 16 - 0.5,
                        random.nextDouble() * -16 - 0.5);
                Vector3d thisPos4 = position();
                Vector3d randomOffset4 = new Vector3d(
                        random.nextDouble() * 16 - 0.5,
                        random.nextDouble() * 16 - 0.5,
                        random.nextDouble() * -16 - 0.5);
                
                Vector3d entityPosition = thisPos.add(randomOffset);
                fugaEntity.moveTo(entityPosition);
                level.addFreshEntity(fugaEntity);
                Vector3d entityPosition2 = thisPos2.add(randomOffset2);
                fugaEntity2.moveTo(entityPosition2);
                level.addFreshEntity(fugaEntity2);
                Vector3d entityPosition3 = thisPos3.add(randomOffset3);
                fugaEntity3.moveTo(entityPosition3);
                level.addFreshEntity(fugaEntity3);
                Vector3d entityPosition4 = thisPos4.add(randomOffset4);
                fugaEntity4.moveTo(entityPosition4);
                level.addFreshEntity(fugaEntity4);
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

