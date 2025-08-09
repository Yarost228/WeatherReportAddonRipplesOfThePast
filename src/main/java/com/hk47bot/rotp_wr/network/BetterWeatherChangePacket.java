package com.hk47bot.rotp_wr.network;

import com.github.standobyte.jojo.network.packets.IModPacketHandler;
import corgitaco.betterweather.helpers.BetterWeatherWorldData;
import corgitaco.betterweather.weather.BWWeatherEventContext;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.Random;
import java.util.function.Supplier;

public class BetterWeatherChangePacket {
    private String weatherType;
    public BetterWeatherChangePacket(String weatherType){
        this.weatherType = weatherType;
    }
    public static class Handler implements IModPacketHandler<BetterWeatherChangePacket> {
        @Override
        public void encode(BetterWeatherChangePacket msg, PacketBuffer buf) {
            buf.writeUtf(msg.weatherType);
        }
        @Override
        public BetterWeatherChangePacket decode(PacketBuffer buf) {
            String packetType = buf.readUtf(32767);
            return new BetterWeatherChangePacket(packetType);
        }
        @Override
        public void handle(BetterWeatherChangePacket msg, Supplier<NetworkEvent.Context> ctx) {
            NetworkEvent.Context context = ctx.get();
            ServerPlayerEntity player = ctx.get().getSender();
            if (player != null){
                Random RANDOM = new Random();
                int rainTime = RANDOM.nextInt(12000) + 3600;
                World world = player.level;
                ServerWorld serverWorld = (ServerWorld)world;
                BWWeatherEventContext weatherEventContext = ((BetterWeatherWorldData) serverWorld).getWeatherEventContext();
                weatherEventContext.setWeatherForced(true);
                weatherEventContext.weatherForcer(msg.weatherType, rainTime, serverWorld);
            }
            context.setPacketHandled(true);
        }
        @Override
        public Class<BetterWeatherChangePacket> getPacketClass() {
            return BetterWeatherChangePacket.class;
        }
    }
}
