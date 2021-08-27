package net.iz44kpvp.kitpvp.Eventos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.server.ServerListPingEvent;

import net.iz44kpvp.kitpvp.Comandos.Score;
import net.iz44kpvp.kitpvp.Sistemas.API;
import net.iz44kpvp.kitpvp.Sistemas.Habilidade;
import net.iz44kpvp.kitpvp.Sistemas.KillsDeathsRankXp;

public class PlayerEventos implements Listener {
	@EventHandler
	public void onEntrar(final PlayerJoinEvent e) {
		final Player p = e.getPlayer();
		e.setJoinMessage("§5[§a+§5] §b" + p.getDisplayName());
		p.getInventory().clear();
		API.ItemServer(p);
		p.setHealth(20.0);
		p.setFireTicks(0);
		API.tirarArmadura(p);
		Habilidade.removeAbility(p);
		p.setFoodLevel(20);
		p.teleport(p.getWorld().getSpawnLocation());
		p.setGameMode(GameMode.SURVIVAL);
		Score.ntemscore.add(p.getName());
		p.sendMessage("§7BemVindo Ao: " + API.NomeServer);
		p.chat("/tag normal");
	}

	@EventHandler
	public void onSair(final PlayerQuitEvent e) {
		final Player p = e.getPlayer();
		e.setQuitMessage("§5[§c-§5] §b" + p.getDisplayName());
	}

	@EventHandler
	public void onCheio(final PlayerLoginEvent event) {
		final Player p = event.getPlayer();
		if (event.getResult() == PlayerLoginEvent.Result.KICK_FULL) {
			if (p.hasPermission("flame.vip")) {
				event.setResult(PlayerLoginEvent.Result.ALLOWED);
			} else {
				event.setKickMessage("§cO Servidor Esta Cheio!");
			}
		} else if (event.getResult() == PlayerLoginEvent.Result.KICK_WHITELIST) {
			event.setKickMessage(
					"§7Estamos Em Manuten\u00e7\u00e3o! §cPara Sua Melhor Jogabilidade\n§ePorFavor Volte Mais Tarde");
		}
	}

	@EventHandler
	public void onRespawn(final PlayerRespawnEvent e) {
		final Player p = e.getPlayer();
		p.getInventory().clear();
		API.ItemServer(p);
		p.setHealth(20.0);
		p.setFireTicks(0);
		p.setFoodLevel(20);
		API.tirarArmadura(p);
		p.teleport(p.getWorld().getSpawnLocation());
		p.updateInventory();
		p.sendMessage("§7Voc\u00ea voltou para o spawn");
		Habilidade.removeAbility(p);
		API.CoisasNoNome(p);
		API.tirarEfeitos(p);
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onColorandChangeChat(final PlayerChatEvent e) {
		final Player p = e.getPlayer();
		if (e.getMessage().equalsIgnoreCase("server lixo") || e.getMessage().equalsIgnoreCase("servidor lixo")) {
			e.setMessage("Amei esse servidor \u00e9 o melhor do mundo <3");
		}
		if (e.getMessage().equalsIgnoreCase("sou hack")) {
			e.setMessage("Sou Um Lixo E Uso Hack Me Bani");
		}
		if (e.getMessage().contains(" ez ") || e.getMessage().contains(" iz ")) {
			e.setCancelled(true);
			p.sendMessage("§cPor Favor N\u00e3o Diga Isso! '<ez, iz>' ");
		}
		if (!p.hasPermission("flame.chat")) {
			e.setFormat("§7(" + ChatColor.RESET + KillsDeathsRankXp.getRankPequeno(p) + "§7)" + ChatColor.RESET + "§7"
					+ p.getDisplayName() + " §b» §f " + e.getMessage());
			if (e.getMessage().contains(".net") || e.getMessage().contains(".com") || e.getMessage().contains(".com.br")
					|| e.getMessage().contains(".pro") || e.getMessage().contains(".nu")
					|| e.getMessage().contains(".tk")) {
				e.setCancelled(true);
				p.sendMessage("§cVoc\u00ea n\u00e3o pode divulgar IP´s nesse servidor");
				p.sendMessage("§cVoc\u00ea foi reportado a um staff");
				Bukkit.broadcast("§7" + p.getName() + " §6Esta Divulgando IP´s Mute-o", "flame.staff");
			}
		} else {
			e.setFormat("§7(" + ChatColor.RESET + KillsDeathsRankXp.getRankPequeno(p) + "§7)" + ChatColor.RESET + "§7"
					+ p.getDisplayName() + " §b» §f " + e.getMessage().replaceAll("&", "§"));
		}
	}

	@EventHandler
	private void onCommand(final PlayerCommandPreprocessEvent e) {
		final Player p = e.getPlayer();
		if (e.getMessage().contains("/me")) {
			if (p.hasPermission("flame.staff")) {
				e.setCancelled(false);
			} else {
				p.sendMessage("§cVoc\u00ea n\u00e3o tem permiss\u00e3o para usar esse comando!");
				e.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void onMotd(final ServerListPingEvent e) {
		e.setMotd(String.valueOf(String.valueOf(API.Motd)) + "\n" + API.StatusMotd);
		e.setMaxPlayers(60);
	}
}
