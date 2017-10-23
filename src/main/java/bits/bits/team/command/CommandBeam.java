package bits.bits.team.command;

import bits.bits.team.Main;
import bits.bits.team.User;
import bits.bits.team.data.DataUser;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * The type Command beam.
 */
public class CommandBeam implements CommandExecutor, TabCompleter {
  private Main main;
  private DataUser data;

  /**
   * Instantiates a new Command beam.
   *
   * @param main the main
   * @param data the data
   */
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
      if (user.getBeamedTo() == null) return main.invalidAction(player, main.d().NEGATIVE_BEAMEDTO);

      UUID temporary = user.getBeamedTo();
      user.setBeamedTo(null);

      user = data.getUser(temporary);
      if (user == null) return main.invalidAction(player, main.d().NEGATIVE_ERROR);

      user.setBeamedFrom(null);

      player.sendMessage(main.d().POSITIVE_BEAM_CANCELLED);
    }
    else {
      Date beam = user.getBeam();

      if (beam != null) {
        int limit = user.isDonor() ? 60000 : 120000;
        long diff = new Date().getTime() - beam.getTime();

        if (diff < limit) {
          long seconds = (limit - diff) / 1000;
          return main.invalidAction(player, main.d().NEGATIVE_BEAM.replace("{seconds}", String.valueOf(seconds)));
        }
      }

      Player temporary = main.getServer().getPlayer(argument);
      if (temporary == null) return main.invalidAction(player, main.d().NEGATIVE_PLAYER_NOT_FOUND);

      if (!player.getWorld().equals(temporary.getWorld()))
        return main.invalidAction(player, main.d().NEGATIVE_BEAMWORLDS);

      user.setBeamedTo(temporary.getUniqueId());

      user = data.getUser(temporary.getUniqueId());
      if (user == null) return main.invalidAction(player, main.d().NEGATIVE_ERROR);

      user.setBeamedFrom(player.getUniqueId());
      temporary.sendMessage(main.d().NEUTRAL_BEAMEDTO.replace("{player}", player.getName()));

      player.sendMessage(main.d().POSITIVE_BEAM_SENT);
    }

    return true;
  }

  @Override
  public List<String> onTabComplete(CommandSender commandSender, Command command, String alias, String[] args) {
    if (!(commandSender instanceof Player)) return null;

    List<String> result = new ArrayList<>();

    if (args.length == 0) {
      Bukkit.getOnlinePlayers().forEach(player -> result.add(player.getName()));
    }
    else {
      if (args[0].startsWith("a")) {
        result.add("accept");
      }
      else if (args[0].startsWith("c")) {
        result.add("cancel");
      }
      Bukkit.getOnlinePlayers().stream()
        .filter(player -> player.getName().toLowerCase().startsWith(args[0].toLowerCase()))
        .forEach(player -> result.add(player.getName()));
    }

    return result;
  }
}
