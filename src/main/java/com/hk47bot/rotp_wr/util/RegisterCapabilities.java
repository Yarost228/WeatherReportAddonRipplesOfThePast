package com.hk47bot.rotp_wr.util;

import com.hk47bot.rotp_wr.RotpWeatherReportAddon;
import com.hk47bot.rotp_wr.capability.PlayerWeatherChangeCapability;
import com.hk47bot.rotp_wr.capability.PlayerWeatherChangeCapabilityProvider;
import com.hk47bot.rotp_wr.capability.PlayerWeatherChangeCapabilityStorage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RotpWeatherReportAddon.MOD_ID)
public class RegisterCapabilities {
    private static final ResourceLocation PLAYER_WEATHER_CAP = new ResourceLocation(RotpWeatherReportAddon.MOD_ID, "player_weather");
    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void onAttachCapabilitiesEntity(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof PlayerEntity){
            event.addCapability(PLAYER_WEATHER_CAP, new PlayerWeatherChangeCapabilityProvider((PlayerEntity) event.getObject()));
        }
    }
    public static void registerCapabilities(){
        CapabilityManager.INSTANCE.register(PlayerWeatherChangeCapability.class, new PlayerWeatherChangeCapabilityStorage(), () -> new PlayerWeatherChangeCapability(null));
    }
}
