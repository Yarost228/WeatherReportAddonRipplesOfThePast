package com.hk47bot.rotp_wr.action.stand;

import com.github.standobyte.jojo.action.ActionConditionResult;
import com.github.standobyte.jojo.action.ActionTarget;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.hk47bot.rotp_wr.entity.fugurain.FugaSummonerEntity;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class WeatherReportFuguRain extends StandEntityAction {

    public WeatherReportFuguRain(Builder builder) {
        super(builder);
    }

    @Override
    protected ActionConditionResult checkStandConditions(StandEntity stand, IStandPower power, ActionTarget target) {
        LivingEntity user = stand.getUser();
        RayTraceResult targetedRT = stand.aimWithStandOrUser(25, target);
        Vector3d pos = targetedRT.getLocation();
        BlockPos standpos = new BlockPos(pos);
            if (!user.level.canSeeSky(standpos)){
                return conditionMessage("fugurain-warningneedtoseesky");
            }
            if (!user.level.getLevelData().isRaining()){
                return conditionMessage("fugurain-warningrain");
            }
        else {
                return super.checkSpecificConditions(user, power, target);
            }

    }
    @Override
    public void standPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        if (!world.isClientSide()) {
            RayTraceResult target = standEntity.aimWithStandOrUser(25, task.getTarget());
            Vector3d pos = target.getLocation();
            BlockPos standpos = new BlockPos(pos);
            if (world.getLevelData().isRaining() && world.canSeeSky(standpos)){
                FugaSummonerEntity summoner = new FugaSummonerEntity(world);
                summoner.setUser(userPower.getUser());
                summoner.moveTo(pos);
                summoner.moveTo(summoner.getX(), summoner.getY()+45, summoner.getZ());
                world.addFreshEntity(summoner);
            }
        }
    }
}

