package bits.bits.team.event;

import bits.bits.team.data.DataShop;
import org.bukkit.event.Listener;

public class EventShopWithdraw implements Listener {
  private DataShop data;

  public EventShopWithdraw(DataShop data) {
    this.data = data;
  }
}
