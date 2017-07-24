package bits.bits.team;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSetWarp implements CommandExecutor
{
  private Main     main;
  private DataWarp data;

  CommandSetWarp(Main main, DataWarp data)
  {
    this.main = main;
    this.data = data;
  }

  @Override
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings)
  {
    if (!(commandSender instanceof Player)) return false;
    Player player = (Player) commandSender;

    if (!player.isOp()) return main.invalidAction(player, Data.MSG_PERMISSION);

    if (strings.length != 1) return main.invalidAction(player, Data.MSG_ARGUMENTS);
    String name = strings[0];

    Warp warp = data.getWarp(name);
    if (warp != null) return main.invalidAction(player, Data.MSG_WARP_FOUND);

    data.addWarp(name, player.getLocation());
    return true;
  }
}
