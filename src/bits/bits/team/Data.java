package bits.bits.team;

class Data
{
  static String ROOT_PATH = "plugins/Bits";

  static String MSG_NO_BED              = "You don't have a bed.";
  static String MSG_TELEPORTING         = "Teleporting...";
  static String MSG_TELEPORTED          = "Teleported!";
  static String MSG_JOIN                = "+ {player}";
  static String MSG_JOIN_NEW            = "+ [NEW] {player}";
  static String MSG_QUIT                = "- {player}";
  static String MSG_ARGUMENTS           = "Invalid amount of arguments.";
  static String MSG_WARP_NOT_FOUND      = "Warp doesn't exist.";
  static String MSG_WARP_FOUND          = "Warp already exist.";
  static String MSG_PERMISSION          = "Not enough permissions.";
  static String MSG_PLAYER_NOT_FOUND    = "Player not found.";
  static String MSG_ALREADY_GUARD       = "Already a guard.";
  static String MSG_NOT_A_GUARD         = "Not a guard.";
  static String MSG_VOTING              = "[Server] {player} voted for us over at PMC. A random effect has been " +
    "given to" +
    " all " +
    "players. Thank you {player}!";
  static String MSG_SLEEPING            = "[Server] {sleeping}/{online} player(s) sleeping.";
  static String MSG_RANDOMSPAWN         = "Hold on. We're finding a new random spawn location for you.";
  static String MSG_RANDOMSPAWN_LOOKING = "({attempts}/{maxAttempts}) Randomizing a new location.";

  static int TELEPORT_WARMUP      = 100;
  static int EFFECT_DURATION      = 20 * 180;
  static int WB_MARGIN            = 250;
  static int RANDOMSPAWN_ATTEMPTS = 20;
}
