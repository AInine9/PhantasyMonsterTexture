package hugu1026.com.github.phantasymonstertexture;

import hugu1026.com.github.phantasymonstertexture.listener.EntitySpawn;
import org.bukkit.Bukkit;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class PhantasyMonsterTexture extends JavaPlugin {

    @Override
    public void onEnable() {
        super.onEnable();

        registerEvents();

        Bukkit.getScheduler().scheduleSyncRepeatingTask(PhantasyMonsterTexture.getPlugin(PhantasyMonsterTexture.class), () -> {
            List<Entity> entities = Bukkit.getWorld("world").getEntities();
            entities.stream()
                    .filter(ArmorStand.class::isInstance)
                    .map(ArmorStand.class::cast)
                    .forEach(entity -> {
                        if (entity.getFallDistance() > 0
                                && entity.hasGravity()) {
                            entity.remove();
                        }
                    });
        }, 1, 5);
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    public void registerEvents() {
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new EntitySpawn(), this);
    }

}
