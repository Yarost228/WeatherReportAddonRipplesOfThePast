package com.hk47bot.rotp_wr.action.stand;

import com.github.standobyte.jojo.action.ActionTarget;
import com.github.standobyte.jojo.action.ActionTarget.TargetType;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;

import com.github.standobyte.jojo.util.general.GeneralUtil;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class WeatherReportLightning extends StandEntityAction {

    public WeatherReportLightning(StandEntityAction.Builder builder) {
        super(builder);
    }


    @Override
    public void standPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        if (!world.isClientSide()) {
            RayTraceResult target = standEntity.aimWithStandOrUser(100, task.getTarget());
            Vector3d pos = target.getLocation();
            if (pos != null) {
                int count;
                if (world.isRaining()){
                    if (world.isThundering()){
                        count = 9;
                    }
                    else {
                        count = 6;
                    }
                }
                else {
                    count = 3;
                }
                GeneralUtil.doFractionTimes(() -> {
                    LightningBoltEntity bolt = EntityType.LIGHTNING_BOLT.create(world);
                    bolt.moveTo(pos);
                    bolt.setCause((ServerPlayerEntity) userPower.getUser());
                    world.addFreshEntity(bolt);
                }, count);
            }
        }
    }
    @Override
    protected boolean standKeepsTarget(ActionTarget target) {
        return target.getType() == TargetType.ENTITY && target.getEntity() instanceof LivingEntity;
    }
}
