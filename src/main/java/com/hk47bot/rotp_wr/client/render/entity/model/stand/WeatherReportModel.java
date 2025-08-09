package com.hk47bot.rotp_wr.client.render.entity.model.stand;

import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.client.render.entity.model.stand.HumanoidStandModel;
import com.github.standobyte.jojo.client.render.entity.pose.*;
import com.github.standobyte.jojo.client.render.entity.pose.anim.PosedActionAnimation;
import com.github.standobyte.jojo.entity.stand.StandPose;
import com.github.standobyte.jojo.util.general.MathUtil;
import com.hk47bot.rotp_wr.action.stand.WeatherReportChangeWeather;
import com.hk47bot.rotp_wr.action.stand.WeatherReportWind;
import com.hk47bot.rotp_wr.client.barrage.WeatherReportBarrageAnimation;
import com.hk47bot.rotp_wr.entity.stand.stands.WeatherReportEntity;

import com.hk47bot.rotp_wr.init.InitStands;
import net.minecraft.client.renderer.model.ModelRenderer;

import javax.annotation.Nullable;
// Made with Blockbench 4.9.3
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


public class WeatherReportModel extends HumanoidStandModel<WeatherReportEntity> {
	private final ModelRenderer spike;
	private final ModelRenderer spike2;
	private final ModelRenderer spike3;
	private final ModelRenderer spike4;
	private final ModelRenderer spike5;
	private final ModelRenderer spike6;
	private final ModelRenderer spike7;
	private final ModelRenderer spike8;
	private final ModelRenderer leftShoulder;
	private final ModelRenderer rightShoulder;
	private final ModelRenderer leftKnee;
	private final ModelRenderer cloud;
	private final ModelRenderer cloud3;
	private final ModelRenderer cloud4;
	private final ModelRenderer rightKnee;
	private final ModelRenderer cloud1;
	private final ModelRenderer cloud2;

	public WeatherReportModel() {
		super();
		addHumanoidBaseBoxes(null);
		texWidth = 128;
		texHeight = 128;

		head.texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		head.texOffs(26, 9).addBox(-3.5F, -8.5F, -4.0F, 1.0F, 1.0F, 8.0F, -0.1F, false);
		head.texOffs(26, 9).addBox(2.5F, -8.5F, -4.0F, 1.0F, 1.0F, 8.0F, -0.1F, false);
		head.texOffs(9, 16).addBox(-0.5F, -1.5F, -4.25F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		spike = new ModelRenderer(this);
		spike.setPos(-1.5F, -7.5F, 0.0F);
		head.addChild(spike);
		setRotationAngle(spike, 0.0F, 0.0F, -0.3927F);
		spike.texOffs(27, 2).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		spike2 = new ModelRenderer(this);
		spike2.setPos(1.5F, -7.5F, 0.0F);
		head.addChild(spike2);
		setRotationAngle(spike2, 0.0F, 0.0F, 0.3927F);
		spike2.texOffs(27, 2).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		spike3 = new ModelRenderer(this);
		spike3.setPos(0.0F, -7.5F, -3.0F);
		head.addChild(spike3);
		setRotationAngle(spike3, 0.3927F, 0.0F, 0.0F);
		spike3.texOffs(27, 2).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		spike4 = new ModelRenderer(this);
		spike4.setPos(0.0F, -7.5F, 3.0F);
		head.addChild(spike4);
		setRotationAngle(spike4, -0.4363F, 0.0F, 0.0F);
		spike4.texOffs(27, 2).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		spike5 = new ModelRenderer(this);
		spike5.setPos(3.25F, -7.25F, 1.5F);
		head.addChild(spike5);
		setRotationAngle(spike5, 0.0F, 0.0F, 0.7854F);
		spike5.texOffs(27, 2).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		spike6 = new ModelRenderer(this);
		spike6.setPos(3.25F, -7.25F, -1.5F);
		head.addChild(spike6);
		setRotationAngle(spike6, 0.0F, 0.0F, 0.7854F);
		spike6.texOffs(27, 2).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		spike7 = new ModelRenderer(this);
		spike7.setPos(-3.25F, -7.25F, -1.5F);
		head.addChild(spike7);
		setRotationAngle(spike7, 0.0F, 0.0F, -0.7854F);
		spike7.texOffs(27, 2).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		spike8 = new ModelRenderer(this);
		spike8.setPos(-3.25F, -7.25F, 1.5F);
		head.addChild(spike8);
		setRotationAngle(spike8, 0.0F, 0.0F, -0.7854F);
		spike8.texOffs(27, 2).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		cloud = new ModelRenderer(this);
		cloud.setPos(0.0F, 0.0F, 0F);
		body.addChild(cloud);

		cloud3 = new ModelRenderer(this);
		cloud3.setPos(0.0F, -2.0F, 0.5F);
		cloud.addChild(cloud3);
		setRotationAngle(cloud3, 0.0F, 0.7854F, 0.0F);
		cloud3.texOffs(0, 52).addBox(-0.5F, -7.25F, 6.75F, 4.0F, 2.0F, 4.0F, 0.0F, false);
		cloud3.texOffs(0, 52).addBox(3.5F, -7.25F, 10.75F, 4.0F, 2.0F, 4.0F, 0.0F, false);
		cloud3.texOffs(0, 52).addBox(-0.5F, -5.25F, 6.75F, 4.0F, 2.0F, 4.0F, 0.0F, false);
		cloud3.texOffs(0, 52).addBox(3.5F, -5.25F, 6.75F, 4.0F, 2.0F, 4.0F, 0.0F, false);
		cloud3.texOffs(0, 52).addBox(3.5F, -5.25F, 2.75F, 4.0F, 2.0F, 4.0F, 0.0F, false);
		cloud3.texOffs(0, 52).addBox(-0.5F, -5.25F, 10.75F, 4.0F, 2.0F, 4.0F, 0.0F, false);

		cloud4 = new ModelRenderer(this);
		cloud4.setPos(0.0F, 2.0F, -1.2F);
		cloud.addChild(cloud4);
		setRotationAngle(cloud4, 0.0F, -22.5F, 0.0F);
		cloud4.texOffs(0, 52).addBox(2.75F, 6.6F, -13.3F, 4.0F, 2.0F, 4.0F, 0.0F, false);
		cloud4.texOffs(0, 52).addBox(-1.25F, 6.6F, -9.3F, 4.0F, 2.0F, 4.0F, 0.0F, false);
		cloud4.texOffs(0, 52).addBox(-1.25F, 8.6F, -13.3F, 4.0F, 2.0F, 4.0F, 0.0F, false);
		cloud4.texOffs(0, 52).addBox(-5.25F, 6.6F, -13.3F, 4.0F, 2.0F, 4.0F, 0.0F, false);
		cloud4.texOffs(0, 52).addBox(-1.25F, 6.6F, -13.3F, 4.0F, 2.0F, 4.0F, 0.0F, false);

		cloud1 = new ModelRenderer(this);
		cloud1.setPos(0.0F, 1.0F, 0.0F);
		cloud.addChild(cloud1);
		setRotationAngle(cloud1, 0.0F, -0.7854F, 0.0F);
		cloud1.texOffs(0, 52).addBox(-11.25F, -5.0F, 0.0F, 4.0F, 2.0F, 4.0F, 0.0F, false);
		cloud1.texOffs(0, 52).addBox(-15.25F, -5.0F, -3.0F, 4.0F, 2.0F, 4.0F, 0.0F, false);

		cloud2 = new ModelRenderer(this);
		cloud2.setPos(0.0F, 11.0F, 0.0F);
		cloud.addChild(cloud2);
		setRotationAngle(cloud2, 0.0F, -0.3927F, 0.0F);
		cloud2.texOffs(0, 52).addBox(-8.75F, 5.5F, 6.25F, 4.0F, 2.0F, 4.0F, 0.0F, false);
		cloud2.texOffs(0, 52).addBox(-12.75F, 5.5F, 6.25F, 4.0F, 2.0F, 4.0F, 0.0F, false);
		cloud2.texOffs(0, 52).addBox(-12.75F, 5.5F, 2.25F, 4.0F, 2.0F, 4.0F, 0.0F, false);
		cloud2.texOffs(0, 52).addBox(-12.75F, 3.5F, 6.25F, 4.0F, 2.0F, 4.0F, 0.0F, false);

		torso.texOffs(0, 32).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
		torso.texOffs(2, 26).addBox(-4.0F, 0.0F, -2.4F, 8.0F, 5.0F, 1.0F, -0.1F, false);
		torso.texOffs(24, 38).addBox(-3.0F, 4.0F, -2.2F, 6.0F, 8.0F, 2.0F, 0.0F, false);

		leftArm.texOffs(0, 108).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		leftArm.texOffs(0, 102).addBox(1.25F, -2.25F, -1.5F, 1.0F, 3.0F, 3.0F, -0.1F, false);

		leftShoulder = new ModelRenderer(this);
		leftShoulder.setPos(1.75F, -2.0F, 0.75F);
		leftArm.addChild(leftShoulder);
		setRotationAngle(leftShoulder, -0.7854F, 0.0F, 0.0F);
		leftShoulder.texOffs(8, 105).addBox(-0.5F, -1.5F, -0.25F, 1.0F, 2.0F, 1.0F, -0.11F, false);

		leftArmJoint.texOffs(0, 92).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, -0.1F, false);
		leftArmJoint.texOffs(12, 118).addBox(-1.5F, -1.5F, 1.25F, 3.0F, 3.0F, 1.0F, -0.1F, false);

		leftForeArm.texOffs(0, 118).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		leftForeArm.texOffs(7, 99).addBox(1.25F, 5.25F, -2.0F, 1.0F, 1.0F, 1.0F, -0.1F, false);
		leftForeArm.texOffs(7, 99).addBox(1.25F, 5.25F, -1.0F, 1.0F, 1.0F, 1.0F, -0.1F, false);
		leftForeArm.texOffs(7, 99).addBox(1.25F, 5.25F, 0.0F, 1.0F, 1.0F, 1.0F, -0.1F, false);
		leftForeArm.texOffs(7, 99).addBox(1.25F, 5.25F, 1.0F, 1.0F, 1.0F, 1.0F, -0.1F, false);

		rightArm.texOffs(20, 108).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		rightArm.texOffs(22, 102).addBox(-2.25F, -2.25F, -1.5F, 1.0F, 3.0F, 3.0F, -0.1F, false);

		rightShoulder = new ModelRenderer(this);
		rightShoulder.setPos(-1.75F, -2.0F, 2.0F);
		rightArm.addChild(rightShoulder);
		setRotationAngle(rightShoulder, -0.7854F, 0.0F, 0.0F);
		rightShoulder.texOffs(30, 105).addBox(-0.5F, -0.7929F, -1.2071F, 1.0F, 2.0F, 1.0F, -0.11F, false);

		rightArmJoint.texOffs(0, 92).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, -0.1F, false);
		rightArmJoint.texOffs(32, 118).addBox(-1.5F, -1.5F, 1.25F, 3.0F, 3.0F, 1.0F, -0.1F, false);

		rightForeArm.texOffs(20, 118).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		rightForeArm.texOffs(7, 99).addBox(-2.25F, 5.25F, -2.0F, 1.0F, 1.0F, 1.0F, -0.1F, false);
		rightForeArm.texOffs(7, 99).addBox(-2.25F, 5.25F, -1.0F, 1.0F, 1.0F, 1.0F, -0.1F, false);
		rightForeArm.texOffs(7, 99).addBox(-2.25F, 5.25F, 0.0F, 1.0F, 1.0F, 1.0F, -0.1F, false);
		rightForeArm.texOffs(7, 99).addBox(-2.25F, 5.25F, 1.0F, 1.0F, 1.0F, 1.0F, -0.1F, false);

		leftLeg.texOffs(40, 108).addBox(-1.9F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

		leftLegJoint.texOffs(0, 92).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, -0.1F, false);
		leftLegJoint.texOffs(52, 118).addBox(-1.5F, -1.5F, -2.25F, 3.0F, 3.0F, 1.0F, -0.1F, false);

		leftKnee = new ModelRenderer(this);
		leftKnee.setPos(1.0F, -1.25F, -1.75F);
		leftLegJoint.addChild(leftKnee);
		setRotationAngle(leftKnee, 0.0F, 0.0F, 0.7854F);
		leftKnee.texOffs(52, 109).addBox(-0.5F, -1.25F, -0.5F, 1.0F, 2.0F, 1.0F, -0.11F, false);

		leftLowerLeg.texOffs(40, 118).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

		rightLeg.texOffs(60, 108).addBox(-2.1F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

		rightLegJoint.texOffs(0, 92).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, -0.1F, false);
		rightLegJoint.texOffs(72, 118).addBox(-1.5F, -1.5F, -2.25F, 3.0F, 3.0F, 1.0F, -0.1F, false);

		rightKnee = new ModelRenderer(this);
		rightKnee.setPos(-1.0F, -1.25F, -1.75F);
		rightLegJoint.addChild(rightKnee);
		setRotationAngle(rightKnee, 0.0F, 0.0F, -0.7854F);
		rightKnee.texOffs(72, 109).addBox(-0.5F, -1.25F, -0.5F, 1.0F, 2.0F, 1.0F, -0.11F, false);

		rightLowerLeg.texOffs(60, 118).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void prepareMobModel(@Nullable WeatherReportEntity entity, float walkAnimPos, float walkAnimSpeed, float partialTick) {
        if (entity != null){
			if (entity.getCurrentTaskAction() == InitStands.WEATHER_REPORT_ICICLE_STRIKE.get()){
				this.rightForeArm.visible = false;
				this.rightArmJoint.visible = false;
			}
			else {
				this.rightForeArm.visible = true;
				this.rightArmJoint.visible = true;
			}
            if (cloud != null){
				cloud.visible = true;
				if (entity.isDeflecting() || (entity.getCurrentTaskAction() == InitStands.WEATHER_REPORT_BLOCK.get() && entity.isArmsOnlyMode())){
					cloud1.yRot = -45;
					cloud2.yRot = -165;
					cloud3.yRot = -35;
					cloud4.yRot = 200;
				}
				else {
					cloud1.yRot = -entity.cloudRotation;
					cloud2.yRot = entity.cloudRotation;
					cloud3.yRot = entity.cloudRotation;
					cloud4.yRot = -entity.cloudRotation;
				}
            }
        }
		super.prepareMobModel(entity, walkAnimPos, walkAnimSpeed, partialTick);
	}

	public ModelRenderer getClouds(){
		return cloud;
	}

	@Override
	protected RotationAngle[][] initSummonPoseRotations() {
		return new RotationAngle[][] {
				new RotationAngle[] {
						new RotationAngle(body, 0.0F, 0.7854F, 0.0F),
						new RotationAngle(leftArm, 0.0F, 0.0F, -0.9599F),
						new RotationAngle(leftForeArm, 0.0F, 1.5708F, 0.7418F),
						new RotationAngle(rightArm, -1.5708F, 0.7854F, 0.0F),
						new RotationAngle(rightForeArm, 0.0F, 0.0F, -1.5708F),
						new RotationAngle(leftLeg, -0.3054F, 0.0F, 0.0F),
						new RotationAngle(leftLowerLeg, 0.48F, 0.0F, 0.0F),
						new RotationAngle(rightLeg, 0.3927F, 0.0F, 0.0F),
						new RotationAngle(rightLowerLeg, 0.3054F, 0.0F, 0.0F),
				},
				new RotationAngle[] {
						new RotationAngle(head, -0.2618F, 0.0F, 0.0F),
						new RotationAngle(leftArm, -2.3562F, 1.2217F, -1.5708F),
						new RotationAngle(leftForeArm, -1.9635F, -0.3747F, 0.2291F),
						new RotationAngle(rightArm, 0.0F, 0.2182F, 0.7854F),
						new RotationAngle(rightForeArm, 0.2618F, 0.0F, -1.5708F),
						new RotationAngle(leftLeg, -1.6581F, 0.0F, 0.0F),
						new RotationAngle(leftLegJoint, 0.7418F, 0.0F, 0.0F),
						new RotationAngle(leftLowerLeg, 1.789F, 0.0F, 0.0F),
						new RotationAngle(rightLeg, -0.1745F, 0.0F, 0.0F),
						new RotationAngle(rightLowerLeg, 0.3491F, 0.0F, 0.0F),
				}
		};
	}

	@Override
	protected void initActionPoses() {
		actionAnim.putIfAbsent(StandPose.RANGED_ATTACK, new PosedActionAnimation.Builder<WeatherReportEntity>()
				.addPose(StandEntityAction.Phase.BUTTON_HOLD, new ModelPose<WeatherReportEntity>(new RotationAngle[] {
						new RotationAngle(body, 0.0F, -0.48F, 0.0F),
						new RotationAngle(rightArm, -1.0908F, 0.0F, 1.5708F),
						new RotationAngle(rightForeArm, 0.0F, 0.0F, 0.0F)
				}).setAdditionalAnim((rotationAmount, entity, ticks, yRotationOffset, xRotation) -> {
					float xRot = xRotation * MathUtil.DEG_TO_RAD;
					rightArm.xRotSecond = xRot;
				}))
				.build(idlePose));

		actionAnim.put(WeatherReportWind.WIND_BLOW, new PosedActionAnimation.Builder<WeatherReportEntity>()
				.addPose(StandEntityAction.Phase.BUTTON_HOLD, new ModelPose<WeatherReportEntity>(new RotationAngle[] {
						new RotationAngle(body, 0.0F, 0.0F, 0.0F),
						new RotationAngle(leftForeArm, 0.0F, 1.5708F, 0.3927F),
						new RotationAngle(rightForeArm, 0.0F, -1.5708F, -0.3927F),
						new RotationAngle(rightArm, 0.0F, 0.0F, 0.3927F),
						new RotationAngle(leftArm, 0.0F, 0.0F, -0.3927F)
				}).setAdditionalAnim((rotationAmount, entity, ticks, yRotationOffset, xRotation) -> {
					float xRot = (80 + xRotation) * MathUtil.DEG_TO_RAD;
					rightArm.xRotSecond = xRot;
					leftArm.xRotSecond = xRot;
				}))
				.build(idlePose));

		actionAnim.put(WeatherReportChangeWeather.WEATHER_CHANGE_POSE, new PosedActionAnimation.Builder<WeatherReportEntity>()
				.addPose(StandEntityAction.Phase.BUTTON_HOLD, new ModelPose<>(new RotationAngle[] {
						new RotationAngle(cloud, 0.0F, 12.0F, 0.0F),
						new RotationAngle(body, 0.0F, 0.0F, 0.0F),
						new RotationAngle(leftArm, 0.0F, 0.0F, -2.618F),
						new RotationAngle(leftForeArm, 0.0F, 0.0F, 0.0F),
						new RotationAngle(rightArm,  0.0F, 0.0F, 2.618F),
						new RotationAngle(rightForeArm, 0.0F, 0.0F, 0.0F)
				}))
				.build(idlePose));

		ModelPose.ModelAnim<WeatherReportEntity> armsRotationFull = (rotationAmount, entity, ticks, yRotOffsetRad, xRotRad) -> {
			setSecondXRot(leftArm, xRotRad);
			setSecondXRot(rightArm, xRotRad);
		};

		RotationAngle[] barrageRightImpact = new RotationAngle[] {
				RotationAngle.fromDegrees(body, 0, 0, 0),
				RotationAngle.fromDegrees(upperPart, 0, -30, 0),
				RotationAngle.fromDegrees(leftArm, 22.5F, 0, -60),
				RotationAngle.fromDegrees(leftForeArm, -135, 0, 0),
				RotationAngle.fromDegrees(rightArm, -90, 0, 90),
				RotationAngle.fromDegrees(rightForeArm, 0, 0, 0)
		};

		IModelPose<WeatherReportEntity> barrageHitStart = new ModelPoseSided<>(
				new ModelPose<WeatherReportEntity>(barrageRightImpact).setAdditionalAnim(armsRotationFull),
				new ModelPose<WeatherReportEntity>(mirrorAngles(barrageRightImpact)).setAdditionalAnim(armsRotationFull));

		IModelPose<WeatherReportEntity> barrageHitImpact = new ModelPoseSided<>(
				new ModelPose<WeatherReportEntity>(mirrorAngles(barrageRightImpact)).setAdditionalAnim(armsRotationFull),
				new ModelPose<WeatherReportEntity>(barrageRightImpact).setAdditionalAnim(armsRotationFull));

		IModelPose<WeatherReportEntity> barrageRecovery = new ModelPose<>(new RotationAngle[] {
				RotationAngle.fromDegrees(body, 0, 0, 0),
				RotationAngle.fromDegrees(upperPart, 0, 0, 0),
				RotationAngle.fromDegrees(leftArm, 22.5F, 0, -22.5F),
				RotationAngle.fromDegrees(leftForeArm, -75, 7.5F, 22.5F),
				RotationAngle.fromDegrees(rightArm, 22.5F, 0, 22.5F),
				RotationAngle.fromDegrees(rightForeArm, -75, -7.5F, -22.5F)
		});

		actionAnim.putIfAbsent(StandPose.BARRAGE, new WeatherReportBarrageAnimation<>(this,
				new ModelPoseTransition<WeatherReportEntity>(barrageHitStart, barrageHitImpact).setEasing(HumanoidStandModel::barrageHitEasing),
				new ModelPoseTransitionMultiple.Builder<WeatherReportEntity>(new ModelPose<WeatherReportEntity>(
						RotationAngle.fromDegrees(body, 0, 0, 0),
						RotationAngle.fromDegrees(upperPart, 0, 0, 0),
						RotationAngle.fromDegrees(leftArm, -33.75F, 0, -75),
						RotationAngle.fromDegrees(leftForeArm, -67.5F, 0, 0),
						RotationAngle.fromDegrees(rightArm, -33.75F, 0, 75),
						RotationAngle.fromDegrees(rightForeArm, -67.5F, 0, 0)).setAdditionalAnim(armsRotationFull))
						.addPose(0.25F, barrageRecovery)
						.addPose(0.5F, barrageRecovery)
						.build(idlePose)));

		super.initActionPoses();

	}



	@Override
	protected ModelPose<WeatherReportEntity> initIdlePose() {
		return new ModelPose<>(new RotationAngle[] {
				new RotationAngle(upperPart, 0, 0, 0),
				new RotationAngle(leftArm, -0.0425F, 0.7769F, -0.1841F),
				new RotationAngle(leftForeArm, 0.0F, 0.0F, 0.0F),
				new RotationAngle(rightArm, 0.0003F, -0.7816F, 0.1231F),
				new RotationAngle(rightForeArm, 0.0F, 0.0F, 0.0F),
				new RotationAngle(leftLeg, -0.2182F, 0.0F, -0.0873F),
				new RotationAngle(leftLowerLeg, 0.7854F, 0.0F, 0.0F),
				new RotationAngle(rightLeg, -0.1309F, 0.0F, 0.0873F),
				new RotationAngle(rightLowerLeg, 0.3054F, 0.0F, 0.0F)
		});
	}

	@Override
	protected ModelPose<WeatherReportEntity> initIdlePose2Loop() {
		return new ModelPose<>(new RotationAngle[] {
				new RotationAngle(leftArm, -0.0852F, 0.7741F, -0.2451F),
				new RotationAngle(leftForeArm, 0.0F, 0.0F, 0.0F),
				new RotationAngle(rightArm, -0.0429F, -0.7807F, 0.1845F),
				new RotationAngle(rightForeArm, 0.0F, 0.0F, 0.0F)
		});

	}
}
