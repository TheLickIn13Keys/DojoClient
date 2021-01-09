package DojoClient.mods.impl.ModGuiBlur;

import DojoClient.gui.hud.ScreenPosition;
import DojoClient.mods.Mod;
import DojoClient.mods.ModDraggable;

public class ModGuiBlur extends ModDraggable {
    @Override
    public int getWidth() {
        return 1;
    }

    @Override
    public int getHeight() {
        return 1;
    }

    @Override
    public void render(ScreenPosition pos) {
        font.drawString("", 0, 0, -1);
    }
}
