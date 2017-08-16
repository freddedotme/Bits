package bits.bits.team.event;

import bits.bits.team.Main;
import com.vexsoftware.votifier.model.Vote;
import com.vexsoftware.votifier.model.VotifierEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class EventVote implements Listener {
  private Main main;
  private List<PotionEffectType> effects;

  public EventVote(Main main) {
    this.main = main;

    effects = new ArrayList<>();
    effects.add(PotionEffectType.FAST_DIGGING);
    effects.add(PotionEffectType.FIRE_RESISTANCE);
    effects.add(PotionEffectType.HEALTH_BOOST);
    effects.add(PotionEffectType.DAMAGE_RESISTANCE);
    effects.add(PotionEffectType.LUCK);
    effects.add(PotionEffectType.INCREASE_DAMAGE);
    effects.add(PotionEffectType.SPEED);
    effects.add(PotionEffectType.JUMP);
    effects.add(PotionEffectType.REGENERATION);
    effects.add(PotionEffectType.WATER_BREATHING);
  }

  @EventHandler
  public void onVotifier(VotifierEvent e) {
    Vote vote = e.getVote();
    String name = vote.getUsername();
    String service = vote.getServiceName();
    main.getServer().dispatchCommand(main.getServer().getConsoleSender(), "broadcast " + main.d().MSG_VOTING.replace
      ("{player}",
        name).replace("{service}", service));
    main.getServer().dispatchCommand(main.getServer().getConsoleSender(), "AdjustBonusClaimBlocks " + name + " 250");

    int random = ThreadLocalRandom.current().nextInt(0, effects.size() - 1);

    for (Player player : main.getServer().getOnlinePlayers()) {
      player.addPotionEffect(new PotionEffect(effects.get(random), main.d().EFFECT_DURATION, 0, false, false));
    }
  }
}
