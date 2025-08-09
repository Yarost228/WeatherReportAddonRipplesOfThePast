package com.hk47bot.rotp_wr.action.stand;

import com.github.standobyte.jojo.action.ActionTarget;
import com.github.standobyte.jojo.action.stand.StandAction;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.hk47bot.rotp_wr.init.InitEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.world.World;

public class WeatherReportGiveCloudShield extends StandAction {
    public WeatherReportGiveCloudShield(StandAction.Builder builder){super(builder);}

    public TargetRequirement getTargetRequirement() {
        return TargetRequirement.ENTITY;
    }

    @Override
    protected void perform(World world, LivingEntity user, IStandPower power, ActionTarget target) {
        Entity entity = target.getEntity();
        if (entity instanceof LivingEntity){
            LivingEntity livingEntity = (LivingEntity) entity;
            livingEntity.addEffect(new EffectInstance(InitEffects.CLOUD_SHIELD_EFFECT.get(), 1200, 0, false, false, true));
        }
    }
}
