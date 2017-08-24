package bits.bits.team;

import bits.bits.team.file.FileManager;
import org.bukkit.Location;

/**
 * The type Warp.
 */
public class Warp {
  private String name;
  private Location location;
  private FileManager manager;

  /**
   * Instantiates a new Warp.
   *
   * @param name     the name
   * @param location the location
   * @param manager  the manager
   */
  public Warp(String name, Location location, FileManager manager) {
    this.name = name;
    this.location = location;
    this.manager = manager;

    int x = location.getBlockX();
    int y = location.getBlockY();
    int z = location.getBlockZ();
    String world = location.getWorld().getName();

    manager.write("warps." + name + ".x", x);
    manager.write("warps." + name + ".y", y);
    manager.write("warps." + name + ".z", z);
    manager.write("warps." + name + ".world", world);
  }

  /**
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets location.
   *
   * @return the location
   */
  public Location getLocation() {
    return location;
  }

  /**
   * Delete.
   */
  public void delete() {
    manager.write("warps." + name, null);
  }
}
