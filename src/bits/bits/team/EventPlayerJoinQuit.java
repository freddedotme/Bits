package bits.bits.team;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.UUID;

class EventPlayerJoinQuit implements Listener
{
  private DataGuard data;

  EventPlayerJoinQuit(DataGuard data)
  {
    this.data = data;
  }

  @EventHandler
  void onPlayerJoin(PlayerJoinEvent e)
  {
    Player player = e.getPlayer();
    e.setJoinMessage(Data.MSG_JOIN.replace("{player}", player.getName()));

    UUID uuid = player.getUniqueId();
    if (!data.isGuard(uuid)) return;

    data.addPermissions(player);
  }

  @EventHandler
  void onPlayerQuit(PlayerQuitEvent e)
  {
    Player player = e.getPlayer();
    e.setQuitMessage(Data.MSG_QUIT.replace("{player}", e.getPlayer().getName()));

    UUID uuid = player.getUniqueId();
    if (!data.isGuard(uuid)) return;

    data.removePermissions(player);
  }
}
