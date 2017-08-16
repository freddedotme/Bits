package bits.bits.team;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;

import java.util.HashMap;

/**
 * Bits
 * Author: freddedotme
 * Created: 2017-08-15
 */
public class WorldEvent {
  private String announcement;
  private HashMap<EntityType, Integer> monsters;
  private Location location;

  public WorldEvent(String announcement, HashMap<EntityType, Integer> monsters, Location location) {
    this.announcement = announcement;
    this.monsters = monsters;
    this.location = location;
  }

  public String getAnnouncement() {
    return announcement;
  }

  public void setAnnouncement(String announcement) {
    this.announcement = announcement;
  }

  public HashMap<EntityType, Integer> getMonsters() {
    return monsters;
  }

  public void setMonsters(HashMap<EntityType, Integer> monsters) {
    this.monsters = monsters;
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }
}
