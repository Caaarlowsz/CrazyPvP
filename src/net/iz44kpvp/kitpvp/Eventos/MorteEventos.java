package net.iz44kpvp.kitpvp.Eventos;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scheduler.BukkitRunnable;

import net.iz44kpvp.kitpvp.Main;
import net.iz44kpvp.kitpvp.Sistemas.API;
import net.iz44kpvp.kitpvp.Sistemas.Cooldown;
import net.iz44kpvp.kitpvp.Sistemas.Habilidade;
import net.iz44kpvp.kitpvp.Sistemas.KillsDeathsRankXp;
import net.iz44kpvp.kitpvp.Sistemas.Warp;

public class MorteEventos implements Listener {
	@EventHandler
	public void aoMorrer(final PlayerDeathEvent e) {
		final Player morreu = e.getEntity();
		if (e.getEntity().getKiller() instanceof Player) {
			final Player matou = e.getEntity().getKiller();
			KillsDeathsRankXp.adicionarXp(matou, 5);
			KillsDeathsRankXp.removerXp(morreu, 1);
			KillsDeathsRankXp.adicionarKill(matou, 1);
			KillsDeathsRankXp.adicionarDeaths(morreu, 1);
			matou.playSound(matou.getLocation(), Sound.ANVIL_LAND, 5.0f, 1.0f);
			morreu.playSound(morreu.getLocation(), Sound.CREEPER_DEATH, 10.0f, 10.0f);
			matou.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea matou: §b"
					+ morreu.getDisplayName() + " §7+5 de XP");
			morreu.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea morreu para: §b"
					+ matou.getDisplayName() + " §7-1 de XP");
			Habilidade.removeAbility(morreu);
			Cooldown.remove(morreu);
			morreu.teleport(matou.getWorld().getSpawnLocation());
			e.setDeathMessage((String) null);
			Warp.removeWarp(morreu);
			morreu.setAllowFlight(false);
			morreu.setFlying(false);
			API.tirarEfeitos(morreu);
		} else {
			Habilidade.removeAbility(morreu);
			morreu.setAllowFlight(false);
			morreu.setFlying(false);
			Warp.removeWarp(morreu);
			morreu.teleport(morreu.getWorld().getSpawnLocation());
			Cooldown.remove(morreu);
			morreu.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§bVoc\u00ea se matou");
			e.setDeathMessage((String) null);
			API.tirarEfeitos(morreu);
		}
	}

	@EventHandler
	public void respawnar(final PlayerDeathEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		new BukkitRunnable() {
			public void run() {
				e.getEntity().spigot().respawn();
			}
		}.runTask(Main.getPlugin());
	}
}
