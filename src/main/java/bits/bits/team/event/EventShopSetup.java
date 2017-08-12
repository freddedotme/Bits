package bits.bits.team.event;

import bits.bits.team.Main;
import bits.bits.team.Shop;
import bits.bits.team.data.Data;
import bits.bits.team.data.DataShop;
import org.bukkit.ChatColor;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class EventShopSetup extends EventShop {

  public EventShopSetup(Main main, DataShop data) {
    super(main, data);
  }

  @Override
  @EventHandler
  public void onPlayerInteractEntityEvent(PlayerInteractEvent e) {
    super.onPlayerInteractEntityEvent(e);
  }

  @EventHandler
  private void onSignChangeEvent(SignChangeEvent e) {
    if (!e.getLine(0).equals("[Shop]")) return;

    e.setLine(0, ChatColor.translateAlternateColorCodes('&', "[&aShop&r]"));

    Player player = e.getPlayer();
    player.sendMessage(Data.MSG_SHOP_SETUP);

    Shop shop = new Shop(player.getUniqueId(), (Sign) e.getBlock().getState(), null, null, 0, 0, true);
    data.addShop(shop);
  }

  @Override
  protected void rightClickAsOwnerShopIncomplete(Player player, Shop shop, Sign sign, ItemStack item) {
    main.getLogger().info("rightClickAsOwnerShopIncomplete");
    super.rightClickAsOwnerShopIncomplete(player, shop, sign, item);

    if (item == null || shop.getProduct() != null) return;

    shop.setProduct(item);
    shop.setStock(item.getAmount());

    player.getInventory().removeItem(item);
  }

  @Override
  protected void leftClickAsOwnerShopIncomplete(Player player, Shop shop, Sign sign, ItemStack item) {
    main.getLogger().info("leftClickAsOwnerShopIncomplete");
    super.leftClickAsOwnerShopIncomplete(player, shop, sign, item);

    if (item == null || shop.getPrice() != null) return;

    shop.setPrice(item);
    shop.setIncome(item.getAmount());
  }
}
