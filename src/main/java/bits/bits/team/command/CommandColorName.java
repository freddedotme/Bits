package bits.bits.team.command;

import bits.bits.team.Main;
import bits.bits.team.User;
import bits.bits.team.Warp;
import bits.bits.team.data.DataUser;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandColorName implements CommandExecutor, TabCompleter {
  private Main main;
  private DataUser data;
  private HashMap<String, String> colors;
  private Scoreboard scoreboard;

  public CommandColorName(Main main, DataUser data) {
    this.main = main;
    this.data = data;

    colors = new HashMap<>();
    colors.put("black", "&0");
    colors.put("dark_blue", "&1");
    colors.put("dark_green", "&2");
    colors.put("dark_aqua", "&3");
    colors.put("dark_red", "&4");
    colors.put("dark_purple", "&5");
    colors.put("gold", "&6");
    colors.put("gray", "&7");
    colors.put("dark_gray", "&8");
    colors.put("blue", "&9");
    colors.put("green", "&a");
    colors.put("aqua", "&b");
    colors.put("red", "&c");
    colors.put("light_purple", "&d");
    colors.put("yellow", "&e");
    colors.put("white", "&f");

    scoreboard = main.getServer().getScoreboardManager().getMainScoreboard();

    for (Map.Entry<String, String> color : colors.entrySet()) {
      if (scoreboard.getTeam(color.getKey()) != null) continue;
      Team team = scoreboard.registerNewTeam(color.getKey());
      team.setPrefix(ChatColor.translateAlternateColorCodes('&', color.getValue()));
    }
  }

  @Override
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
    if (!(commandSender instanceof Player)) return false;
    Player player = (Player) commandSender;

    User user = data.getUser(player.getUniqueId());
    if (user == null) return main.invalidAction(player, main.d().NEGATIVE_ERROR);

    if (!user.isDonor() && !user.isGuard()) return main.invalidAction(player, main.d().NEGATIVE_PERMISSION);

    if (strings.length != 1) return main.invalidAction(player, main.d().NEGATIVE_ARGUMENTS);
    String value = strings[0];

    if (value.equalsIgnoreCase("list")) {
      player.sendMessage(main.d().HEADER_COLORS);
      for (String color : colors.keySet()) {
        player.sendMessage(color);
      }
      return true;
    }

    boolean invalidColor = true;

    for (Map.Entry<String, String> color : colors.entrySet()) {
      if (color.getKey().equalsIgnoreCase(value)) {
        invalidColor = false;

        player.sendMessage(main.d().POSITIVE_COLOR_CHANGE.replace("{color}", color.getKey()));
        user.setPrefix(color.getValue());

        scoreboard.getTeam(color.getKey()).addEntry(player.getName());
      }
    }

    return !invalidColor || main.invalidAction(player, main.d().NEGATIVE_INVALID_COLOR);
  }

  @Override
  public List<String> onTabComplete(CommandSender commandSender, Command command, String alias, String[] args) {
    if (!(commandSender instanceof Player)) return null;

    User user = data.getUser(((Player) commandSender).getUniqueId());
    if (user == null) return null;
    if (!user.isDonor() && !user.isGuard()) return null;

    List<String> colors = new ArrayList<>();

    if (args.length == 0) {
      colors.addAll(this.colors.keySet());
    } else {
      for (String color : this.colors.keySet()) {
        if (color.startsWith(args[0])) {
          colors.add(color);
        }
      }
    }

    return colors;
  }
}
