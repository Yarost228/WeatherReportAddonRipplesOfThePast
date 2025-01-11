package com.hk47bot.rotp_wr.init;

import com.hk47bot.rotp_wr.RotpWeatherReportAddon;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class InitParticles {

    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, RotpWeatherReportAddon.MOD_ID);

    public static final RegistryObject<BasicParticleType> REVERSE_AIR_STREAM = PARTICLES.register("reverse_air_stream", () -> new BasicParticleType(false));
}
