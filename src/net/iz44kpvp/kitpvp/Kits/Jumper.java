package net.iz44kpvp.kitpvp.Kits;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import net.iz44kpvp.kitpvp.Main;
import net.iz44kpvp.kitpvp.Sistemas.API;
import net.iz44kpvp.kitpvp.Sistemas.Cooldown;
import net.iz44kpvp.kitpvp.Sistemas.Habilidade;

public class Jumper implements Listener {
	public static ArrayList<String> naotomardano;

	static {
		Jumper.naotomardano = new ArrayList<String>();
	}

	@EventHandler
	public void aoJumper(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (Habilidade.getAbility(p).equalsIgnoreCase("Jumper")
				&& (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& p.getInventory().getItemInHand().getType() == Material.FIREWORK_CHARGE) {
			if (Cooldown.add(p)) {
				API.MensagemCooldown(p);
				return;
			}
			final Item b = Bukkit.getWorlds().get(0).dropItem(p.getLocation(), new ItemStack(Material.BEACON));
			p.setPassenger((Entity) b);
			final Vector vecto = p.getVelocity().setY(6);
			p.setVelocity(vecto);
			Jumper.naotomardano.add(p.getName());
			Cooldown.add(p, 20);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					p.sendMessage(API.fimcooldown);
				}
			}, 400L);
		}
	}

	@EventHandler
	public void JumperQueda(final EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			final Player p = (Player) e.getEntity();
			if (e.getCause() == EntityDamageEvent.DamageCause.FALL
					&& Habilidade.getAbility(p).equalsIgnoreCase("Jumper")) {
				e.setDamage(2.0);
			}
		}
	}
}
