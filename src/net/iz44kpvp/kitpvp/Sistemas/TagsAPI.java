package net.iz44kpvp.kitpvp.Sistemas;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import ca.wacos.nametagedit.NametagAPI;
import net.iz44kpvp.kitpvp.Main;

public class TagsAPI {
	public static void setarTag(final Player p, final String tag) {
		new BukkitRunnable() {
			public void run() {
				p.setDisplayName(String.valueOf(String.valueOf(tag)) + p.getName());
				NametagAPI.setPrefix(p.getName(), tag);
			}
		}.runTaskAsynchronously((Plugin) Main.getInstance());
	}
}
