package hugu1026.com.github.phantasymonstertexture;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class PhantasyMonsterTexture extends JavaPlugin {

    @Override
    public void onEnable() {
        super.onEnable();

        registerEvents();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    public void registerEvents() {
        PluginManager pm = Bukkit.getPluginManager();
    }

}