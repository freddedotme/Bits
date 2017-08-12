package bits.bits.team.data;

import bits.bits.team.Main;
import bits.bits.team.Shop;
import org.bukkit.block.Sign;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DataShop {
  private Main main;
  private List<Shop> shops;

  public DataShop(Main main) {
    shops = new ArrayList<>();
  }

  public void addShop(Shop shop) {
    shops.add(shop);
  }

  public void deleteShop(Shop shop) {
    shops.remove(shop);
  }

  public Shop getShopBySign(Sign sign) {
    for (Shop shop : shops)
      if (shop.getSign().equals(sign)) return shop;
    return null;
  }

  public boolean isComplete(Shop shop) {
    return shop.getProduct() != null && shop.getPrice() != null;
  }

  public boolean isOwner(UUID uuid) {
    for (Shop shop : shops)
      if (shop.getOwner().equals(uuid)) return true;
    return false;
  }
}
