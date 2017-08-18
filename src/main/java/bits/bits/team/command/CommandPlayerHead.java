package bits.bits.team.command;

import bits.bits.team.Main;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * Bits
 * Author: freddedotme
 * Created: 2017-08-19
 */
public class CommandPlayerHead implements CommandExecutor {
  private Main main;

  public CommandPlayerHead(Main main) {
    this.main = main;
  }

  @Override
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
    if (!(commandSender instanceof Player)) return false;
    Player player = (Player) commandSender;

    if (strings.length != 1) return main.invalidAction(player, main.d().NEGATIVE_ARGUMENTS);
    String name = strings[0];

    Inventory inventory = player.getInventory();
    if (!inventory.contains(Material.DIAMOND)) return main.invalidAction(player, main.d().NEGATIVE_PLAYERHEAD);

    main.getServer().dispatchCommand(main.getServer().getConsoleSender(), "give " + player.getName() + " " +
      "minecraft:skull 1 3 {SkullOwner: " + name + "}");

    inventory.removeItem(new ItemStack(Material.DIAMOND, 1));

    return true;
  }
}
