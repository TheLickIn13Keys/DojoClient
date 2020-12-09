package DojoClient;

import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.util.ResourceLocation;

public class ServerDataFeatured extends ServerData{

    public static final ResourceLocation STAR_ICON = new ResourceLocation("DojoClient/star.png");
    public static final ResourceLocation CHECK = new ResourceLocation("DojoClient/check.png");

    public ServerDataFeatured(String serverName, String serverIp) {
        super(serverName, serverIp, false);
    }
}
