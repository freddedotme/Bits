package bits.bits.team.event;

import bits.bits.team.data.DataShop;
import org.bukkit.event.Listener;

public class EventShopBuy implements Listener {
  private DataShop data;

  public EventShopBuy(DataShop data) {
    this.data = data;
  }
}
