package bits.bits.team.event;

import bits.bits.team.Main;
import bits.bits.team.Shop;
import bits.bits.team.data.DataShop;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class EventShopBuy extends EventShop {

  public EventShopBuy(Main main, DataShop data) {
    super(main, data);
  }

  @EventHandler
  @Override
  public void onPlayerInteractEntityEvent(PlayerInteractEvent e) {
    super.onPlayerInteractEntityEvent(e);
  }

  @Override
  protected void rightClickAsBuyer(Player player, Shop shop, Sign sign, ItemStack item) {
    main.getLogger().info("rightClickAsBuyer");
    super.rightClickAsBuyer(player, shop, sign, item);

    ItemStack price = shop.getPrice();
    if (!player.getInventory().contains(price, price.getAmount())) return;

    player.getInventory().removeItem(price);
    player.getInventory().addItem(shop.getProduct());
  }

  @Override
  protected void leftClickAsBuyer(Player player, Shop shop, Sign sign, ItemStack item) {
    main.getLogger().info("leftClickAsBuyer");
    super.leftClickAsBuyer(player, shop, sign, item);

    ItemStack price = shop.getPrice();
    if (!player.getInventory().contains(price, price.getAmount())) return;

    player.getInventory().removeItem(price);
    player.getInventory().addItem(shop.getProduct());
  }
}
