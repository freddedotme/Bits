package bits.bits.team.event;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class EventEntitySpawn implements Listener {

  private int maxEntityCount;

  public EventEntitySpawn(int maxEntityCount) {
    this.maxEntityCount = maxEntityCount;
  }

  @EventHandler
  public void onEntitySpawn(EntitySpawnEvent e) {
    if (!(e.getEntity() instanceof LivingEntity)) return;

    int currentEntityCount = 0;
    for (Entity entity : e.getLocation().getChunk().getEntities())
      if (entity instanceof LivingEntity) currentEntityCount++;

    e.setCancelled(currentEntityCount >= maxEntityCount);
  }
}
