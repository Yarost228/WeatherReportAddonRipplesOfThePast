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

    public WeatherReportFuguRain(StandEntityAction.Builder builder) {
        super(builder);
    }
    
    @Override
    protected ActionConditionResult checkSpecificConditions(LivingEntity user, IStandPower power, ActionTarget target) {
        BlockPos userPos = new BlockPos(user.getPosition(1));
        if (!user.level.canSeeSky(userPos)){
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

            if (pos != null) {
                
                if (world.getLevelData().isRaining() && userPower.getResolveLevel() >= 3 && world.canSeeSky(standpos)){
                FugaSummonerEntity summoner = new FugaSummonerEntity(world);
                summoner.moveTo(pos);
                summoner.moveTo(summoner.getX(), summoner.getY()+45, summoner.getZ());
                world.addFreshEntity(summoner);

                }
            }
        }
    }
}
