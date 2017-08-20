package bits.bits.team.data;

import org.bukkit.ChatColor;

public class Data {
  public String ROOT_PATH = "plugins/Bits";

  public String MSG_JOIN;
  public String MSG_JOIN_NEW;
  public String MSG_QUIT;
  public String MSG_VOTING;
  public String MSG_SLEEPING;

  public String BOOK_TITLE;
  public String BOOK_AUTHOR;

  public String HEADER_DONORS;
  public String HEADER_GUARDS;
  public String HEADER_COLORS;
  public String HEADER_WARPS;

  public String NEUTRAL_TELEPORTING;
  public String NEUTRAL_RANDOMSPAWN;
  public String NEUTRAL_RANDOMSPAWN_LOOKING;
  public String NEUTRAL_JOINED;
  public String NEUTRAL_SEEN;
  public String NEUTRAL_BEAMEDTO;

  public String NEGATIVE_NO_BED;
  public String NEGATIVE_ARGUMENTS;
  public String NEGATIVE_WARP_NOT_FOUND;
  public String NEGATIVE_PERMISSION;
  public String NEGATIVE_PLAYER_NOT_FOUND;
  public String NEGATIVE_ALREADY_GUARD;
  public String NEGATIVE_ALREADY_DONOR;
  public String NEGATIVE_NOT_GUARD;
  public String NEGATIVE_NOT_DONOR;
  public String NEGATIVE_INVALID_COLOR;
  public String NEGATIVE_ERROR;
  public String NEGATIVE_THE_END;
  public String NEGATIVE_NETHER;
  public String NEGATIVE_RTP;
  public String NEGATIVE_PLAYERHEAD;
  public String NEGATIVE_BEAM;
  public String NEGATIVE_BEAMEDFROM;
  public String NEGATIVE_BEAMEDTO;

  public String POSITIVE_TELEPORTED;
  public String POSITIVE_VOTE;
  public String POSITIVE_DONATE;
  public String POSITIVE_COLOR_CHANGE;
  public String POSITIVE_BEAM_SENT;
  public String POSITIVE_BEAM_CANCELLED;
  public String POSITIVE_BEAM_ACCEPTED;

  public String PERM_COLOREDNAME;
  public String PERM_BYPASSCOOLDOWN;

  public int TELEPORT_WARMUP = 100;
  public int TELEPORT_WARMUP_DONOR = 50;
  public int EFFECT_DURATION = 20 * 180;
  public int WB_MARGIN = 250;
  public int RANDOMSPAWN_ATTEMPTS = 20;

  public Data() {
    MSG_JOIN = "+ {player}";
    MSG_JOIN_NEW = "+ [NEW] {player}";
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
    NEGATIVE_RTP = cc(NEGATIVE + "You need to wait 24 hours between each random teleport.");
    NEGATIVE_PLAYERHEAD = cc(NEGATIVE + "It costs 1 diamond to get a playerhead.");
    NEGATIVE_BEAM = cc(NEGATIVE + "You need to wait 5 minutes between each beam.");
    NEGATIVE_BEAMEDFROM = cc(NEGATIVE + "Nobody has requested to beam to you.");
    NEGATIVE_BEAMEDTO = cc(NEGATIVE + "You haven no pending beam requests.");

    String POSITIVE = "&a";
    POSITIVE_TELEPORTED = cc(POSITIVE + "Teleported!");
    POSITIVE_VOTE = cc(POSITIVE + "Vote URL: www.bits.team/vote");
    POSITIVE_DONATE = cc(POSITIVE + "Donate URL: www.bits.team/donate");
    POSITIVE_COLOR_CHANGE = cc(POSITIVE + "You colored your name {color}.");
    POSITIVE_BEAM_SENT = cc(POSITIVE + "Beam request sent.");
    POSITIVE_BEAM_CANCELLED = cc(POSITIVE + "Beam request cancelled.");
    POSITIVE_BEAM_ACCEPTED = cc(POSITIVE + "Beam request accepted.");

    PERM_COLOREDNAME = "bits.formatname";
    PERM_BYPASSCOOLDOWN = "bits.bypasscooldown";
  }

  private String cc(String message) {
    return ChatColor.translateAlternateColorCodes('&', message);
  }
}
