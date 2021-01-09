package DojoClient.mods.impl.ModFPS;

import DojoClient.mods.Mod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;

import java.awt.*;

public class GuiFPSSettingsIcon extends GuiButton {


    private static final String X = "✗";
    private static final String CHECK = "✔";
    private static final Color X_COLOR = Color.GRAY;
    private static final Color CHECK_COLOR = Color.GREEN;


    public GuiFPSSettingsIcon(int buttonId, int x, int y) {
        this(buttonId, x, y, 20, 20);
    }

    public GuiFPSSettingsIcon(int buttonId, int x, int y, int width, int height) {
        super(buttonId, x, y, width, height, "");
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
            System.out.println("Drew FPS Settings Icon");
        }
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY) {
            Minecraft.getMinecraft().displayGuiScreen(new GuiFPSSettingsToggle());
            System.out.println("Clicked FPS Settings Icon");

    }
}
