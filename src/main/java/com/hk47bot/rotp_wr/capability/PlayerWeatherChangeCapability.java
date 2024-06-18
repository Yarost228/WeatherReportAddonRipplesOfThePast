package com.hk47bot.rotp_wr.capability;

import net.minecraft.entity.player.PlayerEntity;

import java.util.Optional;

public class PlayerWeatherChangeCapability  {
    private PlayerEntity player;
    private String currentWeatherType;
    private String previousWeatherType;
    public PlayerWeatherChangeCapability(PlayerEntity player){
        this.player = player;
    }
    public void setCurrentWeatherType(String newType){
        this.previousWeatherType = this.currentWeatherType;
        this.currentWeatherType = newType;
        System.out.println("Weather changed to:" + currentWeatherType);
    }
    public String getCurrentWeatherType(){
        return currentWeatherType;
    }
    public String getPreviousWeatherType(){
        return previousWeatherType;
    }

}
