package DojoClient.mods.impl;

import DojoClient.gui.hud.ScreenPosition;
import DojoClient.mods.ModDraggable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiInventory;

public class ModPlayer extends ModDraggable {

    /*
     *█▀▄▀█ █▀▀█ █▀▀▄ █▀▀   █▀▀▄ █░░█   █░░░█ █▀▀█ █▀▀ █▀▀ █░░ █▀▀ █
     *█░▀░█ █▄▄█ █░░█ █▀▀   █▀▀▄ █▄▄█   █▄█▄█ █▄▄█ █▀▀ █▀▀ █░░ █▀▀ ▀
     *▀░░░▀ ▀░░▀ ▀▀▀░ ▀▀▀   ▀▀▀░ ▄▄▄█   ░▀░▀░ ▀░░▀ ▀░░ ▀░░ ▀▀▀ ▀▀▀ ▄
     *
     *                    Make sure to credit.
     *
     *
     *
     *            		 Leave this in the code.
     *           And add my Github user to the credits!
     *           (the-garbage-which-belongs-to-waffle)
     *
     *            It might error if you try save with this.
     *                 Simply press 'Save As UTF-8!'
     *
     *         Please note; the save and load methods are missing.
     * I have commented them out so it works with the .json saving tutorial.
     *
     *           Feel free to add them back! They're at the bottom.
     */

    public String modeCrouch = "up";
    /*
     * Modes are 'down', 'up' and none.
     *If down, you will go a few pixels down when crouching (and back when you stop) to keep your Y position.
     *If up, same as down but you go up.
     *If none, you stay the same.
     */

    public String modeAppear = "always";
    /*Modes are 'always', 'crouch', 'sprint' and 'crouchSprint'.
     *These are when it appears, simple enough.
     */
    public int stabilisation;
    public String visible;

    @Override
    public int getWidth() {
        return 9;
    }

    @Override
    public int getHeight() {
        return 20;
    }

    @Override
    public void render(ScreenPosition pos) {

        if (modeCrouch == "none") {
            stabilisation = 0;
        }

        if (modeCrouch == "down") {
            stabilisation = 0;
        }

        if (modeCrouch == "up") {
            stabilisation = -2;
        }

        if (modeAppear == "always") {
            visible = "true";
        }

        if (modeAppear == "crouch") {
            if (mc.thePlayer.isSneaking()) {
                visible = "true";
            } else {
                visible = "false";
            }
        }

        if (modeAppear == "sprint") {
            if (mc.thePlayer.isSprinting()) {
                visible = "true";
            } else {
                visible = "false";
            }
        }

        if (modeAppear == "crouchSprint") {
            if (mc.thePlayer.isSprinting() || mc.thePlayer.isSneaking()) {
                visible = "true";
            } else {
                visible = "false";
            }
        }

        if(visible == "true") {
            if (!mc.thePlayer.isSneaking()) {
                GuiInventory.drawEntityOnScreen(pos.getAbsoluteX() + 5, (pos.getAbsoluteY() + 20), 10, 2f, 1.8f, Minecraft.getMinecraft().thePlayer);
            } else {
                GuiInventory.drawEntityOnScreen(pos.getAbsoluteX() + 5, (pos.getAbsoluteY() + 20) + stabilisation, 10, 2f, 1.8f, Minecraft.getMinecraft().thePlayer);
            }
        }

        //@Override
        //public void save(ScreenPosition pos) {
        //	this.pos = pos;
        //}

        //@Override
        //public ScreenPosition load() {
        //	return pos;
        //}

    }


}
