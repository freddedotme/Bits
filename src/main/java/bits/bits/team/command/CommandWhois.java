package bits.bits.team.command;

import bits.bits.team.Main;
import bits.bits.team.User;
import bits.bits.team.data.DataUser;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * The type Command whois.
 */
public class CommandWhois implements CommandExecutor {
  private Main main;
  private DataUser data;

  /**
   * Instantiates a new Command whois.
   *
   * @param main the main
   * @param data the data
   */
  public CommandWhois(Main main, DataUser data) {
    this.main = main;
    this.data = data;
  }

  @Override
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
    if (!(commandSender instanceof Player)) return false;
    Player player = (Player) commandSender;

    if (strings.length != 1) return main.invalidAction(player, main.d().NEGATIVE_ARGUMENTS);
    String name = strings[0];

    OfflinePlayer temporary = null;
    for (OfflinePlayer op : main.getServer().getOfflinePlayers()) {
      if (op.getName().equalsIgnoreCase(name)) temporary = op;
    }

    if (temporary == null) return main.invalidAction(player, main.d().NEGATIVE_PLAYER_NOT_FOUND);

    User user = data.getUser(temporary.getUniqueId());
    if (user == null) return main.invalidAction(player, main.d().NEGATIVE_ERROR);

    String nick = (user.getNickname() != null) ? user.getNickname() : "<none>";

    player.sendMessage(main.d().NEUTRAL_WHOIS.replace("{player}", temporary.getName()).replace("{nickname}", nick));
    player.performCommand("seen " + temporary.getName());
    player.performCommand("joined " + temporary.getName());

    return true;
  }
}
