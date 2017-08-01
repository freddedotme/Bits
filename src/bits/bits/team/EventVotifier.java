package bits.bits.team;

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

public class EventVotifier implements Listener
{
  private Main                   main;
  private List<PotionEffectType> effects;

  EventVotifier(Main main)
  {
    this.main = main;

    effects = new ArrayList<>();
    effects.add(PotionEffectType.FAST_DIGGING);
    effects.add(PotionEffectType.FIRE_RESISTANCE);
    effects.add(PotionEffectType.HEALTH_BOOST);
    effects.add(PotionEffectType.DAMAGE_RESISTANCE);
    effects.add(PotionEffectType.LUCK);
  }

  @EventHandler
  public void onVotifier(VotifierEvent e)
  {
    Vote   vote = e.getVote();
    String name = vote.getUsername();
    main.getServer().broadcastMessage(Data.MSG_VOTING.replace("{player}", name));
    main.getServer().dispatchCommand(main.getServer().getConsoleSender(), "AdjustBonusClaimBlocks " + name + " 100");

    int random = ThreadLocalRandom.current().nextInt(0, effects.size() - 1);

    for (Player player : main.getServer().getOnlinePlayers())
    {
      player.addPotionEffect(new PotionEffect(effects.get(random), Data.EFFECT_DURATION, 0, false, false));
    }
  }
}
