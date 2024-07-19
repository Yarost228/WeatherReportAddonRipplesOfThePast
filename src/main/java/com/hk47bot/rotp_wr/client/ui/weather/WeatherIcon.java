package com.hk47bot.rotp_wr.client.ui.weather;

import com.hk47bot.rotp_wr.RotpWeatherReportAddon;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;;
import net.minecraft.util.ResourceLocation;

import static net.minecraft.client.gui.AbstractGui.blit;


public class WeatherIcon {
    private static final ResourceLocation WEATHER_CHANGE_GUI = new ResourceLocation(RotpWeatherReportAddon.MOD_ID, "textures/gui/vanilla_weather_change_gui.png");
    private static final ResourceLocation BETTER_WEATHER_CHANGE_GUI = new ResourceLocation(RotpWeatherReportAddon.MOD_ID, "textures/gui/better_weather_change_gui.png");
        public static void renderIcon(BetterWeatherChangeMenu.WeatherType type, MatrixStack matrixStack, int x, int y){
        Minecraft.getInstance().getTextureManager().bind(BETTER_WEATHER_CHANGE_GUI);
        blit(matrixStack, x, y, getUByBetterWeatherType(type), getVByBetterWeatherType(type), 25, 25, 128, 128);
    }
    public static void renderVanillaIcon(VanillaWeatherChangeMenu.WeatherType type,  MatrixStack matrixStack, int x, int y){
        Minecraft.getInstance().getTextureManager().bind(WEATHER_CHANGE_GUI);
        blit(matrixStack, x,y, getUByVanillaWeatherType(type), getVByVanillaWeatherType(type), 25, 25, 128, 128);
    }
    public static int getUByVanillaWeatherType(VanillaWeatherChangeMenu.WeatherType type){
        switch (type){
            case CLEAR:
            case RAIN:
                return 3;
            case THUNDERING:
                return 2;
            default:
                return 0;
        }
    }
    public static int getVByVanillaWeatherType(VanillaWeatherChangeMenu.WeatherType type){
        switch (type){
            case CLEAR:
                return 48;
            case RAIN:
                return 71;
            case THUNDERING:
                return 26;
            default:
                return 0;
        }
    }
    public static int getUByBetterWeatherType(BetterWeatherChangeMenu.WeatherType type){
        switch (type){
            case CLEAR:
            case RAIN:
                return 3;
            case THUNDERING:
                return 2;
            case CLOUDY:
                return 35;
            case CLOUDY_THUNDERING:
                return 34;
            case BLIZZARD:
                return 99;
            case BLIZZARD_THUNDERING:
                return 98;
            case ACID_RAIN:
                return 67;
            case ACID_RAIN_THUNDERING:
                return 66;
            default:
                return 0;
        }
    }
    public static int getVByBetterWeatherType(BetterWeatherChangeMenu.WeatherType type){
        switch (type){
            case CLEAR:
                return 48;
            case RAIN:
            case ACID_RAIN:
            case BLIZZARD:
            case CLOUDY:
                return 71;
            case THUNDERING:
            case ACID_RAIN_THUNDERING:
            case BLIZZARD_THUNDERING:
            case CLOUDY_THUNDERING:
                return 26;
            default:
                return 0;
        }
    }
}
