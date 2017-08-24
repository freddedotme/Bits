package bits.bits.team;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;

import java.util.HashMap;

/**
 * The type World event.
 */
public class WorldEvent {
  private String announcement;
  private HashMap<EntityType, Integer> monsters;
  private Location location;

  /**
   * Instantiates a new World event.
   *
   * @param announcement the announcement
   * @param monsters     the monsters
   * @param location     the location
   */
  public WorldEvent(String announcement, HashMap<EntityType, Integer> monsters, Location location) {
    this.announcement = announcement;
    this.monsters = monsters;
    this.location = location;
  }

  /**
   * Gets announcement.
   *
   * @return the announcement
   */
  public String getAnnouncement() {
    return announcement;
  }

  /**
   * Sets announcement.
   *
   * @param announcement the announcement
   */
  public void setAnnouncement(String announcement) {
    this.announcement = announcement;
  }

  /**
   * Gets monsters.
   *
   * @return the monsters
   */
  public HashMap<EntityType, Integer> getMonsters() {
    return monsters;
  }

  /**
   * Sets monsters.
   *
   * @param monsters the monsters
   */
  public void setMonsters(HashMap<EntityType, Integer> monsters) {
    this.monsters = monsters;
  }

  /**
   * Gets location.
   *
   * @return the location
   */
  public Location getLocation() {
    return location;
  }

  /**
   * Sets location.
   *
   * @param location the location
   */
  public void setLocation(Location location) {
    this.location = location;
  }
}
