package bits.bits.team.data;

public class Data {
  public static String ROOT_PATH = "plugins/Bits";

  public static String MSG_NO_BED = "You don't have a bed.";
  public static String MSG_TELEPORTING = "Teleporting...";
  public static String MSG_TELEPORTED = "Teleported!";
  public static String MSG_JOIN = "+ {player}";
  public static String MSG_JOIN_NEW = "+ [NEW] {player}";
  public static String MSG_QUIT = "- {player}";
  public static String MSG_ARGUMENTS = "Invalid amount of arguments.";
  public static String MSG_WARP_NOT_FOUND = "Warp doesn't exist.";
  public static String MSG_WARP_FOUND = "Warp already exist.";
  public static String MSG_PERMISSION = "Not enough permissions.";
  public static String MSG_PLAYER_NOT_FOUND = "Player not found.";
  public static String MSG_ALREADY_GUARD = "Already a guard.";
  public static String MSG_ALREADY_DONOR = "Already a donor.";
  public static String MSG_NOT_A_GUARD = "Not a guard.";
  public static String MSG_NOT_A_DONOR = "Not a donor.";
  public static String MSG_VOTING = "[Server] {player} voted at {service}. Do /vote to vote.";
  public static String MSG_SLEEPING = "[Server] {sleeping}/{online} player(s) sleeping.";
  public static String MSG_RANDOMSPAWN = "Hold on. We're finding a new random spawn location for you.";
  public static String MSG_RANDOMSPAWN_LOOKING = "({attempts}/{maxAttempts}) Randomizing a new location.";
  public static String MSG_SHOP_SETUP = "Shop sign placed. Right-click with the correct item and amount to set the " +
    "selling object. Left-click with the correct item and amount to set the price.";
  public static String MSG_SHOP_OWNED_BY = "This shop is owned by {player}";
  public static String BOOK_TITLE = "Bits 101";
  public static String BOOK_AUTHOR = "FredTheLion";
  public static String MSG_INVALID_COLOR = "Color not found.";
  public static String MSG_VOTE = "Vote URL: www.bits.team/vote";
  public static String MSG_DONATE = "Donate URL: www.bits.team/donate";
  public static String MSG_ERROR = "Error occurred, contact owner.";
  public static String PERM_COLOREDNAME = "bits.formatname";
  public static String PERM_BYPASSCOOLDOWN = "bits.bypasscooldown";
  public static int TELEPORT_WARMUP = 100;
  public static int TELEPORT_WARMUP_DONOR = 50;
  public static int EFFECT_DURATION = 20 * 180;
  public static int WB_MARGIN = 250;
  public static int RANDOMSPAWN_ATTEMPTS = 20;
  private static String HEADER_COLOR = "&6";
  public static String HEADER_DONORS = HEADER_COLOR + "Donors:";
  public static String HEADER_GUARDS = HEADER_COLOR + "Guards:";
}
