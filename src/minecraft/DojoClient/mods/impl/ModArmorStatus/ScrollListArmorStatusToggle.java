package DojoClient.mods.impl.ModArmorStatus;

import DojoClient.mods.impl.ModFPS.GuiFPSSettingsToggle;
import DojoClient.mods.impl.ModFPS.ModFPSEntry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiListExtended;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScrollListArmorStatusToggle extends GuiListExtended {

    private final List<ModArmorStatusEntry> entrys = new ArrayList<ModArmorStatusEntry>();

    public ScrollListArmorStatusToggle(Minecraft mcIn, GuiArmorStatusSettingsToggle inGui) {
        super(mcIn, inGui.width, inGui.height, 63, inGui.height - 32, 20);
        ModArmorStatusEntry ArmorTextColor = new ModArmorStatusEntry(inGui,"Armor Text Color");

        entrys.add(ArmorTextColor);



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

