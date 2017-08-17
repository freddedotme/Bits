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
	if(e.getEntity() instanceof Player)
    {
      // If damager is a player, or the damager is a projectile shot by a player
      if(e.getDamager() instanceof Player
	    || (e.getDamager() instanceof Projectile
	      && ((Projectile) e.getDamager()).getShooter() instanceof Player))
      	e.setCancelled(true);
    }
  }
}
