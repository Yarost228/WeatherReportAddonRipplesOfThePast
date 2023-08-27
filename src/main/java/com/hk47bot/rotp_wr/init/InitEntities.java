package com.hk47bot.rotp_wr.init;

import com.hk47bot.rotp_wr.RotpWeatherReportAddon;

import net.minecraft.entity.EntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class InitEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, RotpWeatherReportAddon.MOD_ID);
};
