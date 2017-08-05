package bits.bits.team;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkUnloadEvent;

class EventCancelChunkUnload implements Listener {
  private DataWarp data;

  EventCancelChunkUnload(DataWarp data) {
    this.data = data;
  }

  @EventHandler
  void onChunkUnload(ChunkUnloadEvent e) {
    e.setCancelled(data.isWarpInsideChunk(e.getChunk()));
  }
}
