package bits.bits.team;

import org.bukkit.Location;

import java.util.UUID;

/**
 * The type Shop.
 */
public class Shop {
  private UUID uuid;
  private Location location;

  /**
   * Instantiates a new Shop.
   *
   * @param uuid     the uuid
   * @param location the location
   */
  public Shop(UUID uuid, Location location) {
    this.uuid = uuid;
    this.location = location;
  }

  /**
   * Gets uuid.
   *
   * @return the uuid
   */
  public UUID getUuid() {
    return uuid;
  }

  /**
   * Sets uuid.
   *
   * @param uuid the uuid
   */
  public void setUuid(UUID uuid) {
    this.uuid = uuid;
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
