package bits.bits.team.event;

import bits.bits.team.Discord;
import bits.bits.team.Main;
import bits.bits.team.User;
import bits.bits.team.data.DataUser;
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
  private Discord discord;

  public EventPlayerJoinQuit(Main main, DataUser data, Discord discord) {
    this.main = main;
    this.data = data;
    this.discord = discord;
  }

  @EventHandler
  void onPlayerJoin(PlayerJoinEvent e) {
    Player player = e.getPlayer();
    UUID uuid = player.getUniqueId();

    User user = data.getUser(uuid);

    if (user == null) {
      data.addUser(uuid, false, false, "&f");
      data.getUser(uuid).join();
    }
    else {
      user.join();
    }

    if (!player.hasPlayedBefore()) {
      e.setJoinMessage(main.d().MSG_JOIN_NEW.replace("{player}", player.getName()));
      discord.sendToDiscord("BOT", main.d().MSG_JOIN_NEW.replace("{player}", player.getName()));

      player.getInventory().addItem(new ItemStack(Material.CAKE, 1));
      player.getInventory().addItem(new ItemStack(Material.BED, 1));
      player.getInventory().addItem(new ItemStack(Material.GOLD_SPADE, 1));
      player.getInventory().addItem(new ItemStack(Material.STONE_AXE, 1));

      player.performCommand("info");
      player.performCommand("randomteleport");
    }
    else {
      e.setJoinMessage(main.d().MSG_JOIN.replace("{player}", player.getDisplayName()));
      discord.sendToDiscord("BOT", main.d().MSG_JOIN.replace("{player}", player.getName()));
    }

    discord.sendToDiscord("BOT", main.getServer().getOnlinePlayers().size() + " players online.");
  }

  @EventHandler
  void onPlayerQuit(PlayerQuitEvent e) {
    Player player = e.getPlayer();
    UUID uuid = player.getUniqueId();

    User user = data.getUser(uuid);
    if (user != null) user.quit();

    e.setQuitMessage(main.d().MSG_QUIT.replace("{player}", e.getPlayer().getDisplayName()));
    discord.sendToDiscord("BOT", main.d().MSG_QUIT.replace("{player}", player.getName()));
  }
}
