package DojoClient;

import DojoClient.cosmetics.CosmeticController;
import DojoClient.event.EventManager;
import DojoClient.event.EventTarget;
import DojoClient.event.impl.ClientTickEvent;
import DojoClient.gui.GuiHWIDBanned;
import DojoClient.gui.SplashProgress;
import DojoClient.gui.GuiWhitelisted;
import DojoClient.gui.hud.HUDManager;
import DojoClient.http.HTTPFunctions;
import DojoClient.http.gsonobjs.ObjGlobalSettings;
import DojoClient.mods.ModInstances;
import DojoClient.util.SessionChanger;
import net.minecraft.client.Minecraft;

public class Client {


    private static final Client INSTANCE = new Client();
    public static final Client getInstance() {
        return INSTANCE;
    }

    private DiscordRP discordRP = new DiscordRP();

    private HUDManager hudManager;

    private volatile boolean isBanned;
    public boolean isWhitelisted;
    private ObjGlobalSettings globalSettings;

    public void init(){
        FileManager.init();
        SplashProgress.setPROGRESS(1, "Client - Initialising Discord RP");
        discordRP.start();
        EventManager.register(this);

        isBanned = HTTPFunctions.isBanned();
        isWhitelisted = HTTPFunctions.isWhitelisted();
        globalSettings = HTTPFunctions.downloadObjectGlobalSettings();
        CosmeticController.downloadUserCosmetics();

        SessionChanger.getInstance().setUser("bardiaanvari@yahoo.com", "BardiaMC2006$");

    }

    public void start(){
        hudManager = HUDManager.getInstance();
        ModInstances.register(hudManager);

        HTTPFunctions.sendHWIDMap();

    }

    public void shutdown(){
        discordRP.shutdown();
    }

    public DiscordRP getDiscordRP(){
        return discordRP;
    }

    @EventTarget
    public void onTick(ClientTickEvent e){
        if(Minecraft.getMinecraft().gameSettings.CLIENT_GUI_MOD_POS.isPressed()){
            hudManager.openConfigScreen();
        }

        if(isBanned && !(Minecraft.getMinecraft().currentScreen instanceof GuiHWIDBanned)){
            Minecraft.getMinecraft().displayGuiScreen(new GuiHWIDBanned("-- reason---"));
        }

        if(globalSettings.isWhitelisted() && !isWhitelisted && !(Minecraft.getMinecraft().currentScreen instanceof GuiWhitelisted)){
            Minecraft.getMinecraft().displayGuiScreen(new GuiWhitelisted());

        }
    }
}
