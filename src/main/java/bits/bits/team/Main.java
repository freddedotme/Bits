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
    DataShop dataShop = new DataShop();

    getServer().getPluginManager().registerEvents(new EventPlayerJoinQuit(this, dataGuard), this);
    getServer().getPluginManager().registerEvents(new EventBedEnterLeave(this, dataBed), this);
    getServer().getPluginManager().registerEvents(new EventCancelChunkUnload(dataWarp), this);
    getServer().getPluginManager().registerEvents(new EventSignColorize(), this);
    getServer().getPluginManager().registerEvents(new EventVote(this), this);

    getServer().getPluginManager().registerEvents(new EventShopBuy(dataShop), this);
    getServer().getPluginManager().registerEvents(new EventShopDelete(dataShop), this);
    getServer().getPluginManager().registerEvents(new EventShopSetup(dataShop), this);
    getServer().getPluginManager().registerEvents(new EventShopStock(dataShop), this);
    getServer().getPluginManager().registerEvents(new EventShopWithdraw(dataShop), this);

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

  void teleport(final Player player, final Location location) {
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
