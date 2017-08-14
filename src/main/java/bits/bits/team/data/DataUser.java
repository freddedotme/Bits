package bits.bits.team.data;

import bits.bits.team.Main;
import bits.bits.team.User;
import bits.bits.team.file.FileManager;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

/**
 * Bits
 * Author: freddedotme
 * Created: 2017-08-14
 */
public class DataUser {
  private FileManager file;
  private Main main;
  private List<User> users;

  public DataUser(Main main) {
    this.main = main;

    file = new FileManager("users.yml");
    file.write("version", main.getDescription().getVersion());
    fetchFile();
  }

  private void fetchFile() {
    if (file.getKeys("users") == null) return;

    for (String user : file.getKeys("users")) {
      UUID uuid = UUID.fromString(user);

      String root = "users." + uuid.toString();
      boolean donor = (boolean) file.read(root + ".donor");
      boolean guard = (boolean) file.read(root + ".guard");
      String prefix = (String) file.read(root + ".prefix");

      users.add(new User(main, uuid, donor, guard, prefix, null));
    }
  }

  public void addUser(UUID uuid, boolean donor, boolean guard, String prefix) {
    users.add(new User(main, uuid, donor, guard, prefix, null));

    String root = "users." + uuid.toString();
    file.write(root + ".donor", donor);
    file.write(root + ".guard", guard);
    file.write(root + ".prefix", prefix);
  }

  public void removeUser(UUID uuid) {
    User user = getUser(uuid);
    if (user == null) return;

    users.remove(user);

    String root = "users." + uuid.toString();
    file.write(root, null);
  }

  public User getUser(UUID uuid) {
    for (User user : users)
      if (user.getUuid().equals(uuid)) return user;
    return null;
  }

  public void printDonors(Player player) {
    for (User user : users) {
      player.sendMessage(main.cc(Data.HEADER_DONORS));
      if (user.isDonor()) {
        OfflinePlayer offlinePlayer = main.getServer().getOfflinePlayer(user.getUuid());
        player.sendMessage(offlinePlayer.getName());
      }
    }
  }

  public void printGuards(Player player) {
    for (User user : users) {
      player.sendMessage(main.cc(Data.HEADER_GUARDS));
      if (user.isGuard()) {
        OfflinePlayer offlinePlayer = main.getServer().getOfflinePlayer(user.getUuid());
        player.sendMessage(offlinePlayer.getName());
      }
    }
  }
}
