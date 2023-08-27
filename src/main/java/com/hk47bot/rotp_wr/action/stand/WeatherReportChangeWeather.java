package com.hk47bot.rotp_wr.action.stand;

import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.entity.stand.StandPose;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.LogicalSidedProvider;

public class WeatherReportChangeWeather extends StandEntityAction {
    public static final StandPose WEATHER_CHANGE_POSE = new StandPose("WR_WEATHERCHANGE");

    public WeatherReportChangeWeather(StandEntityAction.Builder builder) {
        super(builder);
}
   @Override
    
    public void standPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        if (!world.isClientSide()) {
            MinecraftServer source = LogicalSidedProvider.INSTANCE.get(LogicalSide.SERVER);
            if (!world.isRaining()) {
            source.getCommands().performCommand(source.createCommandSourceStack(), "weather rain");
            }
            else {
                source.getCommands().performCommand(source.createCommandSourceStack(), "weather clear");
            }
        }
    }
}