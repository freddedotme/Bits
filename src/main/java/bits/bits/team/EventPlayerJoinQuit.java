package bits.bits.team;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

class EventPlayerJoinQuit implements Listener {
  private Main main;
  private DataGuard data;

  EventPlayerJoinQuit(Main main, DataGuard data) {
    this.main = main;
    this.data = data;
  }

  @EventHandler
  void onPlayerJoin(PlayerJoinEvent e) {
    Player player = e.getPlayer();
    UUID uuid = player.getUniqueId();

    if (data.isGuard(uuid)) data.addPermissions(player);

    if (!player.hasPlayedBefore()) {
      e.setJoinMessage(Data.MSG_JOIN_NEW.replace("{player}", player.getName()));
      player.sendMessage(Data.MSG_RANDOMSPAWN);
      new RunnableRandomTeleport(main, player).runTaskTimerAsynchronously(main, 0, 20);

      player.getInventory().addItem(new ItemStack(Material.CAKE, 1));
      player.performCommand("info");
    }
    else {
      e.setJoinMessage(Data.MSG_JOIN.replace("{player}", player.getName()));
    }
  }

  @EventHandler
  void onPlayerQuit(PlayerQuitEvent e) {
    Player player = e.getPlayer();
    e.setQuitMessage(Data.MSG_QUIT.replace("{player}", e.getPlayer().getName()));

    UUID uuid = player.getUniqueId();
    if (!data.isGuard(uuid)) return;

    data.removePermissions(player);
  }
}
