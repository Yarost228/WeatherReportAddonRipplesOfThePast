package com.hk47bot.rotp_wr.client.render.entity.model.layer;

import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

import static com.github.standobyte.jojo.client.ClientUtil.setRotationAngle;

public class CloudsModel<T extends LivingEntity> extends PlayerModel<T> {

    private ModelRenderer cloud2;
    private ModelRenderer cloud1;
    private ModelRenderer cloud4;
    private ModelRenderer cloud3;
    public float rotation;

    public CloudsModel(float inflate, boolean slim) {
        super(inflate, slim);

        cloud2 = new ModelRenderer(this);
        this.body.addChild(cloud2);
        cloud2.setPos(0.0F, 1.0F, 0.0F);
        cloud2.texOffs(24, 0).addBox(-8.75F, 6.0F, 6.25F, 4.0F, 2.0F, 4.0F, 0.0F, false);
        cloud2.texOffs(24, 0).addBox(-12.75F, 6.0F, 6.25F, 4.0F, 2.0F, 4.0F, 0.0F, false);
        cloud2.texOffs(24, 0).addBox(-12.75F, 6.0F, 2.25F, 4.0F, 2.0F, 4.0F, 0.0F, false);
        cloud2.texOffs(24, 0).addBox(-12.75F, 4.0F, 6.25F, 4.0F, 2.0F, 4.0F, 0.0F, false);

        cloud1 = new ModelRenderer(this);
        this.body.addChild(cloud1);
        cloud1.setPos(0.0F, 0.0F, 0.0F);
        cloud1.texOffs(24, 0).addBox(-11.25F, -2.0F, 0.0F, 4.0F, 2.0F, 4.0F, 0.0F, false);
        cloud1.texOffs(24, 0).addBox(-15.25F, -2.0F, -3.0F, 4.0F, 2.0F, 4.0F, 0.0F, false);

        cloud4 = new ModelRenderer(this);
        this.body.addChild(cloud4);
        cloud4.setPos(0.0F, 0.0F, -2.0F);
        cloud4.texOffs(24, 0).addBox(2.0F, 13.0F, -13.0F, 4.0F, 2.0F, 4.0F, 0.0F, false);
        cloud4.texOffs(24, 0).addBox(-2.0F, 13.0F, -9.0F, 4.0F, 2.0F, 4.0F, 0.0F, false);
        cloud4.texOffs(24, 0).addBox(-2.0F, 15.0F, -13.0F, 4.0F, 2.0F, 4.0F, 0.0F, false);
        cloud4.texOffs(24, 0).addBox(-6.0F, 13.0F, -13.0F, 4.0F, 2.0F, 4.0F, 0.0F, false);
        cloud4.texOffs(24, 0).addBox(-2.0F, 13.0F, -13.0F, 4.0F, 2.0F, 4.0F, 0.0F, false);

        cloud3 = new ModelRenderer(this);
        this.body.addChild(cloud3);
        cloud3.setPos(0.0F, 0.0F, 0.0F);
        cloud3.texOffs(24, 0).addBox(3.0F, -13.0F, 7.0F, 4.0F, 2.0F, 4.0F, 0.0F, false);
        cloud3.texOffs(24, 0).addBox(-1.0F, -13.0F, 11.0F, 4.0F, 2.0F, 4.0F, 0.0F, false);
        cloud3.texOffs(24, 0).addBox(-1.0F, -15.0F, 7.0F, 4.0F, 2.0F, 4.0F, 0.0F, false);
        cloud3.texOffs(24, 0).addBox(-5.0F, -13.0F, 11.0F, 4.0F, 2.0F, 4.0F, 0.0F, false);
        cloud3.texOffs(24, 0).addBox(-1.0F, -13.0F, 7.0F, 4.0F, 2.0F, 4.0F, 0.0F, false);
        cloud3.texOffs(24, 0).addBox(-5.0F, -13.0F, 7.0F, 4.0F, 2.0F, 4.0F, 0.0F, false);

    }
    public void updateRotation(){
        setRotationAngle(cloud2, 0.0F, -rotation, 0.0F);
        setRotationAngle(cloud1, 0.0F, rotation, 0.0F);
        setRotationAngle(cloud4, 0.0F, rotation, 0.0F);
        setRotationAngle(cloud3, 0.0F, -rotation, 0.0F);
        if (rotation >= 360F){
            rotation = 0F;
        }
        this.rotation += 0.005F;
    }
}