package com.hk47bot.rotp_wr.init;

import com.hk47bot.rotp_wr.RotpWeatherReportAddon;
import com.hk47bot.rotp_wr.entity.fugurain.FugaSummonerEntity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class InitEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, RotpWeatherReportAddon.MOD_ID);
    
    public static final RegistryObject<EntityType<FugaSummonerEntity>> FUGU_SUMMONER = ENTITIES.register("fuga_summoner",
     () -> EntityType.Builder.<FugaSummonerEntity>of(FugaSummonerEntity::new, EntityClassification.MISC)
    .fireImmune()
    .sized(0.25F, 0.25F)
    .build(RotpWeatherReportAddon.MOD_ID + ":fuga_summoner"));
};
