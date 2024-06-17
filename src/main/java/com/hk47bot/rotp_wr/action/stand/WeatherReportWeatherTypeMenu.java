package com.hk47bot.rotp_wr.action.stand;

import com.github.standobyte.jojo.action.ActionTarget;
import com.github.standobyte.jojo.action.stand.StandAction;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.hk47bot.rotp_wr.client.ui.weather.WeatherChangeMenu;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;

public class WeatherReportWeatherTypeMenu extends StandAction {
    public WeatherReportWeatherTypeMenu(StandAction.Builder builder){super(builder);}
    protected void perform(World world, LivingEntity user, IStandPower power, ActionTarget target) {
        if (world.isClientSide()){
            WeatherChangeMenu.openWindowOnClick();
        }
    }
}
