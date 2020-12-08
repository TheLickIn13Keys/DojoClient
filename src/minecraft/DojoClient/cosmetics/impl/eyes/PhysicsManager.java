package DojoClient.cosmetics.impl.eyes;

import DojoClient.event.EventManager;
import DojoClient.event.EventTarget;
import DojoClient.event.impl.ClientTickEvent;
import DojoClient.event.impl.WorldUnloadEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public class PhysicsManager {

    private WeakHashMap<AbstractClientPlayer, EyePhysics> physicsList = new WeakHashMap<AbstractClientPlayer, EyePhysics>();

    private static PhysicsManager instance = null;

    public static PhysicsManager getInstance() {
        if(instance == null) {
            instance = new PhysicsManager();
            EventManager.register(instance);
        }
        return instance;
    }

    public EyePhysics getPhysics(AbstractClientPlayer player) {
        if(!physicsList.containsKey(player)) {
            physicsList.put(player, new EyePhysics(player));
        }
        return physicsList.get(player);
    }

    @EventTarget
    public void onTick(ClientTickEvent event) {

        if(Minecraft.getMinecraft().theWorld != null && !Minecraft.getMinecraft().isGamePaused()) {

            Iterator<Map.Entry<AbstractClientPlayer, EyePhysics>> iterator = physicsList.entrySet().iterator();

            while(iterator.hasNext()) {
                Map.Entry<AbstractClientPlayer, EyePhysics> e = iterator.next();
                EyePhysics ep = e.getValue();

                if(ep.getPlayer().worldObj.getWorldTime() - ep.getLastUpdate() > 3) {
                    iterator.remove();
                }
                else {
                    ep.update();
                }
            }

        }

    }

    @EventTarget
    public void onWorldUload(WorldUnloadEvent event) {
        Iterator<Map.Entry<AbstractClientPlayer, EyePhysics>> iterator = physicsList.entrySet().iterator();

        while(iterator.hasNext()) {
            Map.Entry<AbstractClientPlayer, EyePhysics> e = iterator.next();
            EyePhysics ep = e.getValue();
            if(ep.getPlayer().worldObj == event.getWorld()) {
                iterator.remove();
            }
        }
    }

}
