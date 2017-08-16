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
import org.bukkit.entity.Player;

public class CommandWarp implements CommandExecutor {
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
}
