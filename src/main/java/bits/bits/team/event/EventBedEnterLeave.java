package bits.bits.team.event;

import bits.bits.team.Main;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;

public class EventBedEnterLeave implements Listener {
  private Main main;
  private int sleeping = 0;

  public EventBedEnterLeave(Main main) {
    this.main = main;
  }

  @EventHandler
  public void onPlayerBedEnter(PlayerBedEnterEvent e) {
    World world = e.getPlayer().getWorld();
    if (!(world.getEnvironment().equals(World.Environment.NORMAL))) return;

    sleeping++;

    int online = main.getServer().getOnlinePlayers().size();
    if ((double) sleeping / online >= 0.5) world.setTime(0);

    main.getServer().broadcastMessage(main.d().MSG_SLEEPING.replace("{sleeping}", String.valueOf(sleeping))
      .replace("{online}", String.valueOf(online)));
  }

  @EventHandler
  public void onPlayerBedLeave(PlayerBedLeaveEvent e) {
    sleeping--;
  }
}
