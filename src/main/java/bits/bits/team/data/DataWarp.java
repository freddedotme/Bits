package bits.bits.team.data;

import bits.bits.team.Main;
import bits.bits.team.Warp;
import bits.bits.team.file.FileManager;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The type Data warp.
 */
public class DataWarp {
  private FileManager file;
  private Main main;
  private List<Warp> warps;

  /**
   * Instantiates a new Data warp.
   *
   * @param main the main
   */
  public DataWarp(Main main) {
    this.main = main;

    file = new FileManager(main, "warps.yml");
    file.write("version", main.getDescription().getVersion());
    fetchFile();
  }

  private void fetchFile() {
    warps = new ArrayList<>();
    if (file.getKeys("warps") == null) return;

    for (String warp : file.getKeys("warps")) {
      int x = (int) file.read("warps." + warp + ".x");
      int y = (int) file.read("warps." + warp + ".y");
      int z = (int) file.read("warps." + warp + ".z");
      World world = main.getServer().getWorld((String) file.read("warps." + warp + ".world"));

      Location location = new Location(world, (double) x, (double) y, (double) z);

      warps.add(new Warp(warp, location, file));
      sort();
    }
  }

  /**
   * Add warp.
   *
   * @param name     the name
   * @param location the location
   */
  public void addWarp(String name, Location location) {
    Warp warp = new Warp(name, location, file);
    warps.add(warp);
    sort();
  }

  /**
   * Delete warp.
   *
   * @param warp the warp
   */
  public void deleteWarp(Warp warp) {
    warp.delete();
    warps.remove(warp);
    sort();
  }

  /**
   * Gets warp.
   *
   * @param name the name
   * @return the warp
   */
  public Warp getWarp(String name) {
    for (Warp warp : warps) {
      if (warp.getName().equalsIgnoreCase(name)) return warp;
    }
    return null;
  }

  /**
   * Is warp inside chunk boolean.
   *
   * @param chunk the chunk
   * @return the boolean
   */
  public boolean isWarpInsideChunk(Chunk chunk) {
    for (Warp warp : warps) {
      if (warp.getLocation().getChunk().equals(chunk)) return true;
    }
    return false;
  }

  /**
   * Print warps.
   *
   * @param player the player
   */
  public void printWarps(Player player) {
    player.sendMessage(main.d().HEADER_WARPS);
    for (Warp warp : warps) {
      player.sendMessage(warp.getName());
    }
  }

  private void sort() {
    warps.sort(Comparator.comparing(Warp::getName));
  }

  /**
   * Gets warps.
   *
   * @return the warps
   */
  public List<Warp> getWarps() {
    return warps;
  }
}