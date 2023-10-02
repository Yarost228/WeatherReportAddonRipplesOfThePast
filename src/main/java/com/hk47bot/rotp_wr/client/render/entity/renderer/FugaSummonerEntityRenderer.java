package com.hk47bot.rotp_wr.client.render.entity.renderer;

import com.github.standobyte.jojo.client.render.entity.renderer.SimpleEntityRenderer;
import com.hk47bot.rotp_wr.RotpWeatherReportAddon;
import com.hk47bot.rotp_wr.client.render.entity.model.FugaSummonerEntityModel;
import com.hk47bot.rotp_wr.entity.fugurain.FugaSummonerEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;

public class FugaSummonerEntityRenderer extends SimpleEntityRenderer<FugaSummonerEntity, FugaSummonerEntityModel> {
    public static final ResourceLocation texture = new ResourceLocation(RotpWeatherReportAddon.MOD_ID, "textures/entity/fugarain.png");

    public FugaSummonerEntityRenderer(EntityRendererManager renderManager) {
        super(renderManager, new FugaSummonerEntityModel(), texture);
    }
    @Override
    protected void renderModel(FugaSummonerEntity entity, FugaSummonerEntityModel model, float partialTick, 
            MatrixStack matrixStack, IVertexBuilder vertexBuilder, int packedLight) {
        model.renderToBuffer(matrixStack, vertexBuilder, packedLight, OverlayTexture.NO_OVERLAY,  1.0F, 1.0F, 1.0F, 1.0F);
    }
    
}
