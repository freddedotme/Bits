package bits.bits.team.command;

import bits.bits.team.Main;
import bits.bits.team.User;
import bits.bits.team.data.DataUser;
import bits.bits.team.runnable.RunnableRandomTeleport;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Date;

/**
 * Bits
 * Author: freddedotme
 * Created: 2017-08-19
 */
public class CommandRandomTeleport implements CommandExecutor {
  private Main main;
  private DataUser data;

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

    if (rtp != null && now.getTime() - rtp.getTime() < 86400000)
      return main.invalidAction(player, main.d().NEGATIVE_RTP);

    new RunnableRandomTeleport(main, player).runTaskTimerAsynchronously(main, 0, 20);
    user.setRandomTeleport(now);

    return true;
  }
}
