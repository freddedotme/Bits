package bits.bits.team;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

class EventSignChange implements Listener {
  @EventHandler
  void onSignChange(SignChangeEvent e) {
    for (int i = 0; i < e.getLines().length; i++)
      e.setLine(i, ChatColor.translateAlternateColorCodes('&', e.getLine(i)));
  }
}
