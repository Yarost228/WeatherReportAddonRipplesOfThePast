package com.hk47bot.rotp_wr.init;

import com.hk47bot.rotp_wr.RotpWeatherReportAddon;
import com.hk47bot.rotp_wr.effect.BleedingEffect;
import com.hk47bot.rotp_wr.effect.CloudShieldEffect;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = RotpWeatherReportAddon.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class InitEffects {
    public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, RotpWeatherReportAddon.MOD_ID);

    public static final RegistryObject<Effect> CLOUD_SHIELD_EFFECT = EFFECTS.register ("cloud_shield_effect",
            () -> new CloudShieldEffect(EffectType.BENEFICIAL, 0x404040));

    public static final RegistryObject<Effect> BLEEDING = EFFECTS.register ("bleeding",
            () -> new BleedingEffect(EffectType.BENEFICIAL, 0x9a0000));
}
