package DojoClient.gui;

import java.io.IOException;
import java.util.HashMap;

import DojoClient.mods.impl.ModArmorStatus.GuiArmorSettingsIcon;
import DojoClient.mods.impl.ModFPS.GuiFPSSettingsIcon;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class GuiModToggle extends GuiScreen {

    private ScrollListModToggle scrollPanel;


    @Override
    public void initGui() {
        scrollPanel = new ScrollListModToggle(mc, this);
        this.buttonList.clear();

    }

    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        this.scrollPanel.handleMouseInput();
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        this.scrollPanel.mouseClicked(mouseX, mouseY, mouseButton);
        super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    protected void mouseReleased(int mouseX, int mouseY, int state) {
        this.scrollPanel.mouseReleased(mouseX, mouseY, state);
        super.mouseReleased(mouseX, mouseY, state);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        this.scrollPanel.drawScreen(mouseX, mouseY, partialTicks);
        this.drawCenteredString(this.fontRendererObj, "Mod Options", this.width / 2, 8, 16777215);

/*       for(int i = 0; i<this.scrollPanel.getSize(); i++){
            try {
                String modName = this.scrollPanel.getEntries().get(i).getName();
                GUIs.get(modName).drawButton(Minecraft.getMinecraft(), mouseX, mouseY);
            }catch (Exception e){
                e.printStackTrace();
            }

        }*/
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

}