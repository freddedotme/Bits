package bits.bits.team.command;

import bits.bits.team.Main;
import bits.bits.team.User;
import bits.bits.team.data.DataUser;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Date;
import java.util.UUID;

/**
 * Bits
 * Author: freddedotme
 * Created: 2017-08-20
 */
public class CommandBeam implements CommandExecutor {
  private Main main;
  private DataUser data;

  public CommandBeam(Main main, DataUser data) {
    this.main = main;
    this.data = data;
  }

  @Override
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
    if (!(commandSender instanceof Player)) return false;
    Player player = (Player) commandSender;

    User user = data.getUser(player.getUniqueId());
    if (user == null) return main.invalidAction(player, main.d().NEGATIVE_ERROR);

    if (strings.length != 1) return main.invalidAction(player, main.d().NEGATIVE_ARGUMENTS);
    String argument = strings[0];

    if (argument.equalsIgnoreCase("accept")) {
      if (user.getBeamedFrom() == null) return main.invalidAction(player, main.d().NEGATIVE_BEAMEDFROM);

      Player temporary = main.getServer().getPlayer(user.getBeamedFrom());
      if (temporary == null) return main.invalidAction(player, main.d().NEGATIVE_PLAYER_NOT_FOUND);

      temporary.sendMessage(main.d().POSITIVE_BEAM_ACCEPTED);
      main.teleport(temporary, player.getLocation());

      user.setBeamedFrom(null);

      user = data.getUser(temporary.getUniqueId());
      if (user == null) return main.invalidAction(player, main.d().NEGATIVE_ERROR);

      user.setBeam(new Date());
      user.setBeamedTo(null);
    }
    else if (argument.equalsIgnoreCase("cancel")) {
      if (!user.isDonor() && !user.isGuard()) return main.invalidAction(player, main.d().NEGATIVE_PERMISSION);

      if (user.getBeamedTo() == null) return main.invalidAction(player, main.d().NEGATIVE_BEAMEDTO);

      UUID temporary = user.getBeamedTo();
      user.setBeamedTo(null);

      user = data.getUser(temporary);
      if (user == null) return main.invalidAction(player, main.d().NEGATIVE_ERROR);

      user.setBeamedFrom(null);

      player.sendMessage(main.d().POSITIVE_BEAM_CANCELLED);
    }
    else {
      if (!user.isDonor() && !user.isGuard()) return main.invalidAction(player, main.d().NEGATIVE_PERMISSION);

      Player temporary = main.getServer().getPlayer(argument);
      if (temporary == null) return main.invalidAction(player, main.d().NEGATIVE_PLAYER_NOT_FOUND);

      user.setBeamedTo(temporary.getUniqueId());

      user = data.getUser(temporary.getUniqueId());
      if (user == null) return main.invalidAction(player, main.d().NEGATIVE_ERROR);

      user.setBeamedFrom(player.getUniqueId());
      temporary.sendMessage(main.d().NEUTRAL_BEAMEDTO.replace("{player}", player.getName()));

      player.sendMessage(main.d().POSITIVE_BEAM_SENT);
    }

    return true;
  }
}
