package net.iz44kpvp.kitpvp.Kits;

import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.util.Vector;

import net.iz44kpvp.kitpvp.Sistemas.Habilidade;

public class Deshzin implements Listener {
	@EventHandler
	public void onPlayerToggleFly(final PlayerToggleFlightEvent e) {
		final Player p = e.getPlayer();
		if (Habilidade.getAbility(p).equalsIgnoreCase("Deshzin")) {
			if (p.getGameMode() == GameMode.CREATIVE) {
				return;
			}
			e.setCancelled(true);
			p.setFlying(false);
			p.setAllowFlight(false);
			final Location loc = p.getLocation();
			if (!p.isSneaking()) {
				p.setFallDistance(-3.0f);
				final Vector vector = p.getEyeLocation().getDirection();
				vector.multiply(0.6f);
				vector.setY(1.0f);
				p.setVelocity(vector);
			} else {
				p.setFallDistance(-3.0f);
				final Vector vector = p.getEyeLocation().getDirection();
				vector.multiply(1.35f);
				vector.setY(0.66);
				p.setVelocity(vector);
			}
			loc.getWorld().playSound(loc, Sound.FIREWORK_BLAST, 1.0f, 0.2f);
			p.getWorld().playEffect(p.getLocation(), Effect.COLOURED_DUST, 80);
		}
	}

	@EventHandler
	public void onDamage(final EntityDamageEvent event) {
		final Entity e = event.getEntity();
		if (e instanceof Player) {
			final Player player = (Player) e;
			if (Habilidade.getAbility(player).equalsIgnoreCase("Deshzin") && event.getEntity() instanceof Player
					&& event.getCause() == EntityDamageEvent.DamageCause.FALL) {
				event.setDamage(2.0);
			}
		}
	}

	@EventHandler
	public void onPlayerMove(final PlayerMoveEvent e) {
		final Player p = e.getPlayer();
		if (Habilidade.getAbility(p).equalsIgnoreCase("Deshzin")) {
			if (p.getGameMode() == GameMode.CREATIVE) {
				return;
			}
			if (p.isOnGround() && !p.getAllowFlight()) {
				p.setAllowFlight(true);
			}
		}
	}

	@EventHandler
	public void aomorrer(final PlayerDeathEvent e) {
		final Player p = e.getEntity();
		if (Habilidade.getAbility(p).equalsIgnoreCase("Deshzin")) {
			p.setAllowFlight(false);
		}
	}

	@EventHandler
	public void aomorrer(final PlayerQuitEvent e) {
		final Player p = e.getPlayer();
		if (Habilidade.getAbility(p).equalsIgnoreCase("Deshzin")) {
			p.setAllowFlight(false);
		}
	}
}
