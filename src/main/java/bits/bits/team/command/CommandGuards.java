package bits.bits.team.command;

import bits.bits.team.data.DataGuard;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandGuards implements CommandExecutor {
  private DataGuard data;

  public CommandGuards(DataGuard data) {
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
