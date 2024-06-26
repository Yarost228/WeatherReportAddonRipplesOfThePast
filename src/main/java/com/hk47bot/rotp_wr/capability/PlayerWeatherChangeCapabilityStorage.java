package com.hk47bot.rotp_wr.capability;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;

public class PlayerWeatherChangeCapabilityStorage implements Capability.IStorage<PlayerWeatherChangeCapability> {

    @Override public INBT writeNBT(Capability<PlayerWeatherChangeCapability> capability, PlayerWeatherChangeCapability instance, Direction side) {
        CompoundNBT nbt =new CompoundNBT();
        return nbt;
    }
    @Override public void readNBT(Capability<PlayerWeatherChangeCapability> capability, PlayerWeatherChangeCapability instance, Direction side, INBT nbt) {
        CompoundNBT cnbt = (CompoundNBT) nbt;
        if (cnbt.contains("NotificationsSent", 10)) {
            CompoundNBT notificationsMap = cnbt.getCompound("NotificationsSent");
        }
    }
}
