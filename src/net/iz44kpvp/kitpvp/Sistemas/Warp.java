package net.iz44kpvp.kitpvp.Sistemas;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;

public class Warp {
	public static Map<String, String> powerMap2;

	static {
		Warp.powerMap2 = new HashMap<String, String>();
	}

	public static String NomeDoWarp(final String original) {
		if (original.length() == 0) {
			return original;
		}
		return String.valueOf(String.valueOf(original.substring(0, 1).toUpperCase())) + original.substring(1);
	}

	public static String getWarp(final Player player) {
		if (!Warp.powerMap2.containsKey(player.getName())) {
			Warp.powerMap2.put(player.getName(), "Nenhuma");
		}
		return Warp.powerMap2.get(player.getName());
	}

	public static void setWarp(final Player player, final String warp) {
		Warp.powerMap2.put(player.getName(), warp);
	}

	public static void removeWarp(final Player p) {
		Warp.powerMap2.remove(p.getName());
	}
}
