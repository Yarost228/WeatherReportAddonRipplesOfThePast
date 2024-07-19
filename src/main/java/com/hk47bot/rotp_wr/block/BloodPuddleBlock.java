package com.hk47bot.rotp_wr.block;

import com.google.common.base.CharMatcher;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.fluid.WaterFluid;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

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
}
