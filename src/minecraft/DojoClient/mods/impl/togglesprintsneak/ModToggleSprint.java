package DojoClient.mods.impl.togglesprintsneak;

import DojoClient.gui.hud.ScreenPosition;
import DojoClient.mods.ModDraggable;

public class ModToggleSprint extends ModDraggable {


    //Settings
    public boolean flyBoost = true;
    public float flyBoostFactor = 4;
    public int keyHoldTicks = 7;

    private String textToRender = "";

    @Override
    public int getWidth() {
        return font.getStringWidth(textToRender);
    }

    @Override
    public int getHeight() {
        return font.FONT_HEIGHT;
    }

    @Override
    public void render(ScreenPosition pos) {
        textToRender = mc.thePlayer.movementInput.getDisplayText();
        font.drawStringWithShadow(textToRender, pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
    }

    @Override
    public void renderDummy(ScreenPosition pos) {
        textToRender = "[Sprint Toggle]";
        font.drawStringWithShadow(textToRender, pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
    }

}
