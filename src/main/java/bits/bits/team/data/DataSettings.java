package bits.bits.team.data;

import bits.bits.team.Main;
import bits.bits.team.file.FileManager;

/**
 * The type Data settings.
 */
public class DataSettings {
  private boolean eventBedEnterLeave;
  private boolean eventCancelChunkUnload;
  private boolean eventDisablePvP;
  private boolean eventDiscord;
  private boolean eventFishSlap;
  private boolean eventPlayerJoinQuit;
  private boolean eventSignColorize;
  private boolean eventVote;

  private boolean commandBeam;
  private boolean commandBed;
  private boolean commandBroadcast;
  private boolean commandColorName;
  private boolean commandDelDonor;
  private boolean commandDelGuard;
  private boolean commandDelWarp;
  private boolean commandDiscord;
  private boolean commandDonate;
  private boolean commandDonors;
  private boolean commandGuards;
  private boolean commandHat;
  private boolean commandInfo;
  private boolean commandJoined;
  private boolean commandPlayerHead;
  private boolean commandRandomTeleport;
  private boolean commandSeen;
  private boolean commandSetDonor;
  private boolean commandSetGuard;
  private boolean commandSetWarp;
  private boolean commandVote;
  private boolean commandWarp;
  private boolean commandWarps;

  private boolean runnableWorldEvent;

  /**
   * Instantiates a new Data settings.
   *
   * @param main the main
   */
  public DataSettings(Main main) {
    FileManager file = new FileManager(main, "settings.yml");
    file.write("version", main.getDescription().getVersion());

    if (file.read("eventBedEnterLeave") == null) file.write("eventBedEnterLeave", true);
    if (file.read("eventCancelChunkUnload") == null) file.write("eventCancelChunkUnload", true);
    if (file.read("eventDisablePvP") == null) file.write("eventDisablePvP", true);
    if (file.read("eventDiscord") == null) file.write("eventDiscord", true);
    if (file.read("eventFishSlap") == null) file.write("eventFishSlap", true);
    if (file.read("eventPlayerJoinQuit") == null) file.write("eventPlayerJoinQuit", true);
    if (file.read("eventSignColorize") == null) file.write("eventSignColorize", true);
    if (file.read("eventVote") == null) file.write("eventVote", true);

    if (file.read("commandBeam") == null) file.write("commandBeam", true);
    if (file.read("commandBed") == null) file.write("commandBed", true);
    if (file.read("commandBroadcast") == null) file.write("commandBroadcast", true);
    if (file.read("commandColorName") == null) file.write("commandColorName", true);
    if (file.read("commandDelDonor") == null) file.write("commandDelDonor", true);
    if (file.read("commandDelGuard") == null) file.write("commandDelGuard", true);
    if (file.read("commandDelWarp") == null) file.write("commandDelWarp", true);
    if (file.read("commandDiscord") == null) file.write("commandDiscord", true);
    if (file.read("commandDonate") == null) file.write("commandDonate", true);
    if (file.read("commandDonors") == null) file.write("commandDonors", true);
    if (file.read("commandGuards") == null) file.write("commandGuards", true);
    if (file.read("commandHat") == null) file.write("commandHat", true);
    if (file.read("commandInfo") == null) file.write("commandInfo", true);
    if (file.read("commandJoined") == null) file.write("commandJoined", true);
    if (file.read("commandPlayerHead") == null) file.write("commandPlayerHead", true);
    if (file.read("commandRandomTeleport") == null) file.write("commandRandomTeleport", true);
    if (file.read("commandSeen") == null) file.write("commandSeen", true);
    if (file.read("commandSetDonor") == null) file.write("commandSetDonor", true);
    if (file.read("commandSetGuard") == null) file.write("commandSetGuard", true);
    if (file.read("commandSetWarp") == null) file.write("commandSetWarp", true);
    if (file.read("commandVote") == null) file.write("commandVote", true);
    if (file.read("commandWarp") == null) file.write("commandWarp", true);
    if (file.read("commandWarps") == null) file.write("commandWarps", true);

    if (file.read("runnableWorldEvent") == null) file.write("runnableWorldEvent", true);

    eventBedEnterLeave = (boolean) file.read("eventBedEnterLeave");
    eventCancelChunkUnload = (boolean) file.read("eventCancelChunkUnload");
    eventDisablePvP = (boolean) file.read("eventDisablePvP");
    eventDiscord = (boolean) file.read("eventDiscord");
    eventFishSlap = (boolean) file.read("eventFishSlap");
    eventPlayerJoinQuit = (boolean) file.read("eventPlayerJoinQuit");
    eventSignColorize = (boolean) file.read("eventSignColorize");
    eventVote = (boolean) file.read("eventVote");

    commandBeam = (boolean) file.read("commandBeam");
    commandBed = (boolean) file.read("commandBed");
    commandBroadcast = (boolean) file.read("commandBroadcast");
    commandColorName = (boolean) file.read("commandColorName");
    commandDelDonor = (boolean) file.read("commandDelDonor");
    commandDelGuard = (boolean) file.read("commandDelGuard");
    commandDelWarp = (boolean) file.read("commandDelWarp");
    commandDiscord = (boolean) file.read("commandDiscord");
    commandDonate = (boolean) file.read("commandDonate");
    commandDonors = (boolean) file.read("commandDonors");
    commandGuards = (boolean) file.read("commandGuards");
    commandHat = (boolean) file.read("commandHat");
    commandInfo = (boolean) file.read("commandInfo");
    commandJoined = (boolean) file.read("commandJoined");
    commandPlayerHead = (boolean) file.read("commandPlayerHead");
    commandRandomTeleport = (boolean) file.read("commandRandomTeleport");
    commandSeen = (boolean) file.read("commandSeen");
    commandSetDonor = (boolean) file.read("commandSetDonor");
    commandSetGuard = (boolean) file.read("commandSetGuard");
    commandSetWarp = (boolean) file.read("commandSetWarp");
    commandVote = (boolean) file.read("commandVote");
    commandWarp = (boolean) file.read("commandWarp");
    commandWarps = (boolean) file.read("commandWarps");

    runnableWorldEvent = (boolean) file.read("runnableWorldEvent");
  }

  /**
   * Is event bed enter leave boolean.
   *
   * @return the boolean
   */
  public boolean isEventBedEnterLeave() {
    return eventBedEnterLeave;
  }

  /**
   * Sets event bed enter leave.
   *
   * @param eventBedEnterLeave the event bed enter leave
   */
  public void setEventBedEnterLeave(boolean eventBedEnterLeave) {
    this.eventBedEnterLeave = eventBedEnterLeave;
  }

  /**
   * Is event cancel chunk unload boolean.
   *
   * @return the boolean
   */
  public boolean isEventCancelChunkUnload() {
    return eventCancelChunkUnload;
  }

  /**
   * Sets event cancel chunk unload.
   *
   * @param eventCancelChunkUnload the event cancel chunk unload
   */
  public void setEventCancelChunkUnload(boolean eventCancelChunkUnload) {
    this.eventCancelChunkUnload = eventCancelChunkUnload;
  }

  /**
   * Is event disable pv p boolean.
   *
   * @return the boolean
   */
  public boolean isEventDisablePvP() {
    return eventDisablePvP;
  }

  /**
   * Sets event disable pv p.
   *
   * @param eventDisablePvP the event disable pv p
   */
  public void setEventDisablePvP(boolean eventDisablePvP) {
    this.eventDisablePvP = eventDisablePvP;
  }

  /**
   * Is event discord boolean.
   *
   * @return the boolean
   */
  public boolean isEventDiscord() {
    return eventDiscord;
  }

  /**
   * Sets event discord.
   *
   * @param eventDiscord the event discord
   */
  public void setEventDiscord(boolean eventDiscord) {
    this.eventDiscord = eventDiscord;
  }

  /**
   * Is event fish slap boolean.
   *
   * @return the boolean
   */
  public boolean isEventFishSlap() {
    return eventFishSlap;
  }

  /**
   * Sets event fish slap.
   *
   * @param eventFishSlap the event fish slap
   */
  public void setEventFishSlap(boolean eventFishSlap) {
    this.eventFishSlap = eventFishSlap;
  }

  /**
   * Is event player join quit boolean.
   *
   * @return the boolean
   */
  public boolean isEventPlayerJoinQuit() {
    return eventPlayerJoinQuit;
  }

  /**
   * Sets event player join quit.
   *
   * @param eventPlayerJoinQuit the event player join quit
   */
  public void setEventPlayerJoinQuit(boolean eventPlayerJoinQuit) {
    this.eventPlayerJoinQuit = eventPlayerJoinQuit;
  }

  /**
   * Is event sign colorize boolean.
   *
   * @return the boolean
   */
  public boolean isEventSignColorize() {
    return eventSignColorize;
  }

  /**
   * Sets event sign colorize.
   *
   * @param eventSignColorize the event sign colorize
   */
  public void setEventSignColorize(boolean eventSignColorize) {
    this.eventSignColorize = eventSignColorize;
  }

  /**
   * Is event vote boolean.
   *
   * @return the boolean
   */
  public boolean isEventVote() {
    return eventVote;
  }

  /**
   * Sets event vote.
   *
   * @param eventVote the event vote
   */
  public void setEventVote(boolean eventVote) {
    this.eventVote = eventVote;
  }

  /**
   * Is command beam boolean.
   *
   * @return the boolean
   */
  public boolean isCommandBeam() {
    return commandBeam;
  }

  /**
   * Sets command beam.
   *
   * @param commandBeam the command beam
   */
  public void setCommandBeam(boolean commandBeam) {
    this.commandBeam = commandBeam;
  }

  /**
   * Is command bed boolean.
   *
   * @return the boolean
   */
  public boolean isCommandBed() {
    return commandBed;
  }

  /**
   * Sets command bed.
   *
   * @param commandBed the command bed
   */
  public void setCommandBed(boolean commandBed) {
    this.commandBed = commandBed;
  }

  /**
   * Is command broadcast boolean.
   *
   * @return the boolean
   */
  public boolean isCommandBroadcast() {
    return commandBroadcast;
  }

  /**
   * Sets command broadcast.
   *
   * @param commandBroadcast the command broadcast
   */
  public void setCommandBroadcast(boolean commandBroadcast) {
    this.commandBroadcast = commandBroadcast;
  }

  /**
   * Is command color name boolean.
   *
   * @return the boolean
   */
  public boolean isCommandColorName() {
    return commandColorName;
  }

  /**
   * Sets command color name.
   *
   * @param commandColorName the command color name
   */
  public void setCommandColorName(boolean commandColorName) {
    this.commandColorName = commandColorName;
  }

  /**
   * Is command del donor boolean.
   *
   * @return the boolean
   */
  public boolean isCommandDelDonor() {
    return commandDelDonor;
  }

  /**
   * Sets command del donor.
   *
   * @param commandDelDonor the command del donor
   */
  public void setCommandDelDonor(boolean commandDelDonor) {
    this.commandDelDonor = commandDelDonor;
  }

  /**
   * Is command del guard boolean.
   *
   * @return the boolean
   */
  public boolean isCommandDelGuard() {
    return commandDelGuard;
  }

  /**
   * Sets command del guard.
   *
   * @param commandDelGuard the command del guard
   */
  public void setCommandDelGuard(boolean commandDelGuard) {
    this.commandDelGuard = commandDelGuard;
  }

  /**
   * Is command del warp boolean.
   *
   * @return the boolean
   */
  public boolean isCommandDelWarp() {
    return commandDelWarp;
  }

  /**
   * Sets command del warp.
   *
   * @param commandDelWarp the command del warp
   */
  public void setCommandDelWarp(boolean commandDelWarp) {
    this.commandDelWarp = commandDelWarp;
  }

  /**
   * Is command discord boolean.
   *
   * @return the boolean
   */
  public boolean isCommandDiscord() {
    return commandDiscord;
  }

  /**
   * Sets command discord.
   *
   * @param commandDiscord the command discord
   */
  public void setCommandDiscord(boolean commandDiscord) {
    this.commandDiscord = commandDiscord;
  }

  /**
   * Is command donate boolean.
   *
   * @return the boolean
   */
  public boolean isCommandDonate() {
    return commandDonate;
  }

  /**
   * Sets command donate.
   *
   * @param commandDonate the command donate
   */
  public void setCommandDonate(boolean commandDonate) {
    this.commandDonate = commandDonate;
  }

  /**
   * Is command donors boolean.
   *
   * @return the boolean
   */
  public boolean isCommandDonors() {
    return commandDonors;
  }

  /**
   * Sets command donors.
   *
   * @param commandDonors the command donors
   */
  public void setCommandDonors(boolean commandDonors) {
    this.commandDonors = commandDonors;
  }

  /**
   * Is command guards boolean.
   *
   * @return the boolean
   */
  public boolean isCommandGuards() {
    return commandGuards;
  }

  /**
   * Sets command guards.
   *
   * @param commandGuards the command guards
   */
  public void setCommandGuards(boolean commandGuards) {
    this.commandGuards = commandGuards;
  }

  /**
   * Is command hat boolean.
   *
   * @return the boolean
   */
  public boolean isCommandHat() {
    return commandHat;
  }

  /**
   * Sets command hat.
   *
   * @param commandHat the command hat
   */
  public void setCommandHat(boolean commandHat) {
    this.commandHat = commandHat;
  }

  /**
   * Is command info boolean.
   *
   * @return the boolean
   */
  public boolean isCommandInfo() {
    return commandInfo;
  }

  /**
   * Sets command info.
   *
   * @param commandInfo the command info
   */
  public void setCommandInfo(boolean commandInfo) {
    this.commandInfo = commandInfo;
  }

  /**
   * Is command joined boolean.
   *
   * @return the boolean
   */
  public boolean isCommandJoined() {
    return commandJoined;
  }

  /**
   * Sets command joined.
   *
   * @param commandJoined the command joined
   */
  public void setCommandJoined(boolean commandJoined) {
    this.commandJoined = commandJoined;
  }

  /**
   * Is command player head boolean.
   *
   * @return the boolean
   */
  public boolean isCommandPlayerHead() {
    return commandPlayerHead;
  }

  /**
   * Sets command player head.
   *
   * @param commandPlayerHead the command player head
   */
  public void setCommandPlayerHead(boolean commandPlayerHead) {
    this.commandPlayerHead = commandPlayerHead;
  }

  /**
   * Is command random teleport boolean.
   *
   * @return the boolean
   */
  public boolean isCommandRandomTeleport() {
    return commandRandomTeleport;
  }

  /**
   * Sets command random teleport.
   *
   * @param commandRandomTeleport the command random teleport
   */
  public void setCommandRandomTeleport(boolean commandRandomTeleport) {
    this.commandRandomTeleport = commandRandomTeleport;
  }

  /**
   * Is command seen boolean.
   *
   * @return the boolean
   */
  public boolean isCommandSeen() {
    return commandSeen;
  }

  /**
   * Sets command seen.
   *
   * @param commandSeen the command seen
   */
  public void setCommandSeen(boolean commandSeen) {
    this.commandSeen = commandSeen;
  }

  /**
   * Is command set donor boolean.
   *
   * @return the boolean
   */
  public boolean isCommandSetDonor() {
    return commandSetDonor;
  }

  /**
   * Sets command set donor.
   *
   * @param commandSetDonor the command set donor
   */
  public void setCommandSetDonor(boolean commandSetDonor) {
    this.commandSetDonor = commandSetDonor;
  }

  /**
   * Is command set guard boolean.
   *
   * @return the boolean
   */
  public boolean isCommandSetGuard() {
    return commandSetGuard;
  }

  /**
   * Sets command set guard.
   *
   * @param commandSetGuard the command set guard
   */
  public void setCommandSetGuard(boolean commandSetGuard) {
    this.commandSetGuard = commandSetGuard;
  }

  /**
   * Is command set warp boolean.
   *
   * @return the boolean
   */
  public boolean isCommandSetWarp() {
    return commandSetWarp;
  }

  /**
   * Sets command set warp.
   *
   * @param commandSetWarp the command set warp
   */
  public void setCommandSetWarp(boolean commandSetWarp) {
    this.commandSetWarp = commandSetWarp;
  }

  /**
   * Is command vote boolean.
   *
   * @return the boolean
   */
  public boolean isCommandVote() {
    return commandVote;
  }

  /**
   * Sets command vote.
   *
   * @param commandVote the command vote
   */
  public void setCommandVote(boolean commandVote) {
    this.commandVote = commandVote;
  }

  /**
   * Is command warp boolean.
   *
   * @return the boolean
   */
  public boolean isCommandWarp() {
    return commandWarp;
  }

  /**
   * Sets command warp.
   *
   * @param commandWarp the command warp
   */
  public void setCommandWarp(boolean commandWarp) {
    this.commandWarp = commandWarp;
  }

  /**
   * Is command warps boolean.
   *
   * @return the boolean
   */
  public boolean isCommandWarps() {
    return commandWarps;
  }

  /**
   * Sets command warps.
   *
   * @param commandWarps the command warps
   */
  public void setCommandWarps(boolean commandWarps) {
    this.commandWarps = commandWarps;
  }

  /**
   * Is runnable world event boolean.
   *
   * @return the boolean
   */
  public boolean isRunnableWorldEvent() {
    return runnableWorldEvent;
  }

  /**
   * Sets runnable world event.
   *
   * @param runnableWorldEvent the runnable world event
   */
  public void setRunnableWorldEvent(boolean runnableWorldEvent) {
    this.runnableWorldEvent = runnableWorldEvent;
  }
}
