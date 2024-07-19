package com.hk47bot.rotp_wr.network;

import com.github.standobyte.jojo.network.packets.IModPacketHandler;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.Random;
import java.util.function.Supplier;

public class VanillaWeatherChangePacket {
    private String weatherType;
    public VanillaWeatherChangePacket(String weatherType){
        this.weatherType = weatherType;
    }
    public static class Handler implements IModPacketHandler<VanillaWeatherChangePacket> {
        @Override
        public void encode(VanillaWeatherChangePacket msg, PacketBuffer buf) {
            buf.writeUtf(msg.weatherType);
        }
        @Override
        public VanillaWeatherChangePacket decode(PacketBuffer buf) {
            String packetType = buf.readUtf(32767);
            return new VanillaWeatherChangePacket(packetType);
        }
        @Override
        public void handle(VanillaWeatherChangePacket msg, Supplier<NetworkEvent.Context> ctx) {
            NetworkEvent.Context context = ctx.get();
            ServerPlayerEntity player = ctx.get().getSender();
            if (player != null){
                Random RANDOM = new Random();
                int rainTime = RANDOM.nextInt(12000) + 3600;
                int clearTime = RANDOM.nextInt(168000) + 12000;
                World world = player.level;
                ServerWorld serverWorld = (ServerWorld) world;
                switch (msg.weatherType) {
                    case "none":
                        serverWorld.setWeatherParameters(clearTime, 0, false, false);
                        break;
                    case "rain":
                        serverWorld.setWeatherParameters(0, rainTime, true, false);
                        break;
                    case "thundering":
                        serverWorld.setWeatherParameters(0, rainTime, true, true);
                        break;
                }
            }
            context.setPacketHandled(true);
        }
        @Override
        public Class<VanillaWeatherChangePacket> getPacketClass() {
            return VanillaWeatherChangePacket.class;
        }
    }
}
