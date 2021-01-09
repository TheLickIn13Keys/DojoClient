package DojoClient.mods;

import DojoClient.Client;
import DojoClient.FileManager;
import DojoClient.event.EventManager;
import DojoClient.mods.impl.ModFPS.GuiFPSSettingsToggle;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;

import java.io.File;

public class Mod {

    private boolean isEnabled = true;

    protected final Minecraft mc;
    protected final FontRenderer font;
    protected final Client client;

    public Mod(){
        this.mc = Minecraft.getMinecraft();
        this.font = this.mc.fontRendererObj;
        this.client = Client.getInstance();

        //setEnabled(isEnabled);
    }

    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;

        if(isEnabled){
            EventManager.register(this);
            FileManager.writeJsonToFile(new File(getFolder(), "enabled.json"), true);
        }
        else{
            EventManager.unregister(this);
            FileManager.writeJsonToFile(new File(getFolder(), "enabled.json"), false);
        }
    }

    public GuiScreen getGui(){
        return  null;
    }

    private File getFolder(){
        File folder = new File(FileManager.getModsDirectory(), this.getClass().getSimpleName());
        folder.mkdirs();
        return folder;
    }

    public boolean isEnabled() {
        try {
            Boolean loaded = FileManager.readFromJson(new File(getFolder(), "enabled.json"), Boolean.class);
            return loaded.booleanValue();
        }catch (Exception e){
            e.printStackTrace();
            return isEnabled;
        }

    }
}
