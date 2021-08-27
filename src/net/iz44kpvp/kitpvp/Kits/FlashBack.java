package net.iz44kpvp.kitpvp.Kits;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffectType;

import net.iz44kpvp.kitpvp.Main;
import net.iz44kpvp.kitpvp.Sistemas.API;
import net.iz44kpvp.kitpvp.Sistemas.Cooldown;
import net.iz44kpvp.kitpvp.Sistemas.Habilidade;

public class FlashBack implements Listener {
	public static HashMap<String, Location> salvarlocal;
	public static HashMap<String, ItemStack[]> salvarinv;

	static {
		FlashBack.salvarlocal = new HashMap<String, Location>();
		FlashBack.salvarinv = new HashMap<String, ItemStack[]>();
	}

	public static void checker(final Player p) {
		Bukkit.getScheduler().scheduleSyncRepeatingTask((Plugin) Main.getInstance(), (Runnable) new Runnable() {
			@Override
			public void run() {
				if (Habilidade.getAbility(p).equalsIgnoreCase("FlashBack")) {
					FlashBack.salvarlocal.put(p.getName(), p.getLocation());
					FlashBack.salvarinv.put(p.getName(), p.getInventory().getContents());
					p.getWorld().playEffect(p.getLocation(), Effect.SMOKE, 50);
				}
			}
		}, 0L, 300L);
	}

	@EventHandler
	public void aozombiefer(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (Habilidade.getAbility(p).equalsIgnoreCase("FlashBack")
				&& (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& p.getItemInHand().getType() == Material.HOPPER) {
			if (Gladiator.lutando.containsKey(p.getName()) || Infernor.lutando.containsKey(p.getName())) {
				p.sendMessage(String.valueOf(String.valueOf(API.preffix))
						+ "§cVoc\u00ea n\u00e3o poder usar seu kit no gladiator(infernor) ent\u00e3o vai §aganhar §eum efeito de §afor\u00e7a §ee §aspeed");
				API.darEfeito(p, PotionEffectType.INCREASE_DAMAGE, 10, 1);
				API.darEfeito(p, PotionEffectType.SPEED, 10, 2);
			} else {
				if (Cooldown.add(p)) {
					API.MensagemCooldown(p);
					return;
				}
				if (!FlashBack.salvarlocal.containsKey(p.getName()) || !FlashBack.salvarinv.containsKey(p.getName())) {
					p.sendMessage("§7O local e o inventario ainda n\u00e3o foi salvado");
					return;
				}
				Cooldown.add(p, 35);
				final Location loc = FlashBack.salvarlocal.get(p.getName());
				p.teleport(loc);
				p.getInventory().setContents((ItemStack[]) FlashBack.salvarinv.get(p.getName()));
				Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.getInstance(), (Runnable) new Runnable() {
					@Override
					public void run() {
						p.sendMessage(API.fimcooldown);
					}
				}, 700L);
			}
		}
	}

	@EventHandler
	public void aomorrer(final PlayerDeathEvent e) {
		final Player morreu = e.getEntity();
		if (Habilidade.getAbility(morreu).equalsIgnoreCase("FlashBack")) {
			FlashBack.salvarlocal.remove(morreu.getName());
			FlashBack.salvarinv.remove(morreu.getName());
		}
	}
}
