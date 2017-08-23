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

public class DataWarp {
  private FileManager file;
  private Main main;
  private List<Warp> warps;

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

  public void addWarp(String name, Location location) {
    Warp warp = new Warp(name, location, file);
    warps.add(warp);
    sort();
  }

  public void deleteWarp(Warp warp) {
    warp.delete();
    warps.remove(warp);
    sort();
  }

  public Warp getWarp(String name) {
    for (Warp warp : warps) {
      if (warp.getName().equalsIgnoreCase(name)) return warp;
    }
    return null;
  }

  public boolean isWarpInsideChunk(Chunk chunk) {
    for (Warp warp : warps) {
      if (warp.getLocation().getChunk().equals(chunk)) return true;
    }
    return false;
  }

  public void printWarps(Player player) {
    player.sendMessage(main.d().HEADER_WARPS);
    for (Warp warp : warps) {
      player.sendMessage(warp.getName());
    }
  }

  private void sort() {
    warps.sort(Comparator.comparing(Warp::getName));
  }

  public List<Warp> getWarps() {
    return warps;
  }
}