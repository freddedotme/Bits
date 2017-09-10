package bits.bits.team.data;

import org.bukkit.ChatColor;

/**
 * The type Data.
 */
public class Data {
  /**
   * The Root path.
   */
  public String ROOT_PATH = "plugins/Bits";

  /**
   * The Msg join.
   */
  public String MSG_JOIN;
  /**
   * The Msg join new.
   */
  public String MSG_JOIN_NEW;
  /**
   * The Msg quit.
   */
  public String MSG_QUIT;
  /**
   * The Msg voting.
   */
  public String MSG_VOTING;
  /**
   * The Msg sleeping.
   */
  public String MSG_SLEEPING;

  /**
   * The Book title.
   */
  public String BOOK_TITLE;
  /**
   * The Book author.
   */
  public String BOOK_AUTHOR;

  /**
   * The Header donors.
   */
  public String HEADER_DONORS;
  /**
   * The Header guards.
   */
  public String HEADER_GUARDS;
  /**
   * The Header colors.
   */
  public String HEADER_COLORS;
  /**
   * The Header warps.
   */
  public String HEADER_WARPS;

  /**
   * The Neutral teleporting.
   */
  public String NEUTRAL_TELEPORTING;
  /**
   * The Neutral randomspawn.
   */
  public String NEUTRAL_RANDOMSPAWN;
  /**
   * The Neutral randomspawn looking.
   */
  public String NEUTRAL_RANDOMSPAWN_LOOKING;
  /**
   * The Neutral joined.
   */
  public String NEUTRAL_JOINED;
  /**
   * The Neutral seen.
   */
  public String NEUTRAL_SEEN;

  /**
   * The Neutral whois.
   */
  public String NEUTRAL_WHOIS;
  /**
   * The Neutral beamedto.
   */
  public String NEUTRAL_BEAMEDTO;

  /**
   * The Neutral shop.
   */
  public String NEUTRAL_SHOP_ENABLED;

  /**
   * The Neutral shop disabled.
   */
  public String NEUTRAL_SHOP_DISABLED;

  /**
   * The Negative no bed.
   */
  public String NEGATIVE_NO_BED;
  /**
   * The Negative arguments.
   */
  public String NEGATIVE_ARGUMENTS;
  /**
   * The Negative warp not found.
   */
  public String NEGATIVE_WARP_NOT_FOUND;
  /**
   * The Negative permission.
   */
  public String NEGATIVE_PERMISSION;
  /**
   * The Negative player not found.
   */
  public String NEGATIVE_PLAYER_NOT_FOUND;
  /**
   * The Negative already guard.
   */
  public String NEGATIVE_ALREADY_GUARD;
  /**
   * The Negative already donor.
   */
  public String NEGATIVE_ALREADY_DONOR;
  /**
   * The Negative not guard.
   */
  public String NEGATIVE_NOT_GUARD;
  /**
   * The Negative not donor.
   */
  public String NEGATIVE_NOT_DONOR;
  /**
   * The Negative invalid color.
   */
  public String NEGATIVE_INVALID_COLOR;
  /**
   * The Negative error.
   */
  public String NEGATIVE_ERROR;
  /**
   * The Negative the end.
   */
  public String NEGATIVE_THE_END;
  /**
   * The Negative nether.
   */
  public String NEGATIVE_NETHER;
  /**
   * The Negative rtp.
   */
  public String NEGATIVE_RTP;
  /**
   * The Negative playerhead.
   */
  public String NEGATIVE_PLAYERHEAD;
  /**
   * The Negative beam.
   */
  public String NEGATIVE_BEAM;
  /**
   * The Negative beamedfrom.
   */
  public String NEGATIVE_BEAMEDFROM;
  /**
   * The Negative beamedto.
   */
  public String NEGATIVE_BEAMEDTO;
  /**
   * The Negative beamworlds.
   */
  public String NEGATIVE_BEAMWORLDS;

  /**
   * The Negative shop exists.
   */
  public String NEGATIVE_SHOP_EXISTS;

  /**
   * The Negative shop product.
   */
  public String NEGATIVE_SHOP_PRODUCT;

  /**
   * The Negative shop price.
   */
  public String NEGATIVE_SHOP_PRICE;

  /**
   * The Negative shop items.
   */
  public String NEGATIVE_SHOP_ITEMS;

  /**
   * The Positive teleported.
   */
  public String POSITIVE_TELEPORTED;
  /**
   * The Positive vote.
   */
  public String POSITIVE_VOTE;
  /**
   * The Positive donate.
   */
  public String POSITIVE_DONATE;

  /**
   * The Positive discord.
   */
  public String POSITIVE_DISCORD;
  /**
   * The Positive color change.
   */
  public String POSITIVE_COLOR_CHANGE;
  /**
   * The Positive beam sent.
   */
  public String POSITIVE_BEAM_SENT;
  /**
   * The Positive beam cancelled.
   */
  public String POSITIVE_BEAM_CANCELLED;
  /**
   * The Positive beam accepted.
   */
  public String POSITIVE_BEAM_ACCEPTED;

  /**
   * The Positive shop created.
   */
  public String POSITIVE_SHOP_CREATED;

  /**
   * The Perm coloredname.
   */
  public String PERM_COLOREDNAME;
  /**
   * The Perm bypasscooldown.
   */
  public String PERM_BYPASSCOOLDOWN;

  /**
   * The Discord to minecraft.
   */
  public String DISCORD_TO_MINECRAFT;

  /**
   * The Teleport warmup.
   */
  public int TELEPORT_WARMUP = 100;
  /**
   * The Teleport warmup donor.
   */
  public int TELEPORT_WARMUP_DONOR = 50;
  /**
   * The Effect duration.
   */
  public int EFFECT_DURATION = 20 * 180;
  /**
   * The Wb margin.
   */
  public int WB_MARGIN = 250;
  /**
   * The Randomspawn attempts.
   */
  public int RANDOMSPAWN_ATTEMPTS = 20;

  /**
   * Instantiates a new Data.
   */
  public Data() {
    MSG_JOIN = "+ [{ISO}] {player}";
    MSG_JOIN_NEW = "+ [NEW] [{ISO}] {player}";
    MSG_QUIT = "- {player}";
    MSG_VOTING = "&a{player} voted at {service}. Do /vote to vote.";
    MSG_SLEEPING = "&e{sleeping}/{online} player(s) sleeping.";

    BOOK_TITLE = "Bits 101";
    BOOK_AUTHOR = "FredTheLion";

    String HEADER = "&6";
    HEADER_DONORS = cc(HEADER + "Donors:");
    HEADER_GUARDS = cc(HEADER + "Guards:");
    HEADER_COLORS = cc(HEADER + "Colors:");
    HEADER_WARPS = cc(HEADER + "Warps:");

    String NEUTRAL = "&e";
    NEUTRAL_TELEPORTING = cc(NEUTRAL + "Teleporting...");
    NEUTRAL_RANDOMSPAWN = cc(NEUTRAL + "Hold on. We're finding a new random spawn location for you.");
    NEUTRAL_RANDOMSPAWN_LOOKING = cc(NEUTRAL + "({attempts}/{maxAttempts}) Randomizing a new location.");
    NEUTRAL_JOINED = cc(NEUTRAL + "{player} first joined our server at {time} on {date}.");
    NEUTRAL_SEEN = cc(NEUTRAL + "{player} was last seen at {time} on {date}.");
    NEUTRAL_BEAMEDTO = cc(NEUTRAL + "{player} has sent a beam request to you. Write /beam accept to accept it.");
    NEUTRAL_SHOP_ENABLED = cc(NEUTRAL + "Shop mode is enabled.");
    NEUTRAL_SHOP_DISABLED = cc(NEUTRAL + "Shop mode is disabled.");
    NEUTRAL_WHOIS = cc(NEUTRAL + "{player} has the following nickname: {nickname}.");

    String NEGATIVE = "&c";
    NEGATIVE_NO_BED = cc(NEGATIVE + "You don't have a bed.");
    NEGATIVE_ARGUMENTS = cc(NEGATIVE + "Invalid amount of arguments.");
    NEGATIVE_WARP_NOT_FOUND = cc(NEGATIVE + "Warp doesn't exist.");
    NEGATIVE_PERMISSION = cc(NEGATIVE + "Not enough permissions.");
    NEGATIVE_PLAYER_NOT_FOUND = cc(NEGATIVE + "Player not found.");
    NEGATIVE_ALREADY_GUARD = cc(NEGATIVE + "Already a guard.");
    NEGATIVE_ALREADY_DONOR = cc(NEGATIVE + "Already a donor.");
    NEGATIVE_NOT_GUARD = cc(NEGATIVE + "Not a guard.");
    NEGATIVE_NOT_DONOR = cc(NEGATIVE + "Not a donor.");
    NEGATIVE_INVALID_COLOR = cc(NEGATIVE + "Color not found.");
    NEGATIVE_THE_END = cc(NEGATIVE + "You need to visit the End before using a warp there.");
    NEGATIVE_NETHER = cc(NEGATIVE + "You need to visit the Nether before using a warp there.");
    NEGATIVE_RTP = cc(NEGATIVE + "You need to wait 12 hours between each random teleport.");
    NEGATIVE_PLAYERHEAD = cc(NEGATIVE + "It costs 1 diamond to get a playerhead.");
    NEGATIVE_BEAM = cc(NEGATIVE + "You need to wait 2 minutes between each beam.");
    NEGATIVE_BEAMEDFROM = cc(NEGATIVE + "Nobody has requested to beam to you.");
    NEGATIVE_BEAMEDTO = cc(NEGATIVE + "You haven no pending beam requests.");
    NEGATIVE_BEAMWORLDS = cc(NEGATIVE + "You need to be in the same world as your target.");
    NEGATIVE_SHOP_EXISTS = cc(NEGATIVE + "This is already a shop.");
    NEGATIVE_SHOP_ITEMS = cc(NEGATIVE + "You need to have both a product and a price item.");
    NEGATIVE_SHOP_PRODUCT = cc(NEGATIVE + "There has to be a product item on position 1 in your shop.");
    NEGATIVE_SHOP_PRICE = cc(NEGATIVE + "There has to be a price item on position 2 in your shop.");

    String POSITIVE = "&a";
    POSITIVE_TELEPORTED = cc(POSITIVE + "Teleported!");
    POSITIVE_VOTE = cc(POSITIVE + "Vote URL: www.bits.team/vote");
    POSITIVE_DONATE = cc(POSITIVE + "Donate URL: www.bits.team/donate");
    POSITIVE_DISCORD = cc(POSITIVE + "Discord URL: https://discord.gg/67vHNa3");
    POSITIVE_COLOR_CHANGE = cc(POSITIVE + "You colored your name {color}.");
    POSITIVE_BEAM_SENT = cc(POSITIVE + "Beam request sent.");
    POSITIVE_BEAM_CANCELLED = cc(POSITIVE + "Beam request cancelled.");
    POSITIVE_BEAM_ACCEPTED = cc(POSITIVE + "Beam request accepted.");
    POSITIVE_SHOP_CREATED = cc(POSITIVE + "Shop created.");

    PERM_COLOREDNAME = "bits.formatname";
    PERM_BYPASSCOOLDOWN = "bits.bypasscooldown";

    DISCORD_TO_MINECRAFT = cc("<&9Discord&r {player}> {message}");
  }

  private String cc(String message) {
    return ChatColor.translateAlternateColorCodes('&', message);
  }
}
