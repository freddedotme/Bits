package bits.bits.team.command;

import bits.bits.team.data.DataWarp;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandWarps implements CommandExecutor {
  private DataWarp data;

  public CommandWarps(DataWarp data) {
    this.data = data;
  }

  @Override
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
    if (!(commandSender instanceof Player)) return false;
    Player player = (Player) commandSender;

    data.printWarps(player);
    return true;
  }
}
