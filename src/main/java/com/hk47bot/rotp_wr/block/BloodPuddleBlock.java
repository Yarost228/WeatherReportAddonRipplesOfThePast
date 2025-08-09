package com.hk47bot.rotp_wr.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;

public class BloodPuddleBlock extends Block {
    public static final IntegerProperty STAGE = IntegerProperty.create("stage", 0, 3);
    public static final DirectionProperty FACING = HorizontalBlock.FACING;
    private static final VoxelShape SHAPE_N = Block.box(2, 0.1, 2, 14, 0.1, 14);
    public BloodPuddleBlock(Properties properties){
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(STAGE, 0).setValue(FACING, Direction.NORTH));
    }
    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(STAGE);
        builder.add(FACING);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
        return SHAPE_N;
    }

    public static Direction randomDirection(){
        double random = (Math.random() + Math.random() + Math.random() + Math.random());
        if (random >= 0 && random <= 1){
            return Direction.NORTH;
        }
        if (random >= 1 && random <= 2){
            return Direction.WEST;
        }
        if (random >= 2 && random <= 3){
            return Direction.SOUTH;
        }
        else {
            return Direction.EAST;
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
