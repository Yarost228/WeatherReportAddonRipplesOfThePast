package com.hk47bot.rotp_wr.client.render.entity.renderer;

import com.github.standobyte.jojo.client.render.entity.renderer.damaging.extending.ExtendingEntityRenderer;
import com.hk47bot.rotp_wr.RotpWeatherReportAddon;
import com.hk47bot.rotp_wr.client.render.entity.model.IcicleExtendingProjectileModel;
import com.hk47bot.rotp_wr.entity.IcicleExtendingProjectileEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class IcicleExtendingProjectileRenderer extends ExtendingEntityRenderer<IcicleExtendingProjectileEntity, IcicleExtendingProjectileModel> {

    public IcicleExtendingProjectileRenderer(EntityRendererManager renderManager) {
        super(renderManager, new IcicleExtendingProjectileModel(), new ResourceLocation(RotpWeatherReportAddon.MOD_ID, "textures/entity/projectiles/icicle.png"));
    }

}
