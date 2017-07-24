package bits.bits.team;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandDelGuard implements CommandExecutor
{
  private Main      main;
  private DataGuard data;

  CommandDelGuard(Main main, DataGuard data)
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

    Player temporary = main.getServer().getPlayer(name);
    if (temporary == null) return main.invalidAction(player, Data.MSG_PLAYER_NOT_FOUND);

    boolean isGuard = data.isGuard(temporary.getUniqueId());
    if (!isGuard) return main.invalidAction(player, Data.MSG_NOT_A_GUARD);

    data.removeGuard(temporary.getUniqueId());
    return true;
  }
}

