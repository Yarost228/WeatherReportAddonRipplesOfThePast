package com.hk47bot.rotp_wr.client.ui.weather;

import com.hk47bot.rotp_wr.RotpWeatherReportAddon;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

public class WeatherIcon {
    private static final ResourceLocation UNKNOWN = new ResourceLocation(RotpWeatherReportAddon.MOD_ID, "textures/weather_icon/unknown");
    private static final ResourceLocation CLEAR = new ResourceLocation(RotpWeatherReportAddon.MOD_ID, "textures/weather_icon/clear");
    private static final ResourceLocation RAIN = new ResourceLocation(RotpWeatherReportAddon.MOD_ID, "textures/weather_icon/rain");
    private static final ResourceLocation THUNDERING = new ResourceLocation(RotpWeatherReportAddon.MOD_ID, "textures/weather_icon/thunder");
    private static final ResourceLocation CLOUDY = new ResourceLocation(RotpWeatherReportAddon.MOD_ID, "textures/weather_icon/betterweather/cloudy");
    private static final ResourceLocation CLOUDY_THUNDERING = new ResourceLocation(RotpWeatherReportAddon.MOD_ID, "textures/weather_icon//betterweather/cloudy_thundering");
    private static final ResourceLocation BLIZZARD = new ResourceLocation(RotpWeatherReportAddon.MOD_ID, "textures/weather_icon/betterweather/blizzard");
    private static final ResourceLocation BLIZZARD_THUNDERING = new ResourceLocation(RotpWeatherReportAddon.MOD_ID, "textures/weather_icon/betterweather/blizzard_thundering");
    private static final ResourceLocation ACID_RAIN = new ResourceLocation(RotpWeatherReportAddon.MOD_ID, "textures/weather_icon/betterweather/acid_rain");
    private static final ResourceLocation ACID_RAIN_THUNDERING = new ResourceLocation(RotpWeatherReportAddon.MOD_ID, "textures/weather_icon/betterweather/acid_rain_thundering");
    public static void renderIcon(WeatherChangeMenu.WeatherType type, MatrixStack matrixStack, float x, float y){
        ResourceLocation icon = getIconByType(type);
        if (icon != UNKNOWN){
            Minecraft.getInstance().getTextureManager().bind(icon);
            BlitFloat.blitFloat(matrixStack, x, y, 0, 0, 16, 16, 16, 16);
        }
    }
    public static ResourceLocation getIconByType(WeatherChangeMenu.WeatherType type){
        switch (type){
            case CLEAR:
                return CLEAR;
            case RAIN:
                return RAIN;
            case THUNDERING:
                return THUNDERING;
            case CLOUDY:
                return CLOUDY;
            case CLOUDY_THUNDERING:
                return CLOUDY_THUNDERING;
            case BLIZZARD:
                return BLIZZARD;
            case BLIZZARD_THUNDERING:
                return BLIZZARD_THUNDERING;
            case ACID_RAIN:
                return ACID_RAIN;
            case ACID_RAIN_THUNDERING:
                return ACID_RAIN_THUNDERING;
            default:
                return UNKNOWN;
        }
    }
}
