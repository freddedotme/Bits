package bits.bits.team.event;

import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

/**
 * Bits
 * Authors: AlbinEriksson
 * Created: 2017-08-17
 */
public class EventDisablePvP implements Listener {
  @EventHandler
  public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
  	// Player attacks player
	if(!(e.getDamager() instanceof Player)
	  || !(e.getEntity() instanceof Player)) return;

	// Player shoots player
	if(!(e.getDamager() instanceof Projectile)
	  || !(((Projectile)e.getDamager()).getShooter() instanceof Player)
	  || !(e.getEntity() instanceof Player)) return;
	
	e.setCancelled(true);
  }
}
