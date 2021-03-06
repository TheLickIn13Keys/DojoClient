package DojoClient.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;

import java.awt.*;

public class GuiBackIcon extends GuiButton {

    public boolean checked;
    private static final String X = "✗";
    private static final String CHECK = "✔";
    private static final Color X_COLOR = Color.GRAY;
    private static final Color CHECK_COLOR = Color.GREEN;

    public GuiBackIcon(int buttonId, int x, int y) {
        this(buttonId, x, y, false);
    }

    public GuiBackIcon(int buttonId, int x, int y, boolean checked) {
        this(buttonId, x, y, 20, 20, checked);
    }

    public GuiBackIcon(int buttonId, int x, int y, int width, int height) {
        this(buttonId, x, y, width, height, false);
    }

    public GuiBackIcon(int buttonId, int x, int y, int width, int height, boolean checked) {
        super(buttonId, x, y, width, height, "");
        this.checked = checked;
    }

    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY) {
        if (this.visible) {
            FontRenderer fontrenderer = mc.fontRendererObj;
            mc.getTextureManager().bindTexture(buttonTextures);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
            int i = this.getHoverState(this.hovered);
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            GlStateManager.blendFunc(770, 771);
            this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 46 + i * 20, this.width / 2, this.height);
            this.drawTexturedModalRect(this.xPosition + this.width / 2, this.yPosition, 200 - this.width / 2, 46 + i * 20, this.width / 2, this.height);
            this.mouseDragged(mc, mouseX, mouseY);

            this.displayString = "⚙";
            int color = X_COLOR.getRGB();


            this.drawCenteredString(fontrenderer, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, color);

        }
    }


    public void mouseReleased(int mouseX, int mouseY, GuiScreen gui) {
        Minecraft.getMinecraft().displayGuiScreen(gui);
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

}
