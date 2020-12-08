package DojoClient.mods.impl;

import DojoClient.gui.hud.ScreenPosition;
import DojoClient.mods.ModDraggable;
import org.lwjgl.input.Mouse;

import java.util.ArrayList;
import java.util.List;

public class ModCPS extends ModDraggable {

    private List<Long> clicks = new ArrayList<>();
    private boolean wasPressed;
    private long lastPressed;

    @Override
    public int getWidth() {
        return font.getStringWidth("[CPS] 000");
    }

    @Override
    public int getHeight() {
        return font.FONT_HEIGHT;
    }

    @Override
    public void render(ScreenPosition pos) {

        final boolean pressed = Mouse.isButtonDown(0);

        if(pressed != this.wasPressed){
            this.lastPressed = System.currentTimeMillis();
            this.wasPressed = pressed;
            if(pressed){
                this.clicks.add(this.lastPressed);
            }
        }

        font.drawStringWithShadow("[", pos.getAbsoluteX(), pos.getAbsoluteY(), 0xaaaaaa);
        font.drawStringWithShadow("CPS", pos.getAbsoluteX()+4, pos.getAbsoluteY(), 0xffaa00);
        font.drawStringWithShadow("]", pos.getAbsoluteX()+22, pos.getAbsoluteY(), 0xaaaaaa);
        font.drawStringWithShadow(""+getCPS(), pos.getAbsoluteX()+29, pos.getAbsoluteY(), 0xffffff);


    }

    private int getCPS(){

        final long time = System.currentTimeMillis();
        this.clicks.removeIf(aLong -> aLong + 1000 < time);
        return this.clicks.size();

    }
}
