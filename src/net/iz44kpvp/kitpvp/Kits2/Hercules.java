package net.iz44kpvp.kitpvp.Kits2;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.iz44kpvp.kitpvp.Main;
import net.iz44kpvp.kitpvp.Sistemas.API;
import net.iz44kpvp.kitpvp.Sistemas.Cooldown;
import net.iz44kpvp.kitpvp.Sistemas.Habilidade;

public class Hercules implements Listener {
	@EventHandler
	public void aohercules(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (Habilidade.getAbility(p).equalsIgnoreCase("Hercules")
				&& (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& p.getItemInHand().getType() == Material.BONE) {
			if (Cooldown.add(p)) {
				API.MensagemCooldown(p);
				return;
			}
			for (final Entity pertos : p.getNearbyEntities(5.0, 5.0, 5.0)) {
				pertos.setVelocity(pertos.getVelocity().setY(1));
				((Player) pertos).sendMessage("§7Voc\u00ea foi levantado por um hercules");
			}
			p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 240, 2));
			Cooldown.add(p, 15);
			Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.getInstance(), (Runnable) new Runnable() {
				@Override
				public void run() {
					p.sendMessage(API.fimcooldown);
				}
			}, 300L);
		}
	}
}
