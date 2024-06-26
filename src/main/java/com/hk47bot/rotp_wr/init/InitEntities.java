package com.hk47bot.rotp_wr.init;

import com.hk47bot.rotp_wr.RotpWeatherReportAddon;

import com.hk47bot.rotp_wr.entity.fugurain.FugaSummonerEntity;
import com.hk47bot.rotp_wr.entity.fugurain.projectile.FugaProjectileEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class InitEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, RotpWeatherReportAddon.MOD_ID);

    public static final RegistryObject<EntityType<FugaSummonerEntity>> FUGU_SUMMONER = ENTITIES.register("fuga_summoner",
            () -> EntityType.Builder.<FugaSummonerEntity>of(FugaSummonerEntity::new, EntityClassification.MISC)
                    .fireImmune()
                    .sized(0.01F, 0.01F)
                    .build(RotpWeatherReportAddon.MOD_ID + ":fuga_summoner"));

    public static final RegistryObject<EntityType<FugaProjectileEntity>> FUGU_PROJECTILE = ENTITIES.register("fuga_projectile",
            () -> EntityType.Builder.<FugaProjectileEntity>of(FugaProjectileEntity::new, EntityClassification.MISC)
                    .sized(0.75F, 0.75F)
                    .setUpdateInterval(10)
                    .build(new ResourceLocation(RotpWeatherReportAddon.MOD_ID, "fuga_projectile").toString()));
}