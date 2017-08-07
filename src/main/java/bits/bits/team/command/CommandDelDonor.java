package bits.bits.team.command;

import bits.bits.team.Main;
import bits.bits.team.data.Data;
import bits.bits.team.data.DataDonor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandDelDonor implements CommandExecutor {
  private Main main;
  private DataDonor data;

  public CommandDelDonor(Main main, DataDonor data) {
    this.main = main;
    this.data = data;
  }

  @Override
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
    if (!(commandSender instanceof Player)) return false;
    Player player = (Player) commandSender;

    if (!player.isOp()) return main.invalidAction(player, Data.MSG_PERMISSION);

    if (strings.length != 1) return main.invalidAction(player, Data.MSG_ARGUMENTS);
    String name = strings[0];

    Player temporary = main.getServer().getPlayer(name);
    if (temporary == null) return main.invalidAction(player, Data.MSG_PLAYER_NOT_FOUND);

    boolean isDonor = data.isDonor(temporary.getUniqueId());
    if (!isDonor) return main.invalidAction(player, Data.MSG_NOT_A_DONOR);

    data.removeDonor(temporary.getUniqueId());
    return true;
  }
}
