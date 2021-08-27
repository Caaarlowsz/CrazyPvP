package net.iz44kpvp.kitpvp.Kits;

import java.util.Random;

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

public class Bruxa implements Listener {
	@EventHandler
	public void onBruxa(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (Habilidade.getAbility(p).equalsIgnoreCase("Bruxa")
				&& (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& p.getInventory().getItemInHand().getType() == Material.STICK) {
			if (Cooldown.add(p)) {
				API.MensagemCooldown(p);
				return;
			}
			Cooldown.add(p, 60);
			p.sendMessage(String.valueOf(String.valueOf(API.preffix))
					+ "§bVoc\u00ea deu alguns efeitos pros players mais proximos");
			for (final Entity pertos : p.getNearbyEntities(5.0, 5.0, 5.0)) {
				final Random efeitos = new Random();
				final int dar = efeitos.nextInt(9);
				if (dar == 1) {
					((LivingEntity) pertos).addPotionEffect(new PotionEffect(PotionEffectType.POISON, 160, 2), true);
				}
				if (dar == 2) {
					((LivingEntity) pertos).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 160, 1), true);
				}
				if (dar == 3) {
					((LivingEntity) pertos).addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 160, 2), true);
				}
				if (dar == 4) {
					((LivingEntity) pertos).addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 160, 0), true);
				}
				if (dar == 5) {
					((LivingEntity) pertos).addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 160, 0), true);
				}
				if (dar == 6) {
					((LivingEntity) pertos).addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 160, 0),
							true);
				}
				if (dar == 7) {
					((LivingEntity) pertos).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 160, 0), true);
				}
				if (dar == 8) {
					((LivingEntity) pertos).addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 160, 25), true);
				}
				if (dar == 9) {
					((LivingEntity) pertos).addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 160, 0),
							true);
				}
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
					@Override
					public void run() {
						((LivingEntity) pertos).getActivePotionEffects().clear();
					}
				}, 100L);
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
					@Override
					public void run() {
						p.sendMessage(API.fimcooldown);
					}
				}, 1200L);
			}
		}
	}
}
