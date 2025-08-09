package com.hk47bot.rotp_wr.client.barrage;

import com.github.standobyte.jojo.client.render.entity.model.stand.StandEntityModel;
import com.github.standobyte.jojo.client.render.entity.pose.IModelPose;
import com.github.standobyte.jojo.client.render.entity.pose.anim.barrage.BarrageSwingsHolder;
import com.github.standobyte.jojo.client.render.entity.pose.anim.barrage.StandTwoHandedBarrageAnimation;
import com.hk47bot.rotp_wr.client.render.entity.model.stand.WeatherReportModel;
import com.hk47bot.rotp_wr.entity.stand.stands.WeatherReportEntity;
import net.minecraft.util.HandSide;

public class WeatherReportBarrageAnimation<T extends WeatherReportEntity> extends StandTwoHandedBarrageAnimation<T> {
    public WeatherReportBarrageAnimation(StandEntityModel<T> model, IModelPose<T> loop,
                                          IModelPose<T> recovery) {
        super(model, loop, recovery);
    }
    @Override
    protected void addSwing(T entity, BarrageSwingsHolder<T, StandEntityModel<T>> swings, HandSide side, float f,
                            double maxOffset) {
        swings.addSwing(new WeatherReportBarrageSwing<>(this, f, getLoopLen(), side, maxOffset));
        WeatherReportModel weatherReportModel = (WeatherReportModel) model;
        weatherReportModel.getClouds().visible = true;
    }
}
