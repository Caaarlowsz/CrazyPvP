package net.iz44kpvp.kitpvp.Kits;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffectType;

import net.iz44kpvp.kitpvp.Main;
import net.iz44kpvp.kitpvp.Sistemas.API;
import net.iz44kpvp.kitpvp.Sistemas.Cooldown;
import net.iz44kpvp.kitpvp.Sistemas.Habilidade;

public class Hack implements Listener {
	@EventHandler
	public void aohack(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (Habilidade.getAbility(p).equalsIgnoreCase("Hack")
				&& (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& p.getItemInHand().getType() == Material.SLIME_BALL) {
			if (Cooldown.add(p)) {
				API.MensagemCooldown(p);
				return;
			}
			Cooldown.add(p, 25);
			p.setAllowFlight(true);
			p.setFlying(true);
			API.darEfeito(p, PotionEffectType.SPEED, 5, 2);
			p.sendMessage("§aHACK ATIVADO");
			Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.getInstance(), (Runnable) new Runnable() {
				@Override
				public void run() {
					p.setAllowFlight(false);
					p.setFlying(false);
				}
			}, 100L);
			Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.getInstance(), (Runnable) new Runnable() {
				@Override
				public void run() {
					p.sendMessage(API.fimcooldown);
				}
			}, 500L);
		}
	}
}
