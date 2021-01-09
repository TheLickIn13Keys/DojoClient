package DojoClient.mods.impl.ModFPS;

import DojoClient.FileManager;
import DojoClient.gui.hud.ScreenPosition;
import DojoClient.mods.ModDraggable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;

import java.io.File;

public class ModFPS extends ModDraggable {



    @Override
    public int getWidth() {
        return 50;
    }

    @Override
    public int getHeight() {
        return font.FONT_HEIGHT;
    }

    @Override
    public void render(ScreenPosition pos) {
        font.drawStringWithShadow("[", pos.getAbsoluteX(), pos.getAbsoluteY(), 0xaaaaaa);
        font.drawStringWithShadow("FPS", pos.getAbsoluteX()+4, pos.getAbsoluteY(), 0xff00ff);
        font.drawStringWithShadow("]", pos.getAbsoluteX()+22, pos.getAbsoluteY(), 0xaaaaaa);
        font.drawStringWithShadow(""+mc.getDebugFPS(), pos.getAbsoluteX()+29, pos.getAbsoluteY(), 0xffffff);

    }

    public FPSOptions getOptions(){
        return FileManager.readFromJson(new File(getFolder(), "config.json"), FPSOptions.class);
    }

    @Override
    public GuiScreen getGui() {
        return new GuiFPSSettingsToggle();
    }

    private File getFolder(){
        File folder = new File(FileManager.getModsDirectory(), this.getClass().getSimpleName());
        folder.mkdirs();
        return folder;
    }

    public void writeOptions(){
        FileManager.writeJsonToFile(new File(getFolder(), "config.json"), getOptions());
    }

}
