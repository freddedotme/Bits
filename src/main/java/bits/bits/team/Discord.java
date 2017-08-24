package bits.bits.team;

import bits.bits.team.data.DataDiscord;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.DisconnectEvent;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.ReconnectedEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
import java.util.Calendar;

/**
 * The type Discord.
 */
public class Discord extends ListenerAdapter {
  private Main main;
  private DataDiscord data;
  private TextChannel channel;

  /**
   * Instantiates a new Discord.
   *
   * @param main the main
   * @param data the data
   */
  Discord(Main main, DataDiscord data) {
    this.main = main;
    this.data = data;

    try {
      JDA jda = new JDABuilder(AccountType.BOT).setToken(data.getToken()).buildAsync();
      jda.addEventListener(this);
    } catch (LoginException | RateLimitedException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void onReady(ReadyEvent e) {
    channel = e.getJDA().getTextChannelById(data.getId());
    sendToDiscord("BOT", "Connected.");
  }

  /**
   * On reconnected.
   *
   * @param e the e
   */
  public void onReconnected(ReconnectedEvent e) {
    sendToDiscord("BOT", "Reconnected.");
  }

  @Override
  public void onDisconnect(DisconnectEvent e) {
    sendToDiscord("BOT", "Disconnected.");
  }

  @Override
  public void onMessageReceived(MessageReceivedEvent e) {
    if (e.getTextChannel().getIdLong() != data.getId() || e.getAuthor().isBot()) return;

    String name = e.getAuthor().getName();
    String message = e.getMessage().getStrippedContent();

    main.getServer().broadcastMessage(main.d().DISCORD_TO_MINECRAFT.replace("{player}", name).replace("{message}",
      message));
  }

  /**
   * Send to discord.
   *
   * @param name    the name
   * @param message the message
   */
  public void sendToDiscord(String name, String message) {
    for (Member member : channel.getMembers()) {
      String mention = "@" + member.getEffectiveName();

      if (message.contains(mention))
        message = message.replace(mention, member.getAsMention());
    }

    Calendar calendar = Calendar.getInstance();
    int HH = calendar.get(Calendar.HOUR_OF_DAY);
    int mm = calendar.get(Calendar.MINUTE);
    String time = "[" + String.format("%02d:%02d", HH, mm) + "]";

    channel.sendMessage(time + " " + name + ": " + message).queue();
  }
}
