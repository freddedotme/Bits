package bits.bits.team.command;

import bits.bits.team.Main;
import bits.bits.team.User;
import bits.bits.team.data.DataUser;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * The type Command del guard.
 */
public class CommandDelGuard implements CommandExecutor {
  private Main main;
  private DataUser data;

  /**
   * Instantiates a new Command del guard.
   *
   * @param main the main
   * @param data the data
   */
  public CommandDelGuard(Main main, DataUser data) {
    this.main = main;
    this.data = data;
  }

  @Override
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
    if (!(commandSender instanceof Player)) return false;
    Player player = (Player) commandSender;

    if (!player.isOp()) return main.invalidAction(player, main.d().NEGATIVE_PERMISSION);

    if (strings.length != 1) return main.invalidAction(player, main.d().NEGATIVE_ARGUMENTS);
    String name = strings[0];

    Player temporary = main.getServer().getPlayer(name);
    if (temporary == null) return main.invalidAction(player, main.d().NEGATIVE_PLAYER_NOT_FOUND);

    User user = data.getUser(temporary.getUniqueId());
    if (user == null) return main.invalidAction(player, main.d().NEGATIVE_ERROR);

    if (!user.isGuard()) return main.invalidAction(player, main.d().NEGATIVE_NOT_GUARD);

    user.setGuard(false);
    return true;
  }
}

