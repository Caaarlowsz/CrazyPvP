package net.iz44kpvp.kitpvp.Comandos;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.iz44kpvp.kitpvp.Sistemas.API;

public class Ver implements CommandExecutor {
	public static ArrayList<Player> emver;

	static {
		Ver.emver = new ArrayList<Player>();
	}

	public static boolean emInvisivel(final Player p) {
		return Ver.emver.contains(p);
	}

	public static void addInvisivel(final Player p) {
		Ver.emver.add(p);
	}

	public static void removerInvisivel(final Player p) {
		Ver.emver.remove(p);
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("vis")) {
			if (p.hasPermission("flame.staff")) {
				if (!emInvisivel(p)) {
					addInvisivel(p);
					p.sendMessage("§aVoc\u00ea ficou invisivel para todos os players");
					p.setGameMode(GameMode.CREATIVE);
					Player[] onlinePlayers;
					for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
						final Player todos = onlinePlayers[i];
						todos.hidePlayer(p);
					}
				} else {
					removerInvisivel(p);
					Player[] onlinePlayers2;
					for (int length2 = (onlinePlayers2 = Bukkit.getOnlinePlayers()).length, j = 0; j < length2; ++j) {
						final Player todos = onlinePlayers2[j];
						todos.showPlayer(p);
					}
					p.setGameMode(GameMode.SURVIVAL);
					p.sendMessage("§cVoc\u00ea ficou visivel para todos os players");
				}
			} else {
				p.sendMessage(API.semperm);
			}
		}
		return false;
	}
}
