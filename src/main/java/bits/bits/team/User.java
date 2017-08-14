package bits.bits.team;

import bits.bits.team.data.Data;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

import java.util.UUID;

/**
 * Bits
 * Author: freddedotme
 * Created: 2017-08-14
 */
public class User {
  private Main main;
  private UUID uuid;
  private boolean donor, guard;
  private String prefix;
  private PermissionAttachment permissions;

  public User(Main main, UUID uuid, boolean donor, boolean guard, String prefix, PermissionAttachment permissions) {
    this.main = main;
    this.uuid = uuid;
    this.donor = donor;
    this.guard = guard;
    this.prefix = prefix;
    this.permissions = permissions;
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
    if (donor) addDonorPermissions();
  }

  public boolean isGuard() {
    return guard;
  }

  public void setGuard(boolean guard) {
    this.guard = guard;
    if (guard) addGuardPermissions();
  }

  public String getPrefix() {
    return prefix;
  }

  public void setPrefix(String prefix) {
    this.prefix = prefix;

    Player player = main.getServer().getPlayer(uuid);
    if (player == null) return;

    player.setDisplayName(main.cc(prefix + player.getName() + "&r"));
    player.setPlayerListName(main.cc(prefix + player.getName() + "&r"));
  }

  public PermissionAttachment getPermissions() {
    return permissions;
  }

  public void setPermissions(PermissionAttachment permissions) {
    this.permissions = permissions;
  }

  private void addGuardPermissions() {
    Player player = main.getServer().getPlayer(uuid);
    if (player == null) return;

    permissions = player.addAttachment(main);
    permissions.setPermission(Data.PERM_BYPASSCOOLDOWN, true);
    permissions.setPermission(Data.PERM_COLOREDNAME, true);
  }

  private void addDonorPermissions() {
    Player player = main.getServer().getPlayer(uuid);
    if (player == null) return;

    permissions = player.addAttachment(main);
    permissions.setPermission(Data.PERM_BYPASSCOOLDOWN, true);
    permissions.setPermission(Data.PERM_COLOREDNAME, true);
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
