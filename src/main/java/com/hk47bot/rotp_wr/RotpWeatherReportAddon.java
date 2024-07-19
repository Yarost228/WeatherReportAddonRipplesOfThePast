package com.hk47bot.rotp_wr;

import com.hk47bot.rotp_wr.init.*;
import com.hk47bot.rotp_wr.network.AddonPackets;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(RotpWeatherReportAddon.MOD_ID)
public class RotpWeatherReportAddon {
    // The value here should match an entry in the META-INF/mods.toml file
    public static final String MOD_ID = "rotp_wr";
    private static final Logger LOGGER = LogManager.getLogger();

    public RotpWeatherReportAddon() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        InitEntities.ENTITIES.register(modEventBus);
        InitSounds.SOUNDS.register(modEventBus);
        InitStands.ACTIONS.register(modEventBus);
        InitStands.STANDS.register(modEventBus);
        InitEffects.EFFECTS.register(modEventBus);
        InitBlocks.BLOCKS.register(modEventBus);
    }
    public static Logger getLogger() {
        return LOGGER;
    }
}
