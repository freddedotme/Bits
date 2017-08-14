package bits.bits.team.command;

import bits.bits.team.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Bits
 * Author: freddedotme
 * Created: 2017-08-10
 */
public class CommandVote implements CommandExecutor {
  private Main main;

  public CommandVote(Main main) {
    this.main = main;
  }

  @Override
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
    if (!(commandSender instanceof Player)) return false;
    Player player = (Player) commandSender;

    player.sendMessage(main.d().POSITIVE_VOTE);

    return true;
  }
}
