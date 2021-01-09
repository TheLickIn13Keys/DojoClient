package DojoClient.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;

public class GuiButtonAnimated extends GuiButton {


    public GuiButtonAnimated(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText) {
        super(buttonId, x, y, widthIn, heightIn, buttonText);
    }

    public GuiButtonAnimated(int buttonId, int x, int y, String buttonText) {
        super(buttonId, x, y, buttonText);
    }


    int animatedHeight = 0;

    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY)
    {
        if (this.visible)
        {
            FontRenderer fontrenderer = mc.fontRendererObj;
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;


            if(this.hovered) {
                animatedHeight++;
                if(animatedHeight > this.height) {
                    animatedHeight = height;
                }
            }
            else {
                animatedHeight--;
                if(animatedHeight < 0) {
                    animatedHeight = 0;
                }
            }

            this.drawRect(this.xPosition, this.yPosition, this.xPosition + this.width, this.yPosition + this.height, 0xFFFF00FF);

            this.drawRect(this.xPosition, this.yPosition, this.xPosition + this.width, this.yPosition + this.animatedHeight, 0xFFFF00B7);

            this.mouseDragged(mc, mouseX, mouseY);
            int j = 14737632;

            if (!this.enabled)
            {
                j = 10526880;
            }
            else if (this.hovered)
            {
                j = 16777120;
            }
            this.drawCenteredString(fontrenderer, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, j);
        }
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY) {
        Minecraft.getMinecraft().displayGuiScreen(new GuiModToggle());
    }
}
