package net.iz44kpvp.kitpvp.Comandos;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import net.iz44kpvp.kitpvp.Main;
import net.iz44kpvp.kitpvp.Sistemas.API;

public class Congelar implements CommandExecutor, Listener {
	public static ArrayList<Player> congelado;

	static {
		Congelar.congelado = new ArrayList<Player>();
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("congelar")) {
			if (p.hasPermission("flame.staff")) {
				if (args.length == 0) {
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§cSintaxe correta: /congelar (nome)");
				} else {
					final Player t = Bukkit.getPlayer(args[0]);
					if (t == null) {
						p.sendMessage(API.jogadoroff);
						return true;
					}
					if (!Congelar.congelado.contains(t)) {
						Congelar.congelado.add(t);
						t.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea foi congelado por: §c"
								+ p.getDisplayName());
						t.sendMessage(String.valueOf(String.valueOf(API.preffix))
								+ "§7Espera ele le descongelar ou espere 1 hora");
						p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea congelou: §c"
								+ t.getDisplayName());
					} else {
						Congelar.congelado.remove(t);
						t.sendMessage(String.valueOf(String.valueOf(API.preffix))
								+ "§7Voc\u00ea foi descongelado por: §a" + p.getDisplayName());
						p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea descongelou: §a"
								+ t.getDisplayName());
					}
					if (Congelar.congelado.contains(t)) {
						Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
							@Override
							public void run() {
								Congelar.congelado.remove(t);
								t.sendMessage(String.valueOf(String.valueOf(API.preffix))
										+ "§7Voc\u00ea foi descongelado depois de uma hora");
							}
						}, 72000L);
					}
				}
			} else {
				p.sendMessage(API.semperm);
			}
		}
		return false;
	}

	@EventHandler
	public void aoSair(final PlayerQuitEvent e) {
		final Player p = e.getPlayer();
		if (Congelar.congelado.contains(p)) {
			Congelar.congelado.remove(p);
		}
	}

	@EventHandler
	public void aoComando(final PlayerCommandPreprocessEvent e) {
		final Player p = e.getPlayer();
		if (Congelar.congelado.contains(p) && e.getMessage().startsWith("/")) {
			e.setCancelled(true);
			p.sendMessage(String.valueOf(String.valueOf(API.preffix))
					+ "§cVoc\u00ea n\u00e3o pode digitar comando quando estiver congelado");
		}
	}

	@EventHandler
	public void aoAndar(final PlayerMoveEvent e) {
		final Player p = e.getPlayer();
		if (Congelar.congelado.contains(p)) {
			e.setTo(p.getLocation());
			p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§cVoc\u00ea est\u00e1 congelado");
		}
	}
}
