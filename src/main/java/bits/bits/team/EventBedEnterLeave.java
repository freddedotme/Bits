package bits.bits.team;

import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;

class EventBedEnterLeave implements Listener {
  private Main main;
  private DataBed data;

  EventBedEnterLeave(Main main, DataBed data) {
    this.main = main;
    this.data = data;
  }

  @EventHandler
  void onPlayerBedEnter(PlayerBedEnterEvent e) {
    World world = e.getPlayer().getWorld();
    if (!(world.getEnvironment().equals(World.Environment.NORMAL))) return;

    data.incrementSleeping(1);

    int online = main.getServer().getOnlinePlayers().size();
    if ((double) data.getSleeping() / online >= 0.5) world.setTime(0);

    main.getServer().broadcastMessage(Data.MSG_SLEEPING.replace("{sleeping}", String.valueOf(data.getSleeping()))
      .replace("{online}", String.valueOf(online)));
  }

  @EventHandler
  void onPlayerBedLeave(PlayerBedLeaveEvent e) {
    data.decreaseSleeping(1);
  }
}
