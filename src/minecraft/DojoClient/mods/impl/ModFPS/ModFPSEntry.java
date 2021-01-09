package DojoClient.mods.impl.ModFPS;

import DojoClient.gui.GuiCheckBox;
import DojoClient.gui.GuiSettingsIcon;
import DojoClient.gui.UnicodeFontRenderer;
import DojoClient.mods.Mod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiListExtended;
import net.minecraft.client.gui.GuiTextField;
import org.apache.commons.lang3.StringUtils;

import java.awt.*;

public class ModFPSEntry implements GuiListExtended.IGuiListEntry, Comparable<ModFPSEntry> {

    private final GuiTextField textField;

    private final String name;
    private final GuiFPSSettingsToggle gui;

    public ModFPSEntry(GuiFPSSettingsToggle inGui, String name) {
        this.name = name;
        this.gui = inGui;
        textField = new GuiTextField(69, Minecraft.getMinecraft().fontRendererObj, 10, 10, 10, 10);
    }


    @Override
    public void drawEntry(int slotIndex, int x, int y, int listWidth, int slotHeight, int mouseX, int mouseY, boolean isSelected) {
        this.textField.xPosition = x + 200;
        this.textField.yPosition = y;
        this.textField.drawTextBox();
        gui.drawCenteredString(Minecraft.getMinecraft().fontRendererObj, name, x, y + 4, -1);
    }

    public Color getColor() {
        return Color.getColor(textField.getText());
    }

    @Override
    public boolean mousePressed(int slotIndex, int p_148278_2_, int p_148278_3_, int p_148278_4_, int p_148278_5_, int p_148278_6_) {
        return false;
    }


    @Override
    public void mouseReleased(int slotIndex, int x, int y, int mouseEvent, int relativeX, int relativeY) {
        //this.settingsIcon.mouseReleased(x, y, new GuiS);
        //this.checkbox.mouseReleased(x, y);
    }

    @Override
    public void setSelected(int p_178011_1_, int p_178011_2_, int p_178011_3_) {

    }

    @Override
    public int compareTo(ModFPSEntry o) {
        return this.name.compareTo(o.name);
    }

}
