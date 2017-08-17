package bits.bits.team.event;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Bits
 * Author: freddedotme
 * Created: 2017-08-17
 */
public class EventFishSlap implements Listener {

  public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
    if (!(e.getDamager() instanceof Player)) return;
    Player damager = (Player) e.getDamager();

    if (!(e.getEntity() instanceof Player)) return;
    Player entity = (Player) e.getEntity();

    ItemStack item = damager.getInventory().getItemInMainHand();
    ItemStack fish = new ItemStack(Material.RAW_FISH);

    if (item == null || !item.isSimilar(fish)) return;

    // Albin do magic below
  }
}
