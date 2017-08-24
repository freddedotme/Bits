package bits.bits.team.event;

import bits.bits.team.Main;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;

/**
 * The type Event bed enter leave.
 */
public class EventBedEnterLeave implements Listener {
  private Main main;
  private int sleeping = 0;

  /**
   * Instantiates a new Event bed enter leave.
   *
   * @param main the main
   */
  public EventBedEnterLeave(Main main) {
    this.main = main;
  }

  /**
   * On player bed enter.
   *
   * @param e the e
   */
  @EventHandler
  public void onPlayerBedEnter(PlayerBedEnterEvent e) {
    World world = e.getPlayer().getWorld();
    if (!(world.getEnvironment().equals(World.Environment.NORMAL))) return;

    sleeping++;

    int online = main.getServer().getOnlinePlayers().size();
    if ((double) sleeping / online >= 0.5) world.setTime(0);

    main.getServer().dispatchCommand(main.getServer().getConsoleSender(), "broadcast " + main.d().MSG_SLEEPING
      .replace("{sleeping}",
        String.valueOf(sleeping))
      .replace("{online}", String.valueOf(online)));
  }

  /**
   * On player bed leave.
   *
   * @param e the e
   */
  @EventHandler
  public void onPlayerBedLeave(PlayerBedLeaveEvent e) {
    sleeping--;
  }
}
