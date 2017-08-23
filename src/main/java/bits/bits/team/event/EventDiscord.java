package bits.bits.team.event;

import bits.bits.team.Discord;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * Bits
 * Author: freddedotme
 * Created: 2017-08-23
 */
public class EventDiscord implements Listener {
  private Discord discord;

  public EventDiscord(Discord discord) {
    this.discord = discord;
  }

  @EventHandler
  public void onAsyncPlayerChat(AsyncPlayerChatEvent e) {
    String name = e.getPlayer().getName();
    String message = e.getMessage();

    discord.sendToDiscord(name, message);
  }
}
