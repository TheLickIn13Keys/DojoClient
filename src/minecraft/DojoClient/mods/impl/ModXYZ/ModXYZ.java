package DojoClient.mods.impl.ModXYZ;

import DojoClient.gui.hud.ScreenPosition;
import DojoClient.mods.ModDraggable;

public class ModXYZ extends ModDraggable {



    @Override
    public int getWidth() {/*

        if(font.getStringWidth(getXString()) > font.getStringWidth(getYString()) && font.getStringWidth(getXString()) > font.getStringWidth(getZString()))
        {
           return font.getStringWidth(getXString()+17);
        }
        else if(font.getStringWidth(getYString()) > font.getStringWidth(getZString()))
        {
            return font.getStringWidth(getYString()+17);
        }
        else
        {
            return font.getStringWidth(getZString()+17);
        }
        */
        return 50;

    }

    @Override
    public int getHeight() {
        return font.FONT_HEIGHT*3;
    }

    @Override
    public void render(ScreenPosition pos) {
        //X
        font.drawStringWithShadow("[", pos.getAbsoluteX(), pos.getAbsoluteY(), 0xaaaaaa);
        font.drawStringWithShadow("X", pos.getAbsoluteX()+4, pos.getAbsoluteY(), 0xff00ff);
        font.drawStringWithShadow("]", pos.getAbsoluteX()+10, pos.getAbsoluteY(), 0xaaaaaa);
        font.drawStringWithShadow(getXString(), pos.getAbsoluteX()+17, pos.getAbsoluteY(), -1);
        //Y
        font.drawStringWithShadow("[", pos.getAbsoluteX(), pos.getAbsoluteY()+9, 0xaaaaaa);
        font.drawStringWithShadow("Y", pos.getAbsoluteX()+4, pos.getAbsoluteY()+9, 0xff00ff);
        font.drawStringWithShadow("]", pos.getAbsoluteX()+10, pos.getAbsoluteY()+9, 0xaaaaaa);
        font.drawStringWithShadow(getYString(), pos.getAbsoluteX()+17, pos.getAbsoluteY()+9, -1);
        //Z
        font.drawStringWithShadow("[", pos.getAbsoluteX(), pos.getAbsoluteY()+18, 0xaaaaaa);
        font.drawStringWithShadow("Z", pos.getAbsoluteX()+4, pos.getAbsoluteY()+18, 0xff00ff);
        font.drawStringWithShadow("]", pos.getAbsoluteX()+10, pos.getAbsoluteY()+18, 0xaaaaaa);
        font.drawStringWithShadow(getZString(), pos.getAbsoluteX()+17, pos.getAbsoluteY()+18, -1);

    }

    private String getXString() {

        return String.format("%.0f", mc.getRenderViewEntity().posX);

    }
    private String getYString() {

        return String.format("%.0f", mc.getRenderViewEntity().getEntityBoundingBox().minY);

    }
    private String getZString() {

        return String.format("%.0f", mc.getRenderViewEntity().posZ);

    }
}
