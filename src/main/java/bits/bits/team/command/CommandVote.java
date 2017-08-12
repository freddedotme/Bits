package bits.bits.team.command;

import bits.bits.team.data.Data;
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

  @Override
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
    if (!(commandSender instanceof Player)) return false;
    Player player = (Player) commandSender;

    player.sendMessage(Data.MSG_VOTE);

    return true;
  }
}
