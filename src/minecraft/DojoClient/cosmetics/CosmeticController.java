package DojoClient.cosmetics;

import DojoClient.http.HTTPFunctions;
import DojoClient.http.gsonobjs.ObjUserCosmetics;
import net.minecraft.client.entity.AbstractClientPlayer;

public class CosmeticController {

    private static ObjUserCosmetics[] userCosmetics;

    public static boolean shouldRenderTopHat(AbstractClientPlayer player){
        ObjUserCosmetics uc = getCosmetics(player);
        if(uc == null){
            return false;
        }
        return uc.getHat().isEnabled();
    }

    public static float[] getTopHatColor(AbstractClientPlayer player){
        ObjUserCosmetics uc = getCosmetics(player);
        if(uc == null){
            return  new float[] {0,0,0};
        }
        return uc.getHat().getColor();
    }

    public static boolean shouldRenderEyes(AbstractClientPlayer player){
        ObjUserCosmetics uc = getCosmetics(player);
        if(uc == null){
            return false;
        }
        return uc.isGooglyEyesEnabled();
    }

    private static ObjUserCosmetics getCosmetics(AbstractClientPlayer player){
        for(ObjUserCosmetics uc : userCosmetics){
            if(player.getGameProfile().getId().equals(uc.getUuid())){
                return uc;
            }
        }
        return null;
    }

    public static void downloadUserCosmetics() {
        userCosmetics = HTTPFunctions.downloadUserCosmetics();
    }
}
