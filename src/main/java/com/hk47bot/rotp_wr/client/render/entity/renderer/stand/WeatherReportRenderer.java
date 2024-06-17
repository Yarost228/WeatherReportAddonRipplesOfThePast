package com.hk47bot.rotp_wr.client.render.entity.renderer.stand;

import com.hk47bot.rotp_wr.RotpWeatherReportAddon;
import com.hk47bot.rotp_wr.client.render.entity.model.stand.WeatherReportModel;
import com.hk47bot.rotp_wr.entity.stand.stands.WeatherReportEntity;
import com.github.standobyte.jojo.client.render.entity.renderer.stand.StandEntityRenderer;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class WeatherReportRenderer extends StandEntityRenderer<WeatherReportEntity, WeatherReportModel> {
    public WeatherReportRenderer(EntityRendererManager renderManager) {
        super(renderManager, new WeatherReportModel(), new ResourceLocation(RotpWeatherReportAddon.MOD_ID, "textures/entity/stand/weather_report.png"), 0);
    }
}
