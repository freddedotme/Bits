package bits.bits.team.command;

import bits.bits.team.Main;
import bits.bits.team.User;
import bits.bits.team.data.Data;
import bits.bits.team.data.DataUser;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandDelDonor implements CommandExecutor {
  private Main main;
  private DataUser data;

  public CommandDelDonor(Main main, DataUser data) {
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

    User user = data.getUser(temporary.getUniqueId());
    if (user == null) return main.invalidAction(player, Data.MSG_ERROR);

    if (user.isGuard()) return main.invalidAction(player, Data.MSG_ALREADY_GUARD);

    user.setDonor(false);
    return true;
  }
}
