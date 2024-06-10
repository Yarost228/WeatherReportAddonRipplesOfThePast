package com.hk47bot.rotp_wr.client.render.entity.model;

import com.hk47bot.rotp_wr.entity.fugurain.FugaSummonerEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

// Made with Blockbench 4.8.2


public class FugaSummonerEntityModel extends EntityModel<FugaSummonerEntity> {
	private final ModelRenderer bb_main;

	public FugaSummonerEntityModel() {
        super(RenderType::entityTranslucent);
		texWidth = 16;
		texHeight = 16;

		bb_main = new ModelRenderer(this);
		bb_main.setPos(0.0F, 24.0F, 0.0F);
		bb_main.texOffs(0, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(FugaSummonerEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float yRotationOffset, float xRotation){
        entity.yRot = yRotationOffset * ((float)Math.PI / 180F);
    	entity.xRot = xRotation * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}
	
    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }


}
