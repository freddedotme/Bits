package bits.bits.team.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Bits
 * Author: freddedotme
 * Created: 2017-08-11
 */
public class CommandHat implements CommandExecutor {
  @Override
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
    if (!(commandSender instanceof Player)) return false;
    Player player = (Player) commandSender;

    if (player.getInventory().getItemInMainHand() == null) return false;
    ItemStack hat = player.getInventory().getItemInMainHand();

    if (player.getInventory().getHelmet() != null) {
      ItemStack helmet = player.getInventory().getHelmet();

      player.getInventory().setHelmet(hat);
      player.getInventory().setItemInMainHand(helmet);
    }
    else {
      player.getInventory().setHelmet(hat);
      player.getInventory().setItemInMainHand(null);
    }

    return true;
  }
}
