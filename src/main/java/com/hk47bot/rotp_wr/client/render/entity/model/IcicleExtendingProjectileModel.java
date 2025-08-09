package com.hk47bot.rotp_wr.client.render.entity.model;

import com.github.standobyte.jojo.client.render.entity.model.ownerbound.repeating.RepeatingModel;
import com.hk47bot.rotp_wr.entity.IcicleExtendingProjectileEntity;
import net.minecraft.client.renderer.model.ModelRenderer;

import static com.github.standobyte.jojo.client.ClientUtil.setRotationAngle;

public class IcicleExtendingProjectileModel extends RepeatingModel<IcicleExtendingProjectileEntity> {

    private final ModelRenderer icicle;
    private final ModelRenderer icicle_end;

    public IcicleExtendingProjectileModel() {
        texWidth = 32;
        texHeight = 32;

        icicle = new ModelRenderer(this);
        setRotationAngle(icicle, 0.0F, 0.0F, -0.7854F);
        icicle.texOffs(0, 0).addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 8.0F, 0.0F, false);

        icicle_end = new ModelRenderer(this);
        icicle_end.setPos(0.0F, 0.0F, -4.0F);
        setRotationAngle(icicle_end, 0.0F, 0.0F, 0.7854F);
        icicle_end.texOffs(1, 2).addBox(0.0F, -1.5F, -3.0F, 0.0F, 3.0F, 3.0F, 0.0F, false);
        icicle_end.texOffs(-2, 2).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 0.0F, 3.0F, 0.0F, false);
    }
    @Override
    protected ModelRenderer getMainPart() {
        return icicle_end;
    }

    @Override
    protected float getMainPartLength() {
        return 2F;
    }

    @Override
    protected ModelRenderer getRepeatingPart() {
        return icicle;
    }

    @Override
    protected float getRepeatingPartLength() {
        return 8F;
    }
}
