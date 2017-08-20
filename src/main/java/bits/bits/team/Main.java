package bits.bits.team;

import bits.bits.team.command.*;
import bits.bits.team.data.Data;
import bits.bits.team.data.DataUser;
import bits.bits.team.data.DataWarp;
import bits.bits.team.event.*;
import bits.bits.team.runnable.RunnableWorldEvent;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Main extends JavaPlugin {
  private Data data;

  @Override
  public void onEnable() {
    super.onEnable();

    data = new Data();
    DataWarp dataWarp = new DataWarp(this);
    DataUser dataUser = new DataUser(this);

    getServer().getPluginManager().registerEvents(new EventPlayerJoinQuit(this, dataUser), this);
    getServer().getPluginManager().registerEvents(new EventBedEnterLeave(this), this);
    getServer().getPluginManager().registerEvents(new EventCancelChunkUnload(dataWarp), this);
    getServer().getPluginManager().registerEvents(new EventSignColorize(), this);
    getServer().getPluginManager().registerEvents(new EventVote(this), this);
    getServer().getPluginManager().registerEvents(new EventFishSlap(), this);
    getServer().getPluginManager().registerEvents(new EventDisablePvP(), this);

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

    getCommand("info").setExecutor(new CommandInfo(this));
    getCommand("colorname").setExecutor(new CommandColorName(this, dataUser));
    getCommand("vote").setExecutor(new CommandVote(this));
    getCommand("hat").setExecutor(new CommandHat());
    getCommand("donate").setExecutor(new CommandDonate(this));
    getCommand("seen").setExecutor(new CommandSeen(this));
    getCommand("joined").setExecutor(new CommandJoined(this));
    getCommand("broadcast").setExecutor(new CommandBroadcast(this, dataUser));
    getCommand("randomteleport").setExecutor(new CommandRandomTeleport(this, dataUser));
    getCommand("playerhead").setExecutor(new CommandPlayerHead(this));
    getCommand("beam").setExecutor(new CommandBeam(this, dataUser));

    new RunnableWorldEvent(this).runTaskTimerAsynchronously(this, 400, 360000);
  }

  public Data d() {
    return data;
  }

  public boolean invalidAction(Player player, String message) {
    player.sendMessage(message);
    return false;
  }

  public void teleport(final Player player, final Location location) {
    location.getChunk().load(true);
    player.sendMessage(data.NEUTRAL_TELEPORTING);
    new BukkitRunnable() {
      @Override
      public void run() {
        player.teleport(location);
        player.sendMessage(data.POSITIVE_TELEPORTED);
      }
    }.runTaskLater(this, (player.hasPermission(data.PERM_BYPASSCOOLDOWN) ? data.TELEPORT_WARMUP_DONOR : data
      .TELEPORT_WARMUP));
  }
}
