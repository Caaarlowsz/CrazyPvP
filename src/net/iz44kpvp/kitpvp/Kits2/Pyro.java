package net.iz44kpvp.kitpvp.Kits2;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

import net.iz44kpvp.kitpvp.Main;
import net.iz44kpvp.kitpvp.Sistemas.API;
import net.iz44kpvp.kitpvp.Sistemas.Cooldown;
import net.iz44kpvp.kitpvp.Sistemas.Habilidade;

public class Pyro implements Listener {
	@EventHandler
	public void aopyro(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (Habilidade.getAbility(p).equalsIgnoreCase("Pyro")
				&& (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& p.getItemInHand().getType() == Material.FIREBALL) {
			if (Cooldown.add(p)) {
				API.MensagemCooldown(p);
				return;
			}
			Cooldown.add(p, 21);
			Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.getInstance(), (Runnable) new Runnable() {
				@Override
				public void run() {
					final Fireball fire = (Fireball) p.getWorld().spawnEntity(p.getEyeLocation(), EntityType.FIREBALL);
					fire.setFireTicks(30);
				}
			}, 0L);
			Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.getInstance(), (Runnable) new Runnable() {
				@Override
				public void run() {
					final Fireball fire = (Fireball) p.getWorld().spawnEntity(p.getEyeLocation(), EntityType.FIREBALL);
					fire.setFireTicks(30);
				}
			}, 15L);
			Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.getInstance(), (Runnable) new Runnable() {
				@Override
				public void run() {
					final Fireball fire = (Fireball) p.getWorld().spawnEntity(p.getEyeLocation(), EntityType.FIREBALL);
					fire.setFireTicks(30);
				}
			}, 20L);
			Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.getInstance(), (Runnable) new Runnable() {
				@Override
				public void run() {
					final Fireball fire = (Fireball) p.getWorld().spawnEntity(p.getEyeLocation(), EntityType.FIREBALL);
					fire.setFireTicks(30);
				}
			}, 25L);
			Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.getInstance(), (Runnable) new Runnable() {
				@Override
				public void run() {
					final Fireball fire = (Fireball) p.getWorld().spawnEntity(p.getEyeLocation(), EntityType.FIREBALL);
					fire.setFireTicks(30);
				}
			}, 30L);
			Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.getInstance(), (Runnable) new Runnable() {
				@Override
				public void run() {
					p.sendMessage(API.fimcooldown);
				}
			}, 420L);
		}
	}
}
