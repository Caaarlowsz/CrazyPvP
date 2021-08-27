package net.iz44kpvp.kitpvp.Kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import net.iz44kpvp.kitpvp.Main;
import net.iz44kpvp.kitpvp.Sistemas.API;
import net.iz44kpvp.kitpvp.Sistemas.Cooldown;
import net.iz44kpvp.kitpvp.Sistemas.Habilidade;

public class ForceField implements Listener {
	public static ArrayList<Player> forcefielddano;

	static {
		ForceField.forcefielddano = new ArrayList<Player>();
	}

	@EventHandler
	public void stomperApple(final PlayerInteractEvent event) {
		final Player p = event.getPlayer();
		if (event.getPlayer().getItemInHand().getType() == Material.IRON_FENCE
				&& Habilidade.getAbility(p).equalsIgnoreCase("ForceField")) {
			if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK
					|| event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
				event.setCancelled(true);
			}
			if (Cooldown.add(p)) {
				API.MensagemCooldown(p);
				return;
			}
			final Location loc = p.getLocation();
			p.getWorld().playSound(loc, Sound.MAGMACUBE_WALK2, 5.0f, -5.0f);
			Cooldown.add(p, 30);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Main.getInstance(),
					(Runnable) new Runnable() {
						@Override
						public void run() {
							ForceField.forcefielddano.add(p);
							p.sendMessage(
									String.valueOf(String.valueOf(API.preffix)) + "§aVoce ativou o kit ForceField");
						}
					}, 0L);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Main.getInstance(),
					(Runnable) new Runnable() {
						@Override
						public void run() {
							ForceField.forcefielddano.remove(p);
						}
					}, 200L);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Main.getInstance(),
					(Runnable) new Runnable() {
						@Override
						public void run() {
							p.sendMessage(API.fimcooldown);
						}
					}, 600L);
		}
	}

	@EventHandler
	public void darForceField(final PlayerMoveEvent event) {
		final Player p = event.getPlayer();
		if (ForceField.forcefielddano.contains(p)) {
			final List<Entity> Local = (List<Entity>) p.getNearbyEntities(4.0, 4.0, 4.0);
			for (final Entity inimigos : Local) {
				if (!(inimigos instanceof Player)) {
					return;
				}
//                if (inimigos == null) {
//                    p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§cN\u00e3o existe players perto de voc\u00ea");
//                    return;
//                }
				final Player local = (Player) inimigos;
				local.damage(3.0);
				inimigos.setVelocity(new Vector(0.2, 0.0, 0.2));
			}
		}
	}
}
