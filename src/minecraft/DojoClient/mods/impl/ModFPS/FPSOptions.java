package DojoClient.mods.impl.ModFPS;


import DojoClient.FileManager;

import java.awt.*;
import java.io.File;

public class FPSOptions {

    private Color FPSTextColor = new Color(0xFF00FF);
    private Color bracketsColor = new Color(0xAAAAAA);

    public FPSOptions(Color FPSTextColor, Color bracketsColor){
        this.FPSTextColor = FPSTextColor;
        this.bracketsColor = bracketsColor;
    }


    public Color getBracketsColor() {
        return bracketsColor;
    }

    public Color getFPSTextColor() {
        return FPSTextColor;
    }
}
