package com.hk47bot.rotp_wr.block;

import com.hk47bot.rotp_wr.util.WRDamageUtil;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class BloodSpikesBlock extends BloodPuddleBlock{

    public BloodSpikesBlock(Properties properties){
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(STAGE, 0).setValue(FACING, Direction.NORTH));
    }

    @Override
    public void entityInside(BlockState state, World world, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity){
            entity.makeStuckInBlock(state, new Vector3d(0.8D, 0.75D, 0.8D));
            LivingEntity livingEntity = (LivingEntity) entity;
            livingEntity.hurt(WRDamageUtil.ice_spikes, (float) (state.getValue(STAGE)+1)/2);
        }
    }
}
