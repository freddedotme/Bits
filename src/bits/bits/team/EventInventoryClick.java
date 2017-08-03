package bits.bits.team;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.MerchantInventory;
import org.bukkit.inventory.meta.BookMeta;

class EventInventoryClick implements Listener {
  @EventHandler
  void onInventoryClick(InventoryClickEvent e) {
    if (!(e.getInventory() instanceof MerchantInventory)) return;
    if (!(e.getCurrentItem().getType() == Material.WRITTEN_BOOK)) return;

    BookMeta meta = (BookMeta) e.getCurrentItem().getItemMeta();
    if (meta.getTitle() == null) return;

    e.setCancelled(meta.getTitle().equals(Data.BOOK_TITLE));
  }
}
