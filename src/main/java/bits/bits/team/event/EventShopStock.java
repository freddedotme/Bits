package bits.bits.team.event;

import bits.bits.team.data.DataShop;
import org.bukkit.event.Listener;

public class EventShopStock implements Listener {
  private DataShop data;

  public EventShopStock(DataShop data) {
    this.data = data;
  }
}
