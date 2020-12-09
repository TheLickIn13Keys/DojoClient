package DojoClient.packets.client;

import net.minecraft.entity.item.EntityPainting;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.BlockPos;

import java.io.IOException;
import java.util.UUID;

public class CPacketComplexData extends CPacket{

    @Override
    public void writePacketData(PacketBuffer buf) throws IOException {

        buf.writeInt(1337);
        buf.writeDouble(8.23);
        buf.writeFloat(33.3F);
        buf.writeByteArray(new byte[] {1,2,3,4,5});
        buf.writeBoolean(true);
        writeString(buf, "Hii");
        buf.writeUuid(UUID.fromString("cd23f9ab-c9bf-4852-a172-64615253a25d"));
        buf.writeEnumValue(EntityPainting.EnumArt.BURNING_SKULL);
        buf.writeBlockPos(new BlockPos(10, 20, 30));
        buf.writeItemStackToBuffer(new ItemStack(Blocks.wool, 10, 5));

        NBTTagCompound testTag = new NBTTagCompound();
        testTag.setBoolean("testBoolean", true);
        buf.writeNBTTagCompoundToBuffer(testTag);



    }
}
