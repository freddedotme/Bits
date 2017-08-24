package bits.bits.team.event;

import bits.bits.team.Discord;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * The type Event discord.
 */
public class EventDiscord implements Listener {
  private Discord discord;

  /**
   * Instantiates a new Event discord.
   *
   * @param discord the discord
   */
  public EventDiscord(Discord discord) {
    this.discord = discord;
  }

  /**
   * On async player chat.
   *
   * @param e the e
   */
  @EventHandler
  public void onAsyncPlayerChat(AsyncPlayerChatEvent e) {
    String name = e.getPlayer().getName();
    String message = e.getMessage();

    discord.sendToDiscord(name, message);
  }
}
