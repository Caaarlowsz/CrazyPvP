package net.iz44kpvp.kitpvp.Kits2;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import net.iz44kpvp.kitpvp.Sistemas.API;
import net.iz44kpvp.kitpvp.Sistemas.Cooldown;
import net.iz44kpvp.kitpvp.Sistemas.Habilidade;

public class Hulk implements Listener {
	@EventHandler
	public void PickUpPlayer(final PlayerInteractEntityEvent e) {
		if (!(e.getRightClicked() instanceof Player)) {
			return;
		}
		if (e.getRightClicked() instanceof Player) {
			final Player p = e.getPlayer();
			if (Habilidade.getAbility(p).equalsIgnoreCase("Hulk")) {
				final Player r = (Player) e.getRightClicked();
				if (Cooldown.add(p)) {
					API.MensagemCooldown(p);
					return;
				}
				if (p.getItemInHand().getType() != Material.AIR) {
					return;
				}
				if (p.getPassenger() != null) {
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Ja tem alguem, espere ele sair!");
					return;
				}
				if (r.getPassenger() != null) {
					return;
				}
				Cooldown.add(p, 6);
				p.setPassenger((Entity) r);
				r.sendMessage(
						String.valueOf(String.valueOf(API.preffix)) + "§7Um hulk te prendeu, aperte shift para fugir");
			}
		}
	}
}
