package net.iz44kpvp.kitpvp.Comandos;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import net.iz44kpvp.kitpvp.Sistemas.API;

public final class Build implements Listener, CommandExecutor {
	public static ArrayList<Player> embuild;

	static {
		Build.embuild = new ArrayList<Player>();
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("build")) {
			if (p.hasPermission("flame.build")) {
				if (args.length == 0) {
					if (!Build.embuild.contains(p)) {
						Build.embuild.add(p);
						p.sendMessage(
								String.valueOf(String.valueOf(API.preffix)) + "§aVoc\u00ea ativou seu modo build");
					} else {
						Build.embuild.remove(p);
						p.sendMessage(
								String.valueOf(String.valueOf(API.preffix)) + "§cVoc\u00ea desativou seu modo build");
					}
				} else {
					final Player t = Bukkit.getPlayer(args[0]);
					if (t == null) {
						p.sendMessage(API.jogadoroff);
						return true;
					}
					if (!Build.embuild.contains(t)) {
						Build.embuild.add(t);
						p.sendMessage(String.valueOf(String.valueOf(API.preffix))
								+ "§aVoc\u00ea ativou o modo build de: §7" + t.getName());
					} else {
						Build.embuild.remove(t);
						p.sendMessage(String.valueOf(String.valueOf(API.preffix))
								+ "§cVoc\u00ea desativou o modo build de: §7" + t.getName());
					}
				}
			} else {
				p.sendMessage(API.semperm);
			}
		}
		return false;
	}

	@EventHandler
	public void aoconstruir(final BlockPlaceEvent e) {
		final Player p = e.getPlayer();
		if (!Build.embuild.contains(p)) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void aoconstruir(final BlockBreakEvent e) {
		final Player p = e.getPlayer();
		if (!Build.embuild.contains(p)) {
			e.setCancelled(true);
		}
	}
}
