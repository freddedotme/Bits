package bits.bits.team;

import bits.bits.team.command.*;
import bits.bits.team.data.*;
import bits.bits.team.event.*;
import com.maxmind.db.CHMCache;
import com.maxmind.db.Reader;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;

/**
 * The type Main.
 *
 * @author freddedotme
 */
public class Main extends JavaPlugin {
  private Data data;

  @Override
  public void onEnable() {
    super.onEnable();

    data = new Data();
    DataSettings dataSettings = new DataSettings(this);
    DataWarp dataWarp = new DataWarp(this);
    DataUser dataUser = new DataUser(this);

    File database = new File(data.ROOT_PATH, "GeoLite2-Country.mmdb");
    Reader reader = null;
    try {
      reader = new Reader(database, new CHMCache());
    } catch (IOException e) {
      e.printStackTrace();
    }

    if (dataSettings.isEventPlayerJoinQuit())
      getServer().getPluginManager().registerEvents(new EventPlayerJoinQuit(this, dataUser,
        reader), this);

    if (dataSettings.isEventBedEnterLeave())
      getServer().getPluginManager().registerEvents(new EventBedEnterLeave(this), this);

    if (dataSettings.isEventCancelChunkUnload())
      getServer().getPluginManager().registerEvents(new EventCancelChunkUnload(dataWarp), this);

    if (dataSettings.isEventSignColorize())
      getServer().getPluginManager().registerEvents(new EventSignColorize(), this);

    if (dataSettings.isEventVote())
      getServer().getPluginManager().registerEvents(new EventVote(this), this);

    if (dataSettings.isEventFishSlap())
      getServer().getPluginManager().registerEvents(new EventFishSlap(), this);

    if (dataSettings.isEventDisablePvP())
      getServer().getPluginManager().registerEvents(new EventDisablePvP(), this);

    if (dataSettings.isEventEntitySpawn())
      getServer().getPluginManager().registerEvents(new EventEntitySpawn(256), this);

    if (dataSettings.isCommandBed()) getCommand("bed").setExecutor(new CommandBed(this));

    if (dataSettings.isCommandWarp()) getCommand("warp").setExecutor(new CommandWarp(this, dataWarp));
    if (dataSettings.isCommandWarps()) getCommand("warps").setExecutor(new CommandWarps(dataWarp));
    if (dataSettings.isCommandSetWarp()) getCommand("setwarp").setExecutor(new CommandSetWarp(this, dataWarp));
    if (dataSettings.isCommandDelWarp()) getCommand("delwarp").setExecutor(new CommandDelWarp(this, dataWarp));

    if (dataSettings.isCommandGuards()) getCommand("guards").setExecutor(new CommandGuards(dataUser));
    if (dataSettings.isCommandDonors()) getCommand("donors").setExecutor(new CommandDonors(dataUser));

    if (dataSettings.isCommandSetGuard()) getCommand("setguard").setExecutor(new CommandSetGuard(this, dataUser));
    if (dataSettings.isCommandDelGuard()) getCommand("delguard").setExecutor(new CommandDelGuard(this, dataUser));
    if (dataSettings.isCommandSetDonor()) getCommand("setdonor").setExecutor(new CommandSetDonor(this, dataUser));
    if (dataSettings.isCommandDelDonor()) getCommand("deldonor").setExecutor(new CommandDelDonor(this, dataUser));

    if (dataSettings.isCommandInfo()) getCommand("info").setExecutor(new CommandInfo(this));
    if (dataSettings.isCommandColorName()) getCommand("colorname").setExecutor(new CommandColorName(this, dataUser));
    if (dataSettings.isCommandVote()) getCommand("vote").setExecutor(new CommandVote(this));
    if (dataSettings.isCommandHat()) getCommand("hat").setExecutor(new CommandHat());
    if (dataSettings.isCommandDonate()) getCommand("donate").setExecutor(new CommandDonate(this));
    if (dataSettings.isCommandSeen()) getCommand("seen").setExecutor(new CommandSeen(this));
    if (dataSettings.isCommandJoined()) getCommand("joined").setExecutor(new CommandJoined(this));
    if (dataSettings.isCommandBroadcast()) getCommand("broadcast").setExecutor(new CommandBroadcast(this, dataUser));

    if (dataSettings.isCommandRandomTeleport())
      getCommand("randomteleport").setExecutor(new CommandRandomTeleport(this, dataUser));

    if (dataSettings.isCommandPlayerHead()) getCommand("playerhead").setExecutor(new CommandPlayerHead(this));
    if (dataSettings.isCommandBeam()) getCommand("beam").setExecutor(new CommandBeam(this, dataUser));
    if (dataSettings.isCommandDiscord()) getCommand("discord").setExecutor(new CommandDiscord(this));

    getCommand("nick").setExecutor(new CommandNick(this, dataUser));
    getCommand("whois").setExecutor(new CommandWhois(this, dataUser));
  }

  /**
   * D data.
   *
   * @return the data
   */
  public Data d() {
    return data;
  }

  /**
   * Invalid action boolean.
   *
   * @param player  the player
   * @param message the message
   * @return the boolean
   */
  public boolean invalidAction(Player player, String message) {
    player.sendMessage(message);
    return false;
  }

  /**
   * Teleport.
   *
   * @param player   the player
   * @param location the location
   */
  public void teleport(final Player player, final Location location) {
    location.getChunk().load(true);
    player.sendMessage(data.NEUTRAL_TELEPORTING);
    player.getWorld().spawnParticle(Particle.PORTAL, player.getLocation(), 250, 0.5, 0.5, 0.5);
    player.getWorld().spawnParticle(Particle.PORTAL, location, 250, 0.5, 0.5, 0.5);
    player.getWorld().playSound(player.getLocation(), Sound.BLOCK_PORTAL_TRIGGER, 0.2F, 1.5F);
    new BukkitRunnable() {
      @Override
      public void run() {
        player.teleport(location);
        player.sendMessage(data.POSITIVE_TELEPORTED);
        player.getWorld().spawnParticle(Particle.PORTAL, player.getLocation(), 250, 0.5, 0.5, 0.5);
        player.getWorld().spawnParticle(Particle.PORTAL, player.getLocation(), 50, 0.1, 0.1, 0.1);
        player.getWorld().playSound(player.getLocation(), Sound.BLOCK_PORTAL_TRAVEL, 0.2F, 0.8F);
      }
    }.runTaskLater(this, (player.hasPermission(data.PERM_BYPASSCOOLDOWN) ? data.TELEPORT_WARMUP_DONOR : data
      .TELEPORT_WARMUP));
  }
}
