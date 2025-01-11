package com.hk47bot.rotp_wr.client;

import com.hk47bot.rotp_wr.RotpWeatherReportAddon;
import com.hk47bot.rotp_wr.client.render.entity.model.layer.CloudsModel;
import com.hk47bot.rotp_wr.client.render.entity.renderer.FugaProjectileRenderer;
import com.hk47bot.rotp_wr.client.render.entity.renderer.FugaSummonerEntityRenderer;
import com.hk47bot.rotp_wr.client.render.entity.renderer.IcicleExtendingProjectileRenderer;
import com.hk47bot.rotp_wr.client.render.entity.renderer.layer.WeatherReportEffectCloudLayer;
import com.hk47bot.rotp_wr.client.render.entity.renderer.stand.WeatherReportRenderer;
import com.hk47bot.rotp_wr.client.render.particle.ReverseAirStreamParticle;
import com.hk47bot.rotp_wr.init.AddonStands;
import com.hk47bot.rotp_wr.init.InitBlocks;
import com.hk47bot.rotp_wr.init.InitEntities;

import com.hk47bot.rotp_wr.init.InitParticles;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.Map;

@EventBusSubscriber(modid = RotpWeatherReportAddon.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientInit {
    
    @SubscribeEvent
    public static void onFMLClientSetup(FMLClientSetupEvent event) {
        Minecraft mc = Minecraft.getInstance();
        Map<String, PlayerRenderer> skinMap = mc.getEntityRenderDispatcher().getSkinMap();
        RenderingRegistry.registerEntityRenderingHandler(AddonStands.WEATHER_REPORT.getEntityType(), WeatherReportRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(InitEntities.FUGU_SUMMONER.get(), FugaSummonerEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(InitEntities.FUGU_PROJECTILE.get(), FugaProjectileRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(InitEntities.ICICLE_STRIKE_PROJECTILE.get(), IcicleExtendingProjectileRenderer::new);

        RenderTypeLookup.setRenderLayer(InitBlocks.BLOOD_PUDDLE.get(), RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(InitBlocks.BLOOD_SPIKES.get(), RenderType.cutoutMipped());

        addLayers(skinMap.get("default"));
        addLayers(skinMap.get("slim"));
    }
    @SubscribeEvent
    public static void onMcConstructor(ParticleFactoryRegisterEvent event) {
        Minecraft mc = Minecraft.getInstance();
        mc.particleEngine.register(InitParticles.REVERSE_AIR_STREAM.get(), ReverseAirStreamParticle.Factory::new);
    }
    public static void addLayers(PlayerRenderer renderer){
        renderer.addLayer(new WeatherReportEffectCloudLayer<>(renderer, new CloudsModel<>(0.35F, false)));
    }
}
