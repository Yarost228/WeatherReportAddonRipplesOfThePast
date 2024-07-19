package com.hk47bot.rotp_wr.action.stand;

import com.github.standobyte.jojo.action.stand.StandEntityAction;

import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.hk47bot.rotp_wr.entity.IcicleExtendingProjectileEntity;
import net.minecraft.world.World;

public class WeatherReportIcicleStrike extends StandEntityAction {
    public WeatherReportIcicleStrike(StandEntityAction.Builder builder){super(builder);}

    @Override
    public void onTaskSet(World world, StandEntity standEntity, IStandPower standPower, Phase phase, StandEntityTask task, int ticks) {
        super.onTaskSet(world, standEntity, standPower, phase, task, ticks);
        if (!world.isClientSide()) {
            IcicleExtendingProjectileEntity icicleExtendingProjectile = new IcicleExtendingProjectileEntity(world, standEntity);
            standEntity.addProjectile(icicleExtendingProjectile);
        }
    }
}
