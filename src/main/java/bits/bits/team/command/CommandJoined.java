package bits.bits.team.command;

import bits.bits.team.Main;
import bits.bits.team.data.Data;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Calendar;
import java.util.Date;

/**
 * Bits
 * Author: freddedotme
 * Created: 2017-08-13
 */
public class CommandJoined implements CommandExecutor {
  private Main main;

  public CommandJoined(Main main) {
    this.main = main;
  }

  @Override
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
    if (!(commandSender instanceof Player)) return false;
    Player player = (Player) commandSender;

    if (strings.length != 1) return main.invalidAction(player, Data.MSG_ARGUMENTS);
    String name = strings[0];

    OfflinePlayer temporary = null;
    for (OfflinePlayer op : main.getServer().getOfflinePlayers()) {
      if (op.getName().equalsIgnoreCase(name)) temporary = op;
    }

    if (temporary == null) return main.invalidAction(player, Data.MSG_PLAYER_NOT_FOUND);

    Calendar lastSeen = Calendar.getInstance();
    lastSeen.setTime(new Date(temporary.getFirstPlayed()));

    int YYYY = lastSeen.get(Calendar.YEAR);
    int MM = lastSeen.get(Calendar.MONTH) + 1;
    int dd = lastSeen.get(Calendar.DAY_OF_MONTH);
    String date = YYYY + "/" + MM + "/" + dd;

    int HH = lastSeen.get(Calendar.HOUR_OF_DAY);
    int mm = lastSeen.get(Calendar.MINUTE);
    int ss = lastSeen.get(Calendar.SECOND);
    String time = String.format("%02d:%02d:%02d", HH, mm, ss);

    String message = temporary.getName() + " first joined our server at " + time + " on " + date + ".";
    player.sendMessage(message);

    return true;
  }
}
