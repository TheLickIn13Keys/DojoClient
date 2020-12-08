package DojoClient.http;

import DojoClient.http.gsonobjs.ObjGlobalSettings;
import DojoClient.http.gsonobjs.ObjIsBanned;
import DojoClient.http.gsonobjs.ObjIsWhitelisted;
import DojoClient.http.gsonobjs.ObjUserCosmetics;
import com.google.gson.Gson;
import net.minecraft.client.Minecraft;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class HTTPFunctions {

    private static final Gson gson = new Gson();

    public static void sendHWIDMap(){
        Minecraft mc = Minecraft.getMinecraft();
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("uuid", mc.getSession().getProfile().getId().toString()));
        params.add(new BasicNameValuePair("username", mc.getSession().getProfile().getName()));
        params.add(new BasicNameValuePair("hwid", HWID.get()));
        HTTPUtils.sendPostAsync(HTTPEndpoints.MAP_UUID, params);
    }

    public static boolean isAPIUp(){
        HTTPReply reply = HTTPUtils.sendGet(HTTPEndpoints.BASE);
        return reply.getStatusCode() == 200;
    }

    public static boolean isBanned(){

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("hwid", HWID.get()));
        HTTPReply reply = HTTPUtils.sendGet(HTTPEndpoints.IS_BANNED, params);
        if(reply.getStatusCode() == 200){
            ObjIsBanned objIsBanned = gson.fromJson(reply.getBody(), ObjIsBanned.class);
            return objIsBanned.isBanned();
        }
        return false;
    }

    public static boolean isWhitelisted(){

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("hwid", HWID.get()));
        HTTPReply reply = HTTPUtils.sendGet(HTTPEndpoints.IS_WHITELISTED, params);
        if(reply.getStatusCode() == 200){
            ObjIsWhitelisted objIsWhitelisted = gson.fromJson(reply.getBody(), ObjIsWhitelisted.class);
            return objIsWhitelisted.isWhitelisted();
        }
        return false;
    }

    public static ObjUserCosmetics[] downloadUserCosmetics(){
        return gson.fromJson(HTTPUtils.sendGet(HTTPEndpoints.COSMETICS).getBody(), ObjUserCosmetics[].class);
    }

    public static ObjGlobalSettings downloadObjectGlobalSettings(){
        return gson.fromJson(HTTPUtils.sendGet(HTTPEndpoints.GLOBAL_SETTINGS).getBody(), ObjGlobalSettings.class);
    }

}
