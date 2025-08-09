package com.hk47bot.rotp_wr.util;

import com.hk47bot.rotp_wr.RotpWeatherReportAddon;
import net.minecraft.entity.passive.fish.PufferfishEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RotpWeatherReportAddon.MOD_ID, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onExperienceDrop(LivingExperienceDropEvent event) {
        if (event.getEntityLiving() instanceof PufferfishEntity && event.getEntityLiving().getPersistentData().contains("SummonedByRain")) {
            event.setCanceled(true);
        }
    }
}
