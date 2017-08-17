package bits.bits.team.event;

import org.bukkit.Bukkit;
import org.bukkit.Material;
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
	Bukkit.getLogger().info("An entity has damaged another entity");
  	
  	if (!(e.getDamager() instanceof Player)) return;
    Player damager = (Player) e.getDamager();

    Bukkit.getLogger().info("The damager was a player");
    
    if (!(e.getEntity() instanceof Player)) return;
    Player entity = (Player) e.getEntity();
    
    Bukkit.getLogger().info("The damaged entity was a player");
    
    e.setCancelled(true);
    
    ItemStack item = damager.getInventory().getItemInMainHand();
    ItemStack fish = new ItemStack(Material.RAW_FISH, 1);

    if (item == null || !item.isSimilar(fish)) return;
    
    Bukkit.getLogger().info("The damager was holding a fish");
    
    double horizontalPower = 2; // length of XZ velocity
    double verticalPower = 0.5; // length of Y velocity
    
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
