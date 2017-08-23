package bits.bits.team.event;

import bits.bits.team.Main;
import com.mrpowergamerbr.temmiewebhook.DiscordMessage;
import com.mrpowergamerbr.temmiewebhook.TemmieWebhook;
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
public class EventChatDiscord implements Listener {
  private static final TemmieWebhook WEBHOOK = new TemmieWebhook("https://discordapp.com/api/webhooks/349972577277706242/tlJuGH4P1G7WuvdwMDjEXuHVQZTtgQY9TbEVupIgIsOML5Z0j4SQsppZ6J_lUgjchbio");
  private Main main;

  public EventChatDiscord(Main main) {
    this.main = main;
  }

  @EventHandler
  public void onAsyncPlayerChat(AsyncPlayerChatEvent e) {
    String message = e.getMessage();
    String avatar = String.format("https://crafatar.com/avatars/%s", String.valueOf(e.getPlayer().getName()));
    WEBHOOK.sendMessage(new DiscordMessage(e.getPlayer().getName(), message, avatar));

    for (Player player : main.getServer().getOnlinePlayers()) {
      String name = player.getName();

      if (message.contains("@" + name))
        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BASS, 0.3F, 1.0F);
    }

    e.setMessage(message);
  }
}
