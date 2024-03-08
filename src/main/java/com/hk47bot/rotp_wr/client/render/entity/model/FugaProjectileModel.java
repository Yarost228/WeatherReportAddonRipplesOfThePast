package com.hk47bot.rotp_wr.client.render.entity.model;

import com.hk47bot.rotp_wr.entity.fugurain.projectile.FugaProjectileEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;


public class FugaProjectileModel extends EntityModel<FugaProjectileEntity> {
	private final ModelRenderer body;
	private final ModelRenderer leftFin;
	private final ModelRenderer rightFin;
	private final ModelRenderer spines_top_front;
	private final ModelRenderer spines_top_mid;
	private final ModelRenderer spines_top_back;
	private final ModelRenderer spines_bottom_front;
	private final ModelRenderer spines_bottom_mid;
	private final ModelRenderer spines_bottom_back;
	private final ModelRenderer spines_left_front;
	private final ModelRenderer spines_left_mid;
	private final ModelRenderer spines_left_back;
	private final ModelRenderer spines_right_front;
	private final ModelRenderer spines_right_mid;
	private final ModelRenderer spines_right_back;

	public FugaProjectileModel() {
		texWidth = 32;
		texHeight = 32;

		body = new ModelRenderer(this);
		body.setPos(0.0F, 0.0F, 0.0F);
		body.texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		leftFin = new ModelRenderer(this);
		leftFin.setPos(-4.0F, 6.0F, 3.0F);
		leftFin.texOffs(24, 3).addBox(-2.0F, 0.0F, -5.99F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		rightFin = new ModelRenderer(this);
		rightFin.setPos(4.0F, 6.0F, 1.0F);
		rightFin.texOffs(24, 0).addBox(0.0F, 0.0F, -3.99F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		spines_top_front = new ModelRenderer(this);
		spines_top_front.setPos(4.0F, 8.0F, -4.0F);
		setRotationAngle(spines_top_front, -0.7854F, 0.0F, 0.0F);
		spines_top_front.texOffs(14, 16).addBox(-8.0F, -1.0F, 0.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		spines_top_mid = new ModelRenderer(this);
		spines_top_mid.setPos(0.0F, 8.0F, 0.0F);
		spines_top_mid.texOffs(14, 16).addBox(-4.0F, -1.0F, 0.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		spines_top_back = new ModelRenderer(this);
		spines_top_back.setPos(0.0F, 8.0F, 4.0F);
		setRotationAngle(spines_top_back, 0.7854F, 0.0F, 0.0F);
		spines_top_back.texOffs(14, 16).addBox(-4.0F, -1.0F, 0.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		spines_bottom_front = new ModelRenderer(this);
		spines_bottom_front.setPos(0.0F, 0.0F, -4.0F);
		setRotationAngle(spines_bottom_front, 0.7854F, 0.0F, 0.0F);
		spines_bottom_front.texOffs(14, 19).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		spines_bottom_mid = new ModelRenderer(this);
		spines_bottom_mid.setPos(0.0F, -1.0F, 0.0F);
		spines_bottom_mid.texOffs(14, 19).addBox(-4.0F, -1.0F, 0.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		spines_bottom_back = new ModelRenderer(this);
		spines_bottom_back.setPos(0.0F, 0.0F, 4.0F);
		setRotationAngle(spines_bottom_back, 0.7854F, 0.0F, 0.0F);
		spines_bottom_back.texOffs(14, 20).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		spines_left_front = new ModelRenderer(this);
		spines_left_front.setPos(-4.0F, 0.0F, -4.0F);
		setRotationAngle(spines_left_front, 0.0F, -0.7854F, 0.0F);
		spines_left_front.texOffs(0, 16).addBox(-1.0F, -8.0F, 0.0F, 1.0F, 8.0F, 1.0F, 0.0F, false);

		spines_left_mid = new ModelRenderer(this);
		spines_left_mid.setPos(-4.0F, 0.0F, 0.0F);
		spines_left_mid.texOffs(4, 16).addBox(-1.0F, -8.0F, 0.0F, 1.0F, 8.0F, 1.0F, 0.0F, false);

		spines_left_back = new ModelRenderer(this);
		spines_left_back.setPos(-4.0F, 0.0F, 4.0F);
		setRotationAngle(spines_left_back, 0.0F, 0.7854F, 0.0F);
		spines_left_back.texOffs(8, 16).addBox(-1.0F, -8.0F, 0.0F, 1.0F, 8.0F, 1.0F, 0.0F, false);

		spines_right_front = new ModelRenderer(this);
		spines_right_front.setPos(4.0F, 0.0F, -4.0F);
		setRotationAngle(spines_right_front, 0.0F, 0.7854F, 0.0F);
		spines_right_front.texOffs(4, 16).addBox(0.0F, -8.0F, 0.0F, 1.0F, 8.0F, 1.0F, 0.0F, false);

		spines_right_mid = new ModelRenderer(this);
		spines_right_mid.setPos(4.0F, 0.0F, 0.0F);
		spines_right_mid.texOffs(8, 16).addBox(0.0F, -8.0F, 0.0F, 1.0F, 8.0F, 1.0F, 0.0F, false);

		spines_right_back = new ModelRenderer(this);
		spines_right_back.setPos(4.0F, 0.0F, 4.0F);
		setRotationAngle(spines_right_back, 0.0F, -0.7854F, 0.0F);
		spines_right_back.texOffs(8, 16).addBox(0.0F, -8.0F, 0.0F, 1.0F, 8.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(FugaProjectileEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		leftFin.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		rightFin.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		spines_top_front.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		spines_top_mid.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		spines_top_back.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		spines_bottom_front.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		spines_bottom_mid.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		spines_bottom_back.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		spines_left_front.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		spines_left_mid.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		spines_left_back.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		spines_right_front.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		spines_right_mid.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		spines_right_back.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}