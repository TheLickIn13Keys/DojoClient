package DojoClient.packets.server;

import DojoClient.packets.client.CPacketComplexData;
import net.minecraft.client.Minecraft;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;

import java.io.IOException;

public class SPacketTest extends SPacket{
    @Override
    public void readPacketData(PacketBuffer buf) throws IOException {
        //N/A
    }

    @Override
    public void processPacket(INetHandlerPlayClient handler) {
        System.err.println("Server go brrrrr");
        Minecraft.getMinecraft().getNetHandler().addToSendQueue(new CPacketComplexData());
    }
}
