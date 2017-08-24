package bits.bits.team.event;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

/**
 * The type Event fish slap.
 */
public class EventFishSlap implements Listener {
  /**
   * On entity damage by entity.
   *
   * @param e the e
   */
  @EventHandler
  public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
    if (!(e.getDamager() instanceof Player)) return;
    Player damager = (Player) e.getDamager();

    if (!(e.getEntity() instanceof Player)) return;
    Player entity = (Player) e.getEntity();

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

    damager.getWorld().playSound(damager.getLocation(), Sound.BLOCK_NOTE_BELL, 0.2F, 1.5F);
    damager.getInventory().removeItem(fish);
  }
}
