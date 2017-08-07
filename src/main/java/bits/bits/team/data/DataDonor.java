package bits.bits.team.data;

import bits.bits.team.Main;
import bits.bits.team.file.FileManager;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

import java.util.HashMap;
import java.util.UUID;

public class DataDonor {
  private Main main;
  private FileManager file;
  private HashMap<UUID, PermissionAttachment> donors;

  public DataDonor(Main main) {
    this.main = main;

    file = new FileManager("donors.yml");
    file.write("version", main.getDescription().getVersion());
    fetchFile();
  }

  private void fetchFile() {
    donors = new HashMap<>();
    if (file.getKeys("donors") == null) return;

    for (String donor : file.getKeys("donors")) {
      UUID uuid = UUID.fromString(donor);
      donors.put(uuid, null);
    }
  }

  public void addDonor(UUID uuid) {
    donors.put(uuid, null);
    file.write("donors." + uuid.toString() + ".active", true);
  }

  public void removeDonor(UUID uuid) {
    file.write("donors." + uuid.toString(), null);
    donors.remove(uuid);
  }

  public boolean isDonor(UUID uuid) {
    return (donors.get(uuid) == null);
  }

  public void addPermissions(Player player) {
    PermissionAttachment permission = player.addAttachment(main);
    permission.setPermission(Data.PERM_COLOREDNAME, true);
    permission.setPermission(Data.PERM_BYPASSCOOLDOWN, true);
    donors.put(player.getUniqueId(), permission);
  }

  public void removePermissions(Player player) {
    UUID uuid = player.getUniqueId();
    if (donors.get(uuid) == null) return;

    player.removeAttachment(donors.get(uuid));
  }

  public void printDonors(Player player) {
    player.sendMessage("Donors (thanks a lot):");
    for (UUID donor : donors.keySet()) {
      OfflinePlayer offlinePlayer = main.getServer().getOfflinePlayer(donor);
      player.sendMessage(offlinePlayer.getName());
    }
  }
}
