package DojoClient.mods.impl.ModHelloWorld;

import DojoClient.gui.hud.ScreenPosition;
import DojoClient.mods.ModDraggable;

public class ModHelloWorld extends ModDraggable {


    @Override
    public int getWidth() {
        return font.getStringWidth("Hello World (Dummy)");
    }

    @Override
    public int getHeight() {
        return font.FONT_HEIGHT;
    }

    @Override
    public void render(ScreenPosition pos) {
        font.drawString("Hello World", pos.getAbsoluteX() +1, pos.getAbsoluteY() + 1, -1);
    }

    @Override
    public void renderDummy(ScreenPosition pos) {
        font.drawString("Hello World (Dummy)", pos.getAbsoluteX() +1, pos.getAbsoluteY() + 1, 0xFF00FF00);
    }

}
