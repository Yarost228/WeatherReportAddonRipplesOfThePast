package com.hk47bot.rotp_wr.action.stand;

import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.init.ModBlocks;
import com.github.standobyte.jojo.init.ModStatusEffects;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.github.standobyte.jojo.util.general.GeneralUtil;

import com.hk47bot.rotp_wr.init.InitBlocks;
import com.hk47bot.rotp_wr.init.InitParticles;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CampfireBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import java.util.ArrayList;

import static com.hk47bot.rotp_wr.block.BloodPuddleBlock.FACING;
import static com.hk47bot.rotp_wr.block.BloodPuddleBlock.STAGE;

public class WeatherReportColdWind extends StandEntityAction {

    public WeatherReportColdWind(StandEntityAction.Builder builder) {
        super(builder);
    }

    @Override
    public void standTickPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        double RANGE = 16;
        Vector3d wrLookVec = standEntity.getLookAngle();
        world.getEntities(standEntity, standEntity.getBoundingBox().inflate(RANGE, RANGE, RANGE),
                entity -> wrLookVec.dot(entity.position().subtract(standEntity.position()).normalize()) > 0.886 && entity.distanceToSqr(standEntity) > 0.5
        ).forEach(entity -> {
            if (entity.canUpdate()) {
                double distance = entity.distanceTo(standEntity);
                Vector3d pushVec = wrLookVec.normalize().scale(0.5 * standEntity.getStandEfficiency());
                entity.setDeltaMovement(distance > 2 ?
                        entity.getDeltaMovement().add(pushVec.scale(1/distance*2))
                        : pushVec.scale(Math.max(distance - 1, 0)));
                if (entity instanceof LivingEntity){
                    LivingEntity effectTarget = (LivingEntity) entity;
                    effectTarget.addEffect(new EffectInstance(ModStatusEffects.FREEZE.get(), 200, 0));
                    if (effectTarget.isOnFire()){
                        effectTarget.setRemainingFireTicks(2);
                    }
                    if (effectTarget instanceof BlazeEntity){
                        BlazeEntity blaze = (BlazeEntity) effectTarget;
                        blaze.hurt(DamageSource.DROWN, 1.0F);
                     }
                }
            }
        });
        if (world.isClientSide()) {
            GeneralUtil.doFractionTimes(() -> {
                LivingEntity user = userPower.getUser();
                Vector3d userPos = standEntity.position().add(
                        (Math.random() - 0.5) * (user.getBbWidth() + 1.0),
                        Math.random() * (user.getBbHeight() + 1.0),
                        (Math.random() - 0.5) * (user.getBbWidth() + 1.0));
                Vector3d particlePos = userPos.add(wrLookVec.scale(2)
                        .xRot((float) ((Math.random() * 2 - 1) * Math.PI / 6))
                        .yRot((float) ((Math.random() * 2 - 1) * Math.PI / 6)));
                Vector3d vecToStand = userPos.subtract(particlePos).normalize().scale(0.75);
                world.addParticle(InitParticles.REVERSE_AIR_STREAM.get(), particlePos.x, particlePos.y, particlePos.z, vecToStand.x,  vecToStand.y, vecToStand.z);
                world.addParticle(ParticleTypes.CLOUD, particlePos.x, particlePos.y, particlePos.z, -vecToStand.x,  -vecToStand.y, -vecToStand.z);
            }, 5);
        }
        RayTraceResult target = standEntity.aimWithStandOrUser(RANGE, task.getTarget());
        Vector3d pos = target.getLocation();
        BlockPos targetedBlockPos = new BlockPos(pos);
        getBlocksAroundPos(targetedBlockPos).stream().forEach(blockpos -> {
            BlockState targetedBlockState = world.getBlockState(blockpos);
            if (targetedBlockState.is(BlockTags.CAMPFIRES)){
                world.setBlockAndUpdate(blockpos, targetedBlockState.setValue(CampfireBlock.LIT, false));
            }
            else if (targetedBlockState.is(Blocks.FIRE) || targetedBlockState.is(ModBlocks.MAGICIANS_RED_FIRE.get())){
                world.setBlockAndUpdate(blockpos, Blocks.AIR.defaultBlockState());
            }
            else if (targetedBlockState.getBlock() == InitBlocks.BLOOD_PUDDLE.get()){
                world.setBlockAndUpdate(blockpos, InitBlocks.BLOOD_SPIKES.get().defaultBlockState().setValue(STAGE, targetedBlockState.getValue(STAGE)).setValue(FACING, targetedBlockState.getValue(FACING)));
            }
        });
    }
    private static ArrayList<BlockPos> getBlocksAroundPos(BlockPos pos){
        ArrayList<BlockPos> blockPosList = new ArrayList<>();
        blockPosList.add(pos.above());
        blockPosList.add(pos.above().north());
        blockPosList.add(pos.above().south());
        blockPosList.add(pos.above().east());
        blockPosList.add(pos.above().east().north());
        blockPosList.add(pos.above().east().south());
        blockPosList.add(pos.above().west());
        blockPosList.add(pos.above().west().north());
        blockPosList.add(pos.above().west().south());
        blockPosList.add(pos);
        blockPosList.add(pos.north());
        blockPosList.add(pos.south());
        blockPosList.add(pos.east());
        blockPosList.add(pos.east().north());
        blockPosList.add(pos.east().south());
        blockPosList.add(pos.west());
        blockPosList.add(pos.west().north());
        blockPosList.add(pos.west().south());
        blockPosList.add(pos.below());
        blockPosList.add(pos.below().north());
        blockPosList.add(pos.below().south());
        blockPosList.add(pos.below().east());
        blockPosList.add(pos.below().east().north());
        blockPosList.add(pos.below().east().south());
        blockPosList.add(pos.below().west());
        blockPosList.add(pos.below().west().north());
        blockPosList.add(pos.below().west().south());
        return blockPosList;
    }
}