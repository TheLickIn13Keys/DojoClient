package DojoClient.packets.client;

import DojoClient.packets.DojoPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;

import java.io.IOException;

public abstract class CPacket extends DojoPacket {

    @Override
    public void readPacketData(PacketBuffer buf) throws IOException {

    }

    @Override
    public void processPacket(INetHandlerPlayClient handler) {

    }

    public void writeString(PacketBuffer buf, String toWrite){
        buf.writeInt(toWrite.length());
        buf.writeString(toWrite);
    }
}
