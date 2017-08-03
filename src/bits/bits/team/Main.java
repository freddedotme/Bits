package bits.bits.team;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Main extends JavaPlugin {
  @Override
  public void onEnable() {
    super.onEnable();

    DataBed dataBed = new DataBed(0);
    DataGuard dataGuard = new DataGuard(this);
    DataWarp dataWarp = new DataWarp(this);

    getServer().getPluginManager().registerEvents(new EventPlayerJoinQuit(this, dataGuard), this);
    getServer().getPluginManager().registerEvents(new EventBedEnterLeave(this, dataBed), this);
    getServer().getPluginManager().registerEvents(new EventChunkUnload(dataWarp), this);
    getServer().getPluginManager().registerEvents(new EventSignChange(), this);
    getServer().getPluginManager().registerEvents(new EventVotifier(this), this);

    getCommand("bed").setExecutor(new CommandBed(this));
    getCommand("warp").setExecutor(new CommandWarp(this, dataWarp));
    getCommand("warps").setExecutor(new CommandWarps(dataWarp));
    getCommand("setwarp").setExecutor(new CommandSetWarp(this, dataWarp));
    getCommand("delwarp").setExecutor(new CommandDelWarp(this, dataWarp));
    getCommand("guards").setExecutor(new CommandGuards(dataGuard));
    getCommand("setguard").setExecutor(new CommandSetGuard(this, dataGuard));
    getCommand("delguard").setExecutor(new CommandDelGuard(this, dataGuard));
    getCommand("info").setExecutor(new CommandInfo());
  }

  boolean invalidAction(Player player, String message) {
    player.sendMessage(message);
    return false;
  }

  void teleport(Player player, Location location) {
    location.getChunk().load(true);
    player.sendMessage(Data.MSG_TELEPORTING);
    new BukkitRunnable() {
      @Override
      public void run() {
        player.teleport(location);
        player.sendMessage(Data.MSG_TELEPORTED);
      }
    }.runTaskLater(this, Data.TELEPORT_WARMUP);
  }
}
