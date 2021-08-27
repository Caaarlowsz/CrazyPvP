package net.iz44kpvp.kitpvp.Eventos;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

import net.iz44kpvp.kitpvp.Main;
import net.iz44kpvp.kitpvp.Sistemas.API;
import net.iz44kpvp.kitpvp.Sistemas.Habilidade;

public class CombatLog implements Listener {
	public static HashMap<Player, Player> emcombate;

	static {
		CombatLog.emcombate = new HashMap<Player, Player>();
	}

	public static boolean emCombate(final Player p) {
		return CombatLog.emcombate.containsKey(p);
	}

	public static String statuscombat(final Player p) {
		String nome = "";
		if (emCombate(p)) {
			nome = "§aSim";
		} else if (!emCombate(p)) {
			nome = "§cN\u00e3o";
		}
		return nome;
	}

	@EventHandler
	public void aocombatlog(final EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
			final Player p = (Player) e.getEntity();
			final Player hitter = (Player) e.getDamager();
			if (Habilidade.getAbility(p) != "Nenhum" && Habilidade.getAbility(hitter) != "Nenhum"
					&& !CombatLog.emcombate.containsKey(p) && !CombatLog.emcombate.containsKey(hitter)) {
				CombatLog.emcombate.put(p, hitter);
				CombatLog.emcombate.put(hitter, p);
				hitter.sendMessage("§7Voc\u00ea est\u00e1 em combate com §c" + p.getDisplayName());
				p.sendMessage("§7Voc\u00ea est\u00e1 em combate com §c" + hitter.getDisplayName());
				Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.instance, (Runnable) new Runnable() {
					@Override
					public void run() {
						CombatLog.emcombate.remove(p);
						CombatLog.emcombate.remove(hitter);
						hitter.sendMessage("§aVoc\u00ea est\u00e1 fora de combate");
						p.sendMessage("§aVoc\u00ea est\u00e1 fora de combate");
					}
				}, 80L);
			}
		}
	}

	@EventHandler
	public void aomorrer(final PlayerDeathEvent e) {
		final Player p = e.getEntity();
		if (CombatLog.emcombate.containsKey(p)) {
			final Player t = CombatLog.emcombate.get(p);
			p.teleport(p.getWorld().getSpawnLocation());
			t.sendMessage("§aVoc\u00ea est\u00e1 fora de combate");
			CombatLog.emcombate.remove(p);
			CombatLog.emcombate.remove(t);
		}
	}

	@EventHandler
	public void aosair(final PlayerQuitEvent e) {
		final Player p = e.getPlayer();
		if (CombatLog.emcombate.containsKey(p)) {
			final Player t = CombatLog.emcombate.get(p);
			p.setHealth(0.0);
			p.teleport(p.getWorld().getSpawnLocation());
			CombatLog.emcombate.remove(p);
			CombatLog.emcombate.remove(t);
			Bukkit.broadcastMessage("§7 " + p.getName() + "§c Deslogou No PvP!");
			t.sendMessage("§aVoc\u00ea est\u00e1 fora de combate");
		}
	}

	@EventHandler
	public void aocomando(final PlayerCommandPreprocessEvent e) {
		final Player p = e.getPlayer();
		if (e.getMessage().toLowerCase().startsWith("/") && CombatLog.emcombate.containsKey(p)) {
			p.sendMessage(API.bloquearpvp);
			e.setCancelled(true);
		}
	}
}
