package bits.bits.team.event;

import bits.bits.team.data.DataWarp;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkUnloadEvent;

public class EventCancelChunkUnload implements Listener {
  private DataWarp data;

  public EventCancelChunkUnload(DataWarp data) {
    this.data = data;
  }

  @EventHandler
  public void onChunkUnload(ChunkUnloadEvent e) {
    e.setCancelled(data.isWarpInsideChunk(e.getChunk()));
  }
}
