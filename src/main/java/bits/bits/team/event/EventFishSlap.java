package bits.bits.team.event;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

/**
 * Bits
 * Authors: freddedotme, AlbinEriksson
 * Created: 2017-08-17
 */
public class EventFishSlap implements Listener {
  @EventHandler
  public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
    if (!(e.getDamager() instanceof Player)) return;
    Player damager = (Player) e.getDamager();

    if (!(e.getEntity() instanceof Player)) return;
    Player entity = (Player) e.getEntity();

    e.setCancelled(true);

    if (damager.getLocation().getWorld().getEnvironment() != World.Environment.NORMAL) return;

    ItemStack item = damager.getInventory().getItemInMainHand();
    ItemStack fish = new ItemStack(Material.RAW_FISH, 1);

    if (item == null || !item.isSimilar(fish)) return;

    double horizontalPower = 0.5; // length of XZ velocity
    double verticalPower = 0.2; // length of Y velocity

    Vector launch = damager.getEyeLocation()
      .getDirection()
      .setY(0)
      .normalize()
      .multiply(horizontalPower)
      .setY(verticalPower);

    entity.setVelocity(entity.getVelocity()
      .add(launch));

    damager.getInventory().removeItem(fish);
  }
}
