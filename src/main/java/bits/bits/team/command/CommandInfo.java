package bits.bits.team.command;

import bits.bits.team.Main;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.ArrayList;
import java.util.List;

public class CommandInfo implements CommandExecutor {
  private Main main;

  public CommandInfo(Main main) {
    this.main = main;
  }

  @Override
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
    if (!(commandSender instanceof Player)) return false;
    Player player = (Player) commandSender;

    ItemStack book = new ItemStack(Material.WRITTEN_BOOK, 1);

    BookMeta bookMeta = (BookMeta) book.getItemMeta();
    bookMeta.setTitle(main.d().BOOK_TITLE);
    bookMeta.setAuthor(main.d().BOOK_AUTHOR);

    List<String> pages = new ArrayList<>();

    pages.add("Hello there!\nMy name is Fred ");
    pages.add("Okey, on this server we have some simple commands and here's the list:\n\n/bed\n/warp, " +
      "/warps\n/hat\n/vote\n/discord\n/donate");
    bookMeta.setPages(pages);
    book.setItemMeta(bookMeta);

    player.getInventory().addItem(book);
    return true;
  }
}
