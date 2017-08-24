package bits.bits.team.event;

import bits.bits.team.data.DataWarp;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkUnloadEvent;

/**
 * The type Event cancel chunk unload.
 */
public class EventCancelChunkUnload implements Listener {
  private DataWarp data;

  /**
   * Instantiates a new Event cancel chunk unload.
   *
   * @param data the data
   */
  public EventCancelChunkUnload(DataWarp data) {
    this.data = data;
  }

  /**
   * On chunk unload.
   *
   * @param e the e
   */
  @EventHandler
  public void onChunkUnload(ChunkUnloadEvent e) {
    e.setCancelled(data.isWarpInsideChunk(e.getChunk()));
  }
}
