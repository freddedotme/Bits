package bits.bits.team.event;

import bits.bits.team.Main;
import bits.bits.team.data.DataUser;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * The type Event shop buy.
 */
public class EventShopBuy implements Listener {
  private Main main;
  private DataUser data;

  /**
   * Instantiates a new Event shop buy.
   *
   * @param main the main
   * @param data the data
   */
  public EventShopBuy(Main main, DataUser data) {
    this.main = main;
    this.data = data;
  }

  /**
   * On inventory click.
   *
   * @param e the e
   */
  @EventHandler
  public void onInventoryClick(InventoryClickEvent e) {
  }
}
