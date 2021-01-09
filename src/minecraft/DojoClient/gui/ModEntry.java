package DojoClient.gui;

import DojoClient.mods.Mod;
import DojoClient.mods.impl.ModArmorStatus.GuiArmorSettingsIcon;
import DojoClient.mods.impl.ModArmorStatus.GuiArmorStatusSettingsToggle;
import DojoClient.mods.impl.ModFPS.GuiFPSSettingsIcon;
import DojoClient.mods.impl.ModFPS.GuiFPSSettingsToggle;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiListExtended;
import net.minecraft.client.gui.GuiScreen;
import org.apache.commons.lang3.StringUtils;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class ModEntry implements GuiListExtended.IGuiListEntry, Comparable<ModEntry> {

    private final GuiCheckBox checkbox;
    private final GuiSettingsIcon settingsIcon;
    private String name;
    private final Mod mod;
    private final GuiModToggle gui;
    private GuiButton setIcon;
    HashMap<String, GuiButton> GUIs = new HashMap<String, GuiButton>();


    public ModEntry(GuiModToggle inGui, Mod mod) {
        this.mod = mod;
        name = StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(mod.getClass().getSimpleName().replace("Mod", "").replaceAll("\\d+", "")), " ");
        checkbox = new GuiCheckBox(0, 0, 0, mod.isEnabled());
        settingsIcon = new GuiSettingsIcon(1, 0, 0);

        GUIs.put("Armor Status", new GuiArmorSettingsIcon(4, 0, 0));
        GUIs.put("FPS", new GuiFPSSettingsIcon(4, 0, 0));

        this.gui = inGui;
    }

    @Override
    public void drawEntry(int slotIndex, int x, int y, int listWidth, int slotHeight, int mouseX, int mouseY, boolean isSelected) {
        this.checkbox.xPosition = x + 200;
        this.checkbox.yPosition = y;
        this.checkbox.drawButton(Minecraft.getMinecraft(), mouseX, mouseY);
        this.mod.setEnabled(this.checkbox.isChecked());

        try {
            this.setIcon = GUIs.get(name);
            this.setIcon.xPosition = x + 170;
            this.setIcon.yPosition = y;
            this.setIcon.drawButton(Minecraft.getMinecraft(), mouseX, mouseY);
            gui.drawCenteredString(Minecraft.getMinecraft().fontRendererObj, name, x, y + 4, -1);
            //System.out.println(name);
        }
        catch (Exception e){
            //e.printStackTrace();
            gui.drawCenteredString(Minecraft.getMinecraft().fontRendererObj, name, x, y + 4, -1);
        }

        //gui.drawCenteredString(Minecraft.getMinecraft().fontRendererObj, name, x, y + 4, -1);
    }

    @Override
    public boolean mousePressed(int slotIndex, int x, int y, int p_148278_4_, int p_148278_5_, int p_148278_6_) {
        return this.checkbox.mousePressed(Minecraft.getMinecraft(), x, y);
    }

    @Override
    public void mouseReleased(int slotIndex, int x, int y, int mouseEvent, int relativeX, int relativeY) {

            try {
                System.out.println(name);
                GUIs.get(name).mouseReleased(x, y);
                if(this.setIcon.xPosition == x && this.setIcon.yPosition == y){
                    this.setIcon.mouseReleased(x, y);
                }
                if(this.checkbox.xPosition == x && this.checkbox.yPosition == y){
                    this.checkbox.mouseReleased(x, y);
                }
            }
            catch (Exception e){
                //e.printStackTrace();
                this.checkbox.mouseReleased(x, y);
            }


    }

    @Override
    public void setSelected(int p_178011_1_, int p_178011_2_, int p_178011_3_) {

    }

    @Override
    public int compareTo(ModEntry o) {
        return this.name.compareTo(o.name);
    }

    public String getName() {
        return name;
    }
}
