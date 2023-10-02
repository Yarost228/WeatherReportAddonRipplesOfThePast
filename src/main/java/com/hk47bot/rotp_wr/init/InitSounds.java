package com.hk47bot.rotp_wr.init;

import java.util.function.Supplier;

import com.github.standobyte.jojo.init.ModSounds;
import com.github.standobyte.jojo.util.mc.OstSoundList;
import com.hk47bot.rotp_wr.RotpWeatherReportAddon;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class InitSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, RotpWeatherReportAddon.MOD_ID);
    
    public static final RegistryObject<SoundEvent> WEATHER_REPORT = SOUNDS.register("weather_report", 
            () -> new SoundEvent(new ResourceLocation(RotpWeatherReportAddon.MOD_ID, "weather_report")));

    public static final Supplier<SoundEvent> WEATHER_REPORT_SUMMON = ModSounds.STAND_SUMMON_DEFAULT;
    
    public static final Supplier<SoundEvent> WEATHER_REPORT_UNSUMMON = ModSounds.STAND_UNSUMMON_DEFAULT;
    
    public static final Supplier<SoundEvent> WEATHER_REPORT_PUNCH_LIGHT = ModSounds.STAND_PUNCH_LIGHT;
    
    public static final Supplier<SoundEvent> WEATHER_REPORT_PUNCH_HEAVY = ModSounds.STAND_PUNCH_HEAVY;
    
    public static final Supplier<SoundEvent> WEATHER_REPORT_BARRAGE = ModSounds.STAND_PUNCH_LIGHT;

    public static final RegistryObject<SoundEvent> WEATHER_REPORT_WIND = SOUNDS.register("weather_report_wind_sound", 
            () -> new SoundEvent(new ResourceLocation(RotpWeatherReportAddon.MOD_ID, "weather_report_wind_sound")));

    public static final RegistryObject<SoundEvent> WEATHER_REPORT_COLD_WIND = SOUNDS.register("weather_report_cold_wind_sound", 
            () -> new SoundEvent(new ResourceLocation(RotpWeatherReportAddon.MOD_ID, "weather_report_cold_wind_sound")));

    public static final RegistryObject<SoundEvent> WEATHER_REPORT_LIGHTNING = SOUNDS.register("weather_report_lightning_sound", 
            () -> new SoundEvent(new ResourceLocation(RotpWeatherReportAddon.MOD_ID, "weather_report_lightning_sound")));

    public static final RegistryObject<SoundEvent> WEATHER_REPORT_CHANGE_WEATHER = SOUNDS.register("weather_report_change_weather_sound", 
            () -> new SoundEvent(new ResourceLocation(RotpWeatherReportAddon.MOD_ID, "weather_report_change_weather_sound")));

         public static final RegistryObject<SoundEvent> WEATHER_REPORT_PUFFERFISH_RAIN = SOUNDS.register("weather_report_fugu_rain_sound", 
            () -> new SoundEvent(new ResourceLocation(RotpWeatherReportAddon.MOD_ID, "weather_report_fugu_rain_sound")));   

    static final OstSoundList WEATHER_REPORT_OST = new OstSoundList(new ResourceLocation(RotpWeatherReportAddon.MOD_ID, "weather_report_ost"), SOUNDS);


}
