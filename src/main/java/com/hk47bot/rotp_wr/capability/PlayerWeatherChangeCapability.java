package com.hk47bot.rotp_wr.capability;

import com.hk47bot.rotp_wr.client.ui.weather.WeatherChangeMenu;
import net.minecraft.entity.player.PlayerEntity;

public class PlayerWeatherChangeCapability  {
    private PlayerEntity player;
    private WeatherChangeMenu.WeatherType currentWeatherType;
    public PlayerWeatherChangeCapability(PlayerEntity player){
        this.player = player;
    }
    public void setCurrentWeatherType(WeatherChangeMenu.WeatherType newType){
        this.currentWeatherType = newType;
    }
    public WeatherChangeMenu.WeatherType getCurrentWeatherType(){
        return currentWeatherType;
    }

    public void onTracking(PlayerEntity player){
        player = this.player;
    }
}
