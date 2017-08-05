package bits.bits.team.event;

import bits.bits.team.data.DataShop;
import org.bukkit.event.Listener;

public class EventShopDelete implements Listener {
  private DataShop data;

  public EventShopDelete(DataShop data) {
    this.data = data;
  }
}
