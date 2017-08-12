package bits.bits.team.command;

import bits.bits.team.Main;
import bits.bits.team.data.Data;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class CommandColorName implements CommandExecutor {
  private Main main;
  private HashMap<String, ChatColor> colors;

  public CommandColorName(Main main) {
    this.main = main;

    colors = new HashMap<>();
    colors.put("black", ChatColor.BLACK);
    colors.put("dark_blue", ChatColor.DARK_BLUE);
    colors.put("dark_green", ChatColor.DARK_GREEN);
    colors.put("dark_aqua", ChatColor.DARK_AQUA);
    colors.put("dark_red", ChatColor.DARK_RED);
    colors.put("dark_purple", ChatColor.DARK_PURPLE);
    colors.put("gold", ChatColor.GOLD);
    colors.put("gray", ChatColor.GRAY);
    colors.put("dark_gray", ChatColor.DARK_GRAY);
    colors.put("blue", ChatColor.BLUE);
    colors.put("green", ChatColor.GREEN);
    colors.put("aqua", ChatColor.AQUA);
    colors.put("red", ChatColor.RED);
    colors.put("light_purple", ChatColor.LIGHT_PURPLE);
    colors.put("yellow", ChatColor.YELLOW);
  }

  @Override
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
    if (!(commandSender instanceof Player)) return false;
    Player player = (Player) commandSender;

    if (strings.length != 1) return main.invalidAction(player, Data.MSG_ARGUMENTS);
    String value = strings[0];

    if (!(player.hasPermission(Data.PERM_COLOREDNAME))) return main.invalidAction(player, Data.MSG_PERMISSION);

    if (value.equalsIgnoreCase("list")) {
      player.sendMessage("Available colors:");
      for (String color : colors.keySet()) {
        player.sendMessage(color);
      }
      return true;
    }

    boolean invalidColor = true;

    for (String color : colors.keySet()) {
      if (color.equalsIgnoreCase(value)) {
        invalidColor = false;
        player.setDisplayName(colors.get(color) + player.getName() + ChatColor.RESET);
        player.setPlayerListName(colors.get(color) + player.getName() + ChatColor.RESET);
      }
    }

    return !invalidColor || main.invalidAction(player, Data.MSG_INVALID_COLOR);
  }
}
