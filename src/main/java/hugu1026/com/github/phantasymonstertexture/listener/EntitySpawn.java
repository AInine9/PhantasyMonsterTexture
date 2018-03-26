package hugu1026.com.github.phantasymonstertexture.listener;

import hugu1026.com.github.phantasymonstertexture.manager.MonsterTextureList;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Map;

public class EntitySpawn implements Listener {

    @EventHandler
    public void EntitySpawn(EntitySpawnEvent event) {
        if (event.getEntity() instanceof Zombie
                && event.getEntity().getCustomName() != null) {

            ((Zombie) event.getEntity()).setRemoveWhenFarAway(false);

            ArmorStand armorStand = (ArmorStand) event.getEntity().getWorld().spawnEntity(event.getLocation().add(0, 2, 0), EntityType.ARMOR_STAND);

            ItemStack helmet = new ItemStack(Material.IRON_SWORD);
            ItemMeta meta = helmet.getItemMeta();
            meta.setUnbreakable(true);
            helmet.setItemMeta(meta);

            Map<String, Integer> textureList = MonsterTextureList.getTextureList();

            String display[] = event.getEntity().getCustomName().split(" ");
            String name = display[1];
            int number = textureList.get(name);

            helmet.setDurability((short) (number));

            armorStand.setHelmet(helmet);
            armorStand.setInvulnerable(true);
            armorStand.setCustomName(event.getEntity().getCustomName());
            armorStand.setCustomNameVisible(true);
            armorStand.setFallDistance(0);
            armorStand.setVisible(false);

            event.getEntity().setPassenger(armorStand);
        }
    }
}
