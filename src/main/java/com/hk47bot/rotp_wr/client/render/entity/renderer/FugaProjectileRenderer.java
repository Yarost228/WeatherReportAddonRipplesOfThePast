package com.hk47bot.rotp_wr.client.render.entity.renderer;

import com.github.standobyte.jojo.client.render.entity.renderer.SimpleEntityRenderer;
import com.hk47bot.rotp_wr.RotpWeatherReportAddon;
import com.hk47bot.rotp_wr.client.render.entity.model.FugaProjectileModel;
import com.hk47bot.rotp_wr.entity.fugurain.projectile.FugaProjectileEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class FugaProjectileRenderer extends SimpleEntityRenderer<FugaProjectileEntity, FugaProjectileModel> {
    public FugaProjectileRenderer(EntityRendererManager renderManager) {
        super(renderManager, new FugaProjectileModel(), new ResourceLocation(RotpWeatherReportAddon.MOD_ID, "textures/entity/projectiles/pufferfish.png"));
    }
}
