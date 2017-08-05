package bits.bits.team.event;

import bits.bits.team.Main;
import bits.bits.team.Shop;
import bits.bits.team.data.DataShop;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class EventShopStockWithdraw extends EventShop {

  public EventShopStockWithdraw(Main main, DataShop data) {
    super(main, data);
  }

  @Override
  protected void rightClickAsOwnerShopComplete(Player player, Shop shop, Sign sign, ItemStack item) {
    super.rightClickAsOwnerShopComplete(player, shop, sign, item);

    ItemStack product = shop.getProduct();
    if (!shop.getProduct().isSimilar(item) && product.getAmount() > item.getAmount()) return;

    shop.setStock(shop.getStock() + product.getAmount());
    player.getInventory().removeItem(product);
  }

  @Override
  protected void leftClickAsOwnerShopComplete(Player player, Shop shop, Sign sign, ItemStack item) {
    super.leftClickAsOwnerShopComplete(player, shop, sign, item);

    ItemStack price = shop.getPrice();

    if (shop.getIncome() <= 0 || shop.getIncome() < price.getAmount()) return;

    shop.setIncome(shop.getIncome() - price.getAmount());
    player.getInventory().addItem(price);
  }
}
