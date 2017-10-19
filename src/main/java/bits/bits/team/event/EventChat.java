package bits.bits.team.event;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class EventChat implements Listener {

    private static final String CHAT_JSON = "[\"\",{\"text\":\"%s\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":{\"text\":\"\",\"extra\":[{\"text\":\"%s\"}]}}},{\"text\":\"%s\"}]";

    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGHEST)
    public void onAsyncPlayerChat(AsyncPlayerChatEvent event) {
        event.setCancelled(true);

        String prefix = String.format("<%s> ", event.getPlayer().getDisplayName());
        String json = String.format(CHAT_JSON, prefix, String.format("Real name: %s", event.getPlayer().getName()), event.getMessage());
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), String.format("tellraw @a %s", json));
    }
}
