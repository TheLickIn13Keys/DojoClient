package DojoClient.packets.server;

import DojoClient.packets.DojoPacket;
import net.minecraft.network.PacketBuffer;

import java.io.IOException;

public abstract class SPacket extends DojoPacket {

    @Override
    public void writePacketData(PacketBuffer buf) throws IOException {
        //NOTE: READ ONLY
    }

    public String readString(PacketBuffer buf){
        int length = buf.readInt();
        return buf.readStringFromBuffer(length);
    }
}
