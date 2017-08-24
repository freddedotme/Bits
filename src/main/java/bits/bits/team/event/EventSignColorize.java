package bits.bits.team.event;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

/**
 * The type Event sign colorize.
 */
public class EventSignColorize implements Listener {
  /**
   * On sign change.
   *
   * @param e the e
   */
  @EventHandler
  public void onSignChange(SignChangeEvent e) {
    for (int i = 0; i < e.getLines().length; i++)
      e.setLine(i, ChatColor.translateAlternateColorCodes('&', e.getLine(i)));
  }
}
