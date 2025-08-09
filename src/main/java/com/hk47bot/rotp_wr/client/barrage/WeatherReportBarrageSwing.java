package com.hk47bot.rotp_wr.client.barrage;

import com.github.standobyte.jojo.client.render.entity.model.stand.StandEntityModel;
import com.github.standobyte.jojo.client.render.entity.pose.anim.barrage.IBarrageAnimation;
import com.github.standobyte.jojo.client.render.entity.pose.anim.barrage.StandArmBarrageSwing;
import com.hk47bot.rotp_wr.client.render.entity.model.stand.WeatherReportModel;
import com.hk47bot.rotp_wr.entity.stand.stands.WeatherReportEntity;
import net.minecraft.util.HandSide;


public class WeatherReportBarrageSwing<T extends WeatherReportEntity, M extends StandEntityModel<T>> extends StandArmBarrageSwing<T, M> {

    public WeatherReportBarrageSwing(IBarrageAnimation<T, M> barrageAnim, float ticks, float ticksMax, HandSide side, double maxOffset) {
        super(barrageAnim, ticks, ticksMax, side, maxOffset);
    }
    @Override
    protected void setArmOnlyModelVisibility(T entity, M model, HandSide side) {
        WeatherReportModel weatherReportModel = (WeatherReportModel) model;
        weatherReportModel.setVisibility(entity, WeatherReportModel.VisibilityMode.ALL, true);
        weatherReportModel.getClouds().visible = false;
    }
}
