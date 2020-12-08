package DojoClient.mods.impl;

import DojoClient.gui.hud.ScreenPosition;
import DojoClient.mods.ModDraggable;

public class ModFPS extends ModDraggable {


    @Override
    public int getWidth() {
        return 50;
    }

    @Override
    public int getHeight() {
        return font.FONT_HEIGHT;
    }

    @Override
    public void render(ScreenPosition pos) {
        font.drawStringWithShadow("[", pos.getAbsoluteX(), pos.getAbsoluteY(), 0xaaaaaa);
        font.drawStringWithShadow("FPS", pos.getAbsoluteX()+4, pos.getAbsoluteY(), 0xffaa00);
        font.drawStringWithShadow("]", pos.getAbsoluteX()+22, pos.getAbsoluteY(), 0xaaaaaa);
        font.drawStringWithShadow(""+mc.getDebugFPS(), pos.getAbsoluteX()+29, pos.getAbsoluteY(), 0xffffff);

    }

}
