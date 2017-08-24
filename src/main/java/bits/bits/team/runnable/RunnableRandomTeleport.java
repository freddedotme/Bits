package bits.bits.team.runnable;

import bits.bits.team.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.concurrent.ThreadLocalRandom;

/**
 * The type Runnable random teleport.
 */
public class RunnableRandomTeleport extends BukkitRunnable {
  private Main main;
  private Player player;
  private int attempts = 0;

  /**
   * Instantiates a new Runnable random teleport.
   *
   * @param main   the main
   * @param player the player
   */
  public RunnableRandomTeleport(Main main, Player player) {
    this.main = main;
    this.player = player;
  }

  @Override
  public void run() {
    if (attempts >= main.d().RANDOMSPAWN_ATTEMPTS) this.cancel();

    attempts++;

    World bits = main.getServer().getWorld("bits");
    WorldBorder worldBorder = bits.getWorldBorder();

    double size = worldBorder.getSize();
    Location center = worldBorder.getCenter();
    double x = center.getBlockX();
    double z = center.getBlockZ();
    double margin = main.d().WB_MARGIN;

    double maxX = (x + size / 2) - margin;
    double minX = (x - size / 2) + margin;
    double maxZ = (z + size / 2) - margin;
    double minZ = (z - size / 2) + margin;

    double randX = ThreadLocalRandom.current().nextDouble(minX, maxX);
    double randZ = ThreadLocalRandom.current().nextDouble(minZ, maxZ);

    new BukkitRunnable() {
      @Override
      public void run() {
        if (!player.isOnline()) stop();
        player.sendMessage(main.d().NEUTRAL_RANDOMSPAWN_LOOKING.replace("{attempts}", String.valueOf(attempts)).replace
          ("{maxAttempts}", String.valueOf(main.d().RANDOMSPAWN_ATTEMPTS)));

        Block randBlock = bits.getHighestBlockAt((int) randX, (int) randZ).getRelative(0, -1, 0);

        if (randBlock.getType() != Material.STATIONARY_WATER && randBlock.getType() != Material.STATIONARY_LAVA) {
          main.teleport(player, new Location(bits, randX, randBlock.getY() + 1, randZ));
          stop();
        }
      }
    }.runTask(main);
  }

  private void stop() {
    this.cancel();
  }
}
