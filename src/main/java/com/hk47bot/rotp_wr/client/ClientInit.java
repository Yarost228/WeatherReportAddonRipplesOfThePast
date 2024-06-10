package com.hk47bot.rotp_wr.client;

import com.hk47bot.rotp_wr.RotpWeatherReportAddon;
import com.hk47bot.rotp_wr.client.render.entity.renderer.FugaProjectileRenderer;
import com.hk47bot.rotp_wr.client.render.entity.renderer.FugaSummonerEntityRenderer;
import com.hk47bot.rotp_wr.client.render.entity.renderer.stand.WeatherReportRenderer;
import com.hk47bot.rotp_wr.init.AddonStands;
import com.hk47bot.rotp_wr.init.InitEntities;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = RotpWeatherReportAddon.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientInit {
    
    @SubscribeEvent
    public static void onFMLClientSetup(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(AddonStands.WEATHER_REPORT.getEntityType(), WeatherReportRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(InitEntities.FUGU_SUMMONER.get(), FugaSummonerEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(InitEntities.FUGU_PROJECTILE.get(), FugaProjectileRenderer::new);
    }
}
