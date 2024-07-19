package com.hk47bot.rotp_wr.client.barrage;

import com.github.standobyte.jojo.client.render.entity.model.stand.StandEntityModel;
import com.github.standobyte.jojo.client.render.entity.pose.anim.barrage.ArmBarrageSwing;
import com.github.standobyte.jojo.client.render.entity.pose.anim.barrage.IBarrageAnimation;
import com.hk47bot.rotp_wr.client.render.entity.model.stand.WeatherReportModel;
import com.hk47bot.rotp_wr.entity.stand.stands.WeatherReportEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.HandSide;


public class WeatherReportBarrageSwing<T extends WeatherReportEntity, M extends StandEntityModel<T>> extends ArmBarrageSwing<T, M> {

    public WeatherReportBarrageSwing(IBarrageAnimation<T, M> barrageAnim, float ticks, float ticksMax, HandSide side, double maxOffset) {
        super(barrageAnim, ticks, ticksMax, side, maxOffset);
    }
    @Override
    protected void setArmOnlyModelVisibility(T entity, M model, HandSide side) {
        WeatherReportModel weatherReportModel = (WeatherReportModel) model;
        weatherReportModel.setVisibility(entity, WeatherReportModel.VisibilityMode.ARMS_ONLY, false);
        weatherReportModel.getClouds().visible = false;
    }
    @Override
    public void poseAndRender(T entity, M model, MatrixStack matrixStack, IVertexBuilder buffer,
                              float yRotOffsetRad, float xRotRad,
                              int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        super.poseAndRender(entity, model, matrixStack, buffer, yRotOffsetRad, xRotRad, packedLight, packedOverlay, red, green, blue, alpha);
        setArmOnlyModelVisibility(entity, model, getSide());
    }
}
