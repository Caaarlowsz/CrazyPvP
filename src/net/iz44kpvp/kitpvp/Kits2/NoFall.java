package net.iz44kpvp.kitpvp.Kits2;

import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import net.iz44kpvp.kitpvp.Sistemas.Habilidade;

public class NoFall implements Listener {
	@EventHandler
	public void aogalinha(final EntityDamageEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
			final Player p = (Player) e.getEntity();
			if (Habilidade.getAbility(p).equalsIgnoreCase("NoFall")) {
				e.setDamage(1.0);
				p.getWorld().playEffect(p.getLocation().add(1.0, 0.0, 0.0), Effect.MOBSPAWNER_FLAMES, 30);
				p.getWorld().playEffect(p.getLocation().add(0.0, 0.0, 1.0), Effect.MOBSPAWNER_FLAMES, 30);
				p.getWorld().playEffect(p.getLocation().add(-1.0, 0.0, 0.0), Effect.MOBSPAWNER_FLAMES, 30);
				p.getWorld().playEffect(p.getLocation().add(0.0, 0.0, -1.0), Effect.MOBSPAWNER_FLAMES, 30);
				p.getWorld().playEffect(p.getLocation().add(0.0, 0.0, 0.0), Effect.MOBSPAWNER_FLAMES, 30);
				p.getWorld().playEffect(p.getLocation().add(-0.0, 0.0, 0.0), Effect.MOBSPAWNER_FLAMES, 30);
				p.getWorld().playEffect(p.getLocation().add(0.0, 0.0, -0.0), Effect.MOBSPAWNER_FLAMES, 30);
			}
		}
	}
}
