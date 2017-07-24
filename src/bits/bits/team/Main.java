package bits.bits.team;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Main extends JavaPlugin
{
  @Override
  public void onEnable()
  {
    super.onEnable();

    // Data
    DataBed   dataBed   = new DataBed(0);         // done
    DataGuard dataGuard = new DataGuard(this);    // done
    DataWarp  dataWarp  = new DataWarp(this);     // done

    // Event
    getServer().getPluginManager().registerEvents(new EventPlayerJoinQuit(dataGuard), this);      // done
    getServer().getPluginManager().registerEvents(new EventBedEnterLeave(this, dataBed), this);   // done
    getServer().getPluginManager().registerEvents(new EventChunkUnload(dataWarp), this);          // done
    getServer().getPluginManager().registerEvents(new EventSignChange(), this);                   // done

    // Commands
    getCommand("bed").setExecutor(new CommandBed(this));                      // done
    getCommand("warp").setExecutor(new CommandWarp(this, dataWarp));          // done
    getCommand("warps").setExecutor(new CommandWarps(dataWarp));              // done
    getCommand("setwarp").setExecutor(new CommandSetWarp(this, dataWarp));    // done
    getCommand("delwarp").setExecutor(new CommandDelWarp(this, dataWarp));    // done
    getCommand("guards").setExecutor(new CommandGuards(dataGuard));           // done
    getCommand("setguard").setExecutor(new CommandSetGuard(this, dataGuard)); // done
    getCommand("delguard").setExecutor(new CommandDelGuard(this, dataGuard)); // done
  }

  boolean invalidAction(Player player, String message)
  {
    player.sendMessage(message);
    return false;
  }

  void teleport(Player player, Location location)
  {
    location.getChunk().load(true);
    player.sendMessage(Data.MSG_TELEPORTING);
    new BukkitRunnable()
    {
      @Override
      public void run()
      {
        player.teleport(location);
        player.sendMessage(Data.MSG_TELEPORTED);
      }
    }.runTaskLater(this, Data.TELEPORT_WARMUP);
  }
}
