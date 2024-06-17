package com.hk47bot.rotp_wr.network;

import com.github.standobyte.jojo.network.packets.IModPacketHandler;
import com.hk47bot.rotp_wr.capability.PlayerWeatherChangeCapabilityProvider;
import com.hk47bot.rotp_wr.client.ui.weather.WeatherChangeMenu;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class PlayerWeatherChangePacket {
    private String weatherType;
    public PlayerWeatherChangePacket(String weatherType){
        this.weatherType = weatherType;
    }
    public static class Handler implements IModPacketHandler<PlayerWeatherChangePacket> {
        @Override
        public void encode(PlayerWeatherChangePacket msg, PacketBuffer buf) {
            buf.writeUtf(msg.weatherType);
        }
        @Override
        public PlayerWeatherChangePacket decode(PacketBuffer buf) {
            String packetType = buf.readUtf();
            return new PlayerWeatherChangePacket(packetType);
        }
        @Override
        public void handle(PlayerWeatherChangePacket msg, Supplier<NetworkEvent.Context> ctx) {
            ServerPlayerEntity player = ctx.get().getSender();
            player.getCapability(PlayerWeatherChangeCapabilityProvider.CAPABILITY).ifPresent(cap -> {
                cap.setCurrentWeatherType(WeatherChangeMenu.WeatherType.getByWeatherType(msg.weatherType));
            });
        }
        @Override
        public Class<PlayerWeatherChangePacket> getPacketClass() {
            return PlayerWeatherChangePacket.class;
        }
    }
}
