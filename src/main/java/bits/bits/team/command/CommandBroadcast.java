package bits.bits.team.command;

import bits.bits.team.Main;
import bits.bits.team.User;
import bits.bits.team.data.DataUser;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

/**
 * The type Command broadcast.
 */
public class CommandBroadcast implements CommandExecutor {
  private Main main;
  private DataUser data;
  private StringBuilder message;

  /**
   * Instantiates a new Command broadcast.
   *
   * @param main the main
   * @param data the data
   */
  public CommandBroadcast(Main main, DataUser data) {
    this.main = main;
    this.data = data;

    message = new StringBuilder();
  }

  @Override
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
    if (commandSender instanceof Player) {
      Player player = (Player) commandSender;

      User user = data.getUser(player.getUniqueId());
      if (user == null) return main.invalidAction(player, main.d().NEGATIVE_ERROR);

      if (!user.isGuard()) return main.invalidAction(player, main.d().NEGATIVE_PERMISSION);

      if (strings.length < 1) return main.invalidAction(player, main.d().NEGATIVE_ARGUMENTS);

      for (String string : strings)
        message.append(string).append(" ");

      main.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', message.toString().trim()));

      message = new StringBuilder();
    }
    else if (commandSender instanceof ConsoleCommandSender) {
      if (strings.length < 1) return false;

      for (String string : strings)
        message.append(string).append(" ");

      main.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', message.toString().trim()));

      message = new StringBuilder();
    }

    return true;
  }
}
