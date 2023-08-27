package com.hk47bot.rotp_wr.init;

import com.github.standobyte.jojo.entity.stand.StandEntityType;
import com.github.standobyte.jojo.init.power.stand.EntityStandRegistryObject.EntityStandSupplier;
import com.github.standobyte.jojo.power.impl.stand.stats.StandStats;
import com.github.standobyte.jojo.power.impl.stand.type.EntityStandType;
import com.hk47bot.rotp_wr.entity.stand.stands.WeatherReportEntity;

public class AddonStands {

    public static final EntityStandSupplier<EntityStandType<StandStats>, StandEntityType<WeatherReportEntity>> 
    WEATHER_REPORT = new EntityStandSupplier<>(InitStands.STAND_WEATHER_REPORT);
}
