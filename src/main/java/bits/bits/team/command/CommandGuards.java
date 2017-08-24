package bits.bits.team.command;

import bits.bits.team.data.DataUser;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * The type Command guards.
 */
public class CommandGuards implements CommandExecutor {
  private DataUser data;

  /**
   * Instantiates a new Command guards.
   *
   * @param data the data
   */
  public CommandGuards(DataUser data) {
    this.data = data;
  }

  @Override
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
    if (!(commandSender instanceof Player)) return false;
    Player player = (Player) commandSender;

    data.printGuards(player);
    return true;
  }
}
