package com.hk47bot.rotp_wr.util;

import com.github.standobyte.jojo.action.stand.effect.DriedBloodDrops;
import com.github.standobyte.jojo.advancements.ModCriteriaTriggers;
import com.github.standobyte.jojo.block.StoneMaskBlock;
import com.github.standobyte.jojo.entity.damaging.projectile.CDBloodCutterEntity;
import com.github.standobyte.jojo.init.*;
import com.github.standobyte.jojo.init.power.non_stand.ModPowers;
import com.github.standobyte.jojo.init.power.stand.ModStandEffects;
import com.github.standobyte.jojo.init.power.stand.ModStandsInit;
import com.github.standobyte.jojo.item.StoneMaskItem;
import com.github.standobyte.jojo.power.impl.nonstand.INonStandPower;
import com.github.standobyte.jojo.power.impl.nonstand.type.pillarman.PillarmanData;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.github.standobyte.jojo.tileentity.StoneMaskTileEntity;
import com.github.standobyte.jojo.util.general.GeneralUtil;
import com.github.standobyte.jojo.util.mc.damage.DamageUtil;
import com.hk47bot.rotp_wr.RotpWeatherReportAddon;
import com.hk47bot.rotp_wr.block.BloodPuddleBlock;
import com.hk47bot.rotp_wr.init.InitBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.Optional;

import static com.hk47bot.rotp_wr.block.BloodPuddleBlock.FACING;
import static com.hk47bot.rotp_wr.block.BloodPuddleBlock.STAGE;
import static net.minecraft.block.HorizontalFaceBlock.FACE;

@Mod.EventBusSubscriber(modid = RotpWeatherReportAddon.MOD_ID)
public class GameplayUtil {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onLivingUpdate(LivingEvent.LivingUpdateEvent event){
        if (event.getEntityLiving().hasEffect(ModStatusEffects.BLEEDING.get())){
            LivingEntity user = event.getEntityLiving();
            World world = user.level;
            float amplifier = user.getEffect(ModStatusEffects.BLEEDING.get()).getAmplifier()+2;
            double radius = (double) amplifier * (Math.random() - 0.5);
            AxisAlignedBB aabb = new AxisAlignedBB(user.position().subtract(radius, radius, radius), user.position().add(radius, radius, radius));
            List<LivingEntity> entitiesAround = world.getEntitiesOfClass(LivingEntity.class, aabb,
                    EntityPredicates.ENTITY_STILL_ALIVE.and(EntityPredicates.NO_SPECTATORS)
                            .and(entity -> {
                                return world.clip(new RayTraceContext(user.position(), entity.getBoundingBox().getCenter(),
                                                RayTraceContext.BlockMode.COLLIDER, RayTraceContext.FluidMode.NONE, entity))
                                        .getType() == RayTraceResult.Type.MISS;
                            }));
            for (LivingEntity entity : entitiesAround) {
                if (dropBloodOnEntity(Optional.of(user), entity, 0.1F)) {
                    user.position().add(entity.getEyePosition(1.0F));
                }
            }
            Vector3d particlePos = user.position().add(
                    (Math.random() - 0.5) * (user.getBbWidth() + radius),
                    Math.random() * (user.getBbHeight()),
                    (Math.random() - 0.5) * (user.getBbWidth() + radius));
            user.level.addParticle(ModParticles.BLOOD.get(), particlePos.x, particlePos.y, particlePos.z, 0, 0, 0);
            BlockPos pos = new BlockPos(particlePos.x(), particlePos.y(), particlePos.z());
            if (Math.random() > 0.8){
                if (world.getBlockState(pos.below()).getBlock() != Blocks.AIR
                        && !world.getBlockState(pos.below()).getBlock().hasDynamicShape()
                        && world.getBlockState(pos.below()).isFaceSturdy(world, pos.below(), Direction.UP)
                        && (world.getBlockState(pos).getBlock() == Blocks.AIR
                        || world.getBlockState(pos).getBlock() == Blocks.CAVE_AIR)
                        && world.getBlockState(pos).getBlock() != InitBlocks.BLOOD_SPIKES.get()) {
                    if (world.getBlockState(pos).getBlock() != InitBlocks.BLOOD_PUDDLE.get()) {
                        world.setBlockAndUpdate(pos, InitBlocks.BLOOD_PUDDLE.get().defaultBlockState().setValue(STAGE, 0).setValue(FACING, BloodPuddleBlock.randomDirection()));
                    }

                    world.getBlockStates(new AxisAlignedBB(user.position(), user.position()).inflate(radius)).forEach(state -> {
                        if (state.getBlock() == InitBlocks.BLOOD_PUDDLE.get() && state.getValue(STAGE) < 3 && Math.random() < 0.2){
                            world.setBlockAndUpdate(pos, state.setValue(STAGE,state.getValue(STAGE) + 1));
                        }

                    });
                }
            }
            BlockState blockState = world.getBlockState(pos);
            if (blockState.getBlock() == ModBlocks.STONE_MASK.get() && blockState.hasProperty(FACE)){
                world.playSound(null, pos, ModSounds.STONE_MASK_ACTIVATION.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
                switch (blockState.getValue(FACE)) {
                    case FLOOR:
                        TileEntity tileEntity = world.getBlockEntity(pos);
                        if (tileEntity instanceof StoneMaskTileEntity) {
                            ((StoneMaskTileEntity) tileEntity).activate();
                        }
                        particlePos.add(Vector3d.atBottomCenterOf(pos));
                        break;
                    default:
                        Block.popResource(world, pos, StoneMaskBlock.getItemFromBlock(world, pos, blockState));
                        world.removeBlock(pos, false);
                        particlePos.add(Vector3d.atCenterOf(pos));
                        break;
                }
            }
        }
    }
    private static boolean dropBloodOnEntity(Optional<LivingEntity> bleedingEntity, LivingEntity nearbyEntity, float bleedAmount) {
        boolean dropped = false;

        ItemStack headArmor = nearbyEntity.getItemBySlot(EquipmentSlotType.HEAD);
        if (headArmor.getItem() instanceof StoneMaskItem && applyStoneMask(nearbyEntity, headArmor)) {
            dropped = true;
        }

        dropped |= GeneralUtil.orElseFalse(bleedingEntity, entity -> {
            return nearbyEntity.getRandom().nextFloat() < bleedAmount / 5 &&
                    GeneralUtil.orElseFalse(IStandPower.getStandPowerOptional(entity), (IStandPower power) -> {
                        if (ModStandsInit.CRAZY_DIAMOND_BLOOD_CUTTER.get().isUnlocked(power) && CDBloodCutterEntity.canHaveBloodDropsOn(nearbyEntity, power)) {
                            DriedBloodDrops bloodDrops = power.getContinuousEffects().getOrCreateEffect(ModStandEffects.DRIED_BLOOD_DROPS.get(), nearbyEntity);
                            return bloodDrops.tickCount > 0;
                        }
                        return false;
                    });
        });

        return dropped;
    }

    public static boolean applyStoneMask(LivingEntity entity, ItemStack headStack) {
        if (entity.level.getDifficulty() == Difficulty.PEACEFUL) {
            if (entity instanceof ServerPlayerEntity) {
                ((ServerPlayerEntity) entity).displayClientMessage(
                        new TranslationTextComponent("jojo.chat.message.stone_mask_peaceful"), true);
            }
            return false;
        }
        if (entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;
            return INonStandPower.getNonStandPowerOptional(player).map(power -> {
                //Prevents aja-stone mask to work on non pillar men
                Optional<PillarmanData> pillarmanOptional = power.getTypeSpecificData(ModPowers.PILLAR_MAN.get());

                if (headStack.getItem() == ModItems.AJA_STONE_MASK.get()) {
                    if (!pillarmanOptional.isPresent()) {
                        if (entity instanceof ServerPlayerEntity) {
                            ModCriteriaTriggers.MASK_SUICIDE.get().trigger((ServerPlayerEntity) entity);
                        }
                        entity.hurt(DamageUtil.STONE_MASK, 1000);
                        return false;
                    } else {
                        PillarmanData pillarman = pillarmanOptional.get();
                        if (pillarmanOptional.get().getEvolutionStage() < 3) {
                            pillarman.setEvolutionStage(3);
                            //Gives a random Mode
                            switch (entity.getRandom().nextInt(3)) {
                                case 0:
                                    pillarman.setMode(PillarmanData.Mode.WIND);
                                    break;
                                case 1:
                                    pillarman.setMode(PillarmanData.Mode.HEAT);
                                    break;
                                case 2:
                                    pillarman.setMode(PillarmanData.Mode.LIGHT);
                                    break;
                            }
                            applyMaskEffect(entity, headStack);
                            return true;
                        }
                    }
                }
                else /*if (headStack.getItem() == ModItems.STONE_MASK.get())*/ {
                    if (pillarmanOptional.isPresent()) {
                        PillarmanData pillarman = pillarmanOptional.get();
                        if (pillarman.getEvolutionStage() < 2) {
                            pillarman.setEvolutionStage(2);
                            applyMaskEffect(entity, headStack);
                            return true;
                        }
                    }
                    else if (power.getTypeSpecificData(ModPowers.VAMPIRISM.get()).map(
                            vamp -> !vamp.isVampireAtFullPower()).orElse(false) || power.givePower(ModPowers.VAMPIRISM.get())) {
                        if (power.getType() == ModPowers.VAMPIRISM.get()) {
                            power.getTypeSpecificData(ModPowers.VAMPIRISM.get()).get().setVampireFullPower(true);
                            applyMaskEffect(entity, headStack);
                            return true;
                        }
                    }
                }
                return false;
            }).orElse(false);
        }
        return false;
    }

    private static void applyMaskEffect(LivingEntity entity, ItemStack headStack) {
        entity.level.playSound(null, entity, ModSounds.STONE_MASK_ACTIVATION_ENTITY.get(), entity.getSoundSource(), 1.0F, 1.0F);
        StoneMaskItem.setActivatedArmorTexture(headStack); // TODO light beams on stone mask activation
        headStack.hurtAndBreak(1, entity, stack -> {});
    }
}
