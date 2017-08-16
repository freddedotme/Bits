package bits.bits.team;

import bits.bits.team.file.FileManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

import java.util.UUID;

/**
 * Bits
 * Author: freddedotme
 * Created: 2017-08-14
 */
public class User {
  private FileManager file;
  private Main main;
  private UUID uuid;
  private boolean donor, guard;
  private String prefix;
  private PermissionAttachment permissions;
  private String root;

  public User(FileManager file, Main main, UUID uuid, boolean donor, boolean guard, String prefix,
              PermissionAttachment permissions) {
    this.file = file;
    this.main = main;
    this.uuid = uuid;
    this.donor = donor;
    this.guard = guard;
    this.prefix = prefix;
    this.permissions = permissions;

    root = "users." + uuid.toString();
  }

  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

  public boolean isDonor() {
    return donor;
  }

  public void setDonor(boolean donor) {
    this.donor = donor;
    file.write(root + ".donor", donor);

    if (donor) addDonorPermissions();
  }

  public boolean isGuard() {
    return guard;
  }

  public void setGuard(boolean guard) {
    this.guard = guard;
    file.write(root + ".guard", guard);

    if (guard) addGuardPermissions();
  }

  public String getPrefix() {
    return prefix;
  }

  public void setPrefix(String prefix) {
    this.prefix = prefix;
    file.write(root + ".prefix", prefix);

    Player player = main.getServer().getPlayer(uuid);
    if (player == null) return;

    player.setDisplayName(ChatColor.translateAlternateColorCodes('&', prefix + player.getName() + "&r"));
    player.setPlayerListName(ChatColor.translateAlternateColorCodes('&', prefix + player.getName() + "&r"));
  }

  private void addGuardPermissions() {
    Player player = main.getServer().getPlayer(uuid);
    if (player == null) return;

    permissions = player.addAttachment(main);
    permissions.setPermission(main.d().PERM_BYPASSCOOLDOWN, true);
    permissions.setPermission(main.d().PERM_COLOREDNAME, true);
    permissions.setPermission("minecraft.command.ban", true);
    permissions.setPermission("minecraft.command.kick", true);
    permissions.setPermission("minecraft.command.pardon", true);
    permissions.setPermission("coreprotect.lookup", true);
    permissions.setPermission("coreprotect.inspect", true);
  }

  private void addDonorPermissions() {
    Player player = main.getServer().getPlayer(uuid);
    if (player == null) return;

    permissions = player.addAttachment(main);
    permissions.setPermission(main.d().PERM_BYPASSCOOLDOWN, true);
    permissions.setPermission(main.d().PERM_COLOREDNAME, true);
  }

  public void join() {
    if (prefix != null) setPrefix(prefix);
    if (donor) addDonorPermissions();
    if (guard) addGuardPermissions();
  }

  public void quit() {
    Player player = main.getServer().getPlayer(uuid);
    if (player == null) return;

    if (permissions == null) return;
    player.removeAttachment(permissions);
    permissions = null;
  }
}
