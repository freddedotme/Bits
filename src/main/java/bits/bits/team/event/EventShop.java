package bits.bits.team.event;

import bits.bits.team.Main;
import bits.bits.team.Shop;
import bits.bits.team.data.DataShop;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

abstract class EventShop implements Listener {
  protected Main main;
  protected DataShop data;

  EventShop(Main main, DataShop data) {
    this.main = main;
    this.data = data;
  }

  @EventHandler
  private void onPlayerInteractEntityEvent(PlayerInteractEvent e) {
    Block block = e.getClickedBlock();

    if (!(block instanceof Sign)) return;
    Sign sign = (Sign) block.getState();

    Shop shop = data.getShopBySign(sign);
    if (shop == null) return;

    Action action = e.getAction();
    Player player = e.getPlayer();

    boolean isComplete = data.isComplete(shop);
    boolean isOwner = data.isOwner(player.getUniqueId());

    if (action.equals(Action.RIGHT_CLICK_BLOCK) && !isOwner && isComplete)
      rightClickAsBuyer(player, shop, sign, e.getItem());
    else if (action.equals(Action.LEFT_CLICK_BLOCK) && !isOwner && isComplete)
      leftClickAsBuyer(player, shop, sign, e.getItem());
    else if (action.equals(Action.RIGHT_CLICK_BLOCK) && isOwner && isComplete)
      rightClickAsOwnerShopComplete(player, shop, sign, e.getItem());
    else if (action.equals(Action.LEFT_CLICK_BLOCK) && isOwner && isComplete)
      leftClickAsOwnerShopComplete(player, shop, sign, e.getItem());
    else if (action.equals(Action.RIGHT_CLICK_BLOCK) && isOwner && !isComplete)
      rightClickAsOwnerShopIncomplete(player, shop, sign, e.getItem());
    else if (action.equals(Action.LEFT_CLICK_BLOCK) && isOwner && !isComplete)
      leftClickAsOwnerShopIncomplete(player, shop, sign, e.getItem());
  }

  protected void leftClickAsBuyer(Player player, Shop shop, Sign sign, ItemStack item) {
  }

  protected void rightClickAsBuyer(Player player, Shop shop, Sign sign, ItemStack item) {
  }

  protected void leftClickAsOwnerShopComplete(Player player, Shop shop, Sign sign, ItemStack item) {
  }

  protected void rightClickAsOwnerShopComplete(Player player, Shop shop, Sign sign, ItemStack item) {
  }

  protected void leftClickAsOwnerShopIncomplete(Player player, Shop shop, Sign sign, ItemStack item) {
  }

  protected void rightClickAsOwnerShopIncomplete(Player player, Shop shop, Sign sign, ItemStack item) {
  }
}
