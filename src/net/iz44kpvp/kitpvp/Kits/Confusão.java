package net.iz44kpvp.kitpvp.Kits;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.iz44kpvp.kitpvp.Main;
import net.iz44kpvp.kitpvp.Sistemas.API;
import net.iz44kpvp.kitpvp.Sistemas.Cooldown;
import net.iz44kpvp.kitpvp.Sistemas.Habilidade;

public class Confus\u00e3o implements Listener {
	@EventHandler
	public void onConfusao(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (Habilidade.getAbility(p).equalsIgnoreCase("Confus\u00e3o")
				&& (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& p.getItemInHand().getType() == Material.ENDER_PEARL) {
			e.setCancelled(true);
			if (Cooldown.add(p)) {
				API.MensagemCooldown(p);
				return;
			}
			Cooldown.add(p, 40);
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 2));
			for (final Entity pertos : p.getNearbyEntities(5.0, 5.0, 5.0)) {
				((LivingEntity) pertos).addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 100, 0));
				((LivingEntity) pertos).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 0));
				((LivingEntity) pertos).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 0));
				((LivingEntity) pertos).addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 0));
			}
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					p.sendMessage(API.fimcooldown);
				}
			}, 800L);
		}
	}
}
