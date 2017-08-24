package bits.bits.team.runnable;

import bits.bits.team.Main;
import bits.bits.team.WorldEvent;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The type Runnable world event.
 */
public class RunnableWorldEvent extends BukkitRunnable {
  private Main main;
  private List<WorldEvent> events;

  /**
   * Instantiates a new Runnable world event.
   *
   * @param main the main
   */
  public RunnableWorldEvent(Main main) {
    this.main = main;

    events = new ArrayList<>();

    HashMap<EntityType, Integer> monsters = new HashMap<>();
    monsters.put(EntityType.EVOKER, 5);
    monsters.put(EntityType.VINDICATOR, 10);

    events.add(new WorldEvent(
      "&cOh no, a pack of Evokers and Vindicators are attacking us! Help us defend our lands! They were last " +
        "seen close to {location}. Hurry!",
      monsters,
      null) {
    });

    monsters = new HashMap<>();
    monsters.put(EntityType.GIANT, 10);

    events.add(new WorldEvent(
      "&cThe whole ground is shaking by the Giants that are here to destroy our land. Defeat them " +
        "quickly! They were last seen close to {location}. Hurry!",
      monsters,
      null
    ));

    monsters = new HashMap<>();
    monsters.put(EntityType.CREEPER, 30);

    events.add(new WorldEvent(
      "&cSSSSSssssSSss! The Creeper army is here to wipe us out. Gear up with your bow, godlike armor and kill " +
        "them! They were last seen close to {location}. Hurry!",
      monsters,
      null
    ));

    monsters = new HashMap<>();
    monsters.put(EntityType.WOLF, 45);

    events.add(new WorldEvent(
      "&cAooooOOoo! A pack of wolves are visiting our lands. Get a new friend for life or kill them.. up to you. They" +
        " were last seen close to {location}.",
      monsters,
      null
    ));

    monsters = new HashMap<>();
    monsters.put(EntityType.LLAMA, 25);

    events.add(new WorldEvent(
      "&cWhat the? Lamas here? A pack of lamas are slowly moving through our land, Pay them a visit. They were last " +
        "seen close to {location}.",
      monsters,
      null
    ));

    monsters = new HashMap<>();
    monsters.put(EntityType.DONKEY, 20);

    events.add(new WorldEvent(
      "&cHeee-haw! It looks like there are loads of donkeys having some sort of meeting? You should check out what " +
        "they're up to. They were last seen close to {location}.",
      monsters,
      null
    ));

    monsters = new HashMap<>();
    monsters.put(EntityType.WITCH, 20);

    events.add(new WorldEvent(
      "&cStupefy! A pact of witches are marching through our lands. This can't be good. Head over and keep an eye on " +
        "them. They were last seen close to {location}.",
      monsters,
      null
    ));

    monsters = new HashMap<>();
    monsters.put(EntityType.PARROT, 20);

    events.add(new WorldEvent(
      "&cWow, they are so colorful and cute! A pack of parrots have been spotted. They were last seen close to " +
        "{location}.",
      monsters,
      null
    ));
  }

  @Override
  public void run() {
    init();
  }

  private void init() {
    World bits = main.getServer().getWorld("bits");
    WorldBorder worldBorder = bits.getWorldBorder();

    double size = worldBorder.getSize();
    Location center = worldBorder.getCenter();
    double x = center.getBlockX();
    double z = center.getBlockZ();
    double margin = main.d().WB_MARGIN;

    double maxX = (x + size / 2) - margin;
    double minX = (x - size / 2) + margin;
    double maxZ = (z + size / 2) - margin;
    double minZ = (z - size / 2) + margin;

    double randX = ThreadLocalRandom.current().nextDouble(minX, maxX);
    double randZ = ThreadLocalRandom.current().nextDouble(minZ, maxZ);

    new BukkitRunnable() {
      @Override
      public void run() {
        Block randBlock = bits.getHighestBlockAt((int) randX, (int) randZ).getRelative(0, -1, 0);

        if (randBlock.getType() != Material.STATIONARY_WATER && randBlock.getType() != Material.STATIONARY_LAVA) {
          int random = ThreadLocalRandom.current().nextInt(0, events.size() - 1);

          WorldEvent event = events.get(random);
          Location location = new Location(bits, randX, randBlock.getY() + 1, randZ);

          String target = "(X:" + location.getBlockX() + ", Z:" + location.getBlockZ() + ")";

          main.getServer().dispatchCommand(main.getServer().getConsoleSender(), "broadcast " + event.getAnnouncement
            ().replace("{location}", target));

          for (EntityType monster : event.getMonsters().keySet()) {
            for (int i = 0; i < event.getMonsters().get(monster); i++) {
              LivingEntity entity = (LivingEntity) bits.spawnEntity(location, monster);
              entity.setRemoveWhenFarAway(false);
            }
          }
        }
        else {
          init();
        }
      }
    }.runTask(main);
  }
}
