package hugu1026.com.github.phantasymonstertexture.listener;

import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class EntitySpawn implements Listener {

    @EventHandler
    public void EntitySpawn(EntitySpawnEvent event) {
        if (event.getEntity() instanceof Zombie
                && event.getEntity().getCustomName() != null) {
            ((Zombie) event.getEntity()).setRemoveWhenFarAway(false);
        }
    }
}
