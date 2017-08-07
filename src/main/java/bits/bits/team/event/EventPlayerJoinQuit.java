package bits.bits.team.event;

import bits.bits.team.Main;
import bits.bits.team.data.Data;
import bits.bits.team.data.DataDonor;
import bits.bits.team.data.DataGuard;
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
  private DataGuard data0;
  private DataDonor data1;

  public EventPlayerJoinQuit(Main main, DataGuard data0, DataDonor data1) {
    this.main = main;
    this.data0 = data0;
    this.data1 = data1;
  }

  @EventHandler
  void onPlayerJoin(PlayerJoinEvent e) {
    Player player = e.getPlayer();
    UUID uuid = player.getUniqueId();

    if (data0.isGuard(uuid)) data0.addPermissions(player);
    if (data1.isDonor(uuid)) data1.addPermissions(player);

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
    UUID uuid = player.getUniqueId();

    e.setQuitMessage(Data.MSG_QUIT.replace("{player}", e.getPlayer().getName()));

    if (data0.isGuard(uuid)) data0.removePermissions(player);
    if (data1.isDonor(uuid)) data1.removePermissions(player);
  }
}
