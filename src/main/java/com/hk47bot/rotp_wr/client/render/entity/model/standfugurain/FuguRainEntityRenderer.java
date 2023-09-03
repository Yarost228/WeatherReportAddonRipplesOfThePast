package com.hk47bot.rotp_wr.client.render.entity.model.standfugurain;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.container.PlayerContainer;
import net.minecraft.util.ResourceLocation;

public class FuguRainEntityRenderer extends EntityRenderer<Entity> {

	public FuguRainEntityRenderer(EntityRendererManager renderManager) {
		super(renderManager);
	}

	@Override
	public ResourceLocation getTextureLocation(Entity entity) {
		return PlayerContainer.BLOCK_ATLAS;
	}
}
