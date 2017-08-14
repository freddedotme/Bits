package bits.bits.team;

import bits.bits.team.command.*;
import bits.bits.team.data.Data;
import bits.bits.team.data.DataUser;
import bits.bits.team.data.DataWarp;
import bits.bits.team.event.*;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Main extends JavaPlugin {
  @Override
  public void onEnable() {
    super.onEnable();

    DataWarp dataWarp = new DataWarp(this);
    DataUser dataUser = new DataUser(this);

    getServer().getPluginManager().registerEvents(new EventPlayerJoinQuit(this, dataUser), this);
    getServer().getPluginManager().registerEvents(new EventBedEnterLeave(this), this);
    getServer().getPluginManager().registerEvents(new EventCancelChunkUnload(dataWarp), this);
    getServer().getPluginManager().registerEvents(new EventSignColorize(), this);
    getServer().getPluginManager().registerEvents(new EventVote(this), this);

    getCommand("bed").setExecutor(new CommandBed(this));

    getCommand("warp").setExecutor(new CommandWarp(this, dataWarp));
    getCommand("warps").setExecutor(new CommandWarps(dataWarp));
    getCommand("setwarp").setExecutor(new CommandSetWarp(this, dataWarp));
    getCommand("delwarp").setExecutor(new CommandDelWarp(this, dataWarp));

    getCommand("guards").setExecutor(new CommandGuards(dataUser));
    getCommand("donors").setExecutor(new CommandDonors(dataUser));
    getCommand("setguard").setExecutor(new CommandSetGuard(this, dataUser));
    getCommand("delguard").setExecutor(new CommandDelGuard(this, dataUser));
    getCommand("setdonor").setExecutor(new CommandSetDonor(this, dataUser));
    getCommand("deldonor").setExecutor(new CommandDelDonor(this, dataUser));

    getCommand("info").setExecutor(new CommandInfo());
    getCommand("colorname").setExecutor(new CommandColorName(this, dataUser));
    getCommand("vote").setExecutor(new CommandVote());
    getCommand("hat").setExecutor(new CommandHat());
    getCommand("donate").setExecutor(new CommandDonate());
    getCommand("seen").setExecutor(new CommandSeen(this));
    getCommand("joined").setExecutor(new CommandJoined(this));
  }

  public boolean invalidAction(Player player, String message) {
    player.sendMessage(message);
    return false;
  }

  public void teleport(final Player player, final Location location) {
    location.getChunk().load(true);
    player.sendMessage(Data.MSG_TELEPORTING);
    new BukkitRunnable() {
      @Override
      public void run() {
        player.teleport(location);
        player.sendMessage(Data.MSG_TELEPORTED);
      }
    }.runTaskLater(this, (player.hasPermission(Data.PERM_BYPASSCOOLDOWN) ? Data.TELEPORT_WARMUP_DONOR : Data
      .TELEPORT_WARMUP));
  }

  public String cc(String message) {
    return ChatColor.translateAlternateColorCodes('&', message);
  }
}
