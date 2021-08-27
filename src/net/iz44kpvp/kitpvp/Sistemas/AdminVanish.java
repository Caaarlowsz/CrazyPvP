package net.iz44kpvp.kitpvp.Sistemas;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class AdminVanish implements Listener {
	public static ArrayList<Player> vanished;

	static {
		AdminVanish.vanished = new ArrayList<Player>();
	}

	public static void makeVanished(final Player p) {
		Player[] onlinePlayers;
		for (int length = (onlinePlayers = Bukkit.getServer().getOnlinePlayers()).length, i = 0; i < length; ++i) {
			final Player player = onlinePlayers[i];
			if (!player.getName().equals(p.getName())) {
				player.hidePlayer(p);
			}
		}
		if (!AdminVanish.vanished.contains(p)) {
			AdminVanish.vanished.add(p);
		}
	}

	public static boolean isVanished(final Player p) {
		return AdminVanish.vanished.contains(p);
	}

	public static void updateVanished() {
		Player[] onlinePlayers;
		for (int length = (onlinePlayers = Bukkit.getServer().getOnlinePlayers()).length, i = 0; i < length; ++i) {
			final Player p = onlinePlayers[i];
			if (isVanished(p)) {
				makeVanished(p);
			} else {
				makeVisible(p);
			}
		}
	}

	public static void makeVisible(final Player p) {
		Player[] onlinePlayers;
		for (int length = (onlinePlayers = Bukkit.getServer().getOnlinePlayers()).length, i = 0; i < length; ++i) {
			final Player player = onlinePlayers[i];
			player.showPlayer(p);
		}
		if (AdminVanish.vanished.contains(p)) {
			AdminVanish.vanished.remove(p);
		}
	}
}
