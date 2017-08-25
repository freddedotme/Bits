package bits.bits.team.data;

import bits.bits.team.Main;
import bits.bits.team.Shop;
import bits.bits.team.User;
import bits.bits.team.file.FileManager;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * The type Data user.
 */
public class DataUser {
  private FileManager file;
  private Main main;
  private List<User> users;

  /**
   * Instantiates a new Data user.
   *
   * @param main the main
   */
  public DataUser(Main main) {
    this.main = main;

    file = new FileManager(main, "users.yml");
    file.write("version", main.getDescription().getVersion());
    fetchFile();
  }

  private void fetchFile() {
    users = new ArrayList<>();
    if (file.getKeys("users") == null) return;

    for (String user : file.getKeys("users")) {
      UUID uuid = UUID.fromString(user);

      String root = "users." + uuid.toString();
      boolean donor = (boolean) file.read(root + ".donor");
      boolean guard = (boolean) file.read(root + ".guard");
      String prefix = (String) file.read(root + ".prefix");

      List<Shop> shops = new ArrayList<>();

      if (file.getKeys(root + ".shops") != null) {
        for (String shop : file.getKeys(root + ".shops")) {
          World world = main.getServer().getWorld("bits");

          int x = (int) file.read(root + ".shops." + shop + ".x");
          int y = (int) file.read(root + ".shops." + shop + ".y");
          int z = (int) file.read(root + ".shops." + shop + ".z");

          shops.add(new Shop(uuid, world.getBlockAt(x, y, z).getLocation()));
        }
      }

      users.add(new User(file, main, uuid, donor, guard, prefix, null, shops));
    }
  }

  /**
   * Add user.
   *
   * @param uuid   the uuid
   * @param donor  the donor
   * @param guard  the guard
   * @param prefix the prefix
   */
  public void addUser(UUID uuid, boolean donor, boolean guard, String prefix) {
    users.add(new User(file, main, uuid, donor, guard, prefix, null, null));

    String root = "users." + uuid.toString();
    file.write(root + ".donor", donor);
    file.write(root + ".guard", guard);
    file.write(root + ".prefix", prefix);
  }

  /**
   * Remove user.
   *
   * @param uuid the uuid
   */
  public void removeUser(UUID uuid) {
    User user = getUser(uuid);
    if (user == null) return;

    users.remove(user);

    String root = "users." + uuid.toString();
    file.write(root, null);
  }

  /**
   * Gets user.
   *
   * @param uuid the uuid
   * @return the user
   */
  public User getUser(UUID uuid) {
    for (User user : users)
      if (user.getUuid().equals(uuid)) return user;
    return null;
  }

  /**
   * Print donors.
   *
   * @param player the player
   */
  public void printDonors(Player player) {
    player.sendMessage(main.d().HEADER_DONORS);
    for (User user : users) {
      if (user.isDonor()) {
        OfflinePlayer offlinePlayer = main.getServer().getOfflinePlayer(user.getUuid());
        player.sendMessage(offlinePlayer.getName());
      }
    }
  }

  /**
   * Print guards.
   *
   * @param player the player
   */
  public void printGuards(Player player) {
    player.sendMessage(main.d().HEADER_GUARDS);
    for (User user : users) {
      if (user.isGuard()) {
        OfflinePlayer offlinePlayer = main.getServer().getOfflinePlayer(user.getUuid());
        player.sendMessage(offlinePlayer.getName());
      }
    }
  }
}
