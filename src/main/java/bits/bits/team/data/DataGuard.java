package bits.bits.team.data;

import bits.bits.team.Main;
import bits.bits.team.file.FileManager;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

import java.util.HashMap;
import java.util.UUID;

public class DataGuard {
  private Main main;
  private FileManager file;
  private HashMap<UUID, PermissionAttachment> guards;

  public DataGuard(Main main) {
    this.main = main;

    file = new FileManager("guards.yml");
    file.write("version", main.getDescription().getVersion());
    fetchFile();
  }

  private void fetchFile() {
    guards = new HashMap<>();
    if (file.getKeys("guards") == null) return;

    for (String guard : file.getKeys("guards")) {
      UUID uuid = UUID.fromString(guard);
      guards.put(uuid, null);
    }
  }

  public void addGuard(UUID uuid) {
    guards.put(uuid, null);
    file.write("guards." + uuid.toString() + ".active", true);
  }

  public void removeGuard(UUID uuid) {
    file.write("guards." + uuid.toString(), null);
    guards.remove(uuid);
  }

  public boolean isGuard(UUID uuid) {
    return (guards.containsKey(uuid));
  }

  public void addPermissions(Player player) {
    PermissionAttachment permission = player.addAttachment(main);
    permission.setPermission("minecraft.command.kick", true);
    permission.setPermission("minecraft.command.ban", true);
    permission.setPermission("minecraft.command.pardon", true);
    permission.setPermission("coreprotect.lookup", true);
    permission.setPermission("coreprotect.inspect", true);
    permission.setPermission(Data.PERM_COLOREDNAME, true);
    permission.setPermission(Data.PERM_BYPASSCOOLDOWN, true);
    guards.put(player.getUniqueId(), permission);
  }

  public void removePermissions(Player player) {
    UUID uuid = player.getUniqueId();
    if (!guards.containsKey(uuid)) return;

    player.removeAttachment(guards.get(uuid));
  }

  public void printGuards(Player player) {
    player.sendMessage("Guards:");
    for (UUID guard : guards.keySet()) {
      OfflinePlayer offlinePlayer = main.getServer().getOfflinePlayer(guard);
      player.sendMessage(offlinePlayer.getName());
    }
  }
}
