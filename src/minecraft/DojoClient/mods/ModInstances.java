package DojoClient.mods;

import DojoClient.gui.hud.HUDManager;
import DojoClient.mods.impl.*;
import DojoClient.mods.impl.togglesprintsneak.ModToggleSprintSneak;

public class ModInstances {
    //private static ModHelloWorld modHelloWorld;
    private static ModArmorStatus modArmorStatus;
    private static ModFPS modFPS;
    private static ModXYZ modXYZ;
    private static ModKeystrokes modKeystrokes;
    private static ModToggleSprintSneak modToggleSprintSneak;
    private static ModCPS modCPS;
    private static ModPerspective modPerspective;
    private static ModPlayer modPlayer;
    private static ModPotionStatus modPotionStatus;

    public static void register(HUDManager api){
        //modHelloWorld = new ModHelloWorld();
        //api.register(modHelloWorld);

        modArmorStatus = new ModArmorStatus();
        api.register((modArmorStatus));

        modFPS = new ModFPS();
        api.register((modFPS));

        modXYZ = new ModXYZ();
        api.register((modXYZ));

        modKeystrokes = new ModKeystrokes();
        api.register((modKeystrokes));

        modToggleSprintSneak = new ModToggleSprintSneak();
        api.register((modToggleSprintSneak));

        modCPS = new ModCPS();
        api.register((modCPS));

        modPerspective = new ModPerspective();
        api.register((modPerspective));

        modPlayer = new ModPlayer();
        api.register((modPlayer));

        modPotionStatus = new ModPotionStatus();
        api.register((modPotionStatus));
    }

    public static ModToggleSprintSneak getModToggleSprintSneak() {
        return modToggleSprintSneak;
    }

    public static ModPerspective getModPerspective() {
        return modPerspective;
    }
}
