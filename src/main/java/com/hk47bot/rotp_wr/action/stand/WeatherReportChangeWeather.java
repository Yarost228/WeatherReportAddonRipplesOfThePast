package com.hk47bot.rotp_wr.action.stand;

import com.github.standobyte.jojo.action.ActionTarget;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.entity.stand.StandPose;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;

import com.hk47bot.rotp_wr.RotpWeatherReportAddon;
import com.hk47bot.rotp_wr.capability.PlayerWeatherChangeCapabilityProvider;
import com.hk47bot.rotp_wr.entity.stand.stands.WeatherReportEntity;
import corgitaco.betterweather.helpers.BetterWeatherWorldData;
import corgitaco.betterweather.weather.BWWeatherEventContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.ModList;

import java.util.Random;

public class WeatherReportChangeWeather extends StandEntityAction {
    public static final StandPose WEATHER_CHANGE_POSE = new StandPose("WR_WEATHERCHANGE");

    public WeatherReportChangeWeather(StandEntityAction.Builder builder) {
        super(builder);
    }
    private static final Random RANDOM = new Random();

    @Override
    public void standPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        int rainTime = RANDOM.nextInt(12000) + 3600;
        int clearTime = RANDOM.nextInt(168000) + 12000;
        if (!ModList.get().isLoaded("betterweather")) {
            if (!world.isClientSide()) {
                if (!world.isRaining()) {
                    ((ServerWorld) world).setWeatherParameters(0, rainTime, true, false);
                } else {
                    ((ServerWorld) world).setWeatherParameters(clearTime, 0, false, false);
                }
            }
        }
        else {
            if (!world.isClientSide()){
                ServerWorld serverWorld = (ServerWorld)world;
                BWWeatherEventContext weatherEventContext = ((BetterWeatherWorldData) serverWorld).getWeatherEventContext();
                RotpWeatherReportAddon.getLogger().info(weatherEventContext != null);
                if (weatherEventContext != null) {
                    PlayerEntity player = (PlayerEntity) userPower.getUser();
                    RotpWeatherReportAddon.getLogger().info(player.getCapability(PlayerWeatherChangeCapabilityProvider.CAPABILITY).isPresent());
                    player.getCapability(PlayerWeatherChangeCapabilityProvider.CAPABILITY).ifPresent(cap -> {
                        RotpWeatherReportAddon.getLogger().info("Capability is present");
                        String weatherType = cap.getCurrentWeatherType();
                        RotpWeatherReportAddon.getLogger().info(weatherType);
                        weatherEventContext.setWeatherForced(true);
                        weatherEventContext.weatherForcer(weatherType, rainTime, serverWorld);
                    });
                }
            }
        }
    }
}
