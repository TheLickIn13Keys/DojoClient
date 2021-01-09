package DojoClient.mods.impl.ModFPS;

import DojoClient.gui.hud.HUDManager;
import DojoClient.gui.hud.IRenderer;
import DojoClient.mods.Mod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiListExtended;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScrollListFPSToggle extends GuiListExtended {

    private final List<ModFPSEntry> entrys = new ArrayList<ModFPSEntry>();

    public ScrollListFPSToggle(Minecraft mcIn, GuiFPSSettingsToggle inGui) {
        super(mcIn, inGui.width, inGui.height, 63, inGui.height - 32, 20);
        ModFPSEntry FPSTextColor = new ModFPSEntry(inGui,"'FPS' Text Color");
        ModFPSEntry bracketsColor = new ModFPSEntry(inGui,"Bracket Text Color");

        entrys.add(FPSTextColor);
        entrys.add(bracketsColor);


        Collections.sort(this.entrys);
    }

    @Override
    public IGuiListEntry getListEntry(int index) {
        return entrys.get(index);
    }

    @Override
    protected int getSize() {
        return entrys.size();
    }

}

