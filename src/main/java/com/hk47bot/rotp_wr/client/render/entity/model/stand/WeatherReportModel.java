package com.hk47bot.rotp_wr.client.render.entity.model.stand;

import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.client.render.entity.model.stand.HumanoidStandModel;
import com.github.standobyte.jojo.client.render.entity.pose.ModelPose;
import com.github.standobyte.jojo.client.render.entity.pose.RotationAngle;
import com.github.standobyte.jojo.client.render.entity.pose.anim.PosedActionAnimation;
import com.github.standobyte.jojo.entity.stand.StandPose;
import com.hk47bot.rotp_wr.action.stand.WeatherReportChangeWeather;
import com.hk47bot.rotp_wr.action.stand.WeatherReportWind;
import com.hk47bot.rotp_wr.entity.stand.stands.WeatherReportEntity;

import net.minecraft.client.renderer.model.ModelRenderer;

// Made with Blockbench 4.8.1
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


public class WeatherReportModel extends HumanoidStandModel<WeatherReportEntity> {
	private final ModelRenderer spike;
	private final ModelRenderer spike8_r1;
	private final ModelRenderer spike7_r1;
	private final ModelRenderer spike4_r1;
	private final ModelRenderer spike3_r1;
	private final ModelRenderer spike2_r1;
	private final ModelRenderer spike1_r1;
	private final ModelRenderer leftArm_r1;
	private final ModelRenderer rightArm_r1;


	public WeatherReportModel() {
		super();
			
		addHumanoidBaseBoxes(null);
		texWidth = 256;
		texHeight = 256;

		head.texOffs(38, 1).addBox(2.0F, -8.5F, -4.0F, 1.0F, 1.0F, 8.0F, -0.1F, false);
		head.texOffs(38, 1).addBox(-3.0F, -8.5F, -4.0F, 1.0F, 1.0F, 8.0F, -0.1F, false);
		head.texOffs(43, 12).addBox(-0.5F, -1.75F, -4.5F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		head.texOffs(17, 0).addBox(-4.5F, -5.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		head.texOffs(9, 0).addBox(3.5F, -5.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		spike = new ModelRenderer(this);
		spike.setPos(3.5F, -8.5F, -1.5F);
		head.addChild(spike);
		

		spike8_r1 = new ModelRenderer(this);
		spike8_r1.setPos(0.0F, 0.0F, 0.0F);
		spike.addChild(spike8_r1);
		setRotationAngle(spike8_r1, 0.0F, 0.0F, 0.7854F);
		spike8_r1.texOffs(60, 16).addBox(0.5F, -1.25F, 3.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		spike8_r1.texOffs(60, 16).addBox(0.5F, -1.25F, -1.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		spike7_r1 = new ModelRenderer(this);
		spike7_r1.setPos(-7.0F, 0.0F, 3.5F);
		spike.addChild(spike7_r1);
		setRotationAngle(spike7_r1, 0.0F, 0.0F, -0.7854F);
		spike7_r1.texOffs(60, 16).addBox(-1.5F, -1.25F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		spike7_r1.texOffs(60, 16).addBox(-1.5F, -1.25F, -4.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		spike4_r1 = new ModelRenderer(this);
		spike4_r1.setPos(-3.5F, 0.0F, -1.5F);
		spike.addChild(spike4_r1);
		setRotationAngle(spike4_r1, 0.3927F, 0.0F, 0.0F);
		spike4_r1.texOffs(60, 16).addBox(-0.5F, -1.25F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		spike3_r1 = new ModelRenderer(this);
		spike3_r1.setPos(-2.5F, 0.0F, 1.5F);
		spike.addChild(spike3_r1);
		setRotationAngle(spike3_r1, 0.0F, 0.0F, 0.3927F);
		spike3_r1.texOffs(60, 16).addBox(0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		spike2_r1 = new ModelRenderer(this);
		spike2_r1.setPos(-4.5F, 0.0F, 1.5F);
		spike.addChild(spike2_r1);
		setRotationAngle(spike2_r1, 0.0F, 0.0F, -0.3927F);
		spike2_r1.texOffs(60, 16).addBox(-1.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		spike1_r1 = new ModelRenderer(this);
		spike1_r1.setPos(-3.5F, 0.5F, 4.0F);
		spike.addChild(spike1_r1);
		setRotationAngle(spike1_r1, -0.3927F, 0.0F, 0.0F);
		spike1_r1.texOffs(60, 16).addBox(-0.5F, -1.75F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		torso.texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
		torso.texOffs(19, 20).addBox(-4.0F, 1.1F, -2.25F, 8.0F, 3.0F, 1.0F, 0.1F, false);
		torso.texOffs(20, 25).addBox(-3.0F, 4.0F, -2.3F, 6.0F, 6.0F, 1.0F, 0.0F, false);

		leftArm.texOffs(32, 48).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		leftArm.texOffs(14, 32).addBox(1.15F, -2.5F, -1.75F, 1.0F, 3.0F, 3.0F, -0.1F, false);
		leftArm.texOffs(52, 1).addBox(-1.5F, 2.5F, 0.5F, 3.0F, 3.0F, 2.0F, -0.2F, false);

		leftArm_r1 = new ModelRenderer(this);
		leftArm_r1.setPos(1.7F, -3.0F, 1.5F);
		leftArm.addChild(leftArm_r1);
		setRotationAngle(leftArm_r1, -0.7854F, 0.0F, 0.0F);
		leftArm_r1.texOffs(60, 16).addBox(-0.55F, -0.25F, -0.5F, 1.0F, 2.0F, 1.0F, -0.11F, false);

		leftArmJoint.texOffs(0, 55).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, -0.1F, false);
		
		leftForeArm.texOffs(32, 54).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, -0.001F, false);
		leftForeArm.texOffs(56, 16).addBox(1.25F, 5.25F, 1.0F, 1.0F, 1.0F, 1.0F, -0.1F, false);
		leftForeArm.texOffs(56, 16).addBox(1.25F, 5.25F, 0.0F, 1.0F, 1.0F, 1.0F, -0.1F, false);
		leftForeArm.texOffs(56, 16).addBox(1.25F, 5.25F, -1.0F, 1.0F, 1.0F, 1.0F, -0.1F, false);
		leftForeArm.texOffs(56, 16).addBox(1.25F, 5.25F, -2.0F, 1.0F, 1.0F, 1.0F, -0.1F, false);

		rightArm.texOffs(40, 16).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		rightArm.texOffs(22, 32).addBox(-2.15F, -2.5F, -1.75F, 1.0F, 3.0F, 3.0F, -0.1F, false);
		rightArm.texOffs(53, 11).addBox(-1.5F, 2.5F, 0.5F, 3.0F, 3.0F, 2.0F, -0.2F, false);

		rightArm_r1 = new ModelRenderer(this);
		rightArm_r1.setPos(-1.5F, -3.0F, 1.5F);
		rightArm.addChild(rightArm_r1);
		setRotationAngle(rightArm_r1, -0.7854F, 0.0F, 0.0F);
		rightArm_r1.texOffs(59, 6).addBox(-0.65F, -0.25F, -0.5F, 1.0F, 2.0F, 1.0F, -0.11F, false);

		rightArmJoint.texOffs(0, 32).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, -0.1F, false);

		rightForeArm.texOffs(40, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, -0.001F, false);
		rightForeArm.texOffs(56, 16).addBox(-2.25F, 5.25F, -2.0F, 1.0F, 1.0F, 1.0F, -0.1F, false);
		rightForeArm.texOffs(56, 16).addBox(-2.25F, 5.25F, -1.0F, 1.0F, 1.0F, 1.0F, -0.1F, false);
		rightForeArm.texOffs(56, 16).addBox(-2.25F, 5.25F, 0.0F, 1.0F, 1.0F, 1.0F, -0.1F, false);
		rightForeArm.texOffs(56, 16).addBox(-2.25F, 5.25F, 1.0F, 1.0F, 1.0F, 1.0F, -0.1F, false);

		leftLeg.texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

		leftLegJoint.texOffs(44, 55).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, -0.1F, false);
		leftLegJoint.texOffs(30, 33).addBox(-1.5F, -1.5F, -2.5F, 3.0F, 3.0F, 2.0F, -0.2F, false);

		leftLowerLeg.texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, -0.001F, false);

		rightLeg.texOffs(16, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

		rightLegJoint.texOffs(66, 55).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, -0.1F, false);
		rightLegJoint.texOffs(40, 34).addBox(-1.5F, -1.5F, -2.25F, 3.0F, 3.0F, 2.0F, -0.2F, false);


		rightLowerLeg.texOffs(16, 54).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, -0.001F, false);
	}

	@Override
    protected RotationAngle[][] initSummonPoseRotations() {
        return new RotationAngle[][] {
            new RotationAngle[] {
				new RotationAngle(body, 0.0F, 0.7854F, 0.0F),
				new RotationAngle(leftArm, 0.0F, 0.0F, -0.9599F),
				new RotationAngle(leftArm_r1, -0.7854F, 0.0F, 0.0F),
				new RotationAngle(leftForeArm, 0.0F, 1.5708F, 0.7418F),
				new RotationAngle(rightArm, -1.5708F, 0.7854F, 0.0F),
				new RotationAngle(rightArm_r1, -0.7854F, 0.0F, 0.0F),
				new RotationAngle(rightForeArm, 0.0F, 0.0F, -1.5708F),
				new RotationAngle(leftLeg, -0.3054F, 0.0F, 0.0F),
				new RotationAngle(leftLowerLeg, 0.48F, 0.0F, 0.0F),
				new RotationAngle(rightLeg, 0.3927F, 0.0F, 0.0F),
				new RotationAngle(rightLowerLeg, 0.3054F, 0.0F, 0.0F),
            },
            new RotationAngle[] {
				new RotationAngle(head, -0.2618F, 0.0F, 0.0F),
				new RotationAngle(leftArm, -2.3562F, 1.2217F, -1.5708F),
				new RotationAngle(leftArm_r1, -0.7854F, 0.0F, 0.0F),
				new RotationAngle(leftForeArm, -1.9635F, -0.3747F, 0.2291F),
				new RotationAngle(rightArm, 0.0F, 0.2182F, 0.7854F),
				new RotationAngle(rightArm_r1, -0.7854F, 0.0F, 0.0F),
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
        actionAnim.put(StandPose.RANGED_ATTACK, new PosedActionAnimation.Builder<WeatherReportEntity>()
                .addPose(StandEntityAction.Phase.BUTTON_HOLD, new ModelPose<>(new RotationAngle[] {
                        new RotationAngle(body, 0.0F, -0.48F, 0.0F),
                        new RotationAngle(leftArm, 0.0F, 0.0F, -0.7854F),
                        new RotationAngle(leftForeArm, 0.0F, 0.0F, 0.6109F),
                        new RotationAngle(rightArm, -1.0908F, 0.0F, 1.5708F), 
                        new RotationAngle(rightForeArm, 0.0F, 0.0F, 0.0F)
                }))
                .build(idlePose));
        actionAnim.put(WeatherReportWind.WIND_BLOW, new PosedActionAnimation.Builder<WeatherReportEntity>()
                .addPose(StandEntityAction.Phase.BUTTON_HOLD, new ModelPose<>(new RotationAngle[] {
					new RotationAngle(body, 0.0F, 0.0F, 0.0F),
					new RotationAngle(leftArm, -1.5708F, -0.3927F, 0.0F),
					new RotationAngle(leftArm_r1, -0.7854F, 0.0F, 0.0F),
					new RotationAngle(leftForeArm, 0.0F, 1.5708F, 0.3927F),
					new RotationAngle(rightArm, -1.5708F, 0.3927F, 0.0F),
					new RotationAngle(rightArm_r1, -0.7854F, 0.0F, 0.0F),
					new RotationAngle(rightForeArm, 0.0F, -1.5708F, -0.3927F),
                }))
                .build(idlePose));
		actionAnim.put(WeatherReportChangeWeather.WEATHER_CHANGE_POSE, new PosedActionAnimation.Builder<WeatherReportEntity>()
                .addPose(StandEntityAction.Phase.BUTTON_HOLD, new ModelPose<>(new RotationAngle[] {
					new RotationAngle(leftArm, 0.0F, 0.0F, -2.618F),
					new RotationAngle(leftArm_r1, -0.7854F, 0.0F, 0.0F),
					new RotationAngle(leftForeArm, 0.0F, 0.0F, 0.0F),
					new RotationAngle(rightArm,  0.0F, 0.0F, 2.618F),
					new RotationAngle(rightArm_r1, -0.7854F, 0.0F, 0.0F),
					new RotationAngle(rightForeArm, 0.0F, 0.0F, 0.0F),
                }))
                .build(idlePose));
				super.initActionPoses();

			}
    
    

    @Override
    protected ModelPose<WeatherReportEntity> initIdlePose() {
        return new ModelPose<>(new RotationAngle[] {
			new RotationAngle(leftArm, -0.0425F, 0.7769F, -0.1841F),
			new RotationAngle(leftArm_r1, -0.7854F, 0.0F, 0.0F),
			new RotationAngle(leftForeArm, 0.0F, 0.0F, 0.0F),
			new RotationAngle(rightArm, 0.0003F, -0.7816F, 0.1231F),
			new RotationAngle(rightArm_r1, -0.7854F, 0.0F, 0.0F),
			new RotationAngle(rightForeArm, 0.0F, 0.0F, 0.0F),
			new RotationAngle(leftLeg, -0.2182F, 0.0F, -0.0873F),
			new RotationAngle(leftLowerLeg, 0.7854F, 0.0F, 0.0F),
			new RotationAngle(rightLeg, -0.1309F, 0.0F, 0.0873F),
			new RotationAngle(rightLowerLeg, 0.3054F, 0.0F, 0.0F),
        });
    }

    @Override
    protected ModelPose<WeatherReportEntity> initIdlePose2Loop() {
        return new ModelPose<>(new RotationAngle[] {
                new RotationAngle(leftArm, -0.0852F, 0.7741F, -0.2451F),
				new RotationAngle(leftArm_r1, -0.7854F, 0.0F, 0.0F),
                new RotationAngle(leftForeArm, 0.0F, 0.0F, 0.0F),
                new RotationAngle(rightArm, -0.0429F, -0.7807F, 0.1845F),
				new RotationAngle(rightArm_r1, -0.7854F, 0.0F, 0.0F),
                new RotationAngle(rightForeArm, 0.0F, 0.0F, 0.0F)
        });
		
    }
}