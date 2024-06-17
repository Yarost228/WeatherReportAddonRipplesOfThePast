package com.hk47bot.rotp_wr.capability;

import com.github.standobyte.jojo.capability.entity.ClientPlayerUtilCap;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class PlayerWeatherChangeCapabilityProvider implements ICapabilitySerializable<INBT> {
    @CapabilityInject(PlayerWeatherChangeCapability.class)
    public static Capability<PlayerWeatherChangeCapability> CAPABILITY = null;
    private LazyOptional<PlayerWeatherChangeCapability> instance;

    public PlayerWeatherChangeCapabilityProvider(PlayerEntity player) {
        this.instance = LazyOptional.of(() -> new PlayerWeatherChangeCapability(player));
    }

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        return CAPABILITY.orEmpty(cap, instance);
    }
    @Override
    public INBT serializeNBT() {
        return CAPABILITY.getStorage().writeNBT(CAPABILITY, instance.orElseThrow(
                () -> new IllegalArgumentException("Player capability LazyOptional is not attached.")), null);
    }

    @Override
    public void deserializeNBT(INBT nbt) {
        CAPABILITY.getStorage().readNBT(CAPABILITY, instance.orElseThrow(
                () -> new IllegalArgumentException("Player capability LazyOptional is not attached.")), null, nbt);
    }

}
