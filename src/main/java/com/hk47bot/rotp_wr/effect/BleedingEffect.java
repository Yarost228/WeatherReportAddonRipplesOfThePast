package com.hk47bot.rotp_wr.effect;

import com.github.standobyte.jojo.init.ModParticles;
import com.hk47bot.rotp_wr.RotpWeatherReportAddon;
import com.hk47bot.rotp_wr.block.BloodPuddleBlock;
import com.hk47bot.rotp_wr.init.InitBlocks;
import com.hk47bot.rotp_wr.util.WRDamageUtil;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.RedstoneWireBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import static com.hk47bot.rotp_wr.block.BloodPuddleBlock.FACING;
import static com.hk47bot.rotp_wr.block.BloodPuddleBlock.STAGE;

public class BleedingEffect extends Effect {
    public BleedingEffect(EffectType type, int color){super(type, color);}

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        int k = 50 >> amplifier;
        if (k > 0) {
            return duration % k == 0;
        }
        else {
            return true;
        }
    }

    public void applyEffectTick(LivingEntity user, int amplifier) {
        World world = user.level;
        double radius = (double) amplifier * (Math.random() - 0.5);
        if (!world.isClientSide()) {
            user.hurt(WRDamageUtil.bleeding, (float) amplifier / 2);
        }
        for (int i = 0; i < amplifier; i++) {
            Vector3d particlePos = user.position().add(
                    (Math.random() - 0.5) * (user.getBbWidth() + radius),
                    Math.random() * (user.getBbHeight()),
                    (Math.random() - 0.5) * (user.getBbWidth() + radius));
            user.level.addParticle(ModParticles.BLOOD.get(), particlePos.x, particlePos.y, particlePos.z, 0, 0, 0);
            if (Math.random() > 0.8){
                BlockPos pos = new BlockPos(particlePos.x(), particlePos.y(), particlePos.z());
                if (world.getBlockState(pos.below()).getBlock() != Blocks.AIR
                        && world.getBlockState(pos.below()).getBlock() != InitBlocks.BLOOD_PUDDLE.get()
                        && world.getBlockState(pos.below()).isFaceSturdy(world, pos.below(), Direction.UP)
                        && world.getBlockState(pos).getBlock() == Blocks.AIR
                        && world.getBlockState(pos).getBlock() != InitBlocks.BLOOD_SPIKES.get()) {
                    if (world.getBlockState(pos).getBlock() != InitBlocks.BLOOD_PUDDLE.get()) {
                        world.setBlockAndUpdate(pos, InitBlocks.BLOOD_PUDDLE.get().defaultBlockState().setValue(STAGE, 0).setValue(FACING, BloodPuddleBlock.randomDirection()));
                    }
                    world.getBlockStates(new AxisAlignedBB(user.position(), user.position()).inflate(amplifier)).forEach(state -> {
                        if (state.getBlock() == InitBlocks.BLOOD_PUDDLE.get() && state.getValue(STAGE) < 3 && Math.random() < 0.2){
                            world.setBlockAndUpdate(pos, state.setValue(STAGE,state.getValue(STAGE) + 1));
                        }
                    });
                }
            }
        }
    }
}
