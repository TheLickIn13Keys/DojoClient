package DojoClient.http.gsonobjs;

public class ObjIsBanned {

    private String hwid;
    private int isBanned;

    public String getHwid() {
        return hwid;
    }

    public boolean isBanned() {
        return isBanned == 1;
    }
}
