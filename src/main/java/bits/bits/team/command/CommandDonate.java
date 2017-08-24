package bits.bits.team.command;

import bits.bits.team.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * The type Command donate.
 */
public class CommandDonate implements CommandExecutor {
  private Main main;

  /**
   * Instantiates a new Command donate.
   *
   * @param main the main
   */
  public CommandDonate(Main main) {
    this.main = main;
  }

  @Override
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
    if (!(commandSender instanceof Player)) return false;
    Player player = (Player) commandSender;

    player.sendMessage(main.d().POSITIVE_DONATE);

    return true;
  }
}
