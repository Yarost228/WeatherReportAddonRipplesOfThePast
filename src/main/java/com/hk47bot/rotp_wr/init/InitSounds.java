
package com.hk47bot.rotp_wr.init;

import com.github.standobyte.jojo.util.mc.OstSoundList;
import java.util.function.Supplier;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class InitSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS;
    public static final RegistryObject<SoundEvent> WEATHER_REPORT;
    public static final RegistryObject<SoundEvent> WEATHER_REPORT_USER_UNSUMMON;
    public static final RegistryObject<SoundEvent> WEATHER_REPORT_USER_CLOUD_SHIELD;
    public static final RegistryObject<SoundEvent> WEATHER_REPORT_USER_PUFFERFISH_RAIN_CAST;
    public static final RegistryObject<SoundEvent> WEATHER_REPORT_USER_HEAVY_PUNCH;
    public static final RegistryObject<SoundEvent> WEATHER_REPORT_USER_PUNCH;
    public static final RegistryObject<SoundEvent> WEATHER_REPORT_USER_LIGHTNING;
    public static final Supplier<SoundEvent> WEATHER_REPORT_SUMMON;
    public static final Supplier<SoundEvent> WEATHER_REPORT_UNSUMMON;
    public static final RegistryObject<SoundEvent> WEATHER_REPORT_PUNCH_SWING;
    public static final Supplier<SoundEvent> WEATHER_REPORT_PUNCH_LIGHT;
    public static final Supplier<SoundEvent> WEATHER_REPORT_PUNCH_HEAVY;
    public static final Supplier<SoundEvent> WEATHER_REPORT_BARRAGE;
    public static final Supplier<SoundEvent> WEATHER_REPORT_AIR_FRICTION_PUNCH;
    public static final RegistryObject<SoundEvent> WEATHER_REPORT_WIND;
    public static final RegistryObject<SoundEvent> WEATHER_REPORT_COLD_WIND;
    public static final RegistryObject<SoundEvent> WEATHER_REPORT_CLOUD_SHIELD;
    public static final RegistryObject<SoundEvent> WEATHER_REPORT_LIGHTNING_CAST;
    public static final RegistryObject<SoundEvent> WEATHER_REPORT_CHANGE_WEATHER;
    public static final RegistryObject<SoundEvent> WEATHER_REPORT_PUFFERFISH_RAIN;
    public static final Supplier<SoundEvent> PUFFERFISH_SPLASH;
    static final OstSoundList WEATHER_REPORT_OST;

    public InitSounds() {
    }

    static {
        SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, "rotp_wr");
        WEATHER_REPORT = SOUNDS.register("weather_report", () -> {
            return new SoundEvent(new ResourceLocation("rotp_wr", "weather_report"));
        });
        WEATHER_REPORT_USER_UNSUMMON = SOUNDS.register("weather_report_user_retract", () -> {
            return new SoundEvent(new ResourceLocation("rotp_wr", "weather_report_user_retract"));
        });
        WEATHER_REPORT_USER_CLOUD_SHIELD = SOUNDS.register("weather_report_user_cloud_shield_cast", () -> {
            return new SoundEvent(new ResourceLocation("rotp_wr", "weather_report_user_cloud_shield_cast"));
        });
        WEATHER_REPORT_USER_PUFFERFISH_RAIN_CAST = SOUNDS.register("weather_report_user_fugu_rain_sound", () -> {
            return new SoundEvent(new ResourceLocation("rotp_wr", "weather_report_user_fugu_rain_sound"));
        });
        WEATHER_REPORT_USER_HEAVY_PUNCH = SOUNDS.register("weather_report_user_heavy_punch", () -> {
            return new SoundEvent(new ResourceLocation("rotp_wr", "weather_report_user_heavy_punch"));
        });
        WEATHER_REPORT_USER_PUNCH = SOUNDS.register("weather_report_user_light_punch", () -> {
            return new SoundEvent(new ResourceLocation("rotp_wr", "weather_report_user_light_punch"));
        });
        WEATHER_REPORT_USER_LIGHTNING = SOUNDS.register("weather_report_user_lightning_cast", () -> {
            return new SoundEvent(new ResourceLocation("rotp_wr", "weather_report_user_lightning_cast"));
        });
        WEATHER_REPORT_SUMMON = SOUNDS.register("weather_report_summon", () -> {
            return new SoundEvent(new ResourceLocation("rotp_wr", "weather_report_summon"));
        });
        WEATHER_REPORT_UNSUMMON = SOUNDS.register("weather_report_unsummon", () -> {
            return new SoundEvent(new ResourceLocation("rotp_wr", "weather_report_unsummon"));
        });
        WEATHER_REPORT_PUNCH_SWING = SOUNDS.register("weather_report_swing_sound", () -> {
            return new SoundEvent(new ResourceLocation("rotp_wr", "weather_report_swing_sound"));
        });
        WEATHER_REPORT_PUNCH_LIGHT = SOUNDS.register("weather_report_punch", () -> {
            return new SoundEvent(new ResourceLocation("rotp_wr", "weather_report_punch"));
        });
        WEATHER_REPORT_PUNCH_HEAVY = SOUNDS.register("weather_report_heavy_punch", () -> {
            return new SoundEvent(new ResourceLocation("rotp_wr", "weather_report_heavy_punch"));
        });
        WEATHER_REPORT_BARRAGE = WEATHER_REPORT_PUNCH_LIGHT;
        WEATHER_REPORT_AIR_FRICTION_PUNCH = SOUNDS.register("weather_report_finisher", () -> {
            return new SoundEvent(new ResourceLocation("rotp_wr", "weather_report_finisher"));
        });
        WEATHER_REPORT_WIND = SOUNDS.register("weather_report_wind_sound", () -> {
            return new SoundEvent(new ResourceLocation("rotp_wr", "weather_report_wind_sound"));
        });
        WEATHER_REPORT_COLD_WIND = SOUNDS.register("weather_report_cold_wind_sound", () -> {
            return new SoundEvent(new ResourceLocation("rotp_wr", "weather_report_cold_wind_sound"));
        });
        WEATHER_REPORT_CLOUD_SHIELD = SOUNDS.register("weather_report_cloud_shield", () -> {
            return new SoundEvent(new ResourceLocation("rotp_wr", "weather_report_cloud_shield"));
        });
        WEATHER_REPORT_LIGHTNING_CAST = SOUNDS.register("weather_report_lightning_cast", () -> {
            return new SoundEvent(new ResourceLocation("rotp_wr", "weather_report_lightning_cast"));
        });
        WEATHER_REPORT_CHANGE_WEATHER = SOUNDS.register("weather_report_change_weather_sound", () -> {
            return new SoundEvent(new ResourceLocation("rotp_wr", "weather_report_change_weather_sound"));
        });
        WEATHER_REPORT_PUFFERFISH_RAIN = SOUNDS.register("weather_report_fugu_cast_sound", () -> {
            return new SoundEvent(new ResourceLocation("rotp_wr", "weather_report_fugu_cast_sound"));
        });
        PUFFERFISH_SPLASH = SOUNDS.register("weather_report_fugu_splash_sound", () -> {
            return new SoundEvent(new ResourceLocation("rotp_wr", "weather_report_fugu_splash_sound"));
        });
        WEATHER_REPORT_OST = new OstSoundList(new ResourceLocation("rotp_wr", "weather_report_ost"), SOUNDS);
    }
}

