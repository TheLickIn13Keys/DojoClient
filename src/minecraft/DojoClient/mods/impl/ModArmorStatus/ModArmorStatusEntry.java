package DojoClient.mods.impl.ModArmorStatus;

import DojoClient.mods.impl.ModFPS.GuiFPSSettingsToggle;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiListExtended;
import net.minecraft.client.gui.GuiTextField;

import java.awt.*;

public class ModArmorStatusEntry implements GuiListExtended.IGuiListEntry, Comparable<ModArmorStatusEntry> {

    private final GuiTextField textField;

    private final String name;
    private final GuiArmorStatusSettingsToggle gui;

    public ModArmorStatusEntry(GuiArmorStatusSettingsToggle inGui, String name) {
        this.name = name;
        this.gui = inGui;
        textField = new GuiTextField(71, Minecraft.getMinecraft().fontRendererObj, 10, 10, 10, 10);
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
    public int compareTo(ModArmorStatusEntry o) {
        return this.name.compareTo(o.name);
    }

}
