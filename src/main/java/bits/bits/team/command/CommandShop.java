package bits.bits.team.command;

import bits.bits.team.Main;
import bits.bits.team.User;
import bits.bits.team.data.DataUser;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * The type Command shop.
 */
public class CommandShop implements CommandExecutor {
  private Main main;
  private DataUser data;

  /**
   * Instantiates a new Command shop.
   *
   * @param main the main
   * @param data the data
   */
  public CommandShop(Main main, DataUser data) {
    this.main = main;
    this.data = data;
  }

  @Override
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
    if (!(commandSender instanceof Player)) return false;
    Player player = (Player) commandSender;

    User user = data.getUser(player.getUniqueId());
    if (user == null) return main.invalidAction(player, main.d().NEGATIVE_ERROR);

    user.setShopMode(!user.isShopMode());
    player.sendMessage(!user.isShopMode() ? main.d().NEUTRAL_SHOP_ENABLED : main.d().NEUTRAL_SHOP_DISABLED);

    return true;
  }
}
