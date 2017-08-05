package bits.bits.team.event;

import bits.bits.team.Main;
import bits.bits.team.data.DataShop;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class EventShopSetup extends EventShop {

  public EventShopSetup(Main main, DataShop data) {
    super(main, data);
  }

  @Override
  protected void rightClickAsOwner(Player player, Sign sign, ItemStack item) {
    super.rightClickAsOwner(player, sign, item);

    if (item.getType().equals(Material.AIR)) return;
  }
}
