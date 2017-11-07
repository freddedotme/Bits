package bits.bits.team.command;

import bits.bits.team.Main;
import bits.bits.team.User;
import bits.bits.team.data.DataUser;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Date;

/**
 * The type Command random teleport.
 */
public class CommandRandomTeleport implements CommandExecutor {
  private Main main;
  private DataUser data;

  /**
   * Instantiates a new Command random teleport.
   *
   * @param main the main
   * @param data the data
   */
  public CommandRandomTeleport(Main main, DataUser data) {
    this.main = main;
    this.data = data;
  }

  @Override
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
    if (!(commandSender instanceof Player)) return false;
    Player player = (Player) commandSender;

    User user = data.getUser(player.getUniqueId());
    if (user == null) return main.invalidAction(player, main.d().NEGATIVE_ERROR);

    Date now = new Date();
    Date rtp = user.getRandomTeleport();

    if (rtp != null && now.getTime() - rtp.getTime() < 43200000)
      return main.invalidAction(player, main.d().NEGATIVE_RTP);

    double size = main.getServer().getWorld("bits").getWorldBorder().getSize() - 1000.0;

    main.getServer().dispatchCommand(main.getServer().getConsoleSender(), "spreadplayers 0 0 1 " + size + " false " +
      player.getName());
    user.setRandomTeleport(now);

    return true;
  }
}
