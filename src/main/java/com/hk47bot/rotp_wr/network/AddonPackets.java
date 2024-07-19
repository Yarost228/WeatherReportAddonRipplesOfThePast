package com.hk47bot.rotp_wr.network;

import com.github.standobyte.jojo.network.packets.IModPacketHandler;
import com.hk47bot.rotp_wr.RotpWeatherReportAddon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

import java.util.Optional;

public class AddonPackets {
    private static final String PROTOCOL_VERSION = "1";
    private static SimpleChannel clientChannel;
    private static int packetIndex = 0;

    public static void init(){
        clientChannel = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(RotpWeatherReportAddon.MOD_ID, "client_channel"))
                .clientAcceptedVersions(PROTOCOL_VERSION::equals)
                .serverAcceptedVersions(PROTOCOL_VERSION::equals)
                .networkProtocolVersion(() -> PROTOCOL_VERSION)
                .simpleChannel();
        packetIndex = 0;
        registerMessage(clientChannel, new BetterWeatherChangePacket.Handler(), Optional.of(NetworkDirection.PLAY_TO_SERVER));
        registerMessage(clientChannel, new VanillaWeatherChangePacket.Handler(), Optional.of(NetworkDirection.PLAY_TO_SERVER));
    }
    private static <MSG> void registerMessage(SimpleChannel channel, IModPacketHandler<MSG> handler, Optional<NetworkDirection> networkDirection) {
        if (packetIndex > 127) {
            throw new IllegalStateException("Too many packets (> 127) registered for a single channel!");
        }
        channel.registerMessage(packetIndex++, handler.getPacketClass(), handler::encode, handler::decode, handler::enqueueHandleSetHandled, networkDirection);
    }
    public static void sendToServer(Object msg) {
        clientChannel.sendToServer(msg);
    }

}
