package bits.bits.team.event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.HashMap;

public class EventPlayerMove implements Listener {

    public static final HashMap<Player, Long> lastMoveTimes = new HashMap<>();

    @EventHandler(ignoreCancelled = true)
    public void onPlayerMove(PlayerMoveEvent event) {
        lastMoveTimes.put(event.getPlayer(), event.getPlayer().getWorld().getFullTime());
    }
}
