package bits.bits.team;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.ArrayList;
import java.util.List;

class CommandInfo implements CommandExecutor {
  @Override
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
    if (!(commandSender instanceof Player)) return false;
    Player player = (Player) commandSender;

    ItemStack book = new ItemStack(Material.WRITTEN_BOOK, 1);

    BookMeta bookMeta = (BookMeta) book.getItemMeta();
    bookMeta.setTitle(Data.BOOK_TITLE);
    bookMeta.setAuthor(Data.BOOK_AUTHOR);

    List<String> pages = new ArrayList<>();

    pages.add("Introduction\n\nWelcome to Bits! Bits is a Minecraft community which focuses mainly on survival. The " +
      "server started on 2017-07-12.");
    pages.add("Plugins\n\nWe use CoreProtect (rollback), GriefPrevention (claiming), a custom Discord integration " +
      "plugin (made by AlbinTheLion) and a custom plugin Bits which adds a few features to the server (made by me).");
    pages.add("Rules\n\nYou find our rules at: www.bits.team\n\nDiscord\n\nWe have a discord server. Write /discord " +
      "to get an invite link.");

    bookMeta.setPages(pages);
    book.setItemMeta(bookMeta);

    player.getInventory().addItem(book);
    return true;
  }
}
