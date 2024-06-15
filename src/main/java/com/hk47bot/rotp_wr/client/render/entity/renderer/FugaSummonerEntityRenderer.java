package com.hk47bot.rotp_wr.client.render.entity.renderer;

import com.hk47bot.rotp_wr.entity.fugurain.FugaSummonerEntity;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class FugaSummonerEntityRenderer extends EntityRenderer<FugaSummonerEntity> {

    public FugaSummonerEntityRenderer(EntityRendererManager renderManager) {
        super(renderManager);
    }
    
    // the entity itself doesn't need to be rendered, so we override the render method to empty
    @Override
    public void render(FugaSummonerEntity entity, float yRot, float partialTick, 
            MatrixStack matrixStack, IRenderTypeBuffer vertexBuilder, int packedLight) {
    }
    
    private static final ResourceLocation EMPTY = new ResourceLocation("empty");
    @Override
    public ResourceLocation getTextureLocation(FugaSummonerEntity p_110775_1_) {
        return EMPTY;
    }
    
}
