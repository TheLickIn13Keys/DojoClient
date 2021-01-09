package DojoClient.gui;

import DojoClient.gui.hud.HUDManager;
import DojoClient.gui.hud.IRenderer;
import DojoClient.mods.Mod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiListExtended;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScrollListModToggle extends GuiListExtended {

    private final List<ModEntry> entries = new ArrayList<ModEntry>();

    public ScrollListModToggle(Minecraft mcIn, GuiModToggle inGui) {
        super(mcIn, inGui.width, inGui.height, 63, inGui.height - 32, 20);
        for(IRenderer r : HUDManager.getInstance().getRegisteredRenderers()) {
            if(r instanceof Mod) {
                Mod m = (Mod)r;
                entries.add(new ModEntry(inGui, m));
            }
        }
        Collections.sort(this.entries);
    }

    @Override
    public IGuiListEntry getListEntry(int index) {
        return entries.get(index);
    }

    public List<ModEntry> getEntries() {
        return entries;
    }

    @Override
    protected int getSize() {
        return entries.size();
    }


}

