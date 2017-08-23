package bits.bits.team.command;

import bits.bits.team.Main;
import bits.bits.team.Warp;
import bits.bits.team.data.DataWarp;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.advancement.Advancement;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class CommandWarp implements CommandExecutor, TabCompleter {
  private Main main;
  private DataWarp data;

  public CommandWarp(Main main, DataWarp data) {
    this.main = main;
    this.data = data;
  }

  @Override
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
    if (!(commandSender instanceof Player)) return false;
    Player player = (Player) commandSender;

    if (strings.length != 1) return main.invalidAction(player, main.d().NEGATIVE_ARGUMENTS);
    String name = strings[0];

    Warp warp = data.getWarp(name);
    if (warp == null) return main.invalidAction(player, main.d().NEGATIVE_WARP_NOT_FOUND);

    Advancement the_end = main.getServer().getAdvancement(NamespacedKey.minecraft("end/root"));
    Advancement nether = main.getServer().getAdvancement(NamespacedKey.minecraft("nether/root"));

    if (warp.getLocation().getWorld().getEnvironment() == World.Environment.THE_END
      && !player.getAdvancementProgress(the_end).isDone())
      return main.invalidAction(player, main.d().NEGATIVE_THE_END);

    if (warp.getLocation().getWorld().getEnvironment() == World.Environment.NETHER
      && !player.getAdvancementProgress(nether).isDone())
      return main.invalidAction(player, main.d().NEGATIVE_NETHER);

    main.teleport(player, warp.getLocation());
    return true;
  }

  @Override
  public List<String> onTabComplete(CommandSender commandSender, Command command, String alias, String[] args) {
    if (!(commandSender instanceof Player)) return null;

    List<String> warps = new ArrayList<>();

    if (args.length == 0) {
      for (Warp warp : data.getWarps()) {
        warps.add(warp.getName());
      }
    } else {
      for (Warp warp : data.getWarps()) {
        if (warp.getName().toLowerCase().startsWith(args[0].toLowerCase())) {
          warps.add(warp.getName());
        }
      }
    }

    return warps;
  }
}
