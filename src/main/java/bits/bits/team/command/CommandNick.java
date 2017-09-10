package bits.bits.team.command;

import bits.bits.team.Main;
import bits.bits.team.User;
import bits.bits.team.data.DataUser;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Date;

/**
 * The type Command nick.
 */
public class CommandNick implements CommandExecutor {
  private Main main;
  private DataUser data;

  /**
   * Instantiates a new Command nick.
   *
   * @param main the main
   * @param data the data
   */
  public CommandNick(Main main, DataUser data) {
    this.main = main;
    this.data = data;
  }

  @Override
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
    if (!(commandSender instanceof Player)) return false;
    Player player = (Player) commandSender;

    User user = data.getUser(player.getUniqueId());
    if (user == null) return main.invalidAction(player, main.d().NEGATIVE_ERROR);

    Date nickname = user.getNick();

    if (nickname != null && new Date().getTime() - nickname.getTime() < 300000)
      return main.invalidAction(player, main.d().NEGATIVE_BEAM);

    if (strings.length != 1) return main.invalidAction(player, main.d().NEGATIVE_ARGUMENTS);
    String nick = strings[0];

    if (!nick.matches("[a-zA-Z0-9]*")) return false;

    if (nick.equalsIgnoreCase("clear")) {
      user.setNickname(null);
      return true;
    }

    if (data.getUserByNickname(nick) != null) return false;

    for (OfflinePlayer offlinePlayer : main.getServer().getOfflinePlayers())
      if (nick.equalsIgnoreCase(offlinePlayer.getName())) return false;

    if (nick.length() < 3 || nick.length() > 16) return false;

    user.setNickname(nick);
    user.setNick(new Date());

    return true;
  }
}
