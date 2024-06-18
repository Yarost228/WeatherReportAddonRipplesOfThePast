package com.hk47bot.rotp_wr.network;

import com.github.standobyte.jojo.network.packets.IModPacketHandler;
import com.hk47bot.rotp_wr.RotpWeatherReportAddon;
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
            String packetType = buf.readUtf(32767);
            return new PlayerWeatherChangePacket(packetType);
        }
        @Override
        public void handle(PlayerWeatherChangePacket msg, Supplier<NetworkEvent.Context> ctx) {
            NetworkEvent.Context context = ctx.get();
            ServerPlayerEntity player = ctx.get().getSender();
            if (player != null){
                player.getCapability(PlayerWeatherChangeCapabilityProvider.CAPABILITY).resolve().ifPresent(cap -> {
                    if (msg.weatherType != null){
                        cap.setCurrentWeatherType(msg.weatherType);
                        System.out.println("Weather packet sent!");
                    }
                });
            }
            context.setPacketHandled(true);
        }
        @Override
        public Class<PlayerWeatherChangePacket> getPacketClass() {
            return PlayerWeatherChangePacket.class;
        }
    }
}
