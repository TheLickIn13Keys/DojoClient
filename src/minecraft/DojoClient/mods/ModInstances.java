package DojoClient.mods;

import DojoClient.gui.hud.HUDManager;
import DojoClient.mods.impl.ModArmorStatus.ModArmorStatus;
import DojoClient.mods.impl.ModCPS.ModCPS;
import DojoClient.mods.impl.ModFPS.ModFPS;
import DojoClient.mods.impl.ModGuiBlur.ModGuiBlur;
import DojoClient.mods.impl.ModKeystrokes.ModKeystrokes;
import DojoClient.mods.impl.ModPerspective.ModPerspective;
import DojoClient.mods.impl.ModPlayer.ModPlayer;
import DojoClient.mods.impl.ModPotionStatus.ModPotionStatus;
import DojoClient.mods.impl.ModXYZ.ModXYZ;
import DojoClient.mods.impl.togglesprintsneak.ModToggleSprint;

public class ModInstances {
    //private static ModHelloWorld modHelloWorld;
    private static ModArmorStatus modArmorStatus;
    private static ModFPS modFPS;
    private static ModXYZ modXYZ;
    private static ModKeystrokes modKeystrokes;
    private static ModToggleSprint modToggleSprintSneak;
    private static ModCPS modCPS;
    private static ModPerspective modPerspective;
    private static ModPlayer modPlayer;
    private static ModPotionStatus modPotionStatus;
    private static ModGuiBlur modGuiBlur;

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

        modToggleSprintSneak = new ModToggleSprint();
        api.register((modToggleSprintSneak));

        modCPS = new ModCPS();
        api.register((modCPS));

        modPerspective = new ModPerspective();
        api.register((modPerspective));

        modPlayer = new ModPlayer();
        api.register((modPlayer));

        modPotionStatus = new ModPotionStatus();
        api.register((modPotionStatus));

        modGuiBlur = new ModGuiBlur();
        api.register((modGuiBlur));
    }

    public static ModToggleSprint getModToggleSprintSneak() {
        return modToggleSprintSneak;
    }

    public static ModPerspective getModPerspective() {
        return modPerspective;
    }

    public static ModGuiBlur getModGuiBlur() {
        return modGuiBlur;
    }
}
