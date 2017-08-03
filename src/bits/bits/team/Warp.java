package bits.bits.team;

import org.bukkit.Location;

class Warp {
  private String name;
  private Location location;
  private FileManager manager;

  Warp(String name, Location location, FileManager manager) {
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

  String getName() {
    return name;
  }

  Location getLocation() {
    return location;
  }

  void delete() {
    manager.write("warps." + name, null);
  }
}
