package bits.bits.team.command;

import bits.bits.team.Main;
import bits.bits.team.User;
import bits.bits.team.data.DataUser;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Command whois.
 */
public class CommandWhois implements CommandExecutor, TabCompleter {
  private Main main;
  private DataUser data;

  /**
   * Instantiates a new Command whois.
   *
   * @param main the main
   * @param data the data
   */
  public CommandWhois(Main main, DataUser data) {
    this.main = main;
    this.data = data;
  }

  @Override
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
    if (!(commandSender instanceof Player)) return false;
    Player player = (Player) commandSender;

    if (strings.length != 1) return main.invalidAction(player, main.d().NEGATIVE_ARGUMENTS);
    String name = strings[0];

    for (Player nick : main.getServer().getOnlinePlayers()) {
      User user = data.getUser(nick.getUniqueId());

      if (user == null) continue;
      if (user.getNickname() == null) continue;

      if (user.getNickname().equalsIgnoreCase(name)) {
        player.sendMessage(main.d().NEUTRAL_WHOIS.replace("{nickname}", name).replace("{player}", nick.getName()));
        return true;
      }
    }

    return false;
  }

  @Override
  public List<String> onTabComplete(CommandSender commandSender, Command command, String alias, String[] args) {
    if (!(commandSender instanceof Player)) return null;

    List<String> nicks = new ArrayList<>();

    if (args.length == 0) {
      for (Player player : main.getServer().getOnlinePlayers()) {
        User user = data.getUser(player.getUniqueId());

        if (user == null) continue;
        if (user.getNickname() == null) continue;

        nicks.add(user.getNickname());
      }
    }
    else {
      for (Player player : main.getServer().getOnlinePlayers()) {
        User user = data.getUser(player.getUniqueId());

        if (user == null) continue;
        if (user.getNickname() == null) continue;

        String nick = user.getNickname();

        if (nick.toLowerCase().startsWith(args[0].toLowerCase()))
          nicks.add(nick);
      }
    }

    return nicks;
  }
}
