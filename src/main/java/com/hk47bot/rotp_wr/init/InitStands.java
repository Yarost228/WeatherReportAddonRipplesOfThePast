package com.hk47bot.rotp_wr.init;

import com.github.standobyte.jojo.action.Action;
import com.github.standobyte.jojo.action.stand.StandAction;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.action.stand.StandEntityBlock;
import com.github.standobyte.jojo.action.stand.StandEntityHeavyAttack;
import com.github.standobyte.jojo.action.stand.StandEntityLightAttack;
import com.github.standobyte.jojo.action.stand.StandEntityMeleeBarrage;
import com.github.standobyte.jojo.entity.stand.StandEntityType;
import com.github.standobyte.jojo.entity.stand.StandPose;
import com.github.standobyte.jojo.init.power.stand.EntityStandRegistryObject;
import com.github.standobyte.jojo.init.power.stand.ModStandsInit;
import com.github.standobyte.jojo.power.impl.stand.StandInstance.StandPart;
import com.github.standobyte.jojo.power.impl.stand.stats.StandStats;
import com.github.standobyte.jojo.power.impl.stand.type.EntityStandType;
import com.github.standobyte.jojo.power.impl.stand.type.StandType;
import com.hk47bot.rotp_wr.RotpWeatherReportAddon;
import com.hk47bot.rotp_wr.action.stand.*;
import com.hk47bot.rotp_wr.entity.stand.stands.WeatherReportEntity;

import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

public class InitStands {
    @SuppressWarnings("unchecked")
    public static final DeferredRegister<Action<?>> ACTIONS = DeferredRegister.create(
            (Class<Action<?>>) ((Class<?>) Action.class), RotpWeatherReportAddon.MOD_ID);
    @SuppressWarnings("unchecked")
    public static final DeferredRegister<StandType<?>> STANDS = DeferredRegister.create(
            (Class<StandType<?>>) ((Class<?>) StandType.class), RotpWeatherReportAddon.MOD_ID);
    
 // ======================================== Weather Report ========================================
    
    public static final RegistryObject<StandEntityAction> WEATHER_REPORT_PUNCH = ACTIONS.register("weather_report_punch", 
            () -> new StandEntityLightAttack(new StandEntityLightAttack.Builder()
                    .shout(InitSounds.WEATHER_REPORT_USER_PUNCH)
                    .swingSound(InitSounds.WEATHER_REPORT_PUNCH_SWING)
                    .punchSound(InitSounds.WEATHER_REPORT_PUNCH_LIGHT)));
    
    public static final RegistryObject<StandEntityAction> WEATHER_REPORT_BARRAGE = ACTIONS.register("weather_report_barrage", 
            () -> new StandEntityMeleeBarrage(new StandEntityMeleeBarrage.Builder()
                    .barrageSwingSound(InitSounds.WEATHER_REPORT_PUNCH_SWING)
                    .barrageHitSound(InitSounds.WEATHER_REPORT_PUNCH_LIGHT)));
    
    public static final RegistryObject<StandEntityHeavyAttack> WEATHER_REPORT_FINISHER = ACTIONS.register("weather_report_finisher", 
            () -> new WeatherReportAerodynamicFrictionPunch(new StandEntityHeavyAttack.Builder()
                    .partsRequired(StandPart.ARMS)
                    .swingSound(InitSounds.WEATHER_REPORT_PUNCH_SWING)
                    .punchSound(InitSounds.WEATHER_REPORT_AIR_FRICTION_PUNCH)));

    public static final RegistryObject<StandEntityHeavyAttack> WEATHER_REPORT_HEAVY_PUNCH = ACTIONS.register("weather_report_heavy_punch", 
            () -> new StandEntityHeavyAttack(new StandEntityHeavyAttack.Builder()
                    .shout(InitSounds.WEATHER_REPORT_USER_HEAVY_PUNCH)
                    .swingSound(InitSounds.WEATHER_REPORT_PUNCH_SWING)
                    .punchSound(InitSounds.WEATHER_REPORT_PUNCH_HEAVY)
                    .shiftVariationOf(WEATHER_REPORT_PUNCH)
                    .shiftVariationOf(WEATHER_REPORT_BARRAGE)
                    .setFinisherVariation(WEATHER_REPORT_FINISHER)
                    .partsRequired(StandPart.ARMS)));

    public static final RegistryObject<StandEntityAction> WEATHER_REPORT_CLOUD_SHIELD = ACTIONS.register("weather_report_cloud_shield",
            () -> new WeatherReportCloudShield(new StandEntityAction.Builder()
                    .cooldown(20)
                    .shout(InitSounds.WEATHER_REPORT_USER_CLOUD_SHIELD)));

        public static final RegistryObject<StandEntityAction> WEATHER_REPORT_WIND = ACTIONS.register("weather_report_wind", 
            () -> new WeatherReportWind(new StandEntityAction.Builder()
                    .holdType(80)
                    .staminaCostTick(2F)
                    .cooldown(120)
                    .standPose(WeatherReportWind.WIND_BLOW)
                    .standOffsetFromUser(0, 1.5).standSound(InitSounds.WEATHER_REPORT_WIND)
                    .partsRequired(StandPart.ARMS)));

        public static final RegistryObject<StandEntityAction> WEATHER_REPORT_COLD_WIND = ACTIONS.register("weather_report_cold_wind", 
            () -> new WeatherReportColdWind(new StandEntityAction.Builder()
                    .holdType(80)
                    .staminaCostTick(3F)
                    .cooldown(160)
                    .shiftVariationOf(WEATHER_REPORT_WIND)
                    .resolveLevelToUnlock(1)
                    .standPose(WeatherReportWind.WIND_BLOW)
                    .standOffsetFromUser(0, 1).standSound(InitSounds.WEATHER_REPORT_COLD_WIND)
                    .partsRequired(StandPart.MAIN_BODY)));


       public static final RegistryObject<WeatherReportLightning> WEATHER_REPORT_LIGHTNING = ACTIONS.register("weather_report_lightning", 
            () -> new WeatherReportLightning(new StandEntityAction.Builder()
                    .cooldown(60)
                    .staminaCostTick(75F)
                    .standPose(StandPose.RANGED_ATTACK)
                    .standSound(StandEntityAction.Phase.BUTTON_HOLD, InitSounds.WEATHER_REPORT_LIGHTNING_CAST)
                    .shout(InitSounds.WEATHER_REPORT_USER_LIGHTNING)
                    .resolveLevelToUnlock(2)
                    .holdToFire(40, false)
                    .partsRequired(StandPart.MAIN_BODY)));

        public static final RegistryObject<WeatherReportChangeWeather> WEATHER_REPORT_CHANGE_WEATHER = ACTIONS.register("weather_report_change_weather", 
            () -> new WeatherReportChangeWeather(new StandEntityAction.Builder()
                    .cooldown(1200)
                    .staminaCostTick(75F)
                    .standSound(StandEntityAction.Phase.BUTTON_HOLD, InitSounds.WEATHER_REPORT_CHANGE_WEATHER)
                    .holdToFire(30, false)
                    .standPose(WeatherReportChangeWeather.WEATHER_CHANGE_POSE)
                    .resolveLevelToUnlock(3)
                    .partsRequired(StandPart.MAIN_BODY)));
            
        public static final RegistryObject<StandEntityAction> WEATHER_REPORT_FUGU_RAIN = ACTIONS.register("weather_report_fugu_rain", 
            () -> new WeatherReportFuguRain(new StandEntityAction.Builder().cooldown(720).shiftVariationOf(WEATHER_REPORT_CHANGE_WEATHER)
                    .shout(InitSounds.WEATHER_REPORT_USER_PUFFERFISH_RAIN_CAST)
                    .standSound(InitSounds.WEATHER_REPORT_PUFFERFISH_RAIN)
                    .holdToFire(30, false)
                    .resolveLevelToUnlock(3)
                    .standPose(WeatherReportChangeWeather.WEATHER_CHANGE_POSE)
                    .partsRequired(StandPart.MAIN_BODY)));

    public static final RegistryObject<StandEntityAction> WEATHER_REPORT_ICICLE_STRIKE = ACTIONS.register("weather_report_icicle_strike",
            () -> new WeatherReportIcicleStrike(new StandEntityAction.Builder().staminaCost(375).standPerformDuration(30).cooldown(10, 100)
                    .resolveLevelToUnlock(2)
                    .standOffsetFront().standPose(StandPose.RANGED_ATTACK)
                    .standSound(InitSounds.WEATHER_REPORT_PUNCH_SWING).standOffsetFromUser(0.2, 0.5)
                    .partsRequired(StandPart.ARMS)));
    
    public static final RegistryObject<StandEntityAction> WEATHER_REPORT_BLOCK = ACTIONS.register("weather_report_block",
            StandEntityBlock::new);

    public static final RegistryObject<StandAction> WEATHER_REPORT_GIVE_CLOUD_SHIELD = ACTIONS.register("weather_report_give_cloud_shield",
            () -> new WeatherReportGiveCloudShield(new StandAction.Builder()
                    .staminaCost(400)
                    .cooldown(1300)
                    .shout(InitSounds.WEATHER_REPORT)
                    .shiftVariationOf(InitStands.WEATHER_REPORT_CLOUD_SHIELD)));

    
    public static final EntityStandRegistryObject<EntityStandType<StandStats>, StandEntityType<WeatherReportEntity>> STAND_WEATHER_REPORT = 
            new EntityStandRegistryObject<>("weather_report", 
                    STANDS, 
                    () -> new EntityStandType<StandStats>(
                            0xB8CEE5, ModStandsInit.PART_6_NAME,

                            new StandAction[] {
                                    WEATHER_REPORT_PUNCH.get(),
                                    WEATHER_REPORT_BARRAGE.get(),
                                    WEATHER_REPORT_LIGHTNING.get(),
                                    WEATHER_REPORT_ICICLE_STRIKE.get()
                                    },
                            new StandAction[] {
                                    WEATHER_REPORT_BLOCK.get(),
                                    WEATHER_REPORT_CLOUD_SHIELD.get(),
                                    WEATHER_REPORT_WIND.get(),
                                    WEATHER_REPORT_CHANGE_WEATHER.get()
                                    },

                            StandStats.class, new StandStats.Builder()
                            .tier(6)
                            .power(14.0)
                            .speed(12.0)
                            .range(2.0, 10.0)
                            .durability(16.0)
                            .precision(4.0)
                            .build("Weather Report"),

                            new StandType.StandTypeOptionals()
                            .addSummonShout(InitSounds.WEATHER_REPORT)
                            .addOst(InitSounds.WEATHER_REPORT_OST)),

                    InitEntities.ENTITIES, 
                    () -> new StandEntityType<>(WeatherReportEntity::new, 0.7F, 2.1F)
                    .summonSound(InitSounds.WEATHER_REPORT_SUMMON)
                    .unsummonSound(InitSounds.WEATHER_REPORT_UNSUMMON))
            .withDefaultStandAttributes();
}
