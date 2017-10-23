package bits.bits.team.event;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

/**
 * The type Event entity spawn.
 */
public class EventEntitySpawn implements Listener {

  private int maxEntityCount;

  /**
   * Instantiates a new Event entity spawn.
   *
   * @param maxEntityCount the max entity count
   */
  public EventEntitySpawn(int maxEntityCount) {
    this.maxEntityCount = maxEntityCount;
  }

  /**
   * On entity spawn.
   *
   * @param e the e
   */
  @EventHandler
  public void onEntitySpawn(EntitySpawnEvent e) {
    if (!(e.getEntity() instanceof LivingEntity)) return;

    int currentEntityCount = 0;
    for (Entity entity : e.getLocation().getChunk().getEntities())
      if (entity instanceof LivingEntity) currentEntityCount++;

    e.setCancelled(currentEntityCount >= maxEntityCount);
  }
}
