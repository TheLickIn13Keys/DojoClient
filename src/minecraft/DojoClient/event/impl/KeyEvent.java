package DojoClient.event.impl;

import DojoClient.event.EventCancelable;

public class KeyEvent extends EventCancelable {

    private final int key;

    public KeyEvent(int key){
        this.key = key;
    }

    public int getKey() {
        return key;
    }
}
