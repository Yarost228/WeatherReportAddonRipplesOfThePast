package com.hk47bot.rotp_wr.init;

import com.hk47bot.rotp_wr.RotpWeatherReportAddon;
import com.hk47bot.rotp_wr.block.BloodPuddleBlock;

import com.hk47bot.rotp_wr.block.BloodSpikesBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class InitBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, RotpWeatherReportAddon.MOD_ID);

    public static final RegistryObject<BloodPuddleBlock> BLOOD_PUDDLE = BLOCKS.register("blood_puddle",
            () -> new BloodPuddleBlock(AbstractBlock.Properties.of(Material.DECORATION).noCollission().sound(SoundType.SLIME_BLOCK).strength(0.1F).isValidSpawn((state, reader, pos, entityType) -> false)));

    public static final RegistryObject<BloodPuddleBlock> BLOOD_SPIKES = BLOCKS.register("blood_spikes",
            () -> new BloodSpikesBlock(AbstractBlock.Properties.of(Material.DECORATION).noCollission().sound(SoundType.GLASS).strength(0.75F).isValidSpawn((state, reader, pos, entityType) -> false)));

}
