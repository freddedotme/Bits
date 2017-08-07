package bits.bits.team;

import bits.bits.team.command.*;
import bits.bits.team.data.*;
import bits.bits.team.event.*;
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
    DataDonor dataDonor = new DataDonor(this);

    getServer().getPluginManager().registerEvents(new EventPlayerJoinQuit(this, dataGuard, dataDonor), this);
    getServer().getPluginManager().registerEvents(new EventBedEnterLeave(this, dataBed), this);
    getServer().getPluginManager().registerEvents(new EventCancelChunkUnload(dataWarp), this);
    getServer().getPluginManager().registerEvents(new EventSignColorize(), this);
    getServer().getPluginManager().registerEvents(new EventVote(this), this);

    getServer().getPluginManager().registerEvents(new EventShopBuy(this, dataShop), this);
    getServer().getPluginManager().registerEvents(new EventShopBreak(this, dataShop), this);
    getServer().getPluginManager().registerEvents(new EventShopSetup(this, dataShop), this);
    getServer().getPluginManager().registerEvents(new EventShopStockWithdraw(this, dataShop), this);

    getCommand("bed").setExecutor(new CommandBed(this));
    getCommand("warp").setExecutor(new CommandWarp(this, dataWarp));
    getCommand("warps").setExecutor(new CommandWarps(dataWarp));
    getCommand("setwarp").setExecutor(new CommandSetWarp(this, dataWarp));
    getCommand("delwarp").setExecutor(new CommandDelWarp(this, dataWarp));
    getCommand("guards").setExecutor(new CommandGuards(dataGuard));
    getCommand("setguard").setExecutor(new CommandSetGuard(this, dataGuard));
    getCommand("delguard").setExecutor(new CommandDelGuard(this, dataGuard));
    getCommand("donors").setExecutor(new CommandDonors(dataDonor));
    getCommand("setdonor").setExecutor(new CommandSetDonor(this, dataDonor));
    getCommand("info").setExecutor(new CommandInfo());
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
}
