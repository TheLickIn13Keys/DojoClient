package DojoClient.mods.impl.ModArmorStatus;


import java.awt.*;

public class ArmorStatusOptions {

    private Color ArmorTextColor = new Color(0xFFFFFF);


    public ArmorStatusOptions(Color ArmorTextColor){
        this.ArmorTextColor = ArmorTextColor;

    }

    public Color getArmorTextColor() {
        return ArmorTextColor;
    }
}
