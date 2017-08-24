package bits.bits.team.command;

import bits.bits.team.data.DataUser;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * The type Command donors.
 */
public class CommandDonors implements CommandExecutor {
  private DataUser data;

  /**
   * Instantiates a new Command donors.
   *
   * @param data the data
   */
  public CommandDonors(DataUser data) {
    this.data = data;
  }

  @Override
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
    if (!(commandSender instanceof Player)) return false;
    Player player = (Player) commandSender;

    data.printDonors(player);
    return true;
  }
}
