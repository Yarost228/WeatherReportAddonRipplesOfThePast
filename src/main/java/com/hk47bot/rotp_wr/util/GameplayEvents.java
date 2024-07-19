package com.hk47bot.rotp_wr.util;

import com.github.standobyte.jojo.util.mc.damage.DamageUtil;
import com.hk47bot.rotp_wr.entity.fugurain.projectile.FugaProjectileEntity;
import net.minecraft.entity.passive.fish.PufferfishEntity;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class GameplayEvents {
    @SubscribeEvent
    public void onExperienceDrop(LivingExperienceDropEvent event) {
        if (event.getEntityLiving() instanceof PufferfishEntity) {
            PufferfishEntity pufferfish = (PufferfishEntity) event.getEntityLiving();
            if (pufferfish.serializeNBT().contains("SummonedFromRain")) {
                event.setDroppedExperience(0);
            }
        }
    }
}
