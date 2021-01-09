package DojoClient.mods;

import DojoClient.FileManager;
import DojoClient.gui.hud.IRenderer;
import DojoClient.gui.hud.ScreenPosition;

import java.io.File;

public abstract class ModDraggable extends Mod implements IRenderer {

    protected ScreenPosition pos;

    public ModDraggable(){
        pos = loadPositionFromFile();
    }

    @Override
    public ScreenPosition load() {
        return pos;
    }

    @Override
    public void save(ScreenPosition pos) {
        this.pos = pos;
        savePositionToFile();
    }


    private File getFolder(){
        File folder = new File(FileManager.getModsDirectory(), this.getClass().getSimpleName());
        folder.mkdirs();
        return folder;
    }

    private void savePositionToFile() {

        FileManager.writeJsonToFile(new File(getFolder(), "pos.json"), pos);

    }

    private ScreenPosition loadPositionFromFile() {

        ScreenPosition loaded = FileManager.readFromJson(new File(getFolder(), "pos.json"), ScreenPosition.class);

        if(loaded == null){
            loaded = ScreenPosition.fromRelativePosition(10.5, 10.5);
            this.pos = loaded;
            savePositionToFile();
        }

        return loaded;

    }


    public final int getLineOffset(ScreenPosition pos, int lineNum){

            return pos.getAbsoluteY() + getLineOffset(lineNum);

    }

    private int getLineOffset(int lineNum) {

            return (font.FONT_HEIGHT + 3 ) * lineNum;

    }
}
