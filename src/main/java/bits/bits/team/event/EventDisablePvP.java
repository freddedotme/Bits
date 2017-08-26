package bits.bits.team.event;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityCombustByEntityEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

/**
 * The type Event disable pvp.
 */
public class EventDisablePvP implements Listener {

  /**
   * On entity damage by entity.
   *
   * @param e the e
   */
  @EventHandler
  public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
    if (isPvpDamage(e.getDamager(), e.getEntity()))
      e.setCancelled(true);
  }

  /**
   * On entity combust by entity.
   *
   * @param e the e
   */
  @EventHandler
  public void onEntityCombustByEntity(EntityCombustByEntityEvent e) {
    if (isPvpDamage(e.getCombuster(), e.getEntity()))
      e.setCancelled(true);
  }

  private boolean isPvpDamage(Entity source, Entity target) {
    // Returns true if the target is a player, and the source is either a player or a projectile shot by a player.
    return target instanceof Player &&
      (source instanceof Player || (source instanceof Projectile
        && ((Projectile) source).getShooter() instanceof Player));
  }
}
