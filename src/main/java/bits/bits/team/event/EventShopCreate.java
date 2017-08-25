package bits.bits.team.event;

import bits.bits.team.Main;
import bits.bits.team.Shop;
import bits.bits.team.User;
import bits.bits.team.data.DataUser;
import org.bukkit.block.Block;
import org.bukkit.block.DoubleChest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.List;

/**
 * The type Event shop create.
 */
public class EventShopCreate implements Listener {
  private Main main;
  private DataUser data;

  /**
   * Instantiates a new Event shop create.
   *
   * @param main the main
   * @param data the data
   */
  public EventShopCreate(Main main, DataUser data) {
    this.main = main;
    this.data = data;
  }

  /**
   * On player interact boolean.
   *
   * @param e the e
   * @return the boolean
   */
  @EventHandler
  public boolean onPlayerInteract(PlayerInteractEvent e) {
    if (!e.getAction().equals(Action.LEFT_CLICK_BLOCK)) return false;

    Player player = e.getPlayer();
    Block block = e.getClickedBlock();

    User user = data.getUser(player.getUniqueId());
    if (user == null) return false;

    if (!user.isShopMode()) return false;

    if (!(block instanceof DoubleChest)) return false;
    DoubleChest chest = (DoubleChest) block;

    if (data.getShop(chest.getLocation()) != null) return main.invalidAction(player, main.d().NEGATIVE_SHOP_EXISTS);

    if (chest.getInventory().getContents().length != 2) return main.invalidAction(player, main.d().NEGATIVE_SHOP_ITEMS);

    List<Shop> shops = user.getShops();
    shops.add(new Shop(player.getUniqueId(), chest.getLocation()));

    user.setShops(shops);
    player.sendMessage(main.d().POSITIVE_SHOP_CREATED);

    player.performCommand("shop");
    return true;
  }
}
