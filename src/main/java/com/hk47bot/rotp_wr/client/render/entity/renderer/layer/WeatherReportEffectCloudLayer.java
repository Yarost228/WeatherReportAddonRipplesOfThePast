package com.hk47bot.rotp_wr.client.render.entity.renderer.layer;

import com.github.standobyte.jojo.client.playeranim.PlayerAnimationHandler;
import com.hk47bot.rotp_wr.RotpWeatherReportAddon;
import com.hk47bot.rotp_wr.client.render.entity.model.layer.CloudsModel;
import com.hk47bot.rotp_wr.init.InitEffects;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

import static com.github.standobyte.jojo.client.ClientUtil.setRotationAngle;

public class WeatherReportEffectCloudLayer<T extends LivingEntity, M extends BipedModel<T>> extends LayerRenderer<T, M> {
    private static final Map<PlayerRenderer, WeatherReportEffectCloudLayer<AbstractClientPlayerEntity, BipedModel<AbstractClientPlayerEntity>>> RENDERER_LAYERS = new HashMap<>();
    private CloudsModel cloudModel;
    private boolean playerAnimHandled = false;
    public WeatherReportEffectCloudLayer (IEntityRenderer<T, M> renderer, CloudsModel cloudModel){
        super(renderer);
        if (renderer instanceof PlayerRenderer){
            RENDERER_LAYERS.put((PlayerRenderer) renderer, (WeatherReportEffectCloudLayer<AbstractClientPlayerEntity, BipedModel<AbstractClientPlayerEntity>>) this);
        }
        this.cloudModel = cloudModel;
    }
    @Override
    public void render(MatrixStack matrixStack, IRenderTypeBuffer buffer, int packedLight, T entity, float limbSwing, float limbSwingAmount, float partialTick, float ticks, float yRot, float xRot){
        if (!playerAnimHandled) {
            PlayerAnimationHandler.getPlayerAnimator().onArmorLayerInit(this);
            playerAnimHandled = true;
        }
        if (entity.isAlive() && entity.hasEffect(InitEffects.CLOUD_SHIELD_EFFECT.get())){
            M model = getParentModel();
            ResourceLocation texture = new ResourceLocation(RotpWeatherReportAddon.MOD_ID, "textures/entity/layer/clouds.png");
            cloudModel.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTick);
            model.copyPropertiesTo(cloudModel);
            IVertexBuilder vertexBuilder = buffer.getBuffer(RenderType.entityTranslucentCull(texture));
            cloudModel.updateRotation();
            cloudModel.renderToBuffer(matrixStack, vertexBuilder, packedLight, LivingRenderer.getOverlayCoords(entity, 0.0F), 1, 1, 1, 1);
        }
    }
}
