package bits.bits.team.command;

import bits.bits.team.Main;
import bits.bits.team.Warp;
import bits.bits.team.data.DataWarp;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * The type Command del warp.
 */
public class CommandDelWarp implements CommandExecutor {
  private Main main;
  private DataWarp data;

  /**
   * Instantiates a new Command del warp.
   *
   * @param main the main
   * @param data the data
   */
  public CommandDelWarp(Main main, DataWarp data) {
    this.main = main;
    this.data = data;
  }

  @Override
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
    if (!(commandSender instanceof Player)) return false;
    Player player = (Player) commandSender;

    if (!player.isOp()) return main.invalidAction(player, main.d().NEGATIVE_PERMISSION);

    if (strings.length != 1) return main.invalidAction(player, main.d().NEGATIVE_ARGUMENTS);
    String name = strings[0];

    Warp warp = data.getWarp(name);
    if (warp == null) return main.invalidAction(player, main.d().NEGATIVE_WARP_NOT_FOUND);

    data.deleteWarp(warp);
    return true;
  }
}
