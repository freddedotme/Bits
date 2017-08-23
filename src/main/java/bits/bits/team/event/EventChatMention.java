package bits.bits.team.event;

import bits.bits.team.Main;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * Bits
 * Author: freddedotme
 * Created: 2017-08-23
 */
public class EventChatMention implements Listener {
  private Main main;

  public EventChatMention(Main main) {
    this.main = main;
  }

  @EventHandler
  public void onAsyncPlayerChat(AsyncPlayerChatEvent e) {
    String message = e.getMessage();

    for (Player player : main.getServer().getOnlinePlayers()) {
      String name = player.getName();

      if (message.contains("@" + name))
        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BASS, 0.3F, 1.0F);
    }

    e.setMessage(message);
  }
}
