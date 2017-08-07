package bits.bits.team.command;

import bits.bits.team.data.DataDonor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandDonors implements CommandExecutor {
  private DataDonor data;

  public CommandDonors(DataDonor data) {
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
