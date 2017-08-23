package bits.bits.team.command;

import bits.bits.team.Main;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandBed implements CommandExecutor {
  private Main main;

  public CommandBed(Main main) {
    this.main = main;
  }

  @Override
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
    if (!(commandSender instanceof Player)) return false;

    Player player = (Player) commandSender;
    Location bed = player.getBedSpawnLocation();

    if (bed == null) return main.invalidAction(player, main.d().NEGATIVE_NO_BED);

    main.teleport(player, bed);
    return true;
  }
}
