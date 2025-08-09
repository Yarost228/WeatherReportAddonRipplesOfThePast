package com.hk47bot.rotp_wr.action.stand;

import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.entity.stand.StandPose;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;

import com.hk47bot.rotp_wr.client.ui.weather.BetterWeatherChangeMenu;
import com.hk47bot.rotp_wr.client.ui.weather.VanillaWeatherChangeMenu;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.ModList;

public class WeatherReportChangeWeather extends StandEntityAction {
    public static final StandPose WEATHER_CHANGE_POSE = new StandPose("WR_WEATHERCHANGE");

    public WeatherReportChangeWeather(StandEntityAction.Builder builder) {
        super(builder);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void standPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task){
        if(world.isClientSide && userPower.getUser() == com.github.standobyte.jojo.client.ClientUtil.getClientPlayer()){
            if (ModList.get().isLoaded("betterweather")){
                BetterWeatherChangeMenu.openWindowOnClick(userPower.getUser());
            }
            else {
                VanillaWeatherChangeMenu.openWindowOnClick(userPower.getUser());
            }
        }
    }
}
