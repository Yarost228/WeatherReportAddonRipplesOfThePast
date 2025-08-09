package com.hk47bot.rotp_wr.block;

import com.hk47bot.rotp_wr.util.WRDamageUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
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
    public boolean canSurvive(BlockState state, IWorldReader world, BlockPos pos) {
        BlockState blockstate = world.getBlockState(pos.below());
        return Block.isFaceFull(blockstate.getCollisionShape(world, pos.below()), Direction.UP) && (blockstate.getBlock() != Blocks.AIR && blockstate.getBlock() != Blocks.CAVE_AIR);
    }
    public BlockState updateShape(BlockState p_196271_1_, Direction p_196271_2_, BlockState p_196271_3_, IWorld p_196271_4_, BlockPos p_196271_5_, BlockPos p_196271_6_) {
        return !p_196271_1_.canSurvive(p_196271_4_, p_196271_5_) ? Blocks.AIR.defaultBlockState() : super.updateShape(p_196271_1_, p_196271_2_, p_196271_3_, p_196271_4_, p_196271_5_, p_196271_6_);
    }
}
