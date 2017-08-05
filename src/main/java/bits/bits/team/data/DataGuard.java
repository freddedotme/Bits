package bits.bits.team.data;

import bits.bits.team.Main;
import bits.bits.team.file.FileManager;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DataGuard {
  private Main main;
  private FileManager file;
  private List<UUID> guards;
  private PermissionAttachment permission;

  public DataGuard(Main main) {
    this.main = main;

    file = new FileManager("guards.yml");
    file.write("version", main.getDescription().getVersion());
    fetchFile();
  }

  private void fetchFile() {
    guards = new ArrayList<>();
    if (file.getKeys("guards") == null) return;

    for (String guard : file.getKeys("guards")) {
      UUID uuid = UUID.fromString(guard);
      guards.add(uuid);
    }
  }

  public void addGuard(UUID uuid) {
    guards.add(uuid);
    file.write("guards." + uuid.toString() + ".active", true);
  }

  public void removeGuard(UUID uuid) {
    file.write("guards." + uuid.toString(), null);
    guards.remove(uuid);
  }

  public boolean isGuard(UUID uuid) {
    for (UUID guard : guards) {
      if (guard.equals(uuid)) return true;
    }
    return false;
  }

  public void addPermissions(Player player) {
    permission = player.addAttachment(main);
    permission.setPermission("minecraft.command.kick", true);
    permission.setPermission("minecraft.command.ban", true);
    permission.setPermission("minecraft.command.pardon", true);
    permission.setPermission("coreprotect.lookup", true);
    permission.setPermission("coreprotect.inspect", true);
  }

  public void removePermissions(Player player) {
    player.removeAttachment(permission);
  }

  public void printGuards(Player player) {
    player.sendMessage("Guards:");
    for (UUID guard : guards) {
      OfflinePlayer offlinePlayer = main.getServer().getOfflinePlayer(guard);
      player.sendMessage(offlinePlayer.getName());
    }
  }
}
