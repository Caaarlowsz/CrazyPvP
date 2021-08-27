package net.iz44kpvp.kitpvp.Kits;

import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import net.iz44kpvp.kitpvp.Sistemas.API;
import net.iz44kpvp.kitpvp.Sistemas.Habilidade;

public class Teleporter implements Listener {
	@EventHandler
	public void AoTeleport(final EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Arrow && ((Arrow) e.getDamager()).getShooter() instanceof Player) {
			final Arrow arrow = (Arrow) e.getDamager();
			final Player p = (Player) arrow.getShooter();
			p.getLocation().distance(e.getEntity().getLocation());
			if (e.getEntity() instanceof Player && Habilidade.getAbility(p).equalsIgnoreCase("Teleporter")) {
				p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, 1.0f);
				p.teleport(e.getEntity().getLocation());
				p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea teleportou para: §b"
						+ ((Player) e.getEntity()).getName());
			}
		}
	}
}
