package bits.bits.team.event;

import bits.bits.team.Main;
import bits.bits.team.data.Data;
import bits.bits.team.data.DataShop;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
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
  private void onSignChangeEvent(SignChangeEvent e) {
    if (!e.getLine(0).equals("[Shop]")
      && !e.getLine(1).isEmpty()
      && !e.getLine(2).isEmpty()
      && !e.getLine(3).isEmpty())
      return;

    Player player = e.getPlayer();
    player.sendMessage(Data.MSG_SHOP_SETUP);
  }

  @EventHandler
  private void onPlayerInteractEntityEvent(PlayerInteractEvent e) {
    Block block = e.getClickedBlock();
    if (!(block instanceof Sign)) return;

    Action action = e.getAction();
    Player player = e.getPlayer();

    boolean isOwner = data.isOwner(player.getUniqueId());

    if (action.equals(Action.RIGHT_CLICK_BLOCK) && !isOwner)
      rightClickAsBuyer(player, (Sign) block.getState(), e.getItem());
    else if (action.equals(Action.LEFT_CLICK_BLOCK) && !isOwner)
      leftClickAsBuyer(player, (Sign) block.getState(), e.getItem());
    else if (action.equals(Action.RIGHT_CLICK_BLOCK) && isOwner)
      rightClickAsOwner(player, (Sign) block.getState(), e.getItem());
    else if (action.equals(Action.LEFT_CLICK_BLOCK) && isOwner)
      leftClickAsOwner(player, (Sign) block.getState(), e.getItem());
  }

  protected void leftClickAsBuyer(Player player, Sign sign, ItemStack item) {
  }

  protected void leftClickAsOwner(Player player, Sign sign, ItemStack item) {
  }

  protected void rightClickAsOwner(Player player, Sign sign, ItemStack item) {
  }

  protected void rightClickAsBuyer(Player player, Sign sign, ItemStack item) {
  }
}
