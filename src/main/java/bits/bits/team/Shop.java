package bits.bits.team;

import org.bukkit.block.Sign;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class Shop {
  private UUID owner;
  private Sign sign;
  private ItemStack product, price;
  private int stock, income;

  public Shop(UUID owner, Sign sign, ItemStack product, ItemStack price, int stock, int income) {
    this.owner = owner;
    this.sign = sign;
    this.product = product;
    this.price = price;
    this.stock = stock;
    this.income = income;
  }

  public UUID getOwner() {
    return owner;
  }

  public void setOwner(UUID owner) {
    this.owner = owner;
  }

  public Sign getSign() {
    return sign;
  }

  public void setSign(Sign sign) {
    this.sign = sign;
  }

  public ItemStack getProduct() {
    return product;
  }

  public void setProduct(ItemStack product) {
    this.product = product;
    updateSign();
  }

  public ItemStack getPrice() {
    return price;
  }

  public void setPrice(ItemStack price) {
    this.price = price;
    updateSign();
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
    updateSign();
  }

  public int getIncome() {
    return income;
  }

  public void setIncome(int income) {
    this.income = income;
  }

  private void updateSign() {
    sign.setLine(0, "[Shop]");
    if (product != null) sign.setLine(1, product.getTypeId() + ":" + product.getAmount());
    if (price != null) sign.setLine(2, price.getTypeId() + ":" + price.getAmount());
    sign.setLine(3, String.valueOf(stock));
    sign.update(true);
  }
}
