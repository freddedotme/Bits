package bits.bits.team.event;

import bits.bits.team.Main;
import bits.bits.team.Shop;
import bits.bits.team.data.Data;
import bits.bits.team.data.DataShop;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class EventShopBreak extends EventShop {

  public EventShopBreak(Main main, DataShop data) {
    super(main, data);
  }

  @EventHandler
  public void onBlockBreak(BlockBreakEvent e) {
    if (!(e.getBlock() instanceof Sign)) return;
    Sign sign = (Sign) e.getBlock().getState();

    Shop shop = data.getShopBySign(sign);
    if (shop == null) return;

    Player player = e.getPlayer();

    if (data.isOwner(player.getUniqueId())) {
      World world = player.getWorld();
      Location location = player.getLocation();

      ItemStack product = shop.getProduct();
      ItemStack price = shop.getPrice();

      for (int i = 0; i < shop.getStock() % product.getAmount(); i++)
        world.dropItem(location, product);

      for (int i = 0; i < shop.getIncome() % price.getAmount(); i++)
        world.dropItem(location, price);

      data.deleteShop(shop);
    }
    else {
      e.setCancelled(true);

      OfflinePlayer offlinePlayer = main.getServer().getOfflinePlayer(shop.getOwner());
      if (offlinePlayer != null)
        player.sendMessage(Data.MSG_SHOP_OWNED_BY.replace("{player}", offlinePlayer.getName()));
    }
  }
}
