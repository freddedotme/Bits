package bits.bits.team.event;

import bits.bits.team.Main;
import bits.bits.team.User;
import bits.bits.team.data.Data;
import bits.bits.team.data.DataUser;
import bits.bits.team.runnable.RunnableRandomTeleport;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class EventPlayerJoinQuit implements Listener {
  private Main main;
  private DataUser data;

  public EventPlayerJoinQuit(Main main, DataUser data) {
    this.main = main;
    this.data = data;
  }

  @EventHandler
  void onPlayerJoin(PlayerJoinEvent e) {
    Player player = e.getPlayer();
    UUID uuid = player.getUniqueId();

    User user = data.getUser(uuid);

    if (user == null) {
      e.setJoinMessage(Data.MSG_JOIN_NEW.replace("{player}", player.getName()));
      player.sendMessage(Data.MSG_RANDOMSPAWN);
      new RunnableRandomTeleport(main, player).runTaskTimerAsynchronously(main, 0, 20);

      player.getInventory().addItem(new ItemStack(Material.CAKE, 1));
      player.performCommand("info");

      data.addUser(uuid, false, false, "&f");
      data.getUser(uuid).join();
    }
    else {
      user.join();
      e.setJoinMessage(Data.MSG_JOIN.replace("{player}", player.getDisplayName()));
    }
  }

  @EventHandler
  void onPlayerQuit(PlayerQuitEvent e) {
    Player player = e.getPlayer();
    UUID uuid = player.getUniqueId();

    User user = data.getUser(uuid);
    if (user != null) user.quit();

    e.setQuitMessage(Data.MSG_QUIT.replace("{player}", e.getPlayer().getDisplayName()));
  }
}
